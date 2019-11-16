package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.sound.midi.*;

public class MessagePostbox {

	ShortMessage property;
	// contain a support object instead of extending the support class
	PropertyChangeSupport pcs;
	
	public MessagePostbox() {
		property = new ShortMessage();
		pcs = new  PropertyChangeSupport(this);
	}
	
	public void addObserver(PropertyChangeListener listen) {
		pcs.addPropertyChangeListener("theProperty", listen);
	}
	
	public void receiveMessage(ShortMessage msg) {
		ShortMessage old = property;
		property = msg;
		pcs.firePropertyChange("theProperty", old, msg);
	}
}
