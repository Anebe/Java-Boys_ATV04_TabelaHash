package comum;

//LISTA DUPLA DE ATIV DE NIVELAMENTO FOI SIMPLIFICADA/MELHORADA
//PARA RESOLVER COLISÃO
public class Hash<T extends Key>{
    //private Object[] lista;
    private Lista<T>[] lista;
    private int size;

    @SuppressWarnings("unchecked")
    public Hash(int length){
        //lista = new Object[length];
        lista = new Lista[length];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new Lista<T>();
        }
    }

    /*public boolean add(T element){
        if(!isFull()){

            int index = hashFunction(element.key());
            
            //COLISÃO
            if(lista[index] != null){
                //PERCORRE EM CIRCULOS PROCURANDO VAGA LIVRE
                index = resolveColision(index);
                if(index == -1){
                    return false;
                }
            }
            
            lista[index] = element;
            size++;
            return true;
        }else{
            return false;
        }
        
    }*/
    
    public boolean add(T element){
        int index = hashFunction(element.key());

        Lista<T> auxLista = lista[index];
        T auxElement;

        for (int i = 0; i < auxLista.size(); i++) {
            auxElement = auxLista.get(i);

            if(auxElement.key() == element.key()){
                element = auxElement;
            }
        }
        
        //ADICIONAR
        lista[index].add(element, lista[index].size());
        return true;
    }

    //@SuppressWarnings("unchecked")
    /*public T search(int key){

        int index = hashFunction(key);
        int searchKey =((T) lista[index]).key();

        if(key == searchKey){
            return (T) lista[index];
        }
        else{
            for (int i = 0; i < lista.length; i++) {
                if(key == ((T) lista[i]).key()){
                    return (T) lista[i];
                }
            }
            return null;
        }
    }*/

    public T search(int key){

        int index = hashFunction(key);
        Lista<T> auxLista = lista[index];
        T auxElement;

        //PROCURAR CHAVE
        for (int i = 0; i < auxLista.size(); i++) {
            auxElement = auxLista.get(i);

            if(auxElement.key() == key){
                return auxElement;
            }
        }

        //CASO NÃO ENCONTRE A CHAVE
        return null;
    }

    public int hashFunction(int key){
        int index = Math.abs(key) % lista.length;

        return index;
    }

    public boolean isEmpity(){
        if(lista.length == 0 || lista == null || size == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        /*for (Object object : lista) {
            if(object == null){
                return false;
            }
        }
        return true;*/
        if(size == lista.length){
            return true;
        }
        return false;
    }

    /*private int resolveColision(int indexOfColision){
        for (int i = indexOfColision, j = 0; lista[i] != null; i++, j++, indexOfColision=i){
                    
            if(j >= lista.length){
                return -1;
            }
            if(i+1 >= lista.length){
                i = 0;
            }
        }

        return indexOfColision;
    }*/
    
    public static String encrypt(String palavra){
        int[] letras = new int[palavra.length()];

        for (int i = 0; i < letras.length; i++) {
            letras[i] = palavra.codePointAt(i);
            letras[i] += 10;
        }

        return new String(letras,0, letras.length);
    }

    public static String decrypt(String palavra){
        int[] letras = new int[palavra.length()];

        for (int i = 0; i < letras.length; i++) {
            letras[i] = palavra.codePointAt(i);
            letras[i] -= 10;
        }

        return new String(letras,0, letras.length);
    }

    @Override
    public String toString() {
        String result = "";
        for (Object element : lista) {
            if(element != null){
                result += element.toString() + "\n";
            }else{
                result += "Vazio\n";
            }
        }
        return result;
    }


}
