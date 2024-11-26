import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class SubscriptionPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Subscription Page'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // Wrapping FetchDataPage with a fixed height container to avoid layout issues
            Container(
              height: 200, // Set an appropriate height for the fetched data container
              child: FetchDataPage(),
            ),
            SizedBox(height: 20),
            Center(
              child: ElevatedButton(
                onPressed: () {
                  // Navigate back to Tutor Home Page
                  Navigator.pop(context);
                },
                child: Text('Go Back to Tutor Home Page'),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
