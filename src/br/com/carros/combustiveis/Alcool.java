package br.com.carros.combustiveis;

public class Alcool implements Combustivel {

	@Override
	public double consumo(double tanque) {
		return tanque * 6;
	}

	
}
