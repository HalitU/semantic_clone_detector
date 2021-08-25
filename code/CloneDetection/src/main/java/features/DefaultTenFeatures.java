package features;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.H2Database;
import models.FeatureVector;
import models.Features;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
/**
 * 
 * Default widely used 10 features given in the referenced paper used for creating prediction models
 * 
 * @author Halit U
 *
 */
public class DefaultTenFeatures implements FeatureBase, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declaring attributes - these are required by weka
	// Source attributes
	final Attribute SourceMethodLength = new Attribute("SourceMethodLength");
	final Attribute SourceAssignmentCount = new Attribute("SourceAssignmentCount");
	final Attribute SourceIfCount = new Attribute("SourceIfCount");
	final Attribute SourceIteratorCount = new Attribute("SourceIteratorCount");
	final Attribute SourceSwitchCount = new Attribute("SourceSwitchCount");
	final Attribute SourceCaseCount = new Attribute("SourceCaseCount");
	final Attribute SourceReturnCount = new Attribute("SourceReturnCount");
	final Attribute SourceTryStatementCount = new Attribute("SourceTryStatementCount");
	final Attribute SourceDeclaredVariableCount = new Attribute("SourceDeclaredVariableCount");
	final Attribute SourceExpressionCount = new Attribute("SourceExpressionCount");
	final Attribute SourceDistinctTypeCount = new Attribute("SourceDistinctTypeCount");

    
    // Target attributes
	final Attribute TargetMethodLength = new Attribute("TargetMethodLength");
	final Attribute TargetAssignmentCount = new Attribute("TargetAssignmentCount");
	final Attribute TargetIfCount = new Attribute("TargetIfCount");
	final Attribute TargetIteratorCount = new Attribute("TargetIteratorCount");
	final Attribute TargetSwitchCount = new Attribute("TargetSwitchCount");
	final Attribute TargetCaseCount = new Attribute("TargetCaseCount");
	final Attribute TargetReturnCount = new Attribute("TargetReturnCount");
	final Attribute TargetTryStatementCount = new Attribute("TargetTryStatementCount");
	final Attribute TargetDeclaredVariableCount = new Attribute("TargetDeclaredVariableCount");
	final Attribute TargetExpressionCount = new Attribute("TargetExpressionCount");
	final Attribute TargetDistinctTypeCount = new Attribute("TargetDistinctTypeCount");

    
    // All clone types
    final List<String> classes = new ArrayList<String>() {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("TYPE1");
			add("TYPE2");
			add("VST3");
			add("ST3");
			add("MT3");
			add("WT3");
    		add("nonmatch");
    	}
    };
	
    // Creating a list of attributes
    ArrayList<Attribute> attributeList = new ArrayList<Attribute>(2) {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			// Source
    		add(SourceMethodLength);
    		add(SourceAssignmentCount);
    		add(SourceIfCount);
    		add(SourceIteratorCount);
    		add(SourceSwitchCount);
    		add(SourceCaseCount);
    		add(SourceReturnCount);
    		add(SourceTryStatementCount);
    		add(SourceDeclaredVariableCount);
    		add(SourceExpressionCount);
    		add(SourceDistinctTypeCount);
    		
    		// Target
    		add(TargetMethodLength);
    		add(TargetAssignmentCount);
    		add(TargetIfCount);
    		add(TargetIteratorCount);
    		add(TargetSwitchCount);
    		add(TargetCaseCount);
    		add(TargetReturnCount);
    		add(TargetTryStatementCount);
    		add(TargetDeclaredVariableCount);
    		add(TargetExpressionCount);
    		add(TargetDistinctTypeCount);    		
    		
    		// Class
    		Attribute attributeClass = new Attribute("@@class@@", classes);
    		add(attributeClass);
    	}
    };	
	
   
    /**
     * Loads the feature vector in the database
     * Refer to SQL operations for how to create the tables in h2
     */
	public Instances LoadFeatureVector()
	{
	    // Prepare the instance
	    Instances featureVector = new Instances("Feature Vector", attributeList, 1);
	    featureVector.setClassIndex(featureVector.numAttributes() - 1);
	
	    // Read feature vector from db
		try {
			H2Database h2 = new H2Database();
			Connection conn = h2.Connect();
			Statement stmt = conn.createStatement();
			String sql = "SELECT "
					+ "SOURCE_METHOD_LENGTH,"
					+ "SOURCE_ASSIGNMENT_COUNT,"
					+ "SOURCE_IF_COUNT,"
					+ "SOURCE_ITERATOR_COUNT,"
					+ "SOURCE_SWITCH_COUNT,"
					+ "SOURCE_CASE_COUNT,"
					+ "SOURCE_RETURN_COUNT,"
					+ "SOURCE_TRY_STATEMENT_COUNT,"
					+ "SOURCE_DECLARED_VARIABLE_COUNT,"
					+ "SOURCE_EXPRESSION_COUNT,"
					+ "SOURCE_DISTINCT_TYPE_COUNT,"
					+ "TARGET_METHOD_LENGTH,"
					+ "TARGET_ASSIGNMENT_COUNT,"
					+ "TARGET_IF_COUNT,"
					+ "TARGET_ITERATOR_COUNT,"
					+ "TARGET_SWITCH_COUNT,"
					+ "TARGET_CASE_COUNT,"
					+ "TARGET_RETURN_COUNT,"
					+ "TARGET_TRY_STATEMENT_COUNT,"
					+ "TARGET_DECLARED_VARIABLE_COUNT,"
					+ "TARGET_EXPRESSION_COUNT,"
					+ "TARGET_DISTINCT_TYPE_COUNT,"                    
					+ "CLONE"
					+ " FROM FEATURE_VECTOR";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			    // Create a new instance
			    DenseInstance newCloneInstance = new DenseInstance(featureVector.numAttributes()) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					{						
						// Source
			    		setValue(SourceMethodLength, rs.getInt("SOURCE_METHOD_LENGTH"));
			    		setValue(SourceAssignmentCount, rs.getInt("SOURCE_ASSIGNMENT_COUNT"));
			    		setValue(SourceIfCount, rs.getInt("SOURCE_IF_COUNT"));
			    		setValue(SourceIteratorCount, rs.getInt("SOURCE_ITERATOR_COUNT"));
			    		setValue(SourceSwitchCount, rs.getInt("SOURCE_SWITCH_COUNT"));
			    		setValue(SourceCaseCount, rs.getInt("SOURCE_CASE_COUNT"));
			    		setValue(SourceReturnCount, rs.getInt("SOURCE_RETURN_COUNT"));
			    		setValue(SourceTryStatementCount, rs.getInt("SOURCE_TRY_STATEMENT_COUNT"));
			    		setValue(SourceDeclaredVariableCount, rs.getInt("SOURCE_DECLARED_VARIABLE_COUNT"));
			    		setValue(SourceExpressionCount, rs.getInt("SOURCE_EXPRESSION_COUNT"));
			    		setValue(SourceDistinctTypeCount, rs.getInt("SOURCE_DISTINCT_TYPE_COUNT"));
			    		
			    		// Target
			    		setValue(TargetMethodLength, rs.getInt("TARGET_METHOD_LENGTH"));
			    		setValue(TargetAssignmentCount, rs.getInt("TARGET_ASSIGNMENT_COUNT"));
			    		setValue(TargetIfCount, rs.getInt("TARGET_IF_COUNT"));
			    		setValue(TargetIteratorCount, rs.getInt("TARGET_ITERATOR_COUNT"));
			    		setValue(TargetSwitchCount, rs.getInt("TARGET_SWITCH_COUNT"));
			    		setValue(TargetCaseCount, rs.getInt("TARGET_CASE_COUNT"));
			    		setValue(TargetReturnCount, rs.getInt("TARGET_RETURN_COUNT"));
			    		setValue(TargetTryStatementCount, rs.getInt("TARGET_TRY_STATEMENT_COUNT"));
			    		setValue(TargetDeclaredVariableCount, rs.getInt("TARGET_DECLARED_VARIABLE_COUNT"));
			    		setValue(TargetExpressionCount, rs.getInt("TARGET_EXPRESSION_COUNT"));
			    		setValue(TargetDistinctTypeCount, rs.getInt("TARGET_DISTINCT_TYPE_COUNT"));			    		
			    	}
			    };

			    // Reference instances data set to instance for field references
			    newCloneInstance.setDataset(featureVector);			
			    newCloneInstance.setClassValue(rs.getString("CLONE"));		    
			    featureVector.add(newCloneInstance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			    
		return featureVector;
	}
	/**
	 * Creates a feature vector from features
	 */
	public FeatureVector GetFeatureVectorFromCodes(Features sourceData, Features targetData)
	{
		FeatureVector vector = new FeatureVector();
		
		// Source
		vector.SourceMethodLength = sourceData.MethodLength;
		vector.SourceAssignmentCount = sourceData.AssignmentCount;
		vector.SourceIfCount = sourceData.IfCount;
		vector.SourceIteratorCount = sourceData.IteratorCount;
		vector.SourceSwitchCount = sourceData.SwitchCount;
		vector.SourceCaseCount = sourceData.CaseCount;
		vector.SourceReturnCount = sourceData.ReturnCount;
		vector.SourceTryStatementCount = sourceData.TryStatementCount;
		vector.SourceDeclaredVariableCount = sourceData.DeclaredVariableCount;
		vector.SourceExpressionCount = sourceData.ExpressionCount;
		vector.SourceDistinctTypeCount = sourceData.DistinctTypeCount;
		
		// Target
		vector.TargetMethodLength = targetData.MethodLength;
		vector.TargetAssignmentCount = targetData.AssignmentCount;
		vector.TargetIfCount = targetData.IfCount;
		vector.TargetIteratorCount = targetData.IteratorCount;
		vector.TargetSwitchCount = targetData.SwitchCount;
		vector.TargetCaseCount = targetData.CaseCount;
		vector.TargetReturnCount = targetData.ReturnCount;
		vector.TargetTryStatementCount = targetData.TryStatementCount;
		vector.TargetDeclaredVariableCount = targetData.DeclaredVariableCount;
		vector.TargetExpressionCount = targetData.ExpressionCount;
		vector.TargetDistinctTypeCount = targetData.DistinctTypeCount;		
				
		return vector;
	}
	public List<String> GetClasses()
	{
		return classes;
	}
	public Instances GetInstancesFromAttributes()
	{
	    // Prepare the instance
	    Instances featureVector = new Instances("Feature Vector", attributeList, 1);
	    featureVector.setClassIndex(featureVector.numAttributes() - 1);
	    return featureVector;
	}
	/**
	 * Returns an instance from feature vector and the provided vector instances attributes 
	 */
	public Instance GetInstanceFromFeature(FeatureVector f, Instances featureVector) throws Exception
	{
	    DenseInstance newCloneInstance = new DenseInstance(featureVector.numAttributes()) {
	    	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				// Source
				setValue(SourceMethodLength, f.SourceMethodLength);
				setValue(SourceAssignmentCount, f.SourceAssignmentCount);
				setValue(SourceIfCount, f.SourceIfCount);
				setValue(SourceIteratorCount, f.SourceIteratorCount);
				setValue(SourceSwitchCount, f.SourceSwitchCount);
				setValue(SourceCaseCount, f.SourceCaseCount);
				setValue(SourceReturnCount, f.SourceReturnCount);
				setValue(SourceTryStatementCount, f.SourceTryStatementCount);
				setValue(SourceDeclaredVariableCount, f.SourceDeclaredVariableCount);
				setValue(SourceExpressionCount, f.SourceExpressionCount);
				setValue(SourceDistinctTypeCount, f.SourceDistinctTypeCount);
				
				// Target
				setValue(TargetMethodLength, f.TargetMethodLength);
				setValue(TargetAssignmentCount, f.TargetAssignmentCount);
				setValue(TargetIfCount, f.TargetIfCount);
				setValue(TargetIteratorCount, f.TargetIteratorCount);
				setValue(TargetSwitchCount, f.TargetSwitchCount);
				setValue(TargetCaseCount, f.TargetCaseCount);
				setValue(TargetReturnCount, f.TargetReturnCount);
				setValue(TargetTryStatementCount, f.TargetTryStatementCount);
				setValue(TargetDeclaredVariableCount, f.TargetDeclaredVariableCount);
				setValue(TargetExpressionCount, f.TargetExpressionCount);
				setValue(TargetDistinctTypeCount, f.TargetDistinctTypeCount);				
	    	}
	    };
		
	    newCloneInstance.setDataset(featureVector);

        // Return the single instance
		return newCloneInstance;
	}	
}
