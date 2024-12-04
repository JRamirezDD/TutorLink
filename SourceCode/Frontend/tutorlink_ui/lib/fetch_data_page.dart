// fetch_data_page.dart

import 'package:flutter/material.dart';
import 'package:tutorlink_frontend_http_package/frontend_http_package.dart';
import 'api_service.dart';
import 'config.dart'; 

class FetchDataPage extends StatefulWidget {
  const FetchDataPage({super.key});

  @override
  _FetchDataPageState createState() => _FetchDataPageState();
}

class _FetchDataPageState extends State<FetchDataPage> {
  String _data = "";
  bool _isLoading = true;
  String _errorMessage = "";

  // Use BASE_URL from config.dart
  final ApiClient apiClient = ApiClient(baseUrl: BASE_URL);
  late final ApiService apiService;

  @override
  void initState() {
    super.initState();
    apiService = ApiService(apiClient: apiClient);
    fetchStudentProfile("sample_student_id"); // Replace "sample_student_id" with the actual student ID
  }

  // Updated fetchStudentProfile function
  void fetchStudentProfile(String studentId) async {
  setState(() {
    _isLoading = true;
  });

  try {
    final profileData = await apiService.getStudentProfile(studentId);

    if (!mounted) {
      return;
    }

    if (profileData != null) {
      setState(() {
        _data = profileData.toString();
        _isLoading = false;
      });
    } else {
      setState(() {
        _isLoading = false; // Just stop loading without setting an error message
      });
    }
  } catch (e) {
    if (!mounted) {
      return;
    }

    setState(() {
      _isLoading = false; // Stop loading, do not set any error message
    });
  }
}

@override
Widget build(BuildContext context) {
  return Scaffold(
    appBar: AppBar(
      title: const Text('Fetch Student Profile'),
    ),
    body: _isLoading
        ? const Center(child: CircularProgressIndicator())
        : _data.isNotEmpty
            ? Center(
                child: Text(
                  _data,
                  textAlign: TextAlign.center,
                ),
              )
            : Container(), // Empty container if there's no data and no loading
  );
} // <-- This bracket closes the build method
} // <-- Add this bracket to close the _FetchDataPageState class
