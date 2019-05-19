import java.util.Scanner;


public class Register
{
    public UserClass Registering()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t***Program Adi***\n\n");
        System.out.println("Please fill the blanks with valid answers.");

        UserClass user = new UserClass();

        System.out.println("Please enter your username:\t");
        String name = scanner.nextLine();
        user.setName(name);
        System.out.println("User Name\t:" + user.getName());

        System.out.println("Please enter your email:\t");
        String email = scanner.nextLine();
        user.setEmail(email);
        System.out.println("\nE-mail\t:" + user.getEmail());


        System.out.println("\nPlease enter your birth date one by one:");
        System.out.println("Day/Month/Year\n");

        //Getting day info
        int dayOfBirth = scanner.nextInt();
        scanner.nextLine(); //Dummy
        user.setDayOfBirth(dayOfBirth);
        System.out.println("Day\t:" + user.getDayOfBirth());
        while(user.getDayOfBirth()<1 && user.getDayOfBirth()>31){
            System.out.println("This day of birth value is not valid, please enter a valid day value");
            System.out.println("Day\t:" + user.getDayOfBirth());
        }

       //Getting month info
        int monthOfBirth = scanner.nextInt();
        scanner.nextLine(); //Dummy
        user.setMonthOfBirth(monthOfBirth);
        System.out.println("Month\t:" + user.getMonthOfBirth());

        //Getting year info
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();//Dummy
        user.setYearOfBirth(yearOfBirth);
        System.out.println("Year\t:" + user.getYearOfBirth());

        return user;
    }
}
