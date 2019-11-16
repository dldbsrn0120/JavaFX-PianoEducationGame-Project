package application;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.sound.midi.*;

public class TestReceiver implements PropertyChangeListener, Receiver {

	private Receiver receiver;
	private ShortMessage shortmessage = null;
	private MessagePostbox messagePostbox;

	public TestReceiver() {
		try {
            this.receiver = MidiSystem.getReceiver();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
	}
	
	public TestReceiver(MessagePostbox messagePostbox) {
		try {
            this.receiver = MidiSystem.getReceiver();
            this.messagePostbox = messagePostbox;
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void send(MidiMessage message, long timeStamp) {
		// TODO Auto-generated method stub
		byte[] b = message.getMessage();
				
        if (b[0] != (byte)254) {
    		shortmessage = new ShortMessage();
    		try {
    			shortmessage.setMessage((b[0] & 0xff), 1, (b[1] & 0xff) ,(b[2] & 0xff));
    			messagePostbox.receiveMessage(shortmessage);
    			System.out.println("Msg : " + (b[0] & 0xff) + " " + (b[1] & 0xff) + 
    					" " + (b[2] & 0xff));
    			this.receiver.send(shortmessage, 1000);
    		} catch (InvalidMidiDataException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		this.receiver.close();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
