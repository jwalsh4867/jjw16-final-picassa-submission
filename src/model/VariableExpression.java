package model;

import java.util.*; 
import java.util.regex.*;
import model.*;

//public class VariableExpression extends Expression
//{
//	private String variable;
//	public VariableExpression(String var){
//		this.variable = var;
//	}
//	public RGBColor evaluate(){ 
//		if (variable.equals("x"))
//		{ 
//			return new RGBColor(x);
//		}
//		else if (variable.equals("y"))
//		{
//			return new RGBColor(y);
//		}
//	}
//	public static class Factory extends Expression.CommandFactory
//	{
//		private static final Pattern VARIABLE_REGEX = Pattern.compile("[xy]");
//		@Override
//        public boolean expressionType(Parser parser) 
//        {
//            return regMatcher(VARIABLE_REGEX, parser);
//        }
//		 @Override
//	     public Expression parseExpression(Parser parser) 
//	    {
//			 String input = parser.stringAtCurrentPosition();
//			 Matcher varMatcher = VARIABLE_REGEX.matcher(input);
//			 varMatcher.find(0);
//			 String varMatch = input.substring(varMatcher.start(), varMatcher.end());
//			 parser.advanceCurrentPosition(varMatch.length());
//			 if (varMatch.equals("x")) 
//			 { 
//				 return new VariableExpression("x");
//			 }
//			 else if (varMatch.equals("y"))
//			 {
//				 return new VariableExpression("y");
//			 }
//	    }
//	}
//}
