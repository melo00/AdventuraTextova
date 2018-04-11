/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PrikazOtevri implements IPrikaz{
    private static final String NAZEV = "otevri";
    private HerniPlan plan;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazOtevri(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu), který se má otevřít
     *                       
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) 
    {
        if (parametry.length == 0) {
            
            return "Co mám otevřít? Musíš zadat název prostoru";
        }

        String nazev = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        if(nazev.equals("Tajemná_komnata"))
        {
            if(aktualniProstor.getNazev().equals("Pokoj_pred_komnatou"))
            {
                if(plan.getBatoh().obsahujeVec("kniha_nicolase_flaminga"))
                {
                    plan.Otevri();
                    return "Úspěšně jsi otevřel tajemnou komnatu!.";
                }
                else
                {
                    return "K otevření zámku potřebuješ mít u sebe knihu Nicolase Flaminga.";
                }
            }
            else
            {
                return "Otevřít jde pokoj před komnatou jen z lokace Pokoj_pred_komnatou";
            }
        }
        else
        {
            return "Otevřít lze jen lokaci jmenem Tajemná_komnata";
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
