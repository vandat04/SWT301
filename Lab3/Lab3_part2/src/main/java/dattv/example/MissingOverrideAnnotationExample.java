package dattv.example;

import java.util.logging.Logger;

class Animal {
    void speak() {
        Logger.getLogger("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        Logger.getLogger("Dog barks");
    }
}
