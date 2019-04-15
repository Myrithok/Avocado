package avocado;

enum Location {
	Canada,NewFoundLandAndLabrodor,PEI,NovaScotia,NewBrunswick,Quebec,Ontario,Manitoba,Saskatchewan,Alberta,BritishColumbia;
	
	public int toval() {
		switch(this.name()) {
			case "Canada":
				return 1;
			case "NewFoundLandAndLabrodor":
				return 2;
			case "PEI":
				return 3;
			case "NovaScotia":
				return 4;
			case "NewBrunswick":
				return 5;
			case "Quebec":
				return 6;
			case "Ontario":
				return 7;
			case "Manitoba":
				return 8;
			case "Saskatchewan":
				return 9;
			case "Alberta":
				return 10;
			case "BritishColumbia":
				return 11;
			default:
				return 0;
		}
	}
}