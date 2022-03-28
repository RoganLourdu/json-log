package com.company;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.Scanner;

public class Main {
    final static Logger logger=Logger.getLogger(Main.class);
    public static void main(String[] args) {
	// write your code here
        String path="/home/rogan-zstk272/IdeaProjects/example/src/com/company/log4j.properties";
        PropertyConfigurator.configure(path);
        Scanner input=new Scanner(System.in);
        System.out.print("Enter your name here : ");
        String name= input.nextLine();
        System.out.print("\nEnter your phonenumber here : ");
        long phonenumber= input.nextLong();
        System.out.print("\nEnter your age here : ");
        int age = input.nextInt();
        System.out.print("\nEnter the type of loan here (personal/Home Loan/Car loan) : ");
        input.nextLine();
        String loantype= input.nextLine();
        System.out.print("\nEnter your occupation here : ");
        String occupation= input.nextLine();
        System.out.print("\nEnter here your place of work : ");
        String workplace= input.nextLine();
        System.out.print("\nEnter your ID Proof documents (Passport/Driving License/Voter’s ID/Aadhar Card) [Y|N] : ");
        char idproff= input.next().charAt(0);
        System.out.print("\nEnter your Address Proof Documents (Ration Card/EB Bills)  [Y|N] : ");
        char addressproff=input.next().charAt(0);
        System.out.print("\nEnter your salary amount  : ");
        int salaryamount= input.nextInt();
        System.out.print("\nDo you have salary certificate [Y|N] : ");
        input.nextLine();
        char salarycertificate=input.next().charAt(0);
        System.out.print("\nEnter your Loan Amount : ");
        long loanamount= input.nextLong();

        if(age<18) {
            logger.error("Sorry, You don’t qualify for our age criteria for loans");
            System.out.println("Sorry, You don’t qualify for our age criteria for loans");
        } else if(loanamount<25000) {
            logger.error("Sorry, loan amount is very less");
            System.out.println("Sorry, loan amount is very less");
        } else if(loanamount>100000 && salaryamount<5000) {
            logger.error("Sorry, you may not be eligible for this loan amount");
            System.out.println("Sorry, you may not be eligible for this loan amount");
        } else if(loanamount >1000000) {
            logger.error("Loan for this amount is not possible if we don’t have surety or Guarantee");
            System.out.println("Loan for this amount is not possible if we don’t have surety or Guarantee");
        } else if(idproff=='N' || addressproff=='N' || salarycertificate=='N') {
            logger.error("Insufficient Documents");
            System.out.println("Insufficient Documents");
        }else {
            System.out.println("You are eligible for loan");
        }
    }
}