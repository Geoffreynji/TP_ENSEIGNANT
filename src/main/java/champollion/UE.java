package champollion;

public class UE {
    private final String myIntitule;
    private int heuresCM;
    private int heuresTD;
    private int heuresTP;
    
    public UE(String myIntitule)
    {
    	this.myIntitule = myIntitule;
    }

    public UE(String myIntitule, int heuresCM, int heuresTD, int heuresTP) {
		this.myIntitule = myIntitule;
		this.heuresCM = heuresCM;
		this.heuresTD = heuresTD;
		this.heuresTP = heuresTP;
	}

	public int getHeuresCM() {
		return heuresCM;
	}

	public void setHeuresCM(int heuresCM) {
		this.heuresCM = heuresCM;
	}

	public int getHeuresTD() {
		return heuresTD;
	}

	public void setHeuresTD(int heuresTD) {
		this.heuresTD = heuresTD;
	}

	public int getHeuresTP() {
		return heuresTP;
	}

	public void setHeuresTP(int heuresTP) {
		this.heuresTP = heuresTP;
	}

	public String getMyIntitule() {
		return myIntitule;
	}

	public String getIntitule() {
        return myIntitule;
    }

    
}
