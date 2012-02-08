package model;
import java.util.*;
import model.*;

public class CeilExpression extends ParenExpression
{
	protected CeilExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor ceil (RGBColor left)
	{
		return new RGBColor(Math.ceil(left.getRed()),Math.ceil(left.getGreen()),Math.ceil(left.getBlue())); 
	} 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return CeilExpression.ceil(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "ceil";
		}
		@Override 
		protected int operands() 
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new CeilExpression(Expressions);
		} 
	}
}