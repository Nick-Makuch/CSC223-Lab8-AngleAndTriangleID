package geometry_objects.angle;

import geometry_objects.angle.comparators.AngleStructureComparator;
import utilities.EquivalenceClasses;

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
 * Equivalence classes structure we want:
 * 
 *   canonical = BAE
 *   rest = BAF, CAE, DAE, CAF, DAF
 */
public class AngleEquivalenceClasses extends utilities.EquivalenceClasses<Angle>
{
	public AngleEquivalenceClasses() {
		super(new AngleStructureComparator());
	}
	
	public boolean add(Angle element) {
		for(int i = 0; i < _rest.size(); i++) 
		{
			if(_rest.get(i).belongs(element)) 
			{
				_rest.get(i).add(element);
				return true;
			}
		}
		
		return false;
	}
}