package in.rahulbagchi.spring.game;

public class GameRunner {

    private GameConsole console;

    public GameRunner(GameConsole console) {
        this.console = console;
    }

    public void run() {
        System.out.println("running "+console);
        console.up();
        console.down();
        console.left();
        console.right();
    }
}
