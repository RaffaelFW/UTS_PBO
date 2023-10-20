package Model;
import Model.ContentState;
import java.util.ArrayList;

public class Comment {
    private String commentID;
    private String text;
    private ArrayList<ContentState> status = new ArrayList<>();

    public Comment(String commentID, String text, ArrayList<ContentState> status) {
        this.commentID = commentID;
        this.text = text;
        this.status = status;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<ContentState> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<ContentState> status) {
        this.status = status;
    }
}
