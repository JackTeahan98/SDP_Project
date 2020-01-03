package DetailsPrinter;

import javax.swing.*;

public class StateHasNoPassword implements State {
    Printer printer;

    public StateHasNoPassword(Printer printer) {
        this.printer = printer;
    }

    public void enterPassword() {

        JOptionPane.showMessageDialog(null,"You have entered your password");
        printer.setState(printer.getStateHasPassword());
    }

    public void rejectPassword() {
        JOptionPane.showMessageDialog(null,"You haven't entered a password");
    }

    public void selectPassword(String level, String type, int balance) {
        JOptionPane.showMessageDialog(null,"You have tried to select, but no password detected");
    }

    public void print(String level, String type, int balance) { JOptionPane.showMessageDialog(null,"You need to enter Password first!");
    }

    public String toString() {
        return "waiting for password";
    }
}
