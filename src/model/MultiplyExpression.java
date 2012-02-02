package model;

import java.util.List; 
import model.RGBColor;

public class MultiplyExpression extends ParenExpression 
{

    protected MultiplyExpression(List<Expression> expressions)
    {
        super(expressions);
    }
    public static RGBColor multiply (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }
    @Override
    public RGBColor evaluate() 
    {
        List<RGBColor> types = evaluateExpressions();
        return MultiplyExpression.multiply(types.get(0), types.get(1));
    }  
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "mul";
        }
        @Override
        protected int operands() 
        {
            return 2;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new MultiplyExpression(Expressions);
        }
    }
}