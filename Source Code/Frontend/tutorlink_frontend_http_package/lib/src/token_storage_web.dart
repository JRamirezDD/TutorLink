import 'package:flutter/foundation.dart' show kIsWeb;
import 'dart:html' as html;

class TokenStorage {
  static const String _tokenKey = 'session_token';

  /// Save the session token.
  Future<void> saveToken(String token) async {
    if (kIsWeb) {
      html.window.localStorage[_tokenKey] = token;
    }
  }

  /// Retrieve the session token.
  Future<String?> getToken() async {
    if (kIsWeb) {
      return html.window.localStorage[_tokenKey];
    }
    return null;
  }

  /// Clear the session token.
  Future<void> clearToken() async {
    if (kIsWeb) {
      html.window.localStorage.remove(_tokenKey);
    }
  }
}
