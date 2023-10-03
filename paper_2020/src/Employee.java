
public class Employee {

		private int employeeNumber;
		private String familyName;
		private String givenName;
		
		private double basicHourlyRate;
		private double contractedHoursPerMonth;
		private double hoursWorkedPerMonth;
		
		private double overtimeMultiplier;

		public Employee(int employeeNumber, String familyName, String givenName, double basicHourlyRate, double contractedHoursPerMonth)
		throws IllegalArgumentException {
			
			if (employeeNumber < 10000 && employeeNumber > 0) {
				this.employeeNumber = employeeNumber;
			} else {
				throw new IllegalArgumentException();
			}
			
			if (familyName != "") {
				this.familyName = familyName;
			} else {
				throw new IllegalArgumentException();
			}
			
			if (givenName != "") {
				this.givenName = givenName;
			} else {
				throw new IllegalArgumentException();
			}
			
			if (basicHourlyRate > 9.50 && basicHourlyRate < 100) {
				this.basicHourlyRate = basicHourlyRate;
			} else {
				throw new IllegalArgumentException();
			}
			
			if (contractedHoursPerMonth > 20 && contractedHoursPerMonth < 200) {
				this.contractedHoursPerMonth = contractedHoursPerMonth;
			} else {
				throw new IllegalArgumentException();
			}
			
			this.hoursWorkedPerMonth = 0;
			
			this.overtimeMultiplier = 1.50;
			
		}
		
		public double computePay() {
			
			double overtimePay = 0.00;
			double hours = 0.00;
			
			if (this.hoursWorkedPerMonth > this.contractedHoursPerMonth) {
				overtimePay = ((this.hoursWorkedPerMonth - this.contractedHoursPerMonth)*(this.basicHourlyRate*this.overtimeMultiplier));
				hours = this.hoursWorkedPerMonth - this.contractedHoursPerMonth;
			} else {
				hours = this.hoursWorkedPerMonth;
			}
			
			double pay = hours*this.basicHourlyRate + overtimePay;
			return pay;
		}
		
}
