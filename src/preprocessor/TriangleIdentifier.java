package preprocessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import utilities.LinkedEquivalenceClass;

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
		Collection<Segment> collec = _segments.values();
		List<Segment> ls = new ArrayList<Segment>(collec);
		// get all different combinations of segments with a triple nested for-loop
		for (Segment s1 : ls) {
			for (Segment s2 : ls) {
				for (Segment s3 : ls) {
					// create list that is passed into triangle constructor
					List<Segment> inList = new ArrayList<Segment>();
					inList.add(s1);
					inList.add(s2);
					inList.add(s3);
					// try to create triangle with given segments
					try {
						_triangles.add(new Triangle(inList));
					} catch (FactException e) {
					}
				}
			}
		}
	}
}
