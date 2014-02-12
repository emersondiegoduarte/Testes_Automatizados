package br.treinamento;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Testes {

	
	
	Entidade entidade;
	static ExercicioJUnit exercicioJUnit;
	
	@Rule
	public  ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		entidade = new Entidade();
		entidade.setNome("Emerson Diego");
		entidade.setEmail("emerson.diego.duarte@gmail.com");
		entidade.setId(1L);
		entidade.setTipoDocumento(1);
		entidade.setNumeroDocumento(2000L);
		entidade.setDataFinal(new Date(Calendar.getInstance().getTimeInMillis()));
		entidade.setDataInicial(new Date(Calendar.getInstance().getTimeInMillis()));
		
	}


	@BeforeClass
	public static void instanciaexercicioJUnit(){
		exercicioJUnit = new ExercicioJUnit();
	}
	
	
	@Test
	public void verificarEntidadeValida() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("O nome ? obrigat?rio");
		entidade.setNome(null);
		entidade.setDataInicial(new Date(Calendar.getInstance().getTimeInMillis()));
		entidade.setDataFinal(null);
		exercicioJUnit.verificarEntidadeValida(entidade);
	}
	
	@Test
	public void verificarEntidadeValidaNomeMenorQue5() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("O nome n?o pode ter menos que 5 caracteres");
		entidade.setNome("Diego");
		exercicioJUnit.verificarEntidadeValida(entidade);
		
	}
	
	@Test
	public void verificarEntidadeValidaNomeMaiorQue30() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("O nome n?o pode ter mais que 30 caracteres");
		entidade.setNome("Diegoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		exercicioJUnit.verificarEntidadeValida(entidade);
		
	}

	
	
	@Test
	public void verificarEntidadeValidaNumeroDocumento() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("O n?mero do documento ? obrigat?rio");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(null);
		exercicioJUnit.verificarEntidadeValida(entidade);
	}
	
	
	@Test
	public void verificarEntidadeValidaDataFinal() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("O per?odo deve ser informado por completo");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/15/2014"));
		entidade.setDataFinal(null);
		exercicioJUnit.verificarEntidadeValida(entidade);
	}

	@Test
	public void verificarEntidadeTipoDocumentoNulo() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("O tipo do documento ? obrigat?rio");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/15/2014"));
		entidade.setDataFinal(new Date("02/25/2014"));
		entidade.setTipoDocumento(null);
		exercicioJUnit.verificarEntidadeValida(entidade);
	}
	
	@Test
	public void verificarEntidadeTipoDocumentoInvalido() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("Tipo de documento inv?lido");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/15/2014"));
		entidade.setDataFinal(new Date("02/25/2014"));
		entidade.setTipoDocumento(0);
		exercicioJUnit.verificarEntidadeValida(entidade);
	}
	
	@Test
	public void verificarEntidadeValidaEmail() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("Endere?o de email inv?lido");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/15/2014"));
		entidade.setDataFinal(new Date("02/25/2014"));
		entidade.setTipoDocumento(2);
		entidade.setEmail(null);
		exercicioJUnit.verificarEntidadeValida(entidade);
	}
	@Test
	public void verificarEntidadeValidaEmailSemPonto() throws Exception{
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/15/2014"));
		entidade.setDataFinal(new Date("02/25/2014"));
		entidade.setTipoDocumento(2);
		entidade.setEmail("meu@gmailcom");
boolean respostaActual = exercicioJUnit.verificarEntidadeValida(entidade);
		

		assertTrue("Cenário 7.2: e-mail inválido (e-mail sem @).", respostaActual);

	}
	
	@Test
	public void verificarEntidadeValidaEmailcomPontoSemArroba() throws Exception{
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/15/2014"));
		entidade.setDataFinal(new Date("02/25/2014"));
		entidade.setTipoDocumento(2);
		entidade.setEmail("gmail.com");
		boolean respostaActual = exercicioJUnit.verificarEntidadeValida(entidade);
		

		assertTrue("Cenário 7.2: e-mail inválido (e-mail sem @).", respostaActual);
	}
	

	@Test
	public void verificarEntidadeValidaEmailSemNada() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("Endere?o de email inv?lido");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/15/2014"));
		entidade.setDataFinal(new Date("02/25/2014"));
		entidade.setTipoDocumento(2);
		entidade.setEmail("duartegmailcom");
		exercicioJUnit.verificarEntidadeValida(entidade);
	}
	

	
	@Test
	public void compararDatasIniciais() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("A data inicial n?o pode ser menor que a data atual");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("02/10/2014"));
		entidade.setTipoDocumento(2);
		entidade.setDataFinal(new Date("14/02/2014"));
		exercicioJUnit.verificarEntidadeValida(entidade);
	}
	
	@Test
	public void compararDatasFinais() throws Exception{
		exception.expect(Exception.class);
		exception.expectMessage("A data final n?o pode ser menor que a data inicial");
		entidade.setNome("Emerson Diego");
		entidade.setNumeroDocumento(2000L);
		entidade.setDataInicial(new Date("01/02/2014"));
		entidade.setDataFinal(new Date("10/02/2014"));
		exception.expectMessage("A data final n?o pode ser menor que a data inicial");
		entidade.setDataInicial(new Date("11/02/2014"));
		entidade.setDataFinal(new Date("10/02/2014"));
		exercicioJUnit.verificarEntidadeValida(entidade);
	}

	
	@Test
	public void testCalcDigVerif() throws Exception {
		String cpfActual;
		boolean respostaActual;
		
		// Cenário 1: dígito calculado correto.
		cpfActual = "96257426111";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertTrue("Cenário 1: dígito calculado correto.", respostaActual);
		
		/// Cenário 1.1: dígito calculado correto.
		cpfActual = "01353074307";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertTrue("Cenário 1.1: dígito calculado correto.", respostaActual);
		
		/// Cenário 1.2: dígito calculado correto.
		cpfActual = "15484140005";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertTrue("Cenário 1.2: dígito calculado correto.", respostaActual);
		
		/// Cenário 1.3: dígito calculado correto.
		cpfActual = "16754518340";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertTrue("Cenário 1.3: dígito calculado correto.", respostaActual);
		
		/// Cenário 1.4: dígito calculado correto.
		cpfActual = "62152465300";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertTrue("Cenário 1.4: dígito calculado correto.", respostaActual);
		
		// Cenário 2: dígito calculado incorreto.
		cpfActual = "96257426101";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 2: dígito calculado incorreto.", respostaActual);
	}
	
	@Test
	public void testValidaCPF() throws Exception {
		String cpfActual;
		boolean respostaActual;
		
		testCalcDigVerif();
		
		// Cenário 1: CPF incorreto.
		cpfActual = "12345678901";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1: CPF incorreto.", respostaActual);
		
		// Cenário 1.1: CPF incorreto (00000000000).
		cpfActual = "00000000000";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.1: CPF incorreto (00000000000).", respostaActual);
		
		// Cenário 1.2: CPF incorreto (tamanho menor que 11 dígitos).
		cpfActual = "123";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.2: CPF incorreto (tamanho menor que 11 dígitos).", respostaActual);
		
		// Cenário 1.3: CPF incorreto (11111111111).
		cpfActual = "11111111111";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.3: CPF incorreto (11111111111).", respostaActual);
		
		// Cenário 1.4: CPF incorreto (22222222222).
		cpfActual = "22222222222";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.4: CPF incorreto (22222222222).", respostaActual);
		
		// Cenário 1.5: CPF incorreto (33333333333).
		cpfActual = "33333333333";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.5: CPF incorreto (33333333333).", respostaActual);
		
		// Cenário 1.6: CPF incorreto (44444444444).
		cpfActual = "44444444444";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.6: CPF incorreto (44444444444).", respostaActual);
		
		// Cenário 1.7: CPF incorreto (55555555555).
		cpfActual = "55555555555";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.7: CPF incorreto (55555555555).", respostaActual);
		
		// Cenário 1.8: CPF incorreto (66666666666).
		cpfActual = "66666666666";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.8: CPF incorreto (66666666666).", respostaActual);
		
		// Cenário 1.9: CPF incorreto (77777777777).
		cpfActual = "77777777777";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.9: CPF incorreto (77777777777).", respostaActual);
		
		// Cenário 1.10: CPF incorreto (88888888888).
		cpfActual = "88888888888";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.10: CPF incorreto (88888888888).", respostaActual);
		
		// Cenário 1.11: CPF incorreto (99999999999).
		cpfActual = "99999999999";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertFalse("Cenário 1.11: CPF incorreto (99999999999).", respostaActual);
		
		// Cenário 2: CPF correto.
		cpfActual = "96257426111";
		
		respostaActual = exercicioJUnit.validaCPF(cpfActual);
		assertTrue("Cenário 2: CPF correto.", respostaActual);
	}	

}
