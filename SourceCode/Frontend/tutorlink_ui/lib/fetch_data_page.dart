// fetch_data_page.dart

import 'package:flutter/material.dart';
import 'package:tutorlink_frontend_http_package/frontend_http_package.dart';
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
    fetchStudentProfile(
        "sample_student_id"); // Replace "sample_student_id" with the actual student ID
  }

  // Updated fetchStudentProfile function
  void fetchStudentProfile(String studentId) async {
    setState(() {
      _isLoading = true;
    });

    try {
      // Fetching profile data using ApiService
      final profileData = await apiService.getStudentProfile(studentId);

      if (!mounted) {
        return; // Ensure the widget is still in the tree before calling setState()
      }

      if (profileData != null) {
        setState(() {
          _data = profileData.toString();
          _isLoading = false;
        });
      } else {
        setState(() {
          _errorMessage = 'Failed to fetch profile data.';
          _isLoading = false;
        });
      }
    } catch (e) {
      if (!mounted) {
        return; // Ensure the widget is still in the tree before calling setState()
      }

      setState(() {
        _errorMessage = 'Error: $e';
        _isLoading = false;
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
          : _errorMessage.isNotEmpty
              ? Center(
                  child: Text(
                    _errorMessage,
                    style: const TextStyle(color: Colors.red, fontSize: 16),
                  ),
                )
              : Center(
                  child: Text(
                    _data.isNotEmpty ? _data : 'No profile data available',
                    textAlign: TextAlign.center,
                  ),
                ),
    );
  }
}
