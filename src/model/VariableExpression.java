package model;

import java.util.*; 
import java.util.regex.*;
import model.*;

public abstract class VariableExpression extends Expression
{ 
    private static final Pattern CHARACTER_REGEX = Pattern.compile("([a-z]+)");

    public static abstract class Factory extends Expression.CommandFactory
    {
		protected abstract String commandName();   
		protected abstract VariableExpression makeExpression();

		@Override 
		public boolean expressionType(Parser parser) 
		{
	        Matcher varMatcher = CHARACTER_REGEX.matcher(parser.stringAtCurrentPosition());
	            if(varMatcher.lookingAt())
	            {
	            	return getCommand(parser).equals(commandName());
	            }
	            return false;  
		}
		protected String getCommand(Parser parser)
		{
	        Matcher characterMatcher = CHARACTER_REGEX.matcher(parser.getmyInput());
	        characterMatcher.find(parser.getCurrentPosition());
	        String matches = ((String)parser.getmyInput()).substring(characterMatcher.start(), characterMatcher.end());
	        return matches; 
	    }
		@Override 
		public Expression parseExpression(Parser parser) 
		{
			parser.advanceCurrentPosition(commandName().length());
			parser.skipWhiteSpace();
	        return makeExpression();
		}
    }
}