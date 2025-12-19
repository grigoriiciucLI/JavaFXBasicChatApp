package Observer;

import Domain.Event.Event;

public interface IObserver<T extends Event> {
    void update(T e);

}
