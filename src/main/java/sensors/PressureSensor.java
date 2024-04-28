package sensors;

import java.util.Collections;

import sensorManagers.PressureSensorManager;

public class PressureSensor extends Sensor{

	private final PressureSensorManager PressureManager = new PressureSensorManager(); 
	public PressureSensor(String model,String reference){
		super(model,reference,"Pressure");
		Collections.addAll(this.getListOfReadings(), 25,25,25,25,25,25,25,25,30,30,30,30,45,45,45,45);
	}
	int i = 0;
	public double getReading() {
		if(i==16) {
			i=0;
		}
		return PressureManager.ConvertData(this.getListOfReadings().get(i++));
	}
}
