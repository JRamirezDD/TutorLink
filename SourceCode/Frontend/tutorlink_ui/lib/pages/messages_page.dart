import 'package:flutter/material.dart';
import 'student_home_page.dart' as student_page;
import 'user_settings_page.dart';
import 'catalog_subjects_page.dart';
import '../fetch_data_page.dart';
import 'chat_page.dart'; // Import the ChatPage

class MessagesPage extends StatelessWidget {
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
              MaterialPageRoute(builder: (context) => UserSettingsPage()),
            );
          },
        ),
        title: Text(
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
            child: FetchDataPage(),
          ),
          Expanded(
            child: ListView(
              padding: EdgeInsets.all(16.0),
              children: [
                ListTile(
                  leading: CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: Text('John Doe'),
                  subtitle: Text('Hey! How are you doing?'),
                  trailing: Text('2:30 PM'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => ChatPage(userName: 'John Doe'),
                      ),
                    );
                  },
                ),
                Divider(),
                ListTile(
                  leading: CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: Text('Jane Smith'),
                  subtitle: Text('Can we schedule a session tomorrow?'),
                  trailing: Text('1:45 PM'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => ChatPage(userName: 'Jane Smith'),
                      ),
                    );
                  },
                ),
                Divider(),
                ListTile(
                  leading: CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: Text('Alex Johnson'),
                  subtitle: Text('Thanks for your help!'),
                  trailing: Text('Yesterday'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => ChatPage(userName: 'Alex Johnson'),
                      ),
                    );
                  },
                ),
                Divider(),
                ListTile(
                  leading: CircleAvatar(
                    backgroundImage: NetworkImage('https://via.placeholder.com/150'),
                  ),
                  title: Text('Emily Davis'),
                  subtitle: Text('Do you have any availability next week?'),
                  trailing: Text('Monday'),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => ChatPage(userName: 'Emily Davis'),
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
        currentIndex: 2,
        onTap: (index) {
          if (index == 0) {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => student_page.StudentHomePage(username: 'Student'),
              ),
            );
          } else if (index == 1) {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => CatalogSubjectsPage()),
            );
          }
        },
        items: [
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
        ],
      ),
    );
  }
}
