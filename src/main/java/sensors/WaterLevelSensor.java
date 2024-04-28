package sensors;

import java.util.Collections;
import sensorManagers.WaterLevelSensorManager;
public class WaterLevelSensor extends Sensor {
	private final WaterLevelSensorManager waterManager = new WaterLevelSensorManager();
	public WaterLevelSensor(String model,String reference){
		super(model,reference,"WaterLevel");
		Collections.addAll(this.getListOfReadings(), 25,25,25,25,25,25,25,25,30,30,30,30,45,45,45,45);
	}

	int i = 0;
	public double getReading() {
		if(i==16) {
			i=0;
		}
		return waterManager.ConvertData(this.getListOfReadings().get(i++));
	}
}


