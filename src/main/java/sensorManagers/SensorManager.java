package sensorManagers;

public abstract class SensorManager implements ISensorManager{
	private String type;
	
	public SensorManager(String type) {
		this.setType(type);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
