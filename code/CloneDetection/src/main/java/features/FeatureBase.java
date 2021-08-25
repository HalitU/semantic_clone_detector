package features;

import java.util.List;

import models.FeatureVector;
import models.Features;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * All features have to have this abilities.
 * 
 * @author Halit U
 *
 */
public interface FeatureBase {
	Instances LoadFeatureVector();
	List<String> GetClasses();
	Instances GetInstancesFromAttributes();
	FeatureVector GetFeatureVectorFromCodes(Features sourceData, Features targetData);
	Instance GetInstanceFromFeature(FeatureVector f, Instances featureVector) throws Exception;
}
