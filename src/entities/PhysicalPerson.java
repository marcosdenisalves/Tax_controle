package entities;

public class PhysicalPerson extends Person {

	private Double healthExpenditures;

	public PhysicalPerson() {
		super();
	}

	public PhysicalPerson(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double payTax() {
		double income = 0;
		if (getAnnualIncome() < 20000.0) {
			income = getAnnualIncome() * 15 / 100;
		} else if (getAnnualIncome() >= 20000.0) {
			income = getAnnualIncome() * 25 / 100;
		}
		if (healthExpenditures != null) {
			income -= healthExpenditures * 50 / 100;
		}
		return income;
	}

}
