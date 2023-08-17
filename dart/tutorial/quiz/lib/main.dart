import 'package:flutter/material.dart';
import 'package:quiz/quiz.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        body: Container(
          decoration: const BoxDecoration(
            gradient: LinearGradient(
              colors: [
                Color.fromARGB(255, 78, 13, 151),
                Colors.purple,
              ],
            ),
          ),
          child: const Quiz(),
        ),
      ),
    ),
  );
}
