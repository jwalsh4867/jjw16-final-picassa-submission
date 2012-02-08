package model;
import java.util.*;
import model.util.*;

public class PerlinBWdoubleExpression extends ParenExpression
{
    protected PerlinBWdoubleExpression (List<Expression> expressions) 
    {
        super(expressions);
    }
	@Override
	public RGBColor evaluate(double x, double y) 
	{
        List<RGBColor> types = evaluateExpressions(x,y);
        return PerlinNoise.greyNoise(types.get(0),types.get(1));
	}
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "perlinBW";
		}
		@Override 
		protected int operands()
		{
			return 2;
		} 
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) 
		{
			return new PerlinBWdoubleExpression(Expressions);
		} 
	}
}