package processes;

import learning.CloneClassification;
import models.ClassifierType;
import models.FeatureType;

public class CommandLineTrigger {
	public void CommandLineExecution(String[] args) throws Exception
	{
    	ClassifierType clsType = ClassifierType.J48;
    	FeatureType ftType = FeatureType.DEFAULT_TEN_FEATURES;
    	
    	// will be used in jar output
    	String pathToFindModel = args[0];
    	String pathToOutput = args[1];
    	String pathToFindClones = args[2];

    	// label the data and output results into a file.
    	CloneClassification cc = new CloneClassification();
    	cc.ClassifyGivenProject(pathToFindModel, pathToOutput, pathToFindClones, clsType, ftType);		
	}
}
