package dattv.example;

import java.util.logging.Logger;

class User {
    private String name;
    private int age;

    public void display() {
        Logger.getLogger("Name: " + name + ", Age: " + age);
    }
}
