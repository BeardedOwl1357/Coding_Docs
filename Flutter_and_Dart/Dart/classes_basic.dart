class Rectangle {
  // Variables
  // Private variables are prefixed by _
  double _length = 0;
  double _breadth = 0;
  // Constructor
  // Default Constructor
  Rectangle() {
    print('Length = ${_length} \t Breadth = ${_breadth}');
  }

  // Named constructor
  Rectangle.overrided(this._breadth, this._length) {
    print('Length = ${_length} \t Breadth = ${_breadth}');
  }

  /* For functions with a single statement, use arrow functions */

  // Setters
  // By using the `set` keyword, we tell dart that the sole purpose of this method is to set a value.
  set length(double length) => this._length = length;
  set breadth(double breadth) => this._breadth = breadth;

  // Getters
  // By using the `get` keyword, we tell dart that the sole purpose of this method is to get a value and thus, we don't need to use `return` keyword.
  double get length => _length;
  double get breadth => _breadth;

  /* STATIC VARIABLES and METHODS */
  static String NAME = "Raj";
  static int AGE = 25;

  static void greet() => print("Hello Human");
}

void main() {
  // Calling default constructor
  Rectangle rect1 = Rectangle();
  // Calling named constructor
  Rectangle rect2 = Rectangle.overrided(5, 16);

  // Using setters
  rect1.length = 15;
  rect1.breadth = 25;
  rect2.length = 16;
  rect2.breadth = 26;

  // Accessing getters
  print("rect1 length = ${rect1.length} \t rect2 length = ${rect2.length}");
  print("rect1 length = ${rect1.breadth} \t rect2 length = ${rect2.breadth}");

  // Using static variables and methods
  print("Name = ${Rectangle.NAME} \t Age = ${Rectangle.AGE}");
  Rectangle.greet();
}
