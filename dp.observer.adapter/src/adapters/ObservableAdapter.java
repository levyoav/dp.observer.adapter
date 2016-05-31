package adapters;

import java.util.Observable;

public class ObservableAdapter extends Observable {
	@Override
	public synchronized void setChanged() {
		super.setChanged();
	}
}
