import 'dart:math';

import 'package:dice/random_dice.dart';
import 'package:flutter/material.dart';

class LinearGradientContainer extends StatelessWidget {
  const LinearGradientContainer(
      {required this.color1, required this.color2, super.key});

  final Color color1;
  final Color color2;

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        gradient: LinearGradient(colors: [
          color1,
          color2,
        ]),
      ),
      child: const Center(
        child: Column(
          children: [
            RandomDice(),
          ],
        ),
      ),
    );
  }
}
