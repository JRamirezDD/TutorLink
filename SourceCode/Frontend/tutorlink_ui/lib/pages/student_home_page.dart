import 'package:flutter/material.dart';
import 'catalog_subjects_page.dart';
import 'messages_page.dart';
import 'user_settings_page.dart';
import 'chat_page.dart'; // Import ChatPage for messaging functionality
import 'tutor_profile_page.dart'; // Import TutorProfilePage for detailed tutor profiles
import 'package:http/http.dart' as http;
import 'dart:convert';

// Shared global list for saved tutors
List<Map<String, dynamic>> savedTutors = [];

class StudentHomePage extends StatelessWidget {
  final String username;

  // Constructor to accept the username
  StudentHomePage({super.key, required this.username});

  final List<Map<String, dynamic>> tutors = [
    {
      'name': 'Marius T.',
      'specialty': 'SEO Strategy / Content / Tech',
      'rate': '\$70.00/hr',
      'success': '100% Job Success',
      'image': 'https://via.placeholder.com/150'
    },
    {
      'name': 'Anna K.',
      'specialty': 'Mathematics Expert',
      'rate': '\$50.00/hr',
      'success': '95% Job Success',
      'image': 'https://via.placeholder.com/150'
    },
    {
      'name': 'John D.',
      'specialty': 'Physics Tutor',
      'rate': '\$40.00/hr',
      'success': '90% Job Success',
      'image': 'https://via.placeholder.com/150'
    },
    {
      'name': 'Sophia L.',
      'specialty': 'Chemistry Teacher',
      'rate': '\$45.00/hr',
      'success': '98% Job Success',
      'image': 'https://via.placeholder.com/150'
    },
  ];

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
        title: Text('Welcome, $username'),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const SizedBox(height: 16),

              // Wrapping FetchDataWidget with SizedBox to give a finite height.
              const SizedBox(
                height: 100,
                child: FetchDataWidget(),
              ),

              const SizedBox(height: 16),
              TextField(
                decoration: InputDecoration(
                  hintText: 'Search',
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                  prefixIcon: const Icon(Icons.search),
                ),
              ),
              const SizedBox(height: 16),
              DropdownButtonFormField<String>(
                decoration: InputDecoration(
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                ),
                hint: const Text('Discover'),
                onChanged: (String? value) {},
                items: const [
                  DropdownMenuItem(value: 'Option 1', child: Text('Option 1')),
                  DropdownMenuItem(value: 'Option 2', child: Text('Option 2')),
                ],
              ),
              const SizedBox(height: 32),
              const Text(
                'Recently Viewed',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
                ),
              ),
              const SizedBox(height: 16),
              // Horizontal Scrollable List of Tutors
              SizedBox(
                height: 180,
                child: ListView.builder(
                  scrollDirection: Axis.horizontal,
                  itemCount: tutors.length,
                  itemBuilder: (context, index) {
                    final tutor = tutors[index];
                    return GestureDetector(
                      onTap: () {
                        print('Tutor tapped: ${tutor['name']}'); // Debugging statement
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => TutorProfilePage(tutor: tutor),
                          ),
                        );
                      },
                      child: Container(
                        width: 300,
                        margin: const EdgeInsets.only(right: 16),
                        child: Card(
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(16),
                          ),
                          elevation: 4,
                          child: Padding(
                            padding: const EdgeInsets.all(16.0),
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Row(
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
                                          Text(tutor['specialty']),
                                        ],
                                      ),
                                    ),
                                  ],
                                ),
                                const SizedBox(height: 8),
                                Row(
                                  children: [
                                    Text(
                                      tutor['rate'],
                                      style: const TextStyle(fontWeight: FontWeight.bold),
                                    ),
                                    const Spacer(),
                                    Text(
                                      tutor['success'],
                                      style: const TextStyle(color: Colors.grey),
                                    ),
                                  ],
                                ),
                              ],
                            ),
                          ),
                        ),
                      ),
                    );
                  },
                ),
              ),
              const SizedBox(height: 32),
            ],
          ),
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        currentIndex: 0, // Correct index for the "Dashboard"
        onTap: (index) {
          if (index == 0) {
            // Stay on the same page
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
        ],
      ),
    );
  }
}

class FetchDataWidget extends StatefulWidget {
  const FetchDataWidget({super.key});

  @override
  _FetchDataWidgetState createState() => _FetchDataWidgetState();
}

class _FetchDataWidgetState extends State<FetchDataWidget> {
  String data = 'Loading...';

  @override
  void initState() {
    super.initState();
    fetchData();
  }

  void fetchData() async {
    try {
      final response = await http.get(Uri.parse('http://localhost:10000/cart'));

      if (response.statusCode == 200) {
        final jsonData = jsonDecode(response.body);
        setState(() {
          data = jsonData.toString(); // Replace this with how you want to display the data
        });
      } else {
        setState(() {
          data = 'Failed to fetch data. Status code: ${response.statusCode}';
        });
      }
    } catch (e) {
      setState(() {
        data = 'Error occurred: $e';
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: Colors.blue[100],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Text(data),
    );
  }
}
