package br.com.carros.modos;

public class Medio implements ModoGuidao{

    @Override
    public double modo(double limiteVelocidade) {
        return limiteVelocidade *= 1;
    }
}
