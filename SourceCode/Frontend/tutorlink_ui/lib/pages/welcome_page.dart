import 'package:flutter/material.dart';
import 'student_login_page.dart';
import 'tutor_login_page.dart';
import 'tutor_registration_page.dart';
import 'student_registration_page.dart';
import '../fetch_data_page.dart';

class WelcomePage extends StatelessWidget {
  const WelcomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Welcome to TutorLink'),
        centerTitle: true,
        backgroundColor: Color(0xFF4CA6C6), // Adjusted color to exactly match the image color
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Row(
          children: [
            // Image Section
            Expanded(
              flex: 2,
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Image.asset(
                  'assets/images/background.jpg', // Adjust the path accordingly
                  fit: BoxFit.cover,
                  height: double.infinity,
                ),
              ),
            ),
            // Content Section
            Expanded(
              flex: 3,
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 16.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: <Widget>[
                    const Text(
                      'Welcome to TutorLink',
                      style: TextStyle(
                        fontSize: 28,
                        fontWeight: FontWeight.bold,
                        color: Colors.black87, // Changed for better contrast
                      ),
                      textAlign: TextAlign.left,
                    ),
                    const SizedBox(height: 24),

                    // Login as Tutor button
                    ElevatedButton.icon(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => const TutorLoginPage(),
                          ),
                        );
                      },
                      icon: const Icon(Icons.person),
                      label: const Text('Login as Tutor'),
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 16),
                        backgroundColor: Color(0xFF4CA6C6), // Updated color to match image theme
                      ),
                    ),
                    const SizedBox(height: 10),

                    // Login as Student button
                    ElevatedButton.icon(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => const StudentLoginPage(),
                          ),
                        );
                      },
                      icon: const Icon(Icons.school),
                      label: const Text('Login as Student'),
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 16),
                        backgroundColor: Color(0xFF4CA6C6), // Updated color to match image theme
                      ),
                    ),
                    const SizedBox(height: 20),

                    // Register as Tutor button
                    ElevatedButton.icon(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => const TutorRegistrationPage(),
                          ),
                        );
                      },
                      icon: const Icon(Icons.app_registration),
                      label: const Text('Register as Tutor'),
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 16),
                        backgroundColor: Color(0xFF4CA6C6), // Updated color to match image theme
                      ),
                    ),
                    const SizedBox(height: 10),

                    // Register as Student button
                    ElevatedButton.icon(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => const StudentRegistrationPage(),
                          ),
                        );
                      },
                      icon: const Icon(Icons.person_add),
                      label: const Text('Register as Student'),
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 16),
                        backgroundColor: Color(0xFF4CA6C6), // Updated color to match image theme
                      ),
                    ),
                    const SizedBox(height: 24),

                    
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

void main() => runApp(const MaterialApp(
      home: WelcomePage(),
    ));