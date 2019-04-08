package randomBS;

public enum Sex {
	Male,Female,PreferNotToSpecify;
	
	public int toval() {
		switch(this.name()) {
			case "Male":
				return 2;
			case "Female":
				return 3;
			case "PreferNotToSpecify":
				return 1;
			default:
				return 0;
		}
	}
	
	public static void main(String[] args) {
		Sex test = valueOf("Male");
		System.out.println(test.toString());
		System.out.println(test.toval());
	}
}