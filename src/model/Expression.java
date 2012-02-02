package model;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import model.*;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical 
 * functions and the leaves represent constant values.
 *
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public abstract class Expression
{
    public abstract RGBColor evaluate ();
    public static abstract class CommandFactory
    {
        public abstract boolean expressionType(Parser parser);
        public abstract Expression parseExpression(Parser parser);     
        protected boolean regMatcher(Pattern regex, Parser parser) 
        {
            Matcher matcher = regex.matcher(parser.stringAtCurrentPosition());
            return matcher.lookingAt();
        }
    }
}