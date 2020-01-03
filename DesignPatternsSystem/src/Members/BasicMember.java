package Members;

import java.text.ParseException;

public class BasicMember extends Member {

    public BasicMember(int userID, String userName,String userPassword, String userType, String userLevel, int accountBal, String phonesremoved)
    {
         setUserID(userID);
         setUserName(userName);
         setUserPassword(userPassword);
         setUserType(userType);
         setUserLevel(userLevel);
         setAccountBal(accountBal);
         setPhonesremoved(phonesremoved);
    }





}
