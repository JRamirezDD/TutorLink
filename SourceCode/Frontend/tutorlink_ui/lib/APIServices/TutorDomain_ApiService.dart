import 'dart:convert';
import 'package:tryflutter/UserService.dart';
import 'package:tryflutter/config.dart';
import 'package:tryflutter/models/student_domain/req.dart';
import 'package:tryflutter/models/student_domain/resp.dart';
import 'package:tutorlink_frontend_http_package/frontend_http_package.dart'; // Adjust as per your package

class StudentDomain_ApiService {
  final ApiClient apiClient = ApiClient(baseUrl: BASE_URL);

  final String baseEndpoint = "/gateway/student";

  // Singleton instance
  static StudentDomain_ApiService? _instance;

  final UserService _userService = UserService();

  // Static method to get the instance
  static StudentDomain_ApiService getInstance() {
    return _instance!;
  }

  // Register a new student account
  Future<void> registerStudent(RegisterUserReq registerUserReq,
      UpdateStudentProfileReq registrationData) async {
    await _postRequest('${baseEndpoint}/auth/authentication/register',
        registerUserReq.toJson());

    await _postRequest(
        '${baseEndpoint}/functional/profile', registrationData.toJson());
    return null;
  }

  // Login a student account - P - userId return format?
  Future<String> loginStudent(LoginReq loginData) async {
    final response = await _postRequest(
        '${baseEndpoint}/auth/authentication/login', loginData.toJson());

    final getUserIdResponse =
        await _getRequest('${baseEndpoint}/auth/authentication/user');

    final user = UserEntity.fromJson(getUserIdResponse!);

    _userService.setCurrentUserId(user.id!);
    _userService.setUserType('student');
    return _userService.currentUserId.toString();
  }

  // Login a student account
  Future<void> logoutStudent() async {
    final response =
        await _postRequest('${baseEndpoint}/auth/authentication/logout', null);
    if (response != null) {
      _userService.clearUserId();
      _userService.clearUserType();
    }
    return null;
  }

  // Fetch student profile by ID
  Future<StudentProfileResp?> getStudentProfile(String studentId) async {
    final response =
        await _getRequest('${baseEndpoint}/functional/profile/$studentId');
    if (response != null) {
      return StudentProfileResp.fromJson(response);
    }
    return null;
  }

  // Update student profile
  Future<StudentProfileResp?> updateStudentProfile(
      UpdateStudentProfileReq profileData) async {
    final response = await _putRequest(
        '${baseEndpoint}/functional/profile', profileData.toJson());
    if (response != null) {
      return StudentProfileResp.fromJson(response);
    }
    return null;
  }

  // Fetch subscription status
  Future<SubscriptionStatusResp?> getSubscriptionStatus(
      String studentId) async {
    final response =
        await _getRequest('${baseEndpoint}/functional/subscription/$studentId');
    if (response != null) {
      return SubscriptionStatusResp.fromJson(response);
    }
    return null;
  }

  // Fetch available courses
  Future<List<CourseCatalogResp>?> getAllCourses() async {
    final response =
        await _getRequestList('${baseEndpoint}/functional/catalog/courses');
    if (response != null) {
      return response
          .map((courseJson) => CourseCatalogResp.fromJson(courseJson))
          .toList();
    }
    return null;
  }

  // Fetch specific course details
  Future<CourseDetailResp?> getCourseDetails(String courseId) async {
    final response = await _getRequest(
        '${baseEndpoint}/functional/catalog/courses/$courseId');
    if (response != null) {
      return CourseDetailResp.fromJson(response);
    }
    return null;
  }

  // Enroll in a course
  Future<EnrollmentStatusResp?> enrollInCourse(
      String courseId, EnrollmentReq enrollmentData) async {
    final response = await _postRequest(
        '${baseEndpoint}/functional/catalog/courses/$courseId/enroll',
        enrollmentData.toJson());
    if (response != null) {
      return EnrollmentStatusResp.fromJson(response);
    }
    return null;
  }

  // Fetch all enrolled courses
  Future<List<CourseCatalogResp>?> getEnrolledCourses(String studentId) async {
    final response = await _getRequestList(
        '${baseEndpoint}/functional/catalog/enrolled?studentId=$studentId');
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
        '${baseEndpoint}/functional/messages/send', messageData.toJson());
    if (response != null) {
      return MessageResp.fromJson(response);
    }
    return null;
  }

  // Fetch conversation between two users
  Future<List<MessageResp>?> getConversation(
      String userId, String otherUserId) async {
    final response = await _getRequestList(
        '${baseEndpoint}/functional/messages/conversation/$userId/$otherUserId');
    if (response != null) {
      return response
          .map((messageJson) => MessageResp.fromJson(messageJson))
          .toList();
    }
    return null;
  }

  // Fetch all tutors
  Future<List<TutorProfileResp>?> getAllTutors() async {
    final response = await _getRequestList('${baseEndpoint}/functional/tutors');
    if (response != null) {
      return response
          .map((tutorJson) => TutorProfileResp.fromJson(tutorJson))
          .toList();
    }
    return null;
  }

  // Fetch tutor profile by ID
  Future<TutorProfileResp?> getTutorProfile(String tutorId) async {
    final response =
        await _getRequest('${baseEndpoint}/functional/tutors/$tutorId');
    if (response != null) {
      return TutorProfileResp.fromJson(response);
    }
    return null;
  }

  // Create a payment request
  Future<PaymentResp?> createPaymentRequest(PaymentReq paymentData) async {
    final response = await _postRequest(
        '${baseEndpoint}/functional/payment', paymentData.toJson());
    if (response != null) {
      return PaymentResp.fromJson(response);
    }
    return null;
  }

  // Pay a payment request
  Future<PaymentConfirmationResp?> payRequest(String paymentId) async {
    final response = await _postRequest(
        '${baseEndpoint}/functional/payment/$paymentId/pay', null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Decline a payment request
  Future<PaymentConfirmationResp?> declinePaymentRequest(
      String paymentId) async {
    final response = await _postRequest(
        '${baseEndpoint}/functional/payment/$paymentId/decline', null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Confirm acceptance of payment
  Future<PaymentConfirmationResp?> confirmAcceptPayment(
      String paymentRequestId) async {
    final response = await _postRequest(
        '${baseEndpoint}/functional/payment/$paymentRequestId/confirm/accept',
        null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Confirm rejection of payment
  Future<PaymentConfirmationResp?> confirmRejectPayment(
      String paymentRequestId) async {
    final response = await _postRequest(
        '${baseEndpoint}/functional/payment/$paymentRequestId/confirm/reject',
        null);
    if (response != null) {
      return PaymentConfirmationResp.fromJson(response);
    }
    return null;
  }

  // Upgrade to Gold subscription
  Future<SubscriptionResp?> upgradeToGold(String studentId) async {
    final response = await _postRequest(
        '${baseEndpoint}/functional/subscription/$studentId/upgrade', null);
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
