import java.util.Iterator;


public class AList1 implements EList, Iterable<Integer>
{
	private int[] ar = new int[10];
	int index = 0;

	public AList1()
	{
		// 
	}

	AList1(int[] ar)
	{
		init(ar);
	}

	@Override
	public void init(int[] ar)
	{
		if(ar == null)
			ar = new int[0];
			
			clear();
			if (ar.length > 10)
				resize(ar.length);
			for (int i = 0; i < ar.length; i++) 
			{
				this.ar[i] = ar[i];
			}
			index = ar.length;
	}

	@Override
	public int min()
	{
		if(index == 0)
			throw new IllegalArgumentException();

		int ret = ar[0];

		for (int i = 1; i < index; i++)
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
		for (int i = 0; i < index; i++)
		{
			for (int j = 0; j < index - 1 - i; j++)
			{
				if(ar[j] > ar[j + 1])
				{
					int tmp = ar[j];
					ar[j] = ar[j + 1];
					ar[j + 1] = tmp;
				}
			}
		}
	}

	@Override
	public void clear()
	{
		index = 0;
	}

	@Override
	public int size()
	{
		return index;
	}
	
	private void resize(int size)
	{
		if (index == 0)
			ar = new int[(int)(1.4 * size)];
		else
		{
			int[] arTmp = new int[(int)(1.4 * size)];
			for (int i = 0; i < index; i++)
			{
				arTmp[i] = ar[i];
			}
			ar = arTmp;
		}
	}

	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];

		for (int i = 0; i < size(); i++)
		{
			ret[i] = ar[i];
		}

		return ret;
	}
	
	@Override
	public String toString()
	{
		String ret = "[";

		for (int i = 0; i < index; i++)
		{
			ret += ar[i];
			if (i < index - 1) ret += ", ";
		}

		ret += "]";

		return ret;
	}

	@Override
	public int max()
	{
		if(index == 0)
			throw new IllegalArgumentException();

		int ret = ar[0];

		for (int i = 1; i < index; i++)
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
		if(index == 0)
			throw new IllegalArgumentException();
		int ret = 0;

		for (int i = 1; i < index; i++)
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
		if(index == 0)
			throw new IllegalArgumentException();
		int ret = 0;

		for (int i = 1; i < index; i++)
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
		if (index == 0) return;

		for (int i = 0; i < index / 2; i++)
		{
			int tmp = ar[i];
			ar[i] = ar[index - i - 1];
			ar[index - i - 1] = tmp;
		}
	}

	@Override
	public void halfReverse()
	{
		if (index == 0) return;

		int midd = (index % 2 == 0) ? 0: 1;
		for (int i = 0; i < index / 2; i++)
		{
			int tmp = ar[i];
			ar[i] = ar[index / 2 + midd + i];
			ar[index / 2 + midd + i] = tmp;
		}
	}

	@Override
	public void addStart(int val)
	{	
		if (index == ar.length - 1)
			resize(ar.length);
		for (int i = index++; i > 0; i--)
		{
			ar[i] = ar[i - 1];
		}
		ar[0] = val;
	}

	@Override
	public void addEnd(int val)
	{	
		if (index == ar.length - 1)
			resize(ar.length);
		ar[index++] = val;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos < 0 || pos > size()) throw new IllegalArgumentException();
		
		if (index == ar.length - 1)
			resize(ar.length);
		for (int i = index++; i > pos; i--)
		{
			ar[i] = ar[i - 1];
		}
		ar[pos] = val;
	}

	@Override
	public int delStart()
	{
		if(size() == 0)
			throw new IllegalArgumentException();

		int ret = ar[0];
		for (int i = 0; i < size(); i++)
		{
			ar[i] = ar[i + 1];
		}
		index--;
		return ret;

	}

	@Override
	public int delEnd()
	{
		if (size() == 0) throw new IllegalArgumentException();
		return ar[--index];
	}

	@Override
	public int delPos(int pos)
	{
		if (size() == 0 || pos >= size()) throw new IllegalArgumentException();
		int ret = ar[pos];

		for (int i = pos; i < size() - 1; i++)
		{
			ar[i] = ar[i + 1];
		}
		index--;
		return ret;
	}

	@Override
	public int get(int pos)
	{
		if(pos < 0 || pos >= size())
			throw new IllegalArgumentException();

		return ar[pos];
	}

	@Override
	public void set(int pos, int val)
	{
		if(pos < 0 || pos >= size())
			throw new IllegalArgumentException();

		ar[pos] = val;
	}
	@Override
	public Iterator<Integer> iterator() 
	{
		// TODO Auto-generated method stub
		return new MyIterator(ar);
	}
	
	class MyIterator implements Iterator<Integer>
	{
		int i=0;
		int size = 0;
		int [] ar=null;
		public MyIterator(int [] arr) 
		{
			size = index;
			this.ar = arr;
		}

		@Override
		public boolean hasNext() 
		{
				return i < size;
		}

		@Override
		public Integer next() 
		{
			return ar[i++];
		}
		
	}

}
