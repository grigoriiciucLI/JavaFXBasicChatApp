package Domain.Event;

import Domain.User.User;

import java.time.LocalDateTime;

public class Notification {
    private boolean seen = false;
    User receiver;
    String content;
    LocalDateTime generatedOn;
    LocalDateTime seenOn;
    Integer id;

    public Notification(User receiver, String content) {
        this.id = null;
        this.receiver = receiver;
        this.content = content;
        generatedOn = LocalDateTime.now();
    }

    public Notification(boolean seen, User receiver, String content, LocalDateTime generatedOn, LocalDateTime seenOn, Integer id) {
        this.seen = seen;
        this.receiver = receiver;
        this.content = content;
        this.generatedOn = generatedOn;
        this.seenOn = seenOn;
        this.id = id;
    }

    public void setSeenAsTrue() {
        this.seen = true;
        seenOn = LocalDateTime.now();
    }
}
