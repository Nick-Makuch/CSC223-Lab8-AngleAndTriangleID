package geometry_objects.angle.comparators;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import geometry_objects.Segment;
import geometry_objects.angle.Angle;
import geometry_objects.points.Point;

public class AngleStructureComparatorTest {

	@Test
	void compareTest() {
		//
		//  A(0,0)-----B(8,0)--C(12,0)---D(15,0)
		//   \
		//    \
		//     \
		//      E(2,4)
		//       \
		//        \
		//         F (4,6)
		// 
		Point a = new Point(0,0);
		Point b = new Point(8,0);
		Point c = new Point(12,0);
		Point d = new Point(15,0);
		Point e = new Point(2,4);
		Point f = new Point(4,6);
		Segment ab = new Segment(a,b);
		Segment ac = new Segment(a,c);
		Segment ad = new Segment(a,d);
		Segment ae = new Segment(a,e);
		Segment af = new Segment(a,f);
		Segment cb = new Segment(c,b);
		Segment cd = new Segment(c,d);
		AngleStructureComparator comp = new AngleStructureComparator();
		try {
			Angle bae = new Angle(ab, ae);
			Angle baf = new Angle(ab, af);
			Angle cae = new Angle(ac, ae);
			Angle caf = new Angle(ac, af);
			Angle dcb = new Angle(cb, cd);
			assertEquals(-1, comp.compare(bae, baf));
			assertEquals(1, comp.compare(caf, bae));
			assertEquals(0, comp.compare(baf, cae));
			assertEquals(Integer.MAX_VALUE, comp.compare(bae, dcb));
		}
		catch (Exception exc){
			System.out.println("You messed up");
		}
		
		
		
	}
}
