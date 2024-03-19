package br.com.carros.modelos;

import br.com.carros.combustiveis.Combustivel;
import br.com.carros.combustiveis.Diesel;

public class Caminhao extends Veiculo {

    private double rendimentoCaminhao = 0, pesoCarga, tanque;
    private int limiteTanque = 200, numEixos, limitePeso, limiteEixos = 10;


    public Caminhao(String cor, String marca, String placa, double limiteVelocidade, int numEixos, Combustivel combustivel) {
        super(cor, marca, placa, limiteVelocidade, combustivel);
        this.numEixos = numEixos;
        this.limitePeso = this.numEixos * 1000;
        this.hodometro = random.nextDouble()*30000;
    }

    public void adicionarCarga(double carga) {
        if (pesoCarga + carga <= limitePeso) {
            pesoCarga += carga;
            System.out.printf("Carga adicionada: %.2fkg \n" +
                    "Carga total: %.2fkg \n", carga, pesoCarga);
        } else {
            System.out.printf("Impossível adicionar a carga de %.2f kg pois o limite máximo será ultrapassado! \n" +
                    "Foram carregados apenas %.2fkg \n", carga, limitePeso - pesoCarga);
            pesoCarga = limitePeso;
            System.out.printf("Carga atual: %.2fkg \n", pesoCarga);

        }
        System.out.println();
    }

    public void adicionarEixo(int novoEixo) {
        if(numEixos + novoEixo <= limiteEixos) {
            numEixos += novoEixo;
            limitePeso += (novoEixo  * 1000);
        }
        else {
            numEixos = limiteEixos;
            limitePeso = limiteEixos * 1000;
            System.out.println("Numero maximo de eixos atingido");
        }
        System.out.println("Limite de peso: " + limitePeso);
    }

    public int cargaPesada() {
        double teste = (pesoCarga / limitePeso) * 100;
        if(teste <= 70 ) //ate 70% da capacidadade = sem perda de rendimento
            return 1;
        else if(teste <= 80) //entre 70% e 80% da capacidade = perde metade do rendimento
            return 2;
        else
            return 3; //acima de 80% da capacidade  = perde 2/3 do rendimento
    }

    @Override
    public void abastecer(double litros) {
        if (combustivel instanceof Diesel)
            if (tanque + litros <= limiteTanque) {
                tanque += litros;
            } else {
                tanque = 200;
                System.out.println("Tanque cheio");
            }
        else
            System.out.println("Impossivel abastecer pois o combustivel é incompativel");
    }

    private void rendimento() {
        autonomia = combustivel.consumo(tanque) / cargaPesada();
    }

    @Override
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
                "Peso: %.2fkg \n" +
                "Autonomia: %.2f km \n" +
                "Marca: %s \n" +
                "Cor: %s \n" +
                "Placa: %s \n" +
                "Condição do óleo: %s \n" +
                "Número do chassis: %s \n" +
                "Ano de fabricação: %s \n", status, hodometro, tanque, pesoCarga, autonomia, marca, cor, placa, avisoOleo, numeroChassi, anoFabricacao.getYear()+1900);
    }

    private boolean verificaTrocaOleo() {
        return hodometro >= 15000;
    }

    @Override
    public void acelerar(double valor) {
        if (estaLigado) {
            if (this.tanque >= 1) {
                tanque -= tanque / valor;
                if (this.velocidade + valor <= limiteVelocidade) {
                    this.velocidade += valor;
                } else {
                    System.out.println("ATENÇÃO: Velocidade máxima atingida");
                    this.velocidade = limiteVelocidade;
                }
                System.out.printf("Você acelerou até: %.2f km/h \n", velocidade);
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