package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class Log10Expression extends ParenExpression
{
	protected Log10Expression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor log10 (RGBColor left)
    {
        return new RGBColor(Math.log10(left.getRed()),Math.log10(left.getGreen()),Math.log10(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return Log10Expression.log10(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "logten";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new Log10Expression(Expressions);
		} 
	}
}