package geometry_objects.angle;

import java.util.ArrayList;
import java.util.List;

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
public class AngleEquivalenceClasses extends EquivalenceClasses<Angle>
{	
	public AngleEquivalenceClasses() {
		super(new AngleStructureComparator());
		//super._rest = new ArrayList<((LinkedEquivalenceClass<Angle>) AngleLinkedEquivalenceClass)>();
		//super._rest = new ArrayList<AngleLinkedEquivalenceClass>();
	}
	
	/**
	 * Locates which Linked Equivalence Class angle belongs in and then adds it
	 * 
	 * @param Angle element
	 * @return boolean (true if element is added)
	 * */
	public boolean add(Angle element) 
	{	
		for(int i = 0; i < _rest.size(); i++) 
		{
			if(_rest.get(i).belongs(element)) 
			{
				_rest.get(i).add(element);
				return true;
			}
		}
		
		LinkedEquivalenceClass<Angle> lec = new AngleLinkedEquivalenceClass();
		if (!lec.add(element)) return false;
		return _rest.add(lec);
	}
}