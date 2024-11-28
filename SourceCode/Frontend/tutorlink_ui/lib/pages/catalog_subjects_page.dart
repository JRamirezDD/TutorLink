import 'package:flutter/material.dart';
import 'messages_page.dart';
import 'student_home_page.dart' as student_page;
import 'user_settings_page.dart';
import 'top_rated_tutors_page.dart'; // Import the new page
import '../fetch_data_page.dart';

class CatalogSubjectsPage extends StatefulWidget {
  const CatalogSubjectsPage({super.key});

  @override
  _CatalogSubjectsPageState createState() => _CatalogSubjectsPageState();
}

class _CatalogSubjectsPageState extends State<CatalogSubjectsPage> {
  List<String> subjects = [
    'Mathematics', 'Physics', 'Chemistry', 'Biology', 'History', 'Geography',
    'English', 'Computer Science', 'Economics', 'Psychology', 'Philosophy',
    'Art', 'Music', 'Physical Education', 'Business Studies', 'Political Science',
    'Sociology', 'Environmental Science', 'French', 'Spanish', 'German', 'Japanese',
    'Chinese', 'Accounting', 'Astronomy', 'Botany', 'Zoology', 'Literature',
    'Anthropology', 'Archaeology', 'Statistics', 'Law', 'Medicine', 'Nursing',
    'Pharmacy', 'Veterinary Science'
  ];
  List<String> filteredSubjects = [];

  @override
  void initState() {
    super.initState();
    subjects.sort(); // Sort subjects alphabetically
    filteredSubjects = List.from(subjects);
  }

  void _filterSubjects(String query) {
    setState(() {
      if (query.isEmpty) {
        filteredSubjects = List.from(subjects);
      } else {
        filteredSubjects = subjects
            .where((subject) => subject.toLowerCase().startsWith(query.toLowerCase()))
            .toList();
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: Icon(Icons.account_circle, color: Colors.grey[800]),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => const UserSettingsPage()),
            );
          },
        ),
        title: const Text('Project Catalog', style: TextStyle(color: Colors.black)),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const SizedBox(height: 16),

            // Adding the FetchDataPage with height constraints
            const SizedBox(
              height: 150, // Set a finite height for the FetchDataPage
              child: FetchDataPage(),
            ),

            const SizedBox(height: 16),

            TextField(
              onChanged: (value) => _filterSubjects(value),
              decoration: InputDecoration(
                hintText: 'Search subjects',
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(8),
                ),
                prefixIcon: const Icon(Icons.search),
              ),
            ),
            const SizedBox(height: 32),

            const Text(
              'Popular Subjects',
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Colors.black,
              ),
            ),
            const SizedBox(height: 16),

            Expanded(
              child: ListView.builder(
                itemCount: filteredSubjects.length,
                itemBuilder: (context, index) {
                  return Padding(
                    padding: const EdgeInsets.only(bottom: 16.0),
                    child: Card(
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(16),
                      ),
                      elevation: 4,
                      child: ListTile(
                        title: Text(
                          filteredSubjects[index],
                          style: const TextStyle(fontSize: 18, color: Colors.green),
                        ),
                        trailing: const Icon(Icons.arrow_forward_ios, color: Colors.green),
                        onTap: () {
                          // Navigate to TopRatedTutorsPage
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => TopRatedTutorsPage(
                                subject: filteredSubjects[index],
                              ),
                            ),
                          );
                        },
                      ),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        currentIndex: 1,
        onTap: (index) {
          if (index == 0) {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => student_page.StudentHomePage(username: 'Student'),
              ),
            );
          } else if (index == 2) {
            Navigator.push(
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
        ],
      ),
    );
  }
}
