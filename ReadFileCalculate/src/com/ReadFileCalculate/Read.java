/**
* The ReadFileCalculate program implements an application that
* takes a csv file chosen by the user, parses the file, and makes calculations 
* chosen by the user using the command line interface.
* 
* @author  Vithia An
* @version 1.0
* @since   2018-03-24 
*/

package com.ReadFileCalculate;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Read {
	
	private Scanner sc =null;
	private Scanner scr = null;
	
	Records records = new Records();
	int aTotal=0;	//Total salary in dollars
	int bTotal=0;	//Total salary in dollars grouped by role
	
	//method to open file
	public void openFile(){
		try{
			System.out.println("Type in the name of the file (example: records.csv )");
			
			String fname;
			Scanner scanner = new Scanner(System.in);
			fname = scanner.next();
			File file = new File(fname);

			sc = new Scanner(file);
			sc.useDelimiter(",|\\r\\n");
			
		}
		catch(FileNotFoundException f){
			System.err.println("File not found");
			System.exit(1);
		}
	}
	//method to read records
	//@param L the salary limit reached by the sum of individual salaries
	public void readRecordsG(int L){
		int sumGroup =0;		//sum of individual salaries
		int sumf =0;			//final sum after comparing sumGroup with L
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		try{
			while(sc.hasNext()  ){
				records.setName(sc.next() );
				records.setDOB(sc.next() );
				records.setAnnual_Salary(sc.nextInt() );
				records.setRole(sc.next() );
				 
				map.put(records.getName(), records.getAnnual_Salary() );
			}

			Map<String, Integer> sortedMap = CompareTest.sortByValue(map, L);
			Map<String, Integer> mapf= new HashMap<String, Integer>();	

			for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {

				if(sumGroup <=L){
					sumGroup += entry.getValue();
					mapf.put(entry.getKey(), entry.getValue());
					if(sumGroup> L){
					sumf = sumGroup - entry.getValue();
					mapf.values().remove(entry.getValue());
					
					}
				}
			}

		    System.out.printf("%s$%d.\n","Groupings of people whose sum of annual salary are \n as close to the input number (without going over): ",sumf);
			for (Map.Entry<String, Integer> entry : mapf.entrySet()) {
				System.out.printf("%-12s$%-12d\n", entry.getKey(),entry.getValue() );
			}
		}//try
			
		catch(NoSuchElementException n){
			System.err.println("No such file." );
			sc.close();
			System.exit(1);
		}
		catch(IllegalStateException il){
			System.err.println("Error reading from file.");
			System.exit(1);
		}//catch

	}//read method

	//method to read records by specifying only interested roles
	//@param roles of interest
	public int readRecordsFilter(String role){

		try{
			while(sc.hasNext() ){
				records.setName(sc.next() );
				records.setDOB(sc.next() );
				records.setAnnual_Salary(sc.nextInt() );
				records.setRole(sc.next() );
				if(records.getRole().equals(role)){
					bTotal += records.getAnnual_Salary(); 
				}				
			}//while
		}//try	
		catch(NoSuchElementException n){
			System.err.println("No such file." );
			sc.close();
			System.exit(1);
		}
		catch(IllegalStateException il){
			System.err.println("Error reading from file.");
			System.exit(1);
		}//catch
		return bTotal;
	}
	//method to read records 
	//@return sum of annual salary of all records
	public int readRecords(){
		try{
			while(sc.hasNext() ){
				records.setName(sc.next() );
				records.setDOB(sc.next() );
				records.setAnnual_Salary(sc.nextInt() );
				records.setRole(sc.next() );
				aTotal += records.getAnnual_Salary(); 
			}//while
		}//try
		catch(NoSuchElementException n){
			System.err.println("No such file." );
			sc.close();
			System.exit(1);
		}
		catch(IllegalStateException il){
			System.err.println("Error reading from file.");
			System.exit(1);
		}//catch
		return aTotal;
	}//read method
	
	//method to print grand annual salary
	void printa(){
		System.out.printf("%s$%d.\n","Total salary in dollars: " ,aTotal);
	}
	//method to implement logic flow of choices 
	void switchCase(int i){
		String role;		//role
		int salaryL;		//salary limit
		switch(i){
			case 0:
				//a. Total salary in dollars
				readRecords();
				break;
			case 1:
				System.out.println("Type into terminal the role (example: engineer) ");
				scr = new Scanner(System.in);
				role = scr.next();
				System.out.printf("%s$%d.\n","Total salary in dollars grouped by role: ", readRecordsFilter(role)) ;
				break;	
			case 2:
				System.out.printf("%s$%d.\n","Total salary in dollars by HOUR: ", readRecords()/2080);
				System.out.printf("%s$%d.\n", "Total salary in dollars by WEEK: ", readRecords()/52);
				System.out.printf("%s$%d.\n", "Total salary in dollars by MONTH: ", readRecords()/12);
				break;
			case 3:
				System.out.println("Type into terminal the role (example: engineer) ");
				scr = new Scanner(System.in);
				role = scr.next();
				
				System.out.printf("%s$%d.\n","Total salary in dollars per HOUR grouped by role. ", readRecordsFilter(role)/2080) ;
				System.out.printf("%s$%d.\n","Total salary in dollars per WEEK grouped by role. ", readRecordsFilter(role)/52) ;
				System.out.printf("%s$%d.\n","Total salary in dollars per MONTH grouped by role. ", readRecordsFilter(role)/12) ;
				break;
				
			case 4:
				System.out.println("Type into terminal the maximum salary.");
				Scanner sc = new Scanner(System.in);
				salaryL = sc.nextInt();
				readRecordsG(salaryL);
				break;	
		}
	}
	//method to read records of specific roles only
	//@param role of interest
	void scase2(String r){
	
		try{
			while(sc.hasNext() ){
				
				records.setName(sc.next() );
				records.setDOB(sc.next() );
				records.setAnnual_Salary(sc.nextInt() );
				records.setRole(sc.next() );

				if(records.getRole().equals(r)){
					bTotal += records.getAnnual_Salary();
				}
				
			}//while
			System.out.println("Total role earning. "+bTotal);
		}//try
			
		catch(NoSuchElementException n){
			System.err.println("No such file." );
			sc.close();
			System.exit(1);
		}
		catch(IllegalStateException il){
			System.err.println("Error reading from file.");
			System.exit(1);
		}//catch
	}
	//method to close file
	public void close(){
		if(sc!=null){
			sc.close();
		}
	}//method
}
