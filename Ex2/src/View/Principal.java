package View;

import java.util.concurrent.Semaphore;

import Controller.Threads;

public class Principal {

	public static void main(String[] args) {

		Semaphore semaforo0 = new Semaphore(1);
		Semaphore semaforo1 = new Semaphore(1);
		
		for (int i = 1; i < 13; i++) {
			Thread exec = new Threads(semaforo0, semaforo1, i);
			exec.start();
		}
		
	}

}
