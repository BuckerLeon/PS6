package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddperson() {
		SimpleDateFormat date = new SimpleDateFormat("mm/dd/yyyy");
		Date birth = null;
		try {
			birth = date.parse("02/26/1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PersonDomainModel per = new PersonDomainModel();
		per.setPersonID(null);
		per.setFirstName("Leon");
		per.setLastName("Kennedy");
		per.setStreet("Pebble Beach");
		per.setPostalCode(21921);
		per.setCity("Elkton");
		per.setBirthday(birth);
		
		PersonDAL.addPerson(per);
	}
	

	@Test
	public void testdeletperson() {
		SimpleDateFormat date = new SimpleDateFormat("mm/dd/yyyy");
		Date birth = null;
		try {
			birth = date.parse("02/26/1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UUID uuid = UUID.randomUUID();
		
		PersonDomainModel per = new PersonDomainModel();
		per.setFirstName("Leon");
		per.setLastName("Kennedy");
		per.setBirthday(birth);
		per.setStreet("Pebble Beach");
		per.setPostalCode(21921);
		per.setCity("Elkton");
		per.setPersonID(uuid);
		
		PersonDAL.addPerson(per);
		PersonDAL.getPerson(uuid);
		PersonDAL.deletePerson(uuid);
	}
	
	@Test
	public void testupdateperson() {
		SimpleDateFormat date = new SimpleDateFormat("mm/dd/yyyy");
		Date birth = null;
		try {
			birth = date.parse("02/26/1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PersonDomainModel per = new PersonDomainModel();
		per.setPersonID(null);
		per.setFirstName("Leon");
		per.setLastName("Kennedy");
		per.setStreet("Pebble Beach");
		per.setPostalCode(21921);
		per.setCity("Elkton");
		per.setBirthday(birth);
		
		PersonDAL.addPerson(per);
		per.setLastName("Scott");
		PersonDAL.updatePerson(per);
	}

}
