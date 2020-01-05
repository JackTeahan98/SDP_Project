package Behaviours;

import Members.BasicMember;
import Members.Member;
import Phones.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LumpSumBehaviourTest{
    Member member = new BasicMember(1, "member","pass","Admin","Bronze",1000,"");
    Phone phone = new Phone(1, "iPhone","Apple",200,700,"12/12/12", false, "LumpSumBehaviour",true,"");

//    @Test
//    void payment(){
//        assertEquals("Lump sum of "+phone.getPriceRetail()+" successfully paid off for "+phone.getPhoneName(), PaymentType.payment(member,phone));
//    }


}

