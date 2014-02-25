import java.util.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainClass {

	private static Scanner input = new Scanner(System.in);
    private static FileIO f;
    private static ArrayList<DrivingLicence> drivingLicences = new ArrayList<DrivingLicence>();

	public static int availableCars(String typeOfCar)
	{
		return 0;
	}
	
	public static Cars getRentedCars()
	{
		return null;
	}
	
	public static Cars getCar(String drivingLicence)
	{
		return null;
	}
	
	public static boolean issueCar(String drivingLicence, String typeOfCar)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy"); // Get current year
        Date date = new Date();
        int currentYear = Integer.parseInt(dateFormat.format(date)); //Convert current year to integer
        // to calculate is this customer's age > 20, 25 and DLicence > 1, 5 years
        
		return true;
	}
	
	public static void addNewCustomer(String name, String dateOfBirth, String dateOfIssue, String fullLicence)
	{
		boolean isItFullLicence;
		
		if(fullLicence.equals("Y"))
		{
			isItFullLicence = true;
		}
		else
		{
			isItFullLicence = false;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy"); // Get current year
        Date date = new Date();
        int currentYear = Integer.parseInt(dateFormat.format(date)); //Convert current year to integer
        
        /*-- Generate Driving Licence --*/
        String[] tempName = name.split(" ");
        System.out.println("FN:" +tempName[0]);
        System.out.println("LN:" +tempName[1]);
        
        						// Name        , DOB         , DLicence    , DateOfIssue , full?
		drivingLicences.add(new DrivingLicence(name, dateOfBirth, "JS-1990-01", dateOfIssue, isItFullLicence));
		
	}
	
	/*--- Main method ---*/
	public static void main(String[] args) throws IOException {
		
		f = new FileIO();
		window();
		
		/*
		CarRegistrationNumber crn = new CarRegistrationNumber();
		crn.getSecondComponent();
		*/
	}

	public static void window()
	{
		int choice = 0;
		
		while(choice != 1)
        {
			System.out.println("**************************************************");
			System.out.println("***                                            ***");
			System.out.println("***           WELCOME TO CAR RENTAL            ***");
			System.out.println("***                                            ***");
			System.out.println("**************************************************");
			System.out.println("*** Menu ***");
			System.out.println("1 - to display the number of cars that are available to rent");
	        System.out.println("2 - (getRentedCars) to display on the screen the information about all the cars currently rented out");
	        System.out.println("3 - (getCar(DLicence)) to display on the screen the car they are currently renting");
	        System.out.println("4 - (issueCar(DLicence, typeOfCar))to issued a car");
	        System.out.println("5 - to terminate Rental");
	        System.out.println("6 - Add new customer");
	        System.out.println("7 - Exit");
	        System.out.println("_______________________________________________________________________________");
	        System.out.print("> ");
	        choice = input.nextInt();
	        
			switch(choice)
	        {
	            case 1: System.out.println("--- Available Cars ---");
	            		
	            		String typeOfCar = " ";
	            		while(("small".equals(typeOfCar) == false) && ("large".equals(typeOfCar) == false))
	            		{
	            			System.out.println("Please select type of car (small/large)");
	            			System.out.print(">");
	            			typeOfCar = input.next();
	            		}
	            		System.out.println("Check >"+typeOfCar);
	            		f.writerFile("TEST");
	            		//readFile();
	                    break;
	                    
	            case 2: System.out.println("--- getRentedCars ---");
	                    break;
	                    
	            case 3: System.out.println("--- getCar(DLicence) ---");
	                    break;
	                    
	            case 4: System.out.println("-------------- issueCar(DLicence, typeOfCar) --------------");
	                    break;
	                    
	            case 5: System.out.println("-------------- terminate Rental --------------");
	                    break;
	                    
	            case 6: System.out.println("--- Add new customer ---");
	            
			            System.out.println("Please enter customer name (firstname lastname)");
		                System.out.print("> ");
		                String name = input.next();
		                
		                String datePattern = "\\d{1,2}/\\d{1,2}/\\d{4}";
		                String dob = input.next();
		                System.out.println("Please enter date of birth (dd/mm/yyyy)");
		                while(!dob.matches(datePattern))
		                {
			                System.out.print("> ");
			                dob = input.next();
		                }
		                System.out.println("Please enter date of issue (dd/mm/yyyy)");
		                String doi = input.next();
		                
		                while(!doi.matches(datePattern))
		                {
			                System.out.print("> ");
			                doi = input.next();
		                }
		                
		                System.out.println("Is it a full driving licence? (Y/N)");
		                System.out.print("> ");
		                String fullLicence = input.next();
		                
		                
                		addNewCustomer(name, dob, doi, fullLicence);
                		break;
                		
	            case 7: System.out.println("Test function");
	            
	            	for(DrivingLicence drivingLicence : drivingLicences) 
	            	{
	            		System.out.println(drivingLicence.getDriverName());
	            		
	            	}
	            		//System.exit(1);
        		break;
                
	            default: System.out.println("The command is not valid, Please try again"); 
	            		window();
	                    break;
	        }
        }
	}
	
}
