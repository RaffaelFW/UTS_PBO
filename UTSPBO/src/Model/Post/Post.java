package Model.Post;
import  Model.ContentState;
import Model.ContentType;

import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDateTime;

public abstract class Post {
    private String postID;
    private ArrayList<ContentState> status = new ArrayList<>();
    private Date timestamp;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private  ArrayList<ContentType> postType = new ArrayList<>();

    public Post(String postID, ArrayList<ContentState> status, Date timestamp, ArrayList<ContentType> postType) {
        this.postID = postID;
        this.status = status;
        this.timestamp = timestamp;
        this.postType = postType;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public ArrayList<ContentState> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<ContentState> status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<ContentType> getPostType() {
        return postType;
    }

    public void setPostType(ArrayList<ContentType> postType) {
        this.postType = postType;
    }
}
