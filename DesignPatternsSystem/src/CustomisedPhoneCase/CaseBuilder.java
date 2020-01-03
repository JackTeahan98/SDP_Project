package CustomisedPhoneCase;
import CustomisedPhoneCase.*;

public abstract class CaseBuilder {

    public abstract Case createCase(String item);

    public Case submitCase(String type) {
        Case phoneCase = createCase(type);
        System.out.println("--- Making a " + phoneCase.getName() + " ---");
        phoneCase.selection();
        phoneCase.qualityCheck();
        phoneCase.postToUser();
        return phoneCase;
    }
}