import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'dart:io';

class EditProfilePage extends StatefulWidget {
  final String tutorName;
  final String subjects;
  final String hourlyRate;
  final String profilePictureUrl;
  final Function(String, String, String, String) onSave;

  const EditProfilePage({
    super.key,
    required this.tutorName,
    required this.subjects,
    required this.hourlyRate,
    required this.profilePictureUrl,
    required this.onSave,
  });

  @override
  _EditProfilePageState createState() => _EditProfilePageState();
}

class _EditProfilePageState extends State<EditProfilePage> {
  late TextEditingController nameController;
  late TextEditingController subjectsController;
  late TextEditingController hourlyRateController;
  File? _profileImage; // For holding the picked image.
  final ImagePicker _picker = ImagePicker();

  @override
  void initState() {
    super.initState();
    nameController = TextEditingController(text: widget.tutorName);
    subjectsController = TextEditingController(text: widget.subjects);
    hourlyRateController = TextEditingController(text: widget.hourlyRate);
  }

  Future<void> _pickImage() async {
    try {
      // Pick an image from the gallery
      final pickedFile = await _picker.pickImage(source: ImageSource.gallery);

      if (pickedFile != null) {
        setState(() {
          // Update the profile image with the newly picked file
          _profileImage = File(pickedFile.path);
          print("Image selected: ${_profileImage!.path}");
        });
      } else {
        print("No image selected.");
      }
    } catch (e) {
      print("Error picking image: $e");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Edit Profile Information'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Center(
                child: Stack(
                  alignment: Alignment.bottomRight,
                  children: [
                    CircleAvatar(
                      radius: 50,
                      backgroundColor: Colors.purple[100],
                      backgroundImage: _profileImage != null
                          ? FileImage(_profileImage!) // If a new image is picked
                          : (widget.profilePictureUrl.isNotEmpty
                              ? NetworkImage(widget.profilePictureUrl)
                              : null), // Use profile picture URL if available
                      child: (_profileImage == null && widget.profilePictureUrl.isEmpty)
                          ? const Icon(
                              Icons.person,
                              size: 50,
                              color: Colors.white,
                            )
                          : null,
                    ),
                    Positioned(
                      bottom: 0,
                      right: 0,
                      child: GestureDetector(
                        onTap: _pickImage,
                        child: CircleAvatar(
                          radius: 16,
                          backgroundColor: Colors.blue,
                          child: const Icon(
                            Icons.add,
                            color: Colors.white,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 20),
              TextField(
                decoration: const InputDecoration(labelText: 'Name'),
                controller: nameController,
              ),
              const SizedBox(height: 10),
              TextField(
                decoration: const InputDecoration(labelText: 'Subjects'),
                controller: subjectsController,
              ),
              const SizedBox(height: 10),
              TextField(
                decoration: const InputDecoration(labelText: 'Hourly Rate (€)'),
                controller: hourlyRateController,
                keyboardType: TextInputType.number,
              ),
              const SizedBox(height: 20),
              Center(
                child: ElevatedButton(
                  onPressed: () {
                    String imagePath = _profileImage != null
                        ? _profileImage!.path
                        : widget.profilePictureUrl;

                    widget.onSave(
                      nameController.text,
                      subjectsController.text,
                      hourlyRateController.text,
                      imagePath,
                    );

                    Navigator.of(context).pop();
                  },
                  child: const Text('Save'),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}