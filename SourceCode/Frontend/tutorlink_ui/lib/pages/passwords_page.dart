import 'package:flutter/material.dart';

class PasswordsPage extends StatelessWidget {
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
          'Manage Passwords',
          style: TextStyle(color: Colors.black),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            SizedBox(height: 16),
            Text(
              'Passwords',
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Colors.black,
              ),
            ),
            SizedBox(height: 16),
            ElevatedButton.icon(
              onPressed: () {
                // Implement Reset Password Functionality
                showDialog(
                  context: context,
                  builder: (context) {
                    return AlertDialog(
                      title: Text('Reset Password'),
                      content: Text('Password reset functionality goes here.'),
                      actions: [
                        TextButton(
                          onPressed: () => Navigator.of(context).pop(),
                          child: Text('Close'),
                        ),
                      ],
                    );
                  },
                );
              },
              icon: Icon(Icons.refresh),
              label: Text('Reset Password'),
              style: ElevatedButton.styleFrom(
                minimumSize: Size(double.infinity, 50), // Full-width button
              ),
            ),
            SizedBox(height: 16),
            ElevatedButton.icon(
              onPressed: () {
                // Implement Update Password Functionality
                showDialog(
                  context: context,
                  builder: (context) {
                    return AlertDialog(
                      title: Text('Update Password'),
                      content: Text('Password update functionality goes here.'),
                      actions: [
                        TextButton(
                          onPressed: () => Navigator.of(context).pop(),
                          child: Text('Close'),
                        ),
                      ],
                    );
                  },
                );
              },
              icon: Icon(Icons.update),
              label: Text('Update Password'),
              style: ElevatedButton.styleFrom(
                minimumSize: Size(double.infinity, 50), // Full-width button
              ),
            ),
          ],
        ),
      ),
    );
  }
}
