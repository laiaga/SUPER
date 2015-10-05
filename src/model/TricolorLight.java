package model;

public class TricolorLight extends ColorLights{
	ColorTri feux;

	public ColorTri getFeux() {
		return feux;
	}

	public void setFeux(ColorTri feux) {
		this.feux = feux;
	}

	public TricolorLight() {
		super();
	}

	public TricolorLight(ColorTri feux) {
		super();
		this.feux = feux;
	}
	
	
}
