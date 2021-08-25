package models;

import java.io.Serializable;

/**
 * 
 * All features identified for a method
 * 
 * @author Halit U
 *
 */

public class Features implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String FullPath;
	public String Directory;
	public String Filename;
	public int LineBegin;
	public int LineEnd;
	public int MethodLength;
	public int ParameterCount;
	public int DeclaredVariableCount;
	public int ConstructorCallCount;
	public int CatchClauseCount;
	public int SwitchCount;
	public int CaseCount;
	public int IteratorCount;
	public int AssignmentCount;
	public int MethodCallCount;
	public int FieldAccessCount;
	public int ExpressionCount;
	public int DistinctTypeCount;
	public int ObjectCreationCount;
	public int IfCount;
	public int SuperCallCount;
	public int ReturnCount;
	public int TryStatementCount;
	
	public int ConstructorParameter;
	public int ArrayCreationCount;
	public int TokenCount;
	
	public int CastExpressionCount;
	public int IsStatic;
	public int IsAbstract;
	public int IsPublic;
	public int IsPrivate;
	public int IsProtected;
	public int IsFinal;
	public int IsSynchronized;
	public int MethodTypeLength;
	
	public int assignmentInFor;
	public int assignmentInForeach;
	public int assignmentInIf;
	public int assignmentInSwitch;
	public int assignmentInTry;
	public int assignmentInWhile;

	public int declarationInFor;
	public int declarationInForeach;
	public int declarationInIf;
	public int declarationInSwitch;
	public int declarationInTry;
	public int declarationInWhile;	

	public int variableDeclarationWithAssignment;
	public int variableDeclarationWithoutAssignment;
	public int integerLiteralExpression;
	public int binaryExpression;
	public int primitiveType;
	public int lineComment;
	public int arrayType;

	public int methodOverrides;
	public int nameExpressions;
	public int simpleNames;
	public int modifiers;
	public int subParameters;
	public int markerAnnotations;
	public int blockStatements;
	public int nullLiterals;
	public int throwStatements;
	
	public int forStatementCount;
	public int foreachStatementCount;
	public int whileStatementCount;
	public int primitiveTypes;
	public int classInterfaceTypes;

	public int DoStmt;
	public int AssertStmt;
	public int DoubleLiteralExpr;
	public int BooleanLiteralExpr;
	public int CharLiteralExpr;
	public int StringLiteralExpr;
	public int ArrayAccessExpr;
	public int ConditionalExpr;
	public int EnclosedExpr;
	public int InstanceOfExpr;
	public int LambdaExpr;
	public int LiteralExpr;
	public int LongLiteralExpr;
	public int MethodReferenceExpr;
	public int NormalAnnotationExpr;
	public int PatternExpr;
	public int SingleMemberAnnotationExpr;
	public int ThisExpr;
	public int TypeExpr;
	public int UnaryExpr;
	public int BreakStmt;
	public int ContinueStmt;
	public int YieldStmt;	
	
}





