package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class SinExpression extends ParenExpression
{
	protected SinExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor sin (RGBColor left)
    {
        return new RGBColor(Math.sin(left.getRed()),Math.sin(left.getGreen()),Math.sin(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return SinExpression.sin(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "sin";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new SinExpression(Expressions);
		} 
	}
}