package model.util;
import model.RGBColor;

public class Multiply 
{
	 public static RGBColor multiply (RGBColor left, RGBColor right)
	    {
	        return new RGBColor(left.getRed() * right.getRed(), 
	                            left.getGreen() * right.getGreen(),
	                            left.getBlue() * right.getBlue());
	    }
}
