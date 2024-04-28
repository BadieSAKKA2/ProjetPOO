package sensors;

import java.util.Collections;

import sensorManagers.GazEmissionSensorManager;

public class GazEmissionSensor extends Sensor {
	private final GazEmissionSensorManager GazEmissionManager = new GazEmissionSensorManager(); 
	public GazEmissionSensor(String model,String reference){
		super(model,reference,"GazEmission");
		Collections.addAll(this.getListOfReadings(), 25,25,25,25,25,25,25,25,30,30,30,30,45,45,45,45);
	}
	int i = 0;
	public double getReading() {
		if(i==16) {
			i=0;
		}
		return GazEmissionManager.ConvertData(this.getListOfReadings().get(i++));
	}
}
