package dattv.example;

import java.util.logging.Logger;

class Printer {
    void print() {
        Logger.getLogger("Generating report...");
    }
}

class Report {
    private final Printer printer = new Printer(); // tightly coupled

    void generate() {
        printer.print();
    }
}
