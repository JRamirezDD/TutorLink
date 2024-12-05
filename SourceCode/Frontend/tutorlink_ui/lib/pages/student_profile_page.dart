import 'package:flutter/material.dart';

class StudentProfilePage extends StatelessWidget {
  final String studentName;
  final String email;
  final String subjects;

  const StudentProfilePage({
    super.key,
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
            crossAxisAlignment: CrossAxisAlignment
                .start, // Align content to the start for a more structured layout
            children: <Widget>[
              Text(
                'Name: $studentName',
                style:
                    const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 10),
              Text(
                'Email: $email',
                style: const TextStyle(fontSize: 18),
              ),
              const SizedBox(height: 10),
              Text(
                'Subjects: $subjects',
                style: const TextStyle(fontSize: 18),
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('Changes saved!')),
                  );
                },
                child: const Text('Save Changes'),
              ),
            ]),
      ),
    );
  }
}
