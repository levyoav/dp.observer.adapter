package observables;

import java.util.Observer;

import events.TempChangedEvent;
import abstracts.AbstractThermometer;
import adapters.ObservableAdapter;

public class Thermometer extends AbstractThermometer {
	/*
	 * Instead of implementing the interface Observable, the class holds an object
	 * that extends Observable as an attribute. It actually functions as an adapter
	 * to the observable interface. In this manner, we can adopt methods of this
	 * class to the actual behaviour of an Observable object by adding features to
	 * the methods invoking the Observable methods, using methods with different
	 * signatures that wrap the Observable methods or simply not implementing them,
	 * as oppose to the case where this class would have implemented Observable.
	 */
	private ObservableAdapter observable;

	public Thermometer(double temp) {
		super();
		this.temp = temp;
		this.observable = new ObservableAdapter();
		System.out.println("Thermometer samples: " + temp);

	}

	/*
	 * Wrapping the Observable methods with this calss's methods. In this casem,
	 * there is no difference between the methods functionality of signature.
	 */
	public void addObserver(Observer observer) {
		this.observable.addObserver(observer);
	}

	public void deleteObserver(Observer observer) {
		this.observable.deleteObserver(observer);
	}

	public double getTemp() {
		return this.temp;
	}

	@Override
	public double sampleTemp() {
		double newTemp = super.sampleTemp();

		if (this.temp != newTemp) {
			/*
			 * Using the adapter to invoke the setChanged() method of the Observable.
			 */
			this.observable.setChanged();
		}

		TempChangedEvent event = new TempChangedEvent(this.temp, newTemp);
		this.temp = newTemp;

		/*
		 * Using the adapter to invoke the notifyObservers() method of the Observable.
		 */
		this.observable.notifyObservers(event);

		return newTemp;
	}
}
