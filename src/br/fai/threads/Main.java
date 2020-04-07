package br.fai.threads;

import br.fai.services.Caminhao;

public class Main {

	public static void main(String[] args) {
	
		Main app = new Main();
		app.start();
		
	}

	private void start() {
		
		Caminhao primeiroCaminhao = new Caminhao (1 , 1);
		
		Caminhao segundoCaminhao = new Caminhao (2 , 2);
		
		Thread threadPrimeiroCaminhao = new Thread(primeiroCaminhao);
		
		Thread threadSegundoCaminhao = new Thread(segundoCaminhao);
		
		threadPrimeiroCaminhao.start();
		
		threadSegundoCaminhao.start();
		
		
	}

}
