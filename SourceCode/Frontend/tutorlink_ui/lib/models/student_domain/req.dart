import 'package:json_annotation/json_annotation.dart';

// Link to the generated part file.
part 'req.g.dart';

// Enrollment Request DTO
@JsonSerializable()
class EnrollmentReq {
  final int studentId;

  EnrollmentReq({required this.studentId});

  factory EnrollmentReq.fromJson(Map<String, dynamic> json) =>
      _$EnrollmentReqFromJson(json);

  Map<String, dynamic> toJson() => _$EnrollmentReqToJson(this);
}

// Message Request DTO
@JsonSerializable()
class MessageReq {
  final int senderId;
  final int recipientId;
  final String content;

  MessageReq({
    required this.senderId,
    required this.recipientId,
    required this.content,
  });

  factory MessageReq.fromJson(Map<String, dynamic> json) =>
      _$MessageReqFromJson(json);

  Map<String, dynamic> toJson() => _$MessageReqToJson(this);
}

// Payment Request DTO
@JsonSerializable()
class PaymentReq {
  final int studentId;
  final int paymentRequestId;
  final double amount;

  PaymentReq({
    required this.studentId,
    required this.paymentRequestId,
    required this.amount,
  });

  factory PaymentReq.fromJson(Map<String, dynamic> json) =>
      _$PaymentReqFromJson(json);

  Map<String, dynamic> toJson() => _$PaymentReqToJson(this);
}

// Send Message Request DTO
@JsonSerializable()
class SendMessageReq {
  final int senderId;
  final int recipientId;
  final String content;

  SendMessageReq({
    required this.senderId,
    required this.recipientId,
    required this.content,
  });

  factory SendMessageReq.fromJson(Map<String, dynamic> json) =>
      _$SendMessageReqFromJson(json);

  Map<String, dynamic> toJson() => _$SendMessageReqToJson(this);
}

// Subscription Request DTO
@JsonSerializable()
class SubscriptionReq {
  final int studentId;
  final String plan;
  final DateTime expiryDate;

  SubscriptionReq({
    required this.studentId,
    required this.plan,
    required this.expiryDate,
  });

  factory SubscriptionReq.fromJson(Map<String, dynamic> json) =>
      _$SubscriptionReqFromJson(json);

  Map<String, dynamic> toJson() => _$SubscriptionReqToJson(this);
}

// Update Profile Request DTO
@JsonSerializable()
class UpdateProfileReq {
  final String username;
  final String email;

  UpdateProfileReq({
    required this.username,
    required this.email,
  });

  factory UpdateProfileReq.fromJson(Map<String, dynamic> json) =>
      _$UpdateProfileReqFromJson(json);

  Map<String, dynamic> toJson() => _$UpdateProfileReqToJson(this);
}

// Update Student Profile Request DTO
@JsonSerializable()
class UpdateStudentProfileReq {
  final String? name;
  final String? email;
  final String? subscriptionLevel;

  UpdateStudentProfileReq({
    this.name,
    this.email,
    this.subscriptionLevel,
  });

  factory UpdateStudentProfileReq.fromJson(Map<String, dynamic> json) =>
      _$UpdateStudentProfileReqFromJson(json);

  Map<String, dynamic> toJson() => _$UpdateStudentProfileReqToJson(this);
}

@JsonSerializable()
class LoginReq {
  final String? username;
  final String? password;

  LoginReq({
    this.username,
    this.password,
  });

  factory LoginReq.fromJson(Map<String, dynamic> json) =>
      _$LoginReqFromJson(json);

  Map<String, dynamic> toJson() => _$LoginReqToJson(this);
}
