package controller;

import java.util.concurrent.Semaphore;

public class A extends Thread {
	
	private int aviao;
	private Semaphore semaforoN;
	private Semaphore semaforoS;
	
	public A (int aviao, Semaphore semaforoN, Semaphore semaforoS) {
		this.aviao = aviao;
		this.semaforoN = semaforoN;
		this.semaforoS = semaforoS;

	}

	public void run() {
		if (aviao % 2 == 1) {
		manobra();
		taxiar();
		try {
			semaforoN.acquire();
			decolagem();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoN.release();
			afastamento();
		}
		}
		else {
			manobra();
			taxiar();
			try {
				semaforoS.acquire();
				decolagem();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoS.release();
				afastamento();
			}
			
			}
		}
		
		
	
	public void manobra() {
		
		System.out.println("O avião " + aviao + " está na fase manobra" ); 
		int tempoManobra = (int) ((Math.random() * 5) + 3);
		try {
			sleep(tempoManobra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void taxiar () {
		System.out.println("O avião " + aviao + " está na fase taxiar" );
		int tempoTaxiar = (int) ((Math.random() * 6) + 5);
		try {
			sleep(tempoTaxiar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void decolagem () {
		System.out.println("O avião " + aviao + " está na fase decolagem" ); 
		int tempoDecolagem = (int) ((Math.random() * 4) + 1);
		try {
			sleep(tempoDecolagem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	public void afastamento() {
		System.out.println("O avião " + aviao + " está na fase afastamento" );
		int tempoAfastamento = (int) ((Math.random() * 6) + 3 );
		try {
			sleep(tempoAfastamento);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}