import 'package:flutter/material.dart';
import 'chat_page.dart'; // Import the chat page
import 'student_home_page.dart'; // To access the savedTutors list

class TopRatedTutorsPage extends StatelessWidget {
  final String subject;

  // Constructor to accept the subject name
  TopRatedTutorsPage({required this.subject});

  // Sample tutors data dynamically filtered by subject
  final Map<String, List<Map<String, dynamic>>> subjectTutors = {
    'Mathematics': [
      {
        'name': 'Anna K.',
        'specialty': 'Mathematics Expert',
        'rate': '\$50.00/hr',
        'rating': '4.8',
        'image': 'https://via.placeholder.com/150',
      },
      {
        'name': 'Ethan M.',
        'specialty': 'Advanced Calculus',
        'rate': '\$60.00/hr',
        'rating': '4.7',
        'image': 'https://via.placeholder.com/150',
      },
    ],
    'Physics': [
      {
        'name': 'John D.',
        'specialty': 'Physics Tutor',
        'rate': '\$40.00/hr',
        'rating': '4.7',
        'image': 'https://via.placeholder.com/150',
      },
      {
        'name': 'Sophia L.',
        'specialty': 'Quantum Physics',
        'rate': '\$70.00/hr',
        'rating': '4.9',
        'image': 'https://via.placeholder.com/150',
      },
    ],
    'Chemistry': [
      {
        'name': 'James W.',
        'specialty': 'Organic Chemistry',
        'rate': '\$45.00/hr',
        'rating': '4.6',
        'image': 'https://via.placeholder.com/150',
      },
      {
        'name': 'Emily R.',
        'specialty': 'Inorganic Chemistry',
        'rate': '\$55.00/hr',
        'rating': '4.8',
        'image': 'https://via.placeholder.com/150',
      },
    ],
  };

  @override
  Widget build(BuildContext context) {
    // Get tutors for the selected subject, or show a default list if none exist
    final List<Map<String, dynamic>> tutors = subjectTutors[subject] ?? [];

    return Scaffold(
      appBar: AppBar(
        title: Text('$subject Tutors', style: TextStyle(color: Colors.black)),
        backgroundColor: Colors.white,
        elevation: 0,
        iconTheme: IconThemeData(color: Colors.black),
      ),
      body: tutors.isEmpty
          ? Center(
              child: Text(
                'No tutors found for $subject.',
                style: TextStyle(fontSize: 16, color: Colors.grey),
              ),
            )
          : Padding(
              padding: const EdgeInsets.all(16.0),
              child: ListView.builder(
                itemCount: tutors.length,
                itemBuilder: (context, index) {
                  final tutor = tutors[index];
                  return Card(
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(16),
                    ),
                    elevation: 4,
                    margin: const EdgeInsets.only(bottom: 16),
                    child: ListTile(
                      leading: CircleAvatar(
                        backgroundImage: NetworkImage(tutor['image']),
                        radius: 30,
                      ),
                      title: Text(tutor['name'], style: TextStyle(fontSize: 18)),
                      subtitle: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(tutor['specialty']),
                          Text(
                            tutor['rate'],
                            style: TextStyle(color: Colors.green, fontWeight: FontWeight.bold),
                          ),
                        ],
                      ),
                      trailing: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          IconButton(
                            icon: Icon(Icons.chat, color: Colors.blue),
                            onPressed: () {
                              // Navigate to chat page
                              Navigator.push(
                                context,
                                MaterialPageRoute(
                                  builder: (context) => ChatPage(userName: tutor['name']),
                                ),
                              );
                            },
                          ),
                          IconButton(
                            icon: Icon(
                              savedTutors.contains(tutor) ? Icons.star : Icons.star_border,
                              color: savedTutors.contains(tutor) ? Colors.yellow : Colors.grey,
                            ),
                            onPressed: () {
                              // Add or remove tutor from saved tutors
                              if (savedTutors.contains(tutor)) {
                                savedTutors.remove(tutor);
                                ScaffoldMessenger.of(context).showSnackBar(
                                  SnackBar(
                                    content: Text('${tutor['name']} removed from Saved Tutors.'),
                                  ),
                                );
                              } else {
                                savedTutors.add(tutor);
                                ScaffoldMessenger.of(context).showSnackBar(
                                  SnackBar(
                                    content: Text('${tutor['name']} added to Saved Tutors!'),
                                  ),
                                );
                              }
                            },
                          ),
                        ],
                      ),
                    ),
                  );
                },
              ),
            ),
    );
  }
}
