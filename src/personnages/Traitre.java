package personnages;

public class Traitre extends Samourai{
	private int niveauT = 0;
	
	
	public Traitre(String nom,String seigneur, String boissonfav, int argent) {
		super(nom,seigneur,boissonfav ,argent);
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauT<3) {
			int butin = commercant.getArgent()*(2/10);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi" + butin + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " +this.getNom() +".");
			commercant.perdreArgent(butin);
			this.gagnerArgent(butin);
			
		}
		else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me démasquer");
		}
	}
	
}
