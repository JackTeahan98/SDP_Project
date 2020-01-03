import Shop.Shop;
import java.sql.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jack","jack");

        Shop phoneShop = Shop.getInstance();
        System.out.println("********** Welcome to Phone Shop! **********\n");

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
        else
            phoneShop.openShop();

        if(phoneShop.shopStatus() == true) {
            Utils utils = new Utils();
            utils.purchasePhone(con);
        }

        phoneShop.closeShop();
        con.close();

    }




}
