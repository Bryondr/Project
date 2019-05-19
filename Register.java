package main;


import java.util.Scanner;

public class Register 
{
    public UserClass Registering()
    {
        System.out.println("\t\t\t***Program Adi***\n\n");
        System.out.println("Please fill the blanks with valid answers.");
        
        UserClass user = new UserClass();
        Scanner name = new Scanner(System.in);
        System.out.println("User Name\t:" + user.setName(name));
        Scanner email = new Scanner(System.in);
        System.out.println("\nE-mail\t:" + user.setEmail(email));
        
        System.out.println("\nPlease enter your birth date one by one:");
        Scanner dayOfBirth = new Scanner(System.in);
        System.out.println("Day\t:" + user.setDayOfBirth(dayOfBirth));
        while(user.dayOfBirth<1 && user.dayOfBirth>31){
            System.out.println("This day of birth value is not valid, please enter a valid day value");
            System.out.println("Day\t:" + user.setDayOfBirth(dayOfBirth));
        }
           
         Scanner monthOfBirth = new Scanner(System.in);
         System.out.println("Month\t:" + user.setMonthOfBirth(monthOfBirth));
         
         Scanner yearOfBirth = new Scanner(System.in);
         System.out.println("Year\t:" + user.setYearOfBirth(yearOfBirth));
         
    return 0;
    }
}
