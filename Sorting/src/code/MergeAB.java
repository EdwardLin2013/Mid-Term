package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeAB 
{
	public MergeAB() 
	{
		// TODO Auto-generated constructor stub
	}

	// A: left		B: right
	public List<Integer> Merge(List<Integer> left, List<Integer> right) 
	{
		int i=0,j=0;
		ArrayList<Integer> retval = new ArrayList<Integer>();
		
		while( i<left.size() && j<right.size() )
		{
			if( (left.get(i)).compareTo(right.get(j)) < 0 )
			{
				retval.add(left.get(i));
				i++;
			}
			else
			{
				retval.add(right.get(j));
				j++;
			}				
		}
		
		while( i<left.size() ) // Copy the remaining left
		{
			retval.add(left.get(i));
			i++;
		}
		
		while( j<right.size() ) // Copy the remaining right
		{
			retval.add(right.get(j));
			j++;
		}
		
		return retval;
	}

}
