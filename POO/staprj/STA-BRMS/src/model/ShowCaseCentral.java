package model;

import java.util.ArrayList;
import java.util.HashMap;
import persistency.EntityCentral;

/**
 * Facade Pattern
 *
 * @author LPS
 */
public class ShowCaseCentral {

    private final HashMap<String, Product> allProducts;
    private final ArrayList<Offer> allOffers;
    private final ArrayList<ShowCase> allShowCases;

    public ShowCaseCentral() {
        allProducts = new HashMap();
        EntityCentral.scc.getProductsFromDB();
        
        allOffers = new ArrayList();
        allShowCases = new ArrayList();

    }

    //Creates a new known Product
    public void newProduct(String n, String d, double p) {
        allProducts.put(n, new Product(n, d, p));
    }

    //Return list of products by names
    public ArrayList<String> productsByName() {
        return new ArrayList(allProducts.keySet());
    }

    //Creates a new known Offer
    public void newOffer(String n, int q) {
        if (!allProducts.containsKey(n)) {
            return;
        }
        Product p = allProducts.get(n);
        allOffers.add(new Offer(q, p));
    }

    //Creates new known ShowCase
    public void newShowCase(String n) {
        allShowCases.add(new ShowCase(n));
    }

    //Add Offer to ShowCase
    public void offerProduct(int io, int isc) {
        Offer o = getOfferByIndex(io);
        ShowCase sc = getShowCaseByIndex(isc);
        sc.addOffer(o);
    }

    //Get ShowCase by Index
    private ShowCase getShowCaseByIndex(int isc) {
        return allShowCases.get(isc);
    }

    //Get Offer by Index
    private Offer getOfferByIndex(int io) {
        return allOffers.get(io);
    }
}
