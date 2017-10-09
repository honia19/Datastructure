
public class LList2 implements EList
{
	class Node
	{
		int val;
		Node next;
		Node prev;

		public Node (int val)
		{
			this.val = val;
			next = null;
			prev = null;
		}
	}

	Node start = null;
	Node end = null;

	public LList2()
	{
		//
	}

	public LList2 (int[] ar)
	{
		init(ar);
	}

	@Override
	public void init(int[] ar)
	{
		// TODO Auto-generated method stub
		if(ar == null)
			ar = new int[0];

		for (int i = ar.length - 1; i >= 0; i--) 
		{
			addStart(ar[i]);
		}
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		start = end = null;
	}

	@Override
	public int size()
	{
		int ret = 0;
		Node tmp = start;
		while (tmp != null)
		{
			tmp = tmp.next;
			ret++;
		}
		return ret;
	}

	public int[] debug()
	{
		int[] ret = new int[size()];
		Node tmp = end;
		int i = size() - 1;
		while (tmp != null)
		{
			ret[i--] = tmp.val;
			tmp = tmp.prev;
		}
		return ret;
	}
	
	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];
		Node tmp = start;
		int i = 0;
		while (tmp != null)
		{
			ret[i++] = tmp.val;
			tmp = tmp.next;
		}
		return ret;
	}

	@Override
	public String toString()
	{
		String str = "[";
		Node tmp = start;
		while (tmp != null)
		{
			str += tmp.val;
			if (tmp != end)
				str += ", ";
			tmp = tmp.next;
		}
		str += "]";
		return str;
	}

	@Override
	public void sort()
	{
		int size = size();
		if (size <= 1) return;
		for (int i = 0; i < size - 1; i++)
		{
			Node tmp = start;
			for (int j = 0; j < size - i - 1; j++)
			{
				Node current = tmp,
						before = tmp.prev,
						after = tmp.next;
				if (current.val > after.val)
				{
					current.next = after.next;
					current.prev = after;
					
					after.prev = before;
					if (before != null)
						before.next = after;
					else
						start = after;
					
					if (after.next!=null)
						after.next.prev = current;
					else
						end = current;
					after.next = current;
					tmp = after;
				}
				tmp = tmp.next;
			}
		}
	}

	@Override
	public int min()
	{
		if (start == null)
			throw new IllegalArgumentException();
		int ret = start.val;
		Node tmp = start;
		while (tmp.next!=null)
		{
			tmp = tmp.next;
			if (tmp.val < ret) ret = tmp.val;
		}
		return ret;
	}

	@Override
	public int max()
	{
		if (start == null)
			throw new IllegalArgumentException();
		int ret = start.val;
		Node tmp = start;
		while (tmp.next!=null)
		{
			tmp = tmp.next;
			if (tmp.val > ret) ret = tmp.val;
		}
		return ret;
	}

	@Override
	public int minInd()
	{
		if (start == null)
			throw new IllegalArgumentException();
		int min = start.val;
		int i = 0, ret = 0;
		Node tmp = start;
		while (tmp.next != null)
		{
			tmp = tmp.next;
			i++;
			if (tmp.val < min)
			{
				min = tmp.val;
				ret = i;			
			}
		}
		return ret;
	}

	@Override
	public int maxInd()
	{
		if (start == null)
			throw new IllegalArgumentException();
		int max = start.val;
		int i = 0, ret = 0;
		Node tmp = start;
		while (tmp.next!=null)
		{
			tmp = tmp.next;			
			i++;
			if (tmp.val > max)
			{
				ret = i;
				max = tmp.val;
			}
		}
		return ret;
	}

	@Override
	public void reverse()
	{
		if (size() <= 1)
			return;
		Node tmp = start;
		while (tmp != null)
		{
			Node tmp2 = tmp.next;
			tmp.next = tmp.prev;			
			tmp = tmp.prev = tmp2;
		}
		tmp = end;
		end = start;
		start = tmp;
	}

	@Override
	public void halfReverse()
	{
		int len = size();
		if (len <= 1) return;

		Node tmp = start;
		for (int i = 0; i < len / 2 - 1 ; i++)
		{
			tmp = tmp.next;
		}
		if (len % 2 == 0)
		{
			end.next = start;
			start.prev = end;
			end = tmp;
			start = tmp.next;
		}
		else
		{
			tmp = tmp.next;
			end.next = tmp;
			start.prev = tmp;
			Node tmp2 = tmp.prev;
			tmp.prev = end;
			end = tmp2;
			tmp2 = tmp.next;
			tmp.next = start;
			start = tmp2;
		}
		end.next = null;
		start.prev = null;
	}

	@Override
	public void addStart(int val)
	{
		Node p = new Node(val);
		p.next = start;
		if (start != null)
			start.prev = p;
		start = p;
		if (end == null)
			end = p;
	}

	@Override
	public void addEnd(int val)
	{
		Node p = new Node(val);
		if (end == null)
			addStart(val);
		else
		{
			p.prev = end;
			end.next = p;
			end = p;
		}
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos < 0 || pos > size())
			throw new IllegalArgumentException();

		if (pos == 0)
			addStart(val);
		else if (pos == size())
			addEnd(val);
		else
		{
			Node p = new Node(val);
			int cnt = 0;
			Node tmp = start;
			while (cnt < pos)
			{
				tmp = tmp.next;
				cnt++;
			}
			p.next = tmp;
			p.prev = tmp.prev;
			tmp.prev.next = p;
			tmp.prev = p;
		}
	}

	@Override
	public int delStart()
	{
		if (start == null)
			throw new IllegalArgumentException();
		int ret = start.val;
		start = start.next;
		if (start != null) start.prev = null;
		else end = null;

		return ret;
	}

	@Override
	public int delEnd()
	{
		if (end == null)
			throw new IllegalArgumentException();

		int ret = end.val;
		if (end.prev != null)
		{
			end = end.prev;
			end.next = null;
		}
		else
		{
			start = end = null;
		}
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (pos < 0 || pos >= size())
			throw new IllegalArgumentException();

		int ret;
		if (pos == 0)
			ret = delStart();
		else if (pos == size() - 1)
			ret = delEnd();
		else
		{
			int cnt = 0;
			Node tmp = start;
			while (cnt < pos)
			{
				tmp = tmp.next;
				cnt++;
			}
			ret = tmp.val;
			if (tmp.prev != null)
				tmp.prev.next = tmp.next;
			if (tmp.next != null)
				tmp.next.prev = tmp.prev;
		}
		return ret;
	}

	@Override
	public int get(int pos)
	{
		if (start == null || pos >= size())
			throw new IllegalArgumentException();

		Node tmp = start;
		int len = size(), ret = start.val;
		for (int i = 0; i < len; i++)
		{
			if (i == pos)
			{
				ret = tmp.val;
				break;
			}
			tmp = tmp.next;
		}
		return ret;
	}

	@Override
	public void set(int pos, int val)
	{
		if (start == null || pos >= size())
			throw new IllegalArgumentException();

		Node tmp = start;
		int len = size();
		for (int i = 0; i < len; i++)
		{
			if (i == pos)
			{
				tmp.val = val;
				break;
			}
			tmp = tmp.next;
		}
	}

}