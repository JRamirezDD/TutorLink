// api_service.dart

import 'dart:convert';
import 'package:tutorlink_frontend_http_package/frontend_http_package.dart';

class ApiService {
  final ApiClient apiClient;

  ApiService({required this.apiClient});

  Future<Map<String, dynamic>?> getStudentProfile() async {
    try {
      final response = await apiClient.get('/profile');
      if (response.statusCode == 200) {
        return jsonDecode(response.body);
      } else {
        print('Failed to fetch profile: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error fetching profile: $e');
      return null;
    }
  }
}