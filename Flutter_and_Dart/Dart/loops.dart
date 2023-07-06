void main() {
  // For loop
  for (int i = 0; i < 5; ++i) print("Hello ${i}");

  // While loop
  int i = 5;
  while (i >= 0) {
    print("Mellow ${i}");
    i -= 1;
  }

  // Do-While loop
  do {
    print("Do while ${i}");
    i += 1;
  } while (i != i); // i!=i will always be false

  // Continue keyword. Print first 10 Natural numbers but skip even numbers
  for (int num = 1; num <= 10; ++num) {
    if (num % 2 == 0) continue;
    print("Number = ${num}");
  }

  // Break : Break when we find 7
  for (int num = 1; num <= 10; ++num) {
    if (num == 7) break;
    print("Break Number = ${num}");
  }
}
