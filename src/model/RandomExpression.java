package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class RandomExpression extends ParenExpression
{
	double red =  Math.random(); 
	double green =  Math.random(); 
	double blue =  Math.random(); 
	protected RandomExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor random (double red, double green, double blue)
    {
        return new RGBColor(red, green, blue); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return RandomExpression.random(red,green,blue);
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "random";
		}
		@Override 
		protected int operands()
		{
			return 0;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new RandomExpression(Expressions);
		} 
	}
}
