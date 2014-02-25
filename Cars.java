import java.util.*;

public class Cars {

	private static final int SMALL_TANK = 49;
	private static final int LARGE_TANK = 60;
	
	private String typeOfCar;
	private int fuel;
	private ArrayList<CarRegistrationNumber> carRegistrationNumbers;
	private ArrayList<DrivingLicence> drivingLicences;
	
	public Cars()
	{
		carRegistrationNumbers = new ArrayList<CarRegistrationNumber>();
	}
	
	public String getCarRegistrationNumber()
	{
		
		return null;
	}
	
	public int getFuelTank(String typeOfCar)
	{
		if(typeOfCar.equals("S"))
		{
			return SMALL_TANK;
		}
		else
		{
			return LARGE_TANK;
		}
	}
	
	public int getCurrentFuel()
	{
		return fuel;
	}

	public boolean isTankFull()
	{
		if(typeOfCar.equals("S"))
		{
			if(getCurrentFuel() == SMALL_TANK)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(getCurrentFuel() == LARGE_TANK)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public boolean isCarRented(String registNum)
	{
		/*
		 * use registNum search in pool of car rented
		 * if found, return true
		 * else return false
		 * */
		return false;
	}
	
	public void addFuel(int add)
	{
		if(isTankFull())
		{
			System.out.println("Fuel was added: 0 (Tank is aleady full)");
		}
		else
		{
			
		}
	}
	
	public int driveTheCar(int km)
	{
		return 0;
	}
	
	public HashMap getCarsToHashMap()
	{
		HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
        ArrayList<String> values = new ArrayList<String>();
        
        String key = "Car number";
        
        for(DrivingLicence drivingLicence : drivingLicences)
        {
           values.add(drivingLicence.toString()); // Add to array
        }
        
        map.put(key, values);
        
        //System.out.println("Check - "+ map);
        return map;
	}

}
