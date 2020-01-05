package CustomisedPhoneCase;

import CustomisedPhoneCase.BackVersions.CaseTypeBack;
import CustomisedPhoneCase.FlipVersions.CaseTypeFlip;
import CustomisedPhoneCase.OtterVersions.CaseTypeOtter;

import java.util.Scanner;

public class CaseUtils {
    public void caseRun()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of Custom Case would you like? Flip(F), Back(B) or Oterbox(O)?");
        String customCaseAns = scanner.nextLine().toUpperCase();

        if(customCaseAns.equals("B"))
        {
            CaseBuilder backBuilder = new CaseTypeBack();

            System.out.println("Would you like a Solid-Colour(S), Design(D), Gradiant(G) or Transparent(T) Version?");
            String ans = scanner.nextLine().toUpperCase();
            if(ans.equals("D")) {
                Case phoneCase = backBuilder.submitCase("DESIGN");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }
            if(ans.equals("S")) {
                Case phoneCase = backBuilder.submitCase("SOLIDCOLOUR");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }

            if(ans.equals("G")) {
                Case phoneCase = backBuilder.submitCase("GRADIANT");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }

            if(ans.equals("T")) {
                Case phoneCase = backBuilder.submitCase("DESIGN");
                System.out.println("You Selected " + phoneCase.getName() + "\n");
            }
        }

        if(customCaseAns.equals("F"))
        {
            CaseBuilder flipBuilder = new CaseTypeFlip();

            System.out.println("Would you like a Solid-Colour(S), Design(D), Gradiant(G) or Transparent(T) Version?");
            String ans = scanner.nextLine().toUpperCase();
            if(ans.equals("D")) {
                Case phoneCase = flipBuilder.submitCase("DESIGN");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }
            if(ans.equals("S")) {
                Case phoneCase = flipBuilder.submitCase("SOLIDCOLOUR");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }

            if(ans.equals("G")) {
                Case phoneCase = flipBuilder.submitCase("GRADIANT");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }

            if(ans.equals("T")) {
                Case phoneCase = flipBuilder.submitCase("DESIGN");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }
        }

        if(customCaseAns.equals("O"))
        {
            CaseBuilder otterBuidler = new CaseTypeOtter();

            System.out.println("Would you like a Solid-Colour(S), Design(D), Gradiant(G) or Transparent(T) Version?");
            String ans = scanner.nextLine().toUpperCase();
            if(ans.equals("D")) {
                Case phoneCase = otterBuidler.submitCase("DESIGN");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }
            if(ans.equals("S")) {
                Case phoneCase = otterBuidler.submitCase("SOLIDCOLOUR");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }

            if(ans.equals("G")) {
                Case phoneCase = otterBuidler.submitCase("GRADIANT");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }

            if(ans.equals("T")) {
                Case phoneCase = otterBuidler.submitCase("DESIGN");
                System.out.println("You Selected" + phoneCase.getName() + "\n");
            }
        }
    }
}
