package Bundle;
import Phones.Phone;

public class PhoneInsurance extends PhoneDeals {
    PhoneBundle bundle;

    public String getDescription() {
        return bundle.getDescription() + "\nAdd-On: Phones.Phone Insurance Added ---> $55";
    }

    public PhoneInsurance(PhoneBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public double cost(Phone phone) {
        return bundle.cost(phone) + 55;
    }

}
