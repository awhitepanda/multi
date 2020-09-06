package swing;

import javax.swing.*;
import java.awt.*;

/**
 *  @author qianxi
 *  @email qianx@hopshine.net
 *  @date 2020/9/4
 *  @copyright ©2020 All Right Reserved
 *  @description
 * <p>
 * [Java画图]画函数图像 - jklongint - 博客园
 * https://www.cnblogs.com/jklongint/p/4843126.html
 */

public class DrawFunction extends JFrame {
    // axis X Y limit
    private static double timesx = 10, timesy = 10;
    // width high
    static int W = 1600, H = 1200;

    int x0, y0;
    Graphics G;


    double F(double x) {
        return
                //        Math.sin(x) / Math.pow(1.1, -x);//函数表达式
                //        x * Math.log(x);
                Math.ceil(x);
    }

    public static void main(String[] args) {
        DrawFunction frame = new DrawFunction();

        frame.setTitle("DrawFunction");
        frame.setSize(W, H);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }


    public void setOrigin(int x, int y) {
        this.x0 = x;
        this.y0 = y;
        // show coordinate axis
        drawLine(-W / 2, 0, W / 2, 0);
        drawLine(0, -H / 2, 0, H / 2);
        drawString("X", W / 2 - 30, -20);
        drawString("Y", -20, H / 2 - 20);
        for (int i = 1; i <= 10; i++) {
            draw(W / 2 - i - 6, i);
            draw(W / 2 - i - 6, -i);
        }
        for (int i = 1; i <= 10; i++) {
            draw(-i, H / 2 - i);
            draw(i, H / 2 - i);
        }
    }

    public DrawFunction() {
        add(new NewPanel());
    }

    public class Coordinate2D {
        int x, y;

        public Coordinate2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getPixelPointX() {
            return x0 + x;
        }

        public int getPixelPointY() {
            return y0 - y;
        }
    }

    class NewPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            G = g;
            setOrigin(W / 2, H / 2);
            // in the following , draw what you want draw!
            for (int i = -W / 2; i <= W / 2; i++) {
                draw(i, work(i));
            }
            /*
            for (int i = 0; i < 1000; i ++) {
                int x = (int)(Math.random() * 400 - 200);
                int y = (int)(Math.random() * 400 - 200);
                drawString("哈哈", x, y);
            }
            */
        }
    }

    int work(int x) {
        //timesx = 0.01;
        //timesy = 100;
        return (int) (F(x / timesx) * timesy);
    }

    public void draw(int x, int y) {
        int X = new Coordinate2D(x, y).getPixelPointX();
        int Y = new Coordinate2D(x, y).getPixelPointY();
        G.drawLine(X, Y, X, Y);
    }

    public void drawRec(int x1, int y1, int x2, int y2) {
        int dx = x1 < x2 ? 1 : -1;
        int dy = y1 < y2 ? 1 : -1;
        for (int i = x1; i != x2 + dx; i += dx) {
            for (int j = y1; j != y2 + dy; j += dy) {
                draw(i, j);
            }
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = x1 < x2 ? 1 : -1;
        if (x1 == x2) drawRec(x1, y1, x2, y2);
        else {
            double d = (double) (y2 - y1) / (x2 - x1);
            for (int i = x1; i != x2 + dx; i += dx) {
                draw(i, (int) (y1 + (i - x1) * d));
            }
        }
    }

    public void drawString(String s, int x, int y) {
        int X = new Coordinate2D(x, y).getPixelPointX();
        int Y = new Coordinate2D(x, y).getPixelPointY();
        G.drawString(s, X, Y);
    }
}