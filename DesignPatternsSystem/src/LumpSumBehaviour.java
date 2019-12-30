
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LumpSumBehaviour implements PaymentType {
    @Override
    public String payment(Member member, Phone phone)
    {
        if(member.getAccountBal() > phone.getPriceRetail())
        {
            int newBalance = member.getAccountBal()-phone.getPriceRetail();
            member.setAccountBal(newBalance);

            String phonePurchased = phone.getPhoneName()+" - "+phone.getPhoneBrand();
            String membersCurrentPhones = member.getPhonesremoved();
            member.setPhonesremoved(membersCurrentPhones +" //// "+phonePurchased);

            DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
            Date date = new Date();
            phone.setDateRemoved(dateFormat.format(date));

            phone.setPaidOff(true);
            phone.setPaymentType("LumpSumPayment");

            return "Lump sum of "+phone.getPriceRetail()+" successfully paid off for "+phone.getPhoneName();


        }

        return "Phone has not been purchased, transaction failed";

    }
}
