import 'dart:convert';
import 'package:http/http.dart' as http;

class StudentAuthService {
  final String baseUrl;

  StudentAuthService({required this.baseUrl});

  // Register student
  Future<Map<String, dynamic>?> registerStudent(Map<String, String> registrationData) async {
    final url = Uri.parse('$baseUrl/auth/registration');
    try {
      final response = await http.post(
        url,
        body: jsonEncode(registrationData),
        headers: {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200) {
        return jsonDecode(response.body);
      } else {
        print('Registration failed: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error during registration: $e');
      return null;
    }
  }

  // Authorize student login
  Future<Map<String, dynamic>?> authorizeStudent(Map<String, String> loginData) async {
    final url = Uri.parse('$baseUrl/auth/authorize');
    try {
      final response = await http.post(
        url,
        body: jsonEncode(loginData),
        headers: {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200) {
        return jsonDecode(response.body);
      } else {
        print('Login failed: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error during login: $e');
      return null;
    }
  }
}
