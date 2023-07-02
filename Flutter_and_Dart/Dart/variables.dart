void main() {
  // Static Typing
  int a = 1;
  double b = 2.53;
  String text = "Hello";

  var x;
  x = "This";
  print(x);
  x = 4;
  print(x);

  // Finding absolute values of numbers
  print((-5).abs()); // Int
  print((-5.123).abs()); // Double

  // Multiline String
  String multi_line = """
This is good
Very good
""";
  print(multi_line);
}
