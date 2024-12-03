import 'package:flutter/material.dart';
import 'chat_page_tutor.dart'; // Import your ChatPageTutor widget
import 'tutor_home_page.dart'; // Import TutorHomePage
import 'tasks_page.dart'; // Import TasksPage

class TutorRequestsPage extends StatefulWidget {
  const TutorRequestsPage({Key? key}) : super(key: key);

  @override
  _TutorRequestsPageState createState() => _TutorRequestsPageState();
}

class _TutorRequestsPageState extends State<TutorRequestsPage> {
  final List<Map<String, String>> studentRequests = [
    {
      'studentName': 'John Doe',
      'message': 'I need help with math homework. Can you assist?',
    },
    {
      'studentName': 'Jane Smith',
      'message': 'I would like to schedule a session for science lessons.',
    },
  ];

  void _openChat(int index) {
    String? studentName = studentRequests[index]['studentName'];
    if (studentName != null) {
      Navigator.push(
        context,
        MaterialPageRoute(
          builder: (context) => ChatPageTutor(studentName: studentName),
        ),
      );
    } else {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Student name is missing.')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Student Requests'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: studentRequests.isEmpty
            ? const Center(
                child: Text('No new requests at the moment.'),
              )
            : ListView.builder(
                itemCount: studentRequests.length,
                itemBuilder: (context, index) {
                  final request = studentRequests[index];
                  return Card(
                    elevation: 4,
                    margin: const EdgeInsets.symmetric(vertical: 10),
                    child: Padding(
                      padding: const EdgeInsets.all(16.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            request['studentName']!,
                            style: const TextStyle(
                                fontSize: 18, fontWeight: FontWeight.bold),
                          ),
                          const SizedBox(height: 8),
                          Text(request['message']!),
                          const SizedBox(height: 16),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              ElevatedButton(
                                onPressed: () => _openChat(index),
                                style: ElevatedButton.styleFrom(
                                  backgroundColor: Colors.blue,
                                ),
                                child: const Text('Message'),
                              ),
                            ],
                          ),
                        ],
                      ),
                    ),
                  );
                },
              ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.dashboard, color: Colors.grey),
            label: 'Dashboard',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message, color: Colors.grey),
            label: 'Messages',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.task, color: Colors.grey),
            label: 'Tasks',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person_add, color: Colors.grey),
            label: 'Requests',
          ),
        ],
        currentIndex: 3,
        selectedItemColor: Colors.blueAccent,
        onTap: (int index) {
          switch (index) {
            case 0:
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => TutorHomePage(
                    tutorName: 'John Doe',
                    subjects: 'Math, Science',
                    hourlyRate: '€30',
                  ),
                ),
              );
              break;
            case 1:
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => ChatPageTutor(
                    studentName: 'Default Student', // Use a default value here
                  ),
                ),
              );
              break;
            case 2:
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => TasksPage()),
              );
              break;
            case 3:
              break; // Stay on the Requests page
          }
        },
      ),
    );
  }
}
