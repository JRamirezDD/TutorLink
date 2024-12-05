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
        backgroundColor: Colors.blueAccent,
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
                ListTile(
                  leading: const CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: const Text('Alice Johnson'),
                  subtitle: const Text('Can you help me with my assignment?'),
                  trailing: const Text('12:30 PM'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const ChatPage(userName: 'Alice Johnson'),
                      ),
                    );
                  },
                ),
                const Divider(),
                ListTile(
                  leading: const CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: const Text('Robert Brown'),
                  subtitle: const Text('I need help with a physics problem.'),
                  trailing: const Text('11:00 AM'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const ChatPage(userName: 'Robert Brown'),
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
                  subtitle: const Text('Can we discuss the upcoming chemistry session?'),
                  trailing: const Text('10:15 AM'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const ChatPage(userName: 'Emily Davis'),
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
          BottomNavigationBarItem(
            icon: Icon(Icons.person_add),
            label: 'Requests',
          ),
        ],
        currentIndex: 1,
        selectedItemColor: Colors.blueAccent,
        unselectedItemColor: Colors.black,
        showSelectedLabels: true,
        showUnselectedLabels: true,
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
