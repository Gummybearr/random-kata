import 'dart:math';

import 'package:flutter/material.dart';

class RandomDice extends StatefulWidget {
  const RandomDice({super.key});

  @override
  State<RandomDice> createState() {
    return _RandomDiceState();
  }
}

class _RandomDiceState extends State<RandomDice> {
  var number = 1;

  void rollDice() {
    setState(() {
      number = Random().nextInt(6) + 1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Image.asset(
          'assets/images/dice-$number.png',
          width: 200,
        ),
        TextButton(
          onPressed: rollDice,
          child: const Text('Roll Dice'),
        ),
      ],
    );
  }
}
