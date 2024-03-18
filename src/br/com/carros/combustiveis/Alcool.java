package br.com.carros.combustiveis;

public class Alcool implements Combustivel {

	@Override
	public double consumo(double litros) {
		return litros * 6;
	}

	
}
