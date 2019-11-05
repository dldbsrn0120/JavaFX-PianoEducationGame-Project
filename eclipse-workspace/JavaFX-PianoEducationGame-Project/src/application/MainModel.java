package application;

public class MainModel {
	
	private int sharedData = 1;
	
	public MainModel()
	{
		setSharedData(0);
	}

	public int getSharedData() {
		return sharedData;
	}

	public void setSharedData(int sharedData) {
		this.sharedData = sharedData;
	}
	
	public void increaseSharedData() {
		sharedData += 5;
	}
	
	public void decreaseSharedData() {
		sharedData -= 5;
	}
	
	public void multiplySharedData() {
		sharedData *= 2;
	}
}
