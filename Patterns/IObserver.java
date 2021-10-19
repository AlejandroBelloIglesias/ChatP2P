package Patterns;

public interface IObserver {
    public void update(IObservable observable);
    public void update(IObservable observable, Object args);
}
