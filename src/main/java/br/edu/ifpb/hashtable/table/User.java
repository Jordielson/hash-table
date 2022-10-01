package br.edu.ifpb.hashtable.table;

public class User {
	int id;
	String nome;
	
	public User(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String toString() {
		return nome + "(ID " + id + ")";
	}
}
