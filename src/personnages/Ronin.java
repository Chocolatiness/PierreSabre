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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (this.honneur*2 > adversaire.getReputation()) {
			parler("Je t'ai eu petit yakusa!");
			int butin = adversaire.perdre();
			this.honneur ++;
			gagnerArgent(butin);
		}
		else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			this.honneur --;
			int butin = this.getArgent();
			this.perdreArgent(butin);
			adversaire.gagner(butin);
		}
	}
}
