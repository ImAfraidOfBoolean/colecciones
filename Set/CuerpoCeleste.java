package Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    enum TipoCuerpoCeleste {
        ESTRELLA,
        PLANETA,
        PLANETA_ENANO,
        LUNA,
        COMETA,
        ASTEROIDE
    }

    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        this.satelites = new HashSet<>();
    }

    public boolean addSatelite(CuerpoCeleste cuerpoCeleste){
        if(!satelites.contains(cuerpoCeleste)){
            satelites.add(cuerpoCeleste);
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Objects.equals(getNombre(), that.getNombre()) && getTipoCuerpo() == that.getTipoCuerpo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getTipoCuerpo());
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", periodoOrbital=" + periodoOrbital +
                ", tipoCuerpo=" + tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return satelites;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

}
