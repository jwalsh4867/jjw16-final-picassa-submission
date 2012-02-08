package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Parser;
import model.RGBColor;

public class NumberExpression extends Expression 
{
    private RGBColor color;
    public NumberExpression(RGBColor gray) 
    {
        this.color = gray;
    }
    @Override
    public RGBColor evaluate(double x, double y) 
    {
        return color;
    }
    public static class Factory extends Expression.CommandFactory
    {
        private static final Pattern DOUBLE_REGEX = Pattern.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
        @Override
        public boolean expressionType(Parser parser) 
        {
            return regMatcher(DOUBLE_REGEX, parser);
        }
        @Override
        public Expression parseExpression(Parser parser) 
        {
            String input = parser.stringAtCurrentPosition();
            Matcher doubleMatcher = DOUBLE_REGEX.matcher(input);
            doubleMatcher.find(0);
            String numberMatch = input.substring(doubleMatcher.start(), doubleMatcher.end());
            parser.advanceCurrentPosition(numberMatch.length());
            double value = Double.parseDouble(numberMatch);
            RGBColor gray = new RGBColor(value);
            return new NumberExpression(gray);
        }        
    }   
}