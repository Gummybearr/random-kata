import 'package:flutter/material.dart';
import 'package:quiz/questions_summary.dart';

import 'data/questions.dart';

class ResultsScreen extends StatelessWidget {
  const ResultsScreen({super.key, required this.chosenAnswers});

  final List<String> chosenAnswers;

  List<Map<String, Object>> getSummaryData() {
    final summaryData = <Map<String, Object>>[];

    for (var i = 0; i < chosenAnswers.length; i++) {
      final question = questions[i];
      final answer = chosenAnswers[i];

      summaryData.add({
        'question_index': i,
        'question': question.text,
        'correct_answer': question.answers[0], // first answer is always correct
        'user_answer': answer,
      });
    }

    return summaryData;
  }

  @override
  Widget build(BuildContext context) {
    final summaryData = getSummaryData();
    final numTotalQuestions = questions.length;
    final numCorrectAnswers = summaryData.where((data) {
      return data['correct_answer'] == data['user_answer'];
    }).length;

    return SizedBox(
      width: double.infinity,
      child: Container(
        margin: const EdgeInsets.all(40),
        child: Column(
          children: [
            Text(
                "You answered $numCorrectAnswers out of $numTotalQuestions questions correctly!"),
            const SizedBox(height: 20),
            QuestionsSummary(summaryData: getSummaryData()),
            const SizedBox(height: 20),
            TextButton(onPressed: () {}, child: const Text("Restart Quiz")),
          ],
        ),
      ),
    );
  }
}
