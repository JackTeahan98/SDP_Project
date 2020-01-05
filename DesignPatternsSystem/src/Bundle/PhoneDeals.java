package Bundle;

import Phones.Phone;

public abstract class PhoneDeals extends PhoneBundle{
    public abstract String getDescription();

    @Override
    public abstract double cost(Phone phone) ;
}
