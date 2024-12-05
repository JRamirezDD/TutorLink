import 'package:flutter/material.dart';
import 'catalog_subjects_page.dart';
import 'messages_page.dart';
import 'student_home_page.dart';

class YourTutorsPage extends StatelessWidget {
  final List<Map<String, dynamic>> tutors = [
    {
      'name': 'Anna K.',
      'specialty': 'Mathematics Expert',
    },
    {
      'name': 'John D.',
      'specialty': 'Physics Tutor',
    },
    {
      'name': 'Sophia L.',
      'specialty': 'Chemistry Teacher',
    },
  ];

  YourTutorsPage({Key? key}) : super(key: key); 

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blueAccent,
        elevation: 0,
        title: const Text(
          'My Tutors',
          style: TextStyle(color: Colors.black),
        ),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () {
            Navigator.of(context).pop();
          },
        ),
      ),
      body: ListView.builder(
        itemCount: tutors.length,
        itemBuilder: (context, index) {
          final tutor = tutors[index];
          return Card(
            margin: const EdgeInsets.symmetric(vertical: 8, horizontal: 16),
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        tutor['name'],
                        style: const TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      const SizedBox(height: 4),
                      Text(tutor['specialty']),
                    ],
                  ),
                  ElevatedButton(
                    onPressed: () {
                      _showReviewDialog(context, tutor['name']);
                    },
                    child: const Text('Leave a Review'),
                  ),
                ],
              ),
            ),
          );
        },
      ),
     bottomNavigationBar: BottomNavigationBar(
  type: BottomNavigationBarType.fixed,
  currentIndex: 3, 
  onTap: (index) {
    if (index == 0) {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
          builder: (context) => StudentHomePage(username: 'YourUsername'),
        ),
      );
    } else if (index == 1) {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => const CatalogSubjectsPage()),
      );
    } else if (index == 2) {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => const MessagesPage()),
      );
    }
  },
  items: const [
    BottomNavigationBarItem(
      icon: Icon(Icons.dashboard),
      label: 'Dashboard',
    ),
    BottomNavigationBarItem(
      icon: Icon(Icons.list),
      label: 'Catalog',
    ),
    BottomNavigationBarItem(
      icon: Icon(Icons.message),
      label: 'Messages',
    ),
    BottomNavigationBarItem(
      icon: Icon(Icons.people),
      label: 'My Tutors',
    ),
  ],
),

    );
  }

  void _showReviewDialog(BuildContext context, String tutorName) {
    final TextEditingController reviewController = TextEditingController();
    double rating = 0; // Track the selected rating

    showDialog(
      context: context,
      builder: (context) {
        return StatefulBuilder(
          builder: (context, setState) {
            return AlertDialog(
              title: Text('Review for $tutorName'),
              content: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  const Text('Rate your experience:'),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: List.generate(5, (index) {
                      return IconButton(
                        icon: Icon(
                          index < rating ? Icons.star : Icons.star_border,
                          color: Colors.amber,
                        ),
                        onPressed: () {
                          setState(() {
                            rating = index + 1.0; // Update the rating dynamically
                          });
                        },
                      );
                    }),
                  ),
                  const SizedBox(height: 8),
                  TextField(
                    controller: reviewController,
                    decoration: const InputDecoration(
                      labelText: 'Leave a comment',
                      border: OutlineInputBorder(),
                    ),
                    maxLines: 3,
                  ),
                ],
              ),
              actions: [
                TextButton(
                  onPressed: () {
                    Navigator.pop(context); // Close the dialog
                  },
                  child: const Text('Cancel'),
                ),
                ElevatedButton(
                  onPressed: () {
                    // Handle Review Submission
                    final String reviewText = reviewController.text;
                    print('Rating: $rating stars, Review: $reviewText for $tutorName');
                    Navigator.pop(context); // Close the dialog
                  },
                  child: const Text('Submit'),
                ),
              ],
            );
          },
        );
      },
    );
  }
}
