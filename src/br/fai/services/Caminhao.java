package br.fai.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Caminhao implements Runnable {

	private int codCaminhao;
	private int tempo;
	
	private Map<Integer,Integer> limiteDaCaixa = new HashMap<Integer, Integer>();
	private Map<Integer,ArrayList<Integer>> caixaDePaes = new HashMap<Integer, ArrayList<Integer>>();
	
	private final int MAX_CAIXAS = 4;
	
	public Caminhao (int nome, int tempo) {
		
		this.codCaminhao = nome;
		this.tempo = tempo * 1000;
		
	}
	
	@Override
	public void run() {
		
		System.out.println("Caminhao "+ this.codCaminhao + "comecou a ser carregado...");
		setarLimitesDaCaixa();
		
		int numeroDaCaixa = 1;
		while(numeroDaCaixa <= MAX_CAIXAS) {
			
			carregarCaminhao(numeroDaCaixa);
			System.out.println("A caixa "+ numeroDaCaixa +" do caminhao "+ this.codCaminhao +" terminou de ser carregada.");
			
			numeroDaCaixa +=1;
		}
		
		System.out.println("Caminhao "+ this.codCaminhao + "terminou de ser carregado!");
		
		
	}
	
	private void setarLimitesDaCaixa() {
		limiteDaCaixa.put(1, 4);
		limiteDaCaixa.put(2, 2);
		limiteDaCaixa.put(3, 5);
		limiteDaCaixa.put(4, 6);
		
	}
	
	private void carregarCaminhao(int numeroDaCaixa) {
		
		caixaDePaes.put(numeroDaCaixa,new ArrayList<Integer>());
		int capacidadeCaixa = limiteDaCaixa.get(numeroDaCaixa);

		for(int i=0; i< capacidadeCaixa; i++) {
			caixaDePaes.get(numeroDaCaixa).add(i);
			try {
				Thread.sleep(this.tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O pao "+ i +" foi inserido na caixa "+ numeroDaCaixa +" no caminhao "+ this.codCaminhao);
		}
	}

}
