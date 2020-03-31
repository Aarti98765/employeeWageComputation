import java.util.*;
import java.util.Scanner;
//CREATED INTERFACE
interface IempWageBuilder {
	void empWageComputation();
}
//CREATED CLASS EMPWAGEUC11
public class empWageUC11 implements IempWageBuilder {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	private final int COMPANIES_COUNT;
	companyEmpWage company[];
   	public empWageUC11(int COUNT_OF_COMPANIES) {
		COMPANIES_COUNT = COUNT_OF_COMPANIES;
		company = new companyEmpWage [COMPANIES_COUNT];
	}
        public void empWageComputation() {
		for ( int totalCountEmployees = 0; totalCountEmployees < company.length; totalCountEmployees++) {
			int empHrs = 0;
	   		int empWage = 0;
	   		int totalWage = 0;
	   		int totalEmpHrs = 0;
	 	  	int totalWorkingDays = 0;
			while (totalEmpHrs <= company[totalCountEmployees].getMonthMaxHrs() && 
           	   		totalWorkingDays < company[totalCountEmployees].getWorkingDaysEmp()) { 
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
				empWage = empHrs * company[totalCountEmployees].getRateOfEmp();
				totalWage=totalWage+empWage;
	  	       }
		       display(totalWage);
		}
	}
	public static void display(int totalWage) {
		System.out.println("Company");
      		System.out.println("Total wage of employees:" + totalWage);
		System.out.println("");
    	}
	//MAIN DRIVER PROGRAM
	public static void main(String args[]) {
   		empWageUC11 employee = new empWageUC11(3);
		for (int index=0; index<employee.company.length; index++) {
         		Scanner scan = new Scanner(System.in);
         		System.out.println("Enter maximum hours of working in month for a company:");
         		int maxHrMonth = scan.nextInt();
         		System.out.println("Enter number of days of working for a company:");
         		int numOfWorkDays = scan.nextInt();
         		System.out.println("Enter per hour rate of employee:");
         		int empRateHr= scan.nextInt();
         		employee.company[index] = new companyEmpWage(maxHrMonth, numOfWorkDays, empRateHr);
  		} 
		employee.empWageComputation();
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
	public int getRateOfEmp() {
		return maxHrsInMonth;
	}
	public int getWorkingDaysEmp() {
		return numWorkingDays;
	}
	public int getMonthMaxHrs() {
		return empRatePerHr;
	}
}

