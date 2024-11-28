import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class TutorHomePage extends StatefulWidget {
  final String tutorName;
  final String subjects;
  final String hourlyRate;

  TutorHomePage({required this.tutorName, required this.subjects, required this.hourlyRate});

  @override
  _TutorHomePageState createState() => _TutorHomePageState();
}

class _TutorHomePageState extends State<TutorHomePage> {
  late String tutorName;
  late String subjects;
  late String hourlyRate;

  @override
  void initState() {
    super.initState();
    tutorName = widget.tutorName;
    subjects = widget.subjects;
    hourlyRate = widget.hourlyRate;
  }

  void _editProfile() {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => EditProfilePage(
          tutorName: tutorName,
          subjects: subjects,
          hourlyRate: hourlyRate,
          onSave: (String newName, String newSubjects, String newHourlyRate) {
            setState(() {
              tutorName = newName;
              subjects = newSubjects;
              hourlyRate = newHourlyRate;
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
        backgroundColor: Colors.blueAccent, // Updated color to match brand identity
        title: Text('Tutor Home'),
        actions: [
          IconButton(
            icon: Icon(Icons.account_circle),
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
                // User Profile Section
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    CircleAvatar(
                      radius: 50,
                      backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                    ),
                    SizedBox(height: 10),
                    Text(
                      tutorName,
                      style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                    ),
                    SizedBox(height: 10),
                    Text(
                      '97% Job Success',
                      style: TextStyle(fontSize: 18, color: Colors.green),
                    ),
                    Text(
                      'Total Jobs Done: 51',
                      style: TextStyle(fontSize: 18),
                    ),
                    SizedBox(height: 20),
                    Text(
                      'Tutor Description',
                      style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                    ),
                    SizedBox(height: 10),
                    Text(
                      'Professional tutor specializing in $subjects. Experienced in delivering high-quality lessons to help students excel.',
                      style: TextStyle(fontSize: 16),
                    ),
                    SizedBox(height: 10),
                    Text(
                      'Hourly Rate: €$hourlyRate',
                      style: TextStyle(fontSize: 18),
                    ),
                    SizedBox(height: 20),
                    ElevatedButton(
                      onPressed: _editProfile,
                      child: Text('Edit Profile Information'),
                    ),
                  ],
                ),

                SizedBox(height: 20),
                Text(
                  'Recent Work Done',
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
                SizedBox(height: 10),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Card(
                      elevation: 4,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                      child: Padding(
                        padding: const EdgeInsets.all(16.0),
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
                    SizedBox(height: 10),
                    Card(
                      elevation: 4,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                      child: Padding(
                        padding: const EdgeInsets.all(16.0),
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
                    SizedBox(height: 10),
                    Card(
                      elevation: 4,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                      child: Padding(
                        padding: const EdgeInsets.all(16.0),
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
        ],
        currentIndex: 0, // Set this dynamically as per requirement
        onTap: (int index) {
          // Handle bottom bar navigation here
          switch (index) {
            case 0:
              // Stay on the current page
              break;
            case 1:
              Navigator.pushNamed(context, '/messagesPage');
              break;
            case 2:
              Navigator.pushNamed(context, '/tasks');
              break;
          }
        },
      ),
    );
  }
}

class EditProfilePage extends StatelessWidget {
  final String tutorName;
  final String subjects;
  final String hourlyRate;
  final Function(String, String, String) onSave;

  EditProfilePage({
    required this.tutorName,
    required this.subjects,
    required this.hourlyRate,
    required this.onSave,
  });

  @override
  Widget build(BuildContext context) {
    String newName = tutorName;
    String newSubjects = subjects;
    String newHourlyRate = hourlyRate;

    return Scaffold(
      appBar: AppBar(
        title: Text('Edit Profile Information'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              decoration: InputDecoration(labelText: 'Name'),
              controller: TextEditingController(text: tutorName),
              onChanged: (value) {
                newName = value;
              },
            ),
            DropdownButtonFormField<String>(
              decoration: InputDecoration(labelText: 'Subjects'),
              value: subjects,
              items: <String>['Mathematics', 'Physics', 'Chemistry', 'Biology', 'English']
                  .map((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
              onChanged: (value) {
                newSubjects = value ?? subjects;
              },
            ),
            TextField(
              decoration: InputDecoration(labelText: 'Hourly Rate (€)'),
              controller: TextEditingController(text: hourlyRate),
              onChanged: (value) {
                newHourlyRate = value;
              },
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                onSave(newName, newSubjects, newHourlyRate);
                Navigator.of(context).pop();
              },
              child: Text('Save'),
            ),
          ],
        ),
      ),
    );
  }
}
