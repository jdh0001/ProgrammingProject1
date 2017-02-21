/*
 * CS111-010
 * Programming Assignment 1
 * Jason Huffman
 */
public class Commission extends Employee{

	//VALUES\\
	
	private float salary;
	private float commissionRate;
	private float commissionSales;
	private float commissionThreshold;
	
	//CONSTRUCTORS\\
	
	public Commission(Integer id, String first, String last, char employeeType, String emTitle, float salaryAm, float threshold, float rate) {
		
		super(id, first, last, employeeType, emTitle);
		
		this.salary=salaryAm;
		this.commissionThreshold=threshold;
		this.commissionRate=rate;
		
	}
	
	//GETTORS/ACCESSORS\\
	
	public float getSalary(){
		return salary;
	}//End getSalary
	
	public float getCommissionRate(){
		return commissionRate;
	}//End getCommissionRate
	
	public float getCommissionSales(){
		return commissionSales;
	}//End getCommissionSales
	
	public float getCommissionThreshold(){
		return commissionThreshold;
	}//End getCommissionThreshold
	
	//SETTORS/MUTATORS\\
	
	public void setCommissionSales(float newSales){
		commissionSales = newSales;
	}//End setCommissionSales

	//INHERITED METHODS\\
	
	@Override
	void calculatePay() {
		if(commissionSales>commissionThreshold){
			setTotalPay((salary/24) + ((commissionSales-commissionThreshold) * commissionRate));
		} else {
			setTotalPay(salary/24);
		}//end if-else
	}//End calculatePay

	@Override
	void print() {
		
		System.out.println(getType()+" "+getID()+" "+getFirstName()+" "
				+getLastName()+" "+getTitle()+" "+this.salary+" "
				+this.commissionRate+" "+this.commissionThreshold+" "
				+this.commissionSales);
		
	}

}
