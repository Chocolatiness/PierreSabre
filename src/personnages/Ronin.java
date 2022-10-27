package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin(String nom, String boissonfav, int argent) {
		super(nom,boissonfav ,argent);
	}
	
	public void donner(Commercant beneficiaire) {
		parler(beneficiaire.getNom() + " prends ces " + this.getArgent()/10 + " sous");
		beneficiaire.recevoir(this.getArgent()/10);
		perdreArgent(this.getArgent()/10);
	}
}
