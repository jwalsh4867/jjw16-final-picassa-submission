package model;

import java.util.List; 
import model.RGBColor;

public class X_Expression extends VariableExpression 
{
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		return new RGBColor(x);
	}
	public static class Factory extends VariableExpression.Factory
	{
		@Override
		protected String commandName() 
		{
			return "x";
		}
 
		@Override
		protected VariableExpression makeExpression() 
		{
			return new X_Expression(); 
		}
	}	
}