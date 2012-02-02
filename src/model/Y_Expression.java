package model;

import java.util.List; 
import model.RGBColor;

public class Y_Expression extends ParenExpression 
{
    protected Y_Expression(List<Expression> expressions)
    {
        super(expressions);
    }
    public static RGBColor evalY (RGBColor Y)
	{	
		return new RGBColor(Y);
	}
    @Override
    public RGBColor evaluate() 
    {
        List<RGBColor> types = evaluateExpressions();
        return Y_Expression.evalY(types.get(0));
    }  
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "y";
        }
        @Override
        protected int operands() 
        {
            return 1;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new Y_Expression(Expressions);
        }
    }
}