import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ AListTestsFirst.class, AListTest.class, AList1_WhiteBox_Tests.class, AList2_WhiteBox_Tests.class})
public class AListTests
{

}
