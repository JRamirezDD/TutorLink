import 'dart:convert';
import 'package:http/http.dart' as http; // Import for HTTP requests
import 'package:tutorlink_frontend_http_package/frontend_http_package.dart'; // Adjust as per your package

class ApiService {
  final ApiClient apiClient;

  ApiService({required this.apiClient});

  // Register a new student account
  Future<Map<String, dynamic>?> registerStudent(Map<String, dynamic> registrationData) async {
    return await _postRequest('/auth/registration', registrationData);
  }

  // Authorize a student login
  Future<Map<String, dynamic>?> authorizeStudent(Map<String, dynamic> loginData) async {
    return await _postRequest('/auth/authorize', loginData);
  }

  // Validate a session token
  Future<Map<String, dynamic>?> validateSession(String token) async {
    return await _getRequest('/auth/validate', headers: {
      'Authorization': 'Bearer $token',
    });
  }

  // Fetch student profile by ID
  Future<Map<String, dynamic>?> getStudentProfile(String studentId) async {
    return await _getRequest('/profile/$studentId');
  }

  // Update student profile
  Future<Map<String, dynamic>?> updateStudentProfile(Map<String, dynamic> profileData) async {
    return await _putRequest('/profile', profileData);
  }

  // Fetch subscription status
  Future<Map<String, dynamic>?> getSubscriptionStatus() async {
    return await _getRequest('/profile/subscription');
  }

  // Fetch available courses
  Future<List<Map<String, dynamic>>?> getAllCourses() async {
    return await _getRequestList('/catalog/courses');
  }

  // Fetch specific course details
  Future<Map<String, dynamic>?> getCourseDetails(String courseId) async {
    return await _getRequest('/catalog/courses/$courseId');
  }

  // Enroll in a course
  Future<Map<String, dynamic>?> enrollInCourse(String courseId) async {
    return await _postRequest('/catalog/courses/$courseId/enroll', null);
  }

  // Fetch all enrolled courses
  Future<List<Map<String, dynamic>>?> getEnrolledCourses() async {
    return await _getRequestList('/catalog/enrolled');
  }

  // Send a message between users
  Future<Map<String, dynamic>?> sendMessage(Map<String, dynamic> messageData) async {
    return await _postRequest('/messages/send', messageData);
  }

  // Fetch conversation between two users
  Future<List<Map<String, dynamic>>?> getConversation(String userId, String otherUserId) async {
    return await _getRequestList('/messages/conversation/$userId/$otherUserId');
  }

  // Private methods to handle requests
  Future<Map<String, dynamic>?> _postRequest(String endpoint, dynamic data) async {
    try {
      final response = await apiClient.post(
        endpoint,
        data != null ? jsonEncode(data) : null,
        headers: {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200 || response.statusCode == 201) {
        return jsonDecode(response.body);
      } else {
        print('Failed to post request: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error during post request: $e');
      return null;
    }
  }

  Future<Map<String, dynamic>?> _getRequest(String endpoint, {Map<String, String>? headers}) async {
    try {
      final response = await apiClient.get(
        endpoint,
        headers: headers ?? {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200) {
        return jsonDecode(response.body);
      } else {
        print('Failed to get request: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error during get request: $e');
      return null;
    }
  }

  Future<List<Map<String, dynamic>>?> _getRequestList(String endpoint) async {
    try {
      final response = await apiClient.get(
        endpoint,
        headers: {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200) {
        return List<Map<String, dynamic>>.from(jsonDecode(response.body));
      } else {
        print('Failed to get request list: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error during get request list: $e');
      return null;
    }
  }

  Future<Map<String, dynamic>?> _putRequest(String endpoint, dynamic data) async {
    try {
      final response = await apiClient.put(
        endpoint,
        data != null ? jsonEncode(data) : null,
        headers: {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200 || response.statusCode == 204) {
        if (response.body.isNotEmpty) {
          return jsonDecode(response.body);
        } else {
          return {};
        }
      } else {
        print('Failed to update: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error during put request: $e');
      return null;
    }
  }
}
