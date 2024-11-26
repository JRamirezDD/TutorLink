import 'dart:io';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';

class TutorProfilePage extends StatefulWidget {
  final String tutorName;
  final String subjects;
  final String hourlyRate;

  TutorProfilePage({
    required this.tutorName,
    required this.subjects,
    required this.hourlyRate,
  });

  @override
  _TutorProfilePageState createState() => _TutorProfilePageState();
}

class _TutorProfilePageState extends State<TutorProfilePage> {
  File? _imageFile; // Store selected image
  final picker = ImagePicker();

  // Pick an image from gallery
  Future<void> _pickImage() async {
    final pickedFile = await picker.pickImage(source: ImageSource.gallery);
    if (pickedFile != null) {
      setState(() {
        _imageFile = File(pickedFile.path);
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    // Use a ternary operator to choose the image source
    final imageProvider = _imageFile == null
        ? AssetImage('assets/images/default_avatar.png') // Use local image
        : FileImage(_imageFile!) as ImageProvider; // Selected image

    return Scaffold(
      appBar: AppBar(
        title: Text('Tutor Profile'),
      ),
      body: SingleChildScrollView( // Make the page scrollable
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            GestureDetector(
              onTap: _pickImage, // Open gallery on tap
              child: CircleAvatar(
                radius: 50,
                backgroundImage: imageProvider,
                child: _imageFile == null
                    ? Icon(Icons.camera_alt, color: Colors.white)
                    : null,
              ),
            ),
            SizedBox(height: 20),
            Text(
              'Name: ${widget.tutorName}',
              style: TextStyle(fontSize: 22),
            ),
            SizedBox(height: 10),
            Text(
              'Subjects: ${widget.subjects}',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 10),
            Text(
              'Hourly Rate: \$${widget.hourlyRate}',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 20),
            // Add additional input field for Tutor Description if needed
            Text(
              'Description: Add your brief description here',
              style: TextStyle(fontSize: 18),
            ),
          ],
        ),
      ),
    );
  }
}

