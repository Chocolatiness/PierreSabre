package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom,"th?" ,argent);
	}
	
	public int seFaireExtorquer() {
		int butin = this.getArgent();
		perdreArgent(butin);
		parler("J?ai tout perdu! Le monde est trop injuste...");
		return butin;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie g?n?reux donateur!");
		gagnerArgent(argent);
	}
}

