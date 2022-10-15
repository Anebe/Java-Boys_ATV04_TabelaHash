package quest2;

import comum.Arquivo;
import comum.Hash;

public class Quest2Main {
    public static void main(String[] args) {
        Arquivo palavraArq = new Arquivo("entrada/palavras.txt");

        String[] palavras = palavraArq.readAllStrings();

        System.out.printf("%-25s%-25s%s", "Palavras no arquivo",  "Palavras encriptadas",  "Palavras DESencriptadas\n");
        for (String string : palavras) {
            System.out.printf("%-25s%-25s%s\n", string,
            Hash.encrypt(string),
            Hash.decrypt(Hash.encrypt(string)));
        }
    }   
      
}
