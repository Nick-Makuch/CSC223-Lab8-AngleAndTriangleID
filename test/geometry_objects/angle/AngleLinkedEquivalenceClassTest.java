package geometry_objects.angle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import exceptions.FactException;
import geometry_objects.Segment;
import geometry_objects.points.Point;

public class AngleLinkedEquivalenceClassTest {

	@Test
	void belongsAndAddTest() {
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
		//
		Point a = new Point(2,2);
		Point b = new Point(6,2);
		Point c = new Point(4,4);
		Point d = new Point(4,2);
		Point e = new Point(0,0);
		Point f = new Point(4,0);
		Point h = new Point(8,0);
		Segment ad = new Segment(a, d);
		Segment ac = new Segment(a, c);
		Segment bc = new Segment(b, c);
		Segment bd = new Segment(b, d);
		Segment cd = new Segment(c, d);
		Segment ce = new Segment(c,e);
		Segment cf = new Segment(c, f);
		Segment ch = new Segment(c, h);
		Segment ef = new Segment(e, f);
		AngleLinkedEquivalenceClass aeq = new AngleLinkedEquivalenceClass();
		
		try {
			Angle adc = new Angle(ad, cd);
			Angle cfe = new Angle(cf, ef);
			Angle acd = new Angle(ac, cd);
			Angle acb = new Angle(ac, bc);
			Angle ech = new Angle(ce, ch);
			aeq.setCanonical(ech);
			assertTrue(aeq.belongs(acb));
			assertFalse(aeq.belongs(acd));
			assertTrue(aeq.add(acb));
			assertTrue(aeq.add(ech));	
			
			aeq.clear();
			aeq.setCanonical(adc);
			assertTrue(aeq.belongs(cfe));
			assertTrue(aeq.add(cfe));
		} catch (FactException exc) {
			System.out.println("You messed up");
		}
	}
}
