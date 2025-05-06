package br.lucassbatista.ed;

class No<T> {
	T dado;
	No<T> proximo;
	
	@Override
	public String toString() {
		return "["+dado+"]";
	}
}
