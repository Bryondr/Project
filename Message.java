import java.util.ArrayList;
import java.util.Scanner;


public class Message
{
    private String message;
    private String content;
    private String getterPerson;
    private String senderPerson;

    //Constructor
    public Message()
    {

    }

    //Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) {this.message = message; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getGetterPerson() { return getterPerson; }
    public void setGetterPerson(String getterPerson) { this.getterPerson = getterPerson; }

    public String getSenderPerson() { return senderPerson; }
    public void setSenderPerson(String senderPerson) { this.senderPerson = senderPerson; }



    //Sends message to needed boxes
    public void SendMessage(UserClass user1,UserClass user2,String message,String content)
    {

        FollowSystem Following = new FollowSystem();

        if(Following.IsEachOtherFollowing(user1, user2))
        {
            ArrayList<Message> list = new ArrayList<Message>();

            list = user1.getOutgoing();
            list.add(this);
            user1.setOutgoing(list);

            list = user2.getIncoming();
            list.add(this);
            user2.setIncoming(list);

            user2.SendToNotificationBox("You got a new message from "+user1.getName()+"\nMessage is: "+getMessage()+"\nContent is: "+getContent());
            System.out.println("Your message sent!");

        }

        else
            {
                System.out.println("He should follow you for sending message");
            }
    }
    
    //Messaging Panel for user
    public void MessagingPanel (UserClass user)
    {
        Scanner scanner = new Scanner(System.in);
        int no = user.getFollowedList().size();
        System.out.println("Please select who do you want to send message");
        for(int i=1; i< no+1; i++)
        {
            System.out.println(i + ". "+user.getFollowedList().get(i-1).getName());
        }
        int choose  = scanner.nextInt()-1;
        scanner.nextLine(); // Dummy
        setSenderPerson(user.getName());
        setGetterPerson(user.getFollowedList().get(choose).getName());
        System.out.println("Please write your message: ");
        String msg = scanner.nextLine();
        setMessage(msg);

        System.out.println("Please enter your File name: ");
        String cont = scanner.nextLine();
        setContent(cont);

        SendMessage(user,user.getFollowedList().get(choose),getMessage(),getContent());
    }
}
