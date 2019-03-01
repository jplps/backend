package Auto;
/**
 * Os sensores servem para detecção de velocidade:
 * Rápido / Devagar.
 *
 * @author LPS
 */
public enum Sensor {
    SENS01("S-ID01", 0);
    
    //Atributos do GPS:
    public final String sSensId;
    int iMainVel; //(2)RÁPIDO, (1)DEVAGAR e (0)PARADO
    
    //Renomeando:
    @Override
    public String toString(){
        return sSensId;
    }
    
    //Construtor:
    private Sensor(String id, int vel){
        sSensId = id;
        iMainVel = vel;
    }
    
    //Método de leitura de inf:
    public void updateGps(Camera cam){
        switch (cam.getCamObstCod()){
            case 1:
                //Logic for the obstacle here
                break;
            case 2:
                //Logic for the obstacle here
                break;
        }
    }
    

    //Método de modificação de direção do carro:
    public void MudaVel(Automovel auto) {
        if (iMainVel != auto.iCarVel)
            auto.iCarVel = iMainVel;
    }
}
