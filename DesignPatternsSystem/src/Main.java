import java.sql.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jack","jack");

        purchasePhone(con);

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
        Phone testPhone = new Phone(phoneID, allPhoneFields[1],allPhoneFields[2],priceCost,retailCost,allPhoneFields[5], paidOff, allPhoneFields[7],initialPayment);

        jack.setPaymentType(new LumpSumBehaviour());
        System.out.println(jack.pay(jack, testPhone));

        jack.setPaymentType(new InstallementPlanBehaviour());
        System.out.println(jack.pay(jack, testPhone));

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
