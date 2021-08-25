package models;

/**
 * 
 * These are most of the classifiers which can be used to train a model using weka
 * Application uses a switch case in order to get the model user requires.
 * Classifiers extends the same class therefore it is possible to cast them as well.
 * 
 * @author Halit U
 *
 */

public enum ClassifierType {
	NAIVE_BAYES,
	SVM,
	J48,
	LinearRegression,
	SimpleLogistic,
	RandomForest,
	RunBayesNet,
	RunIBK,
	RunMultilayerPerceptron,
	RunKStar,
	RunBagging,
	RunLogitBoost,
	RunRandomTree,
	RandomCommittee,
	RotationBoost
}
