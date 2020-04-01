import java.util.*;
import java.util.Scanner;
//CREATED INTERFACE
interface IempWageBuilder {
	void empWageComputation();
}
//CREATED CLASS EMPWAGEUC12
public class empWageUC12 implements IempWageBuilder {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	ArrayList <companyEmpWage> company = new ArrayList<companyEmpWage>();
   	public void empWageComputation() {
		for ( companyEmpWage empObj : company) {
			int empHrs = 0;
	   		int empWage = 0;
	   		int totalWage = 0;
	   		int totalEmpHrs = 0;
	 	  	int totalWorkingDays = 0;
			while (totalEmpHrs <= empObj.obatinMonthMaxHrs() && 
           	   	      totalWorkingDays < empObj.obtainWorkingDaysEmp()) { 
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
				empWage = empHrs * empObj.obatinRateOfEmp();
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
   		empWageUC12 employee = new empWageUC12();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter company count:");
		int companyCount = scan.nextInt();
		for (int index=0; index<companyCount; index++) {
         		System.out.println("Enter maximum hours of working in month for a company:");
         		int maxHrMonth = scan.nextInt();
         		System.out.println("Enter number of days of working for a company:");
         		int numOfWorkDays = scan.nextInt();
         		System.out.println("Enter per hour rate of employee:");
         		int empRateHr= scan.nextInt();
         		employee.company.add(new companyEmpWage(maxHrMonth, numOfWorkDays, empRateHr));
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

