import 'package:flutter/material.dart';
import '../fetch_data_page.dart';

class TasksPage extends StatefulWidget {
  const TasksPage({super.key});

  @override
  _TasksPageState createState() => _TasksPageState();
}

class _TasksPageState extends State<TasksPage> {
  List<String> doneTasks = [];
  List<Map<String, String>> toDoTasks = [
    {'title': 'Session with John', 'time': '10:00 AM - 11:00 AM'},
    {'title': 'Session with Jane', 'time': '1:00 PM - 2:00 PM'},
    {'title': 'Session with Sam', 'time': '3:00 PM - 4:00 PM'},
  ];

  final TextEditingController _taskController = TextEditingController();
  final TextEditingController _timeController = TextEditingController();

  @override
  void dispose() {
    _taskController.dispose();
    _timeController.dispose();
    super.dispose();
  }

  void _addTask() {
    if (_taskController.text.isNotEmpty && _timeController.text.isNotEmpty) {
      setState(() {
        toDoTasks.add({'title': _taskController.text, 'time': _timeController.text});
      });
      _taskController.clear();
      _timeController.clear();
      Navigator.of(context).pop();
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Time Management'),
        backgroundColor: Colors.blueAccent,
        actions: [
          IconButton(
            icon: const Icon(Icons.account_circle),
            onPressed: () {
              Navigator.pushNamed(context, '/userSettings');
            },
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            // Fetch Data Widget added at the top to display important data
            const Expanded(
              child: FetchDataPage(),
            ),
            const SizedBox(height: 16),

            // Row to display "Done Tasks" and "To-Do Tasks" lists
            Expanded(
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  // "Done Tasks" Column
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Container(
                          padding: const EdgeInsets.symmetric(vertical: 8),
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(8),
                            color: Colors.deepPurple.withOpacity(0.1),
                          ),
                          child: const Center(
                            child: Text(
                              'Completed Sessions',
                              style: TextStyle(
                                fontSize: 20,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ),
                        const SizedBox(height: 10),
                        Expanded(
                          child: ListView.builder(
                            itemCount: doneTasks.length, // Number of done tasks
                            itemBuilder: (context, index) {
                              return Card(
                                color: Colors.green.shade50,
                                elevation: 3,
                                margin: const EdgeInsets.symmetric(vertical: 8),
                                child: ListTile(
                                  leading: const Icon(Icons.check_circle, color: Colors.green),
                                  title: Text(
                                    doneTasks[index],
                                    style: const TextStyle(fontSize: 16, fontWeight: FontWeight.w500),
                                  ),
                                ),
                              );
                            },
                          ),
                        ),
                      ],
                    ),
                  ),
                  const SizedBox(width: 16),

                  // "To-Do Tasks" Column
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Container(
                              padding: const EdgeInsets.symmetric(vertical: 8),
                              decoration: BoxDecoration(
                                borderRadius: BorderRadius.circular(8),
                                color: Colors.blueAccent.withOpacity(0.1),
                              ),
                              child: const Center(
                                child: Text(
                                  'Upcoming Sessions',
                                  style: TextStyle(
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                              ),
                            ),
                            IconButton(
                              icon: const Icon(Icons.add, color: Colors.blueAccent),
                              onPressed: () {
                                showDialog(
                                  context: context,
                                  builder: (BuildContext context) {
                                    return AlertDialog(
                                      shape: RoundedRectangleBorder(
                                        borderRadius: BorderRadius.circular(15.0),
                                      ),
                                      title: const Text('Add New Task'),
                                      content: Column(
                                        mainAxisSize: MainAxisSize.min,
                                        children: [
                                          TextField(
                                            controller: _taskController,
                                            decoration: const InputDecoration(
                                              labelText: 'Task',
                                              border: OutlineInputBorder(),
                                            ),
                                          ),
                                          const SizedBox(height: 10),
                                          TextField(
                                            controller: _timeController,
                                            decoration: const InputDecoration(
                                              labelText: 'Time',
                                              border: OutlineInputBorder(),
                                            ),
                                          ),
                                        ],
                                      ),
                                      actions: [
                                        TextButton(
                                          onPressed: () {
                                            Navigator.of(context).pop();
                                          },
                                          child: const Text('Cancel'),
                                        ),
                                        ElevatedButton(
                                          style: ElevatedButton.styleFrom(
                                            backgroundColor: Colors.blueAccent,
                                          ),
                                          onPressed: _addTask,
                                          child: const Text('Add'),
                                        ),
                                      ],
                                    );
                                  },
                                );
                              },
                            ),
                          ],
                        ),
                        const SizedBox(height: 10),
                        Expanded(
                          child: ListView.builder(
                            itemCount: toDoTasks.length, // Number of to-do tasks
                            itemBuilder: (context, index) {
                              return Card(
                                color: Colors.blue.shade50,
                                elevation: 3,
                                margin: const EdgeInsets.symmetric(vertical: 8),
                                child: CheckboxListTile(
                                  controlAffinity: ListTileControlAffinity.leading,
                                  activeColor: Colors.blueAccent,
                                  value: false,
                                  onChanged: (bool? value) {
                                    if (value == true) {
                                      setState(() {
                                        doneTasks.add('${toDoTasks[index]['title']} (Completed)');
                                        toDoTasks.removeAt(index);
                                      });
                                    }
                                  },
                                  title: Text(
                                    toDoTasks[index]['title']!,
                                    style: const TextStyle(fontSize: 16, fontWeight: FontWeight.w500),
                                  ),
                                  subtitle: Text(
                                    toDoTasks[index]['time']!,
                                    style: const TextStyle(color: Colors.black54),
                                  ),
                                ),
                              );
                            },
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
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
        currentIndex: 2, // Set this dynamically as per requirement
        selectedItemColor: Colors.blueAccent,
        onTap: (int index) {
          // Handle bottom bar navigation here
          switch (index) {
            case 0:
              Navigator.pushNamed(context, '/tutorHome');
              break;
            case 1:
              Navigator.pushNamed(context, '/messagesPage');
              break;
            case 2:
              // Stay on the current page
              break;
          }
        },
      ),
    );
  }
}
