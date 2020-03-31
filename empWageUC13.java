import java.util.*;
import java.util.Scanner;
//CREATED INTERFACE
interface IempWageBuilder {
	void empWageComputation();
}
//CREATED CLASS EMPWAGEUC13
public class empWageUC13 implements IempWageBuilder {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	ArrayList <companyEmpWage> company = new ArrayList<companyEmpWage>();
	ArrayList <Integer> dailyWage = new ArrayList<Integer>();
	public void empWageComputation() {
		for ( companyEmpWage empObj : company) {
			int empHrs = 0;
	   		int empWage = 0;
	   		int totalWage = 0;
	   		int totalEmpHrs = 0;
	 	  	int totalWorkingDays = 0;
			while (totalEmpHrs <= empObj.getMonthMaxHrs() && 
           	   	totalWorkingDays < empObj.getWorkingDaysEmp()) { 
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
				empWage = empHrs * empObj.getRateOfEmp();
				dailyWage.add(empWage);
				totalWage=totalWage+empWage;
	  		}
        		display(totalWage, dailyWage);
	  	}
	}
	public static void display(int totalWage, ArrayList<Integer> dailyWage) {
		System.out.println("Company");
		System.out.println("Employee daily wage");
		System.out.println(dailyWage);
      		System.out.println("Total wage of employees:" + totalWage);
		System.out.println("");
        }
	//MAIN DRIVER PROGRAM
   	public static void main(String args[]) {
   		empWageUC13 employee = new empWageUC13();
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

