package br.com.carros.modelos;

import br.com.carros.combustiveis.Combustivel;
import br.com.carros.modos.Baixo;
import br.com.carros.modos.Medio;
import br.com.carros.modos.ModoGuidao;

public class Moto extends Veiculo {
    private boolean pezinho;
    private String guidao;
    private double padraoVelocidade;

    public Moto(String cor, String marca, String placa, double limiteVelocidade, Combustivel combustivel) {
        super(cor, marca, placa, limiteVelocidade, combustivel);
        this.pezinho = false;
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

    public void ajustarGuidao(ModoGuidao guidao){
        padraoVelocidade = limiteVelocidade;
        padraoVelocidade = guidao.modo(padraoVelocidade);
        String posicaoGuidao;
        if (guidao instanceof Baixo)
            posicaoGuidao = "baixo";
        else if (guidao instanceof Medio)
            posicaoGuidao = "padrão";
        else
            posicaoGuidao = "alto";
        System.out.println("Guidão ajustado para: " + posicaoGuidao + "\nNovo limite de velocidade: " + padraoVelocidade);
    }

    @Override
    public void acelerar(double valor) {
        if (estaLigado) {
            if (!pezinho) {
                if (tanque >= 1) {
                    tanque -= tanque / valor;
                    if (this.velocidade + valor <= padraoVelocidade) {
                        this.velocidade += valor;
                    } else {
                        System.out.println("ATENÇÃO: Velocidade máxima atingida");
                        this.velocidade = padraoVelocidade;
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

}
