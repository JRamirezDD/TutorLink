import 'package:flutter/material.dart';
import 'catalog_subjects_page.dart';
import 'messages_page.dart';
import 'user_settings_page.dart';
import 'chat_page.dart'; // Import ChatPage for messaging functionality
import 'tutor_profile_page.dart'; // Import TutorProfilePage for detailed tutor profiles

// Shared global list for saved tutors
List<Map<String, dynamic>> savedTutors = [];

class StudentHomePage extends StatefulWidget {
  final String username;

  StudentHomePage({super.key, required this.username});

  @override
  _StudentHomePageState createState() => _StudentHomePageState();
}

class _StudentHomePageState extends State<StudentHomePage> {
  final List<Map<String, dynamic>> tutors = [
    {
      'name': 'Marius T.',
      'specialty': 'SEO Strategy / Content / Tech',
      'rate': 70.0,
      'success': '100% Job Success',
      'verified': true,
      'location': 'New York',
      'rating': 4.9,
      'image': 'https://via.placeholder.com/150'
    },
    {
      'name': 'Anna K.',
      'specialty': 'Mathematics Expert',
      'rate': 50.0,
      'success': '95% Job Success',
      'verified': true,
      'location': 'Los Angeles',
      'rating': 4.8,
      'image': 'https://via.placeholder.com/150'
    },
    {
      'name': 'John D.',
      'specialty': 'Physics Tutor',
      'rate': 40.0,
      'success': '90% Job Success',
      'verified': false,
      'location': 'Chicago',
      'rating': 4.5,
      'image': 'https://via.placeholder.com/150'
    },
    {
      'name': 'Sophia L.',
      'specialty': 'Chemistry Teacher',
      'rate': 45.0,
      'success': '98% Job Success',
      'verified': true,
      'location': 'Houston',
      'rating': 4.7,
      'image': 'https://via.placeholder.com/150'
    },
  ];

  String? selectedSubject;
  double maxRate = 100.0;
  double minRating = 0.0;
  bool showVerified = false;

  List<Map<String, dynamic>> filteredTutors = [];

  @override
  void initState() {
    super.initState();
    filteredTutors = tutors; // Initially display all tutors
  }

  void applyFilters() {
    setState(() {
      filteredTutors = tutors.where((tutor) {
        bool matchesSubject = selectedSubject == null || tutor['specialty'] == selectedSubject;
        bool matchesRate = tutor['rate'] <= maxRate;
        bool matchesRating = tutor['rating'] >= minRating;
        bool matchesVerified = !showVerified || tutor['verified'] == true;

        return matchesSubject && matchesRate && matchesRating && matchesVerified;
      }).toList();
    });
  }

  void _saveTutor(Map<String, dynamic> tutor) {
    setState(() {
      if (!savedTutors.contains(tutor)) {
        savedTutors.add(tutor);
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('${tutor['name']} saved successfully!')),
        );
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('${tutor['name']} is already saved.')),
        );
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.account_circle, color: Colors.grey[800]),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => const UserSettingsPage()),
            );
          },
        ),
        actions: [
          IconButton(
            icon: Icon(Icons.notifications_none, color: Colors.grey[800]),
            onPressed: () {},
          ),
        ],
        title: Text('Welcome, ${widget.username}'),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const SizedBox(height: 16),
              // Search and Filter Section
              TextField(
                decoration: InputDecoration(
                  hintText: 'Search tutors...',
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                  prefixIcon: const Icon(Icons.search),
                ),
                onChanged: (query) {
                  setState(() {
                    filteredTutors = tutors.where((tutor) {
                      return tutor['name'].toLowerCase().contains(query.toLowerCase());
                    }).toList();
                  });
                },
              ),
              const SizedBox(height: 16),
              DropdownButtonFormField<String>(
                decoration: InputDecoration(
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                ),
                hint: const Text('Filter by Subject Expertise'),
                value: selectedSubject,
                onChanged: (String? value) {
                  setState(() {
                    selectedSubject = value;
                    applyFilters();
                  });
                },
                items: tutors
                    .map((tutor) => tutor['specialty'] as String) // Ensure type safety
                    .toSet()
                    .toList()
                    .map((subject) => DropdownMenuItem<String>(
                          value: subject,
                          child: Text(subject),
                        ))
                    .toList(),
              ),
              const SizedBox(height: 16),
              Text('Max Rate: \$${maxRate.toStringAsFixed(0)}'),
              Slider(
                value: maxRate,
                min: 0,
                max: 100,
                divisions: 10,
                label: '\$${maxRate.toStringAsFixed(0)}',
                onChanged: (value) {
                  setState(() {
                    maxRate = value;
                    applyFilters();
                  });
                },
              ),
              Text('Min Rating: ${minRating.toStringAsFixed(1)}'),
              Slider(
                value: minRating,
                min: 0,
                max: 5,
                divisions: 10,
                label: minRating.toStringAsFixed(1),
                onChanged: (value) {
                  setState(() {
                    minRating = value;
                    applyFilters();
                  });
                },
              ),
              Row(
                children: [
                  Checkbox(
                    value: showVerified,
                    onChanged: (bool? value) {
                      setState(() {
                        showVerified = value!;
                        applyFilters();
                      });
                    },
                  ),
                  const Text('Show Only Verified Profiles'),
                ],
              ),
              const SizedBox(height: 16),

              // Tutor List
              const Text(
                'Tutors',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
                ),
              ),
              const SizedBox(height: 16),
              ListView.builder(
                shrinkWrap: true,
                physics: const NeverScrollableScrollPhysics(),
                itemCount: filteredTutors.length,
                itemBuilder: (context, index) {
                  final tutor = filteredTutors[index];
                  return Card(
                    elevation: 4,
                    margin: const EdgeInsets.symmetric(vertical: 8),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(16),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(16.0),
                      child: Row(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          CircleAvatar(
                            radius: 30,
                            backgroundImage: NetworkImage(tutor['image']),
                          ),
                          const SizedBox(width: 16),
                          Expanded(
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  tutor['name'],
                                  style: const TextStyle(
                                    fontSize: 18,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                                const SizedBox(height: 4),
                                Text(
                                  tutor['specialty'],
                                  style: const TextStyle(fontSize: 14, color: Colors.grey),
                                ),
                                const SizedBox(height: 8),
                                Row(
                                  children: [
                                    Text(
                                      '\$${tutor['rate']}/hr',
                                      style: const TextStyle(fontWeight: FontWeight.bold),
                                    ),
                                    const SizedBox(width: 8),
                                    Icon(
                                      tutor['verified'] ? Icons.verified : Icons.error,
                                      size: 16,
                                      color: tutor['verified'] ? Colors.green : Colors.red,
                                    ),
                                    const SizedBox(width: 4),
                                    Text(
                                      tutor['verified'] ? 'Verified' : 'Not Verified',
                                      style: const TextStyle(fontSize: 12, color: Colors.grey),
                                    ),
                                  ],
                                ),
                                const SizedBox(height: 8),
                                Text(
                                  tutor['success'],
                                  style: const TextStyle(fontSize: 12, color: Colors.grey),
                                ),
                              ],
                            ),
                          ),
                          Column(
                            children: [
                              IconButton(
                                icon: const Icon(Icons.message, color: Colors.blue),
                                onPressed: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                      builder: (context) => ChatPage(userName: tutor['name']),
                                    ),
                                  );
                                },
                              ),
                              IconButton(
                                icon: Icon(
                                  savedTutors.contains(tutor)
                                      ? Icons.bookmark
                                      : Icons.bookmark_border,
                                  color: savedTutors.contains(tutor) ? Colors.green : Colors.grey,
                                ),
                                onPressed: () => _saveTutor(tutor),
                              ),
                            ],
                          ),
                        ],
                      ),
                    ),
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
