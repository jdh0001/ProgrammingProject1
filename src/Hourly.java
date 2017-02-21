/*
 * CS111-010
 * Programming Assignment 1
 * Jason Huffman
 */
public class Hourly extends Employee{

	//VALUES\\
	
	private float hoursWorked;
	private float hourlyRate;
	private boolean overtimeEligible;
	private String isItEligible;
	
	//CONSTRUCTORS\\
	
	public Hourly(Integer id, String first, String last, char employeeType, String emTitle, float rate, String overtime, float hours) {
		super(id, first, last, employeeType, emTitle);
		hoursWorked=hours;
		hourlyRate=rate;
		isEligible(overtime);
	}
	
	//GETTORS/ACCESSORS\\
	
	public float getHoursWorked(){
		return hoursWorked;
	}//End getHoursWorked
	
	public float getHourlyRate(){
		return hourlyRate;
	}//End getHourlyRate
	
	public boolean getOvertimeEligible(){
		return overtimeEligible;
	}//End getOVertimeEligible
	
	//SETTORS/MUTATORS\\
	
	public void setHoursWorked(float newHours){
		hoursWorked=newHours;
	}//End setHoursWorked
	
	//INHERITED METHODS\\

	@Override
	void calculatePay() {
		//overtime pay is 1.5 times the hourly rate
		//if the employee is eligible and has worked
		//more than 80 hours
		if(!this.overtimeEligible){
			setTotalPay(hoursWorked*hourlyRate);
		} else if (this.overtimeEligible) {
			if(hoursWorked<=80){
				setTotalPay(hoursWorked*hourlyRate);
			}else{
				setTotalPay(hoursWorked*hourlyRate*(1.5f));
			}//end inner if-else
		} else {
			System.out.println("A catastrophic error has occured.");
		}//end outer if-else
	}//End calculatePay

	private void isEligible(String eligible){
		if(eligible.equalsIgnoreCase("Y")){
			this.isItEligible="Y";
			this.overtimeEligible=true;
		} else if(eligible.equalsIgnoreCase("N")){
			this.isItEligible="N";
			this.overtimeEligible=false;
		}//end if-else	
	}//end is eligible
	
	@Override
	void print() {
		System.out.println(getType()+" "+getID()+" "+getFirstName()+" "
				+getLastName()+" "+getTitle()+" "+this.hourlyRate+" "
				+this.isItEligible+" "+this.hoursWorked);
	}//End print

}
