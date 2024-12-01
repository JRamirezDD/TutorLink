import 'api_client.dart';
import 'token_storage_web.dart';

class AuthService {
  final ApiClient apiClient;
  // final GoogleSignInHelper googleSignInHelper;
  final TokenStorage tokenStorage;

  AuthService({required this.apiClient, required this.tokenStorage});

  /*
      {required this.apiClient,
      required this.tokenStorage,
      GoogleSignInHelper? googleSignInHelper})
      : googleSignInHelper = googleSignInHelper ?? GoogleSignInHelper();
      */

  /// Registers a user and returns the session token.
  Future<String> register(String email, String password) async {
    final response = await apiClient.post('/functional/register', {
      'email': email,
      'password': password,
    });

    if (response.statusCode == 200) {
      final token = response.body;
      await tokenStorage.saveToken(token);
      return token;
    } else {
      throw Exception('Registration failed: ${response.body}');
    }
  }

  /// Logs in a user and returns the session token.
  Future<String> login(String email, String password) async {
    final response = await apiClient.post('/functional/login', {
      'email': email,
      'password': password,
    });

    if (response.statusCode == 200) {
      final token = response.body;
      await tokenStorage.saveToken(token);
      return token;
    } else {
      throw Exception('Login failed: ${response.body}');
    }
  }

  /*
  /// Logs in with Google, sends the Google Token to the Back-end, and Back-end returns a SessionToken.
  Future<String> loginWithGoogle(String idToken) async {
    final response = await apiClient.post('/functional/oauth2/google', {
      'idToken': idToken,
    });

    if (response.statusCode == 200) {
      final token = response.body;
      await tokenStorage.saveToken(token);
      return token;
    } else {
      throw Exception('Google login failed: ${response.body}');
    }
  }
  */
}
