class ImmutableRectangle {
  // To make a class immutable, make each variable final
  final double length;
  final double breadth;

  // Make only one constructor
  // Named parameters can only be used on public variables (`_` not allowed)
  ImmutableRectangle({required this.length, required this.breadth});

  // Positional parameters can be used too
  ImmutableRectangle.positional(this.length, this.breadth);
}

void main() {
  ImmutableRectangle rect1 = ImmutableRectangle(length: 10, breadth: 20);
  // rect1.breadth = 10; // Gives error as we cannot change its value once it is assigned
  print("length = ${rect1.length} \t breadth = ${rect1.breadth}");

  // Using positional constructor

  ImmutableRectangle rect2 = ImmutableRectangle.positional(16, 20);
  // rect2.breadth = 16; // Gives error as we cannot change its value once it is assigned
  print("length = ${rect2.length} \t breadth = ${rect2.breadth}");
}
