package Domain.Event;

import Domain.Entity;
import Domain.User.User;

import java.time.LocalDateTime;

public class Notification extends Entity<Integer> {
    private boolean seen = false;
    User receiver;
    String content;
    LocalDateTime generatedOn;
    LocalDateTime seenOn;

    public Notification(User receiver, String content) {
        super();
        this.receiver = receiver;
        this.content = content;
        generatedOn = LocalDateTime.now();
    }

    public Notification(Integer id, boolean seen, User receiver, String content, LocalDateTime generatedOn, LocalDateTime seenOn) {
        super(id);
        this.seen = seen;
        this.receiver = receiver;
        this.content = content;
        this.generatedOn = generatedOn;
        this.seenOn = seenOn;
    }

    public void setSeenAsTrue() {
        this.seen = true;
        seenOn = LocalDateTime.now();
    }
}
