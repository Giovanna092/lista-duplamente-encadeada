package one.digitainnovation;

public class ListaDuplamenteEncadeada<T> {

    //duas ref de entrada nesta lista
    private NoDuplo<T> primeiroNo; //ref. primeiro nó
    private NoDuplo<T> ultimoNo; //ref. ultimo nó

    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        primeiroNo = null;
        ultimoNo = null;
        tamanhoLista = 0;
    }

    public T get(int index) { return this.getNo(index).getConteudo(); }

    //adição de elementos na ultima posição da lista
    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);
        //se a lista estiver vazia o novo nó se torna o primeiro nó
        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }
        //se a lista tiver um ultimo nó ele imediatamente fica atras do nó adicionado
        if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int index, T elemento) {
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar); //referenciando o novo nó ao antigo nó do indice passado como parametro

        //verifica se tem nó a frente do novo nó
        //mudanças de referencia do nó anterior do que será adicionado
        if (novoNo.getNoProximo() != null) {
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        } else {
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }

        //verifica se tem nó atras do novo nó
        //mudanças no proximo nó do que será adicionado
        if (index == 0) {
            primeiroNo = novoNo;
        } else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }

        tamanhoLista++;
    }

    public void remove(int index) {
        if (index == 0) {
            primeiroNo = primeiroNo.getNoProximo();
            //define a referencia do nó anterior
            if (primeiroNo != null) {
                primeiroNo.setNoPrevio(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = getNo(index);
            //muda a referencia do nó anterior para o nó posterior ao que esta sendo removido
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if (noAuxiliar != ultimoNo) {
                //muda a referencia do nó posterior para o nó anterior ao que esta sendo removido
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            } else {
                ultimoNo = noAuxiliar.getNoPrevio();
            }
        }
        this.tamanhoLista--;
    }

    //método que percorre toda a lista té chegar no nó do indice informado no parametro
    private NoDuplo<T> getNo(int index) {
        //objeto auxiliar que percorre cada nó
        NoDuplo<T> noAuxiliar = primeiroNo; //começa no primeiroNo da lista
        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public int size() { return this.tamanhoLista; }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < size(); i++) {
            strRetorno += "[Nó{conteúdo= "+noAuxiliar.getConteudo()+"}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
