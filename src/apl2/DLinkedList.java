// arquivo: src/apl2/DLinkedList.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

// Nome: Pedro Roberto Fernandes Noronha
// RA: 10443434

// Nome: Arthur Danta Gonzalez Felix
// RA: 10419721

// Nome: Gustavo Kenzo Nakazato Sleiman
// RA: 104089988

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	private Node head; // Referente ao primeiro nó da lista
	private Node tail; // Referente ao ultimo nó da lista
	private int size; // Contador de quantos nó existem na lista

// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		this.head = null; 
		this.tail = null; 
		this.size = 0;
	}

	public int getSize(){ 
		return size; 
	}

// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
	public void insert(String id, String nome, float nota) {
		Node newNode = new Node(id, nome, nota); // Isso ira criar um novo nó com os dados da pessoa

		if(head == null){ // Caso a lista estaja vazia 
			head = newNode;
			tail = newNode;
		} else { 
			newNode.setNext(head); // O proximo nó do novo nó sera o antigo head
			head.setLeft(newNode); // O antigo head agora ira apontar para o novo nó como anterior
			head = newNode; // O novo nó agora eh o novo head
		}
		size++; // Incrementando o contador de nós
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
	public void append(String id, String nome, float nota) {
		Node newNode = new Node(id, nome, nota); // Cria um novo nó com os dados da pessoa

		if(tail == null) { // Se a lista estiver vazia 
		   head = newNode; 
		   tail = newNode; 
		} else { 
			tail.setNext(newNode); // O ultimo nó aponta para o novo nó como proximo
			newNode.setLeft(tail); // O novo nó aponta para o antigo ultimo nó 
			tail = newNode; // O novo nó agora eh o novo tail
		}
		size++; // Incrementando o contador de nós
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead() {
		if(head == null) { // Se a lista estiver vazia  
			return null; 
		}

		Node removeNode = head; // Guarda a referencia do nó que sera removido
		head = head.getNext(); // Atualiza head para o proximo nó

		if(head != null) {  
		   head.setLeft(null); // O novo head nao tem mais o nó anterior
		} else { 
			tail = null; // Sea lista ficou vazia, tail tambem precisa ser atualizado
		}
		size--; // Decrementando o contador de nós 
		removeNode.setNext(null); // Evita referencias indesejadas

		return removeNode; // retorna o nó removido
	}


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		if(tail == null) { // Se a lista estiver vazia 
		   return null;
		}

		Node removeNode = tail; // Guarda a referencia do nó que sera removido 
		tail = tail.getLeft(); // Atualiza tail para o nó anterior

		if(tail != null) { 
			tail.setNext(null); // O novo tail nao tem mais nó seguinte
		} else { 
			head = null; // Se a lista ficou vazia, head tambem precisa ser atualizado
		}

		size--;// Decrementando o contador de nós
		removeNode.setLeft(null); // Evita referencias indesejadas

		return removeNode; // Retorna o nó removido
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) {
		if(head == null) { // Caso a lista estaja vazia 
			return null; 
		}

		Node current = head; 

		// Vamos percorer a lista ate encontrar o nó com o ID correspondente 
		while(current != null && !current.getId().equals(id)){ 
			current = current.getNext();
		}
		
		// Se o nó nao for encontrado, retornaremos null
		if(current == null){ 
			return null;
		}

		// Ajusta as referencias para remover o nó encontrado
		if(current == head){ 
			return removeHead(); // Se for o primeiro nó, usa removeHead()
		} else if (current == tail) { 
			return removeTail(); // Se for o ultimo nó, usa o removeTail()
		} else { 
			current.getLeft().setNext(current.getNext());
			current.getNext().setLeft(current.getLeft());
		}

		size--; // Decrementando o contador de nós
		current.setNext(null); 
		current.setLeft(null); // removo referencias desnecessarias

		return current; // Retorna o nó removido
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		return head; // Retorna o nó do inicio da lista ou null se a lista estiver vazia
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		return tail; // Retorna o nó do final da lista ou null se a lista estiver vazia
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		Node current = head; // Comeca pelo primeiro nó

		while(current != null) { // Enquanto ele nao chegar no final da lista 
			  if(current.getId().equals(id)) { // Se encontrar o ID desejado 
				 return current;
			  }
			  current = current.getNext(); // avanca para o proximo nó
		}
		return null; // Retorna null se o nó nao for encontrado
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		return size; // Retorna a quantidade de nós da lista
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		return size == 0; // Retorna true se a lista estiver vazia, caso o contrario retorna false
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		head = null; // remove a referencia ao primeiro nó
		tail = null; // remove a referencia ao ultimo nó
		size = 0;    // reseta o contador de nós
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		if (isEmpty()) { 
			return "Lista vazia!";
		}

		StringBuilder sb = new StringBuilder();
		Node current = head; 

		while(current != null){ 
			sb.append(current.toString()).append("\n"); // Usa o toString() da classe Node
			current = current.getNext();
		}
		return sb.toString();
	}
}