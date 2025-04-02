package br.lucassbatista.ed;

class NoPilha<T> {
	T dado;
	NoPilha<T> proximo;
	
	@Override
	public String toString() {
		return "["+dado+"]";
	}
}
