package Bundle;
import Phones.Phone;

public class PhoneScreenProtector extends PhoneDeals {
    PhoneBundle bundle;

    public String getDescription() {
        return bundle.getDescription() + "\nAdd-On: Phones.Phone Screen Protector Added ---> $10";
    }

    public PhoneScreenProtector(PhoneBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public double cost(Phone phone) {
        return bundle.cost(phone) + 10;
    }

}
