package model;

import java.util.List; 
import model.RGBColor;

public class PlusExpression extends ParenExpression 
{

    protected PlusExpression(List<Expression> expressions)
    {
        super(expressions);
    }
    public static RGBColor plus (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }
    @Override
    public RGBColor evaluate(double x, double y) 
    {
        List<RGBColor> types = evaluateExpressions(x,y);
        return PlusExpression.plus(types.get(0), types.get(1));
    }  
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "plus";
        }
        @Override
        protected int operands() 
        {
            return 2;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new PlusExpression(Expressions);
        }
    }
}