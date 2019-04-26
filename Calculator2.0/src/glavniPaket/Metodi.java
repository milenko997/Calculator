package glavniPaket;

public class Metodi {

	private Double prethodnoUneseno = null;
	private Double trenutnoUneseno= null;
	private String operacija= null;
	
	public Metodi() {
		super();
	}

	public Double getPrethodnoUneseno() {
		return prethodnoUneseno;
	}

	public void setPrethodnoUneseno(Double prethodnoUneseno) {
		this.prethodnoUneseno = prethodnoUneseno;
	}

	public Double getTrenutnoUneseno() {
		return trenutnoUneseno;
	}

	public void setTrenutnoUneseno(Double trenutnoUneseno) {
		this.trenutnoUneseno = trenutnoUneseno;
	}

	public String getOperacija() {
		return operacija;
	}

	public void setOperacija(String operacija) {
		this.operacija = operacija;
	}
	
	public double akcija() {
		if(operacija.equals("+")){
			double retVal= prethodnoUneseno+ trenutnoUneseno;
			resetData(retVal);
			return retVal;
		}
		else if(operacija.equals("-")) {
			double retVal= prethodnoUneseno-trenutnoUneseno;
			resetData(retVal);
			return retVal;
		}
		else if(operacija.equals("*")) {
			double retVal= prethodnoUneseno*trenutnoUneseno;
			resetData(retVal);
			return retVal;
		}
		else if(operacija.equals("/")) {
			double retVal= prethodnoUneseno/trenutnoUneseno;
			resetData(retVal);
			return retVal;
		}
		return -1;
	}
	
	private void resetData(double rez) {
		prethodnoUneseno= rez;
		trenutnoUneseno= null;
		operacija= null;
		
	}
}
