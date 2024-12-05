// lib/models/message.dart

class Message {
  final String sender;
  final String content;

  Message({
    required this.sender,
    required this.content,
  });

  // Factory method to create a Message from JSON
  factory Message.fromJson(Map<String, dynamic> json) {
    return Message(
      sender: json['sender'] as String,
      content: json['content'] as String,
    );
  }

  // Method to convert a Message to JSON
  Map<String, dynamic> toJson() {
    return {
      'sender': sender,
      'content': content,
    };
  }
}
