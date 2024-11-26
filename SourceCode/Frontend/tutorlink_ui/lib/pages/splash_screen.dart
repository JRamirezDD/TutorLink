import 'package:flutter/material.dart';
import 'welcome_page.dart';
import '../fetch_data_page.dart';

class SplashScreen extends StatefulWidget {
  @override
  _SplashScreenState createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    _navigateToWelcomePage();
  }

  _navigateToWelcomePage() async {
    // Delay to show the splash screen, then navigate to the welcome page
    await Future.delayed(Duration(seconds: 2), () {});
    Navigator.pushReplacement(
      context,
      MaterialPageRoute(builder: (context) => WelcomePage()),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          // Circular Progress Indicator in the center of the screen
          Expanded(
            child: Center(
              child: CircularProgressIndicator(),
            ),
          ),
          SizedBox(height: 20),

          // Wrapping FetchDataPage in Expanded to ensure it gets a defined height
          Expanded(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: FetchDataPage(),
            ),
          ),
        ],
      ),
    );
  }
}
