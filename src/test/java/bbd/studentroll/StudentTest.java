package bbd.studentroll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import bbd.studentroll.Course;
import bbd.studentroll.Student;


public class StudentTest {

	Student s1 = null;
	Student s2 = null;
	Student s3 = null;
	Student s4 = null;
	Course c   = null;

	//sets up some parameters for testing
	@Before
	public void setUp()
	{
		s1 = new Student("Chace", 13, "19980821");
		s2 = new Student("Richard", 11, "19931809");
		s3 = new Student("Alex", 12, "19951002");
		s4 = new Student("Leslie", 13, "19231212");
		c  = new Course("Test", 2);
	}

	//tests setters and getters of student
	@Test
	public void testStudent() {

        assertEquals("Chace", s1.getName());
		assertEquals(13, s1.getUFID());
		assertEquals("19980821", s1.getDob());

		s4.setName("testset");
        assertEquals("testset", s4.getName());

		assertEquals("Richard", s2.getName());
		assertEquals(11, s2.getUFID());
		assertEquals("19931809", s2.getDob());
		
		assertEquals("Alex", s3.getName());
		assertEquals(12, s3.getUFID());
		assertEquals("19951002", s3.getDob());
	}

    @Test
    public void testForMultipleStudent()
    {
        assertTrue(c.enrollStudent(s1));
        assertFalse(c.enrollStudent(s1));
    }
	
	@Test
	public void testCourse(){
		
		Course cr =  Mockito.mock(Course.class);
		Mockito.when(cr.getName()).thenReturn("TESTOUT");
		
		assertEquals("TESTOUT", cr.getName());
		
		assertEquals("Test", c.getName());
		assertEquals(2, c.getCap());
		
		assertTrue(c.enrollStudent(s1));
		assertTrue(c.enrollStudent(s2));
		assertFalse(c.enrollStudent(s4));
		
		String student1 = c.getStudents().get(0).getName() + " " + c.getStudents().get(0).getUFID();
		String student2 = c.getStudents().get(1).getName() + " " + c.getStudents().get(1).getUFID();
		
		assertEquals("Chace 13", student1);
		assertEquals("Richard 11", student2);
		
		assertFalse(c.unEnrollStudent(s3));
		assertTrue(c.unEnrollStudent(s1));
		assertTrue(c.unEnrollStudent(s2));
		
	}
	@Test
	public void testOverCapacity()
	{
        assertEquals(true, c.enrollStudent(s1));
        assertEquals(true, c.enrollStudent(s2));
        assertEquals(false, c.enrollStudent(s3));
    }
	
	@After
	public void teardown()
	{
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		c  = null; 
	}

}
