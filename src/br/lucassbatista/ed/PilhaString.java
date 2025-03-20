package br.lucassbatista.ed;

public class PilhaString {
	NoString topo;
	
	public boolean isEmpty() {
		if (topo == null){
			return true;
		} else {
			return false;
		}
	}
	
	public void push(String e) {
		NoString elemento = new NoString();
		elemento.dado = e;
		elemento.proximo = topo;
		topo = elemento;
	}
	
	
	public String pop() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Não há valores para desempilhar");
		} else {
			String valor = topo.dado;
			topo = topo.proximo;
			return valor;
		}
	}
	
	public String top() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("Não há valores na pilha");
		} else {
			return topo.dado;
		}
	}
	
	public int size() {
		int cont = 0;
		if (isEmpty() == false) {
			NoString aux = topo;
			 cont = 1;
			 while (aux.proximo != null) {
				 cont++;
				 aux = aux.proximo;
			 }
		}
		return cont;
	}
}
