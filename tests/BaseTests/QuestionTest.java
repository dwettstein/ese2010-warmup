package BaseTests;
import static org.junit.Assert.*;

import org.junit.*;

import KnowledgeBase.*;


/**A test for a question.
 * 
 * @author dwettstein
 * 
 */
public class QuestionTest {
	
	User test1;
	User test2;
	Question example;

	@Before
	public void setup() throws Exception {
		test1 = new User("Muster", "Hans");
		test2 = new User("Beispiel", "Fritz");
		example = new Question("What is hot and shines brightly?", test1);
	}
	
	@Test
	public void shouldHaveCreatedQuestion() {
		assertFalse(example.equals(null));
		assertEquals("What is hot and shines brightly?", example.getContent());
	}
	
	@Test
	public void shouldChangeContent() {
		example.setContent("Is this really the new question?");
		assertFalse(example.equals(null));
		assertEquals("Is this really the new question?", example.getContent());
	}
	
	@Test
	public void shouldChangeOwner() {
		assertEquals(test1, example.getOwner());
		example.setOwner(test2);
		assertEquals(test2, example.getOwner());
	}
	
	@Test
	public void shouldVote() {
		example.vote(test1);
		assertEquals(1, example.getVoting());
		assertEquals(1, example.getVoters().size());
		assertTrue(example.getVoters().contains(test1));
	}
	
	@Test
	public void shouldRemoveVote() {
		example.vote(test1);
		assertEquals(1, example.getVoting());
		example.removeVote(test1);
		assertEquals(0, example.getVoting());
		assertEquals(0, example.getVoters().size());
	}
}
