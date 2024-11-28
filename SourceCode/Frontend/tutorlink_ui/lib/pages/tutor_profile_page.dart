import 'package:flutter/material.dart';

class TutorProfilePage extends StatelessWidget {
  final Map<String, dynamic> tutor;

  const TutorProfilePage({super.key, required this.tutor});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          color: Colors.grey[800],
          onPressed: () {
            Navigator.pop(context);
          },
        ),
        title: const Text(
          'Tutor Profile',
          style: TextStyle(
            color: Colors.black,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                // Profile Picture
                CircleAvatar(
                  radius: 50,
                  backgroundImage: NetworkImage(tutor['image']),
                ),
                const SizedBox(width: 16),
                // Profile Details
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        tutor['name'],
                        style: const TextStyle(
                          fontSize: 22,
                          fontWeight: FontWeight.bold,
                          color: Colors.black,
                        ),
                      ),
                      const SizedBox(height: 8),
                      Text(
                        tutor['specialty'],
                        style: const TextStyle(
                          fontSize: 18,
                          color: Colors.grey,
                        ),
                      ),
                      const SizedBox(height: 8),
                      Text(
                        'Rate: ${tutor['rate']}',
                        style: const TextStyle(fontSize: 16),
                      ),
                      Text(
                        'Job Success: ${tutor['success']}',
                        style: const TextStyle(fontSize: 16),
                      ),
                    ],
                  ),
                ),
              ],
            ),
            const SizedBox(height: 24),
            // About the Tutor Section
            const Text(
              'About the Tutor:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            const Text(
              'This section will contain more details about the tutor’s experience, skills, and background.',
              style: TextStyle(fontSize: 16),
            ),
            const SizedBox(height: 24),
            // Recent Work Section
            const Text(
              'Recent Work Done:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            Column(
              children: [
                WorkItem(
                  title: 'SEO Strategy for E-Commerce',
                  description: 'Developed a comprehensive SEO strategy for a major e-commerce site.',
                ),
                const SizedBox(height: 8),
                WorkItem(
                  title: 'Mathematics Tutoring Program',
                  description:
                      'Created a custom tutoring program for high school students to improve their calculus skills.',
                ),
                const SizedBox(height: 8),
                WorkItem(
                  title: 'Physics Lab Preparation',
                  description: 'Assisted in preparing physics labs for university students.',
                ),
              ],
            ),
            const SizedBox(height: 24),
            // Book Session Button
            Center(
              child: ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.blue,
                  padding: const EdgeInsets.symmetric(horizontal: 24, vertical: 12),
                ),
                onPressed: () {
                  // Booking logic here
                },
                child: const Text(
                  'Book a Session',
                  style: TextStyle(fontSize: 16, color: Colors.white),
                ),
              ),
            ),
          ],
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        currentIndex: 0,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.dashboard),
            label: 'Dashboard',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message),
            label: 'Messages',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.task),
            label: 'Tasks',
          ),
        ],
      ),
    );
  }
}

class WorkItem extends StatelessWidget {
  final String title;
  final String description;

  const WorkItem({super.key, required this.title, required this.description});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(12),
      decoration: BoxDecoration(
        color: Colors.grey[200],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            title,
            style: const TextStyle(
              fontSize: 16,
              fontWeight: FontWeight.bold,
            ),
          ),
          const SizedBox(height: 4),
          Text(
            description,
            style: const TextStyle(fontSize: 14),
          ),
        ],
      ),
    );
  }
}
