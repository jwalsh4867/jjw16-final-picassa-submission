package model;
import java.util.*;
import model.*;

public class AbsoluteExpression extends ParenExpression
{
    protected AbsoluteExpression(List<Expression> expressions) 
    {
        super(expressions);
    }
    public static RGBColor abs (RGBColor left)
    {
        return new RGBColor(Math.abs(left.getRed()),Math.abs(left.getGreen()),Math.abs(left.getBlue())); 
    } 
	@Override
	public RGBColor evaluate(double x, double y) 
	{
        List<RGBColor> types = evaluateExpressions(x,y);
        return AbsoluteExpression.abs(types.get(0));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "abs";
		}
		@Override 
		protected int operands() 
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) {
			return new AbsoluteExpression(Expressions);
		} 

	}
}