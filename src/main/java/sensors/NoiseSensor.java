package sensors;

import java.util.Collections;

import sensorManagers.NoiseSensorManager;

public class NoiseSensor extends Sensor{
	
	private final NoiseSensorManager NoiseManager = new NoiseSensorManager(); 
	public NoiseSensor(String model,String reference){
		super(model,reference,"Noise");
		Collections.addAll(this.getListOfReadings(), 25,25,25,25,25,25,25,25,30,30,30,30,45,45,45,45);
	}
	int i = 0;
	public double getReading() {
		if(i==16) {
			i=0;
		}
		return NoiseManager.ConvertData(this.getListOfReadings().get(i++));
	}
}
