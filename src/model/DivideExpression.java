package model;

import java.util.List;
import model.RGBColor;

public class DivideExpression extends ParenExpression 
{

    protected DivideExpression(List<Expression> expressions)
    {
        super(expressions);
    }
    public static RGBColor divide (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
    @Override
    public RGBColor evaluate(double x, double y) 
    {
        List<RGBColor> types = evaluateExpressions(x, y);
        return DivideExpression.divide(types.get(0), types.get(1));
    }  
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "div";
        }
        @Override
        protected int operands() 
        {
            return 2;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new DivideExpression(Expressions);
        }
    }
}