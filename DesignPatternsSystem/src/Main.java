import Behaviours.InstallementPlanBehaviour;
import Behaviours.LumpSumBehaviour;
import Bundle.PhoneBundle;
import Bundle.PhoneCase;
import Bundle.PhoneInsurance;
import Bundle.PhoneScreenProtector;
import DetailsPrinter.Printer;
import Members.BasicMember;
import Members.Member;
import Observer.DisplayPurchaseReceipt;
import Phones.Phone;
import Shop.Shop;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jack","jack");

        Shop phoneShop = Shop.getInstance();
        System.out.println("********** Welcome to Phone Shop! **********\n");
        phoneShop.openShop();

        Date date = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.set(Calendar.HOUR, 1);
        calendar1.set(Calendar.MINUTE,0);
        calendar1.set(Calendar.SECOND,0);

        Date date2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        calendar2.set(Calendar.HOUR, 2);
        calendar2.set(Calendar.MINUTE,0);
        calendar2.set(Calendar.SECOND,0);

        Date date3 = new Date();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);


        Date x = calendar3.getTime();
        if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
             phoneShop.closedForLunch();
        }

        if(phoneShop.shopStatus() == true) {
            purchasePhone(con);
        }

        phoneShop.closeShop();
        con.close();

    }



    public static void purchasePhone(Connection con) throws SQLException, ParseException {
        String[] allUserFields = getUserFromDB(con);
        String[] allPhoneFields = getPhoneFromDB(con);

        int balance = Integer.parseInt(allUserFields[5]);
        int userID = Integer.parseInt(allUserFields[0]);
        int phoneID = Integer.parseInt(allUserFields[0]);
        int priceCost= Integer.parseInt(allPhoneFields[3]);
        int retailCost = Integer.parseInt(allPhoneFields[4]);
        boolean paidOff = Boolean.parseBoolean(allPhoneFields[6]);
        int intitialPaymentInt = Integer.parseInt(allPhoneFields[8]);
        boolean initialPayment = (intitialPaymentInt ==1);

        Member jack = new BasicMember(userID, allUserFields[1],allUserFields[2],allUserFields[3],allUserFields[4],balance,allUserFields[6]);
        Phone testPhone = new Phone(phoneID, allPhoneFields[1],allPhoneFields[2],priceCost,retailCost,allPhoneFields[5], paidOff, allPhoneFields[7],initialPayment,"");

        DisplayPurchaseReceipt phoneReceipt = new DisplayPurchaseReceipt(testPhone);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to purhase a phone?");
        String answer = scanner.nextLine();

        if(answer.equals("yes"))
        {
            System.out.println("Installment Plan or Once off Payment? (I or O)");
            answer = scanner.nextLine().toUpperCase();


            if(answer.equals("I"))
            {
                jack.setPaymentType(new InstallementPlanBehaviour());
                System.out.println(jack.pay(jack, testPhone));
            }

            else if(answer.equals("O"))
            jack.setPaymentType(new LumpSumBehaviour());
            System.out.println(jack.pay(jack, testPhone));


        }
        System.out.println("\n-------------------------------------\n");
        System.out.println("Would you like to purchase a deal?");
        answer = scanner.nextLine().toUpperCase();

        if(answer.equals("YES"))
        {
        PhoneBundle bundle = new Phone(testPhone);

        System.out.println("Would you like to add a Case for $15?");
        answer = scanner.nextLine().toUpperCase();
        if(answer.equals("YES"))
        {
            bundle = new PhoneCase(bundle);
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

        System.out.println("\n-------------------------------------\n");
        System.out.println("Would you like to see your details "+jack.getUserName()+"?");
        answer = scanner.nextLine().toUpperCase();
        if(answer.equals("YES"))
        {
            Printer printer = new Printer(100);

            System.out.println(printer);

            System.out.println("Enter password for username: "+jack.getUserName()+" or press E for Exit");
            String password = scanner.nextLine();
            if(password.equals(jack.getUserPassword()))
            {
                String level = jack.getUserLevel();
                String type = jack.getUserType();
                int userBalance = jack.getAccountBal();

                printer.enterPassword();
                printer.selectPassword(level,type,userBalance);
            }
            else if(password.equals("E")) {
                printer.rejectPassword();
            }
            else
            {
                System.out.println("Error incorrect password!");
            }

            System.out.println(printer);

        }


        System.out.println("************ Exiting System... *************");





        // updatePhone(con, testPhone);

    }


    public static void updatePhone(Connection con, Phone phone) throws SQLException {
        int phoneID = phone.getPhoneID();
        String phoneName = phone.getPhoneName();
        String phoneBrand = phone.getPhoneBrand();
        int priceCost = phone.getPriceCost();
        int priceRetail = phone.getPriceRetail();
        String dateRemoved = phone.getDateRemoved();
        int paidOff = phone.isPaidOff() ? 1 : 0;
        String paymentType = phone.getPaymentType();

        Statement st=con.createStatement();
        String sql="UPDATE PHONE_TBL SET PHONE_NAME = "+ phoneName +", PHONE_BRAND = "+ phoneBrand + ", PRICE_COST = "+ priceCost + ", PRICE_RETAIL = "+ priceRetail + ", DATE_REMOVED = "+ dateRemoved + ", paid_off = "+ paidOff + ", PAYMENT_TYPE = "+ paymentType + "WHERE  = PHONE_ID = "+phoneID+"";
        ResultSet rs=st.executeQuery(sql);
    }


    public static String[] getPhoneFromDB(Connection con) throws SQLException {
        String[] fields = new String[9];
        Statement st=con.createStatement();
        String sql="SELECT * FROM PHONE_TBL where PHONE_ID = 1";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()) {
            fields[0] = rs.getString("PHONE_ID");
            fields[1] = rs.getString("PHONE_NAME");
            fields[2] = rs.getString("PHONE_BRAND");
            fields[3] = rs.getString("PRICE_COST");
            fields[4] = rs.getString("PRICE_RETAIL");
            fields[5] = rs.getString("DATE_REMOVED");
            fields[6] = rs.getString("paid_off");
            fields[7] = rs.getString("payment_type");
            fields[8] = rs.getString("initial_payment");

            }


        return fields;
    }


    public static String[] getUserFromDB(Connection con) throws SQLException {
        String[] fields = new String[7];
        Statement st=con.createStatement();
        String sql="SELECT * FROM USERS_TBL where user_id = 1";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()) {
            fields[0]= rs.getString("USER_ID");
            fields[1]= rs.getString("USER_NAME");
            fields[2] = rs.getString("USER_PASSWORD");
            fields[3] = rs.getString("USER_TYPE");
            fields[4] = rs.getString("USER_LEVEL");
            int balance = rs.getInt("ACCOUNT_BAL");
            String balanceAsString = Integer.toString(balance);
            fields[5] = balanceAsString;
            fields[6] = rs.getString("PHONES_REMOVED");
        }



        return fields;
    }
}
