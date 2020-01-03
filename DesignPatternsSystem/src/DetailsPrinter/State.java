package DetailsPrinter;

public interface State {

    public void enterPassword();
    public void rejectPassword();
    public void selectPassword(String level, String type, int balance);
    public void print(String level, String type, int balance);
}
