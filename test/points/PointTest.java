package points;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometry_objects.points.Point;

class PointTest {
	
	@Test
	void distanceTest() 
	{
		// x(0,0) ------- y (6,0)
		// distance == 6.0
		Point x = new Point("x", 0, 0);
		Point y = new Point("y", 6, 0);
		assertEquals(6.0, Point.distance(x, y));
		
		// x(0,0)
		// |
		// |
		// |
		// y(0,4)
		//
		y = new Point("y", 0, 4);
		assertEquals(4.0, Point.distance(x,y));
		
		// x(1,0)
		//  \
		//   \
		//    \
		//     y(4,4)
		x = new Point("x", 1, 0);
		y = new Point("y", 4, 4);
		assertEquals(5.0, Point.distance(x, y));
	}
}
