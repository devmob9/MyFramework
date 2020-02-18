package be.technifutur.myframework;

public interface Application {

    CharSequence display();

    boolean isFinish();

    void receive(String request);
}
