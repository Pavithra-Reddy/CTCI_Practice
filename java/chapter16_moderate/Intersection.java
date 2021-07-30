package chapter16_moderate;

class Point{
	double x;
	double y;
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
}

//y = mx + c
class Line{
	Point start;
	Point end;
	double m;
	double c;
	
	public Line(Point start, Point end) {
		super();
		this.start = start;
		this.end = end;
		setSlope();
		setConstant();
	}

	private void setSlope() {
		this.m = (start.y  - end.y)/(start.x  - end.x);
	}
	private void setConstant() {
		this.c = start.y  - (m * start.x);
	}
}

public class Intersection {
	public static void main(String[] args) {
		Line l1 = new Line(new Point(1,7), new Point(1,5));
		Line l2 = new Line(new Point(4,6), new Point(5,8));
		Point res = findIntersectionPoint(l1,l2);
		if(res != null) {
			System.out.println("x,y => " + res.x +","+res.y);
		}
	}

	private static Point findIntersectionPoint(Line l1, Line l2) {
		if(l1.m == l2.m) {
			//Parallel Lines
			//if same line
			if(l1.c == l2.c) {
				System.out.println("Same Line");
				return null;
			}
			System.out.println("Parallel Lines");
			return null;
		}
		
		//if start points are same
		if(l1.start.x == l2.start.x && l1.start.y == l2.start.y) {
			return l1.start;
		}
		
		//if end points are same
		if(l1.end.x == l2.end.x && l1.end.y == l2.end.y) {
			return l1.end;
		}
		
		double x = 0;
		double y = 0;
		boolean isYFound = false;
		boolean isXFound = false;
		Line l = null;
		
		//parallel to x axis
		if(l1.start.y == l1.end.y) {
			y = l1.start.y;
			l = l2;
			isYFound = true;
		}
		else if(l2.start.y == l2.end.y){
			y = l2.start.y;
			l = l1;
			isYFound = true;
		}
		
		//parallel to y axis
		if(l1.start.x == l1.end.x) {
			x = l1.start.x;
			l = l2;
			isXFound = true;
		}
		else if(l2.start.x == l2.end.x){
			x = l2.start.x;
			l = l1;
			isXFound = true;
		}
		
		//if atleast one line is parallel to either x or y axis
		if(isYFound && isXFound) {
			return new Point(x,y);
		}
		else if(isYFound) {
			x = (y - l.c)/l.m;
			return new Point(x,y);
		}
		else if(isXFound) {
			y = l.m*x;
			return new Point(x,y);
		}
		
		
		y = ((l1.c*l2.m) - (l2.c*l1.m))/(l2.m-l1.m);
		x = (y - l1.c)/l1.m;
		
		return new Point(x,y);
	}

}
