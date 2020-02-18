package be.technifutur.myframework;

public class TestApplication implements Application {
    private int call = -1;
    private int callFinish = -1;
    private int cpt = 0;

    @Override
    public CharSequence display() {
        this.call = cpt++;
        return "test";
    }

    @Override
    public boolean isFinish() {
        this.callFinish = cpt++;
        return true;
    }

    @Override
    public void receive(String request) {

    }

    public int displayCall() {
        return call;
    }

    public int isFinishCall() {
        return callFinish;
    }
}
