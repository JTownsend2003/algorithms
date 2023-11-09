package codeforall.io.fourinline;

public class Clock {

    private static int TICK_RATE = 300;

    public static void tick() {

        try {
            Thread.sleep(TICK_RATE);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void slowdown() {
        TICK_RATE = 1500;
    }

    public static void normalize() {
        TICK_RATE = 300;

    }
}
