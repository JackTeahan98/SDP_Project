package Behaviours;

import Members.BasicMember;
import Members.Member;
import Phones.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstallementPlanBehaviourTest {
    Member member = new BasicMember(1, "member","pass","Admin","Bronze",1000,"");
    Phone phone = new Phone(1, "iPhone","Apple",200,700,"12/12/12", false, "LumpSumBehaviour",true,"");

//    @Test
//    void payment(){
//        assertEquals("Phone fully paid off", PaymentType.payment());
//    }

}