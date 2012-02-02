package model.util;
import model.RGBColor;

public class Exponent
{
	public static RGBColor exponent (RGBColor left, RGBColor right)
    {
        return new RGBColor(Math.pow(left.getRed(), right.getRed()), 
                            Math.pow(left.getGreen(), right.getGreen()),
                            Math.pow(left.getBlue(), right.getBlue()));
    }
}
