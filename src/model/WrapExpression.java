package model;

import java.util.List;
import model.*;
import model.RGBColor;

public class WrapExpression extends ParenExpression
{
	protected WrapExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor wrap (RGBColor left)
    {
        return new RGBColor(RGBColor.wrap(left.getRed()),RGBColor.wrap(left.getGreen()),RGBColor.wrap(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return WrapExpression.wrap(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "wrap";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new WrapExpression(Expressions);
		} 
	}
}