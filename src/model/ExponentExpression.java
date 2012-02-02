package model;

import java.util.List; 
import model.RGBColor;

public class ExponentExpression extends ParenExpression 
{

    protected ExponentExpression(List<Expression> expressions)
    {
        super(expressions);
    }
    public static RGBColor exponent (RGBColor left, RGBColor right)
    {
        return new RGBColor(Math.pow(left.getRed(), right.getRed()), 
                            Math.pow(left.getGreen(), right.getGreen()),
                            Math.pow(left.getBlue(), right.getBlue()));
    }
    @Override
    public RGBColor evaluate() 
    {
        List<RGBColor> types = evaluateExpressions();
        return ExponentExpression.exponent(types.get(0), types.get(1));
    }  
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "exp";
        }
        @Override
        protected int operands() 
        {
            return 2;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new ExponentExpression(Expressions);
        }
    }
}