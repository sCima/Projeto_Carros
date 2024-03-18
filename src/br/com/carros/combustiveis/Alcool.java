package br.com.carros.combustiveis;

public class Alcool implements Combustivel {

	@Override
	public double rendimento(double tanque) {
		return tanque * 6;
	}

	
}
