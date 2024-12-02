import 'package:flutter/material.dart';
import 'student_home_page.dart'; // Access savedTutors list
import 'tutor_home_page_student.dart'; // Adjust the path if needed

class SavedTutorPage extends StatelessWidget {
  const SavedTutorPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () {
            Navigator.of(context).pop();
          },
        ),
        title: const Text(
          'Saved Tutors',
          style: TextStyle(color: Colors.black),
        ),
      ),
      body: savedTutors.isEmpty
          ? const Center(
              child: Text(
                'No tutors saved yet.',
                style: TextStyle(fontSize: 16, color: Colors.grey),
              ),
            )
          : ListView.builder(
              padding: const EdgeInsets.all(16.0),
              itemCount: savedTutors.length,
              itemBuilder: (context, index) {
                final tutor = savedTutors[index];
                return Card(
                  elevation: 4,
                  margin: const EdgeInsets.symmetric(vertical: 8),
                  child: ListTile(
                    leading: CircleAvatar(
                      backgroundImage: NetworkImage(tutor['image']),
                    ),
                    title: Text(tutor['name']),
                    subtitle: Text(tutor['specialty']),
                    trailing: Text(
                      tutor['rate'].toString(), // Convert to string if necessary
                      style: const TextStyle(fontWeight: FontWeight.bold),
                    ),
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) =>
                              TutorHomePageStudent(tutor: tutor),
                        ),
                      );
                    },
                  ),
                );
              },
            ),
    );
  }
}
