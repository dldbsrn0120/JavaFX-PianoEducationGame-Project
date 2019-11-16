package application;

import javax.sound.midi.*;

import application.GameSceneController.GameSceneListener;

public class MidiModel {
	
	private MidiDevice.Info[] midiDevicesInfos = null;
	private Transmitter transmitter = null;
	private Receiver receiver = null;
	private Sequencer sequencer = null;
	private Synthesizer synthesizer = null;
	
	private TestReceiver treceiver = null;
	
	private MidiDevice inputDevice = null;
	private MidiDevice outputDevice = null;
	
	private MidiDevice device = null;
	
	private ShortMessage expMsg = null;
	private ShortMessage expMsg2 = null;
	
	private MessagePostbox messagePostbox = null;
	
	private boolean ioflag = false;
	
	public MidiModel(GameSceneListener gamescenelistener) {
		expMsg = new ShortMessage();
		expMsg2 = new ShortMessage();
		
		messagePostbox = new MessagePostbox();
		messagePostbox.addObserver(gamescenelistener);
		
		midiDevicesInfos = MidiSystem.getMidiDeviceInfo();
		
		for(int i=0; i<midiDevicesInfos.length; i++) {
			try {
				if(i >= 4) ioflag = true;
				
		    device = MidiSystem.getMidiDevice(midiDevicesInfos[i]);
		    System.out.println("index : " + i);
		    System.out.println("Name : " + midiDevicesInfos[i].getName());
		    System.out.println("Description : " + midiDevicesInfos[i].getDescription());
		    System.out.println("Vendor : " + midiDevicesInfos[i].getVendor());
		    System.out.println("Version : " + midiDevicesInfos[i].getVersion());
			System.out.println("suc");
			
			System.out.println(device.getMaxReceivers());
			System.out.println(device.getMaxTransmitters());
			System.out.println(device.getMicrosecondPosition());
			} catch (MidiUnavailableException e) {
		      // Handle or throw exception...
		  }
		}

		try {
			sequencer = MidiSystem.getSequencer();
			System.out.println("Sequencer Dev info: " + sequencer.getDeviceInfo());
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			synthesizer = MidiSystem.getSynthesizer();
			System.out.println("Synthesizer Dev info: " + synthesizer.getDeviceInfo());
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		refreshIODevices();
	}
	
	public void printConsoleMidiDevices() {
		System.out.println("Test Finished");
	}
	
	public void refreshIODevices() {
		if(ioflag) {
			try {
				inputDevice = MidiSystem.getMidiDevice(midiDevicesInfos[4]);
				System.out.println("Input Dev info: " + inputDevice.getDeviceInfo());
				OpenDevice(inputDevice);
			} catch (MidiUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				outputDevice = MidiSystem.getMidiDevice(midiDevicesInfos[5]);
				System.out.println("Output Dev info: " + outputDevice.getDeviceInfo());
				SetDevice(outputDevice, synthesizer);
			} catch (MidiUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Sequencer getSequencer() {
		return this.sequencer;
	}
	
	public Receiver getReceiver() {
		return this.receiver;
	}
	
	public Transmitter getTransmitter() {
		return this.transmitter;
	}
	
	public void OpenDevice(MidiDevice device) {
		if (!(device.isOpen())) {
		    try {
		      device.open();
		      System.out.println("open successfully");
		      //device.close();
		  } catch (MidiUnavailableException e) {
		          // Handle or throw exception...
		  }
		}
	}
	
	public void SetDevice(MidiDevice oDevice, Synthesizer synthesizer) {
		try {
			if(!(oDevice.isOpen())) {
				oDevice.open();
			}
            treceiver = new TestReceiver(messagePostbox);         
            
            MidiSystem.getTransmitter().setReceiver(treceiver);

            System.out.println("ready");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
	}
	
	public void setOnMsg(String mode, ShortMessage expMsg) {
		if(expMsg != null) {
			try {
				if(mode == "on") expMsg.setMessage(0x90, 1, 60 ,100);
				else if(mode == "off") expMsg.setMessage(0x80, 1, 60, 100);
			} catch (InvalidMidiDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
