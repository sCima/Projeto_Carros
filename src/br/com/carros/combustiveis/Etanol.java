package br.com.carros.combustiveis;

public class Etanol implements Combustivel{

    @Override
    public double consumo(double litros) {
        return litros * 7.5;
    }
}
