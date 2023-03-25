package pedido;
public class ItemCompra {

	private int quantidade;
	
	private float valorReais;
	
	private Pedido pedido;
	
	private Produto produto;

	public ItemCompra(int quantidade, float valorReais, Pedido pedido, Produto produto){
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorReais = valorReais;
	}

	@Override
	public String toString() {
		return produto.toString()
			+ "\nQuantidade: " + quantidade
			+ "\nSub Total: " + getSubTotal() 
			+ "\n----------------\n";
	}

	public float getSubTotal() {
		return quantidade * valorReais;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorReais() {
		return valorReais;
	}

	public void setValorReais(float valorReais) {
		this.valorReais = valorReais;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
}
