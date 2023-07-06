import 'dart:io';

void main() {
  // Learn to read user input and convert to integer
  // Forcefully Taking input (not handling the case where input can be null)
  // int age = int.parse(stdin
  //         .readLineSync()! // This gives String? by default however by using !, we are assuming that it is a String
  //     );
  print("Enter the age of human");
  // Handling case where input can be null
  String? userInput = stdin.readLineSync();
  while (userInput?.length == 0) {
    print("Provide an input");
    userInput = stdin.readLineSync();
  }
  int age = int.parse(userInput!);
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

  /* Switch Case */
  print("Enter Grade (A-F)");
  String grade = stdin.readLineSync()!;
  switch (grade) {
    case 'A':
      print("Superb");
      break; // break is optional
    case 'B':
      print("Good");
      break; // break is optional
    case 'C':
      print("Nice");
      break; // break is optional
    case 'D':
      print("Not Good");
      break; // break is optional
    default:
      print("Fail");
  }
}
