import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AListTest 
{
	EList lst = null;

	public AListTest(EList al)
	{
		lst = al;
	}
	
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]
				{
					{new AList0()},
					{new AList1()},
					{new AList2()}
				});
	}
	
	

	@Before
	public void setUp()
	{
		lst.clear();
	}
	
	@Test
	public void testToString_null() 
	{
		int[] ar = null;
		lst.init(ar);
		assertEquals(0, lst.size());
		String exp = "[]";
		assertEquals(exp, lst.toString());					
	}

	@Test
	public void testToString_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		String exp = "[]";
		assertEquals(exp, lst.toString());
	}

	@Test
	public void testToString_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		String exp = "[10]";
		assertEquals(exp, lst.toString());
	}

	@Test
	public void testToString_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		String exp = "[10, 20]";
		assertEquals(exp, lst.toString());
	}
	@Test
	public void testToString_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		String exp = "[10, 20, 77, 11, 34, 99, 56]";
		assertEquals(exp, lst.toString());
	}

	//=====================================
	//  MIN
	//=====================================
	@Test (expected = IllegalArgumentException.class)
	public void testMin_0_ex() 
	{
		int[] ar = {};
		lst.init(ar);
		lst.min();
	}
	@Test
	public void testMin_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		int rez = lst.min();
		int exp = 10;
		assertEquals(exp, rez);
	}
	@Test
	public void testMin_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		int rez = lst.min();
		int exp = 10;
		assertEquals(exp, rez);
	}
	@Test
	public void testMin_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		int rez = lst.min();
		int exp = 10;
		assertEquals(exp, rez);
	}

	//=====================================
	//  MAX
	//=====================================
	@Test (expected = IllegalArgumentException.class)
	public void testMax_0_ex() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.max();
	}
	@Test
	public void testMax_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		int rez = lst.max();
		int exp = 10;
		assertEquals(exp, rez);
	}
	@Test
	public void testMax_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		int rez = lst.max();
		int exp = 20;
		assertEquals(exp, rez);
	}
	@Test
	public void testMax_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		int rez = lst.max();
		int exp = 99;
		assertEquals(exp, rez);
	}

	//=====================================
	//  MININD
	//=====================================
	@Test (expected = IllegalArgumentException.class)
	public void testMinInd_0_ex() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.minInd();
	}
	@Test
	public void testMinInd_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		int rez = lst.minInd();
		int exp = 0;
		assertEquals(exp, rez);
	}
	@Test
	public void testMinInd_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		int rez = lst.minInd();
		int exp = 0;
		assertEquals(exp, rez);
	}
	@Test
	public void testMinInd_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		int exp = 0;
		int rez = lst.minInd();
		assertEquals(exp, rez);
	}

	//=====================================
	//  MAXIND
	//=====================================
	@Test (expected = IllegalArgumentException.class)
	public void testMaxInd_0_ex() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.maxInd();
	}
	@Test
	public void testMaxInd_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		int rez = lst.maxInd();
		int exp = 0;
		assertEquals(exp, rez);
	}
	@Test
	public void testMaxInd_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		int rez = lst.maxInd();
		int exp = 1;
		assertEquals(exp, rez);
	}
	@Test
	public void testMaxInd_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		int rez = lst.maxInd();
		int exp = 5;
		assertEquals(exp, rez);
	}

	//=====================================
	//  SORT
	//=====================================
	@Test
	public void testSort_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.sort();
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testSort_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.sort();
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testSort_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.sort();
		int[] exp = {10, 20};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testsort_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		lst.sort();
		int[] exp = {10, 11, 20, 34, 56, 77, 99};
		assertArrayEquals(exp, lst.toArray());
	}

	//=====================================
	//  REVERSE
	//=====================================
	@Test
	public void testReverse_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.reverse();
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testReverse_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.reverse();
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testReverse_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.reverse();
		int[] exp = {20, 10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testReverse_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		lst.reverse();
		int[] exp = {56, 99, 34, 11, 77, 20, 10};
		assertArrayEquals(exp, lst.toArray());
	}

	//=====================================
	//  HALF_REVERSE
	//=====================================
	@Test
	public void testHalfReverse_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.halfReverse();
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testHalfReverse_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.halfReverse();
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testHalfReverse_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.halfReverse();
		int[] exp = {20, 10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testhalfReverse_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);assertEquals(7, lst.size());
		lst.halfReverse();
		int[] exp = {34,99,56,11,10,20,77};
		assertArrayEquals(exp, lst.toArray());
	}

	//=====================================
	//  ADD_START
	//=====================================
	@Test
	public void testAddStart_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.addStart(12);
		int[] exp = {12};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddStart_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.addStart(12);
		int[] exp = {12, 10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddStart_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.addStart(12);
		int[] exp = {12, 10, 20};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddStart_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};

		lst.init(ar);
		assertEquals(7, lst.size());
		lst.addStart(12);
		int[] exp = {12, 10, 20, 77, 11, 34, 99, 56};
		assertArrayEquals(exp, lst.toArray());
	}

	//=====================================
	//  ADD_END
	//=====================================
	@Test
	public void testAddEnd_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.addEnd(12);
		int[] exp = {12};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddEnd_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.addEnd(12);
		int[] exp = {10, 12};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddEnd_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.addEnd(12);
		int[]exp = {10, 20, 12};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddEnd_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		lst.addEnd(12);
		int[]exp = {10, 20, 77, 11, 34, 99, 56, 12};
		assertArrayEquals(exp, lst.toArray());
	}

	//=====================================
	//  ADD_END
	//=====================================
	@Test(expected = IllegalArgumentException.class)
	public void testAddPos_0_ex() 
	{
		int[] ar = {};
		lst.init(ar);
		lst.addPos(2, 12);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddPos_1() 
	{
		int[] ar = {10};

		lst.init(ar);
		lst.addPos(2, 12);
	}
	@Test
	public void testAddPos_1_End() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.addPos(1, 12);
		int[] exp = {10, 12};
		assertArrayEquals(exp, lst.toArray());
	}	
	@Test
	public void testAddPos_1_Start() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.addPos(0, 12);
		int[] exp = {12, 10};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddPos_2_End() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.addPos(2, 12);
		int[] exp = {10, 20, 12};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testAddPos_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		lst.addPos(2, 12);
		int[] exp = {10,20,12,77,11,34,99,56};
		assertArrayEquals(exp, lst.toArray());
	}

	//=====================================
	//  DEL_START
	//=====================================
	@Test(expected = IllegalArgumentException.class)
	public void testDelStart_0() 
	{
		int[] ar = {};
		lst = new AList0();
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.delStart();
	}
	@Test
	public void testdelStart_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		int res = lst.delStart();
		int exp = 10;
		assertEquals(exp, res);
	}
	@Test
	public void testDelStart_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		int res = lst.delStart();
		int exp = 10;
		assertEquals(exp, res);
	}
	@Test
	public void testDelStart_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		int res = lst.delStart();
		int exp = 10;
		assertEquals(exp, res);
	}

	//=====================================
	//  DEL_END
	//=====================================
	@Test(expected = IllegalArgumentException.class)
	public void testDelEnd_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.delEnd();
	}
	@Test
	public void testdelEnd_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		int res = lst.delEnd();
		int exp = 10;
		assertEquals(exp, res);
	}
	@Test
	public void testDelEndt_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		int res = lst.delEnd();
		int exp = 20;
		assertEquals(exp, res);
	}
	@Test
	public void testDelEnd_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		int res = lst.delEnd();
		int exp = 56;
		assertEquals(exp, res);
	}

	//=====================================
	//  DEL_POS
	//=====================================
	@Test(expected = IllegalArgumentException.class)
	public void testDelPost_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.delPos(2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDelPos_1_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.delPos(2);
	}
	@Test
	public void testDelPos_1_2() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		int res = lst.delPos(0);
		int exp = 10;
		assertEquals(exp, res);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDelPos_2_1() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.delPos(2);
	}
	@Test
	public void testDelPos_2_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		int res = lst.delPos(0);
		int exp = 10;
		assertEquals(exp, res);
	}
	@Test
	public void testDelPos_2_3() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		int res = lst.delPos(1);
		int exp = 20;
		assertEquals(exp, res);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testDelPos_many_ex() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		lst.delPos(12);
	}
	@Test
	public void testDelPos_many_1() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		int res = lst.delPos(0);
		int exp = 10;
		assertEquals(exp, res);
	}
	@Test
	public void testDelPos_many_2() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		int res = lst.delPos(6);
		int exp = 56;
		assertEquals(exp, res);
	}
	@Test
	public void testDelPos_many_3() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		int res = lst.delPos(2);
		int exp = 77;
		assertEquals(exp, res);
	}

	//=====================================
	//  GET
	//=====================================
	@Test(expected = IllegalArgumentException.class)
	public void testGet_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.get(2);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGet_1_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.get(2);
	}
	@Test
	public void testGet_1_2() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		int res = lst.get(0);
		int exp = 10;
		assertEquals(exp, res);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGet_2_1() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		lst.get(2);
	}
	@Test
	public void testGet_2_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		int res = lst.get(1);
		int exp = 20;
		assertEquals(exp, res);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGet_many_ex() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		lst.get(12);
	}
	@Test
	public void testGet_many_1() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		int res = lst.get(2);
		int exp = 77;
		assertEquals(exp, res);
	}
	//=====================================
	//  SET
	//=====================================
	@Test(expected = IllegalArgumentException.class)
	public void testSet_null_ex() 
	{
		int[] ar = null;
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.set(2, 12);

	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		lst.set(2, 12);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_1_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.set(2, 12);
	}
	@Test
	public void testSet_1_2() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		lst.set(0, 12);
		int[] exp = {12};
		assertArrayEquals(exp,lst.toArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_2_1() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.set(2, 12);
	}
	@Test
	public void testSet_2_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.set(0, 12);
		int[] exp = {12, 20};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testSet_2_3() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		lst.set(1, 12);
		int[] exp = {10, 12};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSet_many_ex() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		lst.set(12, 12);
	}
	@Test
	public void testSet_many_1() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		lst.set(2, 12);
		assertEquals(7, lst.size());
		int[] exp = {10,20,12,11,34,99,56};
		assertArrayEquals(exp, lst.toArray());
	}
}
