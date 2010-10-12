package BaseTests;
import static org.junit.Assert.*;

import org.junit.*;

import KnowledgeBase.*;

/**A test for a KnowledgeBase.
 * 
 * @author dwettstein
 * 
 */
public class KnowledgeBaseTest {

	KnowledgeBase base;
	User asker;
	User answerer;
	User voter;
	Question example;
	Answer answer;
	
	@Before
	public void setup() throws Exception {
		base = new KnowledgeBase();
		asker = new User("Muster", "Hans");
		answerer = new User("Beispiel", "Fritz");
		voter = new User("Voter", "Slim");
		example = new Question("What is hot and shines brightly?", asker);
		answer = new Answer("It is the sun.", answerer, example);
	}
	
	@Test
	public void shouldHaveCreatedEmptyBase() {
		assertFalse(base.equals(null));
		assertTrue(base.getUsers().isEmpty());
		assertTrue(base.getQuestions().isEmpty());
		assertTrue(base.getAnswers().isEmpty());
	}
	
	@Test
	public void shouldAddAndRemoveUsers() {
		assertEquals(0, base.getUsers().size());
		base.createUser("Example", "Ueli");
		base.createUser("Senn", "Peter");
		base.addUser(asker);
		base.addUser(answerer);
		assertEquals(4, base.getUsers().size());
		base.removeUser(asker);
		base.removeUser("Senn", "Peter");
		assertEquals(2, base.getUsers().size());
	}
	
	@Test
	public void shouldAddAndRemoveQuestion() {
		assertEquals(0, base.getQuestions().size());
		base.addQuestion(example);
		base.createQuestion("Is this the question?", asker);
		assertEquals(2, base.getQuestions().size());
		base.removeQuestion(example);
		assertEquals(1, base.getQuestions().size());
		base.removeQuestion("Is this the question?");
		assertEquals(0, base.getQuestions().size());
	}
	
	@Test
	public void shouldAddAndRemoveAnswer() {
		assertEquals(0, base.getAnswers().size());
		base.addAnswer(answer);
		base.createAnswer("To be or not to be is the question.", answerer, example);
		assertEquals(2, base.getAnswers().size());
		base.removeAnswer(answer);
		assertEquals(1, base.getAnswers().size());
		base.removeAnswer("To be or not to be is the question.");
		assertEquals(0, base.getAnswers().size());
	}
	
	@Test
	public void shouldRemoveUserAndHisData() {
		assertEquals(0, base.getQuestions().size());
		base.addUser(voter);
		base.addUser(asker);
		base.addUser(answerer);
		base.createUser("Senn", "Peter");
		assertEquals(4, base.getUsers().size());
		base.addQuestion(example);
		base.createQuestion("Is this the question?", asker);
		base.addAnswer(answer);
		base.createAnswer("To be or not to be is the question.", answerer, example);
		assertEquals(2, base.getQuestions().size());
		assertEquals(2, base.getAnswers().size());
		answer.vote(asker);
		example.vote(voter);
		example.vote(base.getUser("Senn", "Peter"));
		assertEquals(2, example.getVoting());
		assertEquals(1, answer.getVoting());
		base.removeUser(asker);
		base.removeUser("Senn", "Peter");
		assertEquals(2, base.getUsers().size());
		assertFalse(base.getQuestions().contains(example));
		assertEquals(0, answer.getVoting());
	}
	
}
