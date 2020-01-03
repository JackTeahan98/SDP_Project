package Behaviours;

import Members.Member;
import Phones.Phone;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class InstallementPlanBehaviour implements PaymentType {

    private final int monthsForPlan = 6;

    @Override
    public String payment(Member member, Phone phone) throws ParseException {
        int installementPrice = phone.getPriceRetail() / 2;


        if (member.getAccountBal() > installementPrice && phone.isInitialPayment()) {
            member.setAccountBal(member.getAccountBal() - installementPrice);

            String phonePurchased = phone.getPhoneName() + " - " + phone.getPhoneBrand();
            String membersCurrentPhones = member.getPhonesremoved();
            member.setPhonesremoved(membersCurrentPhones + " //// " + phonePurchased);

            DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
            Date date = new Date();
            phone.setDateRemoved(dateFormat.format(date),phone);

            phone.setPaymentType("InstallementPlan");

            phone.setInitialPayment(false);


        }
         if (member.getAccountBal() > installementPrice && !phone.isInitialPayment() && !phone.isPaidOff())
        {
            Date date=new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss").parse(phone.getDateRemoved());
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.MONTH, monthsForPlan);
            Date dateForFutureInstallment = c.getTime();
            phone.setDueDate(dateForFutureInstallment.toString());

            long diffInMillies = Math.abs(date.getTime() - dateForFutureInstallment.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if(diff > monthsForPlan*31)
            {
                member.setAccountBal(member.getAccountBal() - installementPrice);
                phone.setPaidOff(true);
                phone.setPaymentType("InstallementPlanCOMPLETE");
                phone.setInitialPayment(true);

                return "Phones.Phone fully paid off";
            }

          return "Phones.Phone Installment section paid off";

        }
         return "Phones.Phone Installment section paid off";
    }
}
