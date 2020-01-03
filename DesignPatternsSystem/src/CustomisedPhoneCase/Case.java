package CustomisedPhoneCase;

import java.util.ArrayList;

public abstract class Case {
    public String name;
    public String type;
    public ArrayList designType = new ArrayList();

    void selection() {
        System.out.println("Your Phone case: " + name);
        System.out.println("Creating Mold");
        System.out.println("Setting...: ");
        for (int i = 0; i < designType.size(); i++) {
            System.out.println("   " + designType.get(i));
        }
    }

    void qualityCheck() {
        System.out.println("Checking Quality: ");
    }

    void postToUser() {
        System.out.println("Posting to User: ");
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(type + "\n");
        for (int i = 0; i < designType.size(); i++) {
            display.append((String )designType.get(i) + "\n");
        }
        return display.toString();
    }
}



