package model; 
import java.util.*;
import model.*;

public class RGBtoYCrCbExpression extends ParenExpression
{
    protected RGBtoYCrCbExpression(List<Expression> subexpressions) 
    {
        super(subexpressions);
    }
    public static RGBColor RGBtoYCrCb(RGBColor rgbColor) 
    {
    	double Red = rgbColor.getRed(); 
    	double Green = rgbColor.getGreen(); 
    	double Blue = rgbColor.getBlue(); 
    	double Y =  0.299*Red + 0.587*Green + 0.114*Blue; 
    	double U = -0.147*Red - 0.289*Green + 0.436*Blue; 
    	double V =  0.615*Red - 0.515*Green - 0.100*Blue;
        return new RGBColor(Y,U,V); 
	}
	@Override
	public RGBColor evaluate(double x, double y) 
	{
        List<RGBColor> results = evaluateExpressions(x,y);
        return RGBtoYCrCbExpression.RGBtoYCrCb(results.get(0));
	} 
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "rgbToYCrCb";
		}
		@Override 
		protected int operands() 
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) {
			return new RGBtoYCrCbExpression(Expressions); 
		} 
	}
}