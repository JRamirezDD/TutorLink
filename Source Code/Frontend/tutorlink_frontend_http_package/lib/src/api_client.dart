import 'dart:convert';
import 'package:http/http.dart' as http;

class ApiClient {
  final String baseUrl;
  final Map<String, String> defaultHeaders;
  final String sessionToken;
  final http.Client httpClient;

  ApiClient({
    required this.baseUrl,
    required this.sessionToken,
    this.defaultHeaders = const {},
    http.Client? httpClient,
  }) : httpClient = httpClient ?? http.Client();

  Map<String, String> _getHeaders(Map<String, String>? headers) {
    return {
      ...defaultHeaders,
      'Authorization': 'Bearer $sessionToken',
      ...?headers,
    };
  }

  Future<http.Response> get(String endpoint,
      {Map<String, String>? headers}) async {
    return await httpClient.get(
      Uri.parse('$baseUrl$endpoint'),
      headers: _getHeaders(headers),
    );
  }

  Future<http.Response> post(String endpoint, dynamic body,
      {Map<String, String>? headers}) async {
    final requestHeaders = _getHeaders(headers);
    return await httpClient.post(
      Uri.parse('$baseUrl$endpoint'),
      headers: requestHeaders,
      body: body is Map ? jsonEncode(body) : body,
    );
  }

  Future<http.Response> put(String endpoint, dynamic body,
      {Map<String, String>? headers}) async {
    final requestHeaders = _getHeaders(headers);
    return await httpClient.put(
      Uri.parse('$baseUrl$endpoint'),
      headers: requestHeaders,
      body: body is Map ? jsonEncode(body) : body,
    );
  }

  Future<http.Response> delete(String endpoint,
      {Map<String, String>? headers}) async {
    final requestHeaders = _getHeaders(headers);
    return await httpClient.delete(
      Uri.parse('$baseUrl$endpoint'),
      headers: requestHeaders,
    );
  }
}
