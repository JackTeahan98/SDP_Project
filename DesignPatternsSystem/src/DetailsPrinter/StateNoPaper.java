package DetailsPrinter;

import DetailsPrinter.Printer;
import DetailsPrinter.State;

import javax.swing.*;

public class StateNoPaper implements State {
    Printer printer;

    public StateNoPaper(Printer printer) {
        this.printer = printer;
    }

    public void enterPassword() {
        JOptionPane.showMessageDialog(null,"Cannot enter password, no printing paper");
    }

    public void rejectPassword() {
        JOptionPane.showMessageDialog(null,"You cannot reject password as you havent entered one");
    }

    public void selectPassword(String level, String type, int balance) {
        JOptionPane.showMessageDialog(null,"You have selected but there is no paper");
    }

    public void print(String level, String type, int balance) {
        JOptionPane.showMessageDialog(null,"No details printed");
    }

    public String toString() {
        return "No paper!";
    }


}
