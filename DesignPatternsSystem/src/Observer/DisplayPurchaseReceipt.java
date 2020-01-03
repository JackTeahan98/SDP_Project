package Observer;

import Phones.Phone;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DisplayPurchaseReceipt implements Observer{
    private Subject phoneData;
    private Phone phone;


    public DisplayPurchaseReceipt(Subject phoneData) {
        this.phoneData = phoneData;
        phoneData.registerObserver(this);
    }


    @Override
    public void update(Phone phone) {
        this.phone = phone;
        printReceipt(phone);
    }

    public void printReceipt(Phone phone) {
        if (phone.getPaymentType() == "LumpSumPayment" || phone.getPaymentType() == "InstallementPlanCOMPLETE") {
            JOptionPane.showMessageDialog(null, "****** Phone Receipt *****\n\n" +
                    "Phone: " + phone.getPhoneName() + " - " + phone.getPhoneBrand() + "\n" +
                    "Price: $" + phone.getPriceRetail() + "\n" +
                    "Payment Type: " + phone.getPaymentType() + "\n" +
                    "Purchase Date: " + phone.getDateRemoved());
        }

        else
            {
                Date date= null;
                try {
                    date = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss").parse(phone.getDateRemoved());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.MONTH, 6);
                Date dateForFutureInstallment = c.getTime();

                long diffInMillies = Math.abs(date.getTime() -dateForFutureInstallment.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                JOptionPane.showMessageDialog(null, "****** Phones.Phone Receipt *****\n\n" +
                        "Phones.Phone: " + phone.getPhoneName() + " - " + phone.getPhoneBrand() + "\n" +
                        "Payment due: "+dateForFutureInstallment.toString()+"\n\n"+
                        "Payment due in: "+diff+" days");

            }
    }
}
