package br.com.carros.modos;

public class Baixo implements ModoGuidao{

    @Override
    public double modo(double limiteVelocidade) {
        return limiteVelocidade *= 1.1;
    }
}
