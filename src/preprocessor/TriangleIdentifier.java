package preprocessor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.FactException;
import geometry_objects.Segment;
import geometry_objects.Triangle;
import geometry_objects.angle.Angle;
import geometry_objects.angle.AngleEquivalenceClasses;
import geometry_objects.angle.AngleLinkedEquivalenceClass;

public class TriangleIdentifier
{
	protected Set<Triangle>         _triangles;
	protected Map<Segment, Segment> _segments;

	public TriangleIdentifier(Map<Segment, Segment> segments)
	{
		_segments = segments;
	}

	/*
	 * Compute the figure triangles on the fly when requested;
	 * memoize results for subsequent calls.
	 */
	public Set<Triangle> getTriangles() throws FactException
	{
		if (_triangles != null) return _triangles;

		_triangles = new HashSet<Triangle>();

		computeTriangles();

		return _triangles;
	}

	private void computeTriangles() throws FactException
	{
		// TODO
		Set<Segment> segSet = _segments.keySet();
		AngleIdentifier angID = new AngleIdentifier(_segments);
		AngleEquivalenceClasses angles = angID.getAngles();
		
		for(AngleLinkedEquivalenceClass alec : angles.getList()) 
		{
			List lec = alec.getList();
			for(Object angle : lec) 
			{
				//if(segSet.contains(new Segment(angle, null)))
			}
		}
	}
}
