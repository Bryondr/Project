import java.util.ArrayList;
import java.util.Scanner;

public class Post {

    Scanner scanner = new Scanner(System.in);

    //Fields

    private String content;
    private ArrayList<String> comments;
    private int likes;
    private int commentCount;
    private String sharer;


    public Post(String sharer,String content, int likes, int commentCount, ArrayList<String> comments)
    {
        this.sharer = sharer;
        this.content = content;
        this.likes = likes;
        this.commentCount = commentCount;
        this.comments = comments;
    }
    public Post ()
    {
        this.comments = new ArrayList<String>();
    }

    //Getters and Setters

    public String getContent() { return content; }
    public void setContent ( String content ) { this.content = content; }

    public int getLikes() {return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public int getCommentCount() { return commentCount; }
    public void setCommentCount(int commentCount) { this.commentCount = commentCount; }

    public ArrayList<String> getComments() { return comments; }
    public void setComments(ArrayList<String> comments) { this.comments = comments;}

    public String getSharer() { return sharer; }
    public void setSharer(String sharer) { this.sharer = sharer;}
    //Other Methods

    public void Like (){
        likes = likes+1;
    }

    public void sharePost(UserClass user,FollowSystem Following)
    {
        this.sharer = user.getName();
        System.out.println("Write what you want to share: ");
        String cont = scanner.nextLine();
        setContent(cont);
        ArrayList<Post> list = new ArrayList<>();

        //adds post to user's time line
        list = user.getTimeLine();
        list.add(this);
        user.setTimeLine(list);

        //adds post to user's post list(for main page)
        list = user.getPostList();
        list.add(this);
        user.setPostList(list);


        //sends post to followers postList
        for (int i=0 ;i<user.getUserlist().size();i++)
        {
            if (Following.IsFollow(user.getUserlist().get(i),user ))
            {
                list = user.getUserlist().get(i).getPostList();
                list.add(this);
                user.getUserlist().get(i).setPostList(list);
                //Control Post
            }
        }
        System.out.println("\n\tPosted.");
        }


    public void Comment(UserClass user) {
        ArrayList<String> list = new ArrayList<String>();
        list = this.getComments();
        System.out.println("Write your comment here: ");
        String comm = scanner.nextLine();

        list.add(user.getName() + " : " + comm);
        this.setComments(list);

        //it adds 1 to comment count
        int a = getCommentCount() + 1;
        setCommentCount(a);
    }
}
