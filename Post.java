import java.util.ArrayList;
import java.util.Scanner;

public class Post {

    Scanner scanner = new Scanner(System.in);

    //Fields

    private String content;
    private ArrayList<String> comments;
    private int likes;
    private int shares;
    private int commentCount;


    public Post(String content, int likes, int shares, int commentCount, ArrayList<String> comments){
        this.content = content;
        this.likes = likes;
        this.shares = shares;
        this.commentCount = commentCount;
        this.comments = comments;
    }
    public Post (){   }

    //Getters and Setters

    public String getContent() { return content; }
    public void setContent ( String content ) { this.content = content; }

    public int getLikes() {return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public int getShares() { return shares; }
    public void setShares(int shares) { this.shares = shares; }

    public int getCommentCount() { return commentCount; }
    public void setCommentCount(int commentCount) { this.commentCount = commentCount; }

    public ArrayList<String> getComments() { return comments; }
    public void setComments(ArrayList<String> comments) { this.comments = comments;}


    //Some Methods

    public void Like (){
        likes = likes+1;
    }

    public void sharePost(UserClass user)
    {

        System.out.println("Write what you want to share: ");
        String cont = scanner.nextLine();
        System.out.println();
        setContent(cont);

        ArrayList<Post> List =user.getPostList();
        List.add(this);


        System.out.println("\n\tPosted.");
        System.out.println("1 to return User Panel - 2 to share another post.");

        int choose = scanner.nextInt();
        scanner.nextLine();//dummy
        }


    public void Comment(UserClass user)
    {
        ArrayList<String> list = new ArrayList<>();
        list = getComments();
        System.out.println("Write your comment here: ");
        String comm = scanner.nextLine();
        list.add(user.getName()+" : "+comm);
        setComments(list);
        int a = getCommentCount()+1;
        setCommentCount(a);
    }

}
