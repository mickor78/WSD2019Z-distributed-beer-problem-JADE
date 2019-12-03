package pl.edu.pw.eiti.wsd.bar_finder.commons.input_structures;

public class BarBeerData {

    // https://www.wiki.piwo.org/Zestawienie_styl%C3%B3w_piw_(tabela)
    /// TODO: Move to model.
//public enum BeerStyle
//{
//    LITE_AMERICAN_LAGER,
//    STANDARD_AMERICAN_LAGER,
//    PREMIUM_AMERICAN_LAGER,
//    MUNICH_HELLES,
//    DORTMUNDER_EXPORT,
//
//    GERMAN_PILSNER,
//    BOHEMIAN_PILSENER,
//    CLASSIC_AMERICAN_PILSNER,
//
//    VIENNA_LAGER,
//    OKTOBERFEST,
//
//    DARK_AMERICAN_LAGER,
//    MUNICH_DUNKEL,
//    SCHWARZBIER,
//
//    HELLES_BOCK,
//    TRADITIONAL_BOCK,
//    DOPPELBOCK,
//    EISBOCK,
//
//    CREAM_ALE,
//    BLONDE_ALE,
//    KOLSCH,
//    AMERICAN_WHEAT,
//
//    NORTH_GERMAN_ALTBIER,
//    CALIFORNIA_COMMON_BEER,
//    DUSSELDORF_ALTBIER,
//
//    STANDARD_BITTER,
//    SPECIAL_BITTER,
//    EXTRA_SPECIAL_BITTER,
//
//    SCOTTISH_LIGHT,
//    SCOTTISH_HEAVY,
//    SCOTTISH_EXPORT,
//    IRISH_RED_ALE,
//    STRONG_SCOTCH_ALE,
//
//    AMERICAN_PALE_ALE,
//    AMERICAN_AMBER_ALE,
//    AMERICAN_BROWN_ALE,
//
//    MILD,
//    SOUTHERN_ENGLISH_BROWN,
//    NORTHERN_ENGLISH_BROWN,
//
//    BROWN_PORTER,
//    ROBUST_PORTER,
//    BALTIC_PORTER,
//
//    DRY_STOUT,
//    SWEET_STOUT,
//    OATMEAL_STOUT,
//    FOREIGN_EXTRA_STOUT,
//    AMERICAN_STOUT,
//    RUSSIAN_IMPERIAL_STOUT,
//
//    ENGLISH_IPA,
//    AMERICAN_IPA,
//    IMPERIAL_IPA,
//
//    WEIZEN,
//    DUNKELWEIZEN,
//    WEIZENBOCK,
//    ROGGENBIER,
//
//    WITBIER,
//    BELGIAN_PALE_ALE,
//    SAISON,
//    BIERE_DE_GARDE,
//
//    BERLINER_WEISSE,
//    FLANDERS_RED_ALE,
//    FLANDERS_BROWN_ALE,
//    STRAIGHT_LAMBIC,
//    GUEUZE,
//    FRUIT_LAMBIC,
//
//    BELGIAN_BLOND_ALE,
//    BELGIAN_DUBBEL,
//    BELGIAN_TRIPEL,
//    BELGIAN_GOLDEN_STRONG_ALE,
//    BELGIAN_DARK_STRONG_ALE,
//
//    OLD_ALE,
//    ENGLISH_BARLEYWINE,
//    AMERICAN_BARLEYWINE,
//}

    public final static String BEER_NAME_KEY = "name";
    public final static String BEER_BREWERY_NAME_KEY = "brewery";
    public final static String BEER_STYLE_KEY = "style";
    public final static String BEER_PRICE_KEY = "price";
    public final static String BEER_QUANTITY_KEY = "quantity";

    private String name;
    private String breweryName;
    private String style;
    private double price;
    private double quantity;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBreweryName() {
        return breweryName;
    }
    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BarBeerData()
    {}

    public BarBeerData(String name, String breweryName, String style, double price, double quantity)
    {
        setName(name);
        setBreweryName(breweryName);
        setStyle(style);
        setPrice(price);
        setQuantity(quantity);
    }
}