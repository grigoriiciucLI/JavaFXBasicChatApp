package Observer;

import Domain.Event.Event;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T extends Event> implements IObservable<T> {
    List<IObserver<T>> observers = new ArrayList<>();
    @Override
    public void addObserver(IObserver<T> e){
        observers.add(e);
    }
    @Override
    public void removeObserver(IObserver<T> e){
        observers.remove(e);
    }
    @Override
    public void notifyObservers(T e){
        observers.forEach(o->o.notify());
    }
}
