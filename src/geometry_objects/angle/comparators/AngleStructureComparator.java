/**
 * Write a succinct, meaningful description of the class here. You should avoid wordiness    
 * and redundancy. If necessary, additional paragraphs should be preceded by <p>,
 * the html tag for a new paragraph.
 *
 * <p>Bugs: (a list of bugs and / or other problems)
 *
 * @author <your name>
 * @date   <date of completion>
 */

package geometry_objects.angle.comparators;

import java.util.Comparator;

import geometry_objects.Segment;
import geometry_objects.angle.Angle;
import geometry_objects.points.Point;
import utilities.math.MathUtilities;
import utilities.math.analytic_geometry.GeometryUtilities;

public class AngleStructureComparator implements Comparator<Angle>
{
	public static final int STRUCTURALLY_INCOMPARABLE = Integer.MAX_VALUE;
	
	/**
	 * Given the figure below:
	 * 
	 *    A-------B----C-----------D
	 *     \
	 *      \
	 *       \
	 *        E
	 *         \
	 *          \
	 *           F
	 * 
	 * What we care about is the fact that angle BAE is the smallest angle (structurally)
	 * and DAF is the largest angle (structurally). 
	 * 
	 * If one angle X has both rays (segments) that are subsegments of an angle Y, then X < Y.
	 * 
	 * If only one segment of an angle is a subsegment, then no conclusion can be made.
	 * 
	 * So:
	 *     BAE < CAE
   	 *     BAE < DAF
   	 *     CAF < DAF

   	 *     CAE inconclusive BAF
	 * 
	 * @param left -- an angle
	 * @param right -- an angle
	 * @return -- according to the algorithm above:
 	 *            Integer.MAX_VALUE will refer to our error result
 	 *            0 indicates an inconclusive result
	 */
	@Override
	public int compare(Angle left, Angle right) {
		// if either of angles are null
		if (left == null || right == null) return STRUCTURALLY_INCOMPARABLE;
		
		// they don't share vertices
		if (!left.getVertex().equals(right.getVertex())) return STRUCTURALLY_INCOMPARABLE;
		// the rays don't overlap
		
		if ((!Segment.overlaysAsRay(left.getRay1(), right.getRay1()) && !Segment.overlaysAsRay(left.getRay1(), right.getRay2())) || 
				(!Segment.overlaysAsRay(left.getRay2(), right.getRay1()) && !Segment.overlaysAsRay(left.getRay2(), right.getRay2()))) 
				return STRUCTURALLY_INCOMPARABLE;

		if (left.equals(right)) return 0;
		
		// if one of left's rays is equal to the right's corresponding ray but the others differ in length
		if (left.getRay1().equals(right.getRay1()) && (left.getRay2().length() > right.getRay2().length())) return 1;
		if (left.getRay1().equals(right.getRay2()) && (left.getRay2().length() < right.getRay1().length())) return -1;
		if (left.getRay2().equals(right.getRay1()) && (left.getRay1().length() > right.getRay2().length())) return 1;
		if (left.getRay2().equals(right.getRay2()) && (left.getRay1().length() < right.getRay1().length())) return -1;
		
		// if both of left's rays are greater than both of right's rays
		if ((left.getRay1().HasSubSegment(right.getRay1()) || left.getRay1().HasSubSegment(right.getRay2())) &&
				(left.getRay2().HasSubSegment(right.getRay1()) || left.getRay2().HasSubSegment(right.getRay2()))) return 1;
		// if both of right's rays are greater than both of left's rays
		if ((right.getRay1().HasSubSegment(left.getRay1()) || right.getRay1().HasSubSegment(left.getRay2())) &&
				(right.getRay2().HasSubSegment(left.getRay1()) || right.getRay2().HasSubSegment(left.getRay2()))) return -1;
		return 0;
	}
}
