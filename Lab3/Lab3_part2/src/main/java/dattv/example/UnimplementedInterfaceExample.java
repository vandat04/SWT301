package dattv.example;

import java.util.logging.Logger;

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        Logger.getLogger("Drawing a circle");
    }
}