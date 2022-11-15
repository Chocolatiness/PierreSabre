package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 4;
	
	public Yakuza(String nom, String boissonfav, int argent, String clan) {
		super(nom,boissonfav ,argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int butin = victime.seFaireExtorquer();
		gagnerArgent(butin);
		parler("j'ai piqué les " + butin + " sous de " + victime.getNom() + " , ce qui me fait " + this.getArgent() + " sous dans ma poche. Hi ! Hi !");
		this.reputation += 1;
	}

	public int perdre() {
		int butin = this.getArgent();
		this.perdreArgent(butin);
		this.reputation -= 1;
		parler("J'ai perdu mon duel et mes " + butin + " sous , snif... J'ai déshonoré le clan de " + this.clan);
		return butin;
	}
	
	public void gagner(int gain) {
		this.gagnerArgent(gain);
		this.reputation += 1;
		parler("Ce ronin pensait vraiment battre " + this.getNom() + " du clan de " + this.clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}

	public int getReputation() {
		return reputation;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan);
	}
}
