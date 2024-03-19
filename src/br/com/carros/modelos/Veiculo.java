package br.com.carros.modelos;

import br.com.carros.combustiveis.Combustivel;
import br.com.carros.combustiveis.Etanol;
import br.com.carros.combustiveis.Gasolina;

import java.util.Date;
import java.util.Random;

public class Veiculo {
    protected String cor, marca, placa, numeroChassi;
    protected Date anoFabricacao;
    protected boolean estaLigado;
    protected double velocidade, limiteVelocidade, tanque, autonomia, hodometro;
    protected Combustivel combustivel;


    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    public String geraNumeroChassis() {
        // LVVDA11A75D029813
        // Prefixo (2 continente 1 fabricante)
        for (int i = 0; i < 4; i++) {
            sb.append((char) ('A' + random.nextInt(26)));
        }

        // Números (descrição do veiculo e ano fabricação)
        for (int i = 0; i< 7; i++) {
            sb.append(random.nextInt(10));
        }

        // Sufixo (codigo serial)
        for (int i = 0; i < 4; i++) {
            sb.append((char) ('A' + random.nextInt(26)));
        }

        return sb.toString();
    }

    public Veiculo(String cor, String marca, String placa, double limiteVelocidade, Combustivel combustivel) {
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.anoFabricacao = new Date();
        this.estaLigado = true;
        this.limiteVelocidade = limiteVelocidade;
        this.hodometro = random.nextDouble() * 9999;
        this.numeroChassi = geraNumeroChassis();
        this.combustivel = combustivel;
    }

    public void ligar() {
        if (estaLigado) {
            System.out.println("Já tá ligado");
        }
        if (!estaLigado && tanque >= 1) {
            estaLigado = true;
            System.out.printf("O veículo %s foi ligado ", marca);
        } else if (!estaLigado && tanque <= 0) {
            System.out.println("Você tá sem gasolina");
        }
    }

    public void desligar() {
        if (!estaLigado) {
            System.out.println("Já tá desligado");
        } else {
            estaLigado = false;
            System.out.println("Desligado");
        }
    }

    public void acelerar(double valor) {
        if (estaLigado) {
            if (tanque >= 1) {
                tanque -= tanque / valor;
                if (this.velocidade + valor <= limiteVelocidade) {
                    this.velocidade += valor;
                } else {
                    System.out.println("ATENÇÃO: Velocidade máxima atingida");
                    this.velocidade = limiteVelocidade;
                }
                System.out.printf("\nVocê acelerou até: %.2f km/h \n", velocidade);
            }
        } else if (tanque >= 1) {
            this.ligar();
            System.out.println("ao tentar acelerar");
            this.acelerar(valor);
        } else {
            System.out.println("Sem gasolina");
        }
    }

    public void freiar(double valor) {
        if (estaLigado) {
            if (this.velocidade - valor >= 0) {
                this.velocidade -= valor;
            } else {
                this.velocidade = 0;
            }
        }
        System.out.printf("Você freiou até: %.2fkm/h \n", this.velocidade);
        System.out.println();
    }

    public void abastecer(double litros) {
        if (tanque + litros > 50) {
            tanque = 50;
        } else {
            tanque += litros;
        }
        System.out.println("Tanque: " + tanque + "l");
    }

    private double rendimento() {
        return autonomia = combustivel.consumo(tanque);
    }

    public void computadorDeBordo() {
        rendimento();
        String status;
        if (estaLigado)
            status = "ON";
        else
            status = "OFF";

        String avisoOleo;
        if (verificaTrocaOleo()) {
            avisoOleo = "Troca de óleo necessária!";
        } else {
            avisoOleo = "Troca de óleo não é necessária.";
        }
        System.out.printf("Status: %s \n" +
                "Hodômetro: %.2f \n" +
                "Tanque: %.2fl \n" +
                "Autonomia: %.2f km \n" +
                "Marca: %s \n" +
                "Cor: %s \n" +
                "Placa: %s \n" +
                "Condição do óleo: %s \n" +
                "Número do chassis: %s \n", status, hodometro, tanque, autonomia, marca, cor, placa, avisoOleo, numeroChassi);
    }

    private boolean verificaTrocaOleo() {
        return hodometro >= 6000;
    }
}
