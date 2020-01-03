import Members.BasicMember;
import Members.Member;
import Phones.Phone;
import ProgramFeatures.PrintUserDetails;
import ProgramFeatures.PurchaseDeal;
import ProgramFeatures.PurchasePhoneMethod;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Utils
{
    public static void purchasePhone(Connection con) throws SQLException, ParseException {
        DBUtils dbu = new DBUtils();
        String[] allUserFields = dbu.getUserFromDB(con);
        String[] allPhoneFields = dbu.getPhoneFromDB(con);

        int balance = Integer.parseInt(allUserFields[5]);
        int userID = Integer.parseInt(allUserFields[0]);
        int phoneID = Integer.parseInt(allUserFields[0]);
        int priceCost= Integer.parseInt(allPhoneFields[3]);
        int retailCost = Integer.parseInt(allPhoneFields[4]);
        boolean paidOff = Boolean.parseBoolean(allPhoneFields[6]);
        int intitialPaymentInt = Integer.parseInt(allPhoneFields[8]);
        boolean initialPayment = (intitialPaymentInt ==1);

        Member member = new BasicMember(userID, allUserFields[1],allUserFields[2],allUserFields[3],allUserFields[4],balance,allUserFields[6]);
        Phone testPhone = new Phone(phoneID, allPhoneFields[1],allPhoneFields[2],priceCost,retailCost,allPhoneFields[5], paidOff, allPhoneFields[7],initialPayment,"");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to purhase a phone?");
        String answer = scanner.nextLine();
        if(answer.equals("yes"))
        {
            PurchasePhoneMethod purchaseMethod = new PurchasePhoneMethod();
            purchaseMethod.purchasePhone((BasicMember) member, testPhone);
        }

        System.out.println("\n-------------------------------------\n");
        System.out.println("Would you like to purchase a deal?");
        answer = scanner.nextLine().toUpperCase();

        if(answer.equals("YES"))
        {
            PurchaseDeal purchaseDeal = new PurchaseDeal();
            purchaseDeal.purchaseDeal(testPhone);
        }

        System.out.println("\n-------------------------------------\n");
        System.out.println("Would you like to see your details "+member.getUserName()+"?");
        answer = scanner.nextLine().toUpperCase();
        if(answer.equals("YES"))
        {
            PrintUserDetails printUserDetails = new PrintUserDetails();
            printUserDetails.printDetails((BasicMember) member);
        }

        System.out.println("************ Exiting System... *************");

        // updatePhone(con, testPhone);

    }
}
