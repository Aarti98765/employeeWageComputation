//CREATED CLASS EMPWAGEUC7
public class empWageUC7 {
	public static final int IS_PART_TIME = 1;
   	public static final int IS_FULL_TIME = 2;
   	public static final int EMP_RATE_PER_HOUR = 20;
   	public static final int NUM_OF_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;
   	static void empWage() {
		int empHrs = 0;
		int empWage = 0;
		int totalWage = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while (totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
		   	totalWorkingDays++;
			totalEmpHrs++;
			switch ( empCheck ) {
				case IS_FULL_TIME:
					empHrs = 8;
					break; 
		      		case IS_PART_TIME:
			      		empHrs = 4;
					break;
			   	default :
					empHrs= 0;
			}
			empWage = empHrs * EMP_RATE_PER_HOUR;
			totalWage=totalWage+empWage;
			System.out.println("Daily Emp wage: " + empWage);
	 	}
	 	System.out.println("Total emp wage: " + totalWage);
  	}
	//MAIN DRIVER PROGRAM
  	public static void main(String args[]) {
		empWage();	
  	}
}
