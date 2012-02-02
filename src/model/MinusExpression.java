package model;

import java.util.List; 
import model.RGBColor;


public class MinusExpression extends ParenExpression 
{
    protected MinusExpression(List<Expression> expressions) 
    {
        super(expressions);
    }
    public static RGBColor minus (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }
    @Override
    public RGBColor evaluate() 
    {
        List<RGBColor> Types = evaluateExpressions();
        return MinusExpression.minus(Types.get(0),Types.get(1));
    }  
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "minus";
        }
        @Override
        protected int operands() 
        {
            return 2;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new MinusExpression(Expressions);
        }   
    }
}