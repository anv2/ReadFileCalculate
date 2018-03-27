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

public class Records {

	private String name;			//name of person on record
	private String dob;			//date of birth of person on record
	private int annual_salary;	//annual salary of person on record
	private String role;			//role of person on record
	
	//constructor, no argument
	public Records(){
		this("", "", 0 , "");
	}
	//constructor
	//@param n name, d date of birth, as annual salary, r role
	public Records(String n, String d, int as, String r){
		setName(n);
		setDOB(d);
		setAnnual_Salary(as);
		setRole(r);
	}
	//setter for name
	//@param name
	public void setName(String n){
		name=n;
	}
	//setter for date of birth
	//@param date of birth
	public void setDOB(String d){
		dob=d;
	}
	//setter for salary
	//@param salary
	public void setAnnual_Salary(int as){
		annual_salary=as;
	}
	//setter for role
	//@param role
	public void setRole(String r){
		role=r;
	}
	//getter for name
	//@return name
	public String getName(){
		return name;
	}
	//getter for date of birth
	//@return date of birth
	public String getDOB(){
		return dob;
	}
	//getter for salary
	//@return salary
	public int getAnnual_Salary(){
		return annual_salary;
	}
	//getter for role
	//@return role
	public String getRole(){
		return role;
	}
}
