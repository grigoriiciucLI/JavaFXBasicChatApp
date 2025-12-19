package Domain.Event;

import Domain.Entity;

public abstract class Event implements IEvent {
    Integer id;

    public Event(Integer id) {
        this.id = id;
    }

    public Event() {
        this.id = null;
    }
}
