package KnowledgeBase;

import java.util.ArrayList;
import java.util.Date;

/**A question with content, timestamp, owner and voting.
 * 
 * @author dwettstein
 * 
 */
public class Question {
	
	private String content;
	private Date timestamp;
	private User owner;
	private int voting;
	private ArrayList<User> voters;

	
	public Question(String question, User owner) {
		this.content = question;
		this.timestamp = new Date(System.currentTimeMillis());
		this.owner = owner;
		this.voting = 0;
		this.voters = new ArrayList<User>();
	}

	/**Adds a vote to the question.
	 * 
	 * @param voter : the user who votes
	 */
	public void vote(User voter) {
		this.voting++;
		this.voters.add(voter);
	}
	
	/**Removes a vote from a question.
	 * 
	 * @param voter : the user who voted
	 */
	public void removeVote(User voter) {
		assert(this.voters.contains(voter));
		this.voting--;
		this.voters.remove(voter);
	}

	public int getVoting() {
		return voting;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public ArrayList<User> getVoters() {
		return voters;
	}

	
	public Date getTimestamp() {
		return timestamp;
	}
	
	
}
