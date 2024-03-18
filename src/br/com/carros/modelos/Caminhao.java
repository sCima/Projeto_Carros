package br.com.carros.modelos;

public class Caminhao extends Veiculo {

    private double litros, rendimentoCaminhao = 0, pesoCarga, tanque;
    private int limiteTanque = 200, numEixos, limitePeso, limiteEixos = 10;

    public Caminhao(String cor, String marca, String placa, double limiteVelocidade, int numEixos) {
        super(cor, marca, placa, limiteVelocidade);
        this.numEixos = numEixos;
        this.limitePeso = this.numEixos * 1000;
        this.hodometro = random.nextDouble()*30000;
    }

    public void adicionarCarga(double carga) {
        if(pesoCarga + carga <= limitePeso) {
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

    public void abastecer(double litros) {
        if (tanque + litros <= limiteTanque) {
            tanque += litros;
        } else {
            tanque = 200;
            System.out.println("Tanque cheio");
        }
    }

    public void exibirRendimento() {
        rendimentoCaminhao = (tanque * 9) / cargaPesada(); //Diesel
        System.out.printf("Tanque: %.2fl \nPeso: %.2fkg \nRendimento: %.2f Kms\n", tanque, pesoCarga, rendimentoCaminhao);
    }

    @Override
    public void computadorDeBordo() {
        String status;
        if(estaLigado)
            status = "ON";
        else
            status = "OFF";

        String avisoOleo;
        if(verificaTrocaOleo()) {
            avisoOleo = "Troca de óleo necessária!";
        }
        else {
            avisoOleo = "Troca de óleo não é necessária.";
        }
        System.out.printf("Status: %s \n" +
                "Hodômetro: %.2f \n" +
                "Tanque: %.2fl \n" +
                "Autonomia: %.2f km \n" +
                "Marca: %s \n" +
                "Cor: %s \n" +
                "Placa: %s \n" +
                "Condição do óleo: %s \n", status, hodometro, tanque, rendimentoCaminhao, marca, cor, placa, avisoOleo);
    }

    private boolean verificaTrocaOleo() {
        return hodometro >= 15000;
    }
}