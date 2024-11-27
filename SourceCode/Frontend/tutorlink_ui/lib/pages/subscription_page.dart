import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class SubscriptionPage extends StatelessWidget {
  const SubscriptionPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Subscription Page'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // Wrapping FetchDataPage with a fixed height container to avoid layout issues
            SizedBox(
              height: 200, // Set an appropriate height for the fetched data container
              child: FetchDataPage(),
            ),
            const SizedBox(height: 20),
            Center(
              child: ElevatedButton(
                onPressed: () {
                  // Navigate back to Tutor Home Page
                  Navigator.pop(context);
                },
                child: const Text('Go Back to Tutor Home Page'),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
