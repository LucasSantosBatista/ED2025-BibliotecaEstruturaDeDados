package br.lucassbatista.ed;

class NoString {
	String dado;
	NoString proximo;
	
	@Override
	public String toString() {
		return "["+dado+"]";
	}
}
