import 'package:flutter/material.dart';
import 'package:kata/kata3/screens/home_screen.dart';
import 'package:kata/kata3/services/api_service.dart';

void main() {
  ApiService().getTodaysToons();
  runApp(const App());
}

class App extends StatelessWidget {
  const App({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: HomeScreen(),
    );
  }
}
