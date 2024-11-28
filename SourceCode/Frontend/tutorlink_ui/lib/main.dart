import 'package:flutter/material.dart';
import 'pages/student_home_page.dart';
import 'pages/student_login_page.dart';
import 'pages/tutor_login_page.dart';
import 'pages/student_registration_page.dart';
import 'pages/tutor_registration_page.dart';
import 'pages/welcome_page.dart';
import 'pages/catalog_subjects_page.dart';
import 'pages/Messages_page_tutor.dart';
import 'pages/tasks_page.dart';
import 'pages/tutor_home_page.dart';
import 'pages/user_settings_page.dart';
import 'package:tryflutter/fetch_data_page.dart'; // Import the FetchDataPage

// Define route names as constants
const String welcomeRoute = '/';
const String loginStudentRoute = '/loginStudent';
const String loginTutorRoute = '/loginTutor';
const String registerStudentRoute = '/registerStudent';
const String registerTutorRoute = '/registerTutor';
const String studentHomeRoute = '/home';
const String catalogRoute = '/catalog';
const String messagesPageRoute = '/messagesPage';
const String tasksRoute = '/tasks';
const String tutorHomeRoute = '/tutorHome';
const String userSettingsRoute = '/userSettings';
const String fetchDataRoute = '/fetchData';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'TutorLink',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      initialRoute: welcomeRoute, // Set initial route to welcome page
      routes: {
        welcomeRoute: (context) => const WelcomePage(), // Route for welcome page
        loginStudentRoute: (context) =>
            const StudentLoginPage(), // Route for student login page
        loginTutorRoute: (context) =>
            const TutorLoginPage(), // Route for tutor login page
        registerStudentRoute: (context) =>
            const StudentRegistrationPage(), // Route for student registration page
        registerTutorRoute: (context) =>
            const TutorRegistrationPage(), // Route for tutor registration page
        studentHomeRoute: (context) =>
            StudentHomePage(username: 'Guest'), // Home page
        catalogRoute: (context) =>
            const CatalogSubjectsPage(), // Catalog subjects page
        messagesPageRoute: (context) =>
            const MessagesPageTutor(), // Messages page for tutor
        tasksRoute: (context) => const TasksPage(), // Tasks page
        tutorHomeRoute: (context) => TutorHomePage(
            tutorName: 'John Doe',
            subjects: 'Math, Physics',
            hourlyRate: '20'), // Tutor home page
        userSettingsRoute: (context) =>
            const UserSettingsPage(), // User settings page
        fetchDataRoute: (context) =>
            const FetchDataPage(), // Route for FetchDataPage to avoid unused import warning
      },
    );
  }
}
