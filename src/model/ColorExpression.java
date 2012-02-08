package model;

import java.util.List;  
import model.RGBColor;

public class ColorExpression extends ParenExpression 
{
    protected ColorExpression(List<Expression> expressions) 
    {
        super(expressions);
    }
    public static RGBColor color (RGBColor red, RGBColor green, RGBColor blue)
    {
    	return new RGBColor(red.getRed(), green.getGreen(), blue.getBlue());
    }
    @Override
    public RGBColor evaluate(double x, double y) 
    {
        List<RGBColor> types = evaluateExpressions(x,y);
        return ColorExpression.color(types.get(0), types.get(1), types.get(2));
    }    
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "color";
        }
        @Override
        protected int operands() 
        {
            return 3;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new ColorExpression(Expressions);
        }     
    }
}