package DetailsPrinter;

public class Printer {
    State stateHasNoPassword;
    State stateHasPassword;
    State stateNoPaper;
    State statePrinting;

    State state = stateNoPaper;
    int count = 0;

    public Printer(int paperCount){
        stateNoPaper = new StateNoPaper(this);
        statePrinting = new StatePrinting(this);
        stateHasPassword = new StateHasPassword(this);
        stateHasNoPassword = new StateHasNoPassword(this);

        this.count = paperCount;
        if (paperCount > 0) {
            state = stateHasNoPassword;
        }
    }

    public void enterPassword() {
        state.enterPassword();
    }

    public void rejectPassword() {

        state.rejectPassword();
    }

    public void selectPassword(String level, String type, int balance) {
        state.selectPassword(level,type,balance);

    }

    public void print(String level, String type, int balance) {
        state.print(level,type,balance);

    }

    void setState(State state) {
        this.state = state;
    }

    void releasePaper() {
        System.out.println("Printing your Details");
        if (count != 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count = count;
        state = stateHasNoPassword;
    }

    public State getState() {
        return state;
    }

    public State getStateNoPaper() {
        return stateNoPaper;
    }

    public State getStateHasNoPassword() {
        return stateHasNoPassword;
    }

    public State getStateHasPassword() {
        return stateHasPassword;
    }

    public State getStatePrinting() {
        return statePrinting;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nPrinter Details:");
        result.append("\nPaper in Machine: " + count);
        result.append("\n");
        return result.toString();
    }
}
