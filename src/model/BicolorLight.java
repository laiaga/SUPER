package model;

public class BicolorLight
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

	public BicolorLight() {
		this.feux = ColorLights.ROUGE;
	}

	public BicolorLight(ColorLights feux)
	{
		this.feux = feux;
	}
}