package KnowledgeBase;

/**A answer with content, timestamp, owner and voting.
 * 
 * @author dwettstein
 * 
 */
public class Answer extends Question {
	
	private Question belonging;

	public Answer(String answer, User owner, Question question) {
		super(answer, owner);
		this.setBelonging(question);
	}

	public void setBelonging(Question belonging) {
		this.belonging = belonging;
	}

	public Question getBelonging() {
		return belonging;
	}
	

}
