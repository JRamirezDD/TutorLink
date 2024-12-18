import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class SearchPage extends StatefulWidget {
  const SearchPage({super.key});

  @override
  _SearchPageState createState() => _SearchPageState();
}

class _SearchPageState extends State<SearchPage> {
  String? _selectedSubject;
  double _selectedRating = 0;
  double _selectedHourlyRate = 0;
  String? _selectedLocation;

  final List<String> subjects = ['Math', 'Science', 'English', 'History'];
  final List<String> locations = ['New York', 'Los Angeles', 'Chicago', 'Miami'];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Search for Tutors'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // FetchDataPage wrapped in a Container with fixed height
              const SizedBox(
                height: 200, // Provide a fixed height for the FetchDataPage widget
                child: FetchDataPage(),
              ),
              const SizedBox(height: 16),
              const Text('Select Subject:'),
              DropdownButton<String>(
                hint: const Text('Select Subject'),
                value: _selectedSubject,
                onChanged: (newValue) {
                  setState(() {
                    _selectedSubject = newValue;
                  });
                },
                items: subjects.map((subject) {
                  return DropdownMenuItem<String>(
                    value: subject,
                    child: Text(subject),
                  );
                }).toList(),
              ),
              const SizedBox(height: 16),
              const Text('Select Rating:'),
              Slider(
                value: _selectedRating,
                min: 0,
                max: 5,
                divisions: 5,
                label: _selectedRating.toString(),
                onChanged: (value) {
                  setState(() {
                    _selectedRating = value;
                  });
                },
              ),
              const SizedBox(height: 16),
              const Text('Select Hourly Rate:'),
              Slider(
                value: _selectedHourlyRate,
                min: 0,
                max: 100,
                divisions: 20,
                label: _selectedHourlyRate.toString(),
                onChanged: (value) {
                  setState(() {
                    _selectedHourlyRate = value;
                  });
                },
              ),
              const SizedBox(height: 16),
              const Text('Select Location:'),
              DropdownButton<String>(
                hint: const Text('Select Location'),
                value: _selectedLocation,
                onChanged: (newValue) {
                  setState(() {
                    _selectedLocation = newValue;
                  });
                },
                items: locations.map((location) {
                  return DropdownMenuItem<String>(
                    value: location,
                    child: Text(location),
                  );
                }).toList(),
              ),
              const SizedBox(height: 32),
              ElevatedButton(
                onPressed: () {
                  // Handle the search logic here
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('Searching for tutors...')),
                  );
                },
                child: const Text('Search'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
