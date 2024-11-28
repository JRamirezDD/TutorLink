import 'package:flutter/material.dart';
import 'package:tryflutter/fetch_data_page.dart';

class SubscriptionPage extends StatefulWidget {
  const SubscriptionPage({super.key});

  @override
  _SubscriptionPageState createState() => _SubscriptionPageState();
}

class _SubscriptionPageState extends State<SubscriptionPage> {
  bool isCreditCardSelected = false;

  final TextEditingController _cardNumberController = TextEditingController();
  final TextEditingController _expiryDateController = TextEditingController();
  final TextEditingController _cvvController = TextEditingController();

  @override
  void dispose() {
    _cardNumberController.dispose();
    _expiryDateController.dispose();
    _cvvController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: const Text('Subscription Page'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const Text(
                'Gold Subscription',
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                ),
              ),
              const SizedBox(height: 10),
              const Text(
                'As a Gold Subscriber, you will be able to:',
                style: TextStyle(fontSize: 16),
              ),
              const SizedBox(height: 10),
              const ListTile(
                leading: Icon(Icons.message, color: Colors.blue),
                title: Text('Message unlimited tutors'),
              ),
              const ListTile(
                leading: Icon(Icons.search, color: Colors.blue),
                title: Text('Search unlimited tutors'),
              ),
              const SizedBox(height: 20),
              const Text(
                'Choose Payment Method',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                ),
              ),
              const SizedBox(height: 10),
              ListTile(
                leading: Radio<bool>(
                  value: true,
                  groupValue: isCreditCardSelected,
                  onChanged: (value) {
                    setState(() {
                      isCreditCardSelected = value!;
                    });
                  },
                ),
                title: const Text('Credit Card'),
              ),
              ListTile(
                leading: Radio<bool>(
                  value: false,
                  groupValue: isCreditCardSelected,
                  onChanged: (value) {
                    setState(() {
                      isCreditCardSelected = !value!;
                    });
                  },
                ),
                title: const Text('Apple Pay'),
              ),
              const SizedBox(height: 20),
              if (isCreditCardSelected)
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text(
                      'Enter Credit Card Details',
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    const SizedBox(height: 10),
                    TextField(
                      controller: _cardNumberController,
                      decoration: const InputDecoration(
                        labelText: 'Card Number',
                        border: OutlineInputBorder(),
                      ),
                      keyboardType: TextInputType.number,
                    ),
                    const SizedBox(height: 10),
                    TextField(
                      controller: _expiryDateController,
                      decoration: const InputDecoration(
                        labelText: 'Expiry Date (MM/YY)',
                        border: OutlineInputBorder(),
                      ),
                      keyboardType: TextInputType.datetime,
                    ),
                    const SizedBox(height: 10),
                    TextField(
                      controller: _cvvController,
                      decoration: const InputDecoration(
                        labelText: 'CVV',
                        border: OutlineInputBorder(),
                      ),
                      obscureText: true,
                      keyboardType: TextInputType.number,
                    ),
                  ],
                ),
              const SizedBox(height: 20),
              Center(
                child: ElevatedButton(
                  onPressed: () {
                    if (isCreditCardSelected) {
                      // Handle credit card payment
                      if (_cardNumberController.text.isNotEmpty &&
                          _expiryDateController.text.isNotEmpty &&
                          _cvvController.text.isNotEmpty) {
                        // Implement logic to process the credit card here
                        ScaffoldMessenger.of(context).showSnackBar(
                          const SnackBar(
                            content: Text('Processing credit card payment...'),
                          ),
                        );
                      } else {
                        ScaffoldMessenger.of(context).showSnackBar(
                          const SnackBar(
                            content: Text('Please enter all card details'),
                          ),
                        );
                      }
                    } else {
                      // Handle Apple Pay
                      ScaffoldMessenger.of(context).showSnackBar(
                        const SnackBar(
                          content: Text('Processing Apple Pay payment...'),
                        ),
                      );
                    }
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.blue,
                    padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 15),
                  ),
                  child: const Text('Subscribe to Gold Membership'),
                ),
              ),
              const SizedBox(height: 20),
              Center(
                child: ElevatedButton(
                  onPressed: () {
                    // Navigate back to Tutor Home Page
                    Navigator.pop(context);
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.grey,
                  ),
                  child: const Text('Go Back to Tutor Home Page'),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
