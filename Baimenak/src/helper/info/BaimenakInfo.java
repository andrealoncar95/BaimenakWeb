package helper.info;

public class BaimenakInfo {

	private int id;
	private String izena;
	private String kokalekua;
	private String kostuaE;
	private String kostuaB;
	
	public BaimenakInfo(int pID, String pIzena, String pKokalekua, String pKostuaE, String pKostuaB){
		this.id=pID;
		this.izena=pIzena;
		this.kokalekua=pKokalekua;
		this.kostuaB=pKostuaB;
		this.kostuaE=pKostuaE;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getKokalekua(){
		return this.kokalekua;
	}
	
	public String getIzena(){
		return this.izena;
	}
	
	public String getKostuaE(){
		return this.kostuaE;
	}
	
	public String getKostuaB(){
		return this.kostuaB;
	}

}
