import 'package:google_sign_in/google_sign_in.dart';

class GoogleSignInHelper {
  final GoogleSignIn _googleSignIn;

  /// Initialize Google Sign In with the required email scope.
  GoogleSignInHelper()
      : _googleSignIn = GoogleSignIn(
          scopes: ['email'],
        );

  /// Signs in the user with Google and returns the `idToken`.
  Future<String?> getGoogleIdToken() async {
    try {
      final GoogleSignInAccount? googleUser = await _googleSignIn.signIn();
      final GoogleSignInAuthentication? googleAuth =
          await googleUser?.authentication;
      return googleAuth?.idToken;
    } catch (error) {
      print('Google Sign-In failed: $error');
      return null;
    }
  }

  /// Signs out the Google user.
  Future<void> signOut() async {
    try {
      await _googleSignIn.signOut();
    } catch (error) {
      print('Google Sign-Out failed: $error');
    }
  }
}
