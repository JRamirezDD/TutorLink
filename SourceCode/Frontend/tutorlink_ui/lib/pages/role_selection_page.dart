import 'package:flutter/material.dart';
import 'package:tryflutter/pages/student_dashboard.dart'; // Corrected import for StudentDashboardPage
import 'package:tryflutter/pages/tutor_dashboard.dart';   // Corrected import for TutorDashboardPage
import '../fetch_data_page.dart';  // Corrected import for FetchDataPage

class RoleSelectionPage extends StatelessWidget {
  const RoleSelectionPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Welcome to TutorLink'),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            // Role Selection Section
            const Text(
              'Select Your Role',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const StudentDashboardPage()), // Corrected reference to StudentDashboardPage
                );
              },
              child: const Text('I am a Student'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const TutorDashboardPage()), // Corrected reference to TutorDashboardPage
                );
              },
              child: const Text('I am a Tutor'),
            ),
            const SizedBox(height: 40),
            // Adding FetchDataWidget to display data below the role selection
            
            const FetchDataPage(), // Corrected reference to FetchDataPage
          ],
        ),
      ),
    );
  }
}
