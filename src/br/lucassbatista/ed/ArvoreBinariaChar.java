package br.lucassbatista.ed;

public class ArvoreBinariaChar {
	
	NoArvore<Character> raiz;
	
	public ArvoreBinariaChar() {
		raiz = null;
	}
	
	public void insert(char dado) {
		NoArvore<Character> no = new NoArvore<>();
		no.dado = dado;
		no.esquerda = null;
		no.direita = null;
		inserLeaf(no, raiz);
	}

	private void inserLeaf(NoArvore<Character> no, NoArvore<Character> raizSubArvore) {
		if (raiz == null) {
			raiz = no;
		} else {
			if (no.dado < raizSubArvore.dado) {
				if (raizSubArvore.esquerda == null) {
					raizSubArvore.esquerda = no;

				} else {
					inserLeaf(no, raizSubArvore.esquerda);
				}
			}
			if (no.dado >= raizSubArvore.dado) {
				if (raizSubArvore.direita == null) {
					raizSubArvore.direita = no;

				} else {
					inserLeaf(no, raizSubArvore.direita);
				}
			}
		}
	}

	public void search(char valor) throws Exception {
		try {
			NoArvore<Character> no = nodeSearch(raiz, valor);
			int level = nodeLevel(raiz, valor);
			System.out.println("Dado " + no.dado + " | Nível " + level);

		} catch (Exception e) {
			throw new Exception("Valor não encontrado na árvore!");
		}
	}

	public boolean exists(char valor) {
		try {
			nodeSearch(raiz, valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private NoArvore<Character> nodeSearch(NoArvore<Character> raizSubArvore, char valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else if (valor < raizSubArvore.dado) {
			return nodeSearch(raizSubArvore.esquerda, valor);
		} else if (valor > raizSubArvore.dado) {
			return nodeSearch(raizSubArvore.direita, valor);
		} else {
			return raizSubArvore;
		}
	}

	private int nodeLevel(NoArvore<Character> raizSubArvore, char valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else if (valor < raizSubArvore.dado) {
			return 1 + nodeLevel(raizSubArvore.esquerda, valor);
		} else if (valor > raizSubArvore.dado) {
			return 1 + nodeLevel(raizSubArvore.direita, valor);
		} else {
			return 0;
		}
	}

	public void remove(char valor) throws Exception {
		try {
			removeChild(raiz, valor);
		} catch (Exception e) {
			throw new Exception("Valor não encontrado para remover!");
		}
	}

	private void removeChild(NoArvore<Character> raizSubArvore, char valor) throws Exception {
		if (exists(valor)) {
			NoArvore<Character> no = nodeSearch(raizSubArvore, valor);
			NoArvore<Character> pai = nodeParent(null, raiz, no.dado);

			if (no.esquerda != null && no.direita != null) {
				NoArvore<Character> noTroca = no.esquerda;
				while (noTroca.direita != null) {
					noTroca = noTroca.direita;
				}
				pai = nodeParent(null, raiz, noTroca.dado);
				no.dado = noTroca.dado;
				noTroca.dado = valor;
				removeOneOrZeroLeaf(pai, noTroca);
			} else {
				removeOneOrZeroLeaf(pai, no);
			}

		} else {
			throw new Exception("Valor inexistente!");
		}
	}

	private NoArvore<Character> nodeParent(NoArvore<Character> parent, NoArvore<Character> raizSubArvore, char valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia!");
		} else if (valor < raizSubArvore.dado) {
			return nodeParent(raizSubArvore, raizSubArvore.esquerda, valor);
		} else if (valor > raizSubArvore.dado) {
			return nodeParent(raizSubArvore, raizSubArvore.direita, valor);
		} else {
			return parent;
		}
	}

	private void removeOneOrZeroLeaf(NoArvore<Character> parent, NoArvore<Character> no) {
		if (no.esquerda == null && no.direita == null) {
			if (parent == null) {
				raiz = null;
			} else {
				change(parent, no, null);
			}
		} else if (no.direita != null) {
			if (parent == null) {
				raiz = no.direita;
			} else {
				change(parent, no, no.direita);
			}
		} else if (no.direita == null) {
			if (parent == null) {
				raiz = no.esquerda;
			} else {
				change(parent, no, no.esquerda);
			}
		}
	}

	private void change(NoArvore<Character> parent, NoArvore<Character> no, NoArvore<Character> novoNo) {
		if (parent.esquerda != null && parent.esquerda.dado == no.dado) {
			parent.esquerda = novoNo;
		} else if (parent.direita.dado == no.dado) {
			parent.direita = novoNo;
		}
	}

	public void prefixSearch() throws Exception {
		prefix(raiz);
	}

	private void prefix(NoArvore<Character> raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia!");
		} else {
			System.out.print(raizSubArvore.dado + " ");

			if (raizSubArvore.esquerda != null) {
				prefix(raizSubArvore.esquerda);
			}
			if (raizSubArvore.direita != null) {
				prefix(raizSubArvore.direita);
			}
		}
	}

	public void infixSearch() throws Exception {
		infix(raiz);
	}

	private void infix(NoArvore<Character> raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia!");
		} else {
			if (raizSubArvore.esquerda != null) {
				infix(raizSubArvore.esquerda);
			}

			System.out.print(raizSubArvore.dado + " ");

			if (raizSubArvore.direita != null) {
				infix(raizSubArvore.direita);
			}
		}
	}

	public void postfixSearch() throws Exception {
		postfix(raiz);
	}

	private void postfix(NoArvore<Character> raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia!");
		} else {
			if (raizSubArvore.esquerda != null) {
				postfix(raizSubArvore.esquerda);
			}

			if (raizSubArvore.direita != null) {
				postfix(raizSubArvore.direita);
			}
			System.out.print(raizSubArvore.dado + " ");
		}
	}
}
