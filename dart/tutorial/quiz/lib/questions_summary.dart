import 'package:flutter/material.dart';

class QuestionsSummary extends StatelessWidget {
  const QuestionsSummary({super.key, required this.summaryData});

  final List<Map<String, Object>> summaryData;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 300,
      child: Container(
        margin: const EdgeInsets.all(40),
        child: SingleChildScrollView(
          child: Column(
            children: [
              ...summaryData.map(
                (data) {
                  return Row(
                    children: [
                      Text(((data['question_index'] as int) + 1).toString()),
                      Expanded(
                        child: Column(
                          children: [
                            Text(data['question'] as String),
                            Text(data['correct_answer'] as String),
                            Text(data['user_answer'] as String),
                          ],
                        ),
                      )
                    ],
                  );
                },
              ).toList(),
            ],
          ),
        ),
      ),
    );
  }
}
