package sensors;

import java.util.ArrayList;
import java.util.List;


public abstract class Sensor {
	private String model;
	private String reference;
	private String type;
	private List<Integer> listOfReadings = new ArrayList<Integer>();
	
	public Sensor(String model,String reference,String type) {
		this.model = model;
		this.reference = reference;
		this.type = type;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}


	public List<Integer> getListOfReadings() {
		return listOfReadings;
	}

	public void setListOfReadings(List<Integer> listOfReadings) {
		this.listOfReadings = listOfReadings;
	}
	
	public abstract double getReading();
}
