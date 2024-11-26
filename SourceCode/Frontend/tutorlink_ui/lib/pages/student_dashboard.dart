import 'package:flutter/material.dart';
import 'payment_history.dart'; // Import Payment History page
import '../fetch_data_page.dart'; // Corrected import for FetchDataPage

// Define the StudentDashboardPage class
class StudentDashboardPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Student Dashboard'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Welcome message
            ListTile(
              title: Text('Welcome, Student!'),
            ),
            SizedBox(height: 16),

            // Integrate FetchDataWidget to display fetched data
            FetchDataPage(),
            SizedBox(height: 16),

            // Button to find a tutor
            ElevatedButton(
              onPressed: () {
                // Add functionality for finding tutors here
                // e.g., Navigating to a tutor search page or list of tutors
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Find a Tutor functionality coming soon!')),
                );
              },
              child: Text('Find a Tutor'),
            ),
            SizedBox(height: 16),

            // Button to view payment history
            ElevatedButton(
              onPressed: () {
                // Navigate to Payment History Page
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => PaymentHistoryPage()),
                );
              },
              child: Text('View Payment History'),
            ),
          ],
        ),
      ),
    );
  }
}
