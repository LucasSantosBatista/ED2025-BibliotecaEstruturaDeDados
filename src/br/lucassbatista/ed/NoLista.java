package br.lucassbatista.ed;

class NoLista<T> {
	
	T dado;
	NoLista<T> proximo;
	
	@Override
	public String toString() {
		return "[" + dado + "]";
	}
	
}
