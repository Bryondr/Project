public class Main
{
    public static void main(String args[])
    {
        Administrator Admin = new Administrator();
        Register Registerer = new Register();
        UserPanel Panel = new UserPanel();
        
        UserClass user = Registerer.Registering();
        Admin.CallBirthday(user);
        Panel.SelectionsWindow(user);

    }
}
