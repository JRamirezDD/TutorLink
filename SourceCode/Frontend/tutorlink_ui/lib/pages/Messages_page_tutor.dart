import 'package:flutter/material.dart';
import 'tutor_home_page.dart'; // Update to tutor home page
import 'user_settings_page.dart';
import 'catalog_subjects_page.dart';
import '../fetch_data_page.dart';
import 'chat_page.dart'; // Import the ChatPage

class MessagesPageTutor extends StatelessWidget {
  const MessagesPageTutor({super.key});

  @override
  Widget build(BuildContext context) {
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
            height: 150, // Set a finite height for the FetchDataPage
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
                ListTile(
                  leading: const CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: const Text('Alex Johnson'),
                  subtitle: const Text('Thanks for your help!'),
                  trailing: const Text('Yesterday'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const ChatPage(userName: 'Alex Johnson'),
                      ),
                    );
                  },
                ),
                const Divider(),
                ListTile(
                  leading: const CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: const Text('Emily Davis'),
                  subtitle: const Text('Do you have any availability next week?'),
                  trailing: const Text('Monday'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const ChatPage(userName: 'Emily Davis'),
                      ),
                    );
                  },
                ),
              ],
            ),
          ),
        ],
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.dashboard),
            label: 'Dashboard',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message),
            label: 'Messages',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.task),
            label: 'Tasks',
          ),
        ],
        currentIndex: 1, // Set this dynamically as per requirement
        selectedItemColor: Colors.blueAccent,
        onTap: (int index) {
          // Handle bottom bar navigation here
          switch (index) {
            case 0:
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => TutorHomePage(
                  tutorName: 'Tutor Name',
                  subjects: 'Subjects',
                  hourlyRate: 'Hourly Rate',
                )),
              );
              break;
            case 1:
              // Stay on the current page
              break;
            case 2:
              Navigator.pushNamed(context, '/tasks');
              break;
          }
        },
      ),
    );
  }
} 