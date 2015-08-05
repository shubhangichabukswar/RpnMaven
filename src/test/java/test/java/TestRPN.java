package test.java;
import main.java.RPNCalc;
import junit.framework.TestCase;

public class TestRPN extends TestCase{
	
	public void testRPN1()
	{
		RPNCalc obj = new RPNCalc();
		assertEquals((float)4.0, obj.calculate("2 2 +") );
		
	}
	public void testRPN2()
	{
		RPNCalc obj = new RPNCalc();
		assertEquals((float)7.0, obj.calculate("2 5 +") );
		
	}

}