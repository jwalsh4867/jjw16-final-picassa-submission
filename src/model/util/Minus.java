package model.util;
import model.RGBColor;

public class Minus
{
	public static RGBColor minus (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }
}
