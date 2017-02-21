
import java.io.*;
import java.util.*;


public class TestClassMain {

	public static void main(String[] args) {
		List <Employee> employeeRoster=new ArrayList(30);
		//only employ 30 employees so the max is 30
		Scanner readFile=null;
		Scanner userInput=new Scanner(System.in);
		String filePath;
		boolean fudgedIt=true;
		
		while(fudgedIt){
			fudgedIt=false;
			try{
				System.out.println("Please input the file path to be read.");
				filePath=userInput.nextLine();
				readFile= new Scanner(new File(filePath));
			}catch(Exception e){
				System.out.println("Invalid path. Please try again.");
				fudgedIt=true;
			}//end try-catch
		}//end while
		
		employeeRoster = fillRoster(readFile);
		sortEmployees(employeeRoster);
		printRoster(employeeRoster);
	}//End main
	
	//E:/project1employeedata.txt
	
	public static List<Employee> fillRoster(Scanner input){
		List<Employee> newList = new ArrayList();
		//instantiates the new employee based on the string
		//letter at the beginning and adds them to the list
		while(input.hasNextLine()){
			switch(input.next()){
				case "S":
					Employee newSE = new Salaried((Integer)input.nextInt(), 
							input.next(), input.next(),'S', input.next(), input.nextFloat());
					newList.add(newSE);
					input.nextLine();
					break;
				case "H":
					Employee newHE = new Hourly((Integer)input.nextInt(), 
							input.next(), input.next(),'H', input.next(), input.nextFloat(),
							input.next(), input.nextFloat());
					newList.add(newHE);
					input.nextLine();
					break;
				case "C":
					Employee newCE = new Commission((Integer)input.nextInt(), 
							input.next(), input.next(),'C', input.next(), input.nextFloat(),
							input.nextFloat(), input.nextFloat());
					newList.add(newCE);
					input.nextLine();
					break;
				default: 
					break;
			}//end switch
		}//end if
		return newList;
	}//End fillRoster
	
	public static void sortEmployees(List<Employee> aList){
		int size = aList.size();
		boolean sorted=false;
		while(!sorted){
			sorted=true;
				for(int i=0;i<size;i++){
					if(i+1!=size&&aList.get(i).getType()>aList.get(i+1).getType()){
						swap(aList, i, (i+1));
						sorted=false;
					}//end if
				}//end for	
		}//end while		
	}//End sortEmployees

	private static void swap(List<Employee> aList, int posI, int posF){
		Employee temp1 = aList.remove(posI);
		Employee temp2 = aList.remove(posF-1);
		aList.add(posI, temp2);
		aList.add(posF, temp1);
	}//End swap
	
	public static void printRoster(List<Employee> roster){
		int size = roster.size();
		double totalComPay=0.0;
		double totalHourPay=0.0;
		double totalSalPay=0.0;
		//loops through to calculate pay
		//then takes the employee's total pay and adds it 
		//to the total of the employee's type
		System.out.println(" ");
		for(int i=0;i<size;i++){
			roster.get(i).calculatePay();
			if(roster.get(i).getType()=='C'){
				totalComPay = totalComPay + roster.get(i).getTotalPay();
				roster.get(i).print();
			} else if(roster.get(i).getType()=='H'){
				if(roster.get(i-1).getType()=='C'){
					System.out.printf("Total Pay is: $"+"%.2f%n", totalComPay);
					System.out.println("");
					System.out.println("");
				}//end inner if
				totalHourPay = totalHourPay + roster.get(i).getTotalPay();
				roster.get(i).print();	
			} else if(roster.get(i).getType()=='S'){
				if(roster.get(i-1).getType()=='H'){
					System.out.printf("Total Pay is: $"+"%.2f%n", totalHourPay);
					System.out.println("");
					System.out.println("");
				}//end inner if 
				totalSalPay = totalSalPay + roster.get(i).getTotalPay();
				roster.get(i).print();
			}//end if-else	
		}//end for
		System.out.printf("Total Pay is: $"+"%.2f%n", totalSalPay);	
	}//End printRoster
	

}//End class
