package one.digitainnovation;

public class NoDuplo<T> {

    private T conteudo; //Conteudo que ficara armazenado no nó
    private NoDuplo<T> noProximo; //ref. no pos.
    private NoDuplo<T> NoPrevio; //ref. no ant.

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public NoDuplo<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(NoDuplo<T> noProximo) {
        this.noProximo = noProximo;
    }

    public NoDuplo<T> getNoPrevio() {
        return NoPrevio;
    }

    public void setNoPrevio(NoDuplo<T> noPrevio) {
        NoPrevio = noPrevio;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
