package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class LogExpression extends ParenExpression
{
	protected LogExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor log (RGBColor left)
    {
        return new RGBColor(Math.log(left.getRed()),Math.log(left.getGreen()),Math.log(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return LogExpression.log(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "log";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new LogExpression(Expressions);
		} 
	}
}