package sensorManagers;


public class TemperatureSensorManger extends SensorManager {
	
	public TemperatureSensorManger() {
		super("Temperature");
	}
	
	public double ConvertData(int reading){
		return (double)reading/2;
	}

}

