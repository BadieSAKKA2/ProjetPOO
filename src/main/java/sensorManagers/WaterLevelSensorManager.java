package sensorManagers;

public class WaterLevelSensorManager extends SensorManager {
	public WaterLevelSensorManager() {
		super("WaterLevel");
	}
	
	public double ConvertData(int reading){
		return (double)reading/22;
	}
}
