import 'package:flutter/material.dart';
import 'student_login_page.dart';
import 'tutor_login_page.dart';
import 'tutor_registration_page.dart';
import 'student_registration_page.dart';
import '../fetch_data_page.dart';

class WelcomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Welcome to TutorLink'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              // Login as Tutor button
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => TutorLoginPage(),
                    ),
                  );
                },
                child: Text('Login as Tutor'),
              ),
              SizedBox(height: 10),

              // Login as Student button
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => StudentLoginPage()),
                  );
                },
                child: Text('Login as Student'),
              ),
              SizedBox(height: 20),

              // Register as Tutor button
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => TutorRegistrationPage()),
                  );
                },
                child: Text('Register as Tutor'),
              ),
              SizedBox(height: 10),

              // Register as Student button
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => StudentRegistrationPage()),
                  );
                },
                child: Text('Register as Student'),
              ),
              SizedBox(height: 20),

              // Adding FetchDataPage to utilize the import
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: Text(
                  'Here is some fetched data to get you started:',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey[700],
                  ),
                  textAlign: TextAlign.center,
                ),
              ),
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
      home: WelcomePage(),
    ));

