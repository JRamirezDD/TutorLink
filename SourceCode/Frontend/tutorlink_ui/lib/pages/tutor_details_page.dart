import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class TutorDetailsPage extends StatelessWidget {
  const TutorDetailsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Tutor Details'),
      ),
      body: const Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            Text(
              'Welcome, Tutor!',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),
            Text(
              'Subjects: Math, Science, English',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 10),
            Text(
              'Hourly Rate: \$30',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 20),

            // Replace Expanded with a Container with a fixed height
            SizedBox(
              height: 200, // Set a finite height for FetchDataPage
              child: FetchDataPage(),
            ),
          ],
        ),
      ),
    );
  }
}
