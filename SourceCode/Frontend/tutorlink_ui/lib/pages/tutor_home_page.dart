import 'package:flutter/material.dart';
import 'edit_profile_page.dart';
import 'messages_page_tutor.dart';
import 'tasks_page.dart';
import 'user_settings_page.dart';
import 'tutor_requests_page.dart'; // Import the TutorRequestsPage

class TutorHomePage extends StatefulWidget {
  final String tutorName;
  final String subjects;
  final String hourlyRate;

  const TutorHomePage({
    super.key,
    required this.tutorName,
    required this.subjects,
    required this.hourlyRate,
  });

  @override
  _TutorHomePageState createState() => _TutorHomePageState();
}

class _TutorHomePageState extends State<TutorHomePage> {
  late String tutorName;
  late String subjects;
  late String hourlyRate;
  late String profilePictureUrl;

  int _currentIndex = 0; // Track the current selected tab

  @override
  void initState() {
    super.initState();
    tutorName = widget.tutorName;
    subjects = widget.subjects;
    hourlyRate = widget.hourlyRate;
    profilePictureUrl = 'https://via.placeholder.com/150'; // Placeholder profile picture URL
  }

  void _editProfile() {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => EditProfilePage(
          tutorName: tutorName,
          subjects: subjects,
          hourlyRate: hourlyRate,
          profilePictureUrl: profilePictureUrl,
          onSave: (String newName, String newSubjects, String newHourlyRate, String newProfilePictureUrl) {
            setState(() {
              tutorName = newName;
              subjects = newSubjects;
              hourlyRate = newHourlyRate;
              profilePictureUrl = newProfilePictureUrl;
            });
          },
        ),
      ),
    );
  }

  void _onTabTapped(int index) {
    setState(() {
      _currentIndex = index;
    });

    // Handle navigation based on the selected tab
    switch (index) {
      case 0:
        break; // Stay on the current page
      case 1:
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => MessagesPageTutor()),
        );
        break;
      case 2:
        Navigator.pushNamed(context, '/tasks');
        break;
      case 3:
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => TutorRequestsPage()),
        );
        break;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blueAccent,
        title: const Text('Tutor Home'),
        actions: [
          IconButton(
            icon: const Icon(Icons.account_circle),
            onPressed: () {
              Navigator.pushNamed(context, '/userSettings');
            },
          ),
        ],
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    CircleAvatar(
                      radius: 50,
                      backgroundImage: NetworkImage(profilePictureUrl),
                    ),
                    const SizedBox(height: 10),
                    Text(
                      tutorName,
                      style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                    ),
                    const SizedBox(height: 10),
                    const Text(
                      '97% Job Success',
                      style: TextStyle(fontSize: 18, color: Colors.green),
                    ),
                    const Text(
                      'Total Jobs Done: 51',
                      style: TextStyle(fontSize: 18),
                    ),
                    const SizedBox(height: 20),
                    const Text(
                      'Tutor Description',
                      style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                    ),
                    const SizedBox(height: 10),
                    Text(
                      'Professional tutor specializing in $subjects. Experienced in delivering high-quality lessons to help students excel.',
                      style: const TextStyle(fontSize: 16),
                    ),
                    const SizedBox(height: 10),
                    Text(
                      'Hourly Rate: €$hourlyRate',
                      style: const TextStyle(fontSize: 18),
                    ),
                    const SizedBox(height: 20),
                    ElevatedButton(
                      onPressed: _editProfile,
                      child: const Text('Edit Profile Information'),
                    ),
                  ],
                ),
                const SizedBox(height: 20),
                const Text(
                  'Recent Work Done',
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 10),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Card(
                      elevation: 4,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                      child: const Padding(
                        padding: EdgeInsets.all(16.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Helped a student prepare for final exams in Mathematics.',
                              style: TextStyle(fontSize: 16),
                            ),
                            SizedBox(height: 5),
                            Text(
                              'Rating: ⭐⭐⭐⭐⭐',
                              style: TextStyle(fontSize: 16, color: Colors.grey),
                            ),
                          ],
                        ),
                      ),
                    ),
                    const SizedBox(height: 10),
                    Card(
                      elevation: 4,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                      child: const Padding(
                        padding: EdgeInsets.all(16.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Provided guidance on a science project for a high school student.',
                              style: TextStyle(fontSize: 16),
                            ),
                            SizedBox(height: 5),
                            Text(
                              'Rating: ⭐⭐⭐⭐',
                              style: TextStyle(fontSize: 16, color: Colors.grey),
                            ),
                          ],
                        ),
                      ),
                    ),
                    const SizedBox(height: 10),
                    Card(
                      elevation: 4,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                      child: const Padding(
                        padding: EdgeInsets.all(16.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Tutored a college student in Physics to improve their grades.',
                              style: TextStyle(fontSize: 16),
                            ),
                            SizedBox(height: 5),
                            Text(
                              'Rating: ⭐⭐⭐⭐⭐',
                              style: TextStyle(fontSize: 16, color: Colors.grey),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.dashboard, color: Colors.grey),
            label: 'Dashboard',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message, color: Colors.grey),
            label: 'Messages',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.task, color: Colors.grey),
            label: 'Tasks',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person_add, color: Colors.grey),
            label: 'Requests',
          ),
        ],
        currentIndex: _currentIndex,
        selectedItemColor: Colors.blueAccent, // Blue color when selected
        showSelectedLabels: true, // Ensure label is always visible
        showUnselectedLabels: true, // Ensure label is always visible
        onTap: _onTabTapped,
      ),
    );
  }
}