package personnages;

public class Humain {
	private String nom;
	private String boissonfav;
	private int argent;
	private int maxConnaissance = 30;
	private Humain[] connaissance;
	private int nbConnaissance = 1;
	
	public Humain(String nom, String boissonfav, int argent) {
		this.nom = nom;
		this.boissonfav = boissonfav;
		this.argent = argent;
	}

	public void parler(String text) {
		System.out.println("(" + this.nom + ") - " + text);
}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + this.nom +  " et j'aime boire du " + this.boissonfav);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + this.boissonfav +  "! GLOUPS !");
	}
	
	public void gagnerArgent(int gain) {
		this.argent += gain;
	}
	
	public void perdreArgent(int perte) {
		this.argent -= perte;
	}
	
	public void acheter(String bien, int prix) {
		if(prix < this.argent) {
			parler("J'ai " + this.argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " � " + prix + " sous");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que  " + this.argent + " sous en poche. Je ne peux pas m'offrir " + bien + " � " + prix + " sous");
		}
	}
	public void memoriser(Humain humain) {
		if (nbConnaissance==maxConnaissance) {
			nbConnaissance = 1;
		}
		connaissance[nbConnaissance] = humain;
		nbConnaissance++;
	}
	
	public void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		parler("Je connais beaucoup de monde dont :");
		for (int i = 0; i<nbConnaissance;i++) {
			System.out.println(" "+connaissance[i].getNom());
		}
	}
}