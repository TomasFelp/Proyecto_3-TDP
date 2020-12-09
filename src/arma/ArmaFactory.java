package arma;

public class ArmaFactory {
	
	private  ArmaSanitariaDefault armaDefault;
	private  ArmaSanitariaPower armaPower;
	private  ArmaSanitariaPerforadora armaPerforadora;
	private static ArmaFactory instancia;
    
    private ArmaFactory() {
    	armaDefault=new ArmaSanitariaDefault();
    	armaPerforadora=new ArmaSanitariaPerforadora();
    	armaPower=new ArmaSanitariaPower();
    }
    
    /**
     * Devuelve la instancia del ArmaFactory.
     */
    public static ArmaFactory getArmaFactory() {
        if (instancia == null) {
        	instancia = new ArmaFactory();
        }
        return instancia;
    }
    
    public Arma getArmaDefault() {
        return armaDefault;
    }
    
    public Arma getArmaPower() {
        return armaPower;
    }
    
    public Arma getArmaPerforadora() {
        return armaPerforadora;
    }
}
   