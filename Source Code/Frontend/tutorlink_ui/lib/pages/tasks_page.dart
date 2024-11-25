import 'package:flutter/material.dart';
import '../fetch_data_page.dart';
class TasksPage extends StatefulWidget {
  @override
  _TasksPageState createState() => _TasksPageState();
}

class _TasksPageState extends State<TasksPage> {
  List<String> doneTasks = [];
  List<String> toDoTasks = ['To-Do Task 1', 'To-Do Task 2', 'To-Do Task 3', 'To-Do Task 4', 'To-Do Task 5'];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Tasks'),
        actions: [
          IconButton(
            icon: Icon(Icons.account_circle),
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
            Expanded(
              child: FetchDataPage(),
            ),
            SizedBox(height: 16),

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
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Text(
                              'Done Tasks',
                              style: TextStyle(
                                fontSize: 20,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                            IconButton(
                              icon: Icon(Icons.add),
                              onPressed: () {
                                setState(() {
                                  doneTasks.add('New Task to be Done');
                                });
                              },
                            ),
                          ],
                        ),
                        Expanded(
                          child: ListView.builder(
                            itemCount: doneTasks.length, // Number of done tasks
                            itemBuilder: (context, index) {
                              return ListTile(
                                leading: Icon(Icons.check_box_outline_blank),
                                title: Text(doneTasks[index]),
                              );
                            },
                          ),
                        ),
                      ],
                    ),
                  ),
                  SizedBox(width: 16),

                  // "To-Do Tasks" Column
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Text(
                              'To-Do',
                              style: TextStyle(
                                fontSize: 20,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                            IconButton(
                              icon: Icon(Icons.add),
                              onPressed: () {
                                setState(() {
                                  toDoTasks.add('New To-Do Task');
                                });
                              },
                            ),
                          ],
                        ),
                        Expanded(
                          child: ListView.builder(
                            itemCount: toDoTasks.length, // Number of to-do tasks
                            itemBuilder: (context, index) {
                              return ListTile(
                                leading: Icon(Icons.radio_button_unchecked),
                                title: Text(toDoTasks[index]),
                                onTap: () {
                                  setState(() {
                                    doneTasks.add(toDoTasks[index] + ' (Done)');
                                    toDoTasks.removeAt(index);
                                  });
                                },
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
