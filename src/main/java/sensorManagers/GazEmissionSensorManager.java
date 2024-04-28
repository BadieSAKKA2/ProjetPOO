package sensorManagers;

public class GazEmissionSensorManager extends SensorManager{
	public GazEmissionSensorManager() {
		super("GazEmission");
	}

	@Override
	public double ConvertData(int reading){
		return (double)reading/2;
	}

}
