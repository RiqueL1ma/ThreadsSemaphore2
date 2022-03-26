package Controller;

import java.util.concurrent.Semaphore;

public class Threads extends Thread {
	private int numb = 0;
	Semaphore semaforo;
	private static int igquant = 100;

	public Threads(int numb, Semaphore sem) {
		this.numb = numb;
		this.semaforo = sem;
	}

	public void run() {
		try {
			int res = (int) ((Math.random() * 1501) + 500);
			if (res <= 1000) {
				sleep(res);
				System.out.println("Thread: " + numb + " realizou a 1º etapa tempo: " + res);
				compre();
			} else {
				sleep(res);
				System.out.println("Thread: " + numb + " excedeu o tempo: " + res);

			}
		} catch (Exception e) {
		}
		super.run();
	}

	public void compre() {
		int tempoCompra = (int) ((Math.random() * 1001) + 2000);

		if (tempoCompra <= 2500) {
			try {
				sleep(tempoCompra);
				igres();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Thread: " + numb
					+ "Final de tempo de sessão, compra temp: " + tempoCompra);

		}
	}

	public void igres() {
		try {
			semaforo.acquire();
			int requisicao = (int) ((Math.random() * 4) + 1);
			if (igquant >= requisicao) {
				igquant -= requisicao;
				System.out.println(
						"Thread: " + numb + " comprou: " + requisicao + " ingresso(s) e ainda tem: " + igquant + " ingresso(s)");

			} else {
				System.err.println("Thread: " + numb + " excedeu a quantidade de ingressos");

			}
		} catch (Exception a) {
		} finally {
			semaforo.release();
		}
	}
}
