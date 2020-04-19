package entities;

public class LegalPerson extends Person {

	private Integer employeeNumber;

	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, Double annualIncome, Integer employeeNumber) {
		super(name, annualIncome);
		this.employeeNumber = employeeNumber;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public double payTax() {
		double income = 0;
		if (employeeNumber > 10) {
			income = getAnnualIncome() * 14 / 100;
		} else {
			income = getAnnualIncome() * 16 / 100;
		}
		return income;
	}

}
