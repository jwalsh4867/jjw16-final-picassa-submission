package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class CosExpression extends ParenExpression
{
	protected CosExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor cos (RGBColor left)
    {
        return new RGBColor(Math.cos(left.getRed()),Math.cos(left.getGreen()),Math.cos(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return CosExpression.cos(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "cos";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new CosExpression(Expressions);
		} 
	}
}