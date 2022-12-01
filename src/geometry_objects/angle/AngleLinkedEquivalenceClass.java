package geometry_objects.angle;

import geometry_objects.angle.comparators.AngleStructureComparator;
import utilities.eq_classes.LinkedEquivalenceClass;

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
public class AngleLinkedEquivalenceClass extends utilities.LinkedEquivalenceClass<Angle>
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
    
    @Override
    public void setCanonical(Angle element) {
    	if (_comparator.compare(element, _canonical) == -1) _canonical = element;
    }
    
    @Override
    public boolean demoteAndSetCanonical(Angle a) {
    	// TODO
    }
    
    @Override
    public String toString() {
    	// TODO
    }
    
    @Override
    public boolean contains(Angle a) {
    	// TODO
    }
    
    @Override
    public boolean add(Angle a) {
    	// TODO
    }
}