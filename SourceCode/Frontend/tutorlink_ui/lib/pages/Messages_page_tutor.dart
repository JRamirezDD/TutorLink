import 'package:flutter/material.dart';
import 'user_settings_page.dart';
import 'catalog_subjects_page.dart';
import '../fetch_data_page.dart';
import 'chat_page.dart';
import 'tutor_requests_page.dart'; // Import the TutorRequestsPage
import 'tutor_home_page.dart'; // Import the TutorHomePage

class MessagesPageTutor extends StatelessWidget {
  const MessagesPageTutor({super.key});

  @override
  Widget build(BuildContext context) {
    // Example dynamic data
    String tutorName = 'John Doe'; // Example dynamic value
    String subjects = 'Math, Science'; // Example dynamic value
    String hourlyRate = '€30'; // Example dynamic value

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.account_circle, color: Colors.grey[800]),
            onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => const UserSettingsPage()),
            );
            },
          ),
        title: const Text(
          'Messages',
          style: TextStyle(
            color: Colors.black,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
      body: Column(
        children: [
          Container(
            height: 150,
            padding: const EdgeInsets.all(8.0),
            child: const FetchDataPage(),
          ),
          Expanded(
            child: ListView(
            padding: const EdgeInsets.all(16.0),
              children: [
                ListTile(
                  leading: const CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
            ),
                  title: const Text('John Doe'),
                  subtitle: const Text('Hey! How are you doing?'),
                  trailing: const Text('2:30 PM'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const ChatPage(userName: 'John Doe'),
                      ),
                    );
                  },
                ),
                const Divider(),
                ListTile(
                  leading: const CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: const Text('Jane Smith'),
                  subtitle: const Text('Can we schedule a session tomorrow?'),
                  trailing: const Text('1:45 PM'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const ChatPage(userName: 'Jane Smith'),
                      ),
                );
              },
            ),
                const Divider(),
              ],
            ),
          ),
        ],
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
        currentIndex: 1,
        selectedItemColor: Colors.blueAccent, // Blue color when selected
        onTap: (int index) {
          switch (index) {
            case 0:
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => TutorHomePage(
                  tutorName: tutorName,
                  subjects: subjects,
                  hourlyRate: hourlyRate,
                )),
              );
              break;
            case 1:
              break;
            case 2:
              Navigator.pushNamed(context, '/tasks');
              break;
            case 3:
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => TutorRequestsPage()),
              );
              break;
          }
        },
      ),
    );
  }
}
