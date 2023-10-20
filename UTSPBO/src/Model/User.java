package Model;

import Model.Post.Post;
import java.util.*;
import Model.Comment;
import com.sun.source.doctree.CommentTree;

public class User {
   private String userID;
   private String username;
   private String password;
   private String bio;

   private List<Post> userposts = new ArrayList<Post>();

   private List<Comment> usercomments= new ArrayList<Comment>();


   public User(String userID, String username, String password, String bio, List<Post> userposts, List<Comment> usercomments) {
      this.userID = userID;
      this.username = username;
      this.password = password;
      this.bio = bio;
      this.userposts = userposts;
      this.usercomments = usercomments;
   }

   public String getUserID() {
      return userID;
   }

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getBio() {
      return bio;
   }

   public void setBio(String bio) {
      this.bio = bio;
   }

   public List<Post> getUserposts() {
      return userposts;
   }

   public void setUserposts(List<Post> userposts) {
      this.userposts = userposts;
   }

   public List<Comment> getUsercomments() {
      return usercomments;
   }

   public void setUsercomments(List<Comment> usercomments) {
      this.usercomments = usercomments;
   }
}
