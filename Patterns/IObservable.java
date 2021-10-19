package Patterns;

public interface IObservable {
    public void addObserver(IObserver observer);
    public void delObserver(IObserver observer);
    public void notifyObservers();
    public void notifyObservers(Object args);
}