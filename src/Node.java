/**
 * Classe que representa um nó em uma árvore binária.
 * 
 * Cada nó contém um valor, referências para seus filhos à esquerda e à direita,
 * e uma lista encadeada de linhas associadas ao nó.
 * 
 */
public class Node {

     /**
      * Referência para o filho à direita deste nó.
      */
     private Node right;

     /**
      * Referência para o filho à esquerda deste nó.
      */
     private Node left;

     /**
      * Valor armazenado neste nó.
      */
     private String value;

     /**
      * Lista de linhas associadas a este nó.
      */
     private LineList myLineList = new LineList();

     /**
      * Construtor da classe. Inicializa o nó com o valor fornecido e adiciona uma
      * linha à lista de linhas.
      *
      * @param value O valor a ser armazenado neste nó.
      * @param line  A linha a ser adicionada à lista de linhas associada a este nó.
      */
     public Node(String value, Line line) {
          this.value = value;
          this.myLineList.insertEnd(line);
     }

     /**
      * Obtém a referência para o filho à direita deste nó.
      *
      * @return O nó filho à direita, ou <code>null</code> se não houver filho à
      *         direita.
      */
     public Node getRight() {
          return right;
     }

     /**
      * Define a referência para o filho à direita deste nó.
      *
      * @param right O nó a ser definido como filho à direita deste nó.
      */
     public void setRight(Node right) {
          this.right = right;
     }

     /**
      * Obtém a referência para o filho à esquerda deste nó.
      *
      * @return O nó filho à esquerda, ou null se não houver filho à
      *         esquerda.
      */
     public Node getLeft() {
          return left;
     }

     /**
      * Define a referência para o filho à esquerda deste nó.
      *
      * @param left O nó a ser definido como filho à esquerda deste nó.
      */
     public void setLeft(Node left) {
          this.left = left;
     }

     /**
      * Obtém o valor armazenado neste nó.
      *
      * @return O valor armazenado neste nó.
      */
     public String getValue() {
          return value;
     }

     /**
      * Define o valor armazenado neste nó.
      *
      * @param value O novo valor a ser armazenado neste nó.
      */
     public void setValue(String value) {
          this.value = value;
     }

     /**
      * Adiciona uma linha à lista de linhas associada a este nó.
      * 
      * Se a lista de linhas já contém outras linhas, a nova linha é inserida no
      * final da lista.
      * 
      *
      * @param line A linha a ser adicionada à lista de linhas.
      */
     public void setLines(Line line) {
          this.myLineList.insertEnd(line);
     }

     /**
      * Obtém a primeira linha da lista de linhas associada a este nó.
      *
      * @return A primeira linha da lista de linhas, ou <code>null</code> se a lista
      *         estiver vazia.
      */
     public Line getFirstLine() {
          return this.myLineList.getFirstLine();
     }

     /**
      * Obtém a lista de linhas associada a este nó.
      *
      * @return A lista de linhas associada a este nó.
      */
     public LineList getLines() {
          return this.myLineList;
     }

}
