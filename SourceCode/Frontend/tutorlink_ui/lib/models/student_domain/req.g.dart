// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'req.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EnrollmentReq _$EnrollmentReqFromJson(Map<String, dynamic> json) =>
    EnrollmentReq(
      studentId: (json['studentId'] as num).toInt(),
    );

Map<String, dynamic> _$EnrollmentReqToJson(EnrollmentReq instance) =>
    <String, dynamic>{
      'studentId': instance.studentId,
    };

MessageReq _$MessageReqFromJson(Map<String, dynamic> json) => MessageReq(
      senderId: (json['senderId'] as num).toInt(),
      recipientId: (json['recipientId'] as num).toInt(),
      content: json['content'] as String,
    );

Map<String, dynamic> _$MessageReqToJson(MessageReq instance) =>
    <String, dynamic>{
      'senderId': instance.senderId,
      'recipientId': instance.recipientId,
      'content': instance.content,
    };

PaymentReq _$PaymentReqFromJson(Map<String, dynamic> json) => PaymentReq(
      studentId: (json['studentId'] as num).toInt(),
      paymentRequestId: (json['paymentRequestId'] as num).toInt(),
      amount: (json['amount'] as num).toDouble(),
    );

Map<String, dynamic> _$PaymentReqToJson(PaymentReq instance) =>
    <String, dynamic>{
      'studentId': instance.studentId,
      'paymentRequestId': instance.paymentRequestId,
      'amount': instance.amount,
    };

SendMessageReq _$SendMessageReqFromJson(Map<String, dynamic> json) =>
    SendMessageReq(
      senderId: (json['senderId'] as num).toInt(),
      recipientId: (json['recipientId'] as num).toInt(),
      content: json['content'] as String,
    );

Map<String, dynamic> _$SendMessageReqToJson(SendMessageReq instance) =>
    <String, dynamic>{
      'senderId': instance.senderId,
      'recipientId': instance.recipientId,
      'content': instance.content,
    };

SubscriptionReq _$SubscriptionReqFromJson(Map<String, dynamic> json) =>
    SubscriptionReq(
      studentId: (json['studentId'] as num).toInt(),
      plan: json['plan'] as String,
      expiryDate: DateTime.parse(json['expiryDate'] as String),
    );

Map<String, dynamic> _$SubscriptionReqToJson(SubscriptionReq instance) =>
    <String, dynamic>{
      'studentId': instance.studentId,
      'plan': instance.plan,
      'expiryDate': instance.expiryDate.toIso8601String(),
    };

UpdateProfileReq _$UpdateProfileReqFromJson(Map<String, dynamic> json) =>
    UpdateProfileReq(
      username: json['username'] as String,
      email: json['email'] as String,
    );

Map<String, dynamic> _$UpdateProfileReqToJson(UpdateProfileReq instance) =>
    <String, dynamic>{
      'username': instance.username,
      'email': instance.email,
    };

UpdateStudentProfileReq _$UpdateStudentProfileReqFromJson(
        Map<String, dynamic> json) =>
    UpdateStudentProfileReq(
      name: json['name'] as String?,
      email: json['email'] as String?,
      subscriptionLevel: json['subscriptionLevel'] as String?,
    );

Map<String, dynamic> _$UpdateStudentProfileReqToJson(
        UpdateStudentProfileReq instance) =>
    <String, dynamic>{
      'name': instance.name,
      'email': instance.email,
      'subscriptionLevel': instance.subscriptionLevel,
    };

LoginReq _$LoginReqFromJson(Map<String, dynamic> json) => LoginReq(
      username: json['username'] as String?,
      password: json['password'] as String?,
    );

Map<String, dynamic> _$LoginReqToJson(LoginReq instance) => <String, dynamic>{
      'username': instance.username,
      'password': instance.password,
    };
