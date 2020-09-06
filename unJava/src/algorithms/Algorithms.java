package algorithms;

import edu.princeton.cs.algs4.StdDraw;

public class Algorithms {
    public static void main(String[] args) {
        new DrawDemo();
    }
}

class DrawDemo {
    public DrawDemo() {
        final int N = 20;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(0.01);
        for (int i = 1; i <= N; ++i) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * 2);
            StdDraw.point(i, i + 1);
        }
    }
}