package project;

public class TimeLine {

    //Gets all posts from user'stimeline
    public void getTimeLine( UserClass user ){

        for(int i=0; i<user.getPostList().size(); i++)
        {
            System.out.println("__________________");
            System.out.println( i+1 + ". Post\n" + user.getTimeLine().get(i).getSharer()+"\n");
            System.out.println(user.getTimeLine().get(i).getContent());
            System.out.println(user.getTimeLine().get(i).getLikes() + " Likes ");
            System.out.println(user.getTimeLine().get(i).getComments().size()+" Comments");
            System.out.println("__________________");
        }
    }
    //Gets post from user's timeline which user's select
    public void getTimeLine( UserClass user, int i )
    {
        System.out.println("__________________");
        System.out.println( i + ". Post\n" + user.getTimeLine().get(i-1).getSharer()+"\n");
        System.out.println(user.getTimeLine().get(i-1).getContent());
        System.out.println(user.getTimeLine().get(i-1).getLikes() + "Likes ");
        System.out.println(user.getTimeLine().get(i-1).getComments().size()+" Comments");
        System.out.println("__________________");
    }
}
