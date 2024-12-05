import 'package:flutter/material.dart';
import 'payment_history.dart'; // Import Payment History page
import '../fetch_data_page.dart'; // Corrected import for FetchDataPage

// Define the StudentDashboardPage class
class StudentDashboardPage extends StatelessWidget {
  const StudentDashboardPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Student Dashboard'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Welcome message
            const ListTile(
              title: Text('Welcome, Student!'),
            ),
            const SizedBox(height: 16),

            // Integrate FetchDataWidget to display fetched data
            const FetchDataPage(),
            const SizedBox(height: 16),

            // Button to find a tutor
            ElevatedButton(
              onPressed: () {
                // Add functionality for finding tutors here
                // e.g., Navigating to a tutor search page or list of tutors
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Find a Tutor functionality coming soon!')),
                );
              },
              child: const Text('Find a Tutor'),
            ),
            const SizedBox(height: 16),

            // Button to view payment history
            ElevatedButton(
              onPressed: () {
                // Navigate to Payment History Page
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => PaymentHistoryPage()),
                );
              },
              child: const Text('View Payment History'),
            ),
          ],
        ),
      ),
    );
  }
}
