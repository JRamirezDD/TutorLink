import 'package:flutter/material.dart';
import 'tutor_home_page.dart'; // Import TutorHomePage
import '../fetch_data_page.dart';

class TutorRegistrationPage extends StatefulWidget {
  @override
  _TutorRegistrationPageState createState() => _TutorRegistrationPageState();
}

class _TutorRegistrationPageState extends State<TutorRegistrationPage> {
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _hourlyRateController = TextEditingController();

  final _formKey = GlobalKey<FormState>();
  String _selectedSubject = 'Math'; // Default subject

  final List<String> _subjects = ['Math', 'Science', 'English', 'History'];

  bool _validateRegistration() {
    // Validate that all fields are filled
    return _nameController.text.isNotEmpty &&
        _emailController.text.isNotEmpty &&
        _passwordController.text.isNotEmpty &&
        _selectedSubject.isNotEmpty &&
        _hourlyRateController.text.isNotEmpty;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Register as Tutor'),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              // Name TextField
              TextFormField(
                controller: _nameController,
                decoration: InputDecoration(
                  labelText: 'Name',
                  border: OutlineInputBorder(),
                ),
              ),
              SizedBox(height: 20),

              // Email TextField
              TextFormField(
                controller: _emailController,
                decoration: InputDecoration(
                  labelText: 'Email',
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.emailAddress,
              ),
              SizedBox(height: 20),

              // Password TextField
              TextFormField(
                controller: _passwordController,
                decoration: InputDecoration(
                  labelText: 'Password',
                  border: OutlineInputBorder(),
                ),
                obscureText: true,
              ),
              SizedBox(height: 20),

              // Subject Dropdown
              DropdownButtonFormField<String>(
                value: _selectedSubject,
                onChanged: (newValue) {
                  setState(() {
                    _selectedSubject = newValue!;
                  });
                },
                items: _subjects.map<DropdownMenuItem<String>>((String subject) {
                  return DropdownMenuItem<String>(
                    value: subject,
                    child: Text(subject),
                  );
                }).toList(),
                decoration: InputDecoration(
                  labelText: 'Select Subject',
                  border: OutlineInputBorder(),
                ),
              ),
              SizedBox(height: 20),

              // Hourly Rate TextField
              TextFormField(
                controller: _hourlyRateController,
                decoration: InputDecoration(
                  labelText: 'Hourly Rate',
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.number,
              ),
              SizedBox(height: 20),

              // Register button
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState?.validate() ?? false) {
                    // If the form is valid, navigate to TutorHomePage
                    if (_validateRegistration()) {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => TutorHomePage(
                            tutorName: _nameController.text,
                            subjects: _selectedSubject,
                            hourlyRate: _hourlyRateController.text,
                          ),
                        ),
                      );
                    }
                  }
                },
                child: Text('Register'),
              ),
              SizedBox(height: 20),

              // Adding the FetchDataPage to display fetched data
              Text(
                'Some Data from the Fetch Data Page:',
                style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 10),

              // Wrap FetchDataPage in a Container with height constraint
              Container(
                height: 200.0, // Set a fixed height
                child: FetchDataPage(),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
