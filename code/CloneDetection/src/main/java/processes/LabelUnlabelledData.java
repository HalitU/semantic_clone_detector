package processes;

import CloneTool.CloneDetection.Settings;
import learning.CloneClassification;

public class LabelUnlabelledData {
	public void DetectClones() throws Exception
	{    	
    	// Example arg input for detecting clones
    	// Runs the classification with an existing model for a project
    	CloneClassification cc = new CloneClassification();
    	cc.ClassifyGivenProject(
    			Settings.savedModelPath, 
    			Settings.savedPredictionPath, 
    			Settings.javaSourcePathForCloneDetection, 
    			Settings.classifierType,
    			Settings.featureType);   
    	   
	}
}
