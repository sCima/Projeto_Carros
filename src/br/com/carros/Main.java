package br.com.carros;

import br.com.carros.combustiveis.Etanol;
import br.com.carros.combustiveis.Gasolina;
import br.com.carros.combustiveis.Diesel;
import br.com.carros.combustiveis.Alcool;
import br.com.carros.modelos.Caminhao;
import br.com.carros.modelos.Carro;


public class Main {
    public static void main(String[] args) {

        Etanol etanol = new Etanol();
        Gasolina gasolina = new Gasolina();
        Diesel diesel = new Diesel();
        Alcool alcool = new Alcool();

        Carro mercedes = new Carro("Vermelha", "Mercedes", "EYV-7325", 350.0);

        /*mercedes.abastecer(50);
        mercedes.ligar();
        mercedes.desligar();
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
        mercedes.ajustarTemperaturaArCondicionado(29);*/

        /*System.out.println();
        
        Caminhao scania = new Caminhao("Amarelo", "Scania", "CPO-1234", 150, 2);

        scania.abastecer(diesel, 100);
        scania.adicionarCarga(1000);
        scania.adicionarCarga(1500);
        scania.adicionarEixo(1);
        scania.adicionarCarga(200);
        
        scania.acelerar(140);
        scania.exibirRendimento();
        System.out.println();
        scania.computadorDeBordo();  // override */
    }
}