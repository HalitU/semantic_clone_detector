package extraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	// Get the list of .java files under a directory
	public List<File> GetAllFiles(String directoryName)
	{
		List<File> files = new ArrayList<File>();
		listf(directoryName, files);
		return files;
	}
	
	// Recursively iterate through the directory and get .java extensions
    public void listf(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if(fList != null) {
		    for (File file : fList) {      
		        if (file.isFile() && file.getName().endsWith(".java")) {
		            files.add(file);
		        } else if (file.isDirectory()) {
		            listf(file.getAbsolutePath(), files);
		        }
		    }
    	}
    }	
	
    // This method is not used but tested at some point in order to remove the empty lines and such to improve accuracy for detection
    // But then I noticed that the javaparser already gives accurate line start-end information so no longer needed.
    public void RemoveEmptyLines(String filePath) throws IOException
    {
        File sourceCode = new File(filePath);
        
        String tempFileName = sourceCode.getParentFile().getAbsolutePath() + "\\" + "temp_" + sourceCode.getName();
        
    	FileWriter fw = new FileWriter(tempFileName);
    	
    	FileReader fr = new FileReader(filePath); 
    	BufferedReader br = new BufferedReader(fr);
    	    	
    	String line;

    	while((line = br.readLine()) != null)
    	{ 
    		line = line.replaceAll("\n", "");
    		line.trim();
    		if (!line.isBlank()) {
    			line = line + "\n";
    			fw.write(line, 0, line.length());
    		}
    	}
    	
    	fr.close();
    	fw.close();
    	
    	// Replace the file
    	sourceCode.delete();
    	
    	File newFile = new File(tempFileName);
    	newFile.renameTo(sourceCode);
    }
}
