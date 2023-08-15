import 'package:flutter/material.dart';

import 'linear_gradient_container.dart';

void main() {
  runApp(MaterialApp(
    title: 'Flutter Tutorial',
    home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter Tutorial'),
        ),
        body: LinearGradientContainer(
          color1: Colors.blue,
          color2: Colors.red,
        )),
  ));
}
