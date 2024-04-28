package sensorManagers;


public class PressureSensorManager extends SensorManager{
	
	public PressureSensorManager() {
		super("Pressure");
	}

	@Override
	public double ConvertData(int reading){
		return (double)reading/2;
	}

}
