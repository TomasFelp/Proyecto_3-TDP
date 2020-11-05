package arma;

public abstract class ArmaFactory {
    public static Arma getDefaultArma() {
        return new ArmaSanitariaDefault();
    }
}
