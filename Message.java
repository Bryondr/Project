import java.util.ArrayList;
import java.util.Scanner;


public class Message
{
    private String message;
    private String content;

    public String getMessage() { return message; }
    public void setMessage(String message) {this.message = message; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }



    //Constructor
    public Message()
    {

    }

    public void SendMessage(UserClass user1,UserClass user2,String message,String content)
    {
        ArrayList<Message> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        FollowSystem System = new FollowSystem();

        if(System.IsEachOtherFollowing(user1, user2))
        {

            list = user1.getOutgoing();
            list.add(this);
            user1.setOutgoing(list);

            list = user2.getIncoming();
            list.add(this);
            user2.setIncoming(list);

            list2 = user2.getNotificationBox();
            list2.add("You got a new message from "+user1.getName()+"\nMessage is: "+getMessage()+"\nContent is: "+getContent());
            user2.setNotificationBox(list2);
        }
    }
    public void MessagingPanel (UserClass user)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select who do you want to send message");
        for(int i=0; i< user.getFollowedList().size(); i++)
        {
            System.out.println(i + ". "+user.getFollowedList().get(i).getName());
        }
        int choose  = scanner.nextInt();
        scanner.nextLine(); // Dummy

        System.out.println("Please write your message: ");
        String msg = scanner.nextLine();
        setMessage(msg);

        System.out.println("Please enter your File name: ");
        String cont = scanner.nextLine();
        setContent(cont);

        SendMessage(user,user.getFollowedList().get(choose),getMessage(),getContent());
        System.out.println("Your message sent!");
    }

}
