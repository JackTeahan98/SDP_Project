package CustomisedPhoneCase.BackVersions;
import CustomisedPhoneCase.CaseBuilder;
import CustomisedPhoneCase.*;

public class CaseTypeBack extends CaseBuilder {

    public Case createCase(String item) {
        if (item.equals("DESIGN")) {
            return new BackDesign();
        } else if (item.equals("GRADIANT")) {
            return new BackGradiant();
        } else if (item.equals("SOLIDCOLOUR")) {
            return new BackSolidColour();
        } else if (item.equals("TRANSPARENT")) {
            return new BackTransparent();
        } else return null;
    }
}
