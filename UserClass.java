import java.util.ArrayList;

public class UserClass
{
    //Fields
    private String name;
    private String email;
    private int dayOfBirth = 0;
    private int monthOfBirth;
    private int yearOfBirth;
    private ArrayList<String> notificationBox;
    private ArrayList postList;
    private ArrayList timeLine;
    private ArrayList favPosts;
    private ArrayList<UserClass> followedList;
    private String place;
    private ArrayList incoming;
    private ArrayList outgoing;


    public UserClass ()
    {

    }

    public UserClass(String name, String email, int dayOfBirth,int monthOfBirth,int yearOfBirth, ArrayList<String> notificationBox, ArrayList postList, ArrayList timeLine, ArrayList favPosts, ArrayList<UserClass> followedList, String place, ArrayList incoming, ArrayList outgoing)
    {
        this.name = name;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.notificationBox = notificationBox;
        this.postList = postList;
        this.timeLine = timeLine;
        this.favPosts = favPosts;
        this.followedList = followedList;
        this.place = place;
        this.incoming = incoming;
        this.outgoing = outgoing;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ArrayList<String> getNotificationBox() { return notificationBox; }
    public void setNotificationBox(ArrayList notificationBox) { this.notificationBox = notificationBox; }

    public ArrayList getPostList() { return postList; }
    public void setPostList(ArrayList postList) { this.postList = postList; }

    public ArrayList getTimeLine() { return timeLine; }
    public void setTimeLine(ArrayList timeLine) { this.timeLine = timeLine; }

    public ArrayList getFavPosts() { return favPosts; }
    public void setFavPosts(ArrayList favPosts) { this.favPosts = favPosts; }

    public ArrayList<UserClass> getFollowedList() { return followedList; }
    public void setFollowedList(ArrayList<UserClass> followedList) { this.followedList = followedList; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public ArrayList getIncoming() { return incoming; }
    public void setIncoming(ArrayList incoming) { this.incoming = incoming; }

    public ArrayList getOutgoing() { return outgoing; }
    public void setOutgoing(ArrayList outgoing) { this.outgoing = outgoing; }

    public int getDayOfBirth() {return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) {this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() {return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    //Other methods

    public void SendToNotificationBox(String notification)
    {
        //gets notification and sends it to user
        notificationBox.add(notification); //!!NASIL KULLANILDIĞINI ÖĞRENİP TEKRARDAN DÖNECEĞİM!!
    }

    public void ShowNotifications()
    {
        for (int i = 0; i < notificationBox.size(); i++)
            {
                System.out.println(notificationBox.get(i));
            }
    }
}
