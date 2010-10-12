package KnowledgeBase;

import java.util.ArrayList;

/**A simple KnowledgeBase.
 * 
 * @author dwettstein
 * 
 */
public class KnowledgeBase {

	private ArrayList<Question> questions;
	private ArrayList<Answer> answers;
	private ArrayList<User> users;
	
	
	public KnowledgeBase() {
		this.questions = new ArrayList<Question>();
		this.answers = new ArrayList<Answer>();
		this.users = new ArrayList<User>();
	}
	
	/**Puts all users into a string.
	 * 
	 */
	public String toString() {
		String string = new String();
		for(User user:users) {
			string += " | " + user.getUsername();
		}
		return string;
	}
	
	/**Creates a new user in the base.
	 * 
	 * @param name : the users name
	 * @param firstName : the users first-name
	 */
	public void createUser(String name, String firstName) {
		User user = new User(name, firstName);
		this.users.add(user);
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}

	/**Removes an user from the base and his data.
	 * 
	 * @param user : the user to remove
	 */
	public void removeUser(User user) {
		assert(this.users.contains(user));
		for(Question question:this.questions) {
			if(question.getVoters().contains(user))
				question.removeVote(user);
			if (question.getOwner().equals(user))
				this.questions.remove(question);
		}
		for(Answer answer:this.answers) {
			if(answer.getVoters().contains(user))
				answer.removeVote(user);
			if (answer.getOwner().equals(user))
				this.answers.remove(answer);
		}
		this.users.remove(user);
	}
	
	/**Removes an user from the base and his data.
	 * 
	 * @param name : the users name
	 * @param firstName : the users first-name
	 */
	public void removeUser(String name, String firstName) {
		User tempUser = getUser(name, firstName);
		for(Question question:this.questions) {
			if(question.getVoters().contains(tempUser))
				question.removeVote(tempUser);
			if (question.getOwner().equals(tempUser))
				this.questions.remove(question);
		}
		for(Answer answer:this.answers) {
			if(answer.getVoters().contains(tempUser))
				answer.removeVote(tempUser);
			if (answer.getOwner().equals(tempUser))
				this.answers.remove(answer);
		}
		this.users.remove(tempUser);
	}
	
	/**Creates a new question in the base.
	 * 
	 * @param questionText : the content of the question
	 * @param owner : the user who asks this question
	 */
	public void createQuestion(String questionText, User owner) {
		assert(this.users.contains(owner));
		Question question = new Question(questionText, owner);
		this.questions.add(question);
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public void removeQuestion(Question question) {
		assert(this.questions.contains(question));
		this.questions.remove(question);
	}
	
	public void removeQuestion(String questionText) {
		for(Question question:this.questions) {
			if(question.getContent().equals(questionText)) {
				this.questions.remove(question);
				break;
			}
		}
	}
	
	/**Creates a new answer in the base.
	 * 
	 * @param answerText : the content of the answer
	 * @param owner : the user who answered this question
	 * @param question : the answered question 
	 */
	public void createAnswer(String answerText, User owner, Question question) {
		assert(this.users.contains(owner));
		Answer answer = new Answer(answerText, owner, question);
		this.answers.add(answer);
	}
	
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}
	
	public void removeAnswer(Answer answer) {
		assert(this.answers.contains(answer));
		this.answers.remove(answer);
	}
	
	public void removeAnswer(String answerText) {
		for(Answer answer:this.answers) {
			if(answer.getContent().equals(answerText)) {
				this.answers.remove(answer);
				break;
			}
		}
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
	
	/**Gets the user-object from the base.
	 * 
	 * @param name : the name of the user to search
	 * @param firstName : the first-name of the user to search
	 * @return the founded user
	 */
	public User getUser(String name, String firstName) {
		User tempUser = new User("default", "default");
		for(int i = 0;i < this.users.size();i++) {
			if(this.users.get(i).getUsername().equals(name + " " + firstName));
			tempUser = this.users.get(i);
		}
		return tempUser;
	}
	
}
