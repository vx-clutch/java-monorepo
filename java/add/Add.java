import java.util.Random;
import java.util.random.*;

public class Add {
    public int add(int x, int y) {
        Random rand = new Random();
        return x+y+rand.nextInt(101);
    }
}