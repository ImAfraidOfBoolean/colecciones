package Set;

public class Planeta extends CuerpoCeleste{
    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste cuerpoCeleste) {
        if(cuerpoCeleste.getTipoCuerpo().equals(TipoCuerpoCeleste.LUNA)){
            return super.addSatelite(cuerpoCeleste);
        }
        return false;
    }
}
