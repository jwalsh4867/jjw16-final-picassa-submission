package model;

import java.util.List; 
import model.RGBColor;

public class NegateExpression extends ParenExpression 
{
    protected NegateExpression(List<Expression> expressions) 
    {
        super(expressions);
    }
    public static RGBColor negate (RGBColor var)
    {
        return new RGBColor(1 / var.getRed(), 1 / var.getGreen(), 1 / var.getBlue());
    }
    @Override
    public RGBColor evaluate(double x, double y) 
    {
        List<RGBColor> types = evaluateExpressions(x,y);
        return NegateExpression.negate(types.get(0));
    }    
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "neg";
        }
        @Override
        protected int operands() 
        {
            return 1;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new NegateExpression(Expressions);
        }     
    }
}