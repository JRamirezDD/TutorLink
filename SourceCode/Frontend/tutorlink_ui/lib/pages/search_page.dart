import 'package:flutter/material.dart';
import 'package:graphql_flutter/graphql_flutter.dart';

class CourseCataloguePage extends StatefulWidget {
  const CourseCataloguePage({Key? key}) : super(key: key);

  @override
  _CourseCataloguePageState createState() => _CourseCataloguePageState();
}

class _CourseCataloguePageState extends State<CourseCataloguePage> {
  String? selectedLocation;
  String? selectedSubject;
  double? minPrice;
  double? maxPrice;

  final List<String> locations = [
    'New York',
    'Los Angeles',
    'Chicago',
    'Miami'
  ];
  final List<String> subjects = ['Math', 'Science', 'History', 'Programming'];

  final String query = """
    query GetCourses(\$minPrice: Float, \$maxPrice: Float, \$location: String, \$subject: String) {
      getAllCourses(minPrice: \$minPrice, maxPrice: \$maxPrice, location: \$location, subject: \$subject) {
        courseId
        courseName
        tutorName
        hourlyRate
        location
        subject
        description
      }
    }
  """;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Course Catalogue'),
        backgroundColor: Colors.deepPurple,
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: FilterBar(
              locations: locations,
              subjects: subjects,
              onFilterChanged: (String? location, String? subject, double? min,
                  double? max) {
                setState(() {
                  selectedLocation = location;
                  selectedSubject = subject;
                  minPrice = min;
                  maxPrice = max;
                });
              },
            ),
          ),
          Expanded(
            child: Query(
              options: QueryOptions(
                document: gql(query),
                variables: {
                  'minPrice': minPrice,
                  'maxPrice': maxPrice,
                  'location': selectedLocation,
                  'subject': selectedSubject,
                },
              ),
              builder: (QueryResult result, {fetchMore, refetch}) {
                if (result.isLoading) {
                  return const Center(child: CircularProgressIndicator());
                }

                if (result.hasException) {
                  return Center(child: Text(result.exception.toString()));
                }

                final courses = result.data?['getAllCourses'] ?? [];

                if (courses.isEmpty) {
                  return const Center(child: Text('No courses found.'));
                }

                return GridView.builder(
                  padding: const EdgeInsets.all(8.0),
                  gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 2,
                    childAspectRatio: 3 / 4,
                    crossAxisSpacing: 10,
                    mainAxisSpacing: 10,
                  ),
                  itemCount: courses.length,
                  itemBuilder: (context, index) {
                    final course = courses[index];
                    return CourseCard(course: course);
                  },
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}

class FilterBar extends StatelessWidget {
  final List<String> locations;
  final List<String> subjects;
  final Function(String?, String?, double?, double?) onFilterChanged;

  const FilterBar({
    Key? key,
    required this.locations,
    required this.subjects,
    required this.onFilterChanged,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    String? selectedLocation;
    String? selectedSubject;
    double? minPrice;
    double? maxPrice;

    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      elevation: 4,
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: [
            Row(
              children: [
                Expanded(
                  child: DropdownButtonFormField<String>(
                    decoration: const InputDecoration(labelText: 'Location'),
                    items: locations.map((location) {
                      return DropdownMenuItem(
                          value: location, child: Text(location));
                    }).toList(),
                    onChanged: (value) => selectedLocation = value,
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: DropdownButtonFormField<String>(
                    decoration: const InputDecoration(labelText: 'Subject'),
                    items: subjects.map((subject) {
                      return DropdownMenuItem(
                          value: subject, child: Text(subject));
                    }).toList(),
                    onChanged: (value) => selectedSubject = value,
                  ),
                ),
              ],
            ),
            const SizedBox(height: 8),
            Row(
              children: [
                Expanded(
                  child: TextFormField(
                    decoration: const InputDecoration(labelText: 'Min Price'),
                    keyboardType: TextInputType.number,
                    onChanged: (value) => minPrice = double.tryParse(value),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: TextFormField(
                    decoration: const InputDecoration(labelText: 'Max Price'),
                    keyboardType: TextInputType.number,
                    onChanged: (value) => maxPrice = double.tryParse(value),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 8),
            ElevatedButton(
              onPressed: () => onFilterChanged(
                  selectedLocation, selectedSubject, minPrice, maxPrice),
              child: const Text('Apply Filters'),
            ),
          ],
        ),
      ),
    );
  }
}

class CourseCard extends StatelessWidget {
  final dynamic course;

  const CourseCard({Key? key, required this.course}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      elevation: 4,
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(course['courseName'],
                style:
                    const TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            Text('Tutor: ${course['tutorName']}'),
            Text('Rate: \$${course['hourlyRate']}'),
            Text('Location: ${course['location']}'),
            const Spacer(),
            ElevatedButton(
              onPressed: () {
                // Action for enrolling
              },
              child: const Text('Enroll'),
            ),
          ],
        ),
      ),
    );
  }
}
