package geometry_objects.angle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import exceptions.FactException;
import geometry_objects.Segment;
import geometry_objects.points.Point;

public class angleTest 
{
	/**
	 * 		A
	 *     / \
	 *    B   C
	 *   /     \
	 *  D       E
	 * 
	 * @throws FactException 
	 * 
	 * */
	@Test
	void testEquals() throws FactException 
	{
		Point a = new Point(2.0, 4.0);
		Point b = new Point(1.0, 2.0);
		Point c = new Point(3.0, 2.0);
		Point d = new Point(0.0, 0.0);
		Point e = new Point(4.0, 0.0);
		
		Segment ab = new Segment(a, b);
		Segment ac = new Segment(a, c);
		
		Angle bac = new Angle(ab, ac);
		Angle cab = new Angle(ac, ab);
		
		assertTrue(bac.equals(cab));
		
		Segment ae = new Segment(a, e);
		Angle bae = new Angle(ab, ae);
		
		assertFalse(bac.equals(bae));
	}
}
