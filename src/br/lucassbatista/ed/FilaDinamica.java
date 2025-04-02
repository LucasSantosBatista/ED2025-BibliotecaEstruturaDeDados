package br.lucassbatista.ed;

public class FilaDinamica<T> {
	NoFila<T> inicio;
	NoFila<T> fim;
	private int size = 0;

	public FilaDinamica() {
		fim = null;
		inicio = fim;
	}

	public boolean isEmpty() {
		if (inicio == null && fim == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(T valor) {
		NoFila<T> elemento = new NoFila<>();
		elemento.dado = valor;
		elemento.proximo = null;

		if (isEmpty() == true) {
			inicio = elemento;
			fim = inicio;
		} else {
			fim.proximo = elemento;
			fim = elemento;
		}
		atualizaTamanho(true);
	}

	public T remove() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Fila vazia!");
		}

		T valor = inicio.dado;
		if (inicio == fim & inicio != null) {
			inicio = null;
			fim = inicio;
		} else {
			inicio = inicio.proximo;
		}

		atualizaTamanho(false);
		return valor;
	}

	public void list() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Fila vazia!");
		}

		NoFila<T> aux = inicio;
		while (aux != null) {
			System.out.print(aux.dado + " ");
			aux = aux.proximo;
		}
	}

	public int size() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Fila vazia!");
		} else {
			return this.size;
		}
	}

	private void atualizaTamanho(boolean objetivo) {
		if (objetivo == true) {
			this.size++;
		} else {
			this.size--;
		}
	}
	
}
