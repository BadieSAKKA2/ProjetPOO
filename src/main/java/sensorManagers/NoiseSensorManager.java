package sensorManagers;

public class NoiseSensorManager extends SensorManager{
	public NoiseSensorManager() {
		super("NoiseSensor");
	}

	@Override
	public double ConvertData(int reading){
		return (double)reading/2;
	}

}
