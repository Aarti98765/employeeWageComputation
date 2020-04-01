import java.util.*;
import java.util.Scanner;
//CREATED CLASS EMPWAGEUC10
public class empWageUC10 {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static final int COMPANIES_COUNT = 3;
	public static void empWageComputation(companyEmpWage company) {
		int empHrs = 0;
	   	int empWage = 0;
	   	int totalWage = 0;
	   	int totalEmpHrs = 0;
	 	int totalWorkingDays = 0;
		while (totalEmpHrs <= company.obtainMonthMaxHrs() && 
           	       totalWorkingDays < company.obtainWorkingDaysEmp()) { 
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
			empWage = empHrs * company.obtainRateOfEmp();
			totalWage=totalWage+empWage;
	  	}
		displayEmpWage(totalWage);
	}
	public static void displayEmpWage(int totalWage) {
	  		System.out.println("Company");
      			System.out.println("Total wage of employees:" + totalWage);
			System.out.println("");
    	}
	//MAIN DRIVER PROGRAM
   	public static void main(String args[]) {
		companyEmpWage company[] = new companyEmpWage [COMPANIES_COUNT];
   		for (int index=0; index<COMPANIES_COUNT; index++) {
         		Scanner scan = new Scanner(System.in);
         		System.out.println("Enter maximum hours of working in month for a company:");
         		int maxHrMonth = scan.nextInt();
         		System.out.println("Enter number of days of working for a company:");
         		int numOfWorkDays = scan.nextInt();
         		System.out.println("Enter per hour rate of employee:");
         		int empRateHr= scan.nextInt();
         		company[index] = new companyEmpWage(maxHrMonth, numOfWorkDays, empRateHr);
        		empWageComputation(company[index]);
  		} 
    	}
}
//CREATED CLASS COMPANYEMPWAGE
class companyEmpWage {
	private int  maxHrsInMonth = 0;
   	private int  numWorkingDays = 0;
   	private int  empRatePerHr  = 0;
	companyEmpWage(int maxHrsMonth, int numOfWorkingDays, int empRatePerHrs) {
        	maxHrsInMonth = maxHrsMonth;
      		numWorkingDays = numOfWorkingDays;
         	empRatePerHr = empRatePerHrs;    
   	} 	 
	public int obtainRateOfEmp() {
		return maxHrsInMonth;
	}
	public int obtainWorkingDaysEmp() {
		return numWorkingDays;
	}
	public int obtainMonthMaxHrs() {
		return empRatePerHr;
	}
}

