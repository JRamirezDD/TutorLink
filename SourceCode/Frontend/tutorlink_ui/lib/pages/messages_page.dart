import 'package:flutter/material.dart';
import 'student_home_page.dart' as student_page;
import 'user_settings_page.dart';
import 'catalog_subjects_page.dart';
import '../fetch_data_page.dart';
import 'chat_page.dart'; // Import the ChatPage
import 'your_tutors_page.dart'; // Import the "My Tutors" page

class MessagesPage extends StatelessWidget {
  const MessagesPage({super.key});

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
        type: BottomNavigationBarType.fixed,
        currentIndex: 2, // "Messages" tab index
        onTap: (index) {
          switch (index) {
            case 0:
              // Navigate to Dashboard
              Navigator.pushReplacement(
                context,
                MaterialPageRoute(
                  builder: (context) =>
                      student_page.StudentHomePage(username: 'Student'),
                ),
              );
              break;
            case 1:
              // Navigate to Catalog
              Navigator.pushReplacement(
                context,
                MaterialPageRoute(builder: (context) => const CatalogSubjectsPage()),
              );
              break;
            case 2:
              // Stay on Messages
              break;
            case 3:
              // Navigate to My Tutors
              Navigator.pushReplacement(
                context,
               MaterialPageRoute(builder: (context) => YourTutorsPage()),

              );
              break;
          }
        },
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.dashboard),
            label: 'Dashboard',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.list),
            label: 'Catalog',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message),
            label: 'Messages',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.people),
            label: 'My Tutors',
          ),
        ],
      ),
    );
  }
}