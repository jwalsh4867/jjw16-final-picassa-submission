package model;

import java.util.List; 
import model.RGBColor;

public class X_Expression extends ParenExpression 
{

    protected X_Expression(List<Expression> expressions)
    {
        super(expressions);
    }
    public static RGBColor evalX (RGBColor X)
	{	
		return new RGBColor(X);
	}
    @Override
    public RGBColor evaluate() 
    {
        List<RGBColor> types = evaluateExpressions();
        return X_Expression.evalX(types.get(0));
    }  
    public static class Factory extends ParenExpression.Factory
    {
        @Override
        protected String command() 
        {
            return "x";
        }
        @Override
        protected int operands() 
        {
            return 1;
        }
        @Override
        protected ParenExpression makeExpression(List<Expression> Expressions) 
        {
            return new X_Expression(Expressions);
        }
    }
}