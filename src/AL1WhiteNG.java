
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

public class AL1WhiteNG 
{
	AList1 lst = new AList1();
	int[] ini = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14};
	
	int[] ar = {};
	
	@BeforeMethod
	public void createLST()
	{
		lst.clear();
		ar = ini.clone();
	}
	
	//================================
	// INIT + TO_ARRAY + SIZE
	//================================
	
	@Test
	public void testInit_many()		
	{
		lst.init(ar);
		AssertJUnit.assertEquals(20, lst.size());
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	//================================
	// CLEAR
	//================================
	
	@Test
	public void testClear_many()		
	{
		lst.init(ar);
		lst.clear();
		int[] exp = {};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	//================================
	// TO_STRING
	//================================
	
	@Test
	public void testToString_many()		
	{
		lst.init(ar);
		String act = lst.toString();
		String exp = "[20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14]";
		AssertJUnit.assertEquals(exp, act);
	}
		
	//================================
	// MIN
	//================================
	
	@Test
	public void testMin_many() 
	{
		lst.init(ar);
		int act = lst.min();
		AssertJUnit.assertEquals(5, act);
	}
	
	//================================
	// MAX
	//================================
	
	@Test
	public void testMax_many() 
	{
		lst.init(ar);
		int act = lst.max();
		AssertJUnit.assertEquals(99, act);
	}

	//================================
	// MIN_INDEX
	//================================
	
	@Test
	public void testMinIndex_many() 
	{
		lst.init(ar);
		int act = lst.minInd();
		AssertJUnit.assertEquals(10, act);
	}	
	
	//================================
	// MAX_INDEX
	//================================
	
	@Test
	public void testMaxIndex_many() 
	{
		lst.init(ar);
		int act = lst.maxInd();
		AssertJUnit.assertEquals(5, act);
	}
	
	//================================
	// SORT
	//================================
		
	@Test
	public void testSort_many() 
	{
		lst.init(ar);
		lst.sort();
		int[] exp = {5, 10, 11, 13, 14, 20, 23, 34, 42, 46, 51, 56, 67, 69, 77, 81, 88, 92, 94, 99};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	//================================
	// REVERSE
	//================================
		
	@Test
	public void testReverse_many() 
	{
		lst.init(ar);	
		lst.reverse();
		int[] exp = {14, 13, 81, 92, 69, 23, 46, 51, 94, 5, 42, 67, 88, 56, 99, 34, 11, 10, 77, 20};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}	
	
	//================================
	// HALF_REVERSE
	//================================
	
	@Test
	public void testHalfReverse_manyOdd() 
	{
		int[] ar = {20, 77, 10, 11, 34, 99, 56, 88, 38, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14};
		lst.init(ar);		
		lst.halfReverse();
		int[] exp = {5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 42, 20, 77, 10, 11, 34, 99, 56, 88, 38, 67};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	@Test
	public void testHalfReverse_manyEven() 
	{
		lst.init(ar);		
		lst.halfReverse();
		int[] exp = {5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	//================================
	// ADD_START
	//================================
			
	@Test
	public void testAddStart_many() 
	{
		lst.init(ar);
		lst.addStart(45);
		AssertJUnit.assertEquals(21, lst.size());
		int[] exp = {45, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	@Test
	public void testAddStart_9() 
	{
		int[] iniAdd = {20, 77, 10, 11, 34, 99, 56, 88, 67};
		lst.init(iniAdd);
		lst.addStart(45);
		AssertJUnit.assertEquals(10, lst.size());
		int[] exp = {45, 20, 77, 10, 11, 34, 99, 56, 88, 67};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
		lst.addStart(33);
		AssertJUnit.assertEquals(11, lst.size());
		int[]exp2 = {33, 45, 20, 77, 10, 11, 34, 99, 56, 88, 67};
		act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp2, act);		
	}	
	
	//================================
	// ADD_END
	//================================
		
	@Test
	public void testAddEnd_many()
	{
		lst.init(ar);
		lst.addEnd(45);
		AssertJUnit.assertEquals(21, lst.size());
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 45};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	@Test
	public void testAddEnd_9() 
	{
		int[] iniAdd = {20, 77, 10, 11, 34, 99, 56, 88, 67};
		lst.init(iniAdd);
		lst.addEnd(45);
		AssertJUnit.assertEquals(10, lst.size());
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 45};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
		lst.addEnd(33);
		AssertJUnit.assertEquals(11, lst.size());
		int[]exp2 = {20, 77, 10, 11, 34, 99, 56, 88, 67, 45, 33};
		act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp2, act);		
	}

	//================================
	// ADD_POS
	//================================
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testAddPos_many_Ex()
	{
		lst.init(ar);
		lst.addPos(36, 45);
	}
	
	@Test
	public void testAddPos_many()
	{
		lst.init(ar);
		lst.addPos(15, 45);
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 45, 69, 92, 81, 13, 14};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	@Test
	public void testAddPos_9() 
	{
		int[] iniAdd = {20, 77, 10, 11, 34, 99, 56, 88, 67};
		lst.init(iniAdd);
		lst.addPos(5, 45);
		AssertJUnit.assertEquals(10, lst.size());
		int[] exp = {20, 77, 10, 11, 34, 45, 99, 56, 88, 67};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
		lst.addPos(7, 33);
		AssertJUnit.assertEquals(11, lst.size());
		int[]exp2 = {20, 77, 10, 11, 34, 45, 99, 33, 56, 88, 67};
		act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp2, act);		
	}
	
	//================================
	// DEL_START
	//================================
				
	@Test
	public void testDelStart_many() 
	{
		lst.init(ar);
		int act = lst.delStart();
		AssertJUnit.assertEquals(20, act);
	}	
	
	//================================
	// DEL_END
	//================================
			
	@Test
	public void testDelEnd_many()
	{
		lst.init(ar);
		int act = lst.delEnd();
		AssertJUnit.assertEquals(14, act);
	}	

	//================================
	// DEL_POS
	//================================
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDelPos_many_ex() 
	{
		lst.init(ar);
		AssertJUnit.assertEquals(20, lst.size());
		lst.delPos(36);
	}
	@Test
	public void testDelPos_many_1() 
	{
		lst.init(ar);		
		int res = lst.delPos(0);
		AssertJUnit.assertEquals(19, lst.size());
		int exp = 20;
		AssertJUnit.assertEquals(exp, res);
	}
	@Test
	public void testDelPos_many_2() 
	{
		lst.init(ar);		
		int res = lst.delPos(19);
		AssertJUnit.assertEquals(19, lst.size());
		int exp = 14;
		AssertJUnit.assertEquals(exp, res);
	}
	@Test
	public void testDelPos_many_3() 
	{
		lst.init(ar);		
		int res = lst.delPos(2);
		AssertJUnit.assertEquals(19, lst.size());
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
	}
	
	//================================
	// GET
	//================================
			
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testGet_many_ex() 
	{
		lst.init(ar);
		lst.get(36);
	}

	@Test
	public void testGet_many_1() 
	{
		lst.init(ar);
		AssertJUnit.assertEquals(20, lst.size());
		int res = lst.get(2);
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
	}

	//================================
	// SET
	//================================
				
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSet_many_ex() 
	{
		lst.init(ar);
		AssertJUnit.assertEquals(20, lst.size());
		lst.set(36, 12);
	}

	@Test
	public void testSet_many_1() 
	{
		lst.init(ar);
		AssertJUnit.assertEquals(20, lst.size());
		lst.set(2, 12);		
		int[] exp = {20, 77, 12, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}	
}
