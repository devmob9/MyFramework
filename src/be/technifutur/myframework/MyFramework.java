package be.technifutur.myframework;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyFramework {
    private PrintStream sysout = System.out;
    private InputStream sysin = System.in;
    private Scanner scan = new Scanner(sysin);

    private Consumer<CharSequence> out = (t)->sysout.print(t);
    private Supplier<String> in = ()->scan.nextLine();

    public void setOut(Consumer<CharSequence> out) {
        this.out = out;
    }

    public void setIn(Supplier<String> in) {
        this.in = in;
    }

    public void start(Application app) {
        out.accept(app.display());
        System.setOut(null);
        System.setIn(null);
        while(!app.isFinish()){
            String request = in.get();
            app.receive(request);
            out.accept(app.display());
        }
        System.setOut(sysout);
        System.setIn(sysin);
    }
}
