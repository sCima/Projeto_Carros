package br.com.carros.modelos;

import br.com.carros.combustiveis.Combustivel;

public class Moto extends Veiculo {
    private boolean pezinho, desativarPezinho, buzina;

    public Moto(String cor, String marca, String placa, double limiteVelocidade, Combustivel combustivel) {
        super(cor, marca, placa, limiteVelocidade, combustivel);
        this.pezinho = false;
        this.buzina = false;
    }

    public void apoiarPezinho() {
        if (this.pezinho) {
            System.out.println("Pezinho ja apoiado");
        } else {
            System.out.println("Pezinho foi apoiado");
            pezinho = true;
        }
    }

    public void subirPezinho() {
        if (!this.pezinho) {
            System.out.println("Pezinho não esta apoiado");
        } else {
            System.out.println("Pezinho foi levantado");
            pezinho = false;
        }
    }

    @Override
    public void acelerar(double valor) {
        if (estaLigado) {
            if (!pezinho) {
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
            } else {
                System.out.println("Impossivel acelerar pois o pezinho esta apoiado!");
            }
        } else if (tanque >= 1) {
            this.ligar();
            System.out.println("ao tentar acelerar");
            this.acelerar(valor);
        } else {
            System.out.println("Sem gasolina");
        }
    }
    /*public void desativarPezinho() {
        this.desativarPezinho = !this.desativarPezinho;
        if (this.desativarPezinho) {
            System.out.println("pezinho nao apoiado");
        } else {
            System.out.println("pezinho apoiado");
        }
    }*/

    /*public void buzina() {
        this.buzina = !this.buzina;
        if (this.buzina) {
            System.out.println("BEE BEE!!!");
        } else {

        }
    }*/
}
