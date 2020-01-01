public class PhoneCase extends PhoneDeals {
    PhoneBundle bundle;

    public String getDescription() {
        return bundle.getDescription() + "\nAdd-On: Phone Case Added ---> $15";
    }

    @Override
    public double cost(Phone phone) {
        return bundle.cost(phone) + 15;
    }

    public PhoneCase(PhoneBundle bundle) {
        this.bundle = bundle;
    }




}
