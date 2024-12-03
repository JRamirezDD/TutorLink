import 'package:flutter/material.dart';

class ChatPageTutor extends StatelessWidget {
  final String studentName;

  const ChatPageTutor({super.key, required this.studentName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Chat with $studentName'),
        backgroundColor: Colors.blueAccent,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // This can be replaced with actual chat functionality
            Expanded(
              child: ListView(
                children: [
                  ListTile(
                    title: Text('Message 1'),
                    subtitle: Text('This is a sample message'),
                  ),
                  ListTile(
                    title: Text('Message 2'),
                    subtitle: Text('Another sample message'),
                  ),
                ],
              ),
            ),
            TextField(
              decoration: InputDecoration(
                labelText: 'Type a message',
                suffixIcon: Icon(Icons.send),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
