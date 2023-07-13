mixin jumping {
  double jumpHeight = 5.5;
  void jump() => print("Jumping");
}

mixin breathing {
  double oxygenLevel = 50;
  void inhale() {
    print("Inhaling");
    oxygenLevel += 5;
  }

  void exhale() {
    print("Exhaling");
    oxygenLevel -= 5;
  }
}

class Character with jumping, breathing {
  double health = 100;
  void displayStats() {
    print("Health = ${health}");
    print("Jumping capacity = ${jumpHeight}");
    print("Oxygen Level = ${oxygenLevel}");
  }
}

void main() {
  Character mainCharacter = Character();
  mainCharacter.displayStats();
  mainCharacter.exhale();
  mainCharacter.displayStats();
}
