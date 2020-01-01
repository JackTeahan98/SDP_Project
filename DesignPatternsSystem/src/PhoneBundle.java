public abstract class PhoneBundle {
    String description ="Empty Bundle";

    public String getDescription(){
        return description;
    }

    public abstract double cost(Phone phone);



}
