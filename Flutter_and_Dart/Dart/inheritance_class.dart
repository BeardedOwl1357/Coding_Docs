class Vehicle {
  int _speed = 0;
  void accelerate() => _speed += 10;

  void deaccelerate() => _speed -= 10;

  void applyBrake() {
    while (_speed > 0) this.deaccelerate();
  }

  int get speed => _speed;
  void set speed(int speed) => this._speed = speed;
}

class Car extends Vehicle {
  int _numberOfWheels = 4;
  double _steeringAngleDegrees = 90;

  // The @override annotation is just like Java : program can compile without it but it is still recommended to use it so that the IDE can help detect any errors
  @override
  void accelerate() => _speed += 15;

  @override
  void deaccelerate() => _speed -= 15;

  void steerRight() => _steeringAngleDegrees += 2;
  void steerLeft() => _steeringAngleDegrees += 2;

  int get numberOfWheels => _numberOfWheels;
  double get steeringAngleDegrees => _steeringAngleDegrees;
}

void main() {
  // Polymorphism
  Vehicle c = Car();
  print(c._speed);
  c.speed = 20;
  print(c.speed);

  // Type casting
  print((c as Car)._steeringAngleDegrees);
  (c as Car).steerRight();
  print((c as Car)._steeringAngleDegrees);
}
