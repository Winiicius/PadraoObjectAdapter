package transporte;
import pedido.Endereco;

public class Carga {

	private String identificadorRastreio;
	
	private float valorReais;
	
	private float pesoKg;
	
	private float altura;
	
	private float largura;
	
	private float profundidade;
	
	private UnidadeMedida unidadeMedida;
	
	private Endereco enderecoEntrega;
	
	private String conteudo;

	public String getIdentificadorRastreio() {
		return identificadorRastreio;
	}

	public void setIdentificadorRastreio(String identificadorRastreio) {
		this.identificadorRastreio = identificadorRastreio;
	}

	public float getValorReais() {
		return valorReais;
	}

	public void setValorReais(float valorReais) {
		this.valorReais = valorReais;
	}

	public float getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(float pesoKg) {
		this.pesoKg = pesoKg;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
