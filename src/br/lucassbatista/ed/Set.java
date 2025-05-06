package br.lucassbatista.ed;

public class Set<T> {
	No<T> primeiro;

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
			No<T> aux = primeiro;
			while (aux != null) {
				cont++;
				aux = aux.proximo;
			}
		}
		return cont;
	}

	public No<T> getNo(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size() - 1;
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida!");
		}

		No<T> aux = primeiro;
		int cont = 0;
		while (cont < pos) {
			aux = aux.proximo;
			cont++;
		}

		return aux;
	}

	public void addFirst(T valor) {
		if (verificaSet(valor) == false) {
			No<T> elemento = new No<>();
			elemento.dado = valor;
			elemento.proximo = primeiro;
			primeiro = elemento;
		}
	}

	public void addLast(T valor) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}

		if (verificaSet(valor) == false) {
			int tamanho = size() - 1;
			No<T> elemento = new No<>();
			elemento.dado = valor;
			elemento.proximo = null;

			No<T> ultimo = getNo(tamanho);
			ultimo.proximo = elemento;
		}
	}

	public void add(T valor, int pos) throws Exception {
		if (verificaSet(valor) == false) {
			int tamanho = size();
			if (pos < 0 || pos > tamanho) {
				throw new Exception("Posição inválida!");
			}

			if (pos == 0) {
				addFirst(valor);
			} else if (pos == tamanho) {
				addLast(valor);
			} else {
				No<T> elemento = new No<>();
				elemento.dado = valor;

				No<T> anterior = getNo(pos - 1);
				elemento.proximo = anterior.proximo;
				anterior.proximo = elemento;

			}
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
			No<T> penultimo = getNo(tamanho - 2);
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
			No<T> anterior = getNo(pos - 1);
			No<T> atual = getNo(pos);
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
		No<T> aux = primeiro;
		while (cont < pos) {
			aux = aux.proximo;
			cont++;
		}
		return aux.dado;
	}

	public void clean() {
		primeiro = null;
	}

	public void list() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}

		No<T> aux = primeiro;
		System.out.print("Lista = ");
		while (aux != null) {
			System.out.print(aux.dado + " ");
			aux = aux.proximo;
		}
		System.out.println();
	}

	private boolean verificaSet(T valor) {
		if (isEmpty()) {
			return false;
		} else {
			No<T> aux = primeiro;

			while (aux != null) {
				if (aux.dado == valor) {
					return true;
				}
				aux = aux.proximo;
			}
			return false;
		}

	}

}
