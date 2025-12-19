package Observer;

import Domain.Event.Event;

public interface IObservable<T extends Event> {
    void addObserver(IObserver<T> e);
    void removeObserver(IObserver<T> e);
    void notifyObservers(T e);
}
