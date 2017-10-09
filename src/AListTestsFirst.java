import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AListTestsFirst 
{
	EList lst = null;

	public AListTestsFirst(EList al)
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
	//=====================================
	//  INIT + TOARRAY + SIZE
	//=====================================
	@Test
	public void testInt_constr() 
	{
		int[] ar = null;
		lst = new AList0(ar);
		assertEquals(0, lst.size());
		lst = new AList1(ar);
		assertEquals(0, lst.size());
		lst = new AList2(ar);
		assertEquals(0, lst.size());
	}

	@Test
	public void testInt_null() 
	{
		int[] ar = null;
		lst.init(ar);
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());					
	}

	@Test
	public void testInt_0() 
	{
		int[] ar = {};
		lst.init(ar);
		assertEquals(0, lst.size());
		int[] exp = {};
		assertArrayEquals(exp, lst.toArray());
	}

	@Test
	public void testInt_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		assertEquals(1, lst.size());
		int[] exp = {10};
		assertArrayEquals(exp, lst.toArray());
	}

	@Test
	public void testToArray_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		assertEquals(2, lst.size());
		int[] exp = {10, 20};
		assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testToArray_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		assertEquals(7, lst.size());
		int[] exp = {10,20,77,11,34,99,56};
		assertArrayEquals(exp, lst.toArray());
	}

}
