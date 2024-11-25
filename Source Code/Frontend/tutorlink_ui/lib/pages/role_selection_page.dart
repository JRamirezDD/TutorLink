import 'package:flutter/material.dart';
import 'package:tryflutter/pages/student_dashboard.dart'; // Corrected import for StudentDashboardPage
import 'package:tryflutter/pages/tutor_dashboard.dart';   // Corrected import for TutorDashboardPage
import '../fetch_data_page.dart';  // Corrected import for FetchDataPage

class RoleSelectionPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Welcome to TutorLink'),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            // Role Selection Section
            Text(
              'Select Your Role',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => StudentDashboardPage()), // Corrected reference to StudentDashboardPage
                );
              },
              child: Text('I am a Student'),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => TutorDashboardPage()), // Corrected reference to TutorDashboardPage
                );
              },
              child: Text('I am a Tutor'),
            ),
            SizedBox(height: 40),
            // Adding FetchDataWidget to display data below the role selection
            Text(
              'Here is some information fetched for you:',
              style: TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
                color: Colors.grey[700],
              ),
              textAlign: TextAlign.center,
            ),
            SizedBox(height: 20),
            FetchDataPage(), // Corrected reference to FetchDataPage
          ],
        ),
      ),
    );
  }
}
