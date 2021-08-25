package CloneTool.CloneDetection;

import processes.CommandLineTrigger;
import processes.FeaturesToDatabase;
import processes.LabelUnlabelledData;
import processes.MultipleModelTraining;

/**
 * Clone detector tool - also model trainer
 * It is a maven project.
 */
public class App
{
	/**
	 * Entry point for the application
	 * 
	 * Refer to "README & GUIDELINES" file in order to see which method does what and their requirements 
	 */
    public static void main( String[] args ) throws Exception
    {
    	/**
    	 * 
    	 * This is an example for doing multiple classifications one after another
    	 * Useful for me because results are saved and I can just run and wait for all experiments to finish.
    	 * Do note that the CPU usage is high.
    	 * 
    	 */
    	MultipleModelTraining mmt = new MultipleModelTraining();
    	mmt.TrainAllModels();
    	
    	
    	/**
    	 * Labeling unlabeled data example 
    	 * Requires an already trained model
    	 */
    	// LabelUnlabelledData lud = new LabelUnlabelledData();
    	// lud.DetectClones();    	
    	
    	/**
    	 * Processing data into database example
    	 * Need to trigger this once every time the feature vector model changes otherwise DONT trigger it
    	 * Gives error in case database already has the corresponding table or there is no connection
    	 * Also there are duplicate .java files in the IJaDataset these are printed as unique key warnings but can be ignored
    	 * I have already provided the necessary datasets so this method does not have to be used.
    	 */
    	// FeaturesToDatabase ftd = new FeaturesToDatabase();
    	// ftd.ProcessData(false, true);
    	
    	
    	/**
    	 * Turning tool into a format usable by users from command line
    	 * This section is used when converting program into .jar file
    	 */
    	// CommandLineTrigger clt = new CommandLineTrigger();
    	// clt.CommandLineExecution(args);
    	 	
    }
    
}
