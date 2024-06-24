
public class Application {
	public static void main(String[] args) {
		System.out.println("Hello, World");
	}
}






















































































































































































































































































































































































































































































































































































// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import javax.imageio.ImageIO;

// public class BezierCurve {
//     private static final int WIDTH = 200;
//     private static final int HEIGHT = 200;

//     private static final int[][] controlPoints = {
//         {10, 10},
//         {20, 130},
//         {110, 180},
//         {190, 30}
//     };

//     public static void main(String[] args) {
//         BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
//         Graphics g = image.getGraphics();

//         // Fill background with black
//         g.setColor(Color.BLACK);
//         g.fillRect(0, 0, WIDTH, HEIGHT);

//         // Draw the original Bézier curve in white
//         g.setColor(Color.WHITE);
//         drawBezierCurve(g, controlPoints, 1000);

//         // Draw the control polygon in green
//         g.setColor(Color.GREEN);
//         drawControlPolygon(g, controlPoints);

//         // Divide the Bézier curve at t = 0.5
//         double t = 0.5;
//         int[][][] dividedCurves = deCasteljauSplit(controlPoints, t);

//         // Draw the control polygons of the two sub-curves
//         g.setColor(Color.BLUE);
//         drawControlPolygon(g, dividedCurves[0]);
//         g.setColor(Color.RED);
//         drawControlPolygon(g, dividedCurves[1]);

//         // Save the image
//         try {
//             ImageIO.write(image, "png", new File("result.png"));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private static void drawBezierCurve(Graphics g, int[][] points, int steps) {
//         for (int i = 0; i < steps; i++) {
//             double t = (double) i / (steps - 1);
//             int[] p = deCasteljau(points, t);
//             g.drawLine(p[0], p[1], p[0], p[1]);
//         }
//     }

//     private static void drawControlPolygon(Graphics g, int[][] points) {
//         for (int i = 0; i < points.length - 1; i++) {
//             g.drawLine(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
//         }
//     }

//     private static int[] deCasteljau(int[][] points, double t) {
//         int n = points.length - 1;
//         int[][] temp = new int[n + 1][2];
//         for (int i = 0; i <= n; i++) {
//             temp[i][0] = points[i][0];
//             temp[i][1] = points[i][1];
//         }
//         for (int k = 1; k <= n; k++) {
//             for (int i = 0; i <= n - k; i++) {
//                 temp[i][0] = (int) ((1 - t) * temp[i][0] + t * temp[i + 1][0]);
//                 temp[i][1] = (int) ((1 - t) * temp[i][1] + t * temp[i + 1][1]);
//             }
//         }
//         return temp[0];
//     }

//     private static int[][][] deCasteljauSplit(int[][] points, double t) {
//         int n = points.length - 1;
//         int[][] left = new int[n + 1][2];
//         int[][] right = new int[n + 1][2];
//         int[][] temp = new int[n + 1][2];
//         for (int i = 0; i <= n; i++) {
//             temp[i][0] = points[i][0];
//             temp[i][1] = points[i][1];
//         }
//         for (int k = 0; k <= n; k++) {
//             left[k][0] = temp[0][0];
//             left[k][1] = temp[0][1];
//             right[n - k][0] = temp[n - k][0];
//             right[n - k][1] = temp[n - k][1];
//             for (int i = 0; i <= n - k - 1; i++) {
//                 temp[i][0] = (int) ((1 - t) * temp[i][0] + t * temp[i + 1][0]);
//                 temp[i][1] = (int) ((1 - t) * temp[i][1] + t * temp[i + 1][1]);
//             }
//         }
//         return new int[][][] {left, right};
//     }
// }
//NExt
// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import javax.imageio.ImageIO;

// public class BezierCurve {
//     private static final int WIDTH = 200;
//     private static final int HEIGHT = 200;

//     private static final int[][] controlPoints = {
//         {10, 10},
//         {20, 130},
//         {110, 180},
//         {190, 30}
//     };

//     public static void main(String[] args) {
//         BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
//         Graphics g = image.getGraphics();

//         // Fill background with black
//         g.setColor(Color.BLACK);
//         g.fillRect(0, 0, WIDTH, HEIGHT);

//         // Draw the original Bézier curve in white
//         g.setColor(Color.WHITE);
//         drawBezierCurve(g, controlPoints, 1000);

//         // Draw the control polygon in green
//         g.setColor(Color.GREEN);
//         drawControlPolygon(g, controlPoints);

//         // Subdivide and draw the subdivisions
//         int[][] subdivPoints = {
//             {10, 10},
//             {60, 40},
//             {100, 120},
//             {140, 40},
//             {190, 30}
//         };
//         drawSubdivisions(g, subdivPoints);

//         // Fill the original control polygon
//         fillControlPolygon(g, controlPoints);

//         // Save the image
//         try {
//             ImageIO.write(image, "png", new File("result.png"));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private static void drawBezierCurve(Graphics g, int[][] points, int steps) {
//         for (int i = 0; i < steps; i++) {
//             double t = (double) i / (steps - 1);
//             int[] p = deCasteljau(points, t);
//             g.drawLine(p[0], p[1], p[0], p[1]);
//         }
//     }

//     private static void drawControlPolygon(Graphics g, int[][] points) {
//         for (int i = 0; i < points.length - 1; i++) {
//             g.drawLine(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
//         }
//     }

//     private static int[] deCasteljau(int[][] points, double t) {
//         int n = points.length - 1;
//         int[][] temp = new int[n + 1][2];
//         for (int i = 0; i <= n; i++) {
//             temp[i][0] = points[i][0];
//             temp[i][1] = points[i][1];
//         }
//         for (int k = 1; k <= n; k++) {
//             for (int i = 0; i <= n - k; i++) {
//                 temp[i][0] = (int) ((1 - t) * temp[i][0] + t * temp[i + 1][0]);
//                 temp[i][1] = (int) ((1 - t) * temp[i][1] + t * temp[i + 1][1]);
//             }
//         }
//         return temp[0];
//     }

//     private static int[][][] deCasteljauSplit(int[][] points, double t) {
//         int n = points.length - 1;
//         int[][] left = new int[n + 1][2];
//         int[][] right = new int[n + 1][2];
//         int[][] temp = new int[n + 1][2];
//         for (int i = 0; i <= n; i++) {
//             temp[i][0] = points[i][0];
//             temp[i][1] = points[i][1];
//         }
//         for (int k = 0; k <= n; k++) {
//             left[k][0] = temp[0][0];
//             left[k][1] = temp[0][1];
//             right[n - k][0] = temp[n - k][0];
//             right[n - k][1] = temp[n - k][1];
//             for (int i = 0; i <= n - k - 1; i++) {
//                 temp[i][0] = (int) ((1 - t) * temp[i][0] + t * temp[i + 1][0]);
//                 temp[i][1] = (int) ((1 - t) * temp[i][1] + t * temp[i + 1][1]);
//             }
//         }
//         return new int[][][] {left, right};
//     }

//     private static void drawSubdivisions(Graphics g, int[][] points) {
//         Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GRAY};
//         for (int i = 0; i < colors.length; i++) {
//             g.setColor(colors[i]);
//             for (int j = 0; j < points.length - 1; j++) {
//                 g.drawLine(points[j][0], points[j][1], points[j+1][0], points[j+1][1]);
//                 points[j][0] = (points[j][0] + points[j+1][0]) / 2;
//                 points[j][1] = (points[j][1] + points[j+1][1]) / 2;
//             }
//         }
//     }

//     private static void fillControlPolygon(Graphics g, int[][] points) {
//         int[] xPoints = new int[points.length];
//         int[] yPoints = new int[points.length];
//         for (int i = 0; i < points.length; i++) {
//             xPoints[i] = points[i][0];
//             yPoints[i] = points[i][1];
//         }
//         g.setColor(Color.WHITE);
//         g.fillPolygon(xPoints, yPoints, points.length);
//     }
// }
