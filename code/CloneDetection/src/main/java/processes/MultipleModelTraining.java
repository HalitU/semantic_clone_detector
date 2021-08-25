package processes;

import java.util.ArrayList;
import java.util.List;

import learning.CloneClassification;
import models.ClassifierType;
import models.FeatureType;
import models.SplitType;

public class MultipleModelTraining {
	public void TrainAllModels() throws Exception
	{
    	List<ClassifierType> clsList = new ArrayList<ClassifierType>();
    	clsList.add(ClassifierType.RandomCommittee);
    	clsList.add(ClassifierType.RandomForest);
    	clsList.add(ClassifierType.J48);
    	
    	List<FeatureType> ftList = new ArrayList<FeatureType>();
    	ftList.add(FeatureType.DEFAULT_TEN_FEATURES);
    	ftList.add(FeatureType.ALL_FEATURES);
    	
    	List<SplitType> spType = new ArrayList<SplitType>();
    	spType.add(SplitType.EQUAL);
    	spType.add(SplitType.REAL);
    	
    	for (ClassifierType cls : clsList) {
			for (FeatureType ft : ftList) {
				for (SplitType sp : spType) {
			    	CloneClassification c = new CloneClassification();
			    	c.Classify(cls, ft, sp);  					
				}
			}
		}		
	}
}
