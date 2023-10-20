package Controller;
import Model.*;
import Model.Post.Feed;
import Model.Post.Post;
import Model.Post.Reel;
import Model.Post.Story;

import java.util.*;
public class Controller {

    public ArrayList<Post> posts = new ArrayList<>(){
        {
            add(new Reel("001",new ArrayList<ContentState>(){
                {
                    add((ContentState.SHOWED));
                }
            },new Date(12/3/2023),new ArrayList<ContentType>(){
                {
                    add((ContentType.PICTURE));
                }
            },30,12));

            add(new Feed("002",new ArrayList<ContentState>(){
                {
                    add((ContentState.SHOWED));
                }
            },new Date(12/3/2023),new ArrayList<ContentType>(){
                {
                    add((ContentType.PICTURE));
                }
            },"Chillin with the Homies",17));
            add(new Story("003",new ArrayList<ContentState>(){
                {
                    add((ContentState.SHOWED));
                }
            },new Date(12/3/2023),new ArrayList<ContentType>(){
                {
                    add((ContentType.VIDEO));
                }
            },30,100));

        }
    };

    public ArrayList<User> users = new ArrayList<>(){
        {
            add(new User("Cube123","IceCube","SouthCompton","Professional Rapper", posts.subList(0,1),comments.subList(0,1)));
            add(new User("Eazy123","Eazy-E","SouthHampton","A Member of NWA.",posts.subList(1,2),comments.subList(1,2)));
            add(new User("Michael","JumpMan23","NorthCarolina","GOAT.",posts.subList(2,3),comments.subList(2,3)));
        }
    };

    public ArrayList<Comment> comments = new ArrayList<>(){
        {
        add(new Comment("101","Nice bro.",new ArrayList<ContentState>(){
            {
                add((ContentState.PINNED));
            }
                }));
        add(new Comment("201","Good Stuff bro.",new ArrayList<ContentState>(){
                {
                    add((ContentState.ARCHIVED));
                }
                }));
        add(new Comment("301","Really bro?.",new ArrayList<ContentState>(){
                {
                    add((ContentState.SHOWED));
                }}));
        }
    };
    public void showUserPosts(User user, String username) {
        System.out.println("Showing posts for user: " + username);
        for (User users : users) {
            if(username.equals(user.getUsername())) {
                posts.addAll(user.getUserposts());
                Collections.sort(posts, new Comparator<Post>() {
                    public int compare(Post p1, Post p2) {
                        int statusComparison = compareStatus(p1, p2);
                        if (statusComparison != 0) {
                            return statusComparison;
                        } else {
                            return p1.getTimestamp().compareTo(p2.getTimestamp());
                        }
                    }

                    private int compareStatus(Post p1, Post p2) {
                        if (p1.getStatus().contains(ContentState.PINNED)) {
                            return -1;
                        } else if (p2.getStatus().contains(ContentState.PINNED)) {
                            return 1;
                        } else if (p1.getStatus().contains(ContentState.SHOWED) && p2.getStatus().contains(ContentState.ARCHIVED)) {
                            return -1;
                        } else if (p1.getStatus().contains(ContentState.ARCHIVED) && p2.getStatus().contains(ContentState.SHOWED)) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                });


                for (Post post : posts) {
                    if (post instanceof Feed) {
                        Feed feed = (Feed) post;
                        if (post.getStatus().contains(ContentState.PINNED)) {
                            System.out.println("Pinned Feed - Caption: " + feed.getCaption() + ", Likes: " + feed.getLikes());
                        } else {
                            System.out.println("Feed - Caption: " + feed.getCaption() + ", Likes: " + feed.getLikes() + ", Time: " + feed.getTimestamp());
                        }
                    } else if (post instanceof Story) {
                        Story story = (Story) post;
                        if (post.getStatus().contains(ContentState.PINNED)) {
                            System.out.println("Pinned Story - Duration: " + story.getDuration() + " seconds, Views: " + story.getViews());
                        } else {
                            System.out.println("Story - Duration: " + story.getDuration() + " seconds, Views: " + story.getViews() + ", Time: " + story.getTimestamp());
                        }
                    } else if (post instanceof Reel) {
                        Reel reel = (Reel) post;
                        if (post.getStatus().contains(ContentState.PINNED)) {
                            System.out.println("Pinned Reel - Duration: " + reel.getDuration() + " seconds, Played Count: " + reel.getPlayedCount());
                        } else {
                            System.out.println("Reel - Duration: " + reel.getDuration() + " seconds, Played Count: " + reel.getPlayedCount() + ", Time: " + reel.getTimestamp());
                        }
                    }
                }
            }
        }
    }

    public void showPost(String postID) {
        for (Post post : posts) {
            if (post.getPostID().equals(postID)) {
                if (post instanceof Feed) {
                    Feed feed = (Feed) post;
                    System.out.println("Post ID: " + feed.getPostID());
                    System.out.println("Type: Feed");
                    System.out.println("Caption: " + feed.getCaption());
                    System.out.println("Likes: " + feed.getLikes());
                    System.out.println("Status: " + feed.getStatus());
                    System.out.println("Timestamp: " + feed.getTimestamp());
                } else if (post instanceof Story) {
                    Story story = (Story) post;
                    System.out.println("Post ID: " + story.getPostID());
                    System.out.println("Type: Story");
                    System.out.println("Duration: " + story.getDuration() + " seconds");
                    System.out.println("Views: " + story.getViews());
                    System.out.println("Status: " + story.getStatus());
                    System.out.println("Timestamp: " + story.getTimestamp());
                } else if (post instanceof Reel) {
                    Reel reel = (Reel) post;
                    System.out.println("Post ID: " + reel.getPostID());
                    System.out.println("Type: Reel");
                    System.out.println("Duration: " + reel.getDuration() + " seconds");
                    System.out.println("Played Count: " + reel.getPlayedCount());
                    System.out.println("Status: " + reel.getStatus());
                    System.out.println("Timestamp: " + reel.getTimestamp());
                }
                return;
            }
        }
        System.out.println("Post with ID " + postID + " not found.");
    }

    public void changePostState(User user, String postID, ContentState newState) {
        for (Post post : user.getUserposts()) {
            if (post.getPostID().equals(postID)) {
                List<ContentState> status = post.getStatus();
                if (status.contains(ContentState.SHOWED) && (newState == ContentState.ARCHIVED || newState == ContentState.PINNED)) {
                    status.remove(ContentState.SHOWED);
                    status.add(newState);
                } else if (status.contains(ContentState.ARCHIVED) && newState == ContentState.DELETED) {
                    status.remove(ContentState.ARCHIVED);
                    status.add(newState);
                } else if (status.contains(ContentState.PINNED) && newState == ContentState.ARCHIVED) {
                    status.remove(ContentState.PINNED);
                    status.add(newState);
                } else if (status.contains(ContentState.SHOWED) && newState == ContentState.PINNED && post instanceof Feed) {
                    int pinnedCount = 0;
                    for (Post p : user.getUserposts()) {
                        if (p.getStatus().contains(ContentState.PINNED) && p instanceof Feed) {
                            pinnedCount++;
                        }
                    }
                    if (pinnedCount < 3) {
                        status.remove(ContentState.SHOWED);
                        status.add(newState);
                    } else {
                        System.out.println("Cannot set more than 3 posts as pinned.");
                    }
                } else {
                    System.out.println("Invalid state transition.");
                }
                return;
            }
        }
        System.out.println("Post with ID " + postID + " not found.");
    }


}
