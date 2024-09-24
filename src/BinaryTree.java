/**
 * Classe responsável por criar e manipular uma árvore binária.
 * 
 * A árvore binária é uma estrutura de dados onde cada nó possui no máximo dois filhos,
 * sendo um filho à esquerda e um filho à direita.
 * 
 */
public class BinaryTree {

     /**
      * Raiz da árvore binária.
      */
     Node root;
 
     /**
      * Construtor da classe. Inicializa a raiz da árvore como null.
      */
     public BinaryTree() {
         root = null;
     }
 
     /**
      * Insere um novo nó na árvore binária.
      * 
      * A inserção é realizada de acordo com a ordem dos valores dos nós.
      * Se o valor do nó a ser inserido é menor que o valor do nó atual, ele é inserido à esquerda.
      * Se é maior, ele é inserido à direita. Se o valor já existe, as linhas do nó atual são atualizadas.
      * 
      *
      * @param newNode O nó a ser inserido na árvore.
      */
     public void insert(Node newNode) {
         root = insertNewNode(newNode, root);
     }
 
     /**
      * Método recursivo para inserir um novo nó na árvore binária.
      *
      * @param newNode O nó a ser inserido.
      * @param current O nó atual sendo comparado.
      * @return O nó atualizado após a inserção.
      */
     private Node insertNewNode(Node newNode, Node current) {
 
         if (current == null)
             return newNode;
 
         String wordDad = current.getValue();
         String wordSon = newNode.getValue();
         if (wordDad.compareTo(wordSon) < 0) {
             current.setRight(insertNewNode(newNode, current.getRight()));
         }
         if (wordDad.compareTo(wordSon) > 0) {
             current.setLeft(insertNewNode(newNode, current.getLeft()));
         }
         if (wordDad.compareTo(wordSon) == 0) {
             current.setLines(newNode.getFirstLine());
         }
 
         return current;
     }
 
     /**
      * Método para realizar a impressão pré-ordem.
      * 
      * Na impressão pré-ordem, o nó atual é processado antes dos seus filhos.
      * 
      */
     public void preOrder() {
         preOrder(root);
     }
 
     /**
      * Método para realizar a impressão em ordem.
      * 
      * Na impressão em ordem, os filhos à esquerda são processados antes do nó atual,
      * e os filhos à direita são processados após o nó atual.
      * 
      */
     public void onOrder() {
         onOrder(root);
     }
 
     /*
      * 
      * Método para realizar a impressão pós-ordem.
      * 
      * Na impressão pós-ordem, os filhos à esquerda e à direita são processados antes do nó atual.
      * 
      */
     public void posOrder() {
         posOrder(root);
     }
 
     /**
      * Método recursivo para impressão pré-ordem da árvore binária.
      *
      * @param element O nó atual sendo processado.
      */
     private void preOrder(Node element) {
         if (element != null) {
             System.out.println(element.getValue() + " " + element.getLines().show()); // R
             preOrder(element.getLeft()); // E
             preOrder(element.getRight()); // D
         }
     }
 
     /**
      * Método recursivo para impressão em ordem da árvore binária.
      *
      * @param element O nó atual sendo processado.
      */
     private void onOrder(Node element) {
         if (element != null) {
             onOrder(element.getLeft()); // E
             System.out.println(element.getValue() + " " + element.getLines().show()); // R
             onOrder(element.getRight()); // D
         }
     }
 
     /**
      * Método recursivo para impressão pós-ordem da árvore binária.
      *
      * @param element O nó atual sendo processado.
      */
     private void posOrder(Node element) {
         if (element != null) {
             posOrder(element.getLeft()); // E
             posOrder(element.getRight()); // D
             System.out.println(element.getValue() + " " + element.getLines().show()); // R
         }
     }
 
 }
 