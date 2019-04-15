package avocado;

enum EducationLevel {
	Bachelor, Master, Doctorate;

	public int toDebtVal() {
		switch (this.name()) {
		case "Bachelor":
			return 2;
		case "Master":
			return 3;
		case "Doctorate":
			return 4;
		default:
			return 0;
		}
	}

	public int toIncomeVal() {
		switch (this.name()) {
		case "Bachelor":
			return 12;
		case "Master":
			return 21;
		case "Doctorate":
			return 25;
		default:
			return 0;
		}
	}
}