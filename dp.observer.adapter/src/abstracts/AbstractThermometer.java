package abstracts;

public abstract class AbstractThermometer {
	protected double temp;

	public double sampleTemp () {
		double rand = Math.random();
		double newTemp = temp;

		if (rand < 0.25){
			newTemp = temp - 1;
		}else if (rand > 0.75){
			newTemp = temp + 1;
		}

		System.out.println("Thermometer samples: " + temp);

		return newTemp;
	}

}
