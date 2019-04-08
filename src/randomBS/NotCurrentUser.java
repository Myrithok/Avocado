package randomBS;

public class NotCurrentUser implements Comparable<NotCurrentUser> {
	private String username;
	private double score;

	public NotCurrentUser(String username, double score) {
		this.username = username;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public double getScore() {
		return score;
	}

	public int compareTo(NotCurrentUser that) {
		if (this.score > that.getScore()) {
			return 1;
		} else if (this.score == that.getScore()) {
			return 0;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		// Dakota test area

		// Andrew test area

		// Erfan test area

		// Daniel test area
	}
}
