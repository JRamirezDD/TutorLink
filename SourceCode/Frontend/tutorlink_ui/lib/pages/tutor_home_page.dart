import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class TutorHomePage extends StatelessWidget {
  final String tutorName;
  final String subjects;
  final String hourlyRate;

  TutorHomePage({required this.tutorName, required this.subjects, required this.hourlyRate});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
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
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            ListTile(
              title: Text('Welcome, $tutorName!'),
              subtitle: Text('Subjects: $subjects\nHourly Rate: \$ $hourlyRate'),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, '/tutorProfile');
              },
              child: Text('View Profile'),
            ),
            SizedBox(height: 10),
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, '/studentList');
              },
              child: Text('View Students'),
            ),
            SizedBox(height: 20),
            
            // Wrapping FetchDataPage inside Expanded to prevent infinite size issues
            Expanded(
              child: FetchDataPage(),
            ),
          ],
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
