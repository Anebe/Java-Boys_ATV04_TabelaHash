package comum;



public class Lista<T>{
    private No inicio;
    private int size;
    
    public boolean add(T element, int index){
        if(!verifyIndex(index)){
            return false;
        }else{
            if(size == 0){
                inicio = new No(element);
            }else{
                No PreviousNo = getPreviousNo(index);

                if(PreviousNo.getProximo() == null){
                    PreviousNo.setProximo(new No(element));
                }else{
                    PreviousNo.setProximo(new No(element, PreviousNo.getProximo()));
                }
            }
            
            
            size++;
            return true;
        }
        
    }
    
    public T get(int index){
        if(!verifyIndex(index)){
            return null;
        }else{
            
            if(index == 0){
                return inicio.getInfo();
            }else{
                No PreviousNo = getPreviousNo(index);
                
                if(PreviousNo.getProximo() == null){
                    return null;
                }else{
                    return PreviousNo.getProximo().getInfo();
                }
            }
        }
    }

    public T remove(int index){
        if(!verifyIndex(index)){
            return null;
        }else{

            No PreviousNo = getPreviousNo(index);

            if(PreviousNo.getProximo() == null){
                return null;
            }else{
                No removeNo = PreviousNo.getProximo();

                if(removeNo.getProximo() != null){
                    PreviousNo.setProximo(removeNo.getProximo());
                    removeNo.setProximo(null);
                }
                return removeNo.getInfo();
            }
        }
    }
    
    private No getPreviousNo(int index){
        No aux = inicio;
        for (int i = 0; i < index-1; i++) {
            aux = aux.getProximo();
        }
        return aux;
    }

    private boolean verifyIndex(int index){
        if(index < 0 || index > size){
            return false;
        }
        return true;
    }
    
    public int size(){
        return size;
    }
    
    @Override
    public String toString(){
        String str="";
        No local = inicio;
        while (local!= null){
            str += local.getInfo() + ", ";
            local = local.getProximo();
        }
        return str;
    }

    /////////////////////////////////////////////////////////
    public class No{
        private T info;
        private No proximo;
        //private No anterior;

        public No(T info){
            this.info = info;
            proximo = null;
        }
        public No(T info, No proximo){
            this.info = info;
            this.proximo = proximo;
        }

        public void setInfo(T info){
            this.info = info;
        }
        public void setProximo(No proximo){
            this.proximo = proximo;
        }
        /*
        public void setAnterior(No anterior){
            this.anterior = anterior;
        }
        */
        public T getInfo(){
            return info;
        }
        public No getProximo(){
            return proximo;
        }
        /*
        public No getAnterior(){
        return anterior;
    }
        */
    }


}