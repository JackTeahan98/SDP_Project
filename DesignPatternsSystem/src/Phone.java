import java.util.ArrayList;

public class Phone {
    private String phoneName;

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public int getPriceCost() {
        return priceCost;
    }

    public void setPriceCost(int priceCost) {
        this.priceCost = priceCost;
    }

    public int getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(int priceRetail) {
        this.priceRetail = priceRetail;
    }

    public String getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(String dateRemoved) {
        this.dateRemoved = dateRemoved;

        dateChanged();
    }

    public void dateChanged(){ notifyObservers(); }


    public void registerObserver(Observer o)
    {
        observers.add(o);
    }


    public void removeObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if (i >= 0)
        {
            observers.remove(i);
        }
    }

    public void notifyObservers()
    {
        for (int i = 0; i < observers.size(); i++)
        {
            Observer observer = (Observer)observers.get(i);
            observer.update(dateRemoved);
        }
    }



    private String phoneBrand;

    public Phone(int phoneID, String phoneName, String phoneBrand, int priceCost, int priceRetail, String dateRemoved, boolean paidOff, String paymentType, boolean initialPayment) {
        this.phoneID = phoneID;
        this.phoneName = phoneName;
        this.phoneBrand = phoneBrand;
        this.priceCost = priceCost;
        this.priceRetail = priceRetail;
        this.dateRemoved = dateRemoved;
        this.paidOff = paidOff;
        this.paymentType = paymentType;
        this.initialPayment= initialPayment;

    }

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }
    private ArrayList observers;
    private int phoneID;
    private int priceCost;
    private int priceRetail;
    private String dateRemoved;
    private boolean paidOff;

    public boolean isInitialPayment() {
        return initialPayment;
    }

    public void setInitialPayment(boolean initialPayment) {
        this.initialPayment = initialPayment;
    }

    private boolean initialPayment;

    public boolean isPaidOff() {
        return paidOff;
    }

    public void setPaidOff(boolean paidOff) {
        this.paidOff = paidOff;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    private String paymentType;



}
