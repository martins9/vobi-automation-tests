package br.com.vobi.utils;

/**
 * Classe que carrega o arquivo excel
 * @author Saulo Martins Soares da Fonseca
 *
 */
public class LoadData {

	private static String nomeArquivo;
	
	/**
	 * Construtor da classe
	 * @param nomeArquivo
	 */
	public LoadData(String nomeArquivo) {
		
		LoadData.nomeArquivo = nomeArquivo;
	}
	
	/**
	 * Método que retorna o nome do arquivo Excel
	 * @return
	 */
	public static String getNomeArquivo() {
		return nomeArquivo;
	}		
}
