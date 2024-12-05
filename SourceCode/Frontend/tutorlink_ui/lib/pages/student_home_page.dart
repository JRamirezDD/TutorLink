import 'package:flutter/material.dart';
import 'catalog_subjects_page.dart';
import 'messages_page.dart';
import 'user_settings_page.dart';
import 'chat_page.dart'; // Import ChatPage for messaging functionality
import 'tutor_profile_page.dart'; // Import TutorProfilePage for detailed tutor profiles
import 'subscription_page.dart'; // Import SubscriptionPage for subscribing to Gold membership
import 'your_tutors_page.dart';

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
      'image': 'https://via.placeholder.com/150',
      'isConnected': false,
    },
    {
      'name': 'Luana W.',
      'specialty': 'Aerospace engineering',
      'rate': 50.0,
      'success': '95% Job Success',
      'verified': true,
      'location': 'ibiza',
      'rating': 5.0,
      'image': 'https://via.placeholder.com/150',
      'isConnected': false,
    },
    {
      'name': 'John D.',
      'specialty': 'Physics Tutor',
      'rate': 40.0,
      'success': '90% Job Success',
      'verified': false,
      'location': 'Chicago',
      'rating': 4.5,
      'image': 'https://via.placeholder.com/150',
      'isConnected': true,
    },
    {
      'name': 'Sophia L.',
      'specialty': 'Chemistry Teacher',
      'rate': 45.0,
      'success': '98% Job Success',
      'verified': true,
      'location': 'Houston',
      'rating': 4.7,
      'image': 'https://via.placeholder.com/150',
      'isConnected': false,
    },
  ];

  bool isGoldSubscriber = false;

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

  void _showSubscriptionDialog() {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Gold Membership Required'),
        content: const Text(
            'To message tutors, connect with them, or view their profiles, you need to subscribe to the Gold membership.'),
        actions: [
          TextButton(
            onPressed: () {
              Navigator.pop(context); // Close the dialog
            },
            child: const Text('Cancel'),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(context); // Close the dialog
              _navigateToSubscriptionPage();
            },
            child: const Text('Subscribe Now'),
          ),
        ],
      ),
    );
  }

  void _navigateToSubscriptionPage() async {
    final subscribed = await Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => const SubscriptionPage()),
    );
    if (subscribed == true) {
      setState(() {
        isGoldSubscriber = true; // Update subscription status
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blueAccent,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.account_circle, color: Colors.black),
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
                    .map((tutor) => tutor['specialty'] as String)
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
                  return GestureDetector(
                    onTap: () {
                      if (isGoldSubscriber) {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => TutorProfilePage(tutor: tutor),
                          ),
                        );
                      } else {
                        _showSubscriptionDialog();
                      }
                    },
                    child: Card(
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
                                ],
                              ),
                            ),
                            Column(
                              children: [
                                IconButton(
                                  icon: const Icon(Icons.message, color: Colors.blue),
                                  onPressed: () {
                                    if (isGoldSubscriber) {
                                      Navigator.push(
                                        context,
                                        MaterialPageRoute(
                                          builder: (context) => ChatPage(userName: tutor['name']),
                                        ),
                                      );
                                    } else {
                                      _showSubscriptionDialog();
                                    }
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
                    ),
                  );
                },
              ),
            ],
          ),
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
  type: BottomNavigationBarType.fixed,
  currentIndex: 0,
  onTap: (index) {
    if (index == 0) {
      // Stay on the Dashboard
    } else if (index == 1) {
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => const CatalogSubjectsPage()),
      );
    } else if (index == 2) {
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => const MessagesPage()),
      );
    } else if (index == 3) {
      Navigator.push(
       context,
       MaterialPageRoute(builder: (context) => YourTutorsPage()), // My Tutors Page

);

    }
  },
  items: const [
    BottomNavigationBarItem(
      icon: Icon(Icons.dashboard),
      label: 'Dashboard',
    ),
    BottomNavigationBarItem(
      icon: Icon(Icons.list),
      label: 'Catalog',
    ),
    BottomNavigationBarItem(
      icon: Icon(Icons.message),
      label: 'Messages',
    ),
    BottomNavigationBarItem(
      icon: Icon(Icons.people),
      label: 'My Tutors',
    ),
  ],
),

    );
  }
}

