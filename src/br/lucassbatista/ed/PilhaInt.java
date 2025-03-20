package br.lucassbatista.ed;

public class PilhaInt {
	NoInt topo;
	
	public boolean isEmpty() {
		if (topo == null){
			return true;
		} else {
			return false;
		}
	}
	
	public void push(int e) {
		NoInt elemento = new NoInt();
		elemento.dado = e;
		elemento.proximo = topo;
		topo = elemento;
	}
	
	
	public int pop() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Não há valores para desempilhar");
		} else {
			int valor = topo.dado;
			topo = topo.proximo;
			return valor;
		}
	}
	
	public int top() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Não há valores na pilha");
		} else {
			return topo.dado;
		}
	}
	
	public int size() {
		int cont = 0;
		if (isEmpty() == false) {
			 NoInt aux = topo;
			 cont = 1;
			 while (aux.proximo != null) {
				 cont++;
				 aux = aux.proximo;
			 }
		}
		return cont;
	}
}
