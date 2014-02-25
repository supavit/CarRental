import java.util.Date;

public class DrivingLicence {

	private String driverName;
	private String dateOfBirth;
	private String licenceNumber;
	private String dateOfIssue;
	private boolean isItFullLicence;
	
	public DrivingLicence(String driverName, String dateOfBirth, String licenceNumber, String dateOfIssue, boolean isItFullLicence)
	{
		this.driverName = driverName;
		this.dateOfBirth = dateOfBirth;
		this.licenceNumber = licenceNumber;
		this.dateOfIssue = dateOfIssue;
		this.isItFullLicence = isItFullLicence;
		
	}
	
	public String getDriverName()
	{
		return driverName;
	}
	
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public String getLicenceNumber()
	{
		return licenceNumber;
	}

	public String getDateOfIssue()
	{
		return dateOfIssue;
	}
	
	public boolean isItFullLicence()
	{
		return isItFullLicence;
	}
	
}
