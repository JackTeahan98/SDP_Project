package Bundle;
import Phones.Phone;

public abstract class PhoneBundle {
    public String description ="Empty Bundle";

    public String getDescription(){
        return description;
    }

    public abstract double cost(Phone phone);
}
