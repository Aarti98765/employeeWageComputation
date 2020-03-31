import java.util.*;
class empWageBuilder {
	void empWage(int maxHrsInMonth, int numWorkingDays, int empRatePerHr, String companyName) {
		   int empHrs = 0;
	   	int empWage = 0;
	   	int totalWage = 0;
	   	int totalEmpHrs = 0;
	   	int totalWorkingDays = 0;
	   	while (totalEmpHrs <= maxHrsInMonth && 
           	   totalWorkingDays < numWorkingDays) { 
					int empCheck = (int) Math.floor(Math.random() * 10) % 3;
					totalWorkingDays++;
					totalEmpHrs++;
					switch ( empCheck ) {
	        			case 1 :
							empHrs = 8;
							break; 
		        		case 2 :
			      		empHrs = 4;
							break;
			   		default :
							empHrs= 0;
					}
					empWage = empHrs * empRatePerHr;
					totalWage=totalWage+empWage;
	  		}
			display(companyName,maxHrsInMonth,numWorkingDays,empRatePerHr,totalWage);
	}
	void display(String companyName,int maxHrsInMonth,int numWorkingDays,int empRatePerHr,int totalWage) {
	  		System.out.println("Company is " + companyName);
	  		System.out.println("Maximum hours per month is:" + maxHrsInMonth);
	  		System.out.println("Number of working days in month:" + numWorkingDays);
      	System.out.println("Employee rate per hour is:" + empRatePerHr);
      	System.out.println("Total wage of employees:" + totalWage);
			System.out.println("");
    }
}
public class empWageUC8 {
	 public static void main(String args[]) {
		empWageBuilder companyFirstObj = new empWageBuilder();
		companyFirstObj.empWage(100,22,20,"Bridglabz");
		empWageBuilder companySecondObj = new empWageBuilder();
		companySecondObj.empWage(120,20,22,"Thought works");
  	 }
}
