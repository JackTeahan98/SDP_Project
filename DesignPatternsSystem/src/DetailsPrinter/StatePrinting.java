package DetailsPrinter;

import DetailsPrinter.Printer;
import DetailsPrinter.State;

import javax.swing.*;

public class StatePrinting implements State {
    Printer printer;

    public StatePrinting(Printer printer) {this.printer = printer;}

    public void enterPassword() {
        System.out.println("Printing already in process, have patience");
    }

    public void rejectPassword() {
        System.out.println("Cannot reject password now, printing in process");
    }

    public void selectPassword(String level, String type, int balance) {
        System.out.println("You have just selected!");
    }

    public void print(String level, String type, int balance) {
        printer.releasePaper();
        if (printer.getCount() > 0) {
            JOptionPane.showMessageDialog(null,"------------ Details of User ------------\n"+
                    "Level: "+level+"\n"+
                    "Type: "+type+"\n"+
                    "Balance: "+balance);
            printer.setState(printer.getStateHasNoPassword());
        } else {
            System.out.println("No paper");
            printer.setState(printer.getStateNoPaper());
        }
    }

    public String toString() {
        return "Printing Details";
    }


}


