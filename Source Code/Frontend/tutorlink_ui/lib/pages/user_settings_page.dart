import 'package:flutter/material.dart';
import '../fetch_data_page.dart';

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
          'Settings and activity',
          style: TextStyle(color: Colors.black),
        ),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              TextField(
                decoration: InputDecoration(
                  hintText: 'Search',
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                  prefixIcon: Icon(Icons.search),
                ),
              ),
              SizedBox(height: 24),
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
                  'How you use the app',
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
                onTap: () {},
              ),
              ListTile(
                leading: Icon(Icons.archive),
                title: Text('Archive'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {},
              ),
              ListTile(
                leading: Icon(Icons.notifications),
                title: Text('Notifications'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {},
              ),
              ListTile(
                leading: Icon(Icons.access_time),
                title: Text('Time management'),
                trailing: Icon(Icons.arrow_forward_ios),
                onTap: () {},
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: Text(
                  'Who can see your content',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey[700],
                  ),
                ),
              ),
              ListTile(
                leading: Icon(Icons.lock),
                title: Text('Account privacy'),
                trailing: Text('Private', style: TextStyle(color: Colors.grey[600])),
                onTap: () {},
              ),
              ListTile(
                leading: Icon(Icons.star_border),
                title: Text('Close friends'),
                trailing: Text('118', style: TextStyle(color: Colors.grey[600])),
                onTap: () {},
              ),
              SizedBox(height: 24),

              // Integration of FetchDataPage with height constraints
              Text(
                'Data fetched from server:',
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                  color: Colors.grey[700],
                ),
              ),
              SizedBox(height: 16),
              Container(
                height: 150, // Set a finite height for FetchDataPage
                child: FetchDataPage(),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

void main() => runApp(MaterialApp(
      home: UserSettingsPage(),
    ));
