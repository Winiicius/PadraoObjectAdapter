package pedido;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Endereco endereco;
	private String IdentificadorRastreio;
	private List<ItemCompra> itensCompra = new ArrayList<ItemCompra>();

	public void add(ItemCompra item){
		itensCompra.add(item);
	}

	public void criarItemCompra(int quantidade, float valorReais, Pedido pedido, Produto produto){
		add(new ItemCompra(quantidade,valorReais, pedido, produto));
	}

	public float getTotal(){
		float total = 0;
		for (ItemCompra itemCompra : itensCompra) {
			total+=itemCompra.getSubTotal();
		}
		return total;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ItemCompra> getItensCompra() {
		return itensCompra;
	}

	public void setItensCompra(List<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}
    public String getIdentificadorRastreio() {
        return IdentificadorRastreio;
    }
    public void setIdentificadorRastreio(String IdentificadorRastreio) {
        this.IdentificadorRastreio = IdentificadorRastreio;
    }

}
