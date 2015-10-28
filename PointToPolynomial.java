import java.util.ArrayList;
import java.util.Collection;

import util.Point2D;

public class PointToPolynomial {

	public static void main(String[] argv) {
		new PointToPolynomial().start();
	}
	
	public void start() {
		Collection<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D(2,4));
		points.add(new Point2D(3,8));
		String output = "$ f(x) = ";
		for (Point2D p : points) {
			Collection<Point2D> pointsbutone = new ArrayList<Point2D>();
			pointsbutone.addAll(points);
			pointsbutone.remove(p);
			output += createTerm(pointsbutone, p);
			output += " + ";
		}
		output = output.substring(0, output.length() - 3);
		System.out.println(output);
	}
	
	public String createTerm(Collection<Point2D> points, Point2D point) {
		String texresult = "(" + point.y + " * ";
		int canceller = 0;
		for (Point2D otherpoint : points) {
			canceller = point.x - otherpoint.x;
			texresult += "\\frac{(x - " + otherpoint.x + ")}{" + canceller + "})";
		}
		return texresult;
	}
	
}
