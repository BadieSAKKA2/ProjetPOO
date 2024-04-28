package machines;

import sensors.GazEmissionSensor;
import sensors.NoiseSensor;
import sensors.PressureSensor;
import sensors.TemperatureSensor;
import sensors.WaterLevelSensor;

public class PompeAirComprime extends Machine{
	private int pressionMax;
	private int noiseMax;
	
	
	public PompeAirComprime(String model,String reference,int durationOfCycle,int numberOfProductsByCycle, 
			int percentageOfErrosByCycle, int numberOfSensors, int temperatureMax, int pressionMax,int noiseMax) {
		super(model,reference,durationOfCycle,numberOfProductsByCycle,percentageOfErrosByCycle,numberOfSensors,temperatureMax);
		this.setPressionMax(pressionMax);
		this.setNoiseMax(noiseMax);
		this.getListOfSensors().add(new TemperatureSensor("Thermo","T1025"));
		this.getListOfSensors().add(new NoiseSensor("Noise","N1025"));
		this.getListOfSensors().add(new PressureSensor("Pressure","P1025"));
		this.getListOfSensors().add(new WaterLevelSensor("WaterLevel","WT1025"));
		this.getListOfSensors().add(new GazEmissionSensor("GazEmission","GE1025"));
	}
	
	public int getPressionMax() {
		return pressionMax;
	}

	public void setPressionMax(int pressionMax) {
		this.pressionMax = pressionMax;
	}

	public int getNoiseMax() {
		return noiseMax;
	}

	public void setNoiseMax(int noiseMax) {
		this.noiseMax = noiseMax;
	}
}
