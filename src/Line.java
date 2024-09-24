/**
 * Classe que representa uma linha associada a um nó em uma árvore binária.
 * 
 * Cada instância da classe Line contém um número de linha e uma referência para a próxima linha.
 * 
 */
public class Line {

    /**
     * Número da linha.
     */
    int word;

    /**
     * Referência para a próxima linha na lista encadeada.
     */
    Line next;

    /**
     * Construtor da classe. Inicializa a linha com o número fornecido.
     *
     * @param lineWord O número da linha a ser associado a esta instância.
     */
    public Line(int lineWord) {
        this.word = lineWord;
    }

    /**
     * Obtém o número da linha associado a esta instância.
     *
     * @return O número da linha.
     */
    public int getWord() {
        return this.word;
    }

    /**
     * Obtém a referência para a próxima linha na lista encadeada.
     *
     * @return A próxima linha, ou null se não houver próxima linha.
     */
    public Line getNext() {
        return this.next;
    }

    /**
     * Define a referência para a próxima linha na lista encadeada.
     *
     * @param nextLine A próxima linha a ser associada a esta instância.
     */
    public void setNext(Line nextLine) {
        this.next = nextLine;
    }
}
