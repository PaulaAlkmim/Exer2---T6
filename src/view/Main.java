package view;

import java.util.concurrent.Semaphore;

import controller.A;


public class Main {

	public static void main(String[] args) {
	
		Semaphore semaforoN = new Semaphore(1);
		Semaphore semaforoS = new Semaphore(1);
		for (int aviao = 1 ; aviao <= 12 ; aviao++) {
			Thread t = new A(aviao, semaforoN, semaforoS);
			t.start();
		}

	}

}
