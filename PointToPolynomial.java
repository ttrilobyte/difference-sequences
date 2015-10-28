import java.util.ArrayList;
import java.util.Collection;

import util.Point2D;

public class PointToPolynomial {

	public static void main(String[] argv) {
		new PointToPolynomial().start();
	}
	
	public void start() {
		int[] pointlistxyxy = new int[] {1,101,2,102,3,103,4,104,5,105,6,106,7,107};
		//int[] pointlistxyxy = new int[] {2,4,3,8};
		Collection<Point2D> points = new ArrayList<Point2D>();
		for (int i = 0; i < pointlistxyxy.length - 1; i += 2) {
			points.add(new Point2D(pointlistxyxy[i], pointlistxyxy[i + 1]));
		}
		String output = "$ f(x) = ";
		for (Point2D p : points) {
			Collection<Point2D> pointsbutone = new ArrayList<Point2D>();
			pointsbutone.addAll(points);
			pointsbutone.remove(p);
			output += createTerm(pointsbutone, p);
			output += " + ";
		}
		output = output.substring(0, output.length() - 3);
		output += "$";
		System.out.println(output);
	}
	
	public String createTerm(Collection<Point2D> points, Point2D point) {
		String texresult = "(" + point.y + " \\cdot ";
		int canceller = 0;
		for (Point2D otherpoint : points) {
			canceller = point.x - otherpoint.x;
			texresult += "\\frac{(x - " + otherpoint.x + ")}{" + canceller + "}";
		}
		texresult += ")";
		return texresult;
	}
	
}
