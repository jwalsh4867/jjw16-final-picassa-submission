package model; 
import java.util.*;
import model.*;

public class YCrCbtoRGBExpression extends ParenExpression
{
	protected YCrCbtoRGBExpression(List<Expression> subexpressions) 
	{
		super(subexpressions);
	}
	public static RGBColor YCrCbtoRGB(RGBColor rgbColor) 
	{
		double Y = rgbColor.getRed(); 
    	double U = rgbColor.getGreen(); 
    	double V = rgbColor.getBlue(); 
    	double Red = Y + 1.140*V;
    	double Green = Y - 0.395*U - 0.581*V;
    	double Blue = Y + 2.032*U;
		return new RGBColor(Red,Green,Blue); 
	}
	@Override
	public RGBColor evaluate(double x, double y) 
	{
		List<RGBColor> results = evaluateExpressions(x,y);
		return YCrCbtoRGBExpression.YCrCbtoRGB(results.get(0));
	} 
	public static class Factory extends ParenExpression.Factory
	{
		@Override
		protected String command() 
		{
			return "yCrCbtoRGB";
		}
		@Override 
		protected int operands() 
		{
			return 1;
		}
		@Override
		protected ParenExpression makeExpression(List<Expression> Expressions) {
			return new YCrCbtoRGBExpression(Expressions); 
		} 
	}
}