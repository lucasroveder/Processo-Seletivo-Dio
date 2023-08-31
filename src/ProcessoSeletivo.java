import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        selecaoCandidatos();
    }
    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        String [] candidatosPassados = new String[5];
        int candidatosSelecionados = 0;
        int candidatoAtual=0;
        while(candidatosSelecionados<5 && candidatoAtual < 10){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O CANDIDATO " + candidato + " SOLICITOU R$" + salarioPretendido);
            int a = analisaCandidatos(salarioPretendido);
            System.out.println(a);
            if(a <= 2){
                candidatosPassados[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
        System.out.println("LIGANDO PARA OS CANDIDATOS QUE PASSARAM");
        fazLigacao(candidatosPassados);
    }

    static void fazLigacao(String [] candidatos){
        int numeroLigacoes = 0;
        boolean ligando;
        for(int i = 0 ; i < candidatos.length; i++){
            while(numeroLigacoes<3 && candidatos != null){
                ligando = ThreadLocalRandom.current().nextBoolean();
                if(ligando == true){
                    System.out.println("O CANDIDATO " + candidatos[i] + " ATENDEU E ESTA APTO PARA A VAGA");
                    break;
                }
                else if (numeroLigacoes == 2 && ligando == false){
                    System.out.println("O CANDIDATO NAO ATENDEU DENTRE O NUMERO MAXIMO DE TENTATIVAS E INFELIZMENTE NAO ESTA MAIS SELECIONADO PARA A VAGA");
                    break;
                }
                else{
                    numeroLigacoes++;
                }

            }
        }
    }


    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static int analisaCandidatos(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("O CANDIDATO ATUAL FOI SELECIONADO PARA VAGA");
            System.out.println("LIGAR PARA O CANDIDATO");
            System.out.println("");
            System.out.println("");
            return 1;
        }
        else if(salarioBase == salarioPretendido){
            System.out.println("O CANDIDATO ATUAL FOI SELECIONADO PARA VAGA");
            System.out.println("LIGAR PARA O CANDIDATO COM UMA CONTRA PROPOSTA");
            System.out.println("");
            System.out.println("");
            return 2;
        }
        else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
            System.out.println("");
            System.out.println("");
            return 3;
        }

    }
}
