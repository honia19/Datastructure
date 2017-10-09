
public interface EList 
{
	void init(int[] ar);
	int min();
	void sort();
	void clear();
	int size();
	String toString();
	int[] toArray();
	int max();
	int minInd();
	int maxInd();
	void reverse();
	void halfReverse ();
	void addStart(int val);
	void addEnd(int val);
	void addPos(int pos, int val);
	int delStart();
	int delEnd();
	int delPos(int pos);
	int get(int pos);
	void set(int pos, int val);
}
