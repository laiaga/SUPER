package controller;

import java.awt.Color;

import javax.swing.JLabel;

import model.BicolorLight;
import model.Bridge;
import model.ColorLights;
import model.PositionBridge;
import model.TricolorLight;
import view.View;

public class StateLabelController implements Runnable
{
	private View window;
	
	private JLabel stateBridge;
	private JLabel stateLightCars;
	private JLabel stateLightBoats;
	private JLabel stateBarriers;
	
	private Bridge bridge;
	private TricolorLight lightCars;
	private BicolorLight lightBoats;
	private model.Barrier barriers;
	
	public StateLabelController(View window)
	{
		this.window = window;
	    
		this.bridge = Bridge.getInstance();
		this.lightBoats = bridge.getLightNorth();
		this.lightCars = bridge.getLightEast();
		this.barriers = bridge.getBarrierEast();
		
		stateBridge = window.createLabelState(getStringBridge(), Color.GREEN);
		stateLightCars = window.createLabelState(getStringLightCars(), Color.GREEN);
		stateLightBoats = window.createLabelState(getStringLightBoats(), Color.RED);
		stateBarriers = window.createLabelState(getStringBarriers(), Color.GREEN);
	}
	
	public void run()
	{
		while(true)
		{
			refresh();
			
			synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(500);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void refresh()
	{
		stateBridge.setText(getStringBridge());
		stateBridge.setBackground(bridge.getState()==PositionBridge.Moving ? Color.RED : Color.GREEN);
		stateBridge.setForeground(stateBridge.getBackground()==Color.RED ? Color.WHITE : Color.BLACK);
		
		stateLightCars.setText(getStringLightCars());
		stateLightCars.setBackground(lightCars.getFeux()==ColorLights.ROUGE ? Color.RED : (lightCars.getFeux()==ColorLights.ORANGE ? Color.ORANGE : Color.GREEN));
		stateLightCars.setForeground(stateLightCars.getBackground()==Color.RED ? Color.WHITE : Color.BLACK);
		stateLightBoats.setText(getStringLightBoats());
		stateLightBoats.setBackground(lightBoats.getFeux()==ColorLights.ROUGE ? Color.RED : Color.GREEN);
		stateLightBoats.setForeground(stateLightBoats.getBackground()==Color.RED ? Color.WHITE : Color.BLACK);
		
		stateBarriers.setText(getStringBarriers());
		stateBarriers.setBackground(barriers.getState()==false ? Color.RED : Color.GREEN);
		stateBarriers.setForeground(stateBarriers.getBackground()==Color.RED ? Color.WHITE : Color.BLACK);
	}
	
	private String getStringBridge()
	{
		return "Bridge : "+bridge.getState();
	}
	
	private String getStringLightCars()
	{
		return "Cars' lights";
	}
	
	private String getStringLightBoats()
	{
		return "Boats' lights";
	}
	
	private String getStringBarriers()
	{
		return "Barriers are "+(barriers.getState()==false ? "Down" : "Up");
	}
}
