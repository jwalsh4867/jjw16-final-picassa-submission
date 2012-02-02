package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.*;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser 
 * is used 
 *   http://en.wikipedia.org/wiki/Recursive_descent_parser
 *   
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser
{
	public Parser()
	{
		makeExpressionTypes();
	}
	private int myCurrentPosition;
	private String myInput;
	private List<Expression.CommandFactory> expressionTypes;
	private void makeExpressionTypes()
	{
		expressionTypes = new ArrayList<Expression.CommandFactory>();
		expressionTypes.add(new PlusExpression.Factory());
		expressionTypes.add(new MinusExpression.Factory());
		expressionTypes.add(new MultiplyExpression.Factory());
		expressionTypes.add(new DivideExpression.Factory());
		expressionTypes.add(new ModulusExpression.Factory());
		expressionTypes.add(new ExponentExpression.Factory());
		expressionTypes.add(new NegateExpression.Factory());
		expressionTypes.add(new ColorExpression.Factory());
		expressionTypes.add(new NumberExpression.Factory());
		expressionTypes.add(new X_Expression.Factory());
		expressionTypes.add(new Y_Expression.Factory());
	}
	/**
	 * Converts given string into expression tree.
	 * 
	 * @param input expression given in the language to be parsed
	 * @return expression tree representing the given formula
	 */
	public Expression makeExpression (String input)
	{
		myInput = input;
		myCurrentPosition = 0;
		Expression result = parseExpression();
		skipWhiteSpace();
		if (notAtEndOfString())
		{
			throw new ParserException("Unexpected characters at end of the string: " + stringAtCurrentPosition(),ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}
	public Expression parseExpression ()
	{
		skipWhiteSpace();
		for(Expression.CommandFactory type : expressionTypes) 
		{
			if(type.expressionType(this)) 
			{
				return type.parseExpression(this);
			}
		}
		throw new ParserException("Unparsable expression: " + stringAtCurrentPosition());
	}
	public String stringAtCurrentPosition()
	{
		return myInput.substring(myCurrentPosition);
	}
	public void skipWhiteSpace ()
	{
		while (notAtEndOfString() && Character.isWhitespace(currentCharacter()))
		{
			myCurrentPosition++;
		}
	}
	public char currentCharacter ()
	{
		return myInput.charAt(myCurrentPosition);
	}
	public void advanceCurrentPosition(int chars)
	{
		myCurrentPosition += chars;
	}
	private boolean notAtEndOfString ()
	{
		return myCurrentPosition < myInput.length();
	}
}