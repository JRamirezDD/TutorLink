import 'package:flutter/material.dart';
import '../fetch_data_page.dart';// Update this path as needed

class MessagesPageTutor extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Messages'),
        actions: [
          IconButton(
            icon: Icon(Icons.account_circle),
            onPressed: () {
              Navigator.pushNamed(context, '/userSettings');
            },
          ),
        ],
      ),
      body: Column(
        children: [
          // Adding FetchDataWidget at the top to fetch data from the backend
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              children: [
                FetchDataPage(),
                SizedBox(height: 16), // Add spacing between widgets
              ],
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: 10, // Replace with the actual number of messages
              itemBuilder: (context, index) {
                return ListTile(
                  leading: Icon(Icons.person),
                  title: Text('Student ${index + 1}'),
                  subtitle: Text('Last message snippet...'),
                  onTap: () {
                    Navigator.pushNamed(context, '/chatDetail', arguments: 'Student ${index + 1}');
                  },
                );
              },
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
        onTap: (int index) {
          // Handle bottom bar navigation here
          switch (index) {
            case 0:
              Navigator.pushNamed(context, '/tutorHome');
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
