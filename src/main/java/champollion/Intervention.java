package champollion;
import java.util.Date;

public class Intervention {
	private Date debut;
	private int duree;
	private boolean annulee = false;
	private int heureDebut;
	private UE ue;
	private Salle salle;
	private Enseignant enseignant;
	
	
	public Intervention(Date debut, int duree, boolean annulee, int heureDebut,UE ue, Salle salle,Enseignant enseignant)
	{
		this.debut = debut;
		this.duree = duree;
		this.annulee = annulee;
		this.heureDebut = heureDebut;
		this.ue = ue;
		this.salle = salle;
		this.enseignant = enseignant;
	}


	public Date getDebut() {
		return debut;
	}


	public void setDebut(Date debut) {
		this.debut = debut;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public boolean isAnnulee() {
		return annulee;
	}


	public void setAnnulee(boolean annulee) {
		this.annulee = annulee;
	}


	public int getHeureDebut() {
		return heureDebut;
	}


	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}


	public UE getUe() {
		return ue;
	}


	public void setUe(UE ue) {
		this.ue = ue;
	}


	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	
	

}
