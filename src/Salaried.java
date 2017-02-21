/*
 * CS111-010
 * Programming Assignment 1
 * Jason Huffman
 */
public class Salaried extends Employee {

	//VALUES\\
	
	private float salary;
	
	//CONSTRUCTORS\\
	
	public Salaried(Integer id, String first, String last, char employeeType, String emTitle, float salaryAm) {
		super(id, first, last, employeeType, emTitle);
		this.salary=salaryAm;
	}

	//GETTORS/ACCESSORS\\
	
	public float getSalary(){
		return salary;
	}//End getSalary
	
	//SETTORS/ACCESSORS\\
	
	public void setSalary(float newSalary){
		//remember to implement check for negative salary
		salary=newSalary;
	}
	
	//INHERITED METHODS\\
	
	@Override
	void calculatePay() {
		setTotalPay(salary/24);
	}

	@Override
	void print() {
		System.out.println(getType()+" "+getID()+" "+getFirstName()+" "
				+getLastName()+" "+getTitle()+" "+this.salary);
	}

}
