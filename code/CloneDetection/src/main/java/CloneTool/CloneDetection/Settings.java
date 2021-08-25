package CloneTool.CloneDetection;

import models.ClassifierType;
import models.FeatureType;

public class Settings {
	
	// Classifier type used for labeling data
	public static ClassifierType classifierType = ClassifierType.RandomForest;
	
	// Feature type used to train and test data
	public static FeatureType featureType = FeatureType.ALL_FEATURES; 
	
	// Where the trained model will be saved
	public static String savedModelPath = "D:\\MLModels\\" + classifierType.name() + ".model";
	
	// Where the predictions will be saved
	public static String savedPredictionPath = "D:\\MLModels\\Predictions.txt";
	
	// Location where the code clone detection will be applied
	public static String javaSourcePathForCloneDetection = "D:\\MLModels\\Samples\\dummyTrials";
		
	// Location for the main IJaDataset
	public static String IJaDataSetDirectory = "D:\\PhD\\Courses\\BLG630-RecommendationSystemsinSoftEng\\Project\\clone\\IJaDataset_BCEvalVersion";
	
	// Database settings
	public static final String JDBC_DRIVER = "org.h2.Driver"; 	
	public static final String DB_URL = "jdbc:h2:file:/C:/H2/db/bcb";
	public static final String USER = "sa"; 
	public static final String PASS = "";    
}
