package ProgramFeatures;

import Bundle.PhoneBundle;
import Bundle.PhoneCase;
import Bundle.PhoneInsurance;
import Bundle.PhoneScreenProtector;
import CustomisedPhoneCase.CaseUtils;
import Phones.Phone;

import javax.swing.*;
import java.util.Scanner;

public class PurchaseDeal {
    public void purchaseDeal(Phone testPhone){
        PhoneBundle bundle = new Phone(testPhone);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add a Case for $15?");
        String answer = scanner.nextLine().toUpperCase();
        if(answer.equals("YES"))
        {
            System.out.println("Do you want to create a custom Case?");
            String customCaseAns = scanner.nextLine().toUpperCase();
            if(customCaseAns.equals("YES"))
            {
                CaseUtils utils = new CaseUtils();
                utils.caseRun();
                bundle = new PhoneCase(bundle);
            }
            else
            {
                bundle = new PhoneCase(bundle);
            }
        }

        System.out.println("Would you like to purchase Insurance for $55?");
        answer = scanner.nextLine().toUpperCase();

        if(answer.equals("YES"))
        {
            bundle = new PhoneInsurance(bundle);
        }

        System.out.println("Would you like to purchase a Screen Protector for $10 ?");
        answer = scanner.nextLine().toUpperCase();
        if(answer.equals("YES"))
        {
            bundle = new PhoneScreenProtector(bundle);
        }

        JOptionPane.showMessageDialog(null,bundle.getDescription()+" \nTOTAL: $"+bundle.cost(testPhone));

    }
}
