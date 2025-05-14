package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {

    private String id;
    private String nome;
    private float nota;
    private Node next;
    private Node left;

    // Construtor padrão
    public Node() {
        this("", "", 0.0f, null, null);  
    }

    // Construtor com parâmetros
    public Node(String id, String nome, float nota, Node next, Node left) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.next = next;
        this.left = left;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    // Sobrescrevendo o método toString
    @Override
    public String toString() {
        return "[dados: (" + id + "; " + nome + "; " + nota + ") | next: " + 
                (next != null ? next.getId() : "null") + " | left: " + 
                (left != null ? left.getId() : "null") + "]";
    }
}
