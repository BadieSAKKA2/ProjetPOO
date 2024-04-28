package machines;

import java.util.ArrayList;
import java.util.List;
import sensors.Sensor;

public abstract class Machine {
	private String model;
	private String reference;
	private int durationOfCycle;
	private int numberOfProductsByCycle;
	private int percentageOfErrosByCycle;
	private boolean isOn;
	private int numberOfSensors;
	private int temperatureMax;
	private List<Sensor> listOfSensors;
	
	public Machine(String model,String reference,int durationOfCycle,int numberOfProductsByCycle, 
			int percentageOfErrosByCycle, int numberOfSensors, int temperatureMax  ) {
		this.model = model;
		this.reference = reference;
		this.durationOfCycle = durationOfCycle;
		this.numberOfProductsByCycle = numberOfProductsByCycle;
		this.percentageOfErrosByCycle = percentageOfErrosByCycle;
		this.isOn = true;
		this.numberOfSensors = numberOfSensors;	
		this.temperatureMax = temperatureMax;
		this.setListOfSensors(new ArrayList<Sensor>(numberOfSensors));  
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public int getDurationOfCycle() {
		return durationOfCycle;
	}
	public void setDurationOfCycle(int durationOfCycle) {
		this.durationOfCycle = durationOfCycle;
	}
	
	public int getNumberOfProductsByCycle() {
		return numberOfProductsByCycle;
	}
	public void setNumberOfProductsByCycle(int numberOfProductsByCycle) {
		this.numberOfProductsByCycle = numberOfProductsByCycle;
	}
	
	public int getPercentageOfErrosByCycle() {
		return percentageOfErrosByCycle;
	}
	public void setPercentageOfErrosByCycle(int percentageOfErrosByCycle) {
		this.percentageOfErrosByCycle = percentageOfErrosByCycle;
	}
	
	public boolean isOn() {
		return isOn;
	}
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	public int getNumberOfSensors() {
		return numberOfSensors;
	}
	public void setNumberOfSensors(int numberOfSensors) {
		this.numberOfSensors = numberOfSensors;
	}

	public int getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public List<Sensor> getListOfSensors() {
		return listOfSensors;
	}

	public void setListOfSensors(List<Sensor> listOfSensors) {
		this.listOfSensors = listOfSensors;
	}
	
	
	public double getSensorData(String sensorType) {
		for (int i = 0;i<numberOfSensors;i++) {
			if((listOfSensors.get(i)).getType() == sensorType) {
				return listOfSensors.get(i).getReading();
			
			}
		}
		return 0;
		
	}
	
}
