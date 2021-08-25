package processes;

import java.io.File;
import java.io.IOException;
import java.util.List;

import CloneTool.CloneDetection.Settings;
import database.H2Database;
import extraction.ASTUtils;
import extraction.FileUtils;
import models.Features;

public class FeaturesToDatabase {
    /**
     * This function needs to be called only once in order to write all method features from
     * IJaDataset to h2 database.
     * 
     * @param directory
     * @param printOutput
     * @param writeToTable
     * @throws IOException
     */
    public void ProcessData(boolean printOutput, boolean writeToTable) throws IOException
    {
    	// Directory
    	FileUtils fu = new FileUtils();
    	List<File> files = fu.GetAllFiles(Settings.IJaDataSetDirectory);
    	    	
    	System.out.println("Number of java source code files to collect features from: " + files.size());
    	
    	// Initialize database tables if not exists
    	H2Database h2db = new H2Database();
    	h2db.Connect();
    	h2db.CreateFeatureTables();
    	
    	// Read the files and write features to db
    	ASTUtils featureUtil = new ASTUtils();
    	for (File file : files) {
    		String path = file.toURI().getPath(); 
        	List<Features> fs = featureUtil.FetchFeatures(path, printOutput);
        	if (fs != null && writeToTable)
        		h2db.WriteFeatureToTable(fs);	
		}    	
    }
}
