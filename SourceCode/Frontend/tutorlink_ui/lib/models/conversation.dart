// lib/models/conversation.dart

class Conversation {
  final String studentId;
  final String studentName;
  final String lastMessage;

  Conversation({
    required this.studentId,
    required this.studentName,
    required this.lastMessage,
  });

  factory Conversation.fromJson(Map<String, dynamic> json) {
    return Conversation(
      studentId: json['studentId'] as String,
      studentName: json['studentName'] as String,
      lastMessage: json['lastMessage'] as String,
    );
  }
}
