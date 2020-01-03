package DetailsPrinter;

public class StateHasNoPassword implements State {
    Printer printer;

    public StateHasNoPassword(Printer printer) {
        this.printer = printer;
    }

    public void enterPassword() {
        System.out.println("You have entered your password");
        printer.setState(printer.getStateHasPassword());
    }

    public void rejectPassword() {
        System.out.println("You haven't entered a password");
    }

    public void selectPassword(String level, String type, int balance) {
        System.out.println("You have tried to select, but no password detected");
    }

    public void print(String level, String type, int balance) {System.out.println("You need to enter Password first!");
    }

    public String toString() {
        return "waiting for password";
    }
}
