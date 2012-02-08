package model;
import java.util.*;
import model.*;

public class FloorExpression extends ParenExpression
{
	protected FloorExpression(List<Expression> expressions) 
	{
		super(expressions);
	}
	public static RGBColor floor (RGBColor left)
    {
        return new RGBColor(Math.floor(left.getRed()),Math.floor(left.getGreen()),Math.floor(left.getBlue())); 
    }
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> types = evaluateExpressions(x,y);
		return FloorExpression.floor(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "floor";
		}
		@Override 
		protected int operands()
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new FloorExpression(Expressions);
		} 
	}
}

