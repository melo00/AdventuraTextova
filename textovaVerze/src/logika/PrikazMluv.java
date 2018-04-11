/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PrikazMluv implements IPrikaz{
    private static final String NAZEV = "mluv";
    private HerniPlan plan;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "mluv" 
    */    
    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *                       
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) 
    {
        if (parametry.length == 0) {
            
            return "S kým mám mluvit?";
        }

        String nazev = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        
        if(nazev.equals("Hagrid"))
        {
            if(aktualniProstor.getNazev().equals("Pokoj_pred_komnatou"))
            {
                return "Harry, abys mohl projit do tajemné komnaty \n"
                +"musíš nejprve uspat psa hudbou a také \n"
                + "otevřít dveře do tajemné komnaty pomocí Flamingovy knihy kouzel";
            }
            else
            {
                return "Mluvit s Hagridem můžeš jen v jeho lokaci";
            }
        }
        else
        {
            return "Mluvit lze jen s Hagridem ( Hagrid )";
        }
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
