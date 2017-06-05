package test____;

public class ThreadService extends Thread {
	
	public void run() {
		int count = 1;
		int size = 0;
		while (count++ < 20) {
			try {
				Thread.sleep(50);
//				drawLoding(getGraphics(), size);
				size += 10;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
