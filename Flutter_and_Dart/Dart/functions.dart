int add(int x, int y) {
  return x + y;
}

String displayFullName(String firstName, String lastName) {
  return '${firstName} ${lastName}';
}

// Tuples
(int, String, bool) getMultiple() {
  return (10, "Hello", false);
}

// Named arguments
void printDetails({required String name, required int age, int? salary}) {
  print('Name : ${name}');
  print('Age : ${age}');
  print(
      'Salary : ${salary ?? 0}'); // This statement means "if salary is not null, print salary else print 0"
}

// Named Records
({int age, String name, bool isAdult}) getNamedMultiple() {
  int age = 10;
  return (age: age, name: "John", isAdult: age >= 18 ? true : false);
}

void main() {
  print(add(5, 2));
  print(displayFullName("bearded", "owl"));
  (int, String, bool) temp = getMultiple();
  print('All values in temp : ${temp}');
  print('1st value in temp : ${temp.$1}');
  print('2nd value in temp : ${temp.$2}');
  print('3rd value in temp : ${temp.$3}');

  printDetails(name: 'John', age: 25);
  printDetails(name: 'John', age: 25, salary: 1500);

  final stuff = getNamedMultiple();
  print(stuff.runtimeType);
  print(stuff.age);
  print(stuff.name);
  print(stuff.isAdult);
}
