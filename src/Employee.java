import java.util.Collections;
import java.util.List;

/*
 * CS111-010
 * Programming Assignment 1
 * Jason Huffman
 */
public abstract class Employee {

	
	//VALUES\\
	
	private Integer ID;
	private String firstName;
	private String lastName;
	private String title;
	private float totalPay;
	private char type;
	
	//CONSTRUCTORS\\
	
	Employee(){
		firstName = null;
		lastName = null;
		ID = 0000;
		title = "Unemployed";
	}
	
	Employee(Integer id, String first, String last, char employeeType, String emTitle){
		firstName=first;
		lastName=last;
		ID=id;
		title = emTitle;
		type=employeeType;
		calculatePay();
	}
	
	//GETTORS/ACCESSORS\\
	
	public Integer getID(){
		return ID;
	}//End getID
	
	public String getFirstName(){
		return firstName;
	}//End getFirstName
	
	public String getLastName(){
		return lastName;
	}//End getLastName
	
	public char getType() {
		return type;
	}//End getType

	public String getTitle(){
		return title;
	}//End getTitle
	
	public float getTotalPay(){
		return totalPay;
	}//End getTotalPay
	
	//SETTORS/ACCESSORS\\
	
	public void setTotalPay(float newTotalPay){
		totalPay=newTotalPay;
	}//End setTotalPay
	
	//METHODS\\
	
	abstract void calculatePay();
	
	abstract void print();
	

	
	
}
