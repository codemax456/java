
class PrintTest extends Thread {

	
	public void printThread(int n)
	{

		
		synchronized (this)
		{

			
			for (int i = 1; i <= 10; i++) {

				
				System.out.println("Thread " + n
								+ " is working...");

				// Try block to check for exceptions
				try {

					// Making thread to pause for 0.6
					// seconds
					Thread.sleep(600);
				}

				// Catch block to handle exceptions
				catch (Exception ex) {

					// Print message when exception.s occur
					System.out.println(ex.toString());
				}
			}
		}

		// Display message only
		System.out.println("--------------------------");

		try {

			// Making thread t osleep for 1 sec
			Thread.sleep(1000);
		}

		catch (Exception ex) {

			System.out.println(ex.toString());
		}
	}
}

// Class 2
// Helper class extending Thread class
class Thread1 extends Thread {

	PrintTest test;
	Thread1(PrintTest p) { test = p; }

	public void run() { test.printThread(1); }
}

// Class 3
// Helper class extending Thread class
class Thread2 extends Thread {

	PrintTest test;
	Thread2(PrintTest p) { test = p; }

	public void run() { test.printThread(2); }
}

// Class 4
// Main class
class SynchroTest {

	// Main driver method
	public static void main(String[] args)
	{

		// Creating instance for class 1 inside main()
		PrintTest p = new PrintTest();

		// Creating threads and
		// passing same object
		Thread1 t1 = new Thread1(p);
		Thread2 t2 = new Thread2(p);

		// Starting these thread using start() method
		t1.start();
		t2.start();
	}
}
