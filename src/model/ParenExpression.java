package model;

import java.util.*; 
import java.util.regex.*;
import model.*;

public abstract class ParenExpression extends Expression 
{
    private List<Expression> expressions;
    protected ParenExpression(List<Expression> expressions)
    {
        this.expressions = expressions;
    }  
    protected List<RGBColor> evaluateExpressions(double x, double y)
    {
        List<RGBColor> types = new ArrayList<RGBColor>(expressions.size());
        for(Expression type : expressions) 
        {
            types.add(type.evaluate(x,y));
        }
        return types;
    }   
    protected List<Expression> getExpressions()
    {
        return Collections.unmodifiableList(expressions);
    }  
    public abstract static class Factory extends Expression.CommandFactory
    {
        private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern.compile("\\(([a-z]+)");
        protected String getCommand(Parser parser) 
        {
            Matcher matcher = EXPRESSION_BEGIN_REGEX.matcher(parser.stringAtCurrentPosition());
            matcher.find(0);
            return matcher.group(1);
        }      
        @Override
        public boolean expressionType(Parser parser) 
        {
            if(!regMatcher(EXPRESSION_BEGIN_REGEX,parser))
                return false;
            return getCommand(parser).equals(command());
        }
        protected abstract int operands();
        protected abstract String command();
        protected abstract ParenExpression makeExpression(List<Expression> Expressions);      
        @Override
        public Expression parseExpression(Parser parser) 
        {
            if(!expressionType(parser))
                throw new ParserException("Attempt to parse invalid string as " + command() + " paren expression");
            parser.advanceCurrentPosition(command().length() + 1);
            List<Expression> expressions = new ArrayList<Expression>();
            for(int x = 0; x < operands(); x++) 
            {
                expressions.add(parser.parseExpression());
            }
            parser.skipWhiteSpace();
            if (parser.currentCharacter() == ')')
            {
                parser.advanceCurrentPosition(1);
                return makeExpression(expressions);
            }
            else
            {
                throw new ParserException("Expected close paren, instead found " + parser.stringAtCurrentPosition());
            }
        }         
    }
}