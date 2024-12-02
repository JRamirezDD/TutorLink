import 'package:flutter/material.dart';
import 'saved_tutor_page.dart'; // Import the Saved Tutors Page
import 'welcome_page.dart'; // Import the Welcome Page
import 'subscription_page.dart'; // Import the Subscription Page

class UserSettingsPage extends StatefulWidget {
  const UserSettingsPage({super.key});

  @override
  _UserSettingsPageState createState() => _UserSettingsPageState();
}

class _UserSettingsPageState extends State<UserSettingsPage> {
  bool isHibernateMode = false; // Track the Hibernate Mode state

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () {
            Navigator.of(context).pop();
          },
        ),
        title: const Text(
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
                leading: const Icon(Icons.account_circle, color: Colors.black),
                title: const Text('Accounts Centre'),
                subtitle: const Text('Password, security, personal details, ad preferences'),
                trailing: const Icon(Icons.arrow_forward_ios),
                onTap: () {},
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: Text(
                  'Account Management',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey[700] ?? Colors.grey,
                  ),
                ),
              ),
              ListTile(
                leading: const Icon(Icons.bookmark_border),
                title: const Text('Saved'),
                trailing: const Icon(Icons.arrow_forward_ios),
                onTap: () {
                  // Navigate to Saved Tutors Page
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => const SavedTutorPage()),
                  );
                },
              ),
              ListTile(
                leading: const Icon(Icons.lock),
                title: const Text('Password'),
                trailing: const Icon(Icons.arrow_forward_ios),
                onTap: () {
                  // Navigate to Password Management Page (if needed)
                },
              ),
              ListTile(
                leading: const Icon(Icons.upgrade),
                title: const Text('Subscription Upgrade'),
                trailing: const Icon(Icons.arrow_forward_ios),
                onTap: () {
                  // Navigate to Subscription Page
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => const SubscriptionPage()),
                  );
                },
              ),
              const SizedBox(height: 24),
              Text(
                'Privacy Settings',
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey[700] ?? Colors.grey,
                ),
              ),
              ListTile(
                leading: const Icon(Icons.lock_outline),
                title: const Text('Account Privacy'),
                trailing: Text(
                  'Private',
                  style: TextStyle(color: Colors.grey[600] ?? Colors.grey),
                ),
                onTap: () {},
              ),
              const SizedBox(height: 24),
              Text(
                'Actions',
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey[700] ?? Colors.grey,
                ),
              ),
              ListTile(
                leading: const Icon(Icons.logout),
                title: const Text('Logout'),
                trailing: const Icon(Icons.arrow_forward_ios),
                onTap: () {
                  // Navigate to Welcome Page
                  Navigator.pushReplacement(
                    context,
                    MaterialPageRoute(builder: (context) => const WelcomePage()),
                  );
                },
              ),
              const SizedBox(height: 24),
              Text(
                'Profile Settings',
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey[700] ?? Colors.grey,
                ),
              ),
              ListTile(
                leading: const Icon(Icons.timer_off, color: Colors.red),
                title: const Text('Hibernate Mode'),
                subtitle: Text(
                  isHibernateMode
                      ? 'Your profile is in Hibernate Mode. Messaging is disabled.'
                      : 'Your profile is active. Messaging is enabled.',
                  style: TextStyle(color: isHibernateMode ? Colors.red : Colors.green),
                ),
                trailing: Switch(
                  value: isHibernateMode,
                  onChanged: (value) {
                    setState(() {
                      isHibernateMode = value;
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text(
                            isHibernateMode
                                ? 'Hibernate Mode Enabled. Messaging disabled.'
                                : 'Hibernate Mode Disabled. Messaging enabled.',
                          ),
                        ),
                      );
                    });
                  },
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
