package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {
	DateTime datetimeobject1;
	DateTime datetimeobject2;
	@Before
	public void setUp() throws Exception {
		datetimeobject1 = new DateTime("2014-05-01 20:00:00");
		datetimeobject2 = new DateTime(2014,05,01,20,00,00);
		
	}

	@Test
	public void test() {
		assertEquals(datetimeobject1.toString(), "2014-05- 20:00:00");
		assertEquals(datetimeobject1.toString(),datetimeobject2.toString());
	}

}
