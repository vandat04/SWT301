package dattv.example;

import java.util.logging.Logger;

interface Shape {
    void draw();
    void resize();
}

abstract class Square implements Shape {
    public void draw() {
        Logger.getLogger("Drawing square");
    }

}
