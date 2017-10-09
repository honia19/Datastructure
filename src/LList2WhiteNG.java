import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

public class LList2WhiteNG 
{
	LList2 llst = new LList2();

	@BeforeMethod
	public void setUp()
	{
		llst.clear();
	}

	//=====================================
	//  INIT + TOARRAY + SIZE
	//=====================================
	@Test
	public void testInt_null() 
	{
		int[] ar = null;
		llst.init(ar);
		AssertJUnit.assertEquals(0, llst.size());
		int[] exp = {};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());					
	}

	@Test
	public void testInt_0() 
	{
		int[] ar = {};
		llst.init(ar);
		AssertJUnit.assertEquals(0, llst.size());
		int[] exp = {};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	@Test
	public void testInt_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		AssertJUnit.assertEquals(1, llst.size());
		int[] exp = {10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	@Test
	public void testToArray_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {10, 20};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testToArray_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		AssertJUnit.assertEquals(7, llst.size());
		int[] exp = {10,20,77,11,34,99,56};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	//=====================================
	//  SORT
	//=====================================
	@Test
	public void testSort_0() 
	{
		int[] ar = {};
		llst.init(ar);				
		llst.sort();
		AssertJUnit.assertEquals(0, llst.size());
		int[] exp = {};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testSort_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		llst.sort();
		AssertJUnit.assertEquals(1, llst.size());
		int[] exp = {10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testSort_2() 
	{
		int[] ar = {20,10};
		llst.init(ar);
		llst.sort();
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {10, 20};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	@Test
	public void testSort_3() 
	{
		int[] ar = {20,10, 44};
		llst.init(ar);
		llst.sort();
		AssertJUnit.assertEquals(3, llst.size());
		int[] exp = {10, 20, 44};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	@Test
	public void testsort_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		llst.sort();
		AssertJUnit.assertEquals(7, llst.size());
		int[] exp = {10, 11, 20, 34, 56, 77, 99};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	@Test
	public void testsort_many_again() 
	{
		int[] ar = {20,10,77,11,34,99,56};
		llst.init(ar);
		llst.sort();
		AssertJUnit.assertEquals(7, llst.size());
		int[] exp = {10, 11, 20, 34, 56, 77, 99};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	//=====================================
	//  REVERSE
	//=====================================
	@Test
	public void testReverse_0() 
	{
		int[] ar = {};
		llst.init(ar);
		llst.reverse();
		AssertJUnit.assertEquals(0, llst.size());
		int[] exp = {};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testReverse_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		llst.reverse();
		AssertJUnit.assertEquals(1, llst.size());
		int[] exp = {10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testReverse_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		llst.reverse();
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {20, 10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testReverse_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		llst.reverse();
		AssertJUnit.assertEquals(7, llst.size());
		int[] exp = {56, 99, 34, 11, 77, 20, 10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	//=====================================
	//  HALF_REVERSE
	//=====================================
	@Test
	public void testHalfReverse_0() 
	{
		int[] ar = {};
		llst.init(ar);
		llst.halfReverse();
		AssertJUnit.assertEquals(0, llst.size());
		int[] exp = {};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testHalfReverse_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		llst.halfReverse();
		AssertJUnit.assertEquals(1, llst.size());
		int[] exp = {10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testHalfReverse_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		llst.halfReverse();
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {20, 10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testhalfReverse_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		llst.halfReverse();
		AssertJUnit.assertEquals(7, llst.size());
		int[] exp = {34,99,56,11,10,20,77};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testhalfReverse_many_even() 
	{
		int[] ar = {10,20,77,11,34,99};
		llst.init(ar);
		llst.halfReverse();
		AssertJUnit.assertEquals(6, llst.size());
		int[] exp = {11,34,99,10,20,77};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	//=====================================
	//  ADD_START
	//=====================================
	@Test
	public void testAddStart_0() 
	{
		int[] ar = {};
		llst.init(ar);
		llst.addStart(12);
		AssertJUnit.assertEquals(1, llst.size());
		int[] exp = {12};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddStart_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		llst.addStart(12);
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {12, 10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddStart_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		llst.addStart(12);
		AssertJUnit.assertEquals(3, llst.size());
		int[] exp = {12, 10, 20};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddStart_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		llst.addStart(12);
		AssertJUnit.assertEquals(8, llst.size());
		int[] exp = {12, 10, 20, 77, 11, 34, 99, 56};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	//=====================================
	//  ADD_END
	//=====================================
	@Test
	public void testAddEnd_0() 
	{
		int[] ar = {};
		llst.init(ar);
		llst.addEnd(12);
		AssertJUnit.assertEquals(1, llst.size());
		int[] exp = {12};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddEnd_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		llst.addEnd(12);
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {10, 12};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddEnd_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		llst.addEnd(12);
		AssertJUnit.assertEquals(3, llst.size());
		int[]exp = {10, 20, 12};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddEnd_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		llst.addEnd(12);
		AssertJUnit.assertEquals(8, llst.size());
		int[]exp = {10, 20, 77, 11, 34, 99, 56, 12};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	//=====================================
	//  ADD_POS
	//=====================================
	@Test
	public void testAddPos_1_End() 
	{
		int[] ar = {10};
		llst.init(ar);
		llst.addPos(1, 12);
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {10, 12};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}	
	@Test
	public void testAddPos_1_Start() 
	{
		int[] ar = {10};
		llst.init(ar);
		llst.addPos(0, 12);
		AssertJUnit.assertEquals(2, llst.size());
		int[] exp = {12, 10};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddPos_2_End() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		llst.addPos(2, 12);
		AssertJUnit.assertEquals(3, llst.size());
		int[] exp = {10, 20, 12};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}
	@Test
	public void testAddPos_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		llst.addPos(2, 12);
		AssertJUnit.assertEquals(8, llst.size());
		int[] exp = {10,20,12,77,11,34,99,56};
		AssertJUnit.assertArrayEquals(exp, llst.toArray());
		AssertJUnit.assertArrayEquals(exp, llst.debug());
	}

	//=====================================
	//  DEL_START
	//=====================================
	@Test
	public void testDellStart_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		int res = llst.delStart();
		AssertJUnit.assertEquals(0, llst.size());
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	@Test
	public void testDellStart_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		int res = llst.delStart();
		AssertJUnit.assertEquals(1, llst.size());
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {20};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	@Test
	public void testDellstart_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		int res = llst.delStart();
		AssertJUnit.assertEquals(6, llst.size());
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {20, 77, 11, 34, 99, 56};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}

	//=====================================
	//  DEL_END
	//=====================================
	@Test
	public void testDelEnd_1() 
	{
		int[] ar = {10};
		llst.init(ar);
		int res = llst.delEnd();
		AssertJUnit.assertEquals(0, llst.size());
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	@Test
	public void testDelEnd_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		int res = llst.delEnd();
		AssertJUnit.assertEquals(1, llst.size());
		int exp = 20;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {10};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	@Test
	public void testDelEnd_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		int res = llst.delEnd();
		AssertJUnit.assertEquals(6, llst.size());
		int exp = 56;
		int[] expAr = {10, 20, 77, 11, 34, 99};
		AssertJUnit.assertEquals(exp, res);
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}

	//=====================================
	//  DEL_POS
	//=====================================
	@Test
	public void testDelPos_1_2() 
	{
		int[] ar = {10};
		llst.init(ar);
		int res = llst.delPos(0);
		AssertJUnit.assertEquals(0, llst.size());
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}

	@Test
	public void testDelPos_2_2() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		int res = llst.delPos(0);
		AssertJUnit.assertEquals(1, llst.size());
		int exp = 10;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {20};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	@Test
	public void testDelPos_2_3() 
	{
		int[] ar = {10,20};
		llst.init(ar);
		int res = llst.delPos(1);
		AssertJUnit.assertEquals(1, llst.size());
		int exp = 20;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {10};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	
	@Test
	public void testDelPos_many_1() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		int res = llst.delPos(0);
		AssertJUnit.assertEquals(6, llst.size());
		int exp = 10;
		int[] expAr = {20,77,11,34,99,56};
		AssertJUnit.assertEquals(exp, res);
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	@Test
	public void testDelPos_many_2() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		int res = llst.delPos(6);
		AssertJUnit.assertEquals(6, llst.size());
		int exp = 56;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {10, 20,77,11,34,99};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
	@Test
	public void testDelPos_many_3() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		llst.init(ar);
		int res = llst.delPos(2);
		AssertJUnit.assertEquals(6, llst.size());
		int exp = 77;
		AssertJUnit.assertEquals(exp, res);
		int[] expAr = {10, 20,11,34,99, 56};
		AssertJUnit.assertArrayEquals(expAr, llst.toArray());
		AssertJUnit.assertArrayEquals(expAr, llst.debug());
	}
}
