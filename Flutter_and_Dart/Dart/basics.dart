import 'dart:io';

void main() {
  stdout.writeln("Enter your name");
  String name = stdin.readLineSync().toString();
  // Writing via print
  print("Lmao " + name);
  // Writing via stdout
  stdout.writeln("Lmao " + name);
  // Something like Bash I guess
  print("Lmao $name");
  // Printing same text `n` times
  int n = 5;
  print("hello " * n);
}
