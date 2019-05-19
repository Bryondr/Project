public class Main
{
    public static void main(String args[])
    {
        Administrator Admin = new Administrator();
        UserClass user = Register.Registering();
        Admin.CallBirthday(user);

    }
}
