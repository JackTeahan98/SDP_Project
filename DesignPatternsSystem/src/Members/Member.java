package Members;


import Behaviours.PaymentType;
import Phones.Phone;

import java.text.ParseException;

public abstract class Member {
    private PaymentType paymentType ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public int getAccountBal() {
        return accountBal;
    }

    public void setAccountBal(int accountBal) {
        this.accountBal = accountBal;
    }

    public String getPhonesremoved() {
        return phonesremoved;
    }

    public void setPhonesremoved(String phonesremoved) {
        this.phonesremoved = phonesremoved;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private int userID;
    private String userName;
    private String userPassword;
    private String userType;
    private String userLevel;
    private int accountBal;
    private String phonesremoved;


    public void setPaymentType(PaymentType paymentType){
        this.paymentType = paymentType;
    }
    public String pay(Member user, Phone phone) throws ParseException {
        return paymentType.payment(user,phone);
    }



}
