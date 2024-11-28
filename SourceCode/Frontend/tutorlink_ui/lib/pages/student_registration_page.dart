import 'package:flutter/material.dart';
import 'student_home_page.dart';
import '../fetch_data_page.dart';
class StudentRegistrationPage extends StatefulWidget {
  const StudentRegistrationPage({super.key});

  @override
  _StudentRegistrationPageState createState() => _StudentRegistrationPageState();
}

class _StudentRegistrationPageState extends State<StudentRegistrationPage> {
  final TextEditingController _firstNameController = TextEditingController();
  final TextEditingController _lastNameController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _repeatPasswordController = TextEditingController();

  void _registerStudent() {
    String firstName = _firstNameController.text;
    String lastName = _lastNameController.text;
    String email = _emailController.text;
    String username = _usernameController.text;
    String password = _passwordController.text;
    String repeatPassword = _repeatPasswordController.text;

    if (firstName.isNotEmpty &&
        lastName.isNotEmpty &&
        email.isNotEmpty &&
        username.isNotEmpty &&
        password.isNotEmpty &&
        repeatPassword.isNotEmpty) {
      if (password == repeatPassword) {
        // If passwords match, proceed to Student Home Page
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(
            builder: (context) => StudentHomePage(
              username: username,
            ),
          ),
        );
      } else {
        // If passwords don't match, show an error
        showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: const Text('Password Mismatch'),
            content: const Text('The passwords you entered do not match.'),
            actions: <Widget>[
              TextButton(
                child: const Text('OK'),
                onPressed: () {
                  Navigator.pop(context);
                },
              ),
            ],
          ),
        );
      }
    } else {
      // Show error if any field is empty
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: const Text('Missing Fields'),
          content: const Text('Please fill in all fields to complete registration.'),
          actions: <Widget>[
            TextButton(
              child: const Text('OK'),
              onPressed: () {
                Navigator.pop(context);
              },
            ),
          ],
        ),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Register as Student'),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            TextField(
              controller: _firstNameController,
              decoration: const InputDecoration(labelText: 'First Name'),
            ),
            TextField(
              controller: _lastNameController,
              decoration: const InputDecoration(labelText: 'Last Name'),
            ),
            TextField(
              controller: _emailController,
              decoration: const InputDecoration(labelText: 'Email'),
            ),
            TextField(
              controller: _usernameController,
              decoration: const InputDecoration(labelText: 'Username'),
            ),
            TextField(
              controller: _passwordController,
              obscureText: true,
              decoration: const InputDecoration(labelText: 'Password'),
            ),
            TextField(
              controller: _repeatPasswordController,
              obscureText: true,
              decoration: const InputDecoration(labelText: 'Repeat Password'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _registerStudent,
              child: const Text('Register'),
            ),
            const SizedBox(height: 20),

            // Adding the FetchDataPage to display fetched data after registration
            const SizedBox(
              height: 200.0, // Set a fixed height to avoid infinite constraints
              child: FetchDataPage(),
            ),
          ],
        ),
      ),
    );
  }
}
