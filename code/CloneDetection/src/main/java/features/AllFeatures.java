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
 * All features generated in the study.
 * PLEASE REFER TO THE DefaultTenFeatures.java because this class is too long to read because of the requirements by weka.
 * 
 * @author Halit U
 *
 */
public class AllFeatures implements FeatureBase, Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declaring attributes
	// Source
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
	final Attribute SourceParameterCount = new Attribute("SourceParameterCount");
	final Attribute SourceConstructorCallCount = new Attribute("SourceConstructorCallCount");
	final Attribute SourceCatchClauseCount = new Attribute("SourceCatchClauseCount");
	final Attribute SourceMethodCallCount = new Attribute("SourceMethodCallCount");
	final Attribute SourceFieldAccessCount = new Attribute("SourceFieldAccessCount");
	final Attribute SourceObjectCreationCount = new Attribute("SourceObjectCreationCount");
	final Attribute SourceSuperCallCount = new Attribute("SourceSuperCallCount");
	
	final Attribute SourceConstructorParameters = new Attribute("SourceConstructorParameters");
	final Attribute SourceArrayCreationCount = new Attribute("SourceArrayCreationCount");
	final Attribute SourceTokenCount = new Attribute("SourceTokenCount");
	
	final Attribute SourceCastExpressionCount = new Attribute("SourceCastExpressionCount");
	final Attribute SourceIsStatic = new Attribute("SourceIsStatic");
	final Attribute SourceIsAbstract = new Attribute("SourceIsAbstract");
	final Attribute SourceIsPublic = new Attribute("SourceIsPublic");
	final Attribute SourceIsPrivate = new Attribute("SourceIsPrivate");
	final Attribute SourceIsProtected = new Attribute("SourceIsProtected");
	final Attribute SourceIsFinal = new Attribute("SourceIsFinal");
	final Attribute SourceIsSynchronized = new Attribute("SourceIsSynchronized");
	final Attribute SourceMethodTypeLength = new Attribute("SourceMethodTypeLength");
	
	final Attribute SourceassignmentInFor = new Attribute("SourceassignmentInFor");
	final Attribute SourceassignmentInForeach = new Attribute("SourceassignmentInForeach");
	final Attribute SourceassignmentInIf = new Attribute("SourceassignmentInIf");
	final Attribute SourceassignmentInSwitch = new Attribute("SourceassignmentInSwitch");
	final Attribute SourceassignmentInTry = new Attribute("SourceassignmentInTry");
	final Attribute SourceassignmentInWhile = new Attribute("SourceassignmentInWhile");
	final Attribute SourcedeclarationInFor = new Attribute("SourcedeclarationInFor");
	final Attribute SourcedeclarationInForeach = new Attribute("SourcedeclarationInForeach");
	final Attribute SourcedeclarationInIf = new Attribute("SourcedeclarationInIf");
	final Attribute SourcedeclarationInSwitch = new Attribute("SourcedeclarationInSwitch");
	final Attribute SourcedeclarationInTry = new Attribute("SourcedeclarationInTry");
	final Attribute SourcedeclarationInWhile = new Attribute("SourcedeclarationInWhile");
	
	final Attribute SourcevariableDeclarationWithAssignment = new Attribute("SourcevariableDeclarationWithAssignment");
	final Attribute SourcevariableDeclarationWithoutAssignment = new Attribute("SourcevariableDeclarationWithoutAssignment");
	final Attribute SourceintegerLiteralExpression = new Attribute("SourceintegerLiteralExpression");
	final Attribute SourcebinaryExpression = new Attribute("SourcebinaryExpression");
	final Attribute SourceprimitiveType = new Attribute("SourceprimitiveType");
	final Attribute SourcelineComment = new Attribute("SourcelineComment");
	final Attribute SourcearrayType = new Attribute("SourcearrayType");
	
	//
	final Attribute SourcemethodOverrides = new Attribute("SourcemethodOverrides");
	final Attribute SourcenameExpressions = new Attribute("SourcenameExpressions");
	final Attribute SourcesimpleNames = new Attribute("SourcesimpleNames");
	final Attribute Sourcemodifiers = new Attribute("Sourcemodifiers");
	final Attribute SourcesubParameters = new Attribute("SourcesubParameters");
	final Attribute SourcemarkerAnnotations = new Attribute("SourcemarkerAnnotations");
	final Attribute SourceblockStatements = new Attribute("SourceblockStatements");
	final Attribute SourcenullLiterals = new Attribute("SourcenullLiterals");
	final Attribute SourcethrowStatements = new Attribute("SourcethrowStatements");
	
	final Attribute SourceforStatementCount = new Attribute("SourceforStatementCount");
	final Attribute SourceforeachStatementCount = new Attribute("SourceforeachStatementCount");
	final Attribute SourcewhileStatementCount = new Attribute("SourcewhileStatementCount");
	final Attribute SourceprimitiveTypes = new Attribute("SourceprimitiveTypes");
	final Attribute SourceclassInterfaceTypes = new Attribute("SourceclassInterfaceTypes");
	
	//
	final Attribute SourceDoStmt = new Attribute("SourceDoStmt");
	final Attribute SourceAssertStmt = new Attribute("SourceAssertStmt");
	final Attribute SourceDoubleLiteralExpr = new Attribute("SourceDoubleLiteralExpr");
	final Attribute SourceBooleanLiteralExpr = new Attribute("SourceBooleanLiteralExpr");
	final Attribute SourceCharLiteralExpr = new Attribute("SourceCharLiteralExpr");
	final Attribute SourceStringLiteralExpr = new Attribute("SourceStringLiteralExpr");
	final Attribute SourceArrayAccessExpr = new Attribute("SourceArrayAccessExpr");
	final Attribute SourceConditionalExpr = new Attribute("SourceConditionalExpr");
	final Attribute SourceEnclosedExpr = new Attribute("SourceEnclosedExpr");
	final Attribute SourceInstanceOfExpr = new Attribute("SourceInstanceOfExpr");
	final Attribute SourceLambdaExpr = new Attribute("SourceLambdaExpr");
	final Attribute SourceLiteralExpr = new Attribute("SourceLiteralExpr");
	final Attribute SourceLongLiteralExpr = new Attribute("SourceLongLiteralExpr");
	final Attribute SourceMethodReferenceExpr = new Attribute("SourceMethodReferenceExpr");
	final Attribute SourceNormalAnnotationExpr = new Attribute("SourceNormalAnnotationExpr");
	final Attribute SourcePatternExpr = new Attribute("SourcePatternExpr");
	final Attribute SourceSingleMemberAnnotationExpr = new Attribute("SourceSingleMemberAnnotationExpr");
	final Attribute SourceThisExpr = new Attribute("SourceThisExpr");
	final Attribute SourceTypeExpr = new Attribute("SourceTypeExpr");
	final Attribute SourceUnaryExpr = new Attribute("SourceUnaryExpr");
	final Attribute SourceBreakStmt = new Attribute("SourceBreakStmt");
	final Attribute SourceContinueStmt = new Attribute("SourceContinueStmt");
	final Attribute SourceYieldStmt = new Attribute("SourceYieldStmt");
	
    // target
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
	final Attribute TargetParameterCount = new Attribute("TargetParameterCount");
	final Attribute TargetConstructorCallCount = new Attribute("TargetConstructorCallCount");
	final Attribute TargetCatchClauseCount = new Attribute("TargetCatchClauseCount");
	final Attribute TargetMethodCallCount = new Attribute("TargetMethodCallCount");
	final Attribute TargetFieldAccessCount = new Attribute("TargetFieldAccessCount");
	final Attribute TargetObjectCreationCount = new Attribute("TargetObjectCreationCount");
	final Attribute TargetSuperCallCount = new Attribute("TargetSuperCallCount");	
	
	final Attribute TargetConstructorParameters = new Attribute("TargetConstructorParameters");
	final Attribute TargetArrayCreationCount = new Attribute("TargetArrayCreationCount");
	final Attribute TargetTokenCount = new Attribute("TargetTokenCount");
	
	final Attribute TargetCastExpressionCount = new Attribute("TargetCastExpressionCount");
	final Attribute TargetIsStatic = new Attribute("TargetIsStatic");
	final Attribute TargetIsAbstract = new Attribute("TargetIsAbstract");
	final Attribute TargetIsPublic = new Attribute("TargetIsPublic");
	final Attribute TargetIsPrivate = new Attribute("TargetIsPrivate");
	final Attribute TargetIsProtected = new Attribute("TargetIsProtected");
	final Attribute TargetIsFinal = new Attribute("TargetIsFinal");
	final Attribute TargetIsSynchronized = new Attribute("TargetIsSynchronized");
	final Attribute TargetMethodTypeLength = new Attribute("TargetMethodTypeLength");
	
	final Attribute TargetassignmentInFor = new Attribute("TargetassignmentInFor");
	final Attribute TargetassignmentInForeach = new Attribute("TargetassignmentInForeach");
	final Attribute TargetassignmentInIf = new Attribute("TargetassignmentInIf");
	final Attribute TargetassignmentInSwitch = new Attribute("TargetassignmentInSwitch");
	final Attribute TargetassignmentInTry = new Attribute("TargetassignmentInTry");
	final Attribute TargetassignmentInWhile = new Attribute("TargetassignmentInWhile");
	final Attribute TargetdeclarationInFor = new Attribute("TargetdeclarationInFor");
	final Attribute TargetdeclarationInForeach = new Attribute("TargetdeclarationInForeach");
	final Attribute TargetdeclarationInIf = new Attribute("TargetdeclarationInIf");
	final Attribute TargetdeclarationInSwitch = new Attribute("TargetdeclarationInSwitch");
	final Attribute TargetdeclarationInTry = new Attribute("TargetdeclarationInTry");
	final Attribute TargetdeclarationInWhile = new Attribute("TargetdeclarationInWhile");
	
	final Attribute TargetvariableDeclarationWithAssignment = new Attribute("TargetvariableDeclarationWithAssignment");
	final Attribute TargetvariableDeclarationWithoutAssignment = new Attribute("TargetvariableDeclarationWithoutAssignment");
	final Attribute TargetintegerLiteralExpression = new Attribute("TargetintegerLiteralExpression");
	final Attribute TargetbinaryExpression = new Attribute("TargetbinaryExpression");
	final Attribute TargetprimitiveType = new Attribute("TargetprimitiveType");
	final Attribute TargetlineComment = new Attribute("TargetlineComment");
	final Attribute TargetarrayType = new Attribute("TargetarrayType");
	
	//
	final Attribute TargetmethodOverrides = new Attribute("TargetmethodOverrides");
	final Attribute TargetnameExpressions = new Attribute("TargetnameExpressions");
	final Attribute TargetsimpleNames = new Attribute("TargetsimpleNames");
	final Attribute Targetmodifiers = new Attribute("Targetmodifiers");
	final Attribute TargetsubParameters = new Attribute("TargetsubParameters");
	final Attribute TargetmarkerAnnotations = new Attribute("TargetmarkerAnnotations");
	final Attribute TargetblockStatements = new Attribute("TargetblockStatements");
	final Attribute TargetnullLiterals = new Attribute("TargetnullLiterals");
	final Attribute TargetthrowStatements = new Attribute("TargetthrowStatements");

	final public Attribute TargetforStatementCount = new Attribute("TargetforStatementCount");
	final public Attribute TargetforeachStatementCount = new Attribute("TargetforeachStatementCount");
	final public Attribute TargetwhileStatementCount = new Attribute("TargetwhileStatementCount");
	final public Attribute TargetprimitiveTypes = new Attribute("TargetprimitiveTypes");
	final public Attribute TargetclassInterfaceTypes = new Attribute("TargetclassInterfaceTypes");
	
	//
	final Attribute TargetDoStmt = new Attribute("TargetDoStmt");
	final Attribute TargetAssertStmt = new Attribute("TargetAssertStmt");
	final Attribute TargetDoubleLiteralExpr = new Attribute("TargetDoubleLiteralExpr");
	final Attribute TargetBooleanLiteralExpr = new Attribute("TargetBooleanLiteralExpr");
	final Attribute TargetCharLiteralExpr = new Attribute("TargetCharLiteralExpr");
	final Attribute TargetStringLiteralExpr = new Attribute("TargetStringLiteralExpr");
	final Attribute TargetArrayAccessExpr = new Attribute("TargetArrayAccessExpr");
	final Attribute TargetConditionalExpr = new Attribute("TargetConditionalExpr");
	final Attribute TargetEnclosedExpr = new Attribute("TargetEnclosedExpr");
	final Attribute TargetInstanceOfExpr = new Attribute("TargetInstanceOfExpr");
	final Attribute TargetLambdaExpr = new Attribute("TargetLambdaExpr");
	final Attribute TargetLiteralExpr = new Attribute("TargetLiteralExpr");
	final Attribute TargetLongLiteralExpr = new Attribute("TargetLongLiteralExpr");
	final Attribute TargetMethodReferenceExpr = new Attribute("TargetMethodReferenceExpr");
	final Attribute TargetNormalAnnotationExpr = new Attribute("TargetNormalAnnotationExpr");
	final Attribute TargetPatternExpr = new Attribute("TargetPatternExpr");
	final Attribute TargetSingleMemberAnnotationExpr = new Attribute("TargetSingleMemberAnnotationExpr");
	final Attribute TargetThisExpr = new Attribute("TargetThisExpr");
	final Attribute TargetTypeExpr = new Attribute("TargetTypeExpr");
	final Attribute TargetUnaryExpr = new Attribute("TargetUnaryExpr");
	final Attribute TargetBreakStmt = new Attribute("TargetBreakStmt");
	final Attribute TargetContinueStmt = new Attribute("TargetContinueStmt");
	final Attribute TargetYieldStmt = new Attribute("TargetYieldStmt");
	
	// Difference between two vectors
	final public Attribute Difference = new Attribute("Difference");
	
	// Classes
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
    		add(SourceParameterCount);
    		add(SourceConstructorCallCount);
    		add(SourceCatchClauseCount);
    		add(SourceMethodCallCount);
    		add(SourceFieldAccessCount);
    		add(SourceObjectCreationCount);
    		add(SourceSuperCallCount);
    		
    		add(SourceConstructorParameters);
    		add(SourceArrayCreationCount);
    		add(SourceTokenCount);
    		
    		add(SourceCastExpressionCount);
    		add(SourceIsStatic);
    		add(SourceIsAbstract);
    		add(SourceIsPublic);
    		add(SourceIsPrivate);
    		add(SourceIsProtected);
    		add(SourceIsFinal);
    		add(SourceIsSynchronized);
    		add(SourceMethodTypeLength);
    		
    		add(SourceassignmentInFor);
    		add(SourceassignmentInForeach);
    		add(SourceassignmentInIf);
    		add(SourceassignmentInSwitch);
    		add(SourceassignmentInTry);
    		add(SourceassignmentInWhile);
    		add(SourcedeclarationInFor);
    		add(SourcedeclarationInForeach);
    		add(SourcedeclarationInIf);
    		add(SourcedeclarationInSwitch);
    		add(SourcedeclarationInTry);
    		add(SourcedeclarationInWhile);
    		
    		add(SourcevariableDeclarationWithAssignment);
    		add(SourcevariableDeclarationWithoutAssignment);
    		add(SourceintegerLiteralExpression);
    		add(SourcebinaryExpression);
    		add(SourceprimitiveType);
    		add(SourcelineComment);
    		add(SourcearrayType);
    		
    		add(SourcemethodOverrides);
    		add(SourcenameExpressions);
    		add(SourcesimpleNames);
    		add(Sourcemodifiers);
    		add(SourcesubParameters);
    		add(SourcemarkerAnnotations);
    		add(SourceblockStatements);
    		add(SourcenullLiterals);
    		add(SourcethrowStatements);

    		add(SourceforStatementCount);
    		add(SourceforeachStatementCount);
    		add(SourcewhileStatementCount);
    		add(SourceprimitiveTypes);
    		add(SourceclassInterfaceTypes);

    		add(SourceDoStmt);
    		add(SourceAssertStmt);
    		add(SourceDoubleLiteralExpr);
    		add(SourceBooleanLiteralExpr);
    		add(SourceCharLiteralExpr);
    		add(SourceStringLiteralExpr);
    		add(SourceArrayAccessExpr);
    		add(SourceConditionalExpr);
    		add(SourceEnclosedExpr);
    		add(SourceInstanceOfExpr);
    		add(SourceLambdaExpr);
    		add(SourceLiteralExpr);
    		add(SourceLongLiteralExpr);
    		add(SourceMethodReferenceExpr);
    		add(SourceNormalAnnotationExpr);
    		add(SourcePatternExpr);
    		add(SourceSingleMemberAnnotationExpr);
    		add(SourceThisExpr);
    		add(SourceTypeExpr);
    		add(SourceUnaryExpr);
    		add(SourceBreakStmt);
    		add(SourceContinueStmt);
    		add(SourceYieldStmt);
    		
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
    		add(TargetParameterCount);
    		add(TargetConstructorCallCount);
    		add(TargetCatchClauseCount);
    		add(TargetMethodCallCount);
    		add(TargetFieldAccessCount);
    		add(TargetObjectCreationCount);
    		add(TargetSuperCallCount);
    		
    		add(TargetConstructorParameters);
    		add(TargetArrayCreationCount);
    		add(TargetTokenCount);
    		
    		add(TargetCastExpressionCount);
    		add(TargetIsStatic);
    		add(TargetIsAbstract);
    		add(TargetIsPublic);
    		add(TargetIsPrivate);
    		add(TargetIsProtected);
    		add(TargetIsFinal);
    		add(TargetIsSynchronized);
    		add(TargetMethodTypeLength);
    		
    		add(TargetassignmentInFor);
    		add(TargetassignmentInForeach);
    		add(TargetassignmentInIf);
    		add(TargetassignmentInSwitch);
    		add(TargetassignmentInTry);
    		add(TargetassignmentInWhile);
    		add(TargetdeclarationInFor);
    		add(TargetdeclarationInForeach);
    		add(TargetdeclarationInIf);
    		add(TargetdeclarationInSwitch);
    		add(TargetdeclarationInTry);
    		add(TargetdeclarationInWhile);
    		
    		add(TargetvariableDeclarationWithAssignment);
    		add(TargetvariableDeclarationWithoutAssignment);
    		add(TargetintegerLiteralExpression);
    		add(TargetbinaryExpression);
    		add(TargetprimitiveType);
    		add(TargetlineComment);
    		add(TargetarrayType);
    		
    		add(TargetmethodOverrides);
    		add(TargetnameExpressions);
    		add(TargetsimpleNames);
    		add(Targetmodifiers);
    		add(TargetsubParameters);
    		add(TargetmarkerAnnotations);
    		add(TargetblockStatements);
    		add(TargetnullLiterals);
    		add(TargetthrowStatements);

    		add(TargetforStatementCount);
    		add(TargetforeachStatementCount);
    		add(TargetwhileStatementCount);
    		add(TargetprimitiveTypes);
    		add(TargetclassInterfaceTypes);
    		
    		add(TargetDoStmt);
    		add(TargetAssertStmt);
    		add(TargetDoubleLiteralExpr);
    		add(TargetBooleanLiteralExpr);
    		add(TargetCharLiteralExpr);
    		add(TargetStringLiteralExpr);
    		add(TargetArrayAccessExpr);
    		add(TargetConditionalExpr);
    		add(TargetEnclosedExpr);
    		add(TargetInstanceOfExpr);
    		add(TargetLambdaExpr);
    		add(TargetLiteralExpr);
    		add(TargetLongLiteralExpr);
    		add(TargetMethodReferenceExpr);
    		add(TargetNormalAnnotationExpr);
    		add(TargetPatternExpr);
    		add(TargetSingleMemberAnnotationExpr);
    		add(TargetThisExpr);
    		add(TargetTypeExpr);
    		add(TargetUnaryExpr);
    		add(TargetBreakStmt);
    		add(TargetContinueStmt);
    		add(TargetYieldStmt);
    		
    		//
    		add(Difference);
    		
    		Attribute attributeClass = new Attribute("@@class@@", classes);
    		add(attributeClass);
    	}
    };		
	
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
					+ "SOURCE_PARAMETER_COUNT,"
					+ "SOURCE_DECLARED_VARIABLE_COUNT,"
					+ "SOURCE_CONSTRUCTOR_CALL_COUNT,"
					+ "SOURCE_CATCH_CLAUSE_COUNT,"
					+ "SOURCE_SWITCH_COUNT,"
					+ "SOURCE_CASE_COUNT,"
					+ "SOURCE_ITERATOR_COUNT,"
					+ "SOURCE_ASSIGNMENT_COUNT,"
					+ "SOURCE_METHOD_CALL_COUNT,"
					+ "SOURCE_FIELD_ACCESS_COUNT,"
					+ "SOURCE_EXPRESSION_COUNT,"
					+ "SOURCE_DISTINCT_TYPE_COUNT,"
					+ "SOURCE_OBJECT_CREATION_COUNT,"
					+ "SOURCE_IF_COUNT,"
					+ "SOURCE_SUPER_CALL_COUNT,"
					+ "SOURCE_RETURN_COUNT,"
					+ "SOURCE_TRY_STATEMENT_COUNT,"
					+ "SOURCE_CONSTRUCTOR_PARAMETERS,"
					+ "SOURCE_ARRAY_CREATION_COUNT,"
					+ "SOURCE_TOKEN_COUNT,"
					+ "SOURCE_CAST_EXPRESSION_COUNT,"
					+ "SOURCE_IS_STATIC,"
					+ "SOURCE_IS_ABSTRACT,"
					+ "SOURCE_IS_PUBLIC,"
					+ "SOURCE_IS_PRIVATE,"
					+ "SOURCE_IS_PROTECTED,"
					+ "SOURCE_IS_FINAL,"
					+ "SOURCE_IS_SYNCHRONIZED,"
					+ "SOURCE_METHOD_TYPE_LENGTH,"	
					+ "SOURCE_ASSIGNMENT_IN_FOR,"
					+ "SOURCE_ASSIGNMENT_IN_FOREACH,"
					+ "SOURCE_ASSIGNMENT_IN_IF,"
					+ "SOURCE_ASSIGNMENT_IN_SWITCH,"
					+ "SOURCE_ASSIGNMENT_IN_TRY,"
					+ "SOURCE_ASSIGNMENT_IN_WHILE,"
					+ "SOURCE_DECLARATION_IN_FOR,"
					+ "SOURCE_DECLARATION_IN_FOREACH,"
					+ "SOURCE_DECLARATION_IN_IF,"
					+ "SOURCE_DECLARATION_IN_SWITCH,"
					+ "SOURCE_DECLARATION_IN_TRY,"
					+ "SOURCE_DECLARATION_IN_WHILE,"
					+ "SourcevariableDeclarationWithAssignment,"
					+ "SourcevariableDeclarationWithoutAssignment,"
					+ "SourceintegerLiteralExpression,"
					+ "SourcebinaryExpression,"
					+ "SourceprimitiveType,"
					+ "SourcelineComment,"
					+ "SourcearrayType,"
					+ "SourcemethodOverrides,"
					+ "SourcenameExpressions,"
					+ "SourcesimpleNames,"
					+ "Sourcemodifiers,"
					+ "SourcesubParameters,"
					+ "SourcemarkerAnnotations,"
					+ "SourceblockStatements,"
					+ "SourcenullLiterals,"
					+ "SourcethrowStatements,"
					+ "SourceforStatementCount,"
					+ "SourceforeachStatementCount,"
					+ "SourcewhileStatementCount,"
					+ "SourceprimitiveTypes,"
					+ "SourceclassInterfaceTypes,"	
					+ "SourceDoStmt,"
					+ "SourceAssertStmt,"
					+ "SourceDoubleLiteralExpr,"
					+ "SourceBooleanLiteralExpr,"
					+ "SourceCharLiteralExpr,"
					+ "SourceStringLiteralExpr,"
					+ "SourceArrayAccessExpr,"
					+ "SourceConditionalExpr,"
					+ "SourceEnclosedExpr,"
					+ "SourceInstanceOfExpr,"
					+ "SourceLambdaExpr,"
					+ "SourceLiteralExpr,"
					+ "SourceLongLiteralExpr,"
					+ "SourceMethodReferenceExpr,"
					+ "SourceNormalAnnotationExpr,"
					+ "SourcePatternExpr,"
					+ "SourceSingleMemberAnnotationExpr,"
					+ "SourceThisExpr,"
					+ "SourceTypeExpr,"
					+ "SourceUnaryExpr,"
					+ "SourceBreakStmt,"
					+ "SourceContinueStmt,"
					+ "SourceYieldStmt,"					
					
					+ "TARGET_METHOD_LENGTH,"
					+ "TARGET_PARAMETER_COUNT,"
					+ "TARGET_DECLARED_VARIABLE_COUNT,"
					+ "TARGET_CONSTRUCTOR_CALL_COUNT,"
					+ "TARGET_CATCH_CLAUSE_COUNT,"
					+ "TARGET_SWITCH_COUNT,"
					+ "TARGET_CASE_COUNT,"
					+ "TARGET_ITERATOR_COUNT,"
					+ "TARGET_ASSIGNMENT_COUNT,"
					+ "TARGET_METHOD_CALL_COUNT,"
					+ "TARGET_FIELD_ACCESS_COUNT,"
					+ "TARGET_EXPRESSION_COUNT,"
					+ "TARGET_DISTINCT_TYPE_COUNT,"
					+ "TARGET_OBJECT_CREATION_COUNT,"
					+ "TARGET_IF_COUNT,"
					+ "TARGET_SUPER_CALL_COUNT,"
					+ "TARGET_RETURN_COUNT,"
					+ "TARGET_TRY_STATEMENT_COUNT,"		
					+ "TARGET_CONSTRUCTOR_PARAMETERS,"
					+ "TARGET_ARRAY_CREATION_COUNT,"
					+ "TARGET_TOKEN_COUNT,"
					+ "TARGET_CAST_EXPRESSION_COUNT,"
					+ "TARGET_IS_STATIC,"
					+ "TARGET_IS_ABSTRACT,"
					+ "TARGET_IS_PUBLIC,"
					+ "TARGET_IS_PRIVATE,"
					+ "TARGET_IS_PROTECTED,"
					+ "TARGET_IS_FINAL,"
					+ "TARGET_IS_SYNCHRONIZED,"
					+ "TARGET_METHOD_TYPE_LENGTH,"		
					+ "TARGET_ASSIGNMENT_IN_FOR,"
					+ "TARGET_ASSIGNMENT_IN_FOREACH,"
					+ "TARGET_ASSIGNMENT_IN_IF,"
					+ "TARGET_ASSIGNMENT_IN_SWITCH,"
					+ "TARGET_ASSIGNMENT_IN_TRY,"
					+ "TARGET_ASSIGNMENT_IN_WHILE,"
					+ "TARGET_DECLARATION_IN_FOR,"
					+ "TARGET_DECLARATION_IN_FOREACH,"
					+ "TARGET_DECLARATION_IN_IF,"
					+ "TARGET_DECLARATION_IN_SWITCH,"
					+ "TARGET_DECLARATION_IN_TRY,"
					+ "TARGET_DECLARATION_IN_WHILE,"
					+ "TargetvariableDeclarationWithAssignment,"
					+ "TargetvariableDeclarationWithoutAssignment,"
					+ "TargetintegerLiteralExpression,"
					+ "TargetbinaryExpression,"
					+ "TargetprimitiveType,"
					+ "TargetlineComment,"
					+ "TargetarrayType,"
					+ "TargetmethodOverrides,"
					+ "TargetnameExpressions,"
					+ "TargetsimpleNames,"
					+ "Targetmodifiers,"
					+ "TargetsubParameters,"
					+ "TargetmarkerAnnotations,"
					+ "TargetblockStatements,"
					+ "TargetnullLiterals,"
					+ "TargetthrowStatements,"
					+ "TargetforStatementCount,"
					+ "TargetforeachStatementCount,"
					+ "TargetwhileStatementCount,"
					+ "TargetprimitiveTypes,"
					+ "TargetclassInterfaceTypes,"					
					+ "TargetDoStmt,"
					+ "TargetAssertStmt,"
					+ "TargetDoubleLiteralExpr,"
					+ "TargetBooleanLiteralExpr,"
					+ "TargetCharLiteralExpr,"
					+ "TargetStringLiteralExpr,"
					+ "TargetArrayAccessExpr,"
					+ "TargetConditionalExpr,"
					+ "TargetEnclosedExpr,"
					+ "TargetInstanceOfExpr,"
					+ "TargetLambdaExpr,"
					+ "TargetLiteralExpr,"
					+ "TargetLongLiteralExpr,"
					+ "TargetMethodReferenceExpr,"
					+ "TargetNormalAnnotationExpr,"
					+ "TargetPatternExpr,"
					+ "TargetSingleMemberAnnotationExpr,"
					+ "TargetThisExpr,"
					+ "TargetTypeExpr,"
					+ "TargetUnaryExpr,"
					+ "TargetBreakStmt,"
					+ "TargetContinueStmt,"
					+ "TargetYieldStmt,"
					
					+ "Difference,"
					
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
			    		setValue(SourceParameterCount, rs.getInt("SOURCE_PARAMETER_COUNT"));
			    		setValue(SourceConstructorCallCount, rs.getInt("SOURCE_CONSTRUCTOR_CALL_COUNT"));
			    		setValue(SourceCatchClauseCount, rs.getInt("SOURCE_CATCH_CLAUSE_COUNT"));
			    		setValue(SourceMethodCallCount, rs.getInt("SOURCE_METHOD_LENGTH"));
			    		setValue(SourceFieldAccessCount, rs.getInt("SOURCE_FIELD_ACCESS_COUNT"));
			    		setValue(SourceObjectCreationCount, rs.getInt("SOURCE_OBJECT_CREATION_COUNT"));
			    		setValue(SourceSuperCallCount, rs.getInt("SOURCE_SUPER_CALL_COUNT"));	
			    		
			    		setValue(SourceConstructorParameters, rs.getInt("SOURCE_CONSTRUCTOR_PARAMETERS"));
			    		setValue(SourceArrayCreationCount, rs.getInt("SOURCE_ARRAY_CREATION_COUNT"));
			    		setValue(SourceTokenCount, rs.getInt("SOURCE_TOKEN_COUNT"));
			    		
			    		setValue(SourceCastExpressionCount, rs.getInt("SOURCE_CAST_EXPRESSION_COUNT"));
			    		setValue(SourceIsStatic, rs.getInt("SOURCE_IS_STATIC"));
			    		setValue(SourceIsAbstract, rs.getInt("SOURCE_IS_ABSTRACT"));
			    		setValue(SourceIsPublic, rs.getInt("SOURCE_IS_PUBLIC"));
			    		setValue(SourceIsPrivate, rs.getInt("SOURCE_IS_PRIVATE"));
			    		setValue(SourceIsProtected, rs.getInt("SOURCE_IS_PROTECTED"));
			    		setValue(SourceIsFinal, rs.getInt("SOURCE_IS_FINAL"));
			    		setValue(SourceIsSynchronized, rs.getInt("SOURCE_IS_SYNCHRONIZED"));
			    		setValue(SourceMethodTypeLength, rs.getInt("SOURCE_METHOD_TYPE_LENGTH"));
			    		
			    		setValue(SourceassignmentInFor, rs.getInt("SOURCE_ASSIGNMENT_IN_FOR"));
			    		setValue(SourceassignmentInForeach, rs.getInt("SOURCE_ASSIGNMENT_IN_FOREACH"));
			    		setValue(SourceassignmentInIf, rs.getInt("SOURCE_ASSIGNMENT_IN_IF"));
			    		setValue(SourceassignmentInSwitch, rs.getInt("SOURCE_ASSIGNMENT_IN_SWITCH"));
			    		setValue(SourceassignmentInTry, rs.getInt("SOURCE_ASSIGNMENT_IN_TRY"));
			    		setValue(SourceassignmentInWhile, rs.getInt("SOURCE_ASSIGNMENT_IN_WHILE"));
			    		setValue(SourcedeclarationInFor, rs.getInt("SOURCE_DECLARATION_IN_FOR"));
			    		setValue(SourcedeclarationInForeach, rs.getInt("SOURCE_DECLARATION_IN_FOREACH"));
			    		setValue(SourcedeclarationInIf, rs.getInt("SOURCE_DECLARATION_IN_IF"));
			    		setValue(SourcedeclarationInSwitch, rs.getInt("SOURCE_DECLARATION_IN_SWITCH"));
			    		setValue(SourcedeclarationInTry, rs.getInt("SOURCE_DECLARATION_IN_TRY"));
			    		setValue(SourcedeclarationInWhile, rs.getInt("SOURCE_DECLARATION_IN_WHILE"));
			    		
			    		setValue(SourcevariableDeclarationWithAssignment, rs.getInt("SourcevariableDeclarationWithAssignment"));
			    		setValue(SourcevariableDeclarationWithoutAssignment, rs.getInt("SourcevariableDeclarationWithoutAssignment"));
			    		setValue(SourceintegerLiteralExpression, rs.getInt("SourceintegerLiteralExpression"));
			    		setValue(SourcebinaryExpression, rs.getInt("SourcebinaryExpression"));
			    		setValue(SourceprimitiveType, rs.getInt("SourceprimitiveType"));
			    		setValue(SourcelineComment, rs.getInt("SourcelineComment"));
			    		setValue(SourcearrayType, rs.getInt("SourcearrayType"));
			    		
			    		setValue(SourcemethodOverrides, rs.getInt("SourcemethodOverrides"));
			    		setValue(SourcenameExpressions, rs.getInt("SourcenameExpressions"));
			    		setValue(SourcesimpleNames, rs.getInt("SourcesimpleNames"));
			    		setValue(Sourcemodifiers, rs.getInt("Sourcemodifiers"));
			    		setValue(SourcesubParameters, rs.getInt("SourcesubParameters"));
			    		setValue(SourcemarkerAnnotations, rs.getInt("SourcemarkerAnnotations"));
			    		setValue(SourceblockStatements, rs.getInt("SourceblockStatements"));
			    		setValue(SourcenullLiterals, rs.getInt("SourcenullLiterals"));
			    		setValue(SourcethrowStatements, rs.getInt("SourcethrowStatements"));
			    		
			    		setValue(SourceforStatementCount, rs.getInt("SourceforStatementCount"));
			    		setValue(SourceforeachStatementCount, rs.getInt("SourceforeachStatementCount"));
			    		setValue(SourcewhileStatementCount, rs.getInt("SourcewhileStatementCount"));
			    		setValue(SourceprimitiveTypes, rs.getInt("SourceprimitiveTypes"));
			    		setValue(SourceclassInterfaceTypes, rs.getInt("SourceclassInterfaceTypes"));
			    		
			    		setValue(SourceDoStmt, rs.getInt("SourceDoStmt"));
			    		setValue(SourceAssertStmt, rs.getInt("SourceAssertStmt"));
			    		setValue(SourceDoubleLiteralExpr, rs.getInt("SourceDoubleLiteralExpr"));
			    		setValue(SourceBooleanLiteralExpr, rs.getInt("SourceBooleanLiteralExpr"));
			    		setValue(SourceCharLiteralExpr, rs.getInt("SourceCharLiteralExpr"));
			    		setValue(SourceStringLiteralExpr, rs.getInt("SourceStringLiteralExpr"));
			    		setValue(SourceArrayAccessExpr, rs.getInt("SourceArrayAccessExpr"));
			    		setValue(SourceConditionalExpr, rs.getInt("SourceConditionalExpr"));
			    		setValue(SourceEnclosedExpr, rs.getInt("SourceEnclosedExpr"));
			    		setValue(SourceInstanceOfExpr, rs.getInt("SourceInstanceOfExpr"));
			    		setValue(SourceLambdaExpr, rs.getInt("SourceLambdaExpr"));
			    		setValue(SourceLiteralExpr, rs.getInt("SourceLiteralExpr"));
			    		setValue(SourceLongLiteralExpr, rs.getInt("SourceLongLiteralExpr"));
			    		setValue(SourceMethodReferenceExpr, rs.getInt("SourceMethodReferenceExpr"));
			    		setValue(SourceNormalAnnotationExpr, rs.getInt("SourceNormalAnnotationExpr"));
			    		setValue(SourcePatternExpr, rs.getInt("SourcePatternExpr"));
			    		setValue(SourceSingleMemberAnnotationExpr, rs.getInt("SourceSingleMemberAnnotationExpr"));
			    		setValue(SourceThisExpr, rs.getInt("SourceThisExpr"));
			    		setValue(SourceTypeExpr, rs.getInt("SourceTypeExpr"));
			    		setValue(SourceUnaryExpr, rs.getInt("SourceUnaryExpr"));
			    		setValue(SourceBreakStmt, rs.getInt("SourceBreakStmt"));
			    		setValue(SourceContinueStmt, rs.getInt("SourceContinueStmt"));
			    		setValue(SourceYieldStmt, rs.getInt("SourceYieldStmt"));
			    		
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
			    		setValue(TargetParameterCount, rs.getInt("TARGET_PARAMETER_COUNT"));
			    		setValue(TargetConstructorCallCount, rs.getInt("TARGET_CONSTRUCTOR_CALL_COUNT"));
			    		setValue(TargetCatchClauseCount, rs.getInt("TARGET_CATCH_CLAUSE_COUNT"));
			    		setValue(TargetMethodCallCount, rs.getInt("TARGET_METHOD_LENGTH"));
			    		setValue(TargetFieldAccessCount, rs.getInt("TARGET_FIELD_ACCESS_COUNT"));
			    		setValue(TargetObjectCreationCount, rs.getInt("TARGET_OBJECT_CREATION_COUNT"));
			    		setValue(TargetSuperCallCount, rs.getInt("TARGET_SUPER_CALL_COUNT"));			
			    		
			    		setValue(TargetConstructorParameters, rs.getInt("TARGET_CONSTRUCTOR_PARAMETERS"));
			    		setValue(TargetArrayCreationCount, rs.getInt("TARGET_ARRAY_CREATION_COUNT"));
			    		setValue(TargetTokenCount, rs.getInt("TARGET_TOKEN_COUNT"));
			    		
			    		setValue(TargetCastExpressionCount, rs.getInt("TARGET_CAST_EXPRESSION_COUNT"));
			    		setValue(TargetIsStatic, rs.getInt("TARGET_IS_STATIC"));
			    		setValue(TargetIsAbstract, rs.getInt("TARGET_IS_ABSTRACT"));
			    		setValue(TargetIsPublic, rs.getInt("TARGET_IS_PUBLIC"));
			    		setValue(TargetIsPrivate, rs.getInt("TARGET_IS_PRIVATE"));
			    		setValue(TargetIsProtected, rs.getInt("TARGET_IS_PROTECTED"));
			    		setValue(TargetIsFinal, rs.getInt("TARGET_IS_FINAL"));
			    		setValue(TargetIsSynchronized, rs.getInt("TARGET_IS_SYNCHRONIZED"));
			    		setValue(TargetMethodTypeLength, rs.getInt("TARGET_METHOD_TYPE_LENGTH"));
			    		
			    		setValue(TargetassignmentInFor, rs.getInt("TARGET_ASSIGNMENT_IN_FOR"));
			    		setValue(TargetassignmentInForeach, rs.getInt("TARGET_ASSIGNMENT_IN_FOREACH"));
			    		setValue(TargetassignmentInIf, rs.getInt("TARGET_ASSIGNMENT_IN_IF"));
			    		setValue(TargetassignmentInSwitch, rs.getInt("TARGET_ASSIGNMENT_IN_SWITCH"));
			    		setValue(TargetassignmentInTry, rs.getInt("TARGET_ASSIGNMENT_IN_TRY"));
			    		setValue(TargetassignmentInWhile, rs.getInt("TARGET_ASSIGNMENT_IN_WHILE"));
			    		setValue(TargetdeclarationInFor, rs.getInt("TARGET_DECLARATION_IN_FOR"));
			    		setValue(TargetdeclarationInForeach, rs.getInt("TARGET_DECLARATION_IN_FOREACH"));
			    		setValue(TargetdeclarationInIf, rs.getInt("TARGET_DECLARATION_IN_IF"));
			    		setValue(TargetdeclarationInSwitch, rs.getInt("TARGET_DECLARATION_IN_SWITCH"));
			    		setValue(TargetdeclarationInTry, rs.getInt("TARGET_DECLARATION_IN_TRY"));
			    		setValue(TargetdeclarationInWhile, rs.getInt("TARGET_DECLARATION_IN_WHILE"));
			    		
			    		setValue(TargetvariableDeclarationWithAssignment, rs.getInt("TargetvariableDeclarationWithAssignment"));
			    		setValue(TargetvariableDeclarationWithoutAssignment, rs.getInt("TargetvariableDeclarationWithoutAssignment"));
			    		setValue(TargetintegerLiteralExpression, rs.getInt("TargetintegerLiteralExpression"));
			    		setValue(TargetbinaryExpression, rs.getInt("TargetbinaryExpression"));
			    		setValue(TargetprimitiveType, rs.getInt("TargetprimitiveType"));
			    		setValue(TargetlineComment, rs.getInt("TargetlineComment"));
			    		setValue(TargetarrayType, rs.getInt("TargetarrayType"));
			    		
			    		setValue(TargetmethodOverrides, rs.getInt("TargetmethodOverrides"));
			    		setValue(TargetnameExpressions, rs.getInt("TargetnameExpressions"));
			    		setValue(TargetsimpleNames, rs.getInt("TargetsimpleNames"));
			    		setValue(Targetmodifiers, rs.getInt("Targetmodifiers"));
			    		setValue(TargetsubParameters, rs.getInt("TargetsubParameters"));
			    		setValue(TargetmarkerAnnotations, rs.getInt("TargetmarkerAnnotations"));
			    		setValue(TargetblockStatements, rs.getInt("TargetblockStatements"));
			    		setValue(TargetnullLiterals, rs.getInt("TargetnullLiterals"));
			    		setValue(TargetthrowStatements, rs.getInt("TargetthrowStatements"));
			    		
			    		setValue(TargetforStatementCount, rs.getInt("TargetforStatementCount"));
			    		setValue(TargetforeachStatementCount, rs.getInt("TargetforeachStatementCount"));
			    		setValue(TargetwhileStatementCount, rs.getInt("TargetwhileStatementCount"));
			    		setValue(TargetprimitiveTypes, rs.getInt("TargetprimitiveTypes"));
			    		setValue(TargetclassInterfaceTypes, rs.getInt("TargetclassInterfaceTypes"));
			    		
			    		setValue(TargetDoStmt, rs.getInt("TargetDoStmt"));
			    		setValue(TargetAssertStmt, rs.getInt("TargetAssertStmt"));
			    		setValue(TargetDoubleLiteralExpr, rs.getInt("TargetDoubleLiteralExpr"));
			    		setValue(TargetBooleanLiteralExpr, rs.getInt("TargetBooleanLiteralExpr"));
			    		setValue(TargetCharLiteralExpr, rs.getInt("TargetCharLiteralExpr"));
			    		setValue(TargetStringLiteralExpr, rs.getInt("TargetStringLiteralExpr"));
			    		setValue(TargetArrayAccessExpr, rs.getInt("TargetArrayAccessExpr"));
			    		setValue(TargetConditionalExpr, rs.getInt("TargetConditionalExpr"));
			    		setValue(TargetEnclosedExpr, rs.getInt("TargetEnclosedExpr"));
			    		setValue(TargetInstanceOfExpr, rs.getInt("TargetInstanceOfExpr"));
			    		setValue(TargetLambdaExpr, rs.getInt("TargetLambdaExpr"));
			    		setValue(TargetLiteralExpr, rs.getInt("TargetLiteralExpr"));
			    		setValue(TargetLongLiteralExpr, rs.getInt("TargetLongLiteralExpr"));
			    		setValue(TargetMethodReferenceExpr, rs.getInt("TargetMethodReferenceExpr"));
			    		setValue(TargetNormalAnnotationExpr, rs.getInt("TargetNormalAnnotationExpr"));
			    		setValue(TargetPatternExpr, rs.getInt("TargetPatternExpr"));
			    		setValue(TargetSingleMemberAnnotationExpr, rs.getInt("TargetSingleMemberAnnotationExpr"));
			    		setValue(TargetThisExpr, rs.getInt("TargetThisExpr"));
			    		setValue(TargetTypeExpr, rs.getInt("TargetTypeExpr"));
			    		setValue(TargetUnaryExpr, rs.getInt("TargetUnaryExpr"));
			    		setValue(TargetBreakStmt, rs.getInt("TargetBreakStmt"));
			    		setValue(TargetContinueStmt, rs.getInt("TargetContinueStmt"));
			    		setValue(TargetYieldStmt, rs.getInt("TargetYieldStmt"));
			    		
			    		setValue(Difference, rs.getInt("Difference"));
			    	}
			    };

			    // Reference instances dataset to instance for field references
			    newCloneInstance.setDataset(featureVector);			
			    newCloneInstance.setClassValue(rs.getString("CLONE"));		    
			    featureVector.add(newCloneInstance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			    
		return featureVector;
	}    
    
	public FeatureVector GetFeatureVectorFromCodes(Features sourceData, Features targetData)
	{
		FeatureVector vector = new FeatureVector();
		// Source
		vector.SourceMethodLength = sourceData.MethodLength;
		vector.SourceParameterCount = sourceData.ParameterCount;
		vector.SourceDeclaredVariableCount = sourceData.DeclaredVariableCount;
		vector.SourceConstructorCallCount = sourceData.ConstructorCallCount;
		vector.SourceCatchClauseCount = sourceData.CatchClauseCount;
		vector.SourceSwitchCount = sourceData.SwitchCount;
		vector.SourceCaseCount = sourceData.CaseCount;
		vector.SourceIteratorCount = sourceData.IteratorCount;
		vector.SourceAssignmentCount = sourceData.AssignmentCount;
		vector.SourceMethodCallCount = sourceData.MethodCallCount;
		vector.SourceFieldAccessCount = sourceData.FieldAccessCount;
		vector.SourceExpressionCount = sourceData.ExpressionCount;
		vector.SourceDistinctTypeCount = sourceData.DistinctTypeCount;
		vector.SourceObjectCreationCount = sourceData.ObjectCreationCount;
		vector.SourceIfCount = sourceData.IfCount;
		vector.SourceSuperCallCount = sourceData.SuperCallCount;
		vector.SourceReturnCount = sourceData.ReturnCount;
		vector.SourceTryStatementCount = sourceData.TryStatementCount;
		
		vector.SourceConstructorParameters = sourceData.ConstructorParameter;
		vector.SourceArrayCreationCount = sourceData.ArrayCreationCount;
		vector.SourceTokenCount = sourceData.TokenCount;
		
		vector.SourceCastExpressionCount = sourceData.CastExpressionCount;
		vector.SourceIsStatic = sourceData.IsStatic;
		vector.SourceIsAbstract = sourceData.IsAbstract;
		vector.SourceIsPublic = sourceData.IsPublic;
		vector.SourceIsPrivate = sourceData.IsPrivate;
		vector.SourceIsProtected = sourceData.IsProtected;
		vector.SourceIsFinal = sourceData.IsFinal;
		vector.SourceIsSynchronized = sourceData.IsSynchronized;
		vector.SourceMethodTypeLength = sourceData.MethodTypeLength;
		
		vector.SourceassignmentInFor = sourceData.assignmentInFor;
		vector.SourceassignmentInForeach = sourceData.assignmentInForeach;
		vector.SourceassignmentInIf = sourceData.assignmentInIf;
		vector.SourceassignmentInSwitch = sourceData.assignmentInSwitch;
		vector.SourceassignmentInTry = sourceData.assignmentInTry;
		vector.SourceassignmentInWhile = sourceData.assignmentInWhile;
		vector.SourcedeclarationInFor = sourceData.declarationInFor;
		vector.SourcedeclarationInForeach = sourceData.declarationInForeach;
		vector.SourcedeclarationInIf = sourceData.declarationInIf;
		vector.SourcedeclarationInSwitch = sourceData.declarationInSwitch;
		vector.SourcedeclarationInTry = sourceData.declarationInTry;
		vector.SourcedeclarationInWhile = sourceData.declarationInWhile;
		
		vector.SourcevariableDeclarationWithAssignment = sourceData.variableDeclarationWithAssignment;
		vector.SourcevariableDeclarationWithoutAssignment = sourceData.variableDeclarationWithoutAssignment;
		vector.SourceintegerLiteralExpression = sourceData.integerLiteralExpression;
		vector.SourcebinaryExpression = sourceData.binaryExpression;
		vector.SourceprimitiveType = sourceData.primitiveType;
		vector.SourcelineComment = sourceData.lineComment;
		vector.SourcearrayType = sourceData.arrayType;
		
		vector.SourcemethodOverrides  = sourceData.methodOverrides;
		vector.SourcenameExpressions  = sourceData.nameExpressions;
		vector.SourcesimpleNames  = sourceData.simpleNames;
		vector.Sourcemodifiers  = sourceData.modifiers;
		vector.SourcesubParameters  = sourceData.subParameters;
		vector.SourcemarkerAnnotations  = sourceData.markerAnnotations;
		vector.SourceblockStatements  = sourceData.blockStatements;
		vector.SourcenullLiterals  = sourceData.nullLiterals;
		vector.SourcethrowStatements  = sourceData.throwStatements;
		
		vector.SourceforStatementCount = sourceData.forStatementCount;
		vector.SourceforeachStatementCount = sourceData.foreachStatementCount;
		vector.SourcewhileStatementCount = sourceData.whileStatementCount;
		vector.SourceprimitiveTypes = sourceData.primitiveTypes;
		vector.SourceclassInterfaceTypes = sourceData.classInterfaceTypes;
		
		vector.SourceDoStmt = sourceData.DoStmt;
		vector.SourceAssertStmt = sourceData.AssertStmt;
		vector.SourceDoubleLiteralExpr = sourceData.DoubleLiteralExpr;
		vector.SourceBooleanLiteralExpr = sourceData.BooleanLiteralExpr;
		vector.SourceCharLiteralExpr = sourceData.CharLiteralExpr;
		vector.SourceStringLiteralExpr = sourceData.StringLiteralExpr;
		vector.SourceArrayAccessExpr = sourceData.ArrayAccessExpr;
		vector.SourceConditionalExpr = sourceData.ConditionalExpr;
		vector.SourceEnclosedExpr = sourceData.EnclosedExpr;
		vector.SourceInstanceOfExpr = sourceData.InstanceOfExpr;
		vector.SourceLambdaExpr = sourceData.LambdaExpr;
		vector.SourceLiteralExpr = sourceData.LiteralExpr;
		vector.SourceLongLiteralExpr = sourceData.LongLiteralExpr;
		vector.SourceMethodReferenceExpr = sourceData.MethodReferenceExpr;
		vector.SourceNormalAnnotationExpr = sourceData.NormalAnnotationExpr;
		vector.SourcePatternExpr = sourceData.PatternExpr;
		vector.SourceSingleMemberAnnotationExpr = sourceData.SingleMemberAnnotationExpr;
		vector.SourceThisExpr = sourceData.ThisExpr;
		vector.SourceTypeExpr = sourceData.TypeExpr;
		vector.SourceUnaryExpr = sourceData.UnaryExpr;
		vector.SourceBreakStmt = sourceData.BreakStmt;
		vector.SourceContinueStmt = sourceData.ContinueStmt;
		vector.SourceYieldStmt = sourceData.YieldStmt;
		
		// Target
		vector.TargetMethodLength = targetData.MethodLength;
		vector.TargetParameterCount = targetData.ParameterCount;
		vector.TargetDeclaredVariableCount = targetData.DeclaredVariableCount;
		vector.TargetConstructorCallCount = targetData.ConstructorCallCount;
		vector.TargetCatchClauseCount = targetData.CatchClauseCount;
		vector.TargetSwitchCount = targetData.SwitchCount;
		vector.TargetCaseCount = targetData.CaseCount;
		vector.TargetIteratorCount = targetData.IteratorCount;
		vector.TargetAssignmentCount = targetData.AssignmentCount;
		vector.TargetMethodCallCount = targetData.MethodCallCount;
		vector.TargetFieldAccessCount = targetData.FieldAccessCount;
		vector.TargetExpressionCount = targetData.ExpressionCount;
		vector.TargetDistinctTypeCount = targetData.DistinctTypeCount;
		vector.TargetObjectCreationCount = targetData.ObjectCreationCount;
		vector.TargetIfCount = targetData.IfCount;
		vector.TargetSuperCallCount = targetData.SuperCallCount;
		vector.TargetReturnCount = targetData.ReturnCount;
		vector.TargetTryStatementCount = targetData.TryStatementCount;		
		
		vector.TargetConstructorParameters = targetData.ConstructorParameter;
		vector.TargetArrayCreationCount = targetData.ArrayCreationCount;
		vector.TargetTokenCount = targetData.TokenCount;
		
		vector.TargetCastExpressionCount = targetData.CastExpressionCount;
		vector.TargetIsStatic = targetData.IsStatic;
		vector.TargetIsAbstract = targetData.IsAbstract;
		vector.TargetIsPublic = targetData.IsPublic;
		vector.TargetIsPrivate = targetData.IsPrivate;
		vector.TargetIsProtected = targetData.IsProtected;
		vector.TargetIsFinal = targetData.IsFinal;
		vector.TargetIsSynchronized = targetData.IsSynchronized;
		vector.TargetMethodTypeLength = targetData.MethodTypeLength;		
		
		vector.TargetassignmentInFor = targetData.assignmentInFor;
		vector.TargetassignmentInForeach = targetData.assignmentInForeach;
		vector.TargetassignmentInIf = targetData.assignmentInIf;
		vector.TargetassignmentInSwitch = targetData.assignmentInSwitch;
		vector.TargetassignmentInTry = targetData.assignmentInTry;
		vector.TargetassignmentInWhile = targetData.assignmentInWhile;
		vector.TargetdeclarationInFor = targetData.declarationInFor;
		vector.TargetdeclarationInForeach = targetData.declarationInForeach;
		vector.TargetdeclarationInIf = targetData.declarationInIf;
		vector.TargetdeclarationInSwitch = targetData.declarationInSwitch;
		vector.TargetdeclarationInTry = targetData.declarationInTry;
		vector.TargetdeclarationInWhile = targetData.declarationInWhile;
		
		vector.TargetvariableDeclarationWithAssignment = targetData.variableDeclarationWithAssignment;
		vector.TargetvariableDeclarationWithoutAssignment = targetData.variableDeclarationWithoutAssignment;
		vector.TargetintegerLiteralExpression = targetData.integerLiteralExpression;
		vector.TargetbinaryExpression = targetData.binaryExpression;
		vector.TargetprimitiveType = targetData.primitiveType;
		vector.TargetlineComment = targetData.lineComment;
		vector.TargetarrayType = targetData.arrayType;
		
		vector.TargetmethodOverrides = targetData.methodOverrides;
		vector.TargetnameExpressions = targetData.nameExpressions;
		vector.TargetsimpleNames = targetData.simpleNames;
		vector.Targetmodifiers = targetData.modifiers;
		vector.TargetsubParameters = targetData.subParameters;
		vector.TargetmarkerAnnotations = targetData.markerAnnotations;
		vector.TargetblockStatements = targetData.blockStatements;
		vector.TargetnullLiterals = targetData.nullLiterals;
		vector.TargetthrowStatements = targetData.throwStatements;
		
		vector.TargetforStatementCount = targetData.forStatementCount;
		vector.TargetforeachStatementCount = targetData.foreachStatementCount;
		vector.TargetwhileStatementCount = targetData.whileStatementCount;
		vector.TargetprimitiveTypes = targetData.primitiveTypes;
		vector.TargetclassInterfaceTypes = targetData.classInterfaceTypes;
		
		vector.TargetDoStmt = targetData.DoStmt;
		vector.TargetAssertStmt = targetData.AssertStmt;
		vector.TargetDoubleLiteralExpr = targetData.DoubleLiteralExpr;
		vector.TargetBooleanLiteralExpr = targetData.BooleanLiteralExpr;
		vector.TargetCharLiteralExpr = targetData.CharLiteralExpr;
		vector.TargetStringLiteralExpr = targetData.StringLiteralExpr;
		vector.TargetArrayAccessExpr = targetData.ArrayAccessExpr;
		vector.TargetConditionalExpr = targetData.ConditionalExpr;
		vector.TargetEnclosedExpr = targetData.EnclosedExpr;
		vector.TargetInstanceOfExpr = targetData.InstanceOfExpr;
		vector.TargetLambdaExpr = targetData.LambdaExpr;
		vector.TargetLiteralExpr = targetData.LiteralExpr;
		vector.TargetLongLiteralExpr = targetData.LongLiteralExpr;
		vector.TargetMethodReferenceExpr = targetData.MethodReferenceExpr;
		vector.TargetNormalAnnotationExpr = targetData.NormalAnnotationExpr;
		vector.TargetPatternExpr = targetData.PatternExpr;
		vector.TargetSingleMemberAnnotationExpr = targetData.SingleMemberAnnotationExpr;
		vector.TargetThisExpr = targetData.ThisExpr;
		vector.TargetTypeExpr = targetData.TypeExpr;
		vector.TargetUnaryExpr = targetData.UnaryExpr;
		vector.TargetBreakStmt = targetData.BreakStmt;
		vector.TargetContinueStmt = targetData.ContinueStmt;
		vector.TargetYieldStmt = targetData.YieldStmt;
		
		//
		vector.Difference = GetVectorDifference(sourceData, targetData);
		
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
				setValue(SourceParameterCount, f.SourceParameterCount);
				setValue(SourceConstructorCallCount, f.SourceConstructorCallCount);
				setValue(SourceCatchClauseCount, f.SourceCatchClauseCount);
				setValue(SourceMethodCallCount, f.SourceMethodCallCount);
				setValue(SourceFieldAccessCount, f.SourceFieldAccessCount);
				setValue(SourceObjectCreationCount, f.SourceObjectCreationCount);
				setValue(SourceSuperCallCount, f.SourceSuperCallCount);
				
				setValue(SourceConstructorParameters, f.SourceConstructorParameters);
				setValue(SourceArrayCreationCount, f.SourceArrayCreationCount);
				setValue(SourceTokenCount, f.SourceTokenCount);
				
				setValue(SourceCastExpressionCount, f.SourceCastExpressionCount);
				setValue(SourceIsStatic, f.SourceIsStatic);
				setValue(SourceIsAbstract, f.SourceIsAbstract);
				setValue(SourceIsPublic, f.SourceIsPublic);
				setValue(SourceIsPrivate, f.SourceIsPrivate);
				setValue(SourceIsProtected, f.SourceIsProtected);
				setValue(SourceIsFinal, f.SourceIsFinal);
				setValue(SourceIsSynchronized, f.SourceIsSynchronized);
				setValue(SourceMethodTypeLength, f.SourceMethodTypeLength);
				
				setValue(SourceassignmentInFor, f.SourceassignmentInFor);
				setValue(SourceassignmentInForeach, f.SourceassignmentInForeach);
				setValue(SourceassignmentInIf, f.SourceassignmentInIf);
				setValue(SourceassignmentInSwitch, f.SourceassignmentInSwitch);
				setValue(SourceassignmentInTry, f.SourceassignmentInTry);
				setValue(SourceassignmentInWhile, f.SourceassignmentInWhile);
				setValue(SourcedeclarationInFor, f.SourcedeclarationInFor);
				setValue(SourcedeclarationInForeach, f.SourcedeclarationInForeach);
				setValue(SourcedeclarationInIf, f.SourcedeclarationInIf);
				setValue(SourcedeclarationInSwitch, f.SourcedeclarationInSwitch);
				setValue(SourcedeclarationInTry, f.SourcedeclarationInTry);
				setValue(SourcedeclarationInWhile, f.SourcedeclarationInWhile);
				
				setValue(SourcevariableDeclarationWithAssignment, f.SourcevariableDeclarationWithAssignment);
				setValue(SourcevariableDeclarationWithoutAssignment, f.SourcevariableDeclarationWithoutAssignment);
				setValue(SourceintegerLiteralExpression, f.SourceintegerLiteralExpression);
				setValue(SourcebinaryExpression, f.SourcebinaryExpression);
				setValue(SourceprimitiveType, f.SourceprimitiveType);
				setValue(SourcelineComment, f.SourcelineComment);
				setValue(SourcearrayType, f.SourcearrayType);
				
				setValue(SourcemethodOverrides, f.SourcemethodOverrides);
				setValue(SourcenameExpressions, f.SourcenameExpressions);
				setValue(SourcesimpleNames, f.SourcesimpleNames);
				setValue(Sourcemodifiers, f.Sourcemodifiers);
				setValue(SourcesubParameters, f.SourcesubParameters);
				setValue(SourcemarkerAnnotations, f.SourcemarkerAnnotations);
				setValue(SourceblockStatements, f.SourceblockStatements);
				setValue(SourcenullLiterals, f.SourcenullLiterals);
				setValue(SourcethrowStatements, f.SourcethrowStatements);
				
				setValue(SourceforStatementCount, f.SourceforStatementCount);
				setValue(SourceforeachStatementCount, f.SourceforeachStatementCount);
				setValue(SourcewhileStatementCount, f.SourcewhileStatementCount);
				setValue(SourceprimitiveTypes, f.SourceprimitiveTypes);
				setValue(SourceclassInterfaceTypes, f.SourceclassInterfaceTypes);
				
				setValue(SourceDoStmt, f.SourceDoStmt);
				setValue(SourceAssertStmt, f.SourceAssertStmt);
				setValue(SourceDoubleLiteralExpr, f.SourceDoubleLiteralExpr);
				setValue(SourceBooleanLiteralExpr, f.SourceBooleanLiteralExpr);
				setValue(SourceCharLiteralExpr, f.SourceCharLiteralExpr);
				setValue(SourceStringLiteralExpr, f.SourceStringLiteralExpr);
				setValue(SourceArrayAccessExpr, f.SourceArrayAccessExpr);
				setValue(SourceConditionalExpr, f.SourceConditionalExpr);
				setValue(SourceEnclosedExpr, f.SourceEnclosedExpr);
				setValue(SourceInstanceOfExpr, f.SourceInstanceOfExpr);
				setValue(SourceLambdaExpr, f.SourceLambdaExpr);
				setValue(SourceLiteralExpr, f.SourceLiteralExpr);
				setValue(SourceLongLiteralExpr, f.SourceLongLiteralExpr);
				setValue(SourceMethodReferenceExpr, f.SourceMethodReferenceExpr);
				setValue(SourceNormalAnnotationExpr, f.SourceNormalAnnotationExpr);
				setValue(SourcePatternExpr, f.SourcePatternExpr);
				setValue(SourceSingleMemberAnnotationExpr, f.SourceSingleMemberAnnotationExpr);
				setValue(SourceThisExpr, f.SourceThisExpr);
				setValue(SourceTypeExpr, f.SourceTypeExpr);
				setValue(SourceUnaryExpr, f.SourceUnaryExpr);
				setValue(SourceBreakStmt, f.SourceBreakStmt);
				setValue(SourceContinueStmt, f.SourceContinueStmt);
				setValue(SourceYieldStmt, f.SourceYieldStmt);
				
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
				setValue(TargetParameterCount, f.TargetParameterCount);
				setValue(TargetConstructorCallCount, f.TargetConstructorCallCount);
				setValue(TargetCatchClauseCount, f.TargetCatchClauseCount);
				setValue(TargetMethodCallCount, f.TargetMethodCallCount);
				setValue(TargetFieldAccessCount, f.TargetFieldAccessCount);
				setValue(TargetObjectCreationCount, f.TargetObjectCreationCount);
				setValue(TargetSuperCallCount, f.TargetSuperCallCount);				
				
				setValue(TargetConstructorParameters, f.TargetConstructorParameters);
				setValue(TargetArrayCreationCount, f.TargetArrayCreationCount);
				setValue(TargetTokenCount, f.TargetTokenCount);
				
				setValue(TargetCastExpressionCount, f.TargetCastExpressionCount);
				setValue(TargetIsStatic, f.TargetIsStatic);
				setValue(TargetIsAbstract, f.TargetIsAbstract);
				setValue(TargetIsPublic, f.TargetIsPublic);
				setValue(TargetIsPrivate, f.TargetIsPrivate);
				setValue(TargetIsProtected, f.TargetIsProtected);
				setValue(TargetIsFinal, f.TargetIsFinal);
				setValue(TargetIsSynchronized, f.TargetIsSynchronized);
				setValue(TargetMethodTypeLength, f.TargetMethodTypeLength);		
				
				setValue(TargetassignmentInFor, f.TargetassignmentInFor);
				setValue(TargetassignmentInForeach, f.TargetassignmentInForeach);
				setValue(TargetassignmentInIf, f.TargetassignmentInIf);
				setValue(TargetassignmentInSwitch, f.TargetassignmentInSwitch);
				setValue(TargetassignmentInTry, f.TargetassignmentInTry);
				setValue(TargetassignmentInWhile, f.TargetassignmentInWhile);
				setValue(TargetdeclarationInFor, f.TargetdeclarationInFor);
				setValue(TargetdeclarationInForeach, f.TargetdeclarationInForeach);
				setValue(TargetdeclarationInIf, f.TargetdeclarationInIf);
				setValue(TargetdeclarationInSwitch, f.TargetdeclarationInSwitch);
				setValue(TargetdeclarationInTry, f.TargetdeclarationInTry);
				setValue(TargetdeclarationInWhile, f.TargetdeclarationInWhile);
				
				setValue(TargetvariableDeclarationWithAssignment, f.TargetvariableDeclarationWithAssignment);
				setValue(TargetvariableDeclarationWithoutAssignment, f.TargetvariableDeclarationWithoutAssignment);
				setValue(TargetintegerLiteralExpression, f.TargetintegerLiteralExpression);
				setValue(TargetbinaryExpression, f.TargetbinaryExpression);
				setValue(TargetprimitiveType, f.TargetprimitiveType);
				setValue(TargetlineComment, f.TargetlineComment);
				setValue(TargetarrayType, f.TargetarrayType);
				
				setValue(TargetmethodOverrides, f.TargetmethodOverrides);
				setValue(TargetnameExpressions, f.TargetnameExpressions);
				setValue(TargetsimpleNames, f.TargetsimpleNames);
				setValue(Targetmodifiers, f.Targetmodifiers);
				setValue(TargetsubParameters, f.TargetsubParameters);
				setValue(TargetmarkerAnnotations, f.TargetmarkerAnnotations);
				setValue(TargetblockStatements, f.TargetblockStatements);
				setValue(TargetnullLiterals, f.TargetnullLiterals);
				setValue(TargetthrowStatements, f.TargetthrowStatements);
				
				setValue(TargetforStatementCount, f.TargetforStatementCount);
				setValue(TargetforeachStatementCount, f.TargetforeachStatementCount);
				setValue(TargetwhileStatementCount, f.TargetwhileStatementCount);
				setValue(TargetprimitiveTypes, f.TargetprimitiveTypes);
				setValue(TargetclassInterfaceTypes, f.TargetclassInterfaceTypes);
				
				setValue(TargetDoStmt, f.TargetDoStmt);
				setValue(TargetAssertStmt, f.TargetAssertStmt);
				setValue(TargetDoubleLiteralExpr, f.TargetDoubleLiteralExpr);
				setValue(TargetBooleanLiteralExpr, f.TargetBooleanLiteralExpr);
				setValue(TargetCharLiteralExpr, f.TargetCharLiteralExpr);
				setValue(TargetStringLiteralExpr, f.TargetStringLiteralExpr);
				setValue(TargetArrayAccessExpr, f.TargetArrayAccessExpr);
				setValue(TargetConditionalExpr, f.TargetConditionalExpr);
				setValue(TargetEnclosedExpr, f.TargetEnclosedExpr);
				setValue(TargetInstanceOfExpr, f.TargetInstanceOfExpr);
				setValue(TargetLambdaExpr, f.TargetLambdaExpr);
				setValue(TargetLiteralExpr, f.TargetLiteralExpr);
				setValue(TargetLongLiteralExpr, f.TargetLongLiteralExpr);
				setValue(TargetMethodReferenceExpr, f.TargetMethodReferenceExpr);
				setValue(TargetNormalAnnotationExpr, f.TargetNormalAnnotationExpr);
				setValue(TargetPatternExpr, f.TargetPatternExpr);
				setValue(TargetSingleMemberAnnotationExpr, f.TargetSingleMemberAnnotationExpr);
				setValue(TargetThisExpr, f.TargetThisExpr);
				setValue(TargetTypeExpr, f.TargetTypeExpr);
				setValue(TargetUnaryExpr, f.TargetUnaryExpr);
				setValue(TargetBreakStmt, f.TargetBreakStmt);
				setValue(TargetContinueStmt, f.TargetContinueStmt);
				setValue(TargetYieldStmt, f.TargetYieldStmt);

				
				//
				setValue(Difference, f.Difference);
	    	}
	    };
		
	    newCloneInstance.setDataset(featureVector);

        // Return the single instance
		return newCloneInstance;
	}	
	public int GetVectorDifference(Features sourceData, Features targetData)
	{
		int difference = 0;
		
        difference += Math.abs(sourceData.MethodLength - targetData.MethodLength);
		difference += Math.abs(sourceData.ParameterCount - targetData.ParameterCount);
		difference += Math.abs(sourceData.DeclaredVariableCount - targetData.DeclaredVariableCount);
		difference += Math.abs(sourceData.ConstructorCallCount - targetData.ConstructorCallCount);
		difference += Math.abs(sourceData.CatchClauseCount - targetData.CatchClauseCount);
		difference += Math.abs(sourceData.SwitchCount - targetData.SwitchCount);
		difference += Math.abs(sourceData.CaseCount - targetData.CaseCount);
		difference += Math.abs(sourceData.IteratorCount - targetData.IteratorCount);
		difference += Math.abs(sourceData.AssignmentCount - targetData.AssignmentCount);
		difference += Math.abs(sourceData.MethodCallCount - targetData.MethodCallCount);
		difference += Math.abs(sourceData.FieldAccessCount - targetData.FieldAccessCount);
		difference += Math.abs(sourceData.ExpressionCount - targetData.ExpressionCount);
		difference += Math.abs(sourceData.DistinctTypeCount - targetData.DistinctTypeCount);
		difference += Math.abs(sourceData.ObjectCreationCount - targetData.ObjectCreationCount);
		difference += Math.abs(sourceData.IfCount - targetData.IfCount);
		difference += Math.abs(sourceData.SuperCallCount - targetData.SuperCallCount);
		difference += Math.abs(sourceData.ReturnCount - targetData.ReturnCount);
		difference += Math.abs(sourceData.TryStatementCount - targetData.TryStatementCount);
		difference += Math.abs(sourceData.ConstructorParameter - targetData.ConstructorParameter);
		difference += Math.abs(sourceData.ArrayCreationCount - targetData.ArrayCreationCount);
		difference += Math.abs(sourceData.TokenCount - targetData.TokenCount);
		difference += Math.abs(sourceData.CastExpressionCount - targetData.CastExpressionCount);
		difference += Math.abs(sourceData.IsStatic - targetData.IsStatic);
		difference += Math.abs(sourceData.IsAbstract - targetData.IsAbstract);
		difference += Math.abs(sourceData.IsPublic - targetData.IsPublic);
		difference += Math.abs(sourceData.IsPrivate - targetData.IsPrivate);
		difference += Math.abs(sourceData.IsProtected - targetData.IsProtected);
		difference += Math.abs(sourceData.IsFinal - targetData.IsFinal);
		difference += Math.abs(sourceData.IsSynchronized - targetData.IsSynchronized);
		difference += Math.abs(sourceData.MethodTypeLength - targetData.MethodTypeLength);
		difference += Math.abs(sourceData.assignmentInFor - targetData.assignmentInFor);
		difference += Math.abs(sourceData.assignmentInForeach - targetData.assignmentInForeach);
		difference += Math.abs(sourceData.assignmentInIf - targetData.assignmentInIf);
		difference += Math.abs(sourceData.assignmentInSwitch - targetData.assignmentInSwitch);
		difference += Math.abs(sourceData.assignmentInTry - targetData.assignmentInTry);
		difference += Math.abs(sourceData.assignmentInWhile - targetData.assignmentInWhile);
		difference += Math.abs(sourceData.declarationInFor - targetData.declarationInFor);
		difference += Math.abs(sourceData.declarationInForeach - targetData.declarationInForeach);
		difference += Math.abs(sourceData.declarationInIf - targetData.declarationInIf);
		difference += Math.abs(sourceData.declarationInSwitch - targetData.declarationInSwitch);
		difference += Math.abs(sourceData.declarationInTry - targetData.declarationInTry);
		difference += Math.abs(sourceData.declarationInWhile - targetData.declarationInWhile);
		difference += Math.abs(sourceData.variableDeclarationWithAssignment - targetData.variableDeclarationWithAssignment);
		difference += Math.abs(sourceData.variableDeclarationWithoutAssignment - targetData.variableDeclarationWithoutAssignment);
		difference += Math.abs(sourceData.integerLiteralExpression - targetData.integerLiteralExpression);
		difference += Math.abs(sourceData.binaryExpression - targetData.binaryExpression);
		difference += Math.abs(sourceData.primitiveType - targetData.primitiveType);
		difference += Math.abs(sourceData.lineComment - targetData.lineComment);
		difference += Math.abs(sourceData.arrayType - targetData.arrayType);
		difference += Math.abs(sourceData.methodOverrides - targetData.methodOverrides);
		difference += Math.abs(sourceData.nameExpressions - targetData.nameExpressions);
		difference += Math.abs(sourceData.simpleNames - targetData.simpleNames);
		difference += Math.abs(sourceData.modifiers - targetData.modifiers);
		difference += Math.abs(sourceData.subParameters - targetData.subParameters);
		difference += Math.abs(sourceData.markerAnnotations - targetData.markerAnnotations);
		difference += Math.abs(sourceData.blockStatements - targetData.blockStatements);
		difference += Math.abs(sourceData.nullLiterals - targetData.nullLiterals);
		difference += Math.abs(sourceData.throwStatements - targetData.throwStatements);
		difference += Math.abs(sourceData.forStatementCount - targetData.forStatementCount);
		difference += Math.abs(sourceData.foreachStatementCount - targetData.foreachStatementCount);
		difference += Math.abs(sourceData.whileStatementCount - targetData.whileStatementCount);
		difference += Math.abs(sourceData.primitiveTypes - targetData.primitiveTypes);
		difference += Math.abs(sourceData.classInterfaceTypes - targetData.classInterfaceTypes);
		
		difference += Math.abs(sourceData.DoStmt - targetData.DoStmt);
		difference += Math.abs(sourceData.AssertStmt - targetData.AssertStmt);
		difference += Math.abs(sourceData.DoubleLiteralExpr - targetData.DoubleLiteralExpr);
		difference += Math.abs(sourceData.BooleanLiteralExpr - targetData.BooleanLiteralExpr);
		difference += Math.abs(sourceData.CharLiteralExpr - targetData.CharLiteralExpr);
		difference += Math.abs(sourceData.StringLiteralExpr - targetData.StringLiteralExpr);
		difference += Math.abs(sourceData.ArrayAccessExpr - targetData.ArrayAccessExpr);
		difference += Math.abs(sourceData.ConditionalExpr - targetData.ConditionalExpr);
		difference += Math.abs(sourceData.EnclosedExpr - targetData.EnclosedExpr);
		difference += Math.abs(sourceData.InstanceOfExpr - targetData.InstanceOfExpr);
		difference += Math.abs(sourceData.LambdaExpr - targetData.LambdaExpr);
		difference += Math.abs(sourceData.LiteralExpr - targetData.LiteralExpr);
		difference += Math.abs(sourceData.LongLiteralExpr - targetData.LongLiteralExpr);
		difference += Math.abs(sourceData.MethodReferenceExpr - targetData.MethodReferenceExpr);
		difference += Math.abs(sourceData.NormalAnnotationExpr - targetData.NormalAnnotationExpr);
		difference += Math.abs(sourceData.PatternExpr - targetData.PatternExpr);
		difference += Math.abs(sourceData.SingleMemberAnnotationExpr - targetData.SingleMemberAnnotationExpr);
		difference += Math.abs(sourceData.ThisExpr - targetData.ThisExpr);
		difference += Math.abs(sourceData.TypeExpr - targetData.TypeExpr);
		difference += Math.abs(sourceData.UnaryExpr - targetData.UnaryExpr);
		difference += Math.abs(sourceData.BreakStmt - targetData.BreakStmt);
		difference += Math.abs(sourceData.ContinueStmt - targetData.ContinueStmt);
		difference += Math.abs(sourceData.YieldStmt - targetData.YieldStmt);
		
		return difference;
	}
}
