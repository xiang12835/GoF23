package online.flyingfish.pattern.Observer;

public class CriminalObservable extends Observable {
    public void crime(String event) {
        System.out.println("罪犯正在" + event);
        notifyObservers(event);
    }
}
