import java.util.ArrayList;
import java.util.Scanner;

public class UserPanel
{
    public static void main(String args[]) {

        //controls all main page for any user
        MainPage mp = new MainPage();

        //controls all timeline for any user
        TimeLine timeLine = new TimeLine();

        //creates an ArrayList for any usage of array
        ArrayList<UserClass> list = new ArrayList<>();

        //creates Scanner for any usage of scanner
        Scanner scanner = new Scanner(System.in);

        //Creates an Administrator for controlling birthday
        Administrator Admin = new Administrator();

        //Creates new user for you with your information
        Register Registerer = new Register();
        UserClass user = Registerer.Registering();

        //Creates other users for our program(özellikleri değişecek)
        UserClass user1 = new UserClass("Deyan Bora Çetin", "deyan_bora@hotmail.com", 23, 01, 1999);
        UserClass user2 = new UserClass("Ege Bulut", "izciege@hotmail.com", 3, 4, 2000);
        UserClass user3 = new UserClass("Mehmet Uslu", "mehmetUslu@gmail.com", 6, 7, 1967);
        UserClass user4 = new UserClass("Ahmet Sel", "ahmetSel@hotmail.com", 31, 5, 1985);
        UserClass user5 = new UserClass("Arzu Hepcan", "mehmetamca@hotmail.com", 1, 1, 2010);
        UserClass user6 = new UserClass("Aslı Bekir", "mehmetamca@hotmail.com", 1, 1, 2010);
        UserClass user7 = new UserClass("Dilan Saman", "dilan_saman@gmail.com", 1, 1, 2010);

        //Follow system which controls all follow operations
        FollowSystem Following = new FollowSystem();

        //It runs for our user controls if his birthday or not and if it is sends message to notification box
        Admin.CallBirthday(user);

        //Holds all userlist for any use
        ArrayList<UserClass> userlist = new ArrayList<>();
        userlist = UserClass.getUserlist();

        //Makes some users to follow our user
        list = user1.getFollowedList();
        list.add(user);
        user1.setFollowedList(list);

        list = user2.getFollowedList();
        list.add(user);
        user2.setFollowedList(list);

        list = user3.getFollowedList();
        list.add(user);
        user3.setFollowedList(list);

        Post otherpost = new Post(user1.getName()," ",0,0);

        //Panel
        while (true) {
            System.out.println("\nWelcome " + user.getName() + ", please choose an operation;");
            System.out.println("1. Show Inbox");
            System.out.println("2. Show Outbox");
            System.out.println("3. Send Message");
            System.out.println("4. Share Post");
            System.out.println("5. Show Time Line");
            System.out.println("6. Show Main Page");
            System.out.println("7. Show Your Followings");
            System.out.println("8. Show Your Followers");
            System.out.println("9. Follow People");
            System.out.println("10. Show Notifications");

            otherpost.sharePost(user1,Following,"I'm new here");
            otherpost.sharePost(user2,Following,"I'm new here");
            otherpost.sharePost(user3,Following,"I'm new here");
            otherpost.sharePost(user4,Following,"I'm new here");
            otherpost.sharePost(user5,Following,"I'm new here");
            otherpost.sharePost(user6,Following,"I'm new here");
            otherpost.sharePost(user7,Following,"I'm new here");



            int choose = scanner.nextInt();
            scanner.nextLine();//dummy;

            switch (choose)
            {
                //Shows inbox for our user
                case 1:
                    if(user.getIncoming().size() == 0){
                        System.out.println("Your inbox is empty.");
                        break;
                    }
                    else{
                        System.out.println("_______________\nInbox:");
                        for(int i =0;i < user.getIncoming().size();i++){
                            System.out.println("____________");
                            System.out.println("From :"+user.getOutgoing().get(i).getSenderPerson());
                            System.out.println("\nMessage: \n"+user.getIncoming().get(i).getMessage());
                            System.out.println("Content : \n"+user.getIncoming().get(i).getContent());
                            System.out.println("____________");
                        }
                        break;
                    }
                    //Shows outbox for our user
                case 2:
                    if(user.getOutgoing().size() == 0){
                        System.out.println("Your Outbox is empty. Please try to message someone.");
                        break;
                    }
                    else{
                        System.out.println("_______________\nOutbox:");
                        for(int i =0;i < user.getOutgoing().size();i++)
                        {
                            System.out.println("_______________");
                            System.out.println("To :"+user.getOutgoing().get(i).getGetterPerson());
                            System.out.println("\nMessage: \n"+user.getOutgoing().get(i).getMessage());
                            System.out.println("Content : \n"+user.getOutgoing().get(i).getContent());
                            System.out.println("_______________");
                        }
                        break;
                    }
                    //Sends user to message panel for sending message
                case 3:

                    Message message = new Message();
                    System.out.println("\n");
                    message.MessagingPanel(user);
                    break;

                //Creates new post for user and sends him creation page
                case 4:
                    Post post = new Post();
                    post.sharePost(user, Following);
                    break;

                //Shows user's Timeline
                case 5:
                    timeLine.getTimeLine(user);
                    if(user.getPostList().size() == 0){
                        System.out.println("___________________");
                        System.out.println("Your Time Line is empty, please post or share something.");
                        System.out.println("___________________");
                        break;
                    }
                    else{
                        System.out.println("Choose the post number for showing post operations");

                        int tPostNumber = scanner.nextInt();
                        scanner.nextLine();//dummy;
                        timeLine.getTimeLine(user, tPostNumber);

                        System.out.println("Enter 1 to like the post 1 \n" +
                                "Enter 2 to comment the post \n" +
                                "Enter 3 for showing comments \n" +
                                "Enter 4 for returning your Time Line \n" +
                                "Enter another number for returning User panel.");
                        int tPostAction = scanner.nextInt();
                        scanner.nextLine();//dummy;

                        switch (tPostAction)
                        {

                            //Adds 1 like for post which our user selects
                            case 1 :
                                user.getTimeLine().get(tPostNumber-1).Like();
                                break;

                            //Opens comment page for user
                            case 2 :
                                user.getTimeLine().get(tPostNumber-1).Comment(user);
                                break;

                            //Prints all comments for selected post
                            case 3 :
                                timeLine.getTimeLine(user, tPostNumber);
                                for(int i=0;i<user.getTimeLine().get(tPostNumber-1).getComments().size();i++)
                                {
                                    System.out.println(user.getTimeLine().get(tPostNumber - 1).getComments().get(i));
                                }
                                break;

                            //Gets main page for user
                            case 4 :
                                timeLine.getTimeLine(user);
                                break;
                        }
                        break;
                    }

                    //Shows user's main page
                case 6:
                    mp.getMainPage(user);
                    if(user.getPostList().size() == 0){
                        System.out.println("___________________");
                        System.out.println("Your Main Page is empty, please follow someone or post something.");
                        System.out.println("___________________");
                        break;
                    }
                    else
                        {
                            System.out.println("Choose the post number for showing post operations");

                            int postNumber = scanner.nextInt();
                            scanner.nextLine();//dummy;
                            mp.getMainPage(user, postNumber);

                            System.out.println("Enter 1 to like the post 1 \n" +
                                    "Enter 2 to comment the post \n" +
                                    "Enter 3 for showing comments \n" +
                                    "Enter 4 for returning your Main Page \n" +
                                    "Enter another number for returning User panel.");
                            int postAction = scanner.nextInt();
                            scanner.nextLine();//dummy;

                            switch (postAction)
                            {

                                //Adds 1 like for post which our user selects
                                case 1 :
                                    user.getPostList().get(postNumber-1).Like();
                                    break;

                                    //Opens comment page for user
                                case 2 :
                                    user.getPostList().get(postNumber-1).Comment(user);
                                    break;

                                    //Prints all comments for selected post
                                case 3 :
                                    mp.getMainPage(user, postNumber);
                                    for(int i=0;i<user.getPostList().get(postNumber-1).getComments().size();i++)
                                    {
                                        System.out.println(user.getPostList().get(postNumber - 1).getComments().get(i));
                                    }
                                    break;

                                    //Gets main page for user
                                case 4 :
                                    mp.getMainPage(user);
                                    break;
                            }
                        }
                    break;

                    //Shows user his contact list
                case 7:
                    if(user.getFollowedList().size() == 0)
                    {
                        System.out.println("You are follow 0 user, please follow someone to socialize.");
                    }
                    else
                        {
                        System.out.println("You are follow"+ user.getFollowedList().size() +"user:");
                        System.out.println("___________________");
                        for (int i = 0; i < user.getFollowedList().size(); i++){
                            System.out.println(user.getFollowedList().get(i).getName());
                        }
                        break;
                        }

                    //Shows your followers
                case 8:
                    System.out.println("Your followers are:");
                    System.out.println("___________________");
                    for(int i = 0;i < userlist.size();i++)
                    {
                        //if he follows user prints his name
                        if(Following.IsFollow(userlist.get(i),user)){
                            System.out.println(userlist.get(i).getName());
                        }
                    }
                    System.out.println("___________________");
                    break;

                //Shows all users who you're not following for our user and gives him follow option
                case 9:
                    System.out.println("All users in our system are:\n");
                    //prints all users who you're not following in system
                    for (int i = 1; i < Following.getRemainingUsers().size(); i++)
                    {
                        System.out.println(i + " " + Following.getRemainingUsers().get(i).getName());
                    }

                    System.out.println("Please choose the user which you want follow");
                    int select = scanner.nextInt();
                    scanner.nextLine();

                    //makes you follow user who you choose
                    Following.Follow(user, Following.getRemainingUsers().get(select));
                    int number = user.getFollowedList().size()-1;
                    System.out.println("You followed " +  user.getFollowedList().get(number).getName());
                    System.out.println("___________________");
                    break;

                // Shows user's notification box
                case 10 :
                    if( user.getNotificationBox().size() == 0)
                    {
                        System.out.println("You have 0 Notifications.");
                        break;
                    }

                    user.ShowNotifications();
                    System.out.println("Enter anything to return User Panel.");
                    scanner.nextLine();

                default:
                    break;
            }
        }
    }
}
