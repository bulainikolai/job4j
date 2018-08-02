package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Nikolai Bulai (mailto:turisto777.nb@gmail.com)
* @version 1
* @since 02.08.2018
*/
public class CalculateTest {
	/**
	* Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
    	String input = "Petr Arsentev";
    	String expect = "Echo, echo, echo : Petr Arsentev"; 
    	Calculate calc = new Calculate();
    	String result = calc.echo(input);
    	assertThat(result, is(expect));
	}
	
}