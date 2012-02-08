package model;
import java.util.*;
import model.util.*;


public class PerlinColorDoubleExpression extends ParenExpression
{
    protected PerlinColorDoubleExpression (List<Expression> expressions) 
    {
        super(expressions);
    }
	@Override
	public RGBColor evaluate(double x, double y) 
	{
        List<RGBColor> types = evaluateExpressions(x,y);
        return PerlinNoise.colorNoise(types.get(0),types.get(1));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command()
		{
			return "perlinColor";
		}
		@Override 
		protected int operands() 
		{
			return 2;
		} 
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new PerlinColorDoubleExpression(Expressions);
		} 
	}
}