package Model.Post;

import Model.ContentState;
import Model.ContentType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Story extends Post{
    private int duration;
    private int views;

    public Story(String postID, ArrayList<ContentState> status, Date timestamp, ArrayList<ContentType> postType, int duration, int views) {
        super(postID, status, timestamp, postType);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
