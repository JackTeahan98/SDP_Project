package ProgramFeatures;

import Behaviours.InstallementPlanBehaviour;
import Behaviours.LumpSumBehaviour;
import Members.BasicMember;
import Phones.Phone;

import java.lang.reflect.Member;
import java.text.ParseException;
import java.util.Scanner;

public class PurchasePhoneMethod {
    public void purchasePhone(BasicMember member, Phone testPhone) throws ParseException {
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

    }
}
