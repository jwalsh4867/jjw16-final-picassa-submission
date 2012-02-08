package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class ArcTanExpression extends ParenExpression
{
	protected ArcTanExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor atan (RGBColor left)
    {
        return new RGBColor(Math.atan(left.getRed()),Math.atan(left.getGreen()),Math.atan(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return ArcTanExpression.atan(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "atan";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new ArcTanExpression(Expressions);
		} 
	}
}