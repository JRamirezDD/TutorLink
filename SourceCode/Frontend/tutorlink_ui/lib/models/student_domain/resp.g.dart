// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'resp.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ConversationResp _$ConversationRespFromJson(Map<String, dynamic> json) =>
    ConversationResp(
      otherUserId: (json['otherUserId'] as num).toInt(),
      otherUserName: json['otherUserName'] as String,
    );

Map<String, dynamic> _$ConversationRespToJson(ConversationResp instance) =>
    <String, dynamic>{
      'otherUserId': instance.otherUserId,
      'otherUserName': instance.otherUserName,
    };

CourseCatalogResp _$CourseCatalogRespFromJson(Map<String, dynamic> json) =>
    CourseCatalogResp(
      courseId: (json['courseId'] as num).toInt(),
      courseName: json['courseName'] as String,
      tutorName: json['tutorName'] as String,
      tutorId: (json['tutorId'] as num).toInt(),
      hourlyRate: (json['hourlyRate'] as num).toDouble(),
      location: json['location'] as String,
      subject: json['subject'] as String,
      description: json['description'] as String,
    );

Map<String, dynamic> _$CourseCatalogRespToJson(CourseCatalogResp instance) =>
    <String, dynamic>{
      'courseId': instance.courseId,
      'courseName': instance.courseName,
      'tutorName': instance.tutorName,
      'tutorId': instance.tutorId,
      'hourlyRate': instance.hourlyRate,
      'location': instance.location,
      'subject': instance.subject,
      'description': instance.description,
    };

CourseDetailResp _$CourseDetailRespFromJson(Map<String, dynamic> json) =>
    CourseDetailResp(
      courseId: (json['courseId'] as num).toInt(),
      courseName: json['courseName'] as String,
      tutorName: json['tutorName'] as String,
      tutorId: (json['tutorId'] as num).toInt(),
      hourlyRate: (json['hourlyRate'] as num).toDouble(),
      description: json['description'] as String,
    );

Map<String, dynamic> _$CourseDetailRespToJson(CourseDetailResp instance) =>
    <String, dynamic>{
      'courseId': instance.courseId,
      'courseName': instance.courseName,
      'tutorName': instance.tutorName,
      'tutorId': instance.tutorId,
      'hourlyRate': instance.hourlyRate,
      'description': instance.description,
    };

EnrollmentStatusResp _$EnrollmentStatusRespFromJson(
        Map<String, dynamic> json) =>
    EnrollmentStatusResp(
      courseId: (json['courseId'] as num).toInt(),
      studentId: (json['studentId'] as num).toInt(),
      status: json['status'] as String,
    );

Map<String, dynamic> _$EnrollmentStatusRespToJson(
        EnrollmentStatusResp instance) =>
    <String, dynamic>{
      'courseId': instance.courseId,
      'studentId': instance.studentId,
      'status': instance.status,
    };

MessageResp _$MessageRespFromJson(Map<String, dynamic> json) => MessageResp(
      messageId: (json['messageId'] as num).toInt(),
      senderId: (json['senderId'] as num).toInt(),
      recipientId: (json['recipientId'] as num).toInt(),
      content: json['content'] as String,
      timestamp: json['timestamp'] as String,
    );

Map<String, dynamic> _$MessageRespToJson(MessageResp instance) =>
    <String, dynamic>{
      'messageId': instance.messageId,
      'senderId': instance.senderId,
      'recipientId': instance.recipientId,
      'content': instance.content,
      'timestamp': instance.timestamp,
    };

PaymentConfirmationResp _$PaymentConfirmationRespFromJson(
        Map<String, dynamic> json) =>
    PaymentConfirmationResp(
      paymentRequestId: (json['paymentRequestId'] as num).toInt(),
      status: json['status'] as String,
      message: json['message'] as String,
    );

Map<String, dynamic> _$PaymentConfirmationRespToJson(
        PaymentConfirmationResp instance) =>
    <String, dynamic>{
      'paymentRequestId': instance.paymentRequestId,
      'status': instance.status,
      'message': instance.message,
    };

PaymentResp _$PaymentRespFromJson(Map<String, dynamic> json) => PaymentResp(
      paymentId: (json['paymentId'] as num).toInt(),
      amount: (json['amount'] as num).toDouble(),
      status: json['status'] as String,
      requestDate: json['requestDate'] as String,
    );

Map<String, dynamic> _$PaymentRespToJson(PaymentResp instance) =>
    <String, dynamic>{
      'paymentId': instance.paymentId,
      'amount': instance.amount,
      'status': instance.status,
      'requestDate': instance.requestDate,
    };

StudentProfileResp _$StudentProfileRespFromJson(Map<String, dynamic> json) =>
    StudentProfileResp(
      id: (json['id'] as num).toInt(),
      username: json['username'] as String,
      email: json['email'] as String,
      subscriptionLevel: json['subscriptionLevel'] as String,
    );

Map<String, dynamic> _$StudentProfileRespToJson(StudentProfileResp instance) =>
    <String, dynamic>{
      'id': instance.id,
      'username': instance.username,
      'email': instance.email,
      'subscriptionLevel': instance.subscriptionLevel,
    };

SubscriptionResp _$SubscriptionRespFromJson(Map<String, dynamic> json) =>
    SubscriptionResp(
      studentId: (json['studentId'] as num).toInt(),
      plan: json['plan'] as String,
      startDate: json['startDate'] as String,
      expiryDate: json['expiryDate'] as String,
    );

Map<String, dynamic> _$SubscriptionRespToJson(SubscriptionResp instance) =>
    <String, dynamic>{
      'studentId': instance.studentId,
      'plan': instance.plan,
      'startDate': instance.startDate,
      'expiryDate': instance.expiryDate,
    };

SubscriptionStatusResp _$SubscriptionStatusRespFromJson(
        Map<String, dynamic> json) =>
    SubscriptionStatusResp(
      subscriptionPlan: json['subscriptionPlan'] as String,
      expiryDate: json['expiryDate'] as String,
    );

Map<String, dynamic> _$SubscriptionStatusRespToJson(
        SubscriptionStatusResp instance) =>
    <String, dynamic>{
      'subscriptionPlan': instance.subscriptionPlan,
      'expiryDate': instance.expiryDate,
    };

TutorProfileResp _$TutorProfileRespFromJson(Map<String, dynamic> json) =>
    TutorProfileResp(
      tutorId: (json['tutorId'] as num).toInt(),
      name: json['name'] as String,
      expertise: json['expertise'] as String,
      rating: (json['rating'] as num).toDouble(),
      hourlyRate: (json['hourlyRate'] as num).toDouble(),
    );

Map<String, dynamic> _$TutorProfileRespToJson(TutorProfileResp instance) =>
    <String, dynamic>{
      'tutorId': instance.tutorId,
      'name': instance.name,
      'expertise': instance.expertise,
      'rating': instance.rating,
      'hourlyRate': instance.hourlyRate,
    };
