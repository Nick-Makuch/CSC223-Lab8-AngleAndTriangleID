package preprocessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.FactException;
import geometry_objects.Segment;
import geometry_objects.angle.Angle;
import geometry_objects.angle.AngleEquivalenceClasses;
import geometry_objects.angle.AngleLinkedEquivalenceClass;
import utilities.LinkedEquivalenceClass;

public class AngleIdentifier
{
	protected AngleEquivalenceClasses _angles;
	protected Map<Segment, Segment> _segments;

	public AngleIdentifier(Map<Segment, Segment> segments)
	{
		_segments = segments;
	}

	/*
	 * Compute the figure triangles on the fly when requested; memoize results for subsequent calls.
	 */
	public AngleEquivalenceClasses getAngles() throws FactException
	{
		if (_angles != null) return _angles;

		_angles = new AngleEquivalenceClasses();

		computeAngles();

		return _angles;
	}

	private void computeAngles() throws FactException
	{
		Collection<Segment> segCollection = _segments.values();
		List<Segment> segList = new ArrayList<Segment>(segCollection);
		
		for(int i = 0; i < segList.size(); i++) 
		{
			for(int j = i+1; j < segList.size(); j++) 
			{
				if(segList.get(i).sharedVertex(segList.get(j)) != null && !Segment.overlaysAsRay(segList.get(i), segList.get(j)) 
						&& !_angles.contains(new Angle(segList.get(i), segList.get(j))))
				{
					_angles.add(new Angle(segList.get(i), segList.get(j)));
				}
			}
		}
		
		for(LinkedEquivalenceClass<Angle> alec : _angles.getList()) 
		{

			System.out.println(alec.toString() + "\n");
		}
		
		
//		Set<Segment> segSet = _segments.keySet();
//		
//		for(Segment s1 : segSet) 
//		{
//			for(Segment s2 : segSet) 
//			{
//				if(s1.sharedVertex(s2) != null && !Segment.overlaysAsRay(s2, s1) 
//						&& !_angles.contains(new Angle(s1, s2)) && !s1.equals(s2)) 
//				{
//					_angles.add(new Angle(s1, s2));
//				}
//			}
//		}
//		
//		for(Segment segment : segSet)
//			System.out.println(segment.toString());
//		System.out.println(segSet.size());
	}
}
