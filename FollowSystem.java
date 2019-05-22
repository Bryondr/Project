public class FollowSystem
{
    //constuctor
    public FollowSystem()
    {

    }


    public void Follow(UserClass user1 /*follower*/,UserClass user2 /*followed*/)
    {
        user1.getFollowedList().add(user2);
        //EĞER OLMAZSA FOR DÖNGÜSÜ İLE YENİ BİR ARRAY LİST TANIMLAYIP İKİSİNİ BİRBİRİNE EŞİTLEYECEKSİN

    }

    public void Unfollow(UserClass user1,UserClass user2)
    {
        user1.getFollowedList().remove(user2);
    }


    public boolean CheckFollow(UserClass user1,UserClass user2)
    {
        for (int i = 0; i < user1.getFollowedList().size(); i++)
        {
            if (user1.getFollowedList().get(i).equals(user2))
            {
                return true;
            }
        }
        return false;
    }

    public boolean IsEachOtherFollowing(UserClass user1,UserClass user2)
    {
        for (int i =0; i< user1.getFollowedList().size();i++)
        {
            if (user1.getFollowedList().get(i).equals(user2.getFollowedList().get(i)) )
            {
                for (int j=0; j < user2.getFollowedList().size() ;j++)
                {
                    if (user2.getFollowedList().get(j).equals(user1.getFollowedList().get(j)) )
                    {
                        return true;//if both side is following each other return True
                    }
                }
            }
        }

        return false;//if it doesnt return true from top it returns false


    }




}
