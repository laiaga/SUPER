package model;

public class TricolorLight
{
	ColorLights feux;

	public ColorLights getFeux()
	{
		return feux;
	}

	public void setFeux(ColorLights feux)
	{
		this.feux = feux;
	}

	public TricolorLight()
	{
		this.feux = ColorLights.ROUGE;
	}

	public TricolorLight(ColorLights feux)
	{
		this.feux = feux;
	}
}
