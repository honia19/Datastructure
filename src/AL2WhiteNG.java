import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;


public class AL2WhiteNG 
{
	AList2 lst = new AList2();
	int[] ini = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40};
	int[] ar = {};

	@BeforeMethod
	public void setUp()
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
		AssertJUnit.assertEquals(40, lst.size());
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40};
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
		String exp = "[20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40]";
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
		AssertJUnit.assertEquals(0, act);
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
		AssertJUnit.assertEquals(20, act);
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
		int[] exp = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 20, 23, 23, 34, 35, 40, 41, 42, 42, 46, 51, 56, 58, 66, 67, 69, 75, 77, 81, 88, 92, 93, 94, 99};
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
		int[] exp = {40, 42, 93, 66, 58, 35, 15, 23, 41, 75, 5, 8, 9, 2, 6, 7, 1, 4, 3, 0, 14, 13, 81, 92, 69, 23, 46, 51, 94, 5, 42, 67, 88, 56, 99, 34, 11, 10, 77, 20};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}	

	//================================
	// HALF_REVERSE
	//================================

	@Test
	public void testHalfReverse_manyOdd() 
	{
		int[] ar = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 22, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40};
		lst.init(ar);		
		lst.halfReverse();
		int[] exp = {0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40, 22, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	@Test
	public void testHalfReverse_manyEven() 
	{
		lst.init(ar);		
		lst.halfReverse();
		int[] exp = {0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14};
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
		AssertJUnit.assertEquals(41, lst.size());
		int[] exp = {45, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	@Test
	public void testAddStart_many_29() 
	{
		int iniAdd[] = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8};
		lst.init(iniAdd);
		AssertJUnit.assertEquals(29, lst.size());
		lst.addStart(45);
		AssertJUnit.assertEquals(30, lst.size());
		int[] exp = {45, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
		lst.addStart(33);		
		int[] exp2 = {33, 45, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8};
		AssertJUnit.assertEquals(31, lst.size());
		AssertJUnit.assertArrayEquals(exp2, lst.toArray());
	}

	@Test
	public void testAddStart_many_shift() 
	{
		int iniAdd[] = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		lst.init(iniAdd);
		AssertJUnit.assertEquals(26, lst.size());
		for (int i = 0; i < 3; i++)
		{
			lst.addStart(i + 42);
			AssertJUnit.assertEquals(26 + i + 1, lst.size());
		}
		int[] exp = {44, 43, 42, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}

	//================================
	// ADD_END
	//================================

	@Test
	public void testAddEnd_many()
	{
		lst.init(ar);
		lst.addEnd(45);
		AssertJUnit.assertEquals(41, lst.size());
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40, 45};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	
	@Test
	public void testAddEnd_many_29() 
	{
		int iniAdd[] = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8};
		lst.init(iniAdd);
		AssertJUnit.assertEquals(29, lst.size());
		lst.addEnd(45);
		AssertJUnit.assertEquals(30, lst.size());
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 45};
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
		lst.addEnd(33);		
		int[] exp2 = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 45, 33};
		AssertJUnit.assertEquals(31, lst.size());
		AssertJUnit.assertArrayEquals(exp2, lst.toArray());
	}
	
	@Test
	public void testAddEnd_many_shift() 
	{
		int iniAdd[] = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		lst.init(iniAdd);
		AssertJUnit.assertEquals(26, lst.size());
		for (int i = 0; i < 3; i++)
		{
			lst.addEnd(i + 42);
			AssertJUnit.assertEquals(26 + i + 1, lst.size());
		}
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 42, 43, 44};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}

	//================================
	// ADD_POS
	//================================

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testAddPos_many_Ex()
	{
		lst.init(ar);
		lst.addPos(56, 45);
	}

	@Test
	public void testAddPos_many()
	{
		lst.init(ar);
		lst.addPos(15, 45);
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 45, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40};
		
		int[] act = lst.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}	
	
	
	@Test
	public void testAddPos_many_shift_right() 
	{
		int iniAdd[] = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		lst.init(iniAdd);
		AssertJUnit.assertEquals(26, lst.size());
		for (int i = 0; i < 3; i++)
		{
			lst.addPos(26 + i, i + 42);
			AssertJUnit.assertEquals(26 + i + 1, lst.size());
		}
		int[] exp = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 42, 43, 44};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}
	
	@Test
	public void testAddPos_many_shift_left() 
	{
		int iniAdd[] = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		lst.init(iniAdd);
		AssertJUnit.assertEquals(26, lst.size());
		for (int i = 0; i < 3; i++)
		{
			lst.addPos(0, i + 42);
			AssertJUnit.assertEquals(26 + i + 1, lst.size());
		}
		int[] exp = {44, 43, 42, 20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}
	
	@Test
	public void testAddPos_many_widen() 
	{
		int iniAdd[] = {20, 77, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		lst.init(iniAdd);
		AssertJUnit.assertEquals(26, lst.size());
		for (int i = 0; i < 3; i++)
		{
			lst.addPos(2 + i, i + 42);
			AssertJUnit.assertEquals(26 + i + 1, lst.size());
		}
		int[] exp = {20, 77, 42, 43, 44, 10, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
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
		AssertJUnit.assertEquals(40, act);
	}	

	//================================
	// DEL_POS
	//================================

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDelPos_many_ex() 
	{
		lst.init(ar);
		AssertJUnit.assertEquals(40, lst.size());
		lst.delPos(56);
	}
	@Test
	public void testDelPos_many_1() 
	{
		lst.init(ar);		
		int res = lst.delPos(0);
		AssertJUnit.assertEquals(39, lst.size());
		int exp = 20;
		AssertJUnit.assertEquals(exp, res);
	}
	@Test
	public void testDelPos_many_2() 
	{
		lst.init(ar);		
		int res = lst.delPos(39);
		AssertJUnit.assertEquals(39, lst.size());
		int exp = 40;
		AssertJUnit.assertEquals(exp, res);
	}
	@Test
	public void testDelPos_many_3() 
	{
		lst.init(ar);		
		int res = lst.delPos(2);
		AssertJUnit.assertEquals(39, lst.size());
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
		lst.get(56);
	}

	@Test
	public void testGet_many_1() 
	{
		lst.init(ar);
		AssertJUnit.assertEquals(40, lst.size());
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
		AssertJUnit.assertEquals(40, lst.size());
		lst.set(56, 12);
	}

	@Test
	public void testSet_many_1() 
	{
		lst.init(ar);
		AssertJUnit.assertEquals(40, lst.size());
		lst.set(2, 12);		
		int[] exp = {20, 77, 12, 11, 34, 99, 56, 88, 67, 42, 5, 94, 51, 46, 23, 69, 92, 81, 13, 14, 0, 3, 4, 1, 7, 6, 2, 9, 8, 5, 75, 41, 23, 15, 35, 58, 66, 93, 42, 40};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}
 
}
