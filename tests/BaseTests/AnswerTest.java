package BaseTests;
import static org.junit.Assert.*;

import org.junit.*;

import KnowledgeBase.*;

/**A test for an answer.
 * 
 * @author dwettstein
 * 
 */
public class AnswerTest {
	
	User asker;
	User answerer;
	Question example;
	Answer answer;

	@Before
	public void setup() throws Exception {
		asker = new User("Muster", "Hans");
		answerer = new User("Beispiel", "Fritz");
		example = new Question("What is hot and shines brightly?", asker);
		answer = new Answer("It is the sun.", answerer, example);
	}

	@Test
	public void shouldHaveCreatedAnswer() {
		assertFalse(answer.equals(null));
		assertEquals("It is the sun.", answer.getContent());
	}
	
	@Test
	public void shouldGetQuestion() {
		assertEquals(example, answer.getBelonging());
	}
	
}
