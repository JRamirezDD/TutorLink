import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class StudentProfilePage extends StatelessWidget {
  final String studentName;
  final String email;
  final String subjects;

  StudentProfilePage({
    required this.studentName,
    required this.email,
    required this.subjects,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('$studentName\'s Profile'),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start, // Align content to the start for a more structured layout
          children: <Widget>[
            Text(
              'Name: $studentName',
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            Text(
              'Email: $email',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 10),
            Text(
              'Subjects: $subjects',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Changes saved!')),
                );
              },
              child: Text('Save Changes'),
            ),
            SizedBox(height: 20),
            // Add the FetchDataWidget to display fetched data below the profile info
            FetchDataPage(),
          ],
        ),
      ),
    );
  }
}
