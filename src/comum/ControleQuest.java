package comum;

import quest1.Quest1Main;
import quest2.Quest2Main;

public class ControleQuest {
    public static void main(String[] args) {
        if(args.length == 0){
            Quest1Main.main(null);
            Quest2Main.main(null);
        }
        else if(args.length == 1){
            
            if(args[0].equals("1")){
                Quest1Main.main(null);
            }
            if(args[1].equals("2")){
                Quest1Main.main(null);
            }
        }
    }
}
