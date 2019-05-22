package project;

import java.util.Scanner;

public class Post extends UserClass {

    Scanner scanner = new Scanner(System.in);
    
    
    //Fields
    private String content;
    private String userName;
    private int likes;
    private int shares;
    private int comments;
    


    public Post(String content, String userName, int likes, int shares, int comments){
        this.content = content;
        this.userName = userName;
        this.likes = likes;
        this.shares = shares;
        this.comments = comments;
        
    }
    
    public Post (){
        
    }

    //Getters and Setters
    
    public String getUserName() { return name; }
    
    public String getContent() { return content; }
    public void setcontent ( String content ) { this.content = content; }
    
    public int getLikes() {return likes; }
    public void setLikes() { this.likes = likes; }
    
    public int getShares() { return shares; }
    public void setShares() { this.shares = shares; }
    
    public int getComments() { return comments; }
    public void setComments() { this.comments = comments; }

    //Some Methods

    public void like (){
        likes = likes+1;
    }

    public void sharePost() {
        
        System.out.println("Write what you want to share: ");
        content = scanner.nextLine();
        Post post = new Post(content, getUserName(), 0, 0, 0);
      }
    
 }

