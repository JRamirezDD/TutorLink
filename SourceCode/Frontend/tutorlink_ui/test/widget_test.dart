import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:tryflutter/main.dart'; // Update with your actual import path

void main() {
  testWidgets('Tutor List and Grid display test', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MyApp());

    // Verify that the landing page is shown
    expect(find.text('Welcome to TutorLink!'), findsOneWidget);

    // Tap on 'Find a Tutor' button to navigate to Student Dashboard
    await tester.tap(find.widgetWithText(ElevatedButton, 'Find a Tutor'));
    await tester.pumpAndSettle(); // Wait for the navigation animation

    // Verify that the Student Dashboard shows up
    expect(find.text('Search for Tutors'), findsOneWidget);

    // Check if the ListView is displayed
    expect(find.byType(ListTile), findsWidgets); // Checks if list items are present

    // Switch to Grid view
    await tester.tap(find.byIcon(Icons.grid_view));
    await tester.pumpAndSettle(); // Wait for the navigation animation

    // Verify that GridView is displayed
    expect(find.byType(Card), findsWidgets); // Checks if grid items are present
  });
}
