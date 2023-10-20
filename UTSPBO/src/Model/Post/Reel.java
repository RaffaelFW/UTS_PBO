package Model.Post;

import Model.ContentState;
import Model.ContentType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Reel extends Post{
    private int duration;
    private int playedCount;

    public Reel(String postID, ArrayList<ContentState> status, Date timestamp, ArrayList<ContentType> postType, int duration, int playedCount) {
        super(postID, status, timestamp, postType);
        this.duration = duration;
        this.playedCount = playedCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedCount() {
        return playedCount;
    }

    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }
}
