package nu.hex.story.manager.util.currency.convert;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class EuroToUSDollarConverter extends AbstractDollarConverter {

    public EuroToUSDollarConverter(Integer year) {
        super(year, 1998, 2015);
    }

    static {
        RATIO_MAP.put(1998, 1.122121648018304);
        RATIO_MAP.put(1999, 1.0666413253851026);
        RATIO_MAP.put(2000, 0.9234144634242867);
        RATIO_MAP.put(2001, 0.8959576226462529);
        RATIO_MAP.put(2002, 0.9433800889081037);
        RATIO_MAP.put(2003, 1.1297556385328291);
        RATIO_MAP.put(2004, 1.2424677523234813);
        RATIO_MAP.put(2005, 1.24430196904316);
        RATIO_MAP.put(2006, 1.2555410293116878);
        RATIO_MAP.put(2007, 1.3691684997164484);
        RATIO_MAP.put(2008, 1.4661068180631691);
        RATIO_MAP.put(2009, 1.391321757271914);
        RATIO_MAP.put(2010, 1.3257240353108823);
        RATIO_MAP.put(2011, 1.3904323600486441);
        RATIO_MAP.put(2012, 1.2848392714821248);
        RATIO_MAP.put(2013, 1.3278170095179613);
        RATIO_MAP.put(2014, 1.3265088878195317);
        RATIO_MAP.put(2015, 1.1092116182572604);
    }
}
