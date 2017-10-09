
public class AList2 implements EList
{
	private int[] ar = new int[30];
	private int start = (ar.length - 1) / 2;
	private int end = (ar.length - 1) / 2;

	public AList2()
	{
		// 
	}

	public AList2(int[]ar)
	{
		init(ar);		
	}

	@Override
	public void init(int[] ar)
	{
		if (ar == null)
			ar = new int[0];

		clear();
		if (ar.length > 30)
			resize(ar.length);
		start -= (ar.length - 1) / 2;
		end = start + ar.length;
		for (int i = 0; i < ar.length; i++)
		{
			this.ar[start + i] = ar[i];
		}
	}

	@Override
	public int min()
	{
		if(end - start == 0)
			throw new IllegalArgumentException();

		int ret = ar[start];

		for (int i = start; i < end; i++)
		{
			if (ar[i] < ret) ret = ar[i];
		}

		return ret;
	}

	@Override
	public void sort()
	{
		for (int i = 0; i < size(); i++)
		{
			for (int j = start; j < end - i - 1; j++)
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
		start = (ar.length - 1) / 2;
		end = start;
	}

	@Override
	public int size()
	{
		return end - start;
	}

	private void resize(int size)
	{
		if (start == (this.ar.length - 1) / 2 && end == start)
		{
			ar = new int[(int)(1.4 * size)];
			clear();
		}
		else
		{
			int[] arTmp = new int[(int)(1.4 * size)];
			for (int i = start; i < end; i++)
			{
				arTmp[(arTmp.length - ar.length) / 2 + i] = ar[i];
			}
			start = (arTmp.length - ar.length) / 2;
			end = start + ar.length - 1;
			ar = arTmp;
		}
	}

	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];

		for (int i = 0; i < size(); i++)
		{
			ret[i] = ar[i + start];
		}

		return ret;
	}

	@Override
	public String toString()
	{
		String ret = "";
		ret += "[";
		if (size() != 0)
		{
			for (int i = start; i < end; i++)
			{
				ret += ar[i];
				if (i < end - 1) ret += ", ";
			}
		}
		ret += "]";
		return ret;
	}

	@Override
	public int max()
	{
		if(size() == 0)
			throw new IllegalArgumentException();

		int ret = ar[start];

		for (int i = start; i < end; i++)
		{
			if (ar[i] > ret) ret = ar[i];
		}

		return ret;
	}

	@Override
	public int minInd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();

		int ret = 0;

		for (int i = 1; i < size(); i++)
		{
			if (ar[start + i] < ar[start + ret]) ret = i;
		}

		return ret;
	}

	@Override
	public int maxInd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();

		int ret = 0;

		for (int i = 1; i < size(); i++)
		{
			if (ar[start + i] > ar[start + ret]) ret = i;
		}

		return ret;
	}

	@Override
	public void reverse()
	{
		if (size() == 0) return;

		for (int i = start; i < start + size() / 2; i++)
		{
			int tmp = ar[i];
			ar[i] = ar[start + end - i - 1];
			ar[start + end - i - 1] = tmp;
		}
	}

	@Override
	public void halfReverse()
	{
		if (size() == 0) return;

		int midd = (size() % 2 == 0) ? 0: 1;
		for (int i = start; i < start + size() / 2; i++)
		{
			int tmp = ar[i];
			ar[i] = ar[size() / 2 + midd + i ];
			ar[size() / 2 + midd + i ] = tmp;
		}
	}

	@Override
	public void addStart(int val)
	{
		if (start == 0)
		{
			if (end == ar.length - 1)
				resize(ar.length);
			else
			{
				int tmp = (ar.length - end) / 2;
				for (int i = end - 1; i >= start; i--)
				{
					ar[tmp + i] = ar[i];
				}
				end += tmp;
				start += tmp;
			}
		}
		ar[--start] = val;
	}

	@Override
	public void addEnd(int val)
	{
		if (end == ar.length - 1)
		{
			if (start == 0)
			{
				resize(ar.length);
			}
			else
			{
				int tmp = (start + 1) / 2;
				for (int i = start; i < end; i++)
				{
					ar[i - tmp] = ar[i];
				}
				start -= tmp;
				end -= tmp;
			}
		}
		ar[end++] = val;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos < 0 || start + pos > end)
			throw new IllegalArgumentException();

		if (start == 0 && end == ar.length - 1)
			resize(ar.length);
		else if (start == 0)
		{

			int tmp = (ar.length - end) / 2;
			for (int i = end - 1; i >= start; i--)
			{
				ar[tmp + i] = ar[i];
			}
			end += tmp;
			start += tmp;
		}

		else if (end == ar.length - 1)
		{
			int tmp = (start + 1) / 2;
			for (int i = start; i < end; i++)
			{
				ar[i - tmp] = ar[i];
			}
			start -= tmp;
			end -= tmp;
		}
		boolean bAddFromEnd = pos > (size() - 1) / 2 ? true: false;
		if (bAddFromEnd) 
		{
			for (int i = end++; i > start + pos; i--)
			{
				ar[i] = ar[i - 1];
			}			
		}
		else
		{
			for (int i = --start; i <= start + pos; i++)
			{
				ar[i] = ar[i + 1];
			}
		}
		ar[start + pos] = val;
	}

	@Override
	public int delStart()
	{
		if(size() == 0)
			throw new IllegalArgumentException();

		return ar[start++];
	}

	@Override
	public int delEnd()
	{
		if(size() == 0)
			throw new IllegalArgumentException();

		return ar[--end];
	}

	@Override
	public int delPos(int pos)
	{
		if (pos < 0 || start + pos >= end)
			throw new IllegalArgumentException();

		int ret = ar[start + pos];

		boolean bDelFromEnd = (end - pos) > (size() - 1) / 2 ? false: true;
		if (bDelFromEnd) 
		{
			for (int i = start + pos; i < end - 1; i++)
			{
				ar[i] = ar[i + 1];
			}
			end--;
		}
		else
		{
			for (int i = start + pos; i > start; i--)
			{
				ar[i] = ar[i - 1];
			}
			start++;
		}

		return ret;
	}

	@Override
	public int get(int pos)
	{
		if(pos < 0 || pos >= size()) throw new IllegalArgumentException();

		return ar[start + pos];
	}

	@Override
	public void set(int pos, int val)
	{
		if(pos < 0 || pos >= size() ) throw new IllegalArgumentException();

		ar[start + pos] = val;
	}

}
