package Observer;

import Domain.Event.Event;

public abstract class Observer<T extends Event> implements IObserver<T> {
    @Override
    public abstract void update(T e);
}
