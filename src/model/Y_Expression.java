package model;

import java.util.List; 
import model.RGBColor;

public class Y_Expression extends VariableExpression 
{
	@Override
	public RGBColor evaluate(double x, double y) { 
		return new RGBColor(y);
	}
	public static class Factory extends VariableExpression.Factory
	{
		@Override
		protected String commandName() 
		{
			return "y";
		}
		@Override
		protected VariableExpression makeExpression() 
		{
			return new Y_Expression(); 
		}
	}
}