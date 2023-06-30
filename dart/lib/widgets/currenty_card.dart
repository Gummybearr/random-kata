import 'package:flutter/material.dart';

class CurrencyCard extends StatelessWidget {
  final String name, code, ammount;
  final IconData icon;
  final bool isInverted;

  const CurrencyCard(
      {super.key,
      required this.name,
      required this.code,
      required this.ammount,
      required this.icon,
      required this.isInverted});

  @override
  Widget build(BuildContext context) {
    return Container(
      clipBehavior: Clip.hardEdge,
      decoration: BoxDecoration(
          color: isInverted ? Colors.white : const Color(0xFF1F2123),
          borderRadius: BorderRadius.circular(25)),
      child: Padding(
        padding: const EdgeInsets.all(30),
        child:
            Row(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                name,
                style: TextStyle(
                  color: isInverted ? Colors.black : Colors.white,
                  fontSize: 32,
                  fontWeight: FontWeight.w600,
                ),
              ),
              const SizedBox(
                height: 15,
              ),
              Row(
                children: [
                  Text(
                    ammount,
                    style: TextStyle(
                        color: isInverted ? Colors.black : Colors.white,
                        fontSize: 20),
                  ),
                  const SizedBox(
                    width: 5,
                  ),
                  Text(
                    code,
                    style: TextStyle(
                        color: isInverted
                            ? Colors.black.withOpacity(0.8)
                            : Colors.white.withOpacity(0.8)),
                  ),
                ],
              ),
            ],
          ),
          Transform.scale(
            scale: 2.2,
            child: Transform.translate(
              offset: const Offset(8, 15),
              child: Icon(
                icon,
                color: isInverted ? Colors.black : Colors.white,
                size: 88,
              ),
            ),
          ),
        ]),
      ),
    );
  }
}
