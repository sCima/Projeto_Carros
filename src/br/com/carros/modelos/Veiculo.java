package br.com.carros.modelos;

import br.com.carros.combustiveis.Etanol;
import br.com.carros.combustiveis.Gasolina;

import java.util.Date;

public class Veiculo {
    protected String cor, marca, placa;
    protected Date anoFabricacao;
    private boolean estaLigado;
    private double velocidade, limite, tanque, tipoCombustivel;

    Etanol etanol = new Etanol();
    Gasolina gasolina = new Gasolina();

    public Veiculo(String cor, String marca, String placa, double limite, byte tipoCombustivel) {
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.anoFabricacao = new Date();
        this.estaLigado = true;
        this.limite = limite;
        this.tipoCombustivel = tipoCombustivel;
    }

    public void ligar() {
        if(estaLigado) {
            System.out.println("Já tá ligado");

        } else {
            estaLigado = true;
            System.out.println("Tchtchtchtchtch vrooom");
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
            if (this.velocidade + valor <= limite) {
                this.velocidade += valor;
            } else {
                System.out.println("Quer voar?");
                this.velocidade = limite;
            }
        }
        else {
            this.ligar();
            this.acelerar(valor);
        }
        System.out.println("Km/h: " + this.velocidade);
    }
    public void freiar(double valor) {
        if(estaLigado) {
            if(this.velocidade - valor >= 0) {
                this.velocidade -= valor;
            } else {
                this.velocidade = 0;
            }
        }
        System.out.println("Km/h: " + this.velocidade);
    }

    public void abastecer(double litros) {
        if (tanque + litros > 50) {
            tanque = 50;
        } else {
            tanque += litros;
        }
        System.out.println("Tanque: " + tanque + "l");
    }

    public void rendimento() {
        if (tipoCombustivel == 1) {
            System.out.println(gasolina.consumo(tanque) + " km podem ser percorridos");
        } else if (tipoCombustivel == 2) {
            System.out.println(etanol.consumo(tanque) + " km podem ser percorridos");
        } else {
            System.out.println("Tipo de combustivel incorreto");
        }
    }
}
