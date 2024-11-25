// fetch_data_page.dart

import 'package:flutter/material.dart';
import 'api_client.dart';
import 'api_service.dart';
import 'config.dart'; // Import the config file

class FetchDataPage extends StatefulWidget {
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
    fetchStudentProfile(); // Call fetchStudentProfile when the widget is initialized
  }

  // Updated fetchStudentProfile function
  void fetchStudentProfile() async {
    setState(() {
      _isLoading = true;
    });

    try {
      // Fetching profile data using ApiService
      final profileData = await apiService.getStudentProfile();

      if (!mounted) return; // Ensure the widget is still in the tree before calling setState()

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
      if (!mounted) return; // Ensure the widget is still in the tree before calling setState()

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
        title: Text('Fetch Student Profile'),
      ),
      body: _isLoading
          ? Center(child: CircularProgressIndicator())
          : _errorMessage.isNotEmpty
              ? Center(
                  child: Text(
                    _errorMessage,
                    style: TextStyle(color: Colors.red, fontSize: 16),
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