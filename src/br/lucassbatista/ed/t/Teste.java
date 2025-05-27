package br.lucassbatista.ed.t;

import br.lucassbatista.ed.ListaEncadeada;

public class Teste {
	public static void main(String[] args) {
		ListaEncadeada<Integer> Prim = new ListaEncadeada<Integer>();
		ListaEncadeada<Integer> Sec = new ListaEncadeada<Integer>();
		ListaEncadeada<Integer> Terc = new ListaEncadeada<Integer>();

		try {
			Prim.addFirst(1);
			Prim.addLast(7);

			Sec.addFirst(3);
			Sec.addLast(4);
			Sec.addLast(8);
			
			for (int i = 1; i <= 8; i++) {
			    boolean emPrim = false;
			    boolean emSec = false;

			    for (int j = 0; j < Prim.size(); j++) {
			        if (Prim.get(j) == i) {
			            emPrim = true;
			            break;
			        }
			    }

			    for (int j = 0; j < Sec.size(); j++) {
			        if (Sec.get(j) == i) {
			            emSec = true;
			            break;
			        }
			    }

			    if (emPrim || emSec) {
			        if (Terc.isEmpty()) {
			            Terc.addFirst(i);
			        } else {
			            Terc.addLast(i);
			        }
			    }
			}

			Terc.list();
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
