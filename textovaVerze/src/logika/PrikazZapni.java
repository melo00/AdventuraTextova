/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class PrikazZapni implements IPrikaz{
    private static final String NAZEV = "zapni";
    private HerniPlan plan;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "zapni" 
    */    
    public PrikazZapni(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "zapni". Používá se pro zapnutí hudby
     *  
     *@param parametry - jako parametr se udává co se má zapnout - v našem případě hudba
     *                       
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) 
    {
        if (parametry.length == 0) {
            
            return "Co mám zapnout?";
        }

        String nazev = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        
        if(nazev.equals("hudbu"))
        {
            if(aktualniProstor.getNazev().equals("Pokoj_pred_komnatou"))
            {
                if(plan.getBatoh().obsahujeVec("cd_s_hudbou"))
                {
                    plan.zapniHudbu();
                    plan.getBatoh().vyhodVec("cd_s_hudbou");
                    return "Úspěšně jsi zapl hudbu a bestie v komnatě usla!.";
                }
                else
                {
                    return "K zapnutí hudby u sebe musíš mít cd s hudbou.";
                }
            }
            else
            {
                return "Zapnout hudbu lze jen v lokaci Pokoj_pred_komnatou";
            }
        }
        else
        {
            return "Zapnout lze jen hudbu";
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
