/**
 * Classe que representa uma lista encadeada de linhas.
 * 
 * Esta classe é usada para gerenciar uma coleção de linhas, permitindo inserção
 * e recuperação
 * das linhas em uma lista encadeada.
 * 
 */
public class LineList {

    /**
     * Referência para o primeiro elemento da lista.
     */
    private Line first;

    /**
     * Construtor da classe. Inicializa a lista como vazia.
     */
    public LineList() {
        this.first = null;
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return true</code> se a lista não contém elementos, <code>false</code> caso
     *         contrário.
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * Insere uma nova linha no final da lista.
     * 
     * Se a lista estiver vazia, a nova linha se torna o primeiro elemento da lista.
     * Caso contrário, a nova linha é adicionada após o último elemento existente.
     * 
     *
     * @param line A linha a ser inserida no final da lista.
     */
    public void insertEnd(Line line) {
        if (isEmpty()) {
            this.first = line;
        } else {
            if (line != null) {
                Line auxLine = first;

                while (auxLine.getNext() != null) {
                    auxLine = auxLine.getNext();
                }
                auxLine.setNext(line);
            }
        }
    }

    /***
     * Obtém a referência para o primeiro elemento da lista.
     *
     * @return O primeiro elemento da lista, ou <code>null</code> se a lista estiver
     *         vazia.
     */
    public Line getFirstLine() {
        return this.first;
    }

    /**
     * Constrói e retorna uma representação em String dos números das
     * linhas na lista.
     * 
     * A representação é uma lista de números separados por vírgulas.
     * 
     *
     * @return Uma String contendo todos os números das linhas na
     *         lista, separados por vírgulas.
     */
    public String show() {
        Line auxLine = first;
        String lineString = "";

        while (auxLine.getNext() != null) {
            lineString += auxLine.getWord() + ", ";
            auxLine = auxLine.getNext();
        }
        if (auxLine != null) {
            lineString += auxLine.getWord();
        }
        return lineString;
    }
}
