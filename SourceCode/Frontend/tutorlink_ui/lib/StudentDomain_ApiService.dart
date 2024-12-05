import 'dart:convert';
import 'package:tryflutter/UserService.dart';
import 'package:tryflutter/config.dart';
import 'package:tryflutter/models/student_domain/req.dart';
import 'package:tryflutter/models/student_domain/resp.dart';
import 'package:tutorlink_frontend_http_package/frontend_http_package.dart'; // Adjust as per your package

class StudentDomain_ApiService {
  final ApiClient apiClient = ApiClient(baseUrl: BASE_URL);

  final String baseEndpoint = "/student";

  // Singleton instance
  static StudentDomain_ApiService? _instance;

  final UserService _userService = UserService();

  // Static method to get the instance
  static StudentDomain_ApiService getInstance() {
    return _instance!;
  }

  // Register a new student account
  Future<void> registerStudent(UpdateStudentProfileReq registrationData) async {
    await _postRequest(
        '${baseEndpoint}/auth/registration', registrationData.toJson());
    return null;
  }

  // Login a student account - P - userId return format?
  Future<void> loginStudent(LoginReq loginData) async {
    final response =
        await _postRequest('${baseEndpoint}/auth/login', loginData.toJson());
    _userService.setCurrentUserId(response?['userId']);
    _userService.setUserType('student');
    return null;
  }

  // Login a student account
  Future<void> logoutStudent() async {
    final response = await _postRequest('${baseEndpoint}/auth/logout', null);
    if (response != null) {
      _userService.clearUserId();
      _userService.clearUserType();
    }
    return null;
  }

  // Fetch student profile by ID
  Future<StudentProfileResp?> getStudentProfile(String studentId) async {
    final response = await _getRequest('${baseEndpoint}/profile/$studentId');
    if (response != null) {
      return StudentProfileResp.fromJson(response);
    }
    return null;
  }

  // Update student profile
  Future<StudentProfileResp?> updateStudentProfile(
      UpdateStudentProfileReq profileData) async {
    final response =
        await _putRequest('${baseEndpoint}/profile', profileData.toJson());
    if (response != null) {
      return StudentProfileResp.fromJson(response);
    }
    return null;
  }

  // Fetch subscription status
  Future<SubscriptionStatusResp?> getSubscriptionStatus(
      String studentId) async {
    final response =
        await _getRequest('${baseEndpoint}/subscription/$studentId');
    if (response != null) {
      return SubscriptionStatusResp.fromJson(response);
    }
    return null;
  }

  // Fetch available courses
  Future<List<CourseCatalogResp>?> getAllCourses() async {
    final response = await _getRequestList('${baseEndpoint}/catalog/courses');
    if (response != null) {
      return response
          .map((courseJson) => CourseCatalogResp.fromJson(courseJson))
          .toList();
    }
    return null;
  }

  // Fetch specific course details
  Future<CourseDetailResp?> getCourseDetails(String courseId) async {
    final response =
        await _getRequest('${baseEndpoint}/catalog/courses/$courseId');
    if (response != null) {
      return CourseDetailResp.fromJson(response);
    }
    return null;
  }

  // Enroll in a course
  Future<EnrollmentStatusResp?> enrollInCourse(
      String courseId, EnrollmentReq enrollmentData) async {
    final response = await _postRequest(
        '${baseEndpoint}/catalog/courses/$courseId/enroll',
        enrollmentData.toJson());
    if (response != null) {
      return EnrollmentStatusResp.fromJson(response);
    }
    return null;
  }

  // Fetch all enrolled courses
  Future<List<CourseCatalogResp>?> getEnrolledCourses(String studentId) async {
    final response = await _getRequestList(
        '${baseEndpoint}/catalog/enrolled?studentId=$studentId');
    if (response != null) {
      return response
          .map((courseJson) => CourseCatalogResp.fromJson(courseJson))
          .toList();
    }
    return null;
  }

  // Send a message between users
  Future<MessageResp?> sendMessage(SendMessageReq messageData) async {
    final response = await _postRequest(
        '${baseEndpoint}/messages/send', messageData.toJson());
    if (response != null) {
      return MessageResp.fromJson(response);
    }
    return null;
  }

  // Fetch conversation between two users
  Future<List<MessageResp>?> getConversation(
      String userId, String otherUserId) async {
    final response = await _getRequestList(
        '${baseEndpoint}/messages/conversation/$userId/$otherUserId');
    if (response != null) {
      return response
          .map((messageJson) => MessageResp.fromJson(messageJson))
          .toList();
    }
    return null;
  }

  // Fetch all tutors
  Future<List<TutorProfileResp>?> getAllTutors() async {
    final response = await _getRequestList('${baseEndpoint}/tutors');
    if (response != null) {
      return response
          .map((tutorJson) => TutorProfileResp.fromJson(tutorJson))
          .toList();
    }
    return null;
  }

  // Fetch tutor profile by ID
  Future<TutorProfileResp?> getTutorProfile(String tutorId) async {
    final response = await _getRequest('${baseEndpoint}/tutors/$tutorId');
    if (response != null) {
      return TutorProfileResp.fromJson(response);
    }
    return null;
  }

  // Create a payment request
  Future<PaymentResp?> createPaymentRequest(PaymentReq paymentData) async {
    final response =
        await _postRequest('${baseEndpoint}/payment', paymentData.toJson());
    if (response != null) {
      return PaymentResp.fromJson(response);
    }
    return null;
  }

  // Pay a payment request
  Future<PaymentConfirmationResp?> payRequest(String paymentId) async {
    final response =
        await _postRequest('${baseEndpoint}/payment/$paymentId/pay', null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Decline a payment request
  Future<PaymentConfirmationResp?> declinePaymentRequest(
      String paymentId) async {
    final response =
        await _postRequest('${baseEndpoint}/payment/$paymentId/decline', null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Confirm acceptance of payment
  Future<PaymentConfirmationResp?> confirmAcceptPayment(
      String paymentRequestId) async {
    final response = await _postRequest(
        '${baseEndpoint}/payment/$paymentRequestId/confirm/accept', null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Confirm rejection of payment
  Future<PaymentConfirmationResp?> confirmRejectPayment(
      String paymentRequestId) async {
    final response = await _postRequest(
        '${baseEndpoint}/payment/$paymentRequestId/confirm/reject', null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Upgrade to Gold subscription
  Future<SubscriptionResp?> upgradeToGold(String studentId) async {
    final response = await _postRequest(
        '${baseEndpoint}/subscription/$studentId/upgrade', null);
    if (response != null) {
      return SubscriptionResp.fromJson(response);
    }
    return null;
  }

  // Private methods to handle requests
  Future<Map<String, dynamic>?> _postRequest(
      String endpoint, dynamic data) async {
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

  Future<Map<String, dynamic>?> _putRequest(
      String endpoint, dynamic data) async {
    try {
      final response = await apiClient.put(
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

  Future<Map<String, dynamic>?> _getRequest(String endpoint,
      {Map<String, String>? headers}) async {
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
        print('Failed to get request: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('Error during get request: $e');
      return null;
    }
  }
}
