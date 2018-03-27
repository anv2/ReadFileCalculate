/**
* The ReadFileCalculate program implements an application that
* takes a csv file chosen by the user, parses the file, and makes calculations 
* selected by the user using the command line interface.
* 
* @author  Vithia An
* @version 1.0
* @since   2018-03-24 
*/

package com.ReadFileCalculate;
import java.util.Scanner;

public class ReadFileMain {

	public static void main(String[] args){

		Read rFile = new Read();
		rFile.openFile();

		System.out.println("Choose a number from 0 to 4");
		//calculation type
		System.out.println( "0 - Total salary in dollars");
		System.out.println( "1 - Total salary in dollars grouped by role");
		System.out.println( "2 - Total salary in dollars by hour, week, month.");
		System.out.println( "3 - Total salary in dollars by time unit grouped by role.");
		System.out.println( "4 - Groupings of people whose sum of \n annual salary are as close to input number.");
		
	
		int i = 4;
		Scanner sc = new Scanner(System.in);
		i= sc.nextInt();

		switch(i){
			case 0:
				rFile.switchCase(0);
				rFile.printa();
				break;
			case 1:
				rFile.switchCase(1);
				break;	
			case 2:
				rFile.switchCase(2);
				break;
			case 3:
				rFile.switchCase(3);
				break;
			case 4:
				rFile.switchCase(4);
				break;
		}	
		rFile.close();
	}
}
