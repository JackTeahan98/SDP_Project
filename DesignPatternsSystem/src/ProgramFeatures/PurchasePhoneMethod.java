package ProgramFeatures;

import Behaviours.InstallementPlanBehaviour;
import Behaviours.InstallmentPlanDEMO;
import Behaviours.LumpSumBehaviour;
import Behaviours.LumpSumDEMO;
import Members.BasicMember;
import Observer.DisplayPurchaseReceipt;
import Phones.Phone;

import java.lang.reflect.Member;
import java.text.ParseException;
import java.util.Scanner;

public class PurchasePhoneMethod {
    public void purchasePhone(BasicMember member, Phone testPhone) throws ParseException {

        DisplayPurchaseReceipt displayPurchaseReceipt = new DisplayPurchaseReceipt(testPhone);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Installment Plan or Once off Payment? (I or O)");
        String answer = scanner.nextLine().toUpperCase();

        if(answer.equals("I"))
        {
            member.setPaymentType(new InstallementPlanBehaviour());
            System.out.println(member.pay(member, testPhone));
        }

        else if(answer.equals("O"))
            member.setPaymentType(new LumpSumBehaviour());
            System.out.println(member.pay(member, testPhone));


        boolean demo = false;
        String paymentType = "LumpSum";
        if(demo)
        {
            member.setAccountBal(5000);
            if(paymentType.equals("LumpSum"))
            {
                System.out.println(member.getAccountBal());
                LumpSumDEMO lumpSumDEMO = new LumpSumDEMO();
                System.out.println(lumpSumDEMO.paymentLumpSum(member, testPhone));
            }

            else if(paymentType.equals("Installment"))
            {
                System.out.println(member.getAccountBal());
                InstallmentPlanDEMO installmentPlanDEMO = new InstallmentPlanDEMO();
                System.out.println(installmentPlanDEMO.paymentInstalment(member, testPhone));

            }
            System.out.println(member.getAccountBal());
        }
    }
}
