package br.com.carros;

import br.com.carros.combustiveis.Etanol;
import br.com.carros.combustiveis.Gasolina;
import br.com.carros.modelos.Caminhao;
import br.com.carros.modelos.Carro;


public class Main {
    public static void main(String[] args) {

        Etanol etanol = new Etanol();
        Gasolina gasolina = new Gasolina();

        Carro mercedes = new Carro("Vermelha", "Mercedes", "EYV-7325", 350.0);

        mercedes.abastecer(50);
        mercedes.ligar();
        mercedes.desligar();
        //mercedes.ligar(); // teste
        System.out.println();
        mercedes.acelerar(325);
        mercedes.freiar(25);
        System.out.println();
        mercedes.abastecer(55);
        mercedes.rendimento(gasolina);
        System.out.println();
        mercedes.computadorDeBordo();
        System.out.println();
        mercedes.acelerar(250);
        mercedes.freiar(350);
        //mercedes.ligarArCondicionado();
        mercedes.ajustarTemperaturaArCondicionado(29);

        /*Caminhao scania = new Caminhao("Amarelo", "Scania", "CPO-1234", 150, 2);

        System.out.println();

        scania.abastecer(gasolina, 100);
        scania.adicionarEixo(2);
        scania.adicionarCarga(1500);
        scania.adicionarCarga(1500);
        scania.adicionarCarga(1500);
        scania.acelerar(190);

        scania.exibirRendimento();
        System.out.println();
        scania.computadorDeBordo();*/  // override
    }
}