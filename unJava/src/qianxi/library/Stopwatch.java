package qianxi.library;

/**
 *  @author qianxi
 *  @email qianx@hopshine.net
 *  @date 2020/9/2
 *  @copyright ©2020 All Right Reserved
 *  @description use example: stopwatch = new Stopwatch(); Thread.sleep(2000); System.out.println(stopwatch.elapsedTime());
 */

public class Stopwatch {
    /**
     * stopwatch: time spent
     */
    private final long start;

    public Stopwatch() {start = System.currentTimeMillis();}

    /**
     * Returns the elapsed CPU time (in seconds) :now - start
     * come to light, 1000 millisecond =1 second
     *
     * @return elapsed CPU time (in seconds) since the {Stopwatch} was created
     */
    public double elapsedTime() {
        return (System.currentTimeMillis() - start) / 1000.0;
    }
}
