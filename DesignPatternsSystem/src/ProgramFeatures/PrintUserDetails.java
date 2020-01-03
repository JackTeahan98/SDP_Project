package ProgramFeatures;

import DetailsPrinter.Printer;
import Members.BasicMember;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintUserDetails {
    public void printDetails(BasicMember member){

        Printer printer = new Printer(100);
        JTextField txt1= new JTextField(10);
        txt1.setBounds(50,100, 200,30);
        JButton button1= new JButton("Select Password");
        JButton button2= new JButton("Reject Password");
        JButton button3= new JButton("Print Details");
        JButton button4= new JButton("Enter Password");
        String level = member.getUserLevel();
        String type = member.getUserType();
        int userBalance = member.getAccountBal();


        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txt1.getText().equals(member.getUserPassword()))
                {
                    printer.enterPassword();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Password, Please Try again!");
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printer.selectPassword(level,type,userBalance);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printer.rejectPassword();
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printer.print(level,type,userBalance);
                JOptionPane.showMessageDialog(null,printer);
            }
        });
        JOptionPane.showMessageDialog(null,printer);
        JOptionPane.showOptionDialog(null, "Choose an Option...\n", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{txt1,button4,button1, button2, button3}, button1);


    }
}
