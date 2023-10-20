package Model.Post;

import Model.ContentState;
import Model.ContentType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Feed extends Post{
    private  String caption;
    private int likes;

    public Feed(String postID, ArrayList<ContentState> status, Date timestamp, ArrayList<ContentType> postType, String caption, int likes) {
        super(postID, status, timestamp, postType);
        this.caption = caption;
        this.likes = likes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
