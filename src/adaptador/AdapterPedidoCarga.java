package adaptador;

import pedido.Endereco;
import pedido.Pedido;
import transporte.Carga;
import transporte.UnidadeMedida;

/*
 * TODO/OK ADAPTER.03 
 * 1. Altere a declara��o da classe para usar OBJECT ou CLASS ADAPTER, de acordo 
 * com a situacao criada pelo TODO_ADAPTER.02 (DICA: talvez isso dependa do tipo da
 * IMPOSTA PELA PREEXISTENTE, se � uma classe concreta, abstrata ou uma interface),  
 * 
 * 2. Implemente um construtor apropriado parametrizando um objeto da classe ADAPTADA 
 * ou que estenda a Adaptada, a depender da vers�o do padr�o que voc� vai adotar por mera
 * escolha ou daquela que somente seja a poss�vel de se aplicar.
 * 
 * 3. Considere rebatizar o nome desta classe para que como adaptadora remeta qual classe est�
 * sendo adaptada e para qual, para refor�armos-lhe a coes�o (prop�sito de exit�ncia desta classe).
 *
 */
public class AdapterPedidoCarga extends Carga {

	private Pedido pedido;

	public AdapterPedidoCarga(Pedido pedido){
		this.pedido = pedido;
	}
	@Override
	public String getConteudo() {
		return pedido.getItensCompra().toString() + "\nTotal: " + pedido.getTotal();
	}
	@Override
	public Endereco getEnderecoEntrega() {
		return pedido.getEndereco();
	}
	@Override
	public float getValorReais() { 
		return pedido.getTotal();
	}
	@Override
	public String getIdentificadorRastreio() {
		return pedido.getIdentificadorRastreio();
	}
	@Override
	public UnidadeMedida getUnidadeMedida() {
		return UnidadeMedida.CENTIMETROS;
	}
	public Pedido getPedido() {
		return pedido;
	}
	/*
	 * TODO/OK ADAPTER.04 
	 * 1. Implemente os m�todos esperados pelo tipo de classe IMPOSTA PELA PREEXISTENTE.
	 * 
	 * 2. Essas implementa��es somente ser�o aceit�veis como c�digo de adapta��o
	 * se houver ind�cios de acesso com invoca��o de m�todos para reuso de c�digo 
	 * p�blico das classe(s) ADAPTADA(S): o que pode ocorrer por heran�a com a mesma (acesso super), 
	 * ou, por composi��o com a mesma (acesso a refer�ncia a ela, que seria disposta 
	 * como um atributo), a depender a vers�o do padr�o adotada.  
	 * 
	 */
}