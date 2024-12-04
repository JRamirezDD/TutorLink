import 'package:json_annotation/json_annotation.dart';
import 'package:intl/intl.dart'; // For formatting LocalDateTime

part 'resp.g.dart'; // Generates the serialization code

@JsonSerializable()
class ConversationResp {
  final int otherUserId;
  final String otherUserName;

  ConversationResp({
    required this.otherUserId,
    required this.otherUserName,
  });

  factory ConversationResp.fromJson(Map<String, dynamic> json) =>
      _$ConversationRespFromJson(json);

  Map<String, dynamic> toJson() => _$ConversationRespToJson(this);
}

@JsonSerializable()
class CourseCatalogResp {
  final int courseId;
  final String courseName;
  final String tutorName;
  final int tutorId;
  final double hourlyRate;
  final String location;
  final String subject;
  final String description;

  CourseCatalogResp({
    required this.courseId,
    required this.courseName,
    required this.tutorName,
    required this.tutorId,
    required this.hourlyRate,
    required this.location,
    required this.subject,
    required this.description,
  });

  factory CourseCatalogResp.fromJson(Map<String, dynamic> json) =>
      _$CourseCatalogRespFromJson(json);

  Map<String, dynamic> toJson() => _$CourseCatalogRespToJson(this);
}

@JsonSerializable()
class CourseDetailResp {
  final int courseId;
  final String courseName;
  final String tutorName;
  final int tutorId;
  final double hourlyRate;
  final String description;

  CourseDetailResp({
    required this.courseId,
    required this.courseName,
    required this.tutorName,
    required this.tutorId,
    required this.hourlyRate,
    required this.description,
  });

  factory CourseDetailResp.fromJson(Map<String, dynamic> json) =>
      _$CourseDetailRespFromJson(json);

  Map<String, dynamic> toJson() => _$CourseDetailRespToJson(this);
}

@JsonSerializable()
class EnrollmentStatusResp {
  final int courseId;
  final int studentId;
  final String status;

  EnrollmentStatusResp({
    required this.courseId,
    required this.studentId,
    required this.status,
  });

  factory EnrollmentStatusResp.fromJson(Map<String, dynamic> json) =>
      _$EnrollmentStatusRespFromJson(json);

  Map<String, dynamic> toJson() => _$EnrollmentStatusRespToJson(this);
}

@JsonSerializable()
class MessageResp {
  final int messageId;
  final int senderId;
  final int recipientId;
  final String content;
  final String timestamp; // DateTime converted to String (e.g., ISO8601)

  MessageResp({
    required this.messageId,
    required this.senderId,
    required this.recipientId,
    required this.content,
    required this.timestamp,
  });

  factory MessageResp.fromJson(Map<String, dynamic> json) =>
      _$MessageRespFromJson(json);

  Map<String, dynamic> toJson() => _$MessageRespToJson(this);
}

@JsonSerializable()
class PaymentConfirmationResp {
  final int paymentRequestId;
  final String status;
  final String message;

  PaymentConfirmationResp({
    required this.paymentRequestId,
    required this.status,
    required this.message,
  });

  factory PaymentConfirmationResp.fromJson(Map<String, dynamic> json) =>
      _$PaymentConfirmationRespFromJson(json);

  Map<String, dynamic> toJson() => _$PaymentConfirmationRespToJson(this);
}

@JsonSerializable()
class PaymentResp {
  final int paymentId;
  final double amount;
  final String status;
  final String requestDate; // DateTime converted to String (e.g., ISO8601)

  PaymentResp({
    required this.paymentId,
    required this.amount,
    required this.status,
    required this.requestDate,
  });

  factory PaymentResp.fromJson(Map<String, dynamic> json) =>
      _$PaymentRespFromJson(json);

  Map<String, dynamic> toJson() => _$PaymentRespToJson(this);
}

@JsonSerializable()
class StudentProfileResp {
  final int id;
  final String username;
  final String email;
  final String subscriptionLevel;

  StudentProfileResp({
    required this.id,
    required this.username,
    required this.email,
    required this.subscriptionLevel,
  });

  factory StudentProfileResp.fromJson(Map<String, dynamic> json) =>
      _$StudentProfileRespFromJson(json);

  Map<String, dynamic> toJson() => _$StudentProfileRespToJson(this);
}

@JsonSerializable()
class SubscriptionResp {
  final int studentId;
  final String plan;
  final String startDate; // DateTime converted to String (e.g., ISO8601)
  final String expiryDate; // DateTime converted to String (e.g., ISO8601)

  SubscriptionResp({
    required this.studentId,
    required this.plan,
    required this.startDate,
    required this.expiryDate,
  });

  factory SubscriptionResp.fromJson(Map<String, dynamic> json) =>
      _$SubscriptionRespFromJson(json);

  Map<String, dynamic> toJson() => _$SubscriptionRespToJson(this);
}

@JsonSerializable()
class SubscriptionStatusResp {
  final String subscriptionPlan;
  final String expiryDate; // DateTime converted to String (e.g., ISO8601)

  SubscriptionStatusResp({
    required this.subscriptionPlan,
    required this.expiryDate,
  });

  factory SubscriptionStatusResp.fromJson(Map<String, dynamic> json) =>
      _$SubscriptionStatusRespFromJson(json);

  Map<String, dynamic> toJson() => _$SubscriptionStatusRespToJson(this);
}

@JsonSerializable()
class TutorProfileResp {
  final int tutorId;
  final String name;
  final String expertise;
  final double rating;
  final double hourlyRate;

  TutorProfileResp({
    required this.tutorId,
    required this.name,
    required this.expertise,
    required this.rating,
    required this.hourlyRate,
  });

  factory TutorProfileResp.fromJson(Map<String, dynamic> json) =>
      _$TutorProfileRespFromJson(json);

  Map<String, dynamic> toJson() => _$TutorProfileRespToJson(this);
}
