package br.com.carros.combustiveis;

public class Diesel implements Combustivel{
    @Override
    public double consumo(double litros) {
        return litros * 9;
    }
}
