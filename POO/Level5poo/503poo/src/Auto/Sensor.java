package Auto;
/**
 * Os sensores servem para detecção de velocidade:
 * Rápido / Devagar.
 *
 * @author LPS
 */
public enum Sensor implements Control {
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
    

    //Método de modificação de direção do carro:
    public void MudaVel(Automovel auto) {
        if (iMainVel != auto.iCarVel)
            auto.iCarVel = iMainVel;
    }

    @Override
    public void ChangeCarState(Camera cam) {
        switch (cam.iCamObst){
            case JACU:
                //Logic for the obstacle here
                break;
            case PEDESTRE:
                //Logic for the obstacle here
                break;
        }
    }
}
