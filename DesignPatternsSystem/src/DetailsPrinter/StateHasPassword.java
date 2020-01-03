package DetailsPrinter;

public class StateHasPassword implements State {
    Printer printer;

    public StateHasPassword(Printer printer) {
        this.printer = printer;
    }

    public void enterPassword() {System.out.println("You have already entered your password!");}

    public void rejectPassword()
    {
        System.out.println("Password returned");
        printer.setState(printer.getStateHasNoPassword());
    }

    public void selectPassword(String level, String type, int balance)
    {
        System.out.println("You have selected...");
        printer.setState(printer.getStatePrinting());
    }

    public void print(String level, String type, int balance) {
        System.out.println("No details printed...");
    }

    public String toString() {
        return "Waiting for selection";
    }
}
