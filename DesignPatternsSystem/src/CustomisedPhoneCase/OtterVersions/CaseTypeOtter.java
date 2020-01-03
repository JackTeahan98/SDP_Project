package CustomisedPhoneCase.OtterVersions;

import CustomisedPhoneCase.Case;
import CustomisedPhoneCase.CaseBuilder;

public class CaseTypeOtter extends CaseBuilder {
    public Case createCase(String item) {
        if (item.equals("DESIGN")) {
            return new OtterDesign();
        } else if (item.equals("GRADIANT")) {
            return new OtterGradiant();
        } else if (item.equals("SOLIDCOLOUR")) {
            return new OtterSolidColour();
        } else if (item.equals("TRANSPARENT")) {
            return new OtterTransparent();
        } else return null;
    }
}
