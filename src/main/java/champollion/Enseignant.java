package champollion;

import java.util.ArrayList;

public class Enseignant extends Personne {

	ArrayList<ServicePrevu> serviceprevu = new ArrayList();
	ArrayList<Intervention> intervention = new ArrayList();
	ServicePrevu service;

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
    	double heureTot = 0;
        for(ServicePrevu sp : serviceprevu)
        {
        	heureTot =+ sp.getVolumeCM()*1.5 + sp.getVolumeTD()*1 + sp.getVolumeTP()*0.75;
        } return (int)heureTot;
    }
    
    public boolean enSousService()
    {
    	int heureprevues = 0;
    	
    	heureprevues = heuresPrevues();
    	
    	if(heureprevues < 192)
    	{
    		return true;
    	}
    	else
    	{
    		return false;

    	}
    	
    }
    
    public void ajouteIntervention(Intervention inter)
    {
    	intervention.add(inter);
    }
    
    public int resteAPlanifier(UE ue, TypeIntervention type)
    {
    	int result = 0;
    	if(type == TypeIntervention.TD)
    	{
    		result = 192 - ue.getHeuresTD();
    	}
    	if(type == TypeIntervention.CM)
    	{
    		result = 192 - ue.getHeuresCM();
    	}
    	if(type == TypeIntervention.TP)
    	{
    		result = 192 - ue.getHeuresTP();
    	}
    	if(result < 0)
    	{
    		result = 0;
    	}
    	return result;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
    	double heureTot = 0;
    		for(ServicePrevu sp : serviceprevu)
            {
    			if(sp.getUe() == ue)
    			{
    				heureTot =+ sp.getVolumeCM()*1.5 + sp.getVolumeTD()*1 + sp.getVolumeTP()*0.75;
    			}
            } 
    	
    		return (int)heureTot;
    
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
    	if(volumeCM<0 || volumeTD < 0 || volumeTP < 0)
    	{
    		throw new IllegalArgumentException("mauvaise valeur");
    	}
    		if(service == null ) {
    			service = new ServicePrevu(volumeCM,volumeTD,volumeTP,ue);
    			serviceprevu.add(service);
    		}
    		else
    		{
    			service.setVolumeCM(volumeCM + service.getVolumeCM());
    			service.setVolumeTD(volumeTD + service.getVolumeTD());
    			service.setVolumeCM(volumeTP + service.getVolumeTP());
    		}

    }

}
