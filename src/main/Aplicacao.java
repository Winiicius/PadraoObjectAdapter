package main;

import adaptador.AdapterPedidoCarga;
import pedido.Pedido;
import pedido.Produto;
import transporte.Carga;
import transporte.RotaTransporte;

public class Aplicacao {

	public static void main(String[] args) {
		Aplicacao.usandoClasseJaEsperadaPelaClassePreexistente(); 
		Aplicacao.usandoClasseIncompativelComAdaptadorNaClassePreexistente();
	}

	public static void usandoClasseJaEsperadaPelaClassePreexistente() {
		/* 
		 * TODO/OK ADAPTER.01 
		 * 
		 * 1. Crie um objeto da classe {RotaTransporte}.
		 * 
		 * 2. Crie um objeto da classe {Carga} e adicione-o no objeto {RotaTransporte} criado, invocando-lhe {addCarga()}.
		 * 
		 * 3. Invoque {calcularICMSCarga()} do objeto {RotaTransporte} criado.
		 * 
		 * 4. Invoque {mostrarCargas()} do objeto {RotaTransporte} criado.
		 * 
		 * 6. Assuma que o c�digo aqui implementado seria o de um cliente qualquer dessas classes de objetos e que
		 * n�o pretendemos alter�-lo devido a especificidades de uso desses objetos de futuros c�digos clientes. 
		 * 
		 * ---------- 
		 * [PERGUNTA A] 
		 * Podemos dizer que o c�digo aqui implementado acaba assumindo que o objeto {RotaTransporte} � naturalmente usado
		 * com objetos {Carga}?
		 * [Sim, o objeto Rota Transporte é um objeto container, armazenando instâncias de Carga]
		 * ----------
		 */
		RotaTransporte rotaTransporte = new RotaTransporte();
		Carga carga = new Carga();
		rotaTransporte.addCarga(carga);
		carga.setIdentificadorRastreio("BR4532");
		System.out.println(rotaTransporte.calcularICMSCarga(carga.getIdentificadorRastreio()));
		System.out.println(rotaTransporte.mostrarCargas());
	}

	public static void usandoClasseIncompativelComAdaptadorNaClassePreexistente() {

		RotaTransporte rotaTransporte = new RotaTransporte();

		Produto violao = new Produto("Violão", 1.7f,new float[]{102,47,13}, 450f);
		Produto tenis = new Produto("Tênis Nike",0.500f,new float[]{33,21,12}, 300);
		Produto palhetaViolao = new Produto("Palheta Violão", 0.10f, new float[]{10,10,10}, 7f);

		Pedido pedido = new Pedido();

		pedido.criarItemCompra(1,450, pedido, violao );
		pedido.criarItemCompra(1,300, pedido, tenis );
		pedido.criarItemCompra(7,7, pedido, palhetaViolao );

		pedido.setIdentificadorRastreio("BR634773");
		
		rotaTransporte.addCarga(new AdapterPedidoCarga(pedido));

		System.out.println(rotaTransporte.mostrarCargas());

		float icms = rotaTransporte.calcularICMSCarga(pedido.getIdentificadorRastreio());

		System.out.println("ICMS: " + icms);
		System.out.println("Total Pedidos + ICMS: " + (icms + pedido.getTotal()));

		/* TODO/OK ADAPTER.02
		 * 	
		 * 1. Crie um objeto da classe {RotaTransporte}.
		 * 
		 * 2. Agora precisamos fazer com que esse objeto {RotaTransporte} seja capaz de lidar com objetos
		 * da classe {Pedido}, como se fosse {Carga}. Veja que objetos {Pedido} possuem o objetivo de coes�o
		 * de representar compras, que podem conter um ou mais objetos {ItemPedido}, que, por sua vez, correlacionam 
		 * uma quantidade de unidades para um determinado {Produto}. Portanto, crie um {Pedido} contendo 
		 * 02 objetos {ItemCompra}, com seus respectivos objetos {Produto} sendo diferentes.   
		 * 
		 * 3. Adicione ao objeto {RotaTransporte} o objeto {Pedido} criado, como se fosse um objeto {Carga}. 
		 * Para evitarmos incoveni�ncias, n�o mexa em nehuma linha de c�digo das classes envolvidas e tamb�m nos c�digos clientes
		 * das mesmas (como ilustra o m�todo anterior desta classe {usandoClasseJaEsperadaPelaClassePreexistente()}.
		 * Portanto, aplique a vers�o mais adequada do padr�o Adapter para conseguir reusar um objeto {Pedido} perante
		 * um objeto {RotaTransporte} como se fosse um objeto {Carga}, combinado? 
		 * 
		 * 4. Invoque {calcularICMSCarga()} do objeto {RotaTransporte}.  
		 * 
		 * 5. Invoque {mostrarCargas()} do objeto {RotaTransporte}.
		 * 
		 * ---------- 
		 * [PERGUNTA B] 
		 * Considerando a implementa��o de um c�digo cliente do padr�o Adapter e a situa��o aqui simulada,
		 * quem seria(m) a(s) classe(s) de objeto(s) ADAPTADA(S)? DICA: ela seria(m) a(s) classe(s) de objeto(s)
		 * j� codificada(s) que um c�digo cliente pretende converter/reinterfacear, para que sejam compatibilizadas 
		 * uma outra classe PREEXISTENTE (tamb�m j� codificada),que no caso passaria a aceit�-las(s) por adapta��o, 
		 * algo que antes seria imposs�vel.     
		 * [A classe Pedido]
		 * ----------
		 * 
		 * ---------- 
		 * [PERGUNTA C] 
		 * Considerando a implementa��o de um c�digo cliente do padr�o Adapter e a situa��o aqui simulada,
		 * quem seria a classe de objetos PREEXISTENTE? DICA: ela seria a classe que o c�digo cliente intenciona 
		 * associar com um outro objeto de tipo originalmente incompat�vel. Aproveite e determine quem seria
		 * a classe de objetos IMPOSTA PELA PREEXISTENTE, que � justamente aquela da qual a PREEXISTENTE depende e
		 * cuja interface (m�todos p�blicos) ser�o a refer�ncia para o ADPTADOR da classe ADAPTADA. 
		 * [
		 *  Classe PREEXISTENTE: RotaTransporte
		 *  Classe IMPOSTA PELA PREEXISTENTE: Carga
		 * ]
		 * ----------
		 * 
		 * ---------- 
		 * [PERGUNTA D] 
		 * Poder�amos no exemplo desta pr�tica implementar um CLASS ADAPTER (adapta��o por heran�a com a classe ADAPTADA)
		 * ou um OBJECT ADAPTER (adapta��o por composi��o com a classe ADAPTADA)? Ou po c�digo original nos imp�e 
		 * apenas a escolha por uma das duas vers�es do padr�o?
		 * [
		 *  O código original nos impõe a usar o Object Adapter, pois, a classe IMPOSTA PELA PREEXISTENTE é uma classe concreta
		 *  e o java não permite herança múltipla
		 * ]
		 * ----------
		 * 
		 * ---------- 
		 * [PERGUNTA F] 
		 * Os c�digos que j� existiam na classe PREEXISTENTE, na classe IMPOSTA PELA PREEXISTENTE e na(s) classe(s) ADAPTADA(S) 
		 * tiveram que ser modificadas com a aplica��o do padr�o? Ainda, houve modifica��es em c�digos clientes da PREEXISTENTE 
		 * e da IMPOSTA PELA PREEXISTENTE, vide a simula��o no m�todo {usandoClasseJaEsperadaPelaClassePreexistente()}?
		 * Tente expressar o que mais se destaca dentre os par�metros de qualidade de um design OO (coes�o, acoplamento, reusabilidade, 
		 * extensibilidade, flexibilidade a mudan�as), abrangendo o c�digo de classes desta pr�tica que foram beneficiadas com a
		 * aplica��o do padr�o, especialmente o c�digo de classes clientes do mesmo (antes e depois).
		 * [
		 *  Nós adicionamos o atributo IdentificadorRastreio na classe ADAPTADA, tirando isso, nós apenas adicionamos alguns métodos para maior compreensão do cliente
		 *  nenhuma linha do código cliente foi alterada.
		 *  
		 *  Após adotar o padrão o código fica bem mais extensível, pois, alterações na interface do objeto alvo não afetarão a 
		 *  interface da classe PREEXISTENTE,  reduzição no acoplamento entre as classes PREEXISTENTE e ADAPTADA, pois elas agora 
		 *  se comunicam por meio de uma interface intermediária.
		 *  Em termos de extensibilidade novas classes ADAPTADAS podem 
		 *  ser adicionadas facilmente.
		 *  E o código Cliente não seria afetado caso haja mudança em alguma das classes, não há diferenças na forma de manusear o
		 *  objeto PEDIDO e CARGA, claro que cada um tem suas particularidades, mas o cliente realmente trata o PEDIDO como se fosse
		 *  um objeto CARGA, e ele se comporta como um. 
		 * ]
		 * ----------
		 */
	}

}
