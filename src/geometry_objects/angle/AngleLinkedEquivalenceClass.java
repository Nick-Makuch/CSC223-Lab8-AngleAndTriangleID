package geometry_objects.angle;

import java.util.List;

import geometry_objects.angle.comparators.AngleStructureComparator;
import utilities.LinkedEquivalenceClass;

/**
 * This implementation requires greater knowledge of the implementing Comparator.
 * 
 * According to our specifications for the AngleStructureComparator, we have
 * the following cases:
 *
 *    Consider Angles A and B
 *    * Integer.MAX_VALUE -- indicates that A and B are completely incomparable
                             STRUCTURALLY (have different measure, don't share sides, etc. )
 *    * 0 -- The result is indeterminate:
 *           A and B are structurally the same, but it is not clear one is structurally
 *           smaller (or larger) than another
 *    * 1 -- A > B structurally
 *    * -1 -- A < B structurally
 *    
 *    We want the 'smallest' angle structurally to be the canonical element of an
 *    equivalence class.
 * 
 * @author XXX
 */
public class AngleLinkedEquivalenceClass extends LinkedEquivalenceClass<Angle>
{
    public AngleLinkedEquivalenceClass() {
    	super(new AngleStructureComparator());
    }
    
    /**
     * angles with the same vertex and overlapping rays are equivalent
     * 
     * @param a
     * @return true if a belongs in equivalence class
     */
    @Override
    public boolean belongs(Angle a) {
    	if (a == null) return false;
    	return (_comparator.compare(a, _canonical) == 1 || _comparator.compare(a, _canonical) == -1
    			|| _comparator.compare(a, _canonical) == 0);
    }
    
    /**
     * adds an element and sets it as the canonical element if it's 
     * smaller than the current canonical element
     * 
     * @param a
     * @return true if element is added successfully
     */
    @Override
    public boolean add(Angle a) {
    	if (_canonical == null) {
    		_canonical = a;
    		return true;
    	}
    	if (_comparator.compare(a, _canonical) == -1) 
    		return demoteAndSetCanonical(a);
    	
    	_rest.addToFront(a);
    	
    	return _rest.contains(a);
    }
    
    @Override
    public boolean contains(Angle target) 
    {
    	if(target == null) return false;
    	if(canonical().equals(target) || _rest.contains(target)) return true;
    	return false;
    }
    
    @Override
    public String toString()  
    {
    	StringBuilder str = new StringBuilder();
    	str.append("Canonical: " + _canonical.toString() + " Rest: ");
    	str.append(_rest.toString());
    	
    	return str.toString();
    }
}