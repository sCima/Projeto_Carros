package br.com.carros.combustiveis;

public class Gasolina implements Combustivel{

    @Override
    public double consumo(double litros) {
        return litros * 10;
    }
}