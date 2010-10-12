package KnowledgeBase;

/**A user with name and first-name.
 * 
 * @author dwettstein
 * 
 */
public class User {

	private String name;
	private String firstName;

	
	public User(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
	}

	public void setUsername(String name, String firstName) {
		assert(name != null && firstName != null);
		this.name = name;
		this.firstName = firstName;
	}

	public String getUsername() {
		return name + " " + firstName;
	}
	
}
