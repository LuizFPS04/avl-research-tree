/**
 * Classe que fornece métodos para balancear nós em uma estrutura de árvore binária
 * utilizando operações de rotação para árvores AVL.
 */
public class Balance {

    /**
     * Construtor padrão da classe Balance.
     */
    public Balance() {}

    /**
     * Retorna a altura do nó especificado.
     * 
     * @param node O nó cuja altura será calculada.
     * @return A altura do nó. Retorna 0 se o nó for nulo.
     */
    public int getHeight(Node node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    /**
     * Retorna o fator de balanceamento do nó especificado.
     * 
     * O fator de balanceamento é calculado como a diferença entre as alturas
     * dos nós da esquerda e da direita.
     * 
     * @param node O nó para o qual o fator de balanceamento será calculado.
     * @return O fator de balanceamento do nó. Retorna 0 se o nó for nulo.
     */
    private int getBalance(Node node) {
        if (node == null) return 0;

        Node leftNode = node.getLeft();
        Node rightNode = node.getRight();

        return this.getHeight(leftNode) - this.getHeight(rightNode);
    }

    /**
     * Realiza a verificação e o balanceamento do nó especificado.
     * 
     * Caso o nó esteja desbalanceado, são realizadas as rotações necessárias
     * para corrigir o balanceamento da árvore.
     * 
     * @param node O nó a ser balanceado.
     * @return O nó balanceado após a rotação apropriada.
     */
    public Node balancingNode(Node node) {
        Node leftNode = node.getLeft();
        Node rightNode = node.getRight();

        int balance = this.getBalance(node);
        int leftBalance = this.getBalance(leftNode);
        int rightBalance = this.getBalance(rightNode);

        if (balance > 1 && leftBalance >= 0) {
            return rotateRight(node);
        }

        if (balance < -1 && rightBalance <= 0) {
            return rotateLeft(node);
        }

        if (balance > 1 && leftBalance < 0) {
            node.setLeft(rotateLeft(leftNode));
            return rotateRight(node);
        }

        if (balance < -1 && rightBalance > 0) {
            node.setRight(rotateRight(rightNode));
            return rotateLeft(node);
        }

        return node;
    }

    /**
     * Realiza a rotação à direita do nó especificado.
     * 
     * Esse método é usado para balancear a árvore quando o fator de balanceamento
     * indica que o lado esquerdo está mais pesado.
     * 
     * @param node O nó sobre o qual será realizada a rotação à direita.
     * @return O novo nó raiz após a rotação.
     */
    private Node rotateRight(Node node) {
        Node xNode = node.getLeft();
        Node auxNode = xNode.getRight();

        xNode.setRight(node);
        node.setLeft(auxNode);

        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        xNode.setHeight(Math.max(getHeight(xNode.getLeft()), getHeight(xNode.getRight())) + 1);

        return xNode;
    }

    /**
     * Realiza a rotação à esquerda do nó especificado.
     * 
     * Esse método é usado para balancear a árvore quando o fator de balanceamento
     * indica que o lado direito está mais pesado.
     * 
     * @param node O nó sobre o qual será realizada a rotação à esquerda.
     * @return O novo nó raiz após a rotação.
     */
    private Node rotateLeft(Node node) {
        Node yNode = node.getRight();
        Node auxNode = yNode.getLeft();

        yNode.setLeft(node);
        node.setRight(auxNode);

        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        yNode.setHeight(Math.max(getHeight(yNode.getLeft()), getHeight(yNode.getRight())) + 1);

        return yNode;
    }
}