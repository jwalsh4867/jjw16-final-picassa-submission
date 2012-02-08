package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class TanExpression extends ParenExpression
{
	protected TanExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor tan (RGBColor left)
    {
        return new RGBColor(Math.tan(left.getRed()),Math.tan(left.getGreen()),Math.tan(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return TanExpression.tan(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "tan";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new TanExpression(Expressions);
		} 
	}
}