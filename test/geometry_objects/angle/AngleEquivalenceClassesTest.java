package geometry_objects.angle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import geometry_objects.Segment;
import geometry_objects.points.Point;

public class AngleEquivalenceClassesTest {

	@Test
	void addTest() {
		//  E(0,0)----F(4,0)-----H(8,0)
		//   \         |         /
		//    \        |        / 
		//	  A(2,2)--D(4,2)- B(6,2) 
		// 	    \      |      /
		//       \     |     /
		//   	  \    |    /
		//   	   \   |   /
		//   	    \  |  /
		//     	     \ | /
		//            C(4,4)
		
		Point a = new Point("a", 2,2);
		Point b = new Point("b", 6,2);
		Point c = new Point("c", 4,4);
		Point d = new Point("d", 4,2);
		Point e = new Point("e", 0,0);
		Point f = new Point("f", 4,0);
		Point h = new Point("h", 8,0);
		Segment ad = new Segment(a, d);
		Segment ac = new Segment(a, c);
		Segment bc = new Segment(b, c);
		Segment bd = new Segment(b, d);
		Segment cd = new Segment(c, d);
		Segment ce = new Segment(c,e);
		Segment cf = new Segment(c, f);
		Segment ch = new Segment(c, h);
		Segment ef = new Segment(e, f);
		AngleEquivalenceClasses aEqCl = new AngleEquivalenceClasses();

		try {
			Angle adc = new Angle(ad, cd);
			Angle cfe = new Angle(cf, ef);
			Angle acd = new Angle(ac, cd);
			Angle acb = new Angle(ac, bc);
			Angle ech = new Angle(ce, ch);
			Angle bdc = new Angle(bd, cd);
			assertTrue(aEqCl.add(bdc));
			assertTrue(aEqCl.add(adc));
			assertTrue(aEqCl.add(acd));
			assertTrue(aEqCl.add(acb));
			assertTrue(aEqCl.add(ech));
			assertEquals(4, aEqCl.numClasses());
		}
		catch (Exception exc) {
			System.err.println("Angles are invalid");
		}
	}
}
