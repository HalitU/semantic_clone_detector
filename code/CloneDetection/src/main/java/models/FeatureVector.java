package models;

import java.io.Serializable;

/**
 * 
 * Feature vector used in creating instances for the user input when the tool
 * is called manually.
 * 
 * @author Halit U
 *
 */
public class FeatureVector implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Source
	public String SourceFullPath;
	public String SourceDirectory;
	public String SourceFilename;
	public int SourceLineBegin;
	public int SourceLineEnd;
	public int SourceMethodLength;
	public int SourceParameterCount;
	public int SourceDeclaredVariableCount;
	public int SourceConstructorCallCount;
	public int SourceCatchClauseCount;
	public int SourceSwitchCount;
	public int SourceCaseCount;
	public int SourceIteratorCount;
	public int SourceAssignmentCount;
	public int SourceMethodCallCount;
	public int SourceFieldAccessCount;
	public int SourceExpressionCount;
	public int SourceDistinctTypeCount;
	public int SourceObjectCreationCount;
	public int SourceIfCount;
	public int SourceSuperCallCount;
	public int SourceReturnCount;
	public int SourceTryStatementCount;
	
	public int SourceConstructorParameters;
	public int SourceArrayCreationCount;
	public int SourceTokenCount;
	
	public int SourceCastExpressionCount;
	public int SourceIsStatic;
	public int SourceIsAbstract;
	public int SourceIsPublic;
	public int SourceIsPrivate;
	public int SourceIsProtected;
	public int SourceIsFinal;
	public int SourceIsSynchronized;
	public int SourceMethodTypeLength;
	
	public int SourceassignmentInFor;
	public int SourceassignmentInForeach;
	public int SourceassignmentInIf;
	public int SourceassignmentInSwitch;
	public int SourceassignmentInTry;
	public int SourceassignmentInWhile;
	public int SourcedeclarationInFor;
	public int SourcedeclarationInForeach;
	public int SourcedeclarationInIf;
	public int SourcedeclarationInSwitch;
	public int SourcedeclarationInTry;
	public int SourcedeclarationInWhile;
	
	public int SourcevariableDeclarationWithAssignment;
	public int SourcevariableDeclarationWithoutAssignment;
	public int SourceintegerLiteralExpression;
	public int SourcebinaryExpression;
	public int SourceprimitiveType;
	public int SourcelineComment;
	public int SourcearrayType;
	
	public int SourcemethodOverrides;
	public int SourcenameExpressions;
	public int SourcesimpleNames;
	public int Sourcemodifiers;
	public int SourcesubParameters;
	public int SourcemarkerAnnotations;
	public int SourceblockStatements;
	public int SourcenullLiterals;
	public int SourcethrowStatements;
	
	public int SourceforStatementCount;
	public int SourceforeachStatementCount;
	public int SourcewhileStatementCount;
	public int SourceprimitiveTypes;
	public int SourceclassInterfaceTypes;
	
	public int SourceDoStmt;
	public int SourceAssertStmt;
	public int SourceDoubleLiteralExpr;
	public int SourceBooleanLiteralExpr;
	public int SourceCharLiteralExpr;
	public int SourceStringLiteralExpr;
	public int SourceArrayAccessExpr;
	public int SourceConditionalExpr;
	public int SourceEnclosedExpr;
	public int SourceInstanceOfExpr;
	public int SourceLambdaExpr;
	public int SourceLiteralExpr;
	public int SourceLongLiteralExpr;
	public int SourceMethodReferenceExpr;
	public int SourceNormalAnnotationExpr;
	public int SourcePatternExpr;
	public int SourceSingleMemberAnnotationExpr;
	public int SourceThisExpr;
	public int SourceTypeExpr;
	public int SourceUnaryExpr;
	public int SourceBreakStmt;
	public int SourceContinueStmt;
	public int SourceYieldStmt;
	
	// Target
	public String TargetFullPath;
	public String TargetDirectory;
	public String TargetFilename;
	public int TargetLineBegin;
	public int TargetLineEnd;
	public int TargetMethodLength;
	public int TargetParameterCount;
	public int TargetDeclaredVariableCount;
	public int TargetConstructorCallCount;
	public int TargetCatchClauseCount;
	public int TargetSwitchCount;
	public int TargetCaseCount;
	public int TargetIteratorCount;
	public int TargetAssignmentCount;
	public int TargetMethodCallCount;
	public int TargetFieldAccessCount;
	public int TargetExpressionCount;
	public int TargetDistinctTypeCount;
	public int TargetObjectCreationCount;
	public int TargetIfCount;
	public int TargetSuperCallCount;
	public int TargetReturnCount;
	public int TargetTryStatementCount;
	
	public int TargetConstructorParameters;
	public int TargetArrayCreationCount;
	public int TargetTokenCount;
	
	public int TargetCastExpressionCount;
	public int TargetIsStatic;
	public int TargetIsAbstract;
	public int TargetIsPublic;
	public int TargetIsPrivate;
	public int TargetIsProtected;
	public int TargetIsFinal;
	public int TargetIsSynchronized;
	public int TargetMethodTypeLength;	
	
	public int TargetassignmentInFor;
	public int TargetassignmentInForeach;
	public int TargetassignmentInIf;
	public int TargetassignmentInSwitch;
	public int TargetassignmentInTry;
	public int TargetassignmentInWhile;
	public int TargetdeclarationInFor;
	public int TargetdeclarationInForeach;
	public int TargetdeclarationInIf;
	public int TargetdeclarationInSwitch;
	public int TargetdeclarationInTry;
	public int TargetdeclarationInWhile;
	
	public int TargetvariableDeclarationWithAssignment;
	public int TargetvariableDeclarationWithoutAssignment;
	public int TargetintegerLiteralExpression;
	public int TargetbinaryExpression;
	public int TargetprimitiveType;
	public int TargetlineComment;
	public int TargetarrayType;

	public int TargetmethodOverrides;
	public int TargetnameExpressions;
	public int TargetsimpleNames;
	public int Targetmodifiers;
	public int TargetsubParameters;
	public int TargetmarkerAnnotations;
	public int TargetblockStatements;
	public int TargetnullLiterals;
	public int TargetthrowStatements;
	
	public int TargetforStatementCount;
	public int TargetforeachStatementCount;
	public int TargetwhileStatementCount;
	public int TargetprimitiveTypes;
	public int TargetclassInterfaceTypes;

	public int TargetDoStmt;
	public int TargetAssertStmt;
	public int TargetDoubleLiteralExpr;
	public int TargetBooleanLiteralExpr;
	public int TargetCharLiteralExpr;
	public int TargetStringLiteralExpr;
	public int TargetArrayAccessExpr;
	public int TargetConditionalExpr;
	public int TargetEnclosedExpr;
	public int TargetInstanceOfExpr;
	public int TargetLambdaExpr;
	public int TargetLiteralExpr;
	public int TargetLongLiteralExpr;
	public int TargetMethodReferenceExpr;
	public int TargetNormalAnnotationExpr;
	public int TargetPatternExpr;
	public int TargetSingleMemberAnnotationExpr;
	public int TargetThisExpr;
	public int TargetTypeExpr;
	public int TargetUnaryExpr;
	public int TargetBreakStmt;
	public int TargetContinueStmt;
	public int TargetYieldStmt;
	
	//
	public int Difference;
}
