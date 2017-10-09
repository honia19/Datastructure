

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.AssertJUnit;
import static org.testng.ConversionUtils.wrapDataProvider;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized.Parameters;

public class InitFuncNG 
{
	@Factory
	public static Object[] factoryData()
	{
		return wrapDataProvider( InitFuncNG.class, data());
	}
	EList lst = null;

	public InitFuncNG(EList al)
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



	@BeforeMethod
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
		AssertJUnit.assertEquals(0, lst.size());
		lst = new AList1(ar);
		AssertJUnit.assertEquals(0, lst.size());
		lst = new AList2(ar);
		AssertJUnit.assertEquals(0, lst.size());
	}

	@Test
	public void testInt_null() 
	{
		int[] ar = null;
		lst.init(ar);
		AssertJUnit.assertEquals(0, lst.size());
		int[] exp = {};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());					
	}

	@Test
	public void testInt_0() 
	{
		int[] ar = {};
		lst.init(ar);
		AssertJUnit.assertEquals(0, lst.size());
		int[] exp = {};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}

	@Test
	public void testInt_1() 
	{
		int[] ar = {10};
		lst.init(ar);
		AssertJUnit.assertEquals(1, lst.size());
		int[] exp = {10};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}

	@Test
	public void testToArray_2() 
	{
		int[] ar = {10,20};
		lst.init(ar);
		AssertJUnit.assertEquals(2, lst.size());
		int[] exp = {10, 20};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}
	@Test
	public void testToArray_many() 
	{
		int[] ar = {10,20,77,11,34,99,56};
		lst.init(ar);
		AssertJUnit.assertEquals(7, lst.size());
		int[] exp = {10,20,77,11,34,99,56};
		AssertJUnit.assertArrayEquals(exp, lst.toArray());
	}

}
