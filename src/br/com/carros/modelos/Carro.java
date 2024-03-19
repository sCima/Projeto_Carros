package br.com.carros.modelos;

import br.com.carros.combustiveis.Combustivel;

public class Carro extends Veiculo {
    private boolean vidroEletricoFrontal, vidroEletricoTraseiro, arCondicionado;
    private double temperatura = 23;

    public Carro(String cor, String marca, String placa, double limiteVelocidade, Combustivel combustivel) {
        super(cor, marca, placa, limiteVelocidade, combustivel);
        this.vidroEletricoFrontal = false;
        this.vidroEletricoTraseiro = false;
        this.arCondicionado = false;
    }

    public void vidroEletricoFrontal() {
        this.vidroEletricoFrontal = !this.vidroEletricoFrontal;
        if (this.vidroEletricoFrontal) {
            System.out.println("Vidro elétrico frontal operado.");
        } else {
            System.out.println("Vidro elétrico frontal fechado.");
        }
    }

    public void vidroEletricoTraseiro() {
        this.vidroEletricoTraseiro = !this.vidroEletricoTraseiro;
        if (this.vidroEletricoTraseiro) {
            System.out.println("Vidro elétrico traseiro operado.");
        } else {
            System.out.println("Vidro elétrico traseiro fechado.");
        }
    }

    public void ligarArCondicionado() {
        if (!this.arCondicionado) {
            this.arCondicionado = true;
            System.out.println("Ar condicionado ligado.");
        } else {
            System.out.println("Ar condicionado já está ligado.");
        }
    }

    public void desligarArCondicionado() {
        if (this.arCondicionado) {
            this.arCondicionado = false;
            System.out.println("Ar condicionado desligado.");
        } else {
            System.out.println("Ar condicionado já está desligado.");
        }
    }

    public void ajustarTemperaturaArCondicionado(double temperatura) {

        if (this.arCondicionado) {
            if (temperatura > 28) {
                System.out.println("Limite maximo de temperatura atingido.");
                temperatura = 28;
            } else if(temperatura < 16)  {
                System.out.println("Limite mínimo de temperatura atingido.");
                temperatura = 16;
            }
            this.temperatura = temperatura;
            System.out.println("Temperatura do ar condicionado ajustada para: " + temperatura + " °C");
        } else {
            System.out.println("Ar condicionado não está ligado. Ligando...");
            this.ligarArCondicionado();
            this.ajustarTemperaturaArCondicionado(temperatura);
        }
    }
}
