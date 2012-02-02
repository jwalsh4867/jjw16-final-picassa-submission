package model.util;

import model.RGBColor;

public class Color 
{
	public static RGBColor color (RGBColor red, RGBColor green, RGBColor blue)
    {
        return new RGBColor(red.getRed(), green.getGreen(), blue.getBlue());
    }
}
