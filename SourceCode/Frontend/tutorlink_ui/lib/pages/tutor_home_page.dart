import 'package:flutter/material.dart';
import 'edit_profile_page.dart'; // Make sure this path matches the location of EditProfilePage in your project
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
            icon: Icon(Icons.dashboard),
            label: 'Dashboard',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message),
            label: 'Messages',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.task),
            label: 'Tasks',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person_add),
            label: 'Requests',
          ),
        ],
        currentIndex: 0,
        onTap: (int index) {
          switch (index) {
            case 0:
              break;
            case 1:
              Navigator.pushNamed(context, '/messagesPage');
              break;
            case 2:
              Navigator.pushNamed(context, '/tasks');
              break;
            case 3:
              Navigator.pushNamed(context, '/requestsPage');
              break;
          }
        },
      ),
    );
  }
}
