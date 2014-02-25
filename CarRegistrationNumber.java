import java.util.*;
import java.util.regex.*;


public class CarRegistrationNumber {

	private String registNum;
	
	public CarRegistrationNumber()
	{
		
	}
	
	public String getRegistrationNumber()
	{
		return registNum;
	}
	
	public String getFirstComponent()
	{
		String firstComp = "";
		
		firstComp = splitComponents(registNum).toArray()[0].toString();
		
		System.out.println("Check: "+ firstComp);
		
		return firstComp;
	}
	
	public String getSecondComponent()
	{
		String secondComp = "";
		
		secondComp = splitComponents(registNum).toArray()[1].toString();
		
		System.out.println("Check: "+ secondComp);
		
		return secondComp;
	}
	
	private List<String> splitComponents(String comp)
	{
		List<String> output = new ArrayList<String>();
	    Matcher match = Pattern.compile("[0-9]+|[a-z]+|[A-Z]+").matcher(comp);
	    while (match.find()) {
	        output.add(match.group());
	    }
	    return output;
	}
	
}
