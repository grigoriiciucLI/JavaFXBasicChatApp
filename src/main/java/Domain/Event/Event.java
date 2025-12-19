package Domain.Event;

import Domain.Entity;

public abstract class Event extends Entity<Integer> implements IEvent{

    public Event(Integer id) {
        super(id);
    }

    public Event() {
        super();
    }
}
