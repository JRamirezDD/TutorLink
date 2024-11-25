import 'package:flutter/material.dart';
import 'student_home_page.dart'; // Import the StudentHomePage
import '../fetch_data_page.dart';
class StudentLoginPage extends StatefulWidget {
  @override
  _StudentLoginPageState createState() => _StudentLoginPageState();
}

class _StudentLoginPageState extends State<StudentLoginPage> {
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  void _login() {
    String username = _usernameController.text;
    String password = _passwordController.text;

    // Dummy login check for simplicity
    if (username == 'student' && password == 'password') {
      // Navigate to StudentHomePage after successful login
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
          builder: (context) => StudentHomePage(username: username), // Pass the username to the home page
        ),
      );
    } else {
      // Show error if login fails
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Invalid username or password')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Student Login')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              TextField(
                controller: _usernameController,
                decoration: InputDecoration(
                  labelText: 'Username',
                  border: OutlineInputBorder(),
                ),
              ),
              SizedBox(height: 16),
              TextField(
                controller: _passwordController,
                obscureText: true,
                decoration: InputDecoration(
                  labelText: 'Password',
                  border: OutlineInputBorder(),
                ),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: _login,
                child: Text('Login'),
              ),
              SizedBox(height: 20),

              // Include FetchDataPage below the login button to utilize the import and display fetched data
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: Text(
                  'Additional Information:',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey[700],
                  ),
                ),
              ),
              FetchDataPage(), // Display the FetchDataPage widget here
            ],
          ),
        ),
      ),
    );
  }
}

void main() => runApp(MaterialApp(
      home: StudentLoginPage(),
    ));
