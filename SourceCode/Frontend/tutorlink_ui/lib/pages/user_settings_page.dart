import 'package:flutter/material.dart';
import 'saved_tutor_page.dart'; // Import the Saved Tutors Page
import 'welcome_page.dart'; // Import the Welcome Page

class UserSettingsPage extends StatelessWidget {
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
          'Settings and Activity',
          style: TextStyle(color: Colors.black),
        ),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              ListTile(
                leading: Icon(Icons.account_circle, color: Colors.black),
                title: Text('Accounts Centre'),
                subtitle: Text('Password, security, personal details, ad preferences'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {},
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: Text(
                  'Account Management',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey[700],
                  ),
                ),
              ),
              ListTile(
                leading: Icon(Icons.bookmark_border),
                title: Text('Saved'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {
                  // Navigate to Saved Tutors Page
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => SavedTutorPage()),
                  );
                },
              ),
              ListTile(
                leading: Icon(Icons.lock),
                title: Text('Password'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {
                  // Navigate to Password Management Page (if needed)
                },
              ),
              ListTile(
                leading: Icon(Icons.access_time),
                title: Text('Time Management'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {},
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: Text(
                  'Privacy Settings',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey[700],
                  ),
                ),
              ),
              ListTile(
                leading: Icon(Icons.lock_outline),
                title: Text('Account Privacy'),
                trailing: Text('Private', style: TextStyle(color: Colors.grey[600])),
                onTap: () {},
              ),
              SizedBox(height: 24),
              Text(
                'Actions',
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey[700],
                ),
              ),
              ListTile(
                leading: Icon(Icons.logout),
                title: Text('Logout'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {
                  // Navigate to Welcome Page
                  Navigator.pushReplacement(
                    context,
                    MaterialPageRoute(builder: (context) => WelcomePage()),
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
