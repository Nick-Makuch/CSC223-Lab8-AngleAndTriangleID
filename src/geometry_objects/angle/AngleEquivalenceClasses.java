package geometry_objects.angle;

import java.util.ArrayList;

import geometry_objects.angle.comparators.AngleStructureComparator;
import utilities.EquivalenceClasses;
import utilities.LinkedEquivalenceClass;

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
		//super._rest = new ArrayList< (LinkedEquivalenceClass<Angle>) AngleLinkedEquivalenceClass>();
	}
	
	/**
	 * Locates which Linked Equivalence Class angle belongs in and then adds it
	 * 
	 * @param Angle element
	 * @return boolean (true if element is added)
	 * */
	public boolean add(Angle element) {
		for(int i = 0; i < _rest.size(); i++) 
		{
			if(_rest.get(i).belongs(element)) 
			{
				_rest.get(i).add(element);
				return true;
			}
		}
		
		return _rest.contains(element);
	}
}