package entidades;

public class Individual extends Contribuinte{

	private Double despesasDaSaude;

	public Individual(String nome, Double rendaAnual, Double despesasDaSaude) {
		super(nome, rendaAnual);
		this.despesasDaSaude = despesasDaSaude;
	}

	public Double getDespesasDaSaude() {
		return despesasDaSaude;
	}

	public void setDespesasDaSaude(Double despesasDaSaude) {
		this.despesasDaSaude = despesasDaSaude;
	}

	@Override
	public Double imposto() {
		if (getRendaAnual() < 20000.0) {
			return getRendaAnual() * 0.15 - despesasDaSaude * 0.5;
		}
		else {
			return getRendaAnual() * 0.25 - despesasDaSaude * 0.5;
		}
	}
}