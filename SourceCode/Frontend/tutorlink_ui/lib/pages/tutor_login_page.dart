import 'package:flutter/material.dart';
import 'tutor_home_page.dart';

class TutorLoginPage extends StatefulWidget {
  const TutorLoginPage({super.key});

  @override
  _TutorLoginPageState createState() => _TutorLoginPageState();
}

class _TutorLoginPageState extends State<TutorLoginPage> {
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  void _login() {
    // Assume we retrieve these details from a backend after login verification
    String username = _usernameController.text;
    String password = _passwordController.text;

    // Dummy data for demonstration
    if (username == 'tutor123' && password == 'password123') {
      String tutorName = "John Doe"; // Replace with data from your backend
      String subjects =
          "Mathematics, Science"; // Replace with data from backend
      String hourlyRate = "25"; // Replace with data from backend

      Navigator.push(
        context,
        MaterialPageRoute(
          builder: (context) => TutorHomePage(
            tutorName: tutorName,
            subjects: subjects,
            hourlyRate: hourlyRate,
          ),
        ),
      );
    } else {
      // Show an error if login fails
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Invalid username or password')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Tutor Login'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              TextField(
                controller: _usernameController,
                decoration: const InputDecoration(
                  labelText: 'Username',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 16),
              TextField(
                controller: _passwordController,
                decoration: const InputDecoration(
                  labelText: 'Password',
                  border: OutlineInputBorder(),
                ),
                obscureText: true,
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: _login,
                child: const Text('Login'),
              ),
              const SizedBox(height: 20),

              // Integration of FetchDataPage
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 16.0),
                child: Text(
                  'Additional Information for Tutors:',
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.grey[700],
                  ),
                  textAlign: TextAlign.center,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

void main() => runApp(const MaterialApp(
      home: TutorLoginPage(),
    ));
