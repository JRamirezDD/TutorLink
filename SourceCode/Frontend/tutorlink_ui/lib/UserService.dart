import 'package:shared_preferences/shared_preferences.dart';

class UserService {
  static final UserService _instance = UserService._internal();
  factory UserService() => _instance;
  UserService._internal();

  String? _userId;
  String? _userType;

  String? get currentUserId => _userId;
  String? get currentUserType => _userType;

  // Get userId from SharedPreferences when the app starts
  Future<void> loadUserId() async {
    final prefs = await SharedPreferences.getInstance();
    _userId = prefs.getString('userId') ?? '0';
  }

  // Set userId and save it to SharedPreferences
  Future<void> setCurrentUserId(String userId) async {
    _userId = userId;
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString('userId', userId);
  }

  // Clear userId and remove it from SharedPreferences
  Future<void> clearUserId() async {
    _userId = null;
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove('userId');
  }

  // Get userType from SharedPreferences when the app starts
  Future<void> loadUserType() async {
    final prefs = await SharedPreferences.getInstance();
    _userType = prefs.getString('userType');
  }

  // Set userType and save it to SharedPreferences
  Future<void> setUserType(String userType) async {
    _userType = userType;
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString('userType', userType);
  }

  // Clear userType and remove it from SharedPreferences
  Future<void> clearUserType() async {
    _userType = null;
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove('userType');
  }
}
