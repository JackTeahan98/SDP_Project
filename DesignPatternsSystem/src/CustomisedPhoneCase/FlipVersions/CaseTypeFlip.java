package CustomisedPhoneCase.FlipVersions;

import CustomisedPhoneCase.Case;
import CustomisedPhoneCase.CaseBuilder;

public class CaseTypeFlip extends CaseBuilder {
    public Case createCase(String item) {
        if (item.equals("DESIGN")) {
            return new FlipDesign();
        } else if (item.equals("GRADIANT")) {
            return new FlipGradiant();
        } else if (item.equals("SOLIDCOLOUR")) {
            return new FlipSolidColour();
        } else if (item.equals("TRANSPARENT")) {
            return new FlipTransparent();
        } else return null;
    }
}
