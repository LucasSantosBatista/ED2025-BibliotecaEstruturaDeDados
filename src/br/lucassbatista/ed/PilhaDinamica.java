package br.lucassbatista.ed;

public class PilhaDinamica<T> {
	NoPilha<T> topo;
	
	public boolean isEmpty() {
		if (topo == null){
			return true;
		} else {
			return false;
		}
	}
	
	public void push(T e) {
		NoPilha<T> elemento = new NoPilha<>();
		elemento.dado = e;
		elemento.proximo = topo;
		topo = elemento;
	}
	
	
	public T pop() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Não há valores para desempilhar");
		} else {
			T valor = topo.dado;
			topo = topo.proximo;
			return valor;
		}
	}
	
	public T top() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Não há valores na pilha");
		} else {
			return topo.dado;
		}
	}
	
	public int size() {
		int cont = 0;
		if (isEmpty() == false) {
			NoPilha<T> aux = topo;
			 cont = 1;
			 while (aux.proximo != null) {
				 cont++;
				 aux = aux.proximo;
			 }
		}
		return cont;
	}
}
