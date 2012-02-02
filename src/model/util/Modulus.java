package model.util;
import model.RGBColor;

public class Modulus 
{
	public static RGBColor modulo (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() % right.getRed(), 
                            left.getGreen() % right.getGreen(),
                            left.getBlue() % right.getBlue());
    }
}
