package extraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.JavaToken;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.ArrayCreationExpr;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.CharLiteralExpr;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.DoubleLiteralExpr;
import com.github.javaparser.ast.expr.EnclosedExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.InstanceOfExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.LiteralExpr;
import com.github.javaparser.ast.expr.LongLiteralExpr;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.MethodReferenceExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.NullLiteralExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.PatternExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.SuperExpr;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.expr.TypeExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.AssertStmt;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.BreakStmt;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.stmt.ContinueStmt;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.SwitchEntry;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.github.javaparser.ast.stmt.YieldStmt;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.printer.YamlPrinter;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import models.Features;

/**
 * 
 * Main feature fetching class from java files
 * 
 * @author Halit U
 *
 */
public class ASTUtils {
	// YamlPrinter is good to have for beautifying javaparser output
    @SuppressWarnings("unused")
	private YamlPrinter printer;
    private int fetchCounter = 0;
    
    /**
     * Only method in this class
     * 
     * @param filePath
     * @param printOutput
     * @return
     * @throws IOException
     */
	public List<Features> FetchFeatures(String filePath, boolean printOutput) throws IOException
	{
		// Multiple methods can exists in a file obviously
		// Therefore method returns a list of features
		List<Features> allMethodFeatures = new ArrayList<Features>();
    	printer = new YamlPrinter(true);
    			
    	// Print every 250 files processed, this is useful for debugging
		fetchCounter++;
    	if (fetchCounter % 250 == 0) {
    		System.out.println("[" + fetchCounter + "] Fetching features for: " + filePath);
    	}
    	
        // Set up a minimal type solver that only looks at the classes used to run this sample.
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        // Configure JavaParser to use type resolution
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
        
        // Get the file of the source code
        File sourceCode = new File(filePath);
        
        // Get subdirectory of the file location, required by clone database for matching
        String subdirectory = sourceCode.getParentFile().getName();
        String fullpath = sourceCode.getAbsolutePath();
        
        JavaParser codeParser = new JavaParser();
       
        // Parse some code
        CompilationUnit cu;
		try {
			cu = codeParser.parse(sourceCode).getResult().get();
						
	        // Get all methods in that file
	        List<MethodDeclaration> methods = cu.findAll(MethodDeclaration.class);
	        

	        for (MethodDeclaration methodDeclaration : methods) {
	        	/**
	        	 * YAML EXAMPLE for printing the tree-view of a method in a decent way.
	        	System.out.println(methodDeclaration);
	        	System.out.println(printer.output(methodDeclaration));		
	        	System.exit(0);
	        	 */

		        // Get block location to compare results with bigeval data
		        int beginPosition = methodDeclaration.getBegin().get().line;
		        int endPosition = methodDeclaration.getEnd().get().line;
		        
		        
				// Calculate line of codes
				int methodBodyLength = methodDeclaration.getRange().map(range -> range.getLineCount()).orElse(0);
	        	
	        	// Number of parameters
	        	int parameterCount = methodDeclaration.getParameters().size();
	        	
	        	// Number of variable declarations
	        	int variableDeclarationCount = methodDeclaration.findAll(VariableDeclarator.class).size();
	        	
	        	// Number of constructor calls
	        	int constructorCallCount = 0;
	        	List<VariableDeclarator> variableDeclarations = methodDeclaration.findAll(VariableDeclarator.class);
	        	for (VariableDeclarator variableDeclaration : variableDeclarations) {
					int classConstructorCall = variableDeclaration.findAll(ClassOrInterfaceType.class).size();
					if (classConstructorCall > 0)
						constructorCallCount++;
				}
	        	
	        	// Number of try statements
	        	int tryStatementCount = methodDeclaration.findAll(TryStmt.class).size();
	        	
	        	// Number of catch statements
	        	int catchStatementCount = methodDeclaration.findAll(CatchClause.class).size();
	        	
	        	// Number of switch statements
	        	int switchStatementCount = methodDeclaration.findAll(SwitchStmt.class).size();
	        	
	        	// Number of cases in switch statements
	        	int switchCaseStatementCount = methodDeclaration.findAll(SwitchEntry.class).size();
	        	
	        	// Number of for, foreach, while statements
	        	int forStatementCount = methodDeclaration.findAll(ForStmt.class).size();
	        	int foreachStatementCount = methodDeclaration.findAll(ForEachStmt.class).size();
	        	int whileStatementCount = methodDeclaration.findAll(WhileStmt.class).size();
	        	int numberOfIterators = forStatementCount + foreachStatementCount + whileStatementCount;
	        	
	        	// Number of assignments
	        	int assignmentStatements = methodDeclaration.findAll(AssignExpr.class).size();
	        	
	        	// Number of method calls
	        	int methodCalls = methodDeclaration.findAll(MethodCallExpr.class).size();
	        	
	        	// Number of field accesses
	        	int fieldAccessCount = methodDeclaration.findAll(FieldAccessExpr.class).size();
	        	
	        	// Number of expressions
	        	int expressionCount = methodDeclaration.findAll(ExpressionStmt.class).size();
	        	
	        	// Number of different types
	        	// First get number of primitive types
	        	List<String> primitiveTypes = new ArrayList<String>();
	        	methodDeclaration.findAll(PrimitiveType.class).forEach(
	        			(node) -> { 
	        				String primitiveName = node.asPrimitiveType().getType().asString();
	        				if (!primitiveTypes.contains(primitiveName))
	        					primitiveTypes.add(primitiveName);
	        			});
	        		       	        	
	        	// then get the class or interface ones
	        	List<String> classInterfaceTypes = new ArrayList<String>();
	        	methodDeclaration.findAll(ClassOrInterfaceType.class).forEach((node) -> {
	        		String classInterfaceType = node.asClassOrInterfaceType().getNameAsString();
	        		if (!classInterfaceTypes.contains(classInterfaceType))
	        			classInterfaceTypes.add(classInterfaceType);
	        	});	        	
	        	
	        	int typeCount = primitiveTypes.size() + classInterfaceTypes.size();
	        	
	        	// Number of objects created
	        	int objectCreationCount = methodDeclaration.findAll(ObjectCreationExpr.class).size();
	        	
	        	// Number of if statements
	        	int ifStatementCount = methodDeclaration.findAll(IfStmt.class).size();
	        	
	        	// Number of super calls
	        	int superCalls = methodDeclaration.findAll(SuperExpr.class).size();
	        	
	        	// Number of return statement
	        	int returnStatementCount = methodDeclaration.findAll(ReturnStmt.class).size();

	        	// Number of tokens
	        	Iterator<JavaToken> it = methodDeclaration.getTokenRange().get().iterator();
	        	List<String> tokenList = new ArrayList<String>();
	        	while(it.hasNext())
	        	{
	        		String token =  it.next().asString();
	        		if(!token.equals(" ") && !token.equals("\n") && !token.equals("\t")) {
	        			// System.out.println(token);
	        			tokenList.add(token);	
	        		}
	        	}
	        	
	        	// Number of arguments in object creations
	        	int constructorParameters = 0;
	        	for (ObjectCreationExpr objectCreation : methodDeclaration.findAll(ObjectCreationExpr.class)) {
					constructorParameters += objectCreation.getArguments().size();
				}
	        	
	        	// Number of array creations
	        	int arrayCreation = methodDeclaration.findAll(ArrayCreationExpr.class).size();
	        	
	        	
	        	////////
	        	// Number of cast expressions
	        	int numberOfCasts = methodDeclaration.findAll(CastExpr.class).size();
	        	
	        	// Method type checks
	        	int isStatic = methodDeclaration.isStatic() ? 1 : 0;
	        	int isAbstract = methodDeclaration.isAbstract() ? 1 : 0; 
	        	int isPublic = methodDeclaration.isPublic() ? 1 : 0; 
	        	int isPrivate = methodDeclaration.isPrivate() ? 1 : 0; 
	        	int isProtected = methodDeclaration.isProtected() ? 1 : 0;
	        	int isFinal = methodDeclaration.isFinal() ? 1 : 0; 
	        	int isSynchronized = methodDeclaration.isSynchronized() ? 1 : 0; 
	        	
	        	// Methods return value string length (might not be so useful)
	        	int methodTypeLength = methodDeclaration.getTypeAsString().length();
	        	
	        	
	        	// Assignment count in try statements
	        	int assignmentInTry = 0;
	        	List<TryStmt> tryBlocks = methodDeclaration.findAll(TryStmt.class);
	        	for (TryStmt tryBlock : tryBlocks) {
	        		assignmentInTry += tryBlock.findAll(AssignExpr.class).size();
				}	        	
	        	
	        	// Assignment count in if statement
	        	int assignmentInIf = 0;
	        	List<IfStmt> ifBlocks = methodDeclaration.findAll(IfStmt.class);
	        	for (IfStmt ifStatement : ifBlocks) {
					assignmentInIf += ifStatement.findAll(AssignExpr.class).size(); 
				}
	        	
	        	// Assignment count in while statement
	        	int assignmentInWhile = 0;
	        	List<WhileStmt> whileBlocks = methodDeclaration.findAll(WhileStmt.class);
	        	for (WhileStmt whileStatement : whileBlocks) {
					assignmentInWhile += whileStatement.findAll(AssignExpr.class).size();
				}
	        	
	        	// Assignment count in switch statement
	        	int assignmentInSwitch = 0;
	        	List<SwitchStmt> switchBlocks = methodDeclaration.findAll(SwitchStmt.class);
	        	for (SwitchStmt	switchStatement	: switchBlocks) {
					assignmentInSwitch += switchStatement.findAll(AssignExpr.class).size();
				}
	        	
	        	// Assignment count in for statement
	        	int assignmentInFor = 0;
	        	List<ForStmt> forBlocks = methodDeclaration.findAll(ForStmt.class);
	        	for (ForStmt forStatement : forBlocks) {
					assignmentInFor += forStatement.findAll(AssignExpr.class).size();
				}
	        	
	        	// Assignment count in foreach statement
	        	int assignmentInForeach = 0;
	        	List<ForEachStmt> foreachBlocks = methodDeclaration.findAll(ForEachStmt.class);
	        	for (ForEachStmt foreachStatement : foreachBlocks) {
					assignmentInForeach += foreachStatement.findAll(AssignExpr.class).size();
				}
	        	
	        	// in try statements
	        	int declarationInTry = 0;
	        	for (TryStmt tryBlock : tryBlocks) {
	        		declarationInTry += tryBlock.findAll(VariableDeclarationExpr.class).size();
				}	        	
	        	
	        	// in if statement
	        	int declarationInIf = 0;
	        	for (IfStmt ifStatement : ifBlocks) {
					declarationInIf += ifStatement.findAll(VariableDeclarationExpr.class).size(); 
				}
	        	
	        	// in while statement
	        	int declarationInWhile = 0;
	        	for (WhileStmt whileStatement : whileBlocks) {
					declarationInWhile += whileStatement.findAll(VariableDeclarationExpr.class).size();
				}
	        	
	        	// in switch statement
	        	int declarationInSwitch = 0;
	        	for (SwitchStmt	switchStatement	: switchBlocks) {
					declarationInSwitch += switchStatement.findAll(VariableDeclarationExpr.class).size();
				}
	        	
	        	// in for statement
	        	int declarationInFor = 0;
	        	for (ForStmt forStatement : forBlocks) {
					declarationInFor += forStatement.findAll(VariableDeclarationExpr.class).size();
				}
	        	
	        	// in foreach statement
	        	int declarationInForeach = 0;
	        	for (ForEachStmt foreachStatement : foreachBlocks) {
					declarationInForeach += foreachStatement.findAll(VariableDeclarationExpr.class).size();
				}
	        		        	

	        	// VariableDeclarationExpr with - without assignment
	        	int variableDeclarationWithAssignment = 0;
	        	int variableDeclarationWithoutAssignment = 0;
	        	for (VariableDeclarationExpr variableDeclarationExpr : methodDeclaration.findAll(VariableDeclarationExpr.class)) {
	        		int declaration = variableDeclarationExpr.findAll(AssignExpr.class).size();
					if (declaration > 0)
						variableDeclarationWithAssignment += declaration;
					else
						variableDeclarationWithoutAssignment += 1;
				}
	        	
	        	// Integer literal expression
	        	int integerLiteralExpression = methodDeclaration.findAll(IntegerLiteralExpr.class).size();
	        	
	        	// Binary expression
	        	int binaryExpression = methodDeclaration.findAll(BinaryExpr.class).size();
	        	
	        	// Primitive type count
	        	int primitiveType = methodDeclaration.findAll(PrimitiveType.class).size();
	        	
	        	// Line comment count
	        	int lineComment = methodDeclaration.findAll(LineComment.class).size();
	        	
	        	// Array Type
	        	int arrayType = methodDeclaration.findAll(ArrayType.class).size();
	        		        	
	        	// Number of method declarations
	        	int methodOverrides = methodDeclaration.findAll(MethodDeclaration.class).size();
	        	
	        	// Number of name expressions
	        	int nameExpressions = methodDeclaration.findAll(NameExpr.class).size();
	        	
	        	// Number of simple names
	        	int simpleNames = methodDeclaration.findAll(SimpleName.class).size();
	        	
	        	// Number of modifiers
	        	int modifiers = methodDeclaration.findAll(Modifier.class).size();
	        	
	        	// Number of sub parameters
	        	int subParameters = methodDeclaration.findAll(Parameter.class).size();
	        	
	        	// Number of marker annotations
	        	int markerAnnotations = methodDeclaration.findAll(MarkerAnnotationExpr.class).size();

	        	// Number of block statements
	        	int blockStatements = methodDeclaration.findAll(BlockStmt.class).size();

	        	// Number of null literal expressions
	        	int nullLiterals = methodDeclaration.findAll(NullLiteralExpr.class).size();;

	        	// Number of throw statements
	        	int throwStatements = methodDeclaration.findAll(ThrowStmt.class).size();

	        	// Additional ones which are found after inspecting several different method trees
	        	int DoStmt = methodDeclaration.findAll(DoStmt.class).size();
	        	int AssertStmt = methodDeclaration.findAll(AssertStmt.class).size();
	        	int DoubleLiteralExpr = methodDeclaration.findAll(DoubleLiteralExpr.class).size();
	        	int BooleanLiteralExpr = methodDeclaration.findAll(BooleanLiteralExpr.class).size();
	        	int CharLiteralExpr = methodDeclaration.findAll(CharLiteralExpr.class).size();
	        	int StringLiteralExpr = methodDeclaration.findAll(StringLiteralExpr.class).size();
	        	int ArrayAccessExpr = methodDeclaration.findAll(ArrayAccessExpr.class).size();
	        	int ConditionalExpr = methodDeclaration.findAll(ConditionalExpr.class).size();
	        	int EnclosedExpr = methodDeclaration.findAll(EnclosedExpr.class).size();
	        	int InstanceOfExpr = methodDeclaration.findAll(InstanceOfExpr.class).size();
	        	int LambdaExpr = methodDeclaration.findAll(LambdaExpr.class).size();
	        	int LiteralExpr = methodDeclaration.findAll(LiteralExpr.class).size();
	        	int LongLiteralExpr = methodDeclaration.findAll(LongLiteralExpr.class).size();
	        	int MethodReferenceExpr = methodDeclaration.findAll(MethodReferenceExpr.class).size();
	        	int NormalAnnotationExpr = methodDeclaration.findAll(NormalAnnotationExpr.class).size();
	        	int PatternExpr = methodDeclaration.findAll(PatternExpr.class).size();
	        	int SingleMemberAnnotationExpr = methodDeclaration.findAll(SingleMemberAnnotationExpr.class).size();
	        	int ThisExpr = methodDeclaration.findAll(ThisExpr.class).size();
	        	int TypeExpr = methodDeclaration.findAll(TypeExpr.class).size();
	        	int UnaryExpr = methodDeclaration.findAll(UnaryExpr.class).size();
	        	int BreakStmt = methodDeclaration.findAll(BreakStmt.class).size();
	        	int ContinueStmt = methodDeclaration.findAll(ContinueStmt.class).size();
	        	int YieldStmt = methodDeclaration.findAll(YieldStmt.class).size();
	        	
	        	// Print findings if required -- stopped updating this print section because after some point
	        	// Number of features were too much.
	        	if (printOutput) {
		        	int outputNumber = 1;
		        	System.out.println("----------------------------------------------------");
		        	System.out.println("Directory name: " + subdirectory);
		        	System.out.println("File name: " + sourceCode.getName());
		        	System.out.println("Method beginning position: " + beginPosition);
		        	System.out.println("Method end position: " + endPosition);
		        	System.out.println(outputNumber++ + " Length of method: " + methodBodyLength);
		        	System.out.println(outputNumber++ + " Parameter Count: " + parameterCount);
		        	System.out.println(outputNumber++ + " Variable Declaration Count: " + variableDeclarationCount);
		        	System.out.println(outputNumber++ + " Constructor call count: " + constructorCallCount);
		        	System.out.println(outputNumber++ + " Catch clause count: " + catchStatementCount);
		        	System.out.println(outputNumber++ + " Number of switch statements: " + switchStatementCount);
		        	System.out.println(outputNumber++ + " Number of cases in switch statements: " + switchCaseStatementCount);
		        	System.out.println(outputNumber++ + " Number of basic iterators: " + numberOfIterators);
		        	System.out.println(outputNumber++ + " Number of assignments: " + assignmentStatements);
		        	System.out.println(outputNumber++ + " Number of method calls: " + methodCalls);
		        	System.out.println(outputNumber++ + " Number of field accesses: " + fieldAccessCount);
		        	System.out.println(outputNumber++ + " Number of expressions: " + expressionCount);
		        	System.out.println(outputNumber++ + " Number of types: " + typeCount);
		        	System.out.println(outputNumber++ + " Object creation count: " + objectCreationCount);
		        	System.out.println(outputNumber++ + " If statement count: " + ifStatementCount);
		        	System.out.println(outputNumber++ + " Number of super calls: " + superCalls);
		        	System.out.println(outputNumber++ + " Return statement count: " + returnStatementCount);
		        	
		        	// 
		        	System.out.println(outputNumber++ + " Tokens: " + tokenList.size());
		        	System.out.println(outputNumber++ + " Constructor Param Count: " + constructorParameters);
		        	System.out.println(outputNumber++ + " Array creation count: " + arrayCreation);
		        	
		        	// 
		        	System.out.println(outputNumber++ + " Number of casts: " + numberOfCasts);
		        	System.out.println(outputNumber++ + " IsStatic: " + isStatic);
		        	System.out.println(outputNumber++ + " isAbstract: " + isAbstract);
		        	System.out.println(outputNumber++ + " isPublic: " + isPublic);
		        	System.out.println(outputNumber++ + " isPrivate: " + isPrivate);
		        	System.out.println(outputNumber++ + " isProtected: " + isProtected);
		        	System.out.println(outputNumber++ + " isFinal: " + isFinal);
		        	System.out.println(outputNumber++ + " isSynchronized: " + isSynchronized);
		        	System.out.println(outputNumber++ + " methodTypeLength: " + methodTypeLength);
		        	
		        	// 
		        	System.out.println(outputNumber++ + " assignmentInFor: " + assignmentInFor);
		        	System.out.println(outputNumber++ + " assignmentInForeach: " + assignmentInForeach);
		        	System.out.println(outputNumber++ + " assignmentInIf: " + assignmentInIf);
		        	System.out.println(outputNumber++ + " assignmentInSwitch: " + assignmentInSwitch);
		        	System.out.println(outputNumber++ + " assignmentInTry: " + assignmentInTry);
		        	System.out.println(outputNumber++ + " assignmentInWhile: " + assignmentInWhile);
		        	System.out.println(outputNumber++ + " declarationInFor: " + declarationInFor);
		        	System.out.println(outputNumber++ + " declarationInForeach: " + declarationInForeach);
		        	System.out.println(outputNumber++ + " declarationInIf: " + declarationInIf);
		        	System.out.println(outputNumber++ + " declarationInSwitch: " + declarationInSwitch);
		        	System.out.println(outputNumber++ + " declarationInTry: " + declarationInTry);
		        	System.out.println(outputNumber++ + " declarationInWhile: " + declarationInWhile);
		        	
	        	}
	        	
	        	
	        	// Create feature object
	        	Features f = new Features();
	        	f.FullPath = fullpath;
	        	f.Directory = subdirectory;
	        	f.Filename = sourceCode.getName();
	        	f.LineBegin = beginPosition;
	        	f.LineEnd = endPosition;
	        	
	        	// 
	        	f.MethodLength = methodBodyLength;
	        	f.AssignmentCount = assignmentStatements;
	        	f.IfCount = ifStatementCount;
	        	f.IteratorCount = numberOfIterators;
	        	f.SwitchCount = switchStatementCount;
	        	f.CaseCount = switchCaseStatementCount;
	        	f.ReturnCount = returnStatementCount;
	        	f.TryStatementCount = tryStatementCount;
	        	f.DeclaredVariableCount = variableDeclarationCount;
	        	f.ExpressionCount = expressionCount;
	        	
	        	// 
	        	f.ParameterCount = parameterCount;
	        	f.ConstructorCallCount = constructorCallCount;
	        	f.CatchClauseCount = catchStatementCount;
	        	f.MethodCallCount = methodCalls;
	        	f.FieldAccessCount = fieldAccessCount;
	        	f.DistinctTypeCount = typeCount;
	        	f.ObjectCreationCount = objectCreationCount;
	        	f.SuperCallCount = superCalls;
	        		        	
	        	//
	        	f.ConstructorParameter = constructorParameters;
	        	f.ArrayCreationCount = arrayCreation;
	        	f.TokenCount = tokenList.size();
	        	
	        	// 
	        	f.CastExpressionCount = numberOfCasts;
	        	f.IsStatic = isStatic;
	        	f.IsAbstract = isAbstract;
	        	f.IsPublic = isPublic;
	        	f.IsPrivate = isPrivate;
	        	f.IsProtected = isProtected;
	        	f.IsFinal = isFinal;
	        	f.IsSynchronized = isSynchronized;
	        	f.MethodTypeLength = methodTypeLength;	        	
	        	
	        	
	        	// 
	        	f.assignmentInFor = assignmentInFor;
	        	f.assignmentInForeach = assignmentInForeach;
	        	f.assignmentInIf = assignmentInIf;
	        	f.assignmentInSwitch = assignmentInSwitch;
	        	f.assignmentInTry = assignmentInTry;
	        	f.assignmentInWhile = assignmentInWhile;
	        	
	        	// 
	        	f.declarationInFor = declarationInFor;
	        	f.declarationInForeach = declarationInForeach;
	        	f.declarationInIf = declarationInIf;
	        	f.declarationInSwitch = declarationInSwitch;
	        	f.declarationInTry = declarationInTry;
	        	f.declarationInWhile = declarationInWhile;

	        	// 
	        	f.variableDeclarationWithAssignment = variableDeclarationWithAssignment;
	        	f.variableDeclarationWithoutAssignment = variableDeclarationWithoutAssignment;
	        	f.integerLiteralExpression = integerLiteralExpression;
	        	f.binaryExpression = binaryExpression;
	        	f.primitiveType = primitiveType;
	        	f.lineComment = lineComment;
	        	f.arrayType = arrayType;	        	
	        	
	        	//
	        	f.methodOverrides = methodOverrides;
	        	f.nameExpressions = nameExpressions;
	        	f.simpleNames = simpleNames;
	        	f.modifiers = modifiers;
	        	f.subParameters = subParameters;
	        	f.markerAnnotations = markerAnnotations;
	        	f.blockStatements = blockStatements;
	        	f.nullLiterals = nullLiterals;
	        	f.throwStatements = throwStatements;
	        	
	        	//
	        	f.forStatementCount = forStatementCount;
	        	f.foreachStatementCount = foreachStatementCount;
	        	f.whileStatementCount = whileStatementCount;
	        	f.primitiveTypes = primitiveTypes.size();
	        	f.classInterfaceTypes = classInterfaceTypes.size();	        	
	        	
	        	// 
	        	f.DoStmt = DoStmt;
	        	f.AssertStmt = AssertStmt;
	        	f.DoubleLiteralExpr = DoubleLiteralExpr;
	        	f.BooleanLiteralExpr = BooleanLiteralExpr;
	        	f.CharLiteralExpr = CharLiteralExpr;
	        	f.StringLiteralExpr = StringLiteralExpr;
	        	f.ArrayAccessExpr = ArrayAccessExpr;
	        	f.ConditionalExpr = ConditionalExpr;
	        	f.EnclosedExpr = EnclosedExpr;
	        	f.InstanceOfExpr = InstanceOfExpr;
	        	f.LambdaExpr = LambdaExpr;
	        	f.LiteralExpr = LiteralExpr;
	        	f.LongLiteralExpr = LongLiteralExpr;
	        	f.MethodReferenceExpr = MethodReferenceExpr;
	        	f.NormalAnnotationExpr = NormalAnnotationExpr;
	        	f.PatternExpr = PatternExpr;
	        	f.SingleMemberAnnotationExpr = SingleMemberAnnotationExpr;
	        	f.ThisExpr = ThisExpr;
	        	f.TypeExpr = TypeExpr;
	        	f.UnaryExpr = UnaryExpr;
	        	f.BreakStmt = BreakStmt;
	        	f.ContinueStmt = ContinueStmt;
	        	f.YieldStmt = YieldStmt;
	        	
	        	allMethodFeatures.add(f);
			};
			
			return allMethodFeatures;
	        
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return null;		
	}
}
