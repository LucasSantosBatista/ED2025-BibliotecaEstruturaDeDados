package src.br.lucassbatista.ed;

public class ArvoreBinariaInt {
	NoArvore<Integer> raiz;

	public ArvoreBinariaInt() {
		raiz = null;
	}

	public void insert(int dado) {
		NoArvore<Integer> no = new NoArvore<>();
		no.dado = dado;
		no.esquerda = null;
		no.direita = null;
		inserLeaf(no, raiz);
	}

	private void inserLeaf(NoArvore<Integer> no, NoArvore<Integer> raizSubArvore) {
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

	public void search(int valor) throws Exception {
		try {
			NoArvore<Integer> no = nodeSearch(raiz, valor);
			int level = nodeLevel(raiz, valor);
			System.out.println("Dado " + no.dado + " | Nível " + level);

		} catch (Exception e) {
			throw new Exception("Valor não encontrado na árvore!");
		}
	}

	public boolean exists(int valor) {
		try {
			nodeSearch(raiz, valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private NoArvore<Integer> nodeSearch(NoArvore<Integer> raizSubArvore, int valor) throws Exception {
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

	private int nodeLevel(NoArvore<Integer> raizSubArvore, int valor) throws Exception {
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

	public void remove(int valor) throws Exception {
		try {
			removeChild(raiz, valor);
		} catch (Exception e) {
			throw new Exception("Valor não encontrado para remover!");
		}
	}

	private void removeChild(NoArvore<Integer> raizSubArvore, int valor) throws Exception {
		if (exists(valor)) {
			NoArvore<Integer> no = nodeSearch(raizSubArvore, valor);
			NoArvore<Integer> pai = nodeParent(null, raiz, no.dado);

			if (no.esquerda != null && no.direita != null) {
				NoArvore<Integer> noTroca = no.esquerda;
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

	private NoArvore<Integer> nodeParent(NoArvore<Integer> parent, NoArvore<Integer> raizSubArvore, int valor) throws Exception {
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

	private void removeOneOrZeroLeaf(NoArvore<Integer> parent, NoArvore<Integer> no) {
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

	private void change(NoArvore<Integer> parent, NoArvore<Integer> no, NoArvore<Integer> novoNo) {
		if (parent.esquerda != null && parent.esquerda.dado == no.dado) {
			parent.esquerda = novoNo;
		} else if (parent.direita.dado == no.dado) {
			parent.direita = novoNo;
		}
	}

	public void prefixSearch() throws Exception {
		prefix(raiz);
	}

	private void prefix(NoArvore<Integer> raizSubArvore) throws Exception {
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

	private void infix(NoArvore<Integer> raizSubArvore) throws Exception {
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

	private void postfix(NoArvore<Integer> raizSubArvore) throws Exception {
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
