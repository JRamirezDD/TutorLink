import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class PaymentHistoryPage extends StatelessWidget {
  // Sample list of payments for illustration
  final List<Map<String, String>> payments = [
    {'date': '2024-11-01', 'amount': '\$100', 'status': 'Paid'},
    {'date': '2024-10-25', 'amount': '\$80', 'status': 'Paid'},
    {'date': '2024-10-10', 'amount': '\$50', 'status': 'Pending'},
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Payment History'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Adding the FetchDataPage widget at the top of the page
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Text(
              'Additional Financial Data:',
              style: TextStyle(
                fontSize: 16,
                fontWeight: FontWeight.bold,
                color: Colors.grey[700],
              ),
            ),
          ),
          Expanded(
            child: FetchDataPage(),
          ),
          SizedBox(height: 16),

          // Payment History Section
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Text(
              'Your Payment History:',
              style: TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          Expanded(
            flex: 2, // Giving more space to the payment list
            child: ListView.builder(
              itemCount: payments.length,
              itemBuilder: (context, index) {
                return Card(
                  margin: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                  child: ListTile(
                    title: Text('Date: ${payments[index]['date']}'),
                    subtitle: Text('Amount: ${payments[index]['amount']}'),
                    trailing: Text('Status: ${payments[index]['status']}'),
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
