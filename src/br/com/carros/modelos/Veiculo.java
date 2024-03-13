package br.com.carros.modelos;

import br.com.carros.combustiveis.Combustivel;
import br.com.carros.combustiveis.Etanol;
import br.com.carros.combustiveis.Gasolina;

import java.util.Date;

public class Veiculo {
    protected String cor, marca, placa;
    protected Date anoFabricacao;
    protected boolean estaLigado;
    protected double velocidade, limiteVelocidade, tanque, autonomia;


    public Veiculo(String cor, String marca, String placa, double limiteVelocidade) {
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.anoFabricacao = new Date();
        this.estaLigado = true;
        this.limiteVelocidade = limiteVelocidade;
    }

    public void ligar() {
        if(estaLigado) {
            System.out.println("Já tá ligado");
        }
        if (!estaLigado && tanque >= 1) {
            estaLigado = true;
            System.out.printf("O veículo %s foi ligado ", marca);
        } else if(!estaLigado && tanque <= 0) {
            System.out.println("Você tá sem gasolina");
        }
    }
    public void desligar() {
        if(!estaLigado) {
            System.out.println("Já tá desligado");
        } else {
            estaLigado = false;
            System.out.println("Desligado");
        }
    }
    public void acelerar(double valor) {
        if (estaLigado) {
            if(tanque >= 1) {
                if (this.velocidade + valor <= limiteVelocidade) {
                    this.velocidade += valor;
                } else {
                    System.out.println("Quer voar?");
                    this.velocidade = limiteVelocidade;
                }
                System.out.printf("\nVocê acelerou até: %.2f km/h \n", velocidade);
            }
        } else if (tanque >= 1){
            this.ligar();
            System.out.println("ao tentar acelerar");
            this.acelerar(valor);
        } else {
            System.out.println("Sem gasolina");
        }

    }
    public void freiar(double valor) {
        if(estaLigado) {
            if(this.velocidade - valor >= 0) {
                this.velocidade -= valor;
            } else {
                this.velocidade = 0;
            }
        }
        System.out.printf("Você freiou até: %.2fkm/h \n", this.velocidade);
    }

    public void abastecer(double litros) {
        if (tanque + litros > 50) {
            tanque = 50;
        } else {
            tanque += litros;
        }
        System.out.println("Tanque: " + tanque + "l");
    }

    public void rendimento(Combustivel combustivel) {
        System.out.println(combustivel.consumo(tanque) + " km podem ser percorridos");
        autonomia = combustivel.consumo(tanque);
    }

    public void computadorDeBordo() {
        String status;
        if(estaLigado)
            status = "ON";
        else
            status = "OFF";

        System.out.printf("Status: %s \n" +
                "Tanque: %.2fl \n" +
                "Autonomia: %.2f km \n" +
                "Marca: %s \n" +
                "Cor: %s \n" +
                "Placa: %s \n", status, tanque, autonomia, marca, cor, placa);
    }
}
