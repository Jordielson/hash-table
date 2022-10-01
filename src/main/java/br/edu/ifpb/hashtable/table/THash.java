package br.edu.ifpb.hashtable.table;

public interface THash {

	/**
	 * calcula o hash da chave inteira id, utilizando o metodo da divisao
	 * @param id chave identificadora do objeto
	 * @return o indice mapeado
	 */
	public int hash(int id);
	
	/**
	 * metodo para averiguar se ha espacos vazios na tabela 
	 * (a tabela pode conter um atributo para contar a quantidade de elementos)
	 * @return verdadeiro se nao houver espacos onde possam ser inseridos novos elementos
	 */
	public boolean isCheia();
	
	/**
	 * adiciona o usuario passado por parametro da tabela hash
	 * @param u usuario que sera salvo na tabela
	 * @throws Exception lanca uma excecao quando nao houver espacos disponiveis
	 */
	public void adicionar(User u) throws Exception;

	/**
	 * o metodo retorna o usuario com id igual ao recebido como parametro de entrada
	 * @param id id do usuario que se deseja recuperar
	 * @return retorna o objeto usuario com o id igual ao recebido como parametro
	 * @throws Exception lanca uma excecao caso o usuario nao seja encontrada
	 */
	public User recuperar(int id) throws Exception;
	
	/**
	 * esse metodo deve imprimir os indices da tabela hash
	 * ex. 
	 * [0] - vazio
	 * [1] - Joao (ID 1) (para tabelas com enderecamento aberto)
	 * [2] - INICIO -> Ana (ID 2) -> Maria (ID 4) (para tabelas com enderecamento fechado).
	 * [3] - RAIZ -> Jose (ID 3), Jonathas (ID 6) (percurso preordem para arvores). 
	 */
	public void print();
	
	/**
	 * funcao que dobra o tamanho da tabela hash e realoca todos os elementos existentes em seus novos indices
	 */
	public void crescer();
	
	/**
	 * @return retorna a quantidade de elementos guardada atualmente na tabela
	 */
	public int qtd();
	
}
