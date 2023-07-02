void main() {
  // If the below is uncommented, this will give an error as a non-nullable variable cannot have `null` value
  // String x
  String? x;
  print(x); // Has null value

  x = "Lol";
  print(x); // Now has non-null value

  x = null; // We were able to assign null value
  print(x);

  /*
    * Let's try to get the length of a variable which is assigned null
    * For this, we need to use `?` operator while accessing the `length` value 
  */
  print(
      "Length of ${x} = ${x?.length}"); // If x is not null, return length else return null
  print(
      "Length of ${x} = ${x?.length ?? 0}"); // If x is not null, return length else return 0
}
