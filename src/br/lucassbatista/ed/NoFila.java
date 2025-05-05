package br.lucassbatista.ed;

class NoFila<T> {
	T dado;
	NoFila<T> proximo;

	@Override
	public String toString() {
		return "[" + dado + "]";
	}
}
