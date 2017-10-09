
public class LList1 implements EList
{

	class Node 
	{
		int val;
		Node next;

		public Node(int val)
		{
			this.val = val;
		}
	}

	Node root = null;

	public  LList1()
	{
		//
	}

	public LList1(int[] ini)
	{
		init(ini);
	}	

	@Override
	public void init(int[] ar)
	{
		if(ar == null)
			ar = new int[0];

		for (int i = ar.length - 1; i >= 0; i--) 
		{
			addStart(ar[i]);
		}		
	}

	@Override
	public int min()
	{
		if (root == null)
			throw new IllegalArgumentException();
		int ret = root.val;
		Node tmp = root;
		while (tmp.next!=null)
		{
			tmp = tmp.next;
			if (tmp.val < ret) ret = tmp.val;
		}
		return ret;
	}

	@Override
	public void sort()
	{
		if (root == null || root.next == null) return;
		int len = size();
		if (len == 2)
		{
			root.next.next = root;
			root = root.next;
			root.next.next = null;
		}
		for (int i = 0; i < len - 1; i++)
		{
			Node tmp = root, tmpVal = null;
			if (root.next.val < root.val)
			{
				tmpVal = root.next.next;
				root.next.next = root;
				root = root.next;
				root.next.next = tmpVal;
			}
			while (tmp.next.next != null)
			{
				if (tmp.next.val > tmp.next.next.val)
				{
					tmpVal = tmp.next;
					tmp.next = tmp.next.next;
					tmpVal.next = tmp.next.next;
					tmp.next.next = tmpVal;
				}
				tmp = tmp.next;
			}
		}
	}

	@Override
	public void clear()
	{
		root = null;		
	}

	@Override
	public int size()
	{
		int ret = 0;		
		Node tmp = root;
		while(tmp != null)
		{
			ret++;
			tmp = tmp.next;
		}		
		return ret;
	}

	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];
		int i = 0;
		Node tmp = root;
		while(tmp != null)
		{
			ret[i++] = tmp.val;
			tmp = tmp.next;
		}

		return ret;
	}

	public String toString()
	{
		String ret = "[";

		Node tmp = root;
		while (tmp != null)
		{
			ret += tmp.val;if (tmp.next != null)ret += ", ";
			tmp = tmp.next;
		}
		ret += "]";
		return ret;
	}

	@Override
	public int max()
	{
		if (root == null)
			throw new IllegalArgumentException();
		int ret = root.val;
		Node tmp = root;
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
		if (root == null)
			throw new IllegalArgumentException();
		int min = root.val;
		int i = 0, ret = 0;
		Node tmp = root;
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
		if (root == null)
			throw new IllegalArgumentException();
		int max = root.val;
		int i = 0, ret = 0;
		Node tmp = root;
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
		if (size() <= 1) return;
		else
		{
			Node tmp = root, tmpNode = null;
			root = null;
			while (tmp != null)
			{
				tmpNode = tmp.next;
				tmp.next = root;
				root = tmp;
				tmp = tmpNode;
			}
		}
	}

	@Override
	public void halfReverse()
	{
		int len = size();
		if (len <= 1) return;
		else
		{
			Node tmp = root, root2 = null, oddNode = null;
			int odd = (len % 2 == 0) ? 0: 1;
			int cnt = 0;
			while(cnt < (len - odd - 1) / 2)
			{
				tmp = tmp.next;
				cnt++;
			}
			if (odd == 1)
			{
				oddNode = tmp.next;
				tmp.next = null;
				root2 = oddNode.next;
				tmp = root2;
				oddNode.next = root;
			}
			else
			{
				root2 = tmp.next;
				tmp.next = null;
				tmp = root2;
			}
			while (tmp.next != null)
			{
				tmp = tmp.next;
			}
			if (odd == 0)
			{
				tmp.next = root;
			}
			else
			{
				tmp.next = oddNode;
			}
			root = root2;
		}
	}

	@Override
	public void addStart(int val)
	{
		Node p = new Node(val);
		p.next = root;
		root = p;
	}

	@Override
	public void addEnd(int val)
	{
		Node p = new Node(val);
		if (root == null) root = p;
		else
		{
			Node tmp = root;
			while(tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.next = p;
		}
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos < 0 || pos > size())
			throw new IllegalArgumentException();

		Node p = new Node(val), tmp = root;
		int len = size();

		if (pos == 0) addStart(val);
		else if (pos == len) addEnd(val);
		else
		{
			int i = 0;
			while (i < pos - 1)
			{
				tmp = tmp.next;
				i++;
			}
			p.next = tmp.next;
			tmp.next = p;
		}
	}

	@Override
	public int delStart()
	{
		if (root == null)
			throw new IllegalArgumentException();
		int ret = root.val;
		root = root.next;
		return ret;
	}

	@Override
	public int delEnd()
	{
		if (root == null)
			throw new IllegalArgumentException();

		Node tmp = root;
		int ret = tmp.val;
		if (root.next == null) root = null;
		else
		{ 
			int len = size();
			for (int i = 0; i < len - 2; i++)
			{
				tmp = tmp.next;
			}
			ret = tmp.next.val;
			tmp.next = null;
		}
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (root == null || pos >= size())
			throw new IllegalArgumentException();

		Node tmp = root;
		int ret = tmp.val;
		if (root.next == null) root = null;
		else
		{ 
			if (pos == 0) root = root.next;
			else
			{
				for (int i = 0; i < pos - 1; i++)
				{
					tmp = tmp.next;
				}
				ret = tmp.next.val;
				tmp.next = tmp.next.next;
			}
		}
		return ret;
	}

	@Override
	public int get(int pos)
	{
		if (root == null || pos >= size())
			throw new IllegalArgumentException();

		Node tmp = root;
		int len = size(), ret = root.val;
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
		if (root == null || pos >= size())
			throw new IllegalArgumentException();

		Node tmp = root;
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
