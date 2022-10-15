package quest1;

import java.util.StringTokenizer;


import comum.Arquivo;
import comum.Hash;

public class Quest1Main {
    public static void main(String[] args){
        Arquivo arqDados = new Arquivo("entrada/dados.txt");
        Arquivo arqConsulta = new Arquivo("entrada/consulta.txt");

        int quantidade = arqDados.countLines();
        Hash<Cliente> h1 = new Hash<Cliente>(quantidade);

        int id;
        String nome;
        String email;

        Object[] dados = arqDados.readAll();
        Object[] consultas = arqConsulta.readAll();
        StringTokenizer delimitar;


        for (Object object : dados) {

            delimitar = new StringTokenizer(object.toString(), ";");

            id = Integer.parseInt(delimitar.nextToken());
            nome = delimitar.nextToken();
            email = delimitar.nextToken();

            if(!h1.add(new Cliente(id, nome, email))){
                System.err.println("Limite atingido!");
            }
        }
        
        for (Object object : consultas) {
            
            Object c1 = h1.search(Integer.parseInt(object.toString()));
            if(c1 != null){
                System.out.println(c1);
            }else{
                System.out.println("Chave não encontrada. Chave: " + object);
            }
        }

        //Lista<String> teste = new Lista<String>();
        //teste.add("gabriel", 0);
        //teste.add("barros", 1);
        //teste.add("aragao", 2);
        //teste.add("costa", 3);
        //System.out.println(teste.get(4));
    }
}
