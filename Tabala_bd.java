package testar.com.br.meu_koltlin;

/**
 * Created by Pichau on 01/02/2018.
 */

public class Tabala_bd {
    private String nome_tabela;
    private String campo;
    private String chave;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
    public String getNome_tabela() {
        return nome_tabela;
    }

    public String getCampo() {
        return campo;
    }

    public void setNome_tabela(String nome_tabela) {
        this.nome_tabela = nome_tabela;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Tabala_bd(String nome_tabela){
        setNome_tabela(nome_tabela);
    }



    public void criar_tabela(){
        StringBuilder sql = new StringBuilder();
        sql.append("Create Table"+ getNome_tabela()+"(");
    }

    public void criar_campo(String campo, String tipo){
        StringBuilder sql = new StringBuilder();
        setCampo(campo);
        sql.append(getCampo() +  tipo);
    }

    public void chave_fim(){
        setChave("}");
        getChave();
    }
}
