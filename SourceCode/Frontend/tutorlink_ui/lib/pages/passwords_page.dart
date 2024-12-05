import 'package:flutter/material.dart';

class PasswordsPage extends StatelessWidget {
  const PasswordsPage({super.key});

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
          'Manage Passwords',
          style: TextStyle(color: Colors.black),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const SizedBox(height: 16),
            const Text(
              'Passwords',
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Colors.black,
              ),
            ),
            const SizedBox(height: 16),
            ElevatedButton.icon(
              onPressed: () {
                // Implement Reset Password Functionality
                showDialog(
                  context: context,
                  builder: (context) {
                    return AlertDialog(
                      title: const Text('Reset Password'),
                      content: const Text('Password reset functionality goes here.'),
                      actions: [
                        TextButton(
                          onPressed: () => Navigator.of(context).pop(),
                          child: const Text('Close'),
                        ),
                      ],
                    );
                  },
                );
              },
              icon: const Icon(Icons.refresh),
              label: const Text('Reset Password'),
              style: ElevatedButton.styleFrom(
                minimumSize: const Size(double.infinity, 50), // Full-width button
              ),
            ),
            const SizedBox(height: 16),
            ElevatedButton.icon(
              onPressed: () {
                // Implement Update Password Functionality
                showDialog(
                  context: context,
                  builder: (context) {
                    return AlertDialog(
                      title: const Text('Update Password'),
                      content: const Text('Password update functionality goes here.'),
                      actions: [
                        TextButton(
                          onPressed: () => Navigator.of(context).pop(),
                          child: const Text('Close'),
                        ),
                      ],
                    );
                  },
                );
              },
              icon: const Icon(Icons.update),
              label: const Text('Update Password'),
              style: ElevatedButton.styleFrom(
                minimumSize: const Size(double.infinity, 50), // Full-width button
              ),
            ),
          ],
        ),
      ),
    );
  }
}
