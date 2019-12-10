package multithreading;

public class OddEven implements Runnable {

	public void run() {

		for (int i = 1; i <= 10; i++) {
			synchronized (this) {

				if (i % 2 == 1 && Thread.currentThread().getName().equals("Thread1")) {

					try {
						notifyAll();
						System.out.println("Thread 1 : " + i);
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (i % 2 == 0 && Thread.currentThread().getName().equals("Thread2")) {

					try {
						notifyAll();

						System.out.println("Thread 2 : " + i);
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}

	public static void main(String[] args) {
		OddEven runnable = new OddEven();

		Thread t1 = new Thread(runnable, "Thread1");
		Thread t2 = new Thread(runnable, "Thread2");

		t1.start();
		t2.start();
	}

}
