public class UserPanel
{
    public static void main(String args[])
    {
        UserClass user1 = new UserClass("Mehmet amca","mehmetamca@hotmail.com",1,1,1000);
        Administrator Admin = new Administrator();
        Register Registerer = new Register();


        UserClass user = Registerer.Registering();
        Admin.CallBirthday(user);

        System.out.println("Welcome " + user.getName() + ", please choose an operation;");
        System.out.println("1. Show Inbox");
        System.out.println("2. Show Outbox");
        System.out.println("3. Send Message");
        System.out.println("4. Share Post");
        System.out.println("5. Show timeline");
        System.out.println("6. Show contact list");
        System.out.println("7. Show Notifications");
        //user.ShowNotifications(); Bu böyle kullanılmayacak sadece
        // 7.seçenek seçilirse bu method çalışacak ona göre implement edilmeli!!!!
        // Switch Case bu işe uygun!!!
        System.out.println("8. Follow People");
        
    }
}
