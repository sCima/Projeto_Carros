package br.com.carros.modos;

public class Alto implements ModoGuidao{

    @Override
    public double modo(double limiteVelocidade) {
        return limiteVelocidade *= 0.9;
    }
}
