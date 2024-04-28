package sensors;

import java.util.Collections;

import sensorManagers.TemperatureSensorManger;

public class TemperatureSensor extends Sensor{
	private final TemperatureSensorManger TemperatureManager = new TemperatureSensorManger(); 
	public TemperatureSensor(String model,String reference){
		super(model,reference,"Temperature");
		Collections.addAll(this.getListOfReadings(), 25,25,25,25,25,25,25,25,30,30,30,30,45,45,45,45);
	}
	int i = 0;
	public double getReading() {
		if(i==16) {
			i=0;
		}
		return TemperatureManager.ConvertData(this.getListOfReadings().get(i++));
	}
}
