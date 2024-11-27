import 'package:flutter/material.dart';

class TutorHomePageStudent extends StatelessWidget {
  final Map<String, dynamic> tutor;

  const TutorHomePageStudent({super.key, required this.tutor});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.grey[800]),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
        title: Text(
          tutor['name'],
          style: const TextStyle(
            color: Colors.black,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Center(
              child: CircleAvatar(
                radius: 50,
                backgroundImage: NetworkImage(tutor['image']),
              ),
            ),
            const SizedBox(height: 16),
            Center(
              child: Text(
                tutor['name'],
                style: const TextStyle(
                  fontSize: 22,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
            Center(
              child: Text(
                tutor['specialty'],
                style: const TextStyle(
                  fontSize: 18,
                  color: Colors.grey,
                ),
              ),
            ),
            const SizedBox(height: 16),
            const Text(
              'Hourly Rate:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            Text(
              tutor['rate'],
              style: const TextStyle(fontSize: 16),
            ),
            const SizedBox(height: 16),
            const Text(
              'Job Success:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            Text(
              tutor['success'],
              style: const TextStyle(fontSize: 16),
            ),
            const SizedBox(height: 16),
            const Text(
              'About the Tutor:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const Text(
              'This is a placeholder for the tutor\'s bio or description. You can fetch and display more details about the tutor from the backend here.',
              style: TextStyle(fontSize: 16),
            ),
            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: () {
                // Handle booking logic here
              },
              child: const Text('Book a Session'),
            ),
          ],
        ),
      ),
    );
  }
}
