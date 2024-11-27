import 'package:flutter/material.dart';
import 'payment_history.dart'; // Import Payment History page
import '../fetch_data_page.dart';
class TutorDashboardPage extends StatelessWidget {
  const TutorDashboardPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Tutor Dashboard'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Welcome message
            const ListTile(
              title: Text('Welcome, Tutor!'),
            ),
            const SizedBox(height: 16),

            // Button to manage availability
            ElevatedButton(
              onPressed: () {
                // Add functionality for managing availability here
                // e.g., Add or edit availability slots for tutoring
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Manage Availability functionality coming soon!')),
                );
              },
              child: const Text('Manage Availability'),
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
            const SizedBox(height: 20),

            // Title for fetched data section
            const Text(
              'Fetched Data from Backend',
              style: TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 16),

            // Integration of FetchDataPage to display fetched data
            Expanded(
              child: FetchDataPage(),
            ),
          ],
        ),
      ),
    );
  }
}
