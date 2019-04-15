package avocado;

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
	
}