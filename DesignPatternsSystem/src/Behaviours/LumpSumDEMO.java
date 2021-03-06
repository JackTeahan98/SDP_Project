package Behaviours;

import Members.Member;
import Phones.Phone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LumpSumDEMO {

    public String paymentLumpSum(Member member, Phone phone){

        if(member.getAccountBal() > phone.getPriceRetail())
        {
            int newBalance = member.getAccountBal()-phone.getPriceRetail();
            member.setAccountBal(newBalance);

            String phonePurchased = phone.getPhoneName()+" - "+phone.getPhoneBrand();
            String membersCurrentPhones = member.getPhonesremoved();
            member.setPhonesremoved(membersCurrentPhones +" //// "+phonePurchased);

            phone.setPaidOff(true);
            phone.setPaymentType("LumpSumPayment");

            phone.setDueDate("No further dates required");

            DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
            Date date = new Date();
            phone.setDateRemoved(dateFormat.format(date),phone);

            return "DEMO Lump sum of "+phone.getPriceRetail()+" successfully paid off for "+phone.getPhoneName();
        }

        return "DEMO Phone has not been purchased, transaction failed";

    }
}
