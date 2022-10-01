package br.edu.ifpb.hashtable.table;

public class THashImpl implements THash {
	private User[] users;
	private int qtd = 0;
	
	public THashImpl(int tamanho) {
		users = new User[tamanho];
	}

	public int hash(int id) {
		float ka = id*1/3f;
		float x = ka%1;
		int h = (int) (x*users.length);
		return h;
	}
	
	public int rehash(int id, int i) {
		int rh = (3*i*i+2*i+hash(id))%users.length;
		return rh;
	}

	public boolean isCheia() {
		if(qtd == users.length) {
			return true;
		}
		return false;
	}

	public void adicionar(User u) throws Exception {
		if(isCheia()) {
			throw new Exception("Tabela Hash esta cheia. Aumente o tamanho da tabela para adicionar novos usuarios.");
		}
		
		int h = hash(u.id);
		if(users[h] == null) {
			users[h] = u;
		} else {
			int i = 1;
			int rh;
			do {
				if(users.length < i) {
					throw new Exception("Nao ha indice disponivel na tabela hash. Aumente o tamanho da tabela pra adicionar este usuario.");
				}
				rh = rehash(u.id, i++);
			} while (users[rh] != null);
			users[rh] = u;
		}
		qtd++;
	}

	public User recuperar(int id) throws Exception {
		int h = hash(id);
		int i = 1;
		User user = users[h]; 
		
		while(user != null) {
			if(user.id == id) {
				return user;
			} else if(users.length < i) {
				break;
			} else {
				int rh = rehash(id, i++);
				user = users[rh];
			}
		}
		throw new Exception("Usuario nao encontrado!");
	}

	public void print() {
		for (int i = 0; i < users.length; i++) {
			User user = users[i];
			System.out.print("[" + i + "] - ");
			if(user == null) {
				System.out.println("Vazio");
			} else {
				System.out.println(user);
			}
		}
	}

	public void crescer() {
		THashImpl tabela = new THashImpl(users.length*2);
		for (int i = 0; i < users.length; i++) {
			User user = users[i];
			if(user != null) {
				try {
					tabela.adicionar(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		users = tabela.getUsers();
	}

	private User[] getUsers() {
		return users;
	}

	public int qtd() {
		return qtd;
	}

}
