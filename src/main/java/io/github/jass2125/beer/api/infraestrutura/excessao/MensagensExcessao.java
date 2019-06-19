package io.github.jass2125.beer.api.infraestrutura.excessao;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 5 de jun de 2018
 * @project bids-api
 *
 *          Classe wrapper para as mensagens disparadas pelos serviços de
 *          Usuario
 **/
public final class MensagensExcessao {

	private final static String MENSAGEM_BASICA = "Somente usuários %s podem cadastrar usuários desse nível.";
	public static final String NIVEL_CADASTRO_INVALIDO_CONTRATO = String.format(MENSAGEM_BASICA, "Master Contrato");
	public static final String NIVEL_CADASTRO_INVALIDO_LICITACAO = String.format(MENSAGEM_BASICA, "Master Licitação");
	public static final String NIVEL_CADASTRO_FULL = String.format(MENSAGEM_BASICA, "FULL");

	public static final String ORGAO_NAO_CADASTRADO = "O órgão referênciado não está cadastrado";
	public static final String ORGAO_SEM_PERMISSAO = "Você não tem permissão para realizar a operação neste orgao";
	public static final String ORGAO_JA_EXISTENTE = "Já existe um órgao com esse nome registrado";

	public static final String CONTRATO_JA_EXISTENTE = "Já existe um contrato com esse número e órgão registrados";
	public static final String CONTRATO_SEM_PERMISSAO = "Você não tem permissão para realizar a operação neste contrato";
	
	public static final String COMISSAO_JA_EXISTENTE = "Já existe uma comissão com este nome registrado";
	public static final String COMISSAO_NAO_CADASTRADO = "A comissao referênciada não está cadastrada";
	public static final String COMISSAO_SEM_PERMISSAO = "Você não tem permissão para realizar a operação nesta comissão";

	public static final String USUARIO_JA_EXISTENTE = "Já existe um usuário com este email registrado";
	public static final String USUARIO_NAO_CADASTRADO = "O usuário referênciado não está cadastrado";

	public static final String LICITACAO_NAO_CADASTRADA = "A licitação referenciada não existe";
	public static final String LICITACAO_JA_EXISTENTE = "Já existe uma licitação com esse número, modalidade e comissão registrados";
	public static final String LICITACAO_DATA_REALIZACAO_MAIOR_DATA_CREDENCIAMENTO = "“A Data de Realização deve ser igual ou superior à Data de Credenciamento";
	public static final String LICITACAO_SEM_PERMISSAO = "Você não tem permissão para realizar a operação nesta licitação";
	public static final String LICITACAO_MODALIDADE_NAO_CADASTRADO = "A modalidade referênciada não está cadastrada";

	public static final String FORNECEDOR_JA_EXISTENTE = "Já existe um fornecedor com este código no sistema";
        public static final String FORNECEDOR_INEXISTENTE = "Fornecedor não existe";

	public static final String AVISO_SEM_PERMISSAO = "Você não possui permissão para criar este aviso";
        public static final String AVISO_SEM_DESTINATÁRIO = "É necessário adicionar um destinatário";
}
