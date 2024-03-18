package br.com.carros.combustiveis;

public class Diesel implements Combustivel{

	@Override
	public double rendimento(double tanque) {
		return tanque * 10;
	}
	
}
