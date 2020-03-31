import java.util.*;
class empWageBuilder {
	private int  MAX_HRS_IN_MONTH = 0;
   private int  NUM_WORKING_DAYS = 0;
   private int  EMP_RATE_PER_HR  = 0;
	private int  COMPANY_COUNT = 0;
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	empWageBuilder(int MAX_HRS_MONTH, int NUM_OF_WORKING_DAYS, int EMP_RATE_PER_HRS,int COMPANY_COUNTS) {
			MAX_HRS_IN_MONTH = MAX_HRS_MONTH;
			NUM_WORKING_DAYS = NUM_OF_WORKING_DAYS;
			EMP_RATE_PER_HR = EMP_RATE_PER_HRS;		
			COMPANY_COUNT = COMPANY_COUNTS;
	} 
	public static void empWageComputation(empWageBuilder company) {
		   int empHrs = 0;
	   	int empWage = 0;
	   	int totalWage = 0;
	   	int totalEmpHrs = 0;
	   	int totalWorkingDays = 0;
			while (totalEmpHrs <= company.MAX_HRS_IN_MONTH && 
           	   totalWorkingDays < company.NUM_WORKING_DAYS) { 
					int empCheck = (int) Math.floor(Math.random() * 10) % 3;
					totalWorkingDays++;
					totalEmpHrs++;
					switch ( empCheck ) {
	        			case IS_FULL_TIME :
								empHrs = 8;
								break; 
		        		case IS_PART_TIME:
			      			empHrs = 4;
								break;
			   		default :
								empHrs= 0;
					}
					empWage = empHrs * company.EMP_RATE_PER_HR;
					totalWage=totalWage+empWage;
	  		}
			display(company.COMPANY_COUNT,company.MAX_HRS_IN_MONTH,company.NUM_WORKING_DAYS,company.EMP_RATE_PER_HR,totalWage);
	}
	public static void display(int COMPANY_COUNT,int MAX_HRS_IN_MONTH,int NUM_WORKING_DAYS,int EMP_RATE_PER_HR,int totalWage) {
	  		System.out.println("Company" + COMPANY_COUNT);
	  		System.out.println("Maximum hours per month is:" + MAX_HRS_IN_MONTH);
	  		System.out.println("Number of working days in month:" + NUM_WORKING_DAYS);
      	System.out.println("Employee rate per hour is:" + EMP_RATE_PER_HR);
      	System.out.println("Total wage of employees:" + totalWage);
			System.out.println("");
    }
}
public class empWageUC9 {
    public static void main(String args[]) {
		   empWageBuilder company1 = new empWageBuilder(100,22,20,1);
		   empWageBuilder company2 = new empWageBuilder(110,20,22,2);
			empWageBuilder company3 = new empWageBuilder(150,20,22,3);
	 		empWageBuilder.empWageComputation(company1);
			empWageBuilder.empWageComputation(company2);
			empWageBuilder.empWageComputation(company3);
    }
}

