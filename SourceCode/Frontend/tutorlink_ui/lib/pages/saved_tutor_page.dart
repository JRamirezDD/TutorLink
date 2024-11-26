import 'package:flutter/material.dart';
import 'tutor_home_page_student.dart'; // Adjust the path if needed
import 'student_home_page.dart'; // Access savedTutors list

class SavedTutorPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () {
            Navigator.of(context).pop();
          },
        ),
        title: Text(
          'Saved Tutors',
          style: TextStyle(color: Colors.black),
        ),
      ),
      body: savedTutors.isEmpty
          ? Center(
              child: Text(
                'No tutors saved yet.',
                style: TextStyle(fontSize: 16, color: Colors.grey),
              ),
            )
          : ListView.builder(
              padding: EdgeInsets.all(16.0),
              itemCount: savedTutors.length,
              itemBuilder: (context, index) {
                final tutor = savedTutors[index];
                return Card(
                  child: ListTile(
                    leading: CircleAvatar(
                      backgroundImage: NetworkImage(tutor['image']),
                    ),
                    title: Text(tutor['name']),
                    subtitle: Text(tutor['specialty']),
                    trailing: Text(tutor['rate']),
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
