package DetailsPrinter;

import javax.swing.*;

public class StateHasPassword implements State {
    Printer printer;

    public StateHasPassword(Printer printer) {
        this.printer = printer;
    }

    public void enterPassword() { JOptionPane.showMessageDialog(null,"You have already entered your password!");}

    public void rejectPassword()
    {
        JOptionPane.showMessageDialog(null,"Password returned");
        printer.setState(printer.getStateHasNoPassword());
    }

    public void selectPassword(String level, String type, int balance)
    {
        JOptionPane.showMessageDialog(null,"You have selected...");
        printer.setState(printer.getStatePrinting());
    }

    public void print(String level, String type, int balance) {
        JOptionPane.showMessageDialog(null,"No details printed...");
    }

    public String toString() {
        return "Waiting for selection";
    }
}
