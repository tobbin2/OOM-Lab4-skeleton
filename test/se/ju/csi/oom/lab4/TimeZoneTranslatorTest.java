
package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {
	TimeZoneTranslator timezone = new TimeZoneTranslator();
	DateTime datetimeobject;
	DateTime datetimeobject2;
	Event event;
	Event event2;
	Person person1;
	Person person2;
	Place batcave;
	@Before
	public void setUp() throws Exception {
		datetimeobject = new DateTime(2016, 1, 1, 6, 0, 0);
		datetimeobject2 = new DateTime(2015,12,31,21,0,0);
		person1 = new Person("person1");
		person2 = new Person("person2");
		batcave = new Place("batcave",35.27,-82.28,0.0);
		event = new Event("batman",datetimeobject,datetimeobject2,new HashSet<>(Arrays.asList(person1, person2)),batcave);
	}

	@Test
	public void testShiftTimeZone() {
		System.out.println("testShiftTimeZone:");
		System.out.println(datetimeobject.toString());
		System.out.println("After change");
		int from = 1;
		int to = -8;
		datetimeobject = timezone.shiftTimeZone(datetimeobject, from, to);
		System.out.println(datetimeobject.toString());
		System.out.println(datetimeobject2.toString());
		assertEquals(datetimeobject.toString(),datetimeobject2.toString());
		
		
		
		//My great random code changes
	}

	@Test
	public void testShiftEventTimeZone() {
		System.out.println("TestShiftEventTimeZone:");
		DateTime expectedDateObject;
		DateTime expectedDateObject2;
		expectedDateObject = timezone.shiftTimeZone(datetimeobject,TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(),TimeZone.US_PACIFIC.getOffset());
		expectedDateObject2 = timezone.shiftTimeZone(datetimeobject2,TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(),TimeZone.US_PACIFIC.getOffset());
		Event expectedEvent = new Event("batman",expectedDateObject,expectedDateObject2,new HashSet<>(Arrays.asList(person1,person2)),batcave);
		event = timezone.shiftEventTimeZone(event, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_PACIFIC);
		System.out.println(event.toString());
		System.out.println(expectedEvent.toString());
		assertEquals(event.toString(),expectedEvent.toString());
		//assertEquals(1,1);
		//assertEquals(event.getStartDate().getHour(),timezone.shiftEventTimeZone(event, TimeZone.SINGAPORE, TimeZone.JAPAN).getStartDate().getHour()+timeZonescompared);
		//fail("Not yet implemented");
	}

}