package model;

public class BicolorLight extends ColorLights{
	ColorTri feux;

	public ColorTri getFeux() {
		return feux;
	}

	public void setFeux(ColorTri feux) {
		this.feux = feux;
	}

	public BicolorLight() {
		super();
	}

	public BicolorLight(ColorTri feux) {
		super();
		this.feux = feux;
	}
}
