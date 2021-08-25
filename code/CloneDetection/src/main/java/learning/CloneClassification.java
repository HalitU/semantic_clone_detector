package learning;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import extraction.ASTUtils;
import extraction.FileUtils;
import features.AllFeatures;
import features.DefaultTenFeatures;
import features.FeatureBase;
import models.ClassifierType;
import models.FeatureType;
import models.FeatureVector;
import models.Features;
import models.SplitType;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.functions.SimpleLogistic;
import weka.classifiers.lazy.IBk;
import weka.classifiers.lazy.KStar;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.meta.Bagging;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.meta.LogitBoost;
import weka.classifiers.meta.RandomCommittee;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.trees.RandomTree;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSink;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.Standardize;

/**
 * 
 * Training and classification is done in this class.
 * 
 * @author Halit U
 *
 */
public class CloneClassification {
	/*
	 * Classifier should take in account only methods with 6 lines and higher methods
	 * This is the minimum requirement for benchmarks, otherwise too small methods complicate the process
	 * and might find too many clones
	 */
	public void Classify(ClassifierType classifierType, FeatureType featureType, SplitType splitType) throws Exception
	{
		/**
		 * 
		 * There exists two ways for getting the train-test data
		 * First one is to fetch it from database
		 * Second one is to use the saved dataset from previous runs using .arff file.
		 * In order to shorten run times I run the models one generated the datasets saved them then used them
		 * unless the model is changed.
		 * However I am leaving the codes for both of these choices here for reference.
		 * 
		 */
		
		/**
		 * 
		 * First option is to fetch it from database
		 * It is commented because I was using the second option further down in the end which uses the saved .arff file
		 * datasets.
		 * Fetching from database every single time is not a good idea because feature vector is huge.
		 * 
		 */
		List<Instances> instanceList = new ArrayList<Instances>();
		instanceList = PrepareTrainTestManually(classifierType, featureType, splitType);
		Instances trainData = instanceList.get(0);
		Instances testData = instanceList.get(1);
		
		/**
		 * Using the datasets saved in the computer in .arff format
		 */
		/*
		String trainPath = "D:\\MLModels\\" + featureType.name() + "_" + splitType.name() + "_" + "train" + ".arff";
		DataSource trainSource = new DataSource(trainPath);
		Instances trainData = trainSource.getDataSet();
		if (trainData.classIndex() == -1)
			trainData.setClassIndex(trainData.numAttributes() - 1);
		
		String testPath = "D:\\MLModels\\" + featureType.name() + "_" + splitType.name() + "_" + "test" + ".arff";
		DataSource testSource = new DataSource(testPath);
		Instances testData = testSource.getDataSet();
		if (testData.classIndex() == -1)
			testData.setClassIndex(testData.numAttributes() - 1);		
		*/
		
		/**
		 * Sample code for saving the generated instances dataset for train and test sets. 
		 */
		// SaveTrainTestSet(featureType, splitType, trainData, testData);
		
		// Print distributions on console for debugging
		CheckTPFPDistribution(trainData, "Train dataset");
		CheckTPFPDistribution(testData, "Test dataset");
				
		// Trigger the classification
		RunClassificationModel(classifierType, trainData, testData, featureType, splitType);
	}
	private void SaveTrainTestSet(FeatureType featureType, SplitType splitType, Instances trainData, Instances testData) throws IOException
	{
		// Save data for further usage
		ArffSaver trainsaver = new ArffSaver();
		trainsaver.setInstances(trainData);
		trainsaver.setFile(new File("D:\\MLModels\\" + featureType.name() + "_" + splitType.name() + "_" + "train" + ".arff"));
		trainsaver.writeBatch();
		
		ArffSaver testsaver = new ArffSaver();
		testsaver.setInstances(testData);
		testsaver.setFile(new File("D:\\MLModels\\" + featureType.name() + "_" + splitType.name() + "_" + "test" + ".arff"));
		testsaver.writeBatch();		
	}
	
	private List<Instances> PrepareTrainTestManually(ClassifierType classifierType, FeatureType featureType, SplitType splitType)
	{
		List<Instances> instanceList = new ArrayList<Instances>();
		
		Instances data;
		
		// Fetch the requested features
		switch (featureType) {
			case DEFAULT_TEN_FEATURES:
				DefaultTenFeatures dtf = new DefaultTenFeatures();
				data = dtf.LoadFeatureVector();
				break;
			case ALL_FEATURES:
				AllFeatures af = new AllFeatures();
				data = af.LoadFeatureVector();
				break;
			default:
				System.out.println("Something must have gone wrong...");
				DefaultTenFeatures dtfBackup = new DefaultTenFeatures();
				data = dtfBackup.LoadFeatureVector();
				break;
		}		

		// Randomize the dataset
        Random rand = new Random(); 
        int seed = rand.nextInt(1337);
		data.randomize(new java.util.Random(seed));
				
		// Split dataset into 80 - 20 percent or 80 - real ratio
		// Types
		double TYPE1 = data.classAttribute().indexOfValue("TYPE1");		
		double TYPE2 = data.classAttribute().indexOfValue("TYPE2");		
		double VST3 = data.classAttribute().indexOfValue("VST3");				
		double ST3 = data.classAttribute().indexOfValue("ST3");		
		double MT3 = data.classAttribute().indexOfValue("MT3");	
		double WT3 = data.classAttribute().indexOfValue("WT3");
		double nonmatch = data.classAttribute().indexOfValue("nonmatch");		
		
		// Counts -- default should be 3360 - -1
		int TYPE1_Count = 0;		
		int TYPE2_Count = 0;		
		int VST3_Count = 0;				
		int ST3_Count = 0;		
		int MT3_Count = 0;	
		int WT3_Count = 0;
		int nonmatch_Count = 0;	
		int upperTrainLimit = 3360;
		
		int TYPE1_test = 0;		
		int TYPE2_test = 0;		
		int VST3_test = 0;				
		int ST3_test = 0;		
		int MT3_test = 0;	
		int WT3_test = 0;
		int nonmatch_test = 0;
		
		int upperTestLimit = -1;
		
		// If it is equal all test cases will have 840 pairs
		// Otherwise they will have all the pairs therefore creating the real-ratio distribution
		if (splitType == SplitType.EQUAL)
			upperTestLimit = 840;
		else
			upperTestLimit = -1;
		
		// 
		Instances trainData = new Instances(data, 0);
		Instances testData = new Instances(data, 0);
		
		// Manually distributing the randomized clone types
		// This is written so that I can play with the numbers easily during debugging
		for (Instance ins : data) {
			if (ins.classValue() == TYPE1 && TYPE1_Count < upperTrainLimit) {
				trainData.add(ins);
				TYPE1_Count++;	
			}			
			if (ins.classValue() == TYPE2 && TYPE2_Count < upperTrainLimit) {
				trainData.add(ins);
				TYPE2_Count++;
			}
			if (ins.classValue() == VST3 && VST3_Count < upperTrainLimit) {
				trainData.add(ins);
				VST3_Count++;
			}
			if (ins.classValue() == ST3 && ST3_Count < upperTrainLimit) {
				trainData.add(ins);
				ST3_Count++;
			}
			if (ins.classValue() == MT3 && MT3_Count < upperTrainLimit) {
				trainData.add(ins);
				MT3_Count++;
			}
			if (ins.classValue() == WT3 && WT3_Count < upperTrainLimit) {
				trainData.add(ins);
				WT3_Count++;
			}
			if (ins.classValue() == nonmatch && nonmatch_Count < upperTrainLimit) {
				trainData.add(ins);
				nonmatch_Count++;
			}
			// Test data
			if (ins.classValue() == TYPE1 && (TYPE1_test < upperTestLimit || upperTestLimit == -1) && TYPE1_Count >= upperTrainLimit) {
				testData.add(ins);
				TYPE1_test++;
			}
			if (ins.classValue() == TYPE2 && (TYPE2_test < upperTestLimit || upperTestLimit == -1) && TYPE2_Count >= upperTrainLimit) {
				testData.add(ins);
				TYPE2_test++;
			}
			if (ins.classValue() == VST3 && (VST3_test < upperTestLimit || upperTestLimit == -1) && VST3_Count >= upperTrainLimit) {
				testData.add(ins);
				VST3_test++;
			}
			if (ins.classValue() == ST3 && (ST3_test < upperTestLimit || upperTestLimit == -1) && ST3_Count >= upperTrainLimit) {
				testData.add(ins);
				ST3_test++;
			}
			if (ins.classValue() == MT3 && (MT3_test < upperTestLimit || upperTestLimit == -1) && MT3_Count >= upperTrainLimit) {
				testData.add(ins);
				MT3_test++;
			}
			if (ins.classValue() == WT3 && (WT3_test < upperTestLimit || upperTestLimit == -1) && WT3_Count >= upperTrainLimit) {
				testData.add(ins);
				WT3_test++;
			}
			if (ins.classValue() == nonmatch && (nonmatch_test < upperTestLimit || upperTestLimit == -1) && nonmatch_Count >= upperTrainLimit) {
				testData.add(ins);
				nonmatch_test++;
			}
		}		
		instanceList.add(trainData);
		instanceList.add(testData);
		
		return instanceList;
	}
	
	/**
	 * Prints the clone distribution for the given instance on console
	 * Useful for debugging
	 * 
	 * @param data
	 * @param name
	 */
	private void CheckTPFPDistribution(Instances data, String name)
	{
		System.out.println("---------------------");
		System.out.println("Data is checked for: " + name);
		System.out.println("Data size: " + data.size());
		System.out.println("Number of classes: " + data.numClasses());

		double TYPE1 = data.classAttribute().indexOfValue("TYPE1");	
		double TYPE2 = data.classAttribute().indexOfValue("TYPE2");	
		double VST3 = data.classAttribute().indexOfValue("VST3");				
		double ST3 = data.classAttribute().indexOfValue("ST3");		
		double MT3 = data.classAttribute().indexOfValue("MT3");	
		double WT3 = data.classAttribute().indexOfValue("WT3");
		double nonmatch = data.classAttribute().indexOfValue("nonmatch");

		System.out.println("TYPE1 index: " + TYPE1);
		System.out.println("TYPE2 index: " + TYPE2);
		System.out.println("VST3 index: " + VST3);
		System.out.println("ST3 index: " + ST3);
		System.out.println("MT3 index: " + MT3);
		System.out.println("WT3 index: " + WT3);
		System.out.println("nonmatch index: " + nonmatch);

		int TYPE1_Count = 0;
		int TYPE2_Count = 0;
		int VST3_Count = 0;
		int ST3_Count = 0;
		int MT3_Count = 0;
		int WT3_Count = 0;
		int nonmatch_Count = 0;		
				
		for (Instance instance : data) {
			double classVal = instance.classValue();
			if (classVal == TYPE1)
				TYPE1_Count++;
			if (classVal == TYPE2)
				TYPE2_Count++;
			if (classVal == VST3)
				VST3_Count++;
			if (classVal == ST3)
				ST3_Count++;
			if (classVal == MT3)
				MT3_Count++;
			if (classVal == WT3)
				WT3_Count++;
			if (classVal == nonmatch)
				nonmatch_Count++;
		}
		System.out.println("TYPE1: " + TYPE1_Count + " TYPE2: " + TYPE2_Count + " VST3: " + VST3_Count + " ST3: " + ST3_Count + " MT3: " + MT3_Count + " WT3: " + WT3_Count + " nonmatch: " + nonmatch_Count);
	}


	/**
	 * 
	 * Runs the classification model using the preferences.
	 * 
	 * @param clsType
	 * @param trainData
	 * @param testData
	 * @param featureType
	 * @param splitType
	 * @throws Exception
	 */
	private void RunClassificationModel(ClassifierType clsType, Instances trainData, Instances testData, FeatureType featureType, SplitType splitType) throws Exception
	{
		
		// Normalize filter
		// Normalization does not affect the results significantly as mentioned in the study/presentation
		// However since it is used, code is here for reference
		Normalize normFilter = new Normalize();
		normFilter.setInputFormat(trainData);
			
		// Attribute selection filter is disabled because it reduces the performance for some cases
		// Code is here for reference
		/*
		// Attribute selection filter
		AttributeSelectedClassifier classifier = new AttributeSelectedClassifier();
		CfsSubsetEval eval = new CfsSubsetEval();
		GreedyStepwise search = new GreedyStepwise();
		search.setSearchBackwards(true);
		*/
				
		// Main classifier
		Classifier cls;
		
		switch (clsType) {
			case J48:
				cls = new J48();
				((J48) cls).setUnpruned(true);
				break;
			case NAIVE_BAYES:
				cls = new NaiveBayes();
				break;
			case SVM:
				cls = new LibSVM();
				break;
			case LinearRegression:
				cls = new LinearRegression();
				break;
			case RandomForest:
				cls = new RandomForest();
				break;
			case SimpleLogistic:
				cls = new SimpleLogistic();
				break;
			case RunBayesNet:
				cls = new BayesNet();
				break;
			case RunIBK:
				cls = new IBk();
				break;
			case RunMultilayerPerceptron:
				cls = new MultilayerPerceptron();
				break;
			case RunKStar:
				cls = new KStar();
				break;
			case RunBagging:
				cls = new Bagging();
				break;
			case RunLogitBoost:
				cls = new LogitBoost();
				break;
			case RunRandomTree:
				cls = new RandomTree();
				break;
			case RandomCommittee:
				cls = new RandomCommittee();
				break;
			case RotationBoost:
				cls = new AdaBoostM1();
				break;
			default:
				cls = new J48();
				break;
		}			
		
		// Again disabled because it uses the attribute selected classifier
		/*
		classifier.setClassifier(cls);
		classifier.setEvaluator(eval);
		classifier.setSearch(search);
		*/
		
		// Filtered classifier is required to save the filter for the model as well
		// Basically all of the operations applied during the classification process is saved
		// Such as pre-processing as well. Therefore these operations are applied for the test data. 
		FilteredClassifier filteredCls = new FilteredClassifier();
		filteredCls.setFilter(normFilter);
		filteredCls.setClassifier(cls);		

		// 10-Fold cross validation evaluation
		Evaluation crossVal = new Evaluation(trainData);
		crossVal.crossValidateModel(filteredCls, trainData, 10, new Random(1));
		
		System.out.println(filteredCls);
		System.out.println(crossVal.toSummaryString());
		System.out.println(crossVal.toMatrixString());
		System.out.println(crossVal.toClassDetailsString());
		
		System.out.println("-------------------------");
		
		// Build and save the model
		filteredCls.buildClassifier(trainData);
		SaveClassifier(filteredCls, clsType);			
		
		System.out.println("classifier built, continuing with test evaluation");
		
		// Load saved model
		// I am using save-load here instead of using the model directly
		// Because the model will be used for the clone detection tool user interface
		String path = "/MLModels/" + clsType.toString() + ".model";
		FilteredClassifier loadedClassifier = (FilteredClassifier) weka.core.SerializationHelper.read(path);

		// Test split evaluation
		Evaluation testEval = new Evaluation(testData);
		testEval.evaluateModel(loadedClassifier, testData);
		
		System.out.println(testEval.toSummaryString());
		System.out.println(testEval.toMatrixString());
		System.out.println(testEval.toClassDetailsString());	
		
		// Writing results to file for not losing them
		String resultPath = "D:\\PhD\\Courses\\BLG630-RecommendationSystemsinSoftEng\\Project\\experments\\" 
				+ clsType.name() + "_" + featureType.name() + "_" + splitType.name() + ".txt"; 
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultPath));

        writer.write(crossVal.toSummaryString());
        writer.write(crossVal.toMatrixString());
        writer.write(crossVal.toClassDetailsString());
        writer.write("-----------------------------\n");
        writer.write(testEval.toSummaryString());
        writer.write(testEval.toMatrixString());
        writer.write(testEval.toClassDetailsString());
        writer.write("-----------------------------\n");
        writer.write("Done.");
        
        writer.flush();
        writer.close();
	}
	
	// Saves the trained model
	private void SaveClassifier(Classifier cls, ClassifierType clsType) throws Exception
	{
		String path = "/MLModels/" + clsType.toString() + ".model";
		weka.core.SerializationHelper.write(path, cls);		
	}

	/**
	 * 
	 * Classifies the directory given by user to classify UNLABELLED data.
	 * 
	 * @param pathToModel
	 * @param pathToOutput
	 * @param pathToFindClones
	 * @param classifierType
	 * @param featureType
	 * @throws Exception
	 */
	public void ClassifyGivenProject(String pathToModel, String pathToOutput, String pathToFindClones, ClassifierType classifierType, FeatureType featureType) throws Exception
	{
		// Get all .java files under that directory
		FileUtils fu = new FileUtils();
		List<File> files = fu.GetAllFiles(pathToFindClones);
		
		int totalNumberOfMethods = 0;
		
		// Get their features
    	ASTUtils featureUtil = new ASTUtils();
    	List<Features> features = new ArrayList<Features>();
    	for (File file : files) {
    		String filePath = file.toURI().getPath(); 
        	List<Features> fs = featureUtil.FetchFeatures(filePath, false);
        	if (fs != null && fs.size() != 0) {
        		for (Features fileFeatures : fs) {
        			totalNumberOfMethods++;
        			if ((fileFeatures.LineEnd - fileFeatures.LineBegin) > 5)
						features.add(fileFeatures);
				}
        	}
		} 		
    	System.out.println("Total number of methods: " + totalNumberOfMethods);
    	System.out.println("Total number of valid methods(line > 5): " + features.size());
    	
    	// Run the classification model
    	RunSavedModel(pathToModel, pathToOutput, features, classifierType, featureType);
	}
		
	/**
	 * 
	 * Runs the saved model in order to classify UNLABELLED data
	 * 
	 * @param pathToModel
	 * @param pathToOutput
	 * @param testData
	 * @param classifierType
	 * @param featureType
	 * @throws Exception
	 */
	public void RunSavedModel(String pathToModel, String pathToOutput, List<Features> testData, ClassifierType classifierType, FeatureType featureType) throws Exception
	{
		// Fetch the saved model
		FileWriter myWriter = new FileWriter(pathToOutput);
		FileWriter benchmarkformat = new FileWriter("/MLModels/BenchMarkPredictions.csv");
		
		int classificationCount = 0;
		int cloneCount = 0;
		FilteredClassifier cls = (FilteredClassifier) weka.core.SerializationHelper.read(pathToModel);
		
		// Fetch the feature class
		FeatureBase dtf;
		
		switch (featureType) {
			case DEFAULT_TEN_FEATURES:
				dtf = new DefaultTenFeatures();
				break;
			case ALL_FEATURES:
				dtf = new AllFeatures();
				break;
			default:
				System.out.println("Some type must be wrong...");
				dtf = new DefaultTenFeatures();
				break;
		}
		
		// Get the clone types as classes
		List<String> classes = dtf.GetClasses();			
		int[] classDistribution = new int[classes.size()];
		
		System.out.println("Number of methods in the data for testing: " + testData.size());
		
		/*
		 * Iterate through entire methods and match them one by one with one another.
		 * If any clone is detected write it to a result file.
		 */
		for (int i = 0; i < testData.size(); i++) {
			
			for (int j = i + 1; j < testData.size(); j++) {
				// Get the instances
				Instances featureVector = dtf.GetInstancesFromAttributes();	
				
				// Get source and target code features
				Features sourceData = testData.get(i);
				Features targetData = testData.get(j);
				
				// Get the vector
				FeatureVector vector = dtf.GetFeatureVectorFromCodes(sourceData, targetData);
				
				
				// Get current instance
				Instance currentInstance = dtf.GetInstanceFromFeature(vector, featureVector);
				
				featureVector.add(currentInstance);
								
				// Make prediction				
	            double prediction = cls.classifyInstance(currentInstance);
	            double[] probabilities = cls.distributionForInstance(currentInstance);
	            double highestProb = 0.0;
	            for (double d : probabilities) {
					if (d > highestProb)
						highestProb = d;
				}
	            	            
	            classDistribution[(int)prediction]++;
	            
	            
	            // There exists a clone (not considering the type), 6 is non-match
				if (prediction != 6) {
					String sourceResult = sourceData.FullPath + ";" + sourceData.Filename + ";" + sourceData.LineBegin + ";" + sourceData.LineEnd + ";";
					String targetResult = targetData.FullPath + ";" + targetData.Filename + ";" + targetData.LineBegin + ";" + targetData.LineEnd + ";";
					String endofLine = ((probabilities[(int)prediction] * 100) / 100.0) + ";" + classes.get((int)prediction) + "\n";
					myWriter.write(sourceResult + targetResult + endofLine);
					cloneCount++;
					
					// For benchmark control
					String benchmarkSourceResult = sourceData.Directory + "," + sourceData.Filename + "," + sourceData.LineBegin + "," + sourceData.LineEnd + ",";
					String benchmarkTargetResult = targetData.Directory + "," + targetData.Filename + "," + targetData.LineBegin + "," + targetData.LineEnd + "\n";
					benchmarkformat.write(benchmarkSourceResult + benchmarkTargetResult);
				}				
				classificationCount++;
			}
		}
		
		myWriter.close();
		benchmarkformat.close();
		System.out.println("Done with classification: " + classificationCount);
		for (int i = 0; i < classDistribution.length; i++) {
			System.out.println("Number of class found for: " +  classes.get(i) +  " " + classDistribution[i]);
		}
		System.out.println("Clone count: " + cloneCount);
	}
		
}

