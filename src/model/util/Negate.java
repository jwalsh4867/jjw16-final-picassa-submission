package model.util;
import model.RGBColor;

public class Negate
{
	public static RGBColor negate (RGBColor var)
    {
        return new RGBColor(-var.getRed(), -var.getGreen(), -var.getBlue());
    }
}
