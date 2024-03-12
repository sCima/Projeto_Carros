package br.com.carros;

import br.com.carros.modelos.Carro;


public class Main {
    public static void main(String[] args) {

        Carro mercedes = new Carro("Vermelha", "Mercedes", "EYV-7325", 350.0, (byte) 1);

        mercedes.ligar();
        mercedes.desligar();
        mercedes.ligar();
        mercedes.acelerar(325);
        mercedes.freiar(25);
        mercedes.abastecer(55);
        mercedes.rendimento();
        mercedes.freiar(299);

    }
}