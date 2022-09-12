package ru.vsu.cs.rodionovri;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double[] point = new double[2];
        point = inputPoint();
        printColorForPoint(point[0], point[1]);
    }

    public static final HorizontalParabola P1 = new HorizontalParabola(-2, -4, -0.5);
    public static final VerticalParabola P2 = new VerticalParabola(4, -5, 0.25);
    public static final Rectangle R1 = new Rectangle(-5, -3, 3, 4);
    public static final Rectangle R2 = new Rectangle(0, 3, 5, 11);
    public static final Line L1 = new Line(1, 0, 1);

    public static SimpleColor getColor(double x, double y) {
        if ((R2.isPointInOfRectangle(x, y) && !L1.isPointAboveLine(x, y))
                || (R1.isPointInOfRectangle(x, y) && !P1.isPointRightOfParabola(x, y))) {
            return SimpleColor.GREEN;
        } else if ((P2.isPointUpperOfParabola(x, y) && y > 4 && x < 0)
                || !P2.isPointUpperOfParabola(x, y) && (P1.isPointRightOfParabola(x, y) && L1.isPointAboveLine(x, y)
                && R1.isPointInOfRectangle(x, y)) || (!P1.isPointRightOfParabola(x, y) && L1.isPointAboveLine(x, y)
                && !R1.isPointInOfRectangle(x, y))) {
            return SimpleColor.YELLOW;
        } else if ((R1.isPointInOfRectangle(x, y) && R2.isPointInOfRectangle(x, y))
                || (P2.isPointUpperOfParabola(x, y) && !R1.isPointInOfRectangle(x, y) && !R2.isPointInOfRectangle(x, y)
                && !L1.isPointAboveLine(x, y))) {
            return SimpleColor.GRAY;
        } else if ((!P2.isPointUpperOfParabola(x, y) && P1.isPointRightOfParabola(x, y) && y > -1
                && !R1.isPointInOfRectangle(x, y)) || (!L1.isPointAboveLine(x, y) && !P1.isPointRightOfParabola(x, y))
                || R2.isPointInOfRectangle(x, y) && L1.isPointAboveLine(x, y) && !R1.isPointInOfRectangle(x, y)) {
            return SimpleColor.WHITE;
        }
        if ((R1.isPointInOfRectangle(x, y) && !R2.isPointInOfRectangle(x, y) && L1.isPointAboveLine(x, y)
                && P2.isPointUpperOfParabola(x, y)) || (!P2.isPointUpperOfParabola(x, y) && !L1.isPointAboveLine(x, y)
                && R1.isPointInOfRectangle(x, y)) || (L1.isPointAboveLine(x, y) && P1.isPointRightOfParabola(x, y) && x < -7)) {
            return SimpleColor.ORANGE;
        } else {
            return SimpleColor.BLUE;
        }
    }

    public static void printColorForPoint(double x, double y) {
        System.out.println(getColor(x, y));
    }

    public static double[] inputPoint() {
        Scanner scanner = new Scanner(System.in);
        double[] point = new double[2];

        System.out.print("Input X: ");
        point[0] = scanner.nextDouble();
        System.out.print("Input Y: ");
        point[1] = scanner.nextDouble();

        return point;
    }

}