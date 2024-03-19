package br.com.carros;

import br.com.carros.combustiveis.Diesel;
import br.com.carros.combustiveis.Etanol;
import br.com.carros.combustiveis.Gasolina;
import br.com.carros.modelos.Caminhao;
import br.com.carros.modelos.Carro;
import br.com.carros.modelos.Moto;
import br.com.carros.modos.Alto;
import br.com.carros.modos.Baixo;
import br.com.carros.modos.Medio;


public class Main {
    public static void main(String[] args) {

        Etanol etanol = new Etanol();
        Gasolina gasolina = new Gasolina();
        Diesel diesel = new Diesel();
        Baixo guidaoBaixo = new Baixo();
        Medio guidaoMedio = new Medio();
        Alto guidaoAlto = new Alto();

        // Carro
        Carro mercedes = new Carro("Vermelha", "Mercedes", "EYV-7325", 350.0, gasolina);

        mercedes.abastecer(50);
        mercedes.ligar();
        mercedes.desligar();
        System.out.println();
        mercedes.acelerar(325);
        mercedes.freiar(25);
        mercedes.computadorDeBordo();
        mercedes.acelerar(250);
        mercedes.freiar(350);
        //mercedes.ligarArCondicionado();
        mercedes.ajustarTemperaturaArCondicionado(29);

        System.out.println();

        // Caminhao
        Caminhao scania = new Caminhao("Amarelo", "Scania", "CPO-1234", 150, 2, diesel);

        scania.abastecer(100);
        scania.adicionarCarga(1000);
        scania.adicionarCarga(1500);
        scania.adicionarEixo(1);
        scania.adicionarCarga(2000);
        
        scania.acelerar(50);
        System.out.println();
        scania.computadorDeBordo();  // override

        System.out.println();

        // Moto
        Moto yamaha = new Moto("Branca", "Yamaha", "XYZ-0032", 300, etanol);

        yamaha.abastecer(20);
        yamaha.computadorDeBordo();
        yamaha.acelerar(50);
        yamaha.freiar(50);
        yamaha.computadorDeBordo();
        yamaha.acelerar(50);
        yamaha.acelerar(50);
        yamaha.acelerar(50);
        yamaha.acelerar(50);
        yamaha.freiar(200);
        yamaha.computadorDeBordo();
        yamaha.apoiarPezinho();
        yamaha.subirPezinho();
        yamaha.acelerar(20);
        yamaha.ajustarGuidao(guidaoAlto);
        yamaha.ajustarGuidao(guidaoMedio);
        //yamaha.ajustarGuidao(guidaoBaixo);
        yamaha.acelerar(500);
    }
}