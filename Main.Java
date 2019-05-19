public class Main
{
    public static void main(String args[])
    {
        //Admin doğum gününü kontrol ediyor register classından gelecek user ile bütün parçalar tamam olacak
        Administrator Admin = new Administrator();
        UserClass user = Register.Registering();
        Admin.CallBirthday(user);

    }
}
