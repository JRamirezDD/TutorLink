import 'package:flutter/material.dart';
import 'tutor_home_page.dart'; // Import TutorHomePage
import '../fetch_data_page.dart';

class TutorRegistrationPage extends StatefulWidget {
  const TutorRegistrationPage({super.key});

  @override
  _TutorRegistrationPageState createState() => _TutorRegistrationPageState();
}

class _TutorRegistrationPageState extends State<TutorRegistrationPage> {
  final TextEditingController _firstNameController = TextEditingController();
  final TextEditingController _lastNameController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _repeatPasswordController = TextEditingController();
  final TextEditingController _dobController = TextEditingController();
  final TextEditingController _phoneNumberController = TextEditingController();
  final TextEditingController _addressController = TextEditingController();
  final TextEditingController _briefDescriptionController = TextEditingController();
  final TextEditingController _hourlyRateController = TextEditingController();

  final _formKey = GlobalKey<FormState>();

  String? _selectedSubject; // Selected subject
  final List<String> _predefinedSubjects = [
    'Computer Programming',
    'Calculus',
    'Database Management',
    'Physics',
    'Chemistry',
    'Biology',
    'Java',
    'Python'
  ];

  final List<Map<String, String>> _addedSubjects = []; // Added subjects with hourly rates

  bool _validateRegistration() {
    return _firstNameController.text.isNotEmpty &&
        _lastNameController.text.isNotEmpty &&
        _emailController.text.isNotEmpty &&
        _usernameController.text.isNotEmpty &&
        _passwordController.text.isNotEmpty &&
        _repeatPasswordController.text == _passwordController.text &&
        _dobController.text.isNotEmpty &&
        _briefDescriptionController.text.isNotEmpty &&
        _addedSubjects.isNotEmpty;
  }

  void _addSubject() {
    if (_selectedSubject == null || _hourlyRateController.text.isEmpty) {
      _showAlert('Error', 'Please select a subject and enter its hourly rate.');
      return;
    }

    // Add subject and hourly rate to the list
    setState(() {
      _addedSubjects.add({
        'subject': _selectedSubject!,
        'hourlyRate': _hourlyRateController.text,
      });
      _selectedSubject = null; // Reset selection
      _hourlyRateController.clear(); // Clear hourly rate field
    });
  }

  void _showAlert(String title, String message) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text(title),
        content: Text(message),
        actions: [
          TextButton(
            child: const Text('OK'),
            onPressed: () => Navigator.pop(context),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Register as Tutor'),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              // Personal Information
              TextFormField(
                controller: _firstNameController,
                decoration: const InputDecoration(
                  labelText: 'First Name *',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _lastNameController,
                decoration: const InputDecoration(
                  labelText: 'Last Name *',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _emailController,
                decoration: const InputDecoration(
                  labelText: 'Email *',
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.emailAddress,
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _usernameController,
                decoration: const InputDecoration(
                  labelText: 'Username *',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _passwordController,
                decoration: const InputDecoration(
                  labelText: 'Password *',
                  border: OutlineInputBorder(),
                ),
                obscureText: true,
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _repeatPasswordController,
                decoration: const InputDecoration(
                  labelText: 'Repeat Password *',
                  border: OutlineInputBorder(),
                ),
                obscureText: true,
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _dobController,
                decoration: const InputDecoration(
                  labelText: 'Date of Birth *',
                  border: OutlineInputBorder(),
                ),
                onTap: () async {
                  DateTime? pickedDate = await showDatePicker(
                    context: context,
                    initialDate: DateTime.now(),
                    firstDate: DateTime(1900),
                    lastDate: DateTime.now(),
                  );
                  if (pickedDate != null) {
                    _dobController.text =
                        '${pickedDate.year}-${pickedDate.month}-${pickedDate.day}';
                  }
                },
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _phoneNumberController,
                decoration: const InputDecoration(
                  labelText: 'Phone Number (Optional)',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _addressController,
                decoration: const InputDecoration(
                  labelText: 'Residential Address (Optional)',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 20),

              // Brief Description Section
              TextFormField(
                controller: _briefDescriptionController,
                decoration: const InputDecoration(
                  labelText: 'Brief Description *',
                  border: OutlineInputBorder(),
                ),
                maxLines: 4,
              ),
              const SizedBox(height: 20),

              // Subject and Tutoring Details
              DropdownButtonFormField<String>(
                value: _selectedSubject,
                onChanged: (newValue) {
                  setState(() {
                    _selectedSubject = newValue;
                  });
                },
                items: _predefinedSubjects.map<DropdownMenuItem<String>>((String subject) {
                  return DropdownMenuItem<String>(
                    value: subject,
                    child: Text(subject),
                  );
                }).toList(),
                decoration: const InputDecoration(
                  labelText: 'Select Subject *',
                  border: OutlineInputBorder(),
                ),
              ),
              const SizedBox(height: 10),
              TextFormField(
                controller: _hourlyRateController,
                decoration: const InputDecoration(
                  labelText: 'Hourly Rate (€) *',
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.number,
              ),
              const SizedBox(height: 10),
              ElevatedButton(
                onPressed: _addSubject,
                child: const Text('Add Subject'),
              ),
              const SizedBox(height: 20),

              // Display Added Subjects
              if (_addedSubjects.isNotEmpty)
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text(
                      'Added Subjects:',
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                    const SizedBox(height: 10),
                    ..._addedSubjects.map((subject) {
                      return ListTile(
                        title: Text(subject['subject'] ?? ''),
                        subtitle: Text('Hourly Rate: €${subject['hourlyRate']}'),
                        trailing: IconButton(
                          icon: const Icon(Icons.delete),
                          onPressed: () {
                            setState(() {
                              _addedSubjects.remove(subject);
                            });
                          },
                        ),
                      );
                    }),
                  ],
                ),
              const SizedBox(height: 20),

              // Register Button
              ElevatedButton(
                onPressed: () {
                  if (_validateRegistration()) {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => TutorHomePage(
                          tutorName: '${_firstNameController.text} ${_lastNameController.text}',
                          subjects: _addedSubjects
                              .map((e) => '${e['subject']} (€${e['hourlyRate']}/hr)')
                              .join(', '),
                          hourlyRate: '', // Not used as individual rates are specified
                        ),
                      ),
                    );
                  } else {
                    _showAlert('Error', 'Please fill in all mandatory fields and add at least one subject.');
                  }
                },
                child: const Text('Register'),
              ),
              const SizedBox(height: 20),

              // Fetch Data Section
              const Text(
                'Some Data from the Fetch Data Page:',
                style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 10),
              const SizedBox(
                height: 200.0,
                child: FetchDataPage(),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
