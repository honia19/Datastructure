public class LListF implements EList
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

	public  LListF()
	{
		//
	}

	public LListF(int[] ini)
	{
		init(ini);
	}	

	@Override
	public void init(int[] ar)
	{
		if(ar == null)
			ar = new int[0];

		initNode(ar, ar.length - 1);
	}

	private void initNode(int[] ar, int i)
	{
		if (i >= 0)
		{
			addStart(ar[i]);
			initNode(ar, --i);
		}
	}

	@Override
	public int min()
	{
		if (root == null)
			throw new IllegalArgumentException();

		return minNode(root, root.val);
	}

	private int minNode(Node nd, int min)
	{
		if (nd != null)
		{
			if (nd.val < min)
			{
				min = minNode(nd.next, nd.val);
			}
			else
			{
				min = minNode(nd.next, min); 
			}
		}
		return min;
	}

	@Override
	public void sort()
	{
		if (root == null || root.next == null) return;
		root = sortNode(root);

	}

	private Node sortNode(Node nd)
	{
		if (nd.next != null)
		{
			boolean bHaveToSort = true;
			while (bHaveToSort)
			{
				nd.next = sortNode(nd.next);
				if (nd.val > nd.next.val)
				{
					Node tmp = nd.next;
					nd.next = tmp.next;
					tmp.next = nd;
					nd = tmp;
				}
				else
				{
					bHaveToSort = false;
				}
			}
		}
		return nd;
	}

	@Override
	public void clear()
	{
		root = null;		
	}

	@Override
	public int size()
	{
		return sizeNode(root);
	}

	private int sizeNode(Node nd)
	{
		int sz = 0;
		if (nd != null)
		{
			sz = 1 + sizeNode(nd.next);
		}
		return sz;
	}

	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];
		toArrayNode(root, ret, 0);
		return ret;
	}

	private void toArrayNode(Node nd, int[] ar, int index)
	{
		if (nd == null)
			return;

		ar[index] = nd.val;
		toArrayNode(nd.next, ar, ++index);
	}

	public String toString()
	{
		return "[" + toStringNode(root);
	}

	private String toStringNode(Node nd)
	{
		String str = "";
		if (nd != null)
		{
			str += nd.val;
			if (nd.next != null)
				str += ", ";
			str += toStringNode(nd.next);
		}
		else
			str += "]";
		return str;
	}

	@Override
	public int max()
	{
		if (root == null)
			throw new IllegalArgumentException();

		return maxNode(root, root.val);
	}

	private int maxNode(Node nd, int max)
	{
		if (nd != null)
		{
			if (nd.val > max)
			{
				max = maxNode(nd.next, nd.val);
			}
			else
			{
				max = maxNode(nd.next, max); 
			}
		}
		return max;
	}

	@Override
	public int minInd()
	{
		if (root == null)
			throw new IllegalArgumentException();
		return minIndNode(root, root.val, 0, 0);
	}

	private int minIndNode(Node nd, int min, int iMin, int i)
	{
		if (nd != null)
		{
			if (nd.val < min)
			{
				iMin = minIndNode(nd.next, nd.val, i, ++i);
			}
			else
			{
				iMin = minIndNode(nd.next, min, iMin, ++i);
			}
		}
		return iMin;
	}

	@Override
	public int maxInd()
	{
		if (root == null)
			throw new IllegalArgumentException();

		return maxIndNode(root, root.val, 0, 0);
	}

	private int maxIndNode(Node nd, int max, int iMax, int i)
	{
		if (nd != null)
		{
			if (nd.val > max)
			{
				iMax = maxIndNode(nd.next, nd.val, i, ++i);
			}
			else
			{
				iMax = maxIndNode(nd.next, max, iMax, ++i);
			}
		}
		return iMax;
	}

	@Override
	public void reverse()
	{
		if (size() <= 1) return;
		else
		{
			reverseNode(root.next);
		}
	}

	private void reverseNode(Node nd)
	{
		if (nd != null)
		{
			Node tmp = nd.next;
			nd.next = root;
			if (root.next == nd) root.next = null;
			root = nd;
			reverseNode(tmp);
		}
	}

	@Override
	public void halfReverse()
	{
		int len = size();
		if (len <= 1) return;
		else
		{
			int odd = (len % 2 == 0)? 0: 1;
			halfReverseNode(root, odd, len, 0);
		}
	}

	private void halfReverseNode(Node nd, int odd, int len, int i)
	{
		Node root2 = null;
		if (nd.next != null)
		{
			if (i == (len - 1 - odd) / 2)
			{
				if (odd == 0)
				{
					root2 = nd.next;
				}
				else
				{
					Node oddN = nd.next;
					nd.next = null;
					root2 = oddN.next;
					oddN.next = root;
					root = oddN;
				}
				nd.next = null;
				halfReverseNode(root2, odd, len, ++i);
				root = root2;
			}
			else
			{
				halfReverseNode(nd.next, odd, len, ++i);
			}			
		}
		else
		{
			nd.next = root;	
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
		else addEndNode(root, p);
	}

	private void addEndNode(Node nd, Node p)
	{
		if (nd.next == null)
			nd.next = p;
		else
			addEndNode(nd.next, p);
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos > size())
			throw new IllegalArgumentException();
		if (pos == 0) addStart(val);
		else addPosNode(root, pos, val, 0);
	}

	private void addPosNode(Node nd, int pos, int val, int i)
	{
		if (i == pos - 1)
		{
			Node p = new Node(val);
			p.next = nd.next;
			nd.next = p;
		}
		else
			addPosNode(nd.next, pos, val, ++i);
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
		int ret = root.val;
		if (root.next == null)
			root = null;
		else
		{
			ret = delEndNode(root);
		}
		return ret;
	}

	private int delEndNode(Node nd)
	{
		int ret;
		if (nd.next.next == null)
		{
			ret = nd.next.val;
			nd.next = null;
		}
		else
			ret = delEndNode(nd.next);
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (root == null || pos >= size())
			throw new IllegalArgumentException();

		int ret = root.val;
		if (root.next == null) root = null;
		else
			ret = delPosNode(root, pos, 0);
		return ret;
	}

	private int delPosNode(Node nd, int pos, int i)
	{
		int ret;
		if (pos == 0)
		{
			ret = root.val;
			root = root.next;
		}
		else
		{
			if (i < pos - 1)
				ret = delPosNode(nd.next, pos, ++i);			
			else
			{
				ret = nd.next.val;
				nd.next = nd.next.next;
			}				
		}
		return ret;
	}

	@Override
	public int get(int pos)
	{
		if (root == null || pos >= size())
			throw new IllegalArgumentException();

		return getNode(root, pos, 0);
	}

	private int getNode(Node nd, int pos, int i)
	{
		int ret;
		if (i == pos)
			ret = nd.val;
		else
			ret = getNode(nd.next, pos, ++i);
		return ret;
	}

	@Override
	public void set(int pos, int val)
	{
		if (root == null || pos >= size())
			throw new IllegalArgumentException();

		setNode(root, pos, val, 0); 
	}

	private void setNode(Node nd, int pos, int val, int i)
	{
		if (i == pos)
			nd.val = val;
		else
			setNode(nd.next, pos, val, ++i);
	}

}
