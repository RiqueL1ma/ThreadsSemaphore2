package View;

import java.util.concurrent.Semaphore;

import Controller.Threads;

public class Principal {
	public static void main(String args[]) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 0; i < 300; i++) {
			Thread exec = new Threads(i, semaforo);
			exec.start();
		}
		
		
		
	}
}
