package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import CloneTool.CloneDetection.Settings;
import models.Features;

public class H2Database {
     
    private Connection conn = null; 
    private Statement stmt = null; 
    
    /**
     * Connect to a h2 database
     * It is better to put h2 database in the fastest harddrive, otherwise operations will be too slow
     * @return
     */
	public Connection Connect()
	{
        try {
			Class.forName(Settings.JDBC_DRIVER);
			conn = DriverManager.getConnection (Settings.DB_URL, Settings.USER, Settings.PASS);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;  		
	}
	/**
	 * Creates the table for saving the method features
	 * Other tables are generated manually using SQL scripts
	 */
	public void CreateFeatureTables()
	{
		try {
			stmt = conn.createStatement();
			String sql = "CREATE TABLE "
					+ "SAVED_METHOD_FEATURES"
					+ "(directory varchar(255) NOT NULL"
					+ ",filename varchar(255) NOT NULL"
					+ ",line_begin integer NOT NULL"
					+ ",line_end integer NOT NULL"
					+ ",method_length integer"
					+ ",parameter_count integer"
					+ ",declared_variable_count integer"
					+ ",constructor_call_count integer"
					+ ",catch_clause_count integer"
					+ ",switch_count integer"
					+ ",case_count integer"
					+ ",iterator_count integer"
					+ ",assignment_count integer"
					+ ",method_call_count integer"
					+ ",field_access_count integer"
					+ ",expression_count integer"
					+ ",distinct_type_count integer"
					+ ",object_creation_count integer"
					+ ",if_count integer"
					+ ",super_call_count integer"
					+ ",return_count integer"
					+ ",try_statement_count integer"
					+ ",constructor_parameters integer"
					+ ",array_creation_count integer"
					+ ",token_count integer"
					+ ",cast_expression_count integer"
					+ ",is_static integer"
					+ ",is_abstract integer"
					+ ",is_public integer"
					+ ",is_private integer"
					+ ",is_protected integer"
					+ ",is_final integer"
					+ ",is_synchronized integer"
					+ ",method_type_length integer"
					
					+ ",assignmentInFor integer"
					+ ",assignmentInForeach integer"
					+ ",assignmentInIf integer"
					+ ",assignmentInSwitch integer"
					+ ",assignmentInTry integer"
					+ ",assignmentInWhile integer"
					+ ",declarationInFor integer"
					+ ",declarationInForeach integer"
					+ ",declarationInIf integer"
					+ ",declarationInSwitch integer"
					+ ",declarationInTry integer"
					+ ",declarationInWhile integer"
					
					+ ",variableDeclarationWithAssignment integer"
					+ ",variableDeclarationWithoutAssignment integer"
					+ ",integerLiteralExpression integer"
					+ ",binaryExpression integer"
					+ ",primitiveType integer"
					+ ",lineComment integer"
					+ ",arrayType integer"
					
					+ ",methodOverrides integer"
					+ ",nameExpressions integer"
					+ ",simpleNames integer"
					+ ",modifiers integer"
					+ ",subParameters integer"
					+ ",markerAnnotations integer"
					+ ",blockStatements integer"
					+ ",nullLiterals integer"
					+ ",throwStatements integer"
					
					+ ",forStatementCount integer"
					+ ",foreachStatementCount integer"
					+ ",whileStatementCount integer"
					+ ",primitiveTypes integer"
					+ ",classInterfaceTypes integer"				
					
					+ ",DoStmt integer"
					+ ",AssertStmt integer"
					+ ",DoubleLiteralExpr integer"
					+ ",BooleanLiteralExpr integer"
					+ ",CharLiteralExpr integer"
					+ ",StringLiteralExpr integer"
					+ ",ArrayAccessExpr integer"
					+ ",ConditionalExpr integer"
					+ ",EnclosedExpr integer"
					+ ",InstanceOfExpr integer"
					+ ",LambdaExpr integer"
					+ ",LiteralExpr integer"
					+ ",LongLiteralExpr integer"
					+ ",MethodReferenceExpr integer"
					+ ",NormalAnnotationExpr integer"
					+ ",PatternExpr integer"
					+ ",SingleMemberAnnotationExpr integer"
					+ ",ThisExpr integer"
					+ ",TypeExpr integer"
					+ ",UnaryExpr integer"
					+ ",BreakStmt integer"
					+ ",ContinueStmt integer"
					+ ",YieldStmt integer"
					
					+ ");"
					+ "CREATE UNIQUE INDEX IF NOT EXISTS NAME_LINE_IDX ON SAVED_METHOD_FEATURES(directory, filename, line_begin, line_end)";
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Writes list of features to h2 database
	 * Writing operation is done in bulks so they are written in bulks of 1000
	 * This increases the overall performance
	 * @param fs
	 */
	public void WriteFeatureToTable(List<Features> fs)
	{
		try {
			String sql = "INSERT INTO SAVED_METHOD_FEATURES"
					+ " (directory, filename, line_begin, line_end, method_length, parameter_count, declared_variable_count, "
					+ "constructor_call_count, catch_clause_count, switch_count, case_count, iterator_count, assignment_count, "
					+ "method_call_count, field_access_count, expression_count, distinct_type_count, object_creation_count, "
					+ "if_count, super_call_count, return_count, try_statement_count, constructor_parameters,"
					+ "array_creation_count, token_count, cast_expression_count, is_static, is_abstract, is_public, is_private, "
					+ "is_protected, is_final, is_synchronized, method_type_length"
					+ ",assignmentInFor"
					+ ",assignmentInForeach"
					+ ",assignmentInIf"
					+ ",assignmentInSwitch"
					+ ",assignmentInTry"
					+ ",assignmentInWhile"
					+ ",declarationInFor"
					+ ",declarationInForeach"
					+ ",declarationInIf"
					+ ",declarationInSwitch"
					+ ",declarationInTry"
					+ ",declarationInWhile"
					+ ",variableDeclarationWithAssignment"
					+ ",variableDeclarationWithoutAssignment"
					+ ",integerLiteralExpression"
					+ ",binaryExpression"
					+ ",primitiveType"
					+ ",lineComment"
					+ ",arrayType"			
					+ ",methodOverrides"
					+ ",nameExpressions"
					+ ",simpleNames"
					+ ",modifiers"
					+ ",subParameters"
					+ ",markerAnnotations"
					+ ",blockStatements"
					+ ",nullLiterals"
					+ ",throwStatements"		
					+ ",forStatementCount"
					+ ",foreachStatementCount"
					+ ",whileStatementCount"
					+ ",primitiveTypes"
					+ ",classInterfaceTypes"		
					
					+ ",DoStmt"
					+ ",AssertStmt"
					+ ",DoubleLiteralExpr"
					+ ",BooleanLiteralExpr"
					+ ",CharLiteralExpr"
					+ ",StringLiteralExpr"
					+ ",ArrayAccessExpr"
					+ ",ConditionalExpr"
					+ ",EnclosedExpr"
					+ ",InstanceOfExpr"
					+ ",LambdaExpr"
					+ ",LiteralExpr"
					+ ",LongLiteralExpr"
					+ ",MethodReferenceExpr"
					+ ",NormalAnnotationExpr"
					+ ",PatternExpr"
					+ ",SingleMemberAnnotationExpr"
					+ ",ThisExpr"
					+ ",TypeExpr"
					+ ",UnaryExpr"
					+ ",BreakStmt"
					+ ",ContinueStmt"
					+ ",YieldStmt"
					+ ")"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ");";		
			PreparedStatement preparedStatement = conn.prepareStatement(sql);		
			int currentPoint = 0;
			for (Features f : fs) {
				preparedStatement.setString(1, f.Directory);
				preparedStatement.setString(2, f.Filename);
				preparedStatement.setInt(3, f.LineBegin);
				preparedStatement.setInt(4, f.LineEnd);
				preparedStatement.setInt(5, f.MethodLength);
				preparedStatement.setInt(6, f.ParameterCount);
				preparedStatement.setInt(7, f.DeclaredVariableCount);
				preparedStatement.setInt(8, f.ConstructorCallCount);
				preparedStatement.setInt(9, f.CatchClauseCount);
				preparedStatement.setInt(10, f.SwitchCount);
				preparedStatement.setInt(11, f.CaseCount);
				preparedStatement.setInt(12, f.IteratorCount);
				preparedStatement.setInt(13, f.AssignmentCount);
				preparedStatement.setInt(14, f.MethodCallCount);
				preparedStatement.setInt(15, f.FieldAccessCount);
				preparedStatement.setInt(16, f.ExpressionCount);
				preparedStatement.setInt(17, f.DistinctTypeCount);
				preparedStatement.setInt(18, f.ObjectCreationCount);
				preparedStatement.setInt(19, f.IfCount);
				preparedStatement.setInt(20, f.SuperCallCount);
				preparedStatement.setInt(21, f.ReturnCount);
				preparedStatement.setInt(22, f.TryStatementCount);
								
				preparedStatement.setInt(23, f.ConstructorParameter);
				preparedStatement.setInt(24, f.ArrayCreationCount);
				preparedStatement.setInt(25, f.TokenCount);
				
				preparedStatement.setInt(26, f.CastExpressionCount);
				preparedStatement.setInt(27, f.IsStatic);
				preparedStatement.setInt(28, f.IsAbstract);
				preparedStatement.setInt(29, f.IsPublic);
				preparedStatement.setInt(30, f.IsPrivate);
				preparedStatement.setInt(31, f.IsProtected);
				preparedStatement.setInt(32, f.IsFinal);
				preparedStatement.setInt(33, f.IsSynchronized);
				preparedStatement.setInt(34, f.MethodTypeLength);
				
				preparedStatement.setInt(35, f.assignmentInFor);
				preparedStatement.setInt(36, f.assignmentInForeach);
				preparedStatement.setInt(37, f.assignmentInIf);
				preparedStatement.setInt(38, f.assignmentInSwitch);
				preparedStatement.setInt(39, f.assignmentInTry);
				preparedStatement.setInt(40, f.assignmentInWhile);
				preparedStatement.setInt(41, f.declarationInFor);
				preparedStatement.setInt(42, f.declarationInForeach);
				preparedStatement.setInt(43, f.declarationInIf);
				preparedStatement.setInt(44, f.declarationInSwitch);
				preparedStatement.setInt(45, f.declarationInTry);
				preparedStatement.setInt(46, f.declarationInWhile);
				
				preparedStatement.setInt(47, f.variableDeclarationWithAssignment);
				preparedStatement.setInt(48, f.variableDeclarationWithoutAssignment);
				preparedStatement.setInt(49, f.integerLiteralExpression);
				preparedStatement.setInt(50, f.binaryExpression);
				preparedStatement.setInt(51, f.primitiveType);
				preparedStatement.setInt(52, f.lineComment);
				preparedStatement.setInt(53, f.arrayType);
				
				preparedStatement.setInt(54, f.methodOverrides);
				preparedStatement.setInt(55, f.nameExpressions);
				preparedStatement.setInt(56, f.simpleNames);
				preparedStatement.setInt(57, f.modifiers);
				preparedStatement.setInt(58, f.subParameters);
				preparedStatement.setInt(59, f.markerAnnotations);
				preparedStatement.setInt(60, f.blockStatements);
				preparedStatement.setInt(61, f.nullLiterals);
				preparedStatement.setInt(62, f.throwStatements);
				
				preparedStatement.setInt(63, f.forStatementCount);
				preparedStatement.setInt(64, f.foreachStatementCount);
				preparedStatement.setInt(65, f.whileStatementCount);
				preparedStatement.setInt(66, f.primitiveTypes);
				preparedStatement.setInt(67, f.classInterfaceTypes);
				
				preparedStatement.setInt(68, f.DoStmt);
				preparedStatement.setInt(69, f.AssertStmt);
				preparedStatement.setInt(70, f.DoubleLiteralExpr);
				preparedStatement.setInt(71, f.BooleanLiteralExpr);
				preparedStatement.setInt(72, f.CharLiteralExpr);
				preparedStatement.setInt(73, f.StringLiteralExpr);
				preparedStatement.setInt(74, f.ArrayAccessExpr);
				preparedStatement.setInt(75, f.ConditionalExpr);
				preparedStatement.setInt(76, f.EnclosedExpr);
				preparedStatement.setInt(77, f.InstanceOfExpr);
				preparedStatement.setInt(78, f.LambdaExpr);
				preparedStatement.setInt(79, f.LiteralExpr);
				preparedStatement.setInt(80, f.LongLiteralExpr);
				preparedStatement.setInt(81, f.MethodReferenceExpr);
				preparedStatement.setInt(82, f.NormalAnnotationExpr);
				preparedStatement.setInt(83, f.PatternExpr);
				preparedStatement.setInt(84, f.SingleMemberAnnotationExpr);
				preparedStatement.setInt(85, f.ThisExpr);
				preparedStatement.setInt(86, f.TypeExpr);
				preparedStatement.setInt(87, f.UnaryExpr);
				preparedStatement.setInt(88, f.BreakStmt);
				preparedStatement.setInt(89, f.ContinueStmt);
				preparedStatement.setInt(90, f.YieldStmt);
				
				preparedStatement.addBatch();
				currentPoint++;
				
				if ((currentPoint % 1000) == 0 || currentPoint == fs.size()) {
					preparedStatement.executeBatch();
					conn.commit();	
				}	
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}	
}
