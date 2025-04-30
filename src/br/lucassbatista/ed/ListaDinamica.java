package br.lucassbatista.ed;

public class ListaDinamica<T> {
	NoLista<T> primeiro;

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		int cont = 0;
		if (isEmpty() == false) {
			NoLista<T> aux = primeiro;
			while (aux != null) {
				cont++;
				aux = aux.proximo;
			}
		}
		return cont;
	}

	public NoLista<T> getNo(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size() - 1;
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida!");
		}

		NoLista<T> aux = primeiro;
		int cont = 0;
		while (cont < pos) {
			aux = aux.proximo;
			cont++;
		}

		return aux;
	}

	public void addFirst(T valor) {
		NoLista<T> elemento = new NoLista<>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;

	}

	public void addLast(T valor) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}

		int tamanho = size() - 1;
		NoLista<T> elemento = new NoLista<>();
		elemento.dado = valor;
		elemento.proximo = null;

		NoLista<T> ultimo = getNo(tamanho);
		ultimo.proximo = elemento;
	}

	public void add(T valor, int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida!");
		}

		if (pos == 0) {
			addFirst(valor);
		} else if (pos == tamanho) {
			addLast(valor);
		} else {
			NoLista<T> elemento = new NoLista<>();
			elemento.dado = valor;

			NoLista<T> anterior = getNo(pos - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;

		}

	}

	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}

		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}

		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			NoLista<T> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}

	public void remove(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size() - 1;
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida!");
		}

		if (pos == 0) {
			removeFirst();
		} else if (pos == tamanho) {
			removeLast();
		} else {
			NoLista<T> anterior = getNo(pos - 1);
			NoLista<T> atual = getNo(pos);
			anterior.proximo = atual.proximo;

		}
	}

	public T get(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size() - 1;
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida!");
		}

		int cont = 0;
		NoLista<T> aux = primeiro;
		while (cont < pos) {
			aux = aux.proximo;
			cont++;
		}
		return aux.dado;		
	}

}
