package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Test testuje dohratelnost hry. Protože hra generuje předměty, které se dají sebrat náhodně, tak je nutné si vytvořit menší ,,hack,,
     * Vytvoříme si věci, dáme si je do místnosti jako kdybysme je sebrali.
     * 
     */
    @Test
    public void testVyhry() 
    {
        hra.zpracujPrikaz("seber cd_s_hudbou");
        hra.zpracujPrikaz("jdi Knihovna");
        hra.zpracujPrikaz("seber kniha_nicolase_flaminga");
        hra.zpracujPrikaz("jdi Hagridův_dům");
        hra.zpracujPrikaz("jdi Pokoj_pred_komnatou");
        hra.zpracujPrikaz("otevri Tajemná_komnata");
        hra.zpracujPrikaz("zapni hudbu");
        hra.zpracujPrikaz("jdi Tajemná_komnata");
        hra.zpracujPrikaz("seber tajemný_šperk");
        assertEquals(true, hra.konecHry());
    }
    @Test
    public void testProhry() 
    {
        hra.zpracujPrikaz("jdi Snapuv_kabinet");
        assertEquals(true, hra.konecHry());
    }
    @Test
    public void testProhry2() 
    {
        hra.zpracujPrikaz("jdi Knihovna");
        hra.zpracujPrikaz("jdi Hagridův_dům");
        hra.zpracujPrikaz("jdi Herni_mistnost");
        assertEquals(true, hra.konecHry());
    }
    @Test
    public void testBatohu() //Test batohu 
    {
        hra.zpracujPrikaz("seber cd_s_hudbou");
        assertEquals(1, hra.getHerniPlan().getBatoh().vratObsahBatohu().size()); 
        // Test že máme v batohu jednu věc
        hra.zpracujPrikaz("vyhod cd_s_hudbou");
        assertEquals(0, hra.getHerniPlan().getBatoh().vratObsahBatohu().size());
        // Test že jsme vyhodili věc a nemáme v batohu nic
        hra.zpracujPrikaz("seber cd_s_hudbou");
        assertEquals(1, hra.getHerniPlan().getBatoh().vratObsahBatohu().size());
        // Test že jsme věc opět sebrali
        hra.zpracujPrikaz("jdi Knihovna");
        hra.zpracujPrikaz("seber kniha_nicolase_flaminga");
        hra.zpracujPrikaz("seber časopis_svět_magie");
        assertEquals(2, hra.getHerniPlan().getBatoh().vratObsahBatohu().size());
        // Test, že máme v batohu 2 věci, ikdyž jsme sebrali tři - kapacita je nastavena na 2
    }

}
