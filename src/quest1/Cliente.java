package quest1;

import comum.Key;

public class Cliente implements Key{
    private Integer id;
    private String nome;
    private String email;

    public Cliente (Integer id, String nome, String email){
        this.id = id;
        this.email = email;
        this.nome = nome;
    }         

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int key(){
        return id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + nome + ", Email: " + email;
    }

}
