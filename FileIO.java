import java.util.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class FileIO {

	private static final String FILENAME = "carFile.txt";
    private static final String FILEINFORMING = "fileInforming.txt";
    private FileWriter outFile;
    private ArrayList<DrivingLicence> drivingLicence;
    
	public FileIO() throws IOException 
	{
		if(checkFile(FILENAME))
		{
			readFile();
		}
		else
		{
			System.out.println("Need to create new file");
		}
	}
	
	/**
     * Check file "earthquakeFile.txt" is it exist?
     * @throws IOException If a valid filename cannot be reach.
     * @return true if file is exist
     */
    private boolean checkFile(String filename) throws IOException
    {
    	URL fileURL = getClass().getClassLoader().getResource(filename);
       
    	if(fileURL == null) 
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
     }
    
	/**
     * Read data in text file
     */
    public void readFile()
    {
        Scanner inFile = null;
        try {
            File resultsFile = makeAbsoluteFilename(FILENAME);
            inFile = new Scanner(new FileReader(resultsFile));
            
            ArrayList<String> dataArrayList = new ArrayList<String>();
            HashMap<String, String> map = new HashMap<String, String>();
            
            while (inFile.hasNextLine())
            {
                String[] line = inFile.nextLine().split(":");
                //System.out.println(line);
                //dataArrayList.add(line);
                
                //String[] columns = inFile.next().split(":");
                map.put(line[0], line[1]);
                System.out.println("Check:"+line[0]);
            }
            
            System.out.println(map);
            
            /*
            ArrayList<String> dataArrayList = new ArrayList<String>();
            ArrayList<String> bookArray = new ArrayList<String>();
            ArrayList<String> memberArray = new ArrayList<String>();
            int[] value = new int[2];
            boolean flag = false;
            //int i = 0;
            
            while (inFile.hasNextLine())
            {
                String line = inFile.nextLine();
                
                dataArrayList.add(line);
                
                if(line.matches("\\d+"))
                {
                    flag = !flag;
                }
                
                if(flag) // true add books
                {
                    bookArray.add(line);
                }
                else // false add members
                {
                    memberArray.add(line);
                }
            }
            
            System.out.println("---------");
            
            
            bookAmount = Integer.parseInt(bookArray.get(0));
            bookArray.remove(0);
            for(int i = 0; i < bookArray.size(); i++)
            {
                String title = bookArray.toArray()[i].toString();
                String author = bookArray.toArray()[++i].toString();
                //System.out.println(bookArray.toArray()[i]+","+bookArray.toArray()[++i]);
                library.enterBook(title, author, true, "");
            }
            
            System.out.println("---------");
            memberAmount = Integer.parseInt(memberArray.get(0));
            memberArray.remove(0);
            for(int i = 0; i < memberArray.size(); i++)
            {
                //System.out.println(memberArray.toArray()[i]);
                String[] name = memberArray.toArray()[i].toString().split(" ");
                library.enterMember(name[0], name[1], 0);
            }
            */
        }
        catch(FileNotFoundException e) {
            System.out.println("Unable to find the file: " + FILENAME);
        }
        catch(IOException e) {
            System.out.println("Error encountered reading the file: " + FILENAME);
        }
    }
    
    public void writerFile(String result)
    {
        try {
            File resultsFile = makeAbsoluteFilename(FILENAME);
            outFile = new FileWriter(resultsFile.getAbsoluteFile(), true);
            
            //outFile.println(result);
            outFile.write(result);
            
            outFile.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Unable to find the file: " + FILENAME);
        }
        catch(IOException e) {
            System.out.println("Error encountered reading the file: " + FILENAME);
        }
    }
    
    /**
     * Create an absolute file from the given file name.
     * If the filename is an absolute one already, then use it
     * unchanged, otherwise assume it is relative to the
     * current project folder.
     * @throws IOException If a valid filename cannot be made.
     */
    private File makeAbsoluteFilename(String filename) throws IOException
    {
        try {
            File file = new File(filename);
            if(!file.isAbsolute()) {
                file = new File(getProjectFolder(), filename);
            }
            return file;
        }
        catch(URISyntaxException e) {
            throw new IOException("Unable to make a valid filename for " + filename);
        }
    }
    
    /**
     * Try to determine the name of the current project folder.
     * This process involves locating the path of the .class file
     * for this class, and then extracting the name of the folder
     * containing it.
     * @throws URISyntaxException If the URL is not formatted correctly.
     * @return The current project folder.
     */
    private File getProjectFolder() throws URISyntaxException
    {
         String myClassFile = getClass().getName() + ".class";
         URL url = getClass().getResource(myClassFile);
         return new File(url.toURI()).getParentFile();
    }
    
}
