package SituacaoAprendizagem;

import javax.swing.*;

//A Classe avião representa cada Avião criado
public class Aviao {

    private int idAviao;

    //Lista de Assentos, cada assento é um objeto do tipo Passagem.
    private Passagem[] assento;
    private Passagem pass;
    private int cont = 0;

    //Metodos Getters and Setters são utilizados para pegar e/ou inserir informações nas variáveis da classe
    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public Passagem[] getAssento() {
        return assento;
    }

    public void setAssento(Passagem[] assento) {
        this.assento = assento;
    }

    public int getCont() {
        return cont;
    }

    public Passagem getPass() {
        return pass;
    }

    public void setPass(Passagem pass) {
        this.pass = pass;
    }

    //Procedimento para adicionar um tamanho ao vetor de Assentos
    public void sizeAssento(int size){
        assento = new Passagem[size];
        setAssento(assento);
    }

    //Procedimento para verificar se o Vetor ja foi criado
    public static boolean sizeVazio(Passagem[] assento){
        if (assento == null) {
            return true;
        }else {
            return false;
        }
    }

    //Procedimento que verifica se ainda possui assentos/espaços disponíveis no vetor
    public boolean assentoVago(){
        if(cont < assento.length){
            return true;
        }else {
            return false;
        }
    }

    //Recursividade para cadastrar passagens
    public void registrarPassagem(){
        //Antes de registrar uma nova reserva verifica se ainda possui assentos vazios
        if(assentoVago()) {

            String opcao = JOptionPane.showInputDialog(String.format("---- RESERVA DE PASSAGENS ---- \n" +
                "AVIÃO %d\n" +
                "Escolha uma opção: \n" +
                "1 - Reservar uma passagem \n" +
                "2 - Encerrar \n" +
                "------------------------------------", this.idAviao));

            //Estrutura de repetição para manter a persistência do programa até que se escolha a opção 2
            if(opcao.equalsIgnoreCase("1")) {

                //Cria-se um novo objeto Passagem para adicionar os dados da reserva
                this.pass = new Passagem();
                this.pass.setIdPassagem(this.cont);
                this.pass.setIdAviao(this.idAviao);
                this.pass.setNomePassageiro(JOptionPane.showInputDialog("Informe o nome do Passageiro: ").toUpperCase());

                //Transfere o objeto criado para a lista de objetos, cada assento no avião é um objeto do tipo Passagem
                this.assento[this.cont] = this.pass;

                //Contador foi criado para se saber se todos os assentos ja foram reservados
                this.cont++;
                JOptionPane.showMessageDialog(null, "Passagem Registradas com Sucesso!!");

                //Chama recursivamente a função para efetuar uma nova reserva
                registrarPassagem();

            }else{
                JOptionPane.showMessageDialog(null, "Encerrando a Reserva de Passagens!!");
            }

        }else{
            JOptionPane.showMessageDialog(null,"Sem Mais Lugares Disponíveis!!");
            JOptionPane.showMessageDialog(null, "Encerrando a Reserva de Passagens!!");
        }

    }

    //Procedimento para buscar passagens pelo nome
    public boolean consultarPassagem(String nome){
        boolean resultado = false;
        for (int i = 0; i < this.cont; i++) {
            if (this.assento[i].getNomePassageiro().contains(nome.toUpperCase())) {
                System.out.printf("ID do Avião: %d \nNome do Passageiro: %s \nNº do Assento: %d", this.idAviao, this.assento[i].getNomePassageiro(), this.assento[i].getIdPassagem());
                System.out.println("\n-----------------\n");
                resultado = true;
            }
        }

        return resultado;
    }

    //Procedimento para exibir todas as reservas feitas por avião
    public void exibeReservas(){
        for(int i = 0; i < cont; i++){
            System.out.printf("Nome Passageiro: %s \nNº do Assento: %d",this.assento[i].getNomePassageiro(), this.assento[i].getIdPassagem());
            System.out.println("\n-----------------\n");
        }
    }
}
