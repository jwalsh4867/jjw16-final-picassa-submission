package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class ClampExpression extends ParenExpression
{
	protected ClampExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor clamp(RGBColor left)
    {
        return new RGBColor(RGBColor.clamp(left.getRed()),RGBColor.clamp(left.getGreen()),RGBColor.clamp(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return ClampExpression.clamp(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "clamp";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new ClampExpression(Expressions);
		} 
	}
}