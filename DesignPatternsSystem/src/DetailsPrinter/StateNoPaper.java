package DetailsPrinter;

import DetailsPrinter.Printer;
import DetailsPrinter.State;

public class StateNoPaper implements State {
    Printer printer;

    public StateNoPaper(Printer printer) {
        this.printer = printer;
    }

    public void enterPassword() {
        System.out.println("Cannot enter password, no printing paper");
    }

    public void rejectPassword() {
        System.out.println("You cannot reject password as you havent entered one");
    }

    public void selectPassword(String level, String type, int balance) {
        System.out.println("You have selected but there is no paper");
    }

    public void print(String level, String type, int balance) {
        System.out.println("No details printed");
    }

    public String toString() {
        return "No paper!";
    }


}
