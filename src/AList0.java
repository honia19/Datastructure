
public class AList0 implements EList
{
	private int[] ar = {};
	
	public AList0()
	{
		//
	}
	public AList0(int[] ar)
	{
		init( ar );
	}
	
	@Override
	public void init(int[] ar)
	{
		if(ar == null)
			ar = new int[0];
		
		this.ar = new int[ar.length];
		for (int i = 0; i < ar.length; i++) 
		{
			this.ar[i] = ar[i];
		}
	}
	
	@Override
	public int min()
	{
		if(ar.length == 0)
			throw new IllegalArgumentException();
		
		int ret = ar[0];
		for (int i = 1; i < ar.length; i++)
		{
			if( ar[i] < ret )
			{
				ret = ar[i];
			}
		}
		return ret;
	}
	
	
	@Override
	public void sort()
	{
		for (int i = 0; i < ar.length; i++)
		{
			for (int j = 0; j < ar.length-1; j++)
			{
				if(ar[j] > ar[j+1])
				{
					int tmp = ar[j];
					ar[j] = ar[j+1];
					ar[j + 1] = tmp;
				}
			}
		}
	}
	
	@Override
	public void clear()
	{
		init(new int[0]);
	}
	
	@Override
	public int size()
	{
		return ar.length;
	}
	
	@Override
	public String toString()
	{
		String ret = "";
		ret += "[";
		for (int i = 0; i < ar.length; i++)
		{
			ret += ar[i];
			if (i < ar.length - 1) ret += ", ";
		}
		ret += "]";
		return ret;
	}
	
	@Override
	public int[] toArray()
	{
		return ar;
	}
	
	@Override
	public int max()
	{
		if(ar.length == 0)
			throw new IllegalArgumentException();
		
		int ret = ar[0];
		for (int i = 1; i < ar.length; i++)
		{
			if( ar[i] > ret )
			{
				ret = ar[i];
			}
		}
		return ret;
	}
	
	@Override
	public int minInd()
	{
		if(ar.length == 0)
			throw new IllegalArgumentException();
		
		int ret = 0;
		for (int i = 1; i < ar.length; i++)
		{
			if( ar[i] < ar[ret] )
			{
				ret = i;
			}
		}
		return ret;
	}
	
	@Override
	public int maxInd()
	{
		if(ar.length == 0)
			throw new IllegalArgumentException();
		
		int ret = 0;
		for (int i = 1; i < ar.length; i++)
		{
			if( ar[i] > ar[ret] )
			{
				ret = i;
			}
		}
		return ret;
	}
	
	@Override
	public void reverse()
	{
		if (ar.length != 0)
		{
			for (int i = 0, len = ar.length - 1; i <= len / 2; i++)
			{
				int tmp = ar[i];
				ar[i] = ar[len - i];
				ar[len - i] = tmp;
			}
		}
	}
	
	@Override
	public void halfReverse ()
	{
		if (ar.length != 0)
		{
			int midd = 0;
			if (ar.length % 2 != 0) midd = 1;
			for (int i = 0; i < ar.length / 2; i++)
			{
				int tmp = ar[i];
				ar[i] = ar[ar.length / 2 + midd + i];
				ar[ar.length / 2 + midd + i] = tmp;
			}
		}
	}
	
	@Override
	public void addStart(int val)
	{
		int[] temp = new int[ar.length + 1];
		temp[0] = val;
		for (int i = 1; i < temp.length; i++)
		{
			temp[i] = ar[i - 1];
		}

		ar = temp;
	}
	
	@Override
	public void addEnd(int val)
	{
		int[] temp = new int[ar.length + 1];
		temp[ar.length] = val;
		if (temp.length > 1)
		{
			for (int i = 0; i < ar.length; i++)
			{
				temp[i] = ar[i];
			}
		}
		ar = temp;
	}
	
	@Override
	public void addPos(int pos, int val)
	{
		if (ar.length == 0 || pos > ar.length)
			throw new IllegalArgumentException();
		
		int[] temp = new int[ar.length + 1];
		for (int i = 0; i < pos; i++)
		{
			temp[i] = ar[i];
		}
		temp[pos] = val;
		for (int i = pos; i < ar.length; i++)
		{
			temp[i + 1] = ar[i];
		}
		ar = temp;
	}
	
	@Override
	public int delStart()
	{
		if(ar.length == 0)
			throw new IllegalArgumentException();
		
		int ret = ar[0];
		
		int[] temp = new int[ar.length - 1];
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = ar[i + 1];
		}
		ar = temp;
		return ret;
	}
	
	@Override
	public int delEnd()
	{
		if(ar.length == 0)
			throw new IllegalArgumentException();
		
		int ret = ar[ar.length - 1];

		int[] temp = new int[ar.length - 1];
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = ar[i];
		}
		ar = temp;
		return ret;
	}
	
	@Override
	public int delPos(int pos)
	{
		if(ar.length == 0 || pos >= ar.length)
			throw new IllegalArgumentException();
		
		int ret = ar[pos];
		
		int[] temp = new int[ar.length - 1];
		for (int i = 0; i < pos; i++)
		{
			temp[i] = ar[i];
		}
		for (int i = pos; i < temp.length; i++)
		{
			temp[i] = ar[i + 1];
		}
		ar = temp;
		
		return ret;
	}
	
	@Override
	public int get(int pos)
	{
		if(ar.length == 0 || pos < 0 || pos > ar.length - 1)
			throw new IllegalArgumentException();
		
		return ar[pos];
	}
	
	@Override
	public void set(int pos, int val)
	{
		if(ar.length == 0 || pos < 0 || pos > ar.length - 1)
			throw new IllegalArgumentException();
		
		ar[pos] = val;
	}
}
