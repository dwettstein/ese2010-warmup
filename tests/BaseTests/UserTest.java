package BaseTests;
import org.junit.*;

import KnowledgeBase.*;

import static org.junit.Assert.*;

/**A test for an user.
 * 
 * @author dwettstein
 * 
 */
public class UserTest {
	
	User test;
	Question example;

	@Before
	public void setup() throws Exception {
		test = new User("Muster", "Hans");
		example = new Question("What is hot and shines brightly?", test);
		
	}
	
	@Test
	public void shouldHaveCreatedUser() {
		assertFalse(test.equals(null));
		assertEquals("Muster Hans", test.getUsername());
	}
	
	@Test
	public void shouldHaveAssignedQuestion() {
		assertFalse(example.getOwner().equals(null));
		assertEquals(test, example.getOwner());
	}
	
	@Test
	public void shouldChangeName() {
		test.setUsername("Tester", "Fritz");
		assertEquals("Tester Fritz", test.getUsername());
	}
	
}
