import 'dart:io';

void main() {
  int age = (int) stdin.readLineSync();
  // With curly braces
  if (age >= 18 && age <= 25) {
    print("Young Adult");
  } else if (age > 25) {
    print("Experienced Adult");
  } else {
    print("Child");
  }

  // Same logic without curly braces
  if (age >= 18 && age <= 25)
    print("Young Adult");
  else if (age > 25)
    print("Experienced Adult");
  else
    print("Child");

  // Ternary Operator
  // condition ? <true> : <false>
  print("Is adult? \t ${age >= 18 ? "Yes" : "No"}");
}
