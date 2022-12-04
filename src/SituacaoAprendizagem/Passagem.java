package SituacaoAprendizagem;

//Classe passagem representa cada Reserva feita
public class Passagem {

    private int idAviao;
    private int idPassagem;
    private String nomePassageiro;

    //Metodos Getters and Setters são utilizados para pegar e/ou inserir informações nas variáveis da classe
    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public int getIdPassagem() {
        return idPassagem;
    }

    public String getNomePassageiro(){
        return nomePassageiro;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

}
