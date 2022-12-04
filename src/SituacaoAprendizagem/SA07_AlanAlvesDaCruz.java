package SituacaoAprendizagem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SA07_AlanAlvesDaCruz {

    static List<Aviao> listaAviao = new ArrayList<>();
    static int contador = 0;
    static Aviao aviao;

    public static void main(String[] args) {

        Passagem pass = new Passagem();

        String opcao;

        //Estrutura de repetição para manter o programa persistente até que seja escolhida a opção para encerrar
        do {
            opcao = JOptionPane.showInputDialog
                    ("---------- SWEET FLIGHT ----------\n" +
                     "Escolha uma opção abaixo: \n" +
                     "1 - Registrar Avião -\n" +
                     "2 - Registrar Assentos disponíveis por Avião -\n" +
                     "3 - Reservas de Passagem -\n" +
                     "4 - Realizar Consulta Por Avião -\n" +
                     "5 - Realizar Consulta Por Passageiro -\n" +
                     "6 - Encerrar -\n" +
                     "--------------------------------------------");

            switch (opcao) {

                //Registrar Aviões
                case "1":

                    int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantos Aviões serão cadastrados?"));
                    registrarAviao(qtd);

                    break;

                //Registra Assentos por Avião
                case "2":

                    if (listaAviao.isEmpty()){
                        semAviao();
                    }else {
                        registrarAssentos();
                    }

                    break;

                //Registrar Reservas por Avião
                case "3":

                    if (listaAviao.isEmpty()){
                        semAviao();
                    }else {
                        reservas();
                    }

                    break;

                //Consulta Reservas por Avião
                case "4":

                    if (listaAviao.isEmpty()){
                        semAviao();
                    }else {
                        buscarAviao();
                    }

                    break;

                //Consulta Reservas por Passageiro
                case "5":

                    if (listaAviao.isEmpty()){
                        semAviao();
                    }else {
                        buscarPassageiro();
                    }

                    break;

                //Encerra o Programa
                case "6":

                    JOptionPane.showMessageDialog(null, "Encerrando Programa!!");
                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Opção Inválida!!");
            }
        }while(!opcao.equalsIgnoreCase("6"));


    }

    //Mensagem de erro caso não haja aviões cadastrados
    public static void semAviao(){
        JOptionPane.showMessageDialog(null, "Sem Aviões Cadastrados!! Registre um avião e tente novamente.");
    }

    //Recursividade para registrar aviões
    public static void registrarAviao(int qtd){

        //Enquanto a quantidade informada for diferente de zero vai efetuar o codigo a seguir
        if(qtd != 0) {
            //Cria um novo objeto para inserir novos dados
            aviao = new Aviao();
            aviao.setIdAviao(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do Avião")));
            listaAviao.add(aviao);
            //Chama o procedimento criando a recursividade reduzindo -1 a cada iteração
            registrarAviao(qtd - 1);

        //Quando qtd = 0 finaliza a recursividade
        }else{
            JOptionPane.showMessageDialog(null, "Aviões Registrados com Sucesso!!");
        }
    }

    //Recursividade para registrar os assentos
    public static void registrarAssentos() {

        //Contador foi criado para limitar as iteraçoes da recursividade
        if(contador < listaAviao.size()) {

            //Chama função sizeVazio da classe Avião para verificar se o Size ainda não foi definido para os aviões criados
            if (Aviao.sizeVazio(listaAviao.get(contador).getAssento())) {

                //Escolhe a quantidade de assentos disponíveis
                int size = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de Assentos do Avião " + listaAviao.get(contador).getIdAviao() + ": "));

                //Chama função sizeAssento da classe Avião para definir o size informado do Vetor.
                listaAviao.get(contador).sizeAssento(size);
                contador++;

                //Chama recursivamente o procedimento
                registrarAssentos();
            }

        //Caso não exista mais aviões sem assentos definidos
        }else {
            JOptionPane.showMessageDialog(null, "Todos os Aviões estão com os Assentos cadastrados!!");
        }

    }

    //Recursividade para registrar as reservas
    public static void reservas(){

        //Utiliza-se da do procedimento consultar avião para retornar o Indice do Avião escolhido
        int indice = consultarAviao();

        //Se -1 avião informado não foi encontrado
        if(indice == -1){
            JOptionPane.showMessageDialog(null, "ID do Avião não Existe!! Tente novamente");
            reservas();

        //Se encontrado chama a função sizeVazio da Classe Avião para verificar se foram criados assentos para o Avião escolhido
        }else if (Aviao.sizeVazio(listaAviao.get(indice).getAssento())){
            JOptionPane.showMessageDialog(null,"Avião selecionado não possui assentos cadastrados!! \nCadastre os assentos e tente novamente.");

        //Se o Avião encontrado tiver assentos cadastrados então chama a função assentoVago da Classe Avião para verificar se tem assentos disponíveis
        }else if(listaAviao.get(indice).assentoVago()) {
            listaAviao.get(indice).registrarPassagem();

        //Se todos os assentos estiverem ocupados não permitirá a reserva.
        }else{
            JOptionPane.showMessageDialog(null,String.format("O Avião %d não possui Assentos disponíveis!! Utilize outro Avião", listaAviao.get(indice).getIdAviao()));
        }

    }

    //Função que verifica se o Avião informado existe e retorna a sua posição no vetor.
    public static int consultarAviao(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do avião: "));

        for (int i = 0; i < listaAviao.size(); i++) {
            if (id == listaAviao.get(i).getIdAviao()) {
                return i;
            }
        }

        return -1;
    }

    //Recursividade para consulta de reservas por Avião
    public static void buscarAviao(){
        //Procura o indice do Avião informado
        int indice = consultarAviao();

        //Caso não encontre informa que o avião não existe e chamar novamente o procedimento
        if(indice == - 1){
            JOptionPane.showMessageDialog(null, "ID do Avião não Existe!! Tente novamente");
            buscarAviao();

        //Caso não tenha nenhuma reserva retorna mensagem.
        }else if (listaAviao.get(indice).getCont() == 0) {
            JOptionPane.showMessageDialog(null, "Não há Reservas para esse Avião");

        //Se tiver chama procedimento exibieReservas da Classe Avião para efetuar as reservas
        }else{
            System.out.printf("---- Avião %d ----\n", listaAviao.get(indice).getIdAviao());
            listaAviao.get(indice).exibeReservas();
        }

    }

    //Procedimento para consulta de reservas por Passageiro
    public static void buscarPassageiro(){
        //Armazena o nome que deseja buscar
        String nome = JOptionPane.showInputDialog("Informe o nome do Passageiro: ");
        //Iteração para verificar se nenhum nome foi encontado
        int cont = 0;

        System.out.printf("---- %s ----\n", nome);

        //Repetição para verificar todos os Aviões da lista
        for(int i = 0; i < listaAviao.size(); i++) {

            //Chama função consultarPassagem da Classe Avião para verificar Reservas em nome do Passageiro informado.
            if (!listaAviao.get(i).consultarPassagem(nome)) {
                //Se não localizar adiciona +1 no contador
                cont++;
            }
        }

        //Se o contador passar por todos os aviões e não encontrar o Passageiro, ele devera ter o mesmo valor da quantidade de Aviões se isso ocorrer
        //então não existem Reservas para o nome informado.
        if(cont == listaAviao.size()) {
            System.out.println("Sem Reservas");
            System.out.println("\n-----------------\n");
            JOptionPane.showMessageDialog(null, "Não foram encontradas Reservas para o Passageiro informado!!");
        }

    }




}
