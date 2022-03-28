package nu.hex.story.manager.util.currency.convert;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class RussianRubleToUSDollarConverter extends AbstractDollarConverter {

    public RussianRubleToUSDollarConverter(Integer year) {
        super(year, 1880, 2015);
    }

    static {
        RATIO_MAP.put(1880, 0.49253279420293067);
        RATIO_MAP.put(1881, 0.49237577532619275);
        RATIO_MAP.put(1882, 0.4766554348489784);
        RATIO_MAP.put(1883, 0.46682229508887163);
        RATIO_MAP.put(1884, 0.47655168244377183);
        RATIO_MAP.put(1885, 0.4797250383213081);
        RATIO_MAP.put(1886, 0.4641055086874754);
        RATIO_MAP.put(1887, 0.4266611671746406);
        RATIO_MAP.put(1888, 0.4415322674319534);
        RATIO_MAP.put(1889, 0.49666180015432454);
        RATIO_MAP.put(1890, 0.5423001708982043);
        RATIO_MAP.put(1891, 0.5239747552300735);
        RATIO_MAP.put(1892, 0.4733405560599878);
        RATIO_MAP.put(1893, 0.4891898426866517);
        RATIO_MAP.put(1894, 0.5103222812471485);
        RATIO_MAP.put(1895, 0.5127665743948697);
        RATIO_MAP.put(1896, 0.5040635223066116);
        RATIO_MAP.put(1897, 0.5032719929716921);
        RATIO_MAP.put(1898, 0.5013077154671912);
        RATIO_MAP.put(1899, 0.5023962882494923);
        RATIO_MAP.put(1900, 0.5037672088716341);
        RATIO_MAP.put(1901, 0.5043001648908642);
        RATIO_MAP.put(1902, 0.5043869593335272);
        RATIO_MAP.put(1903, 0.5049598941365299);
        RATIO_MAP.put(1904, 0.5052601227862151);
        RATIO_MAP.put(1905, 0.5033494207818677);
        RATIO_MAP.put(1906, 0.49205893649569765);
        RATIO_MAP.put(1907, 0.5022132720211686);
        RATIO_MAP.put(1908, 0.5068783634148085);
        RATIO_MAP.put(1909, 0.5128751963888154);
        RATIO_MAP.put(1910, 0.5126294690407734);
        RATIO_MAP.put(1911, 0.5119329074288338);
        RATIO_MAP.put(1912, 0.5113187955836858);
        RATIO_MAP.put(1913, 0.5101043778946449);
        RATIO_MAP.put(1914, -0.048908339181214545);
        RATIO_MAP.put(1915, -0.04801469806257112);
        RATIO_MAP.put(1916, -0.04782303837064122);
        RATIO_MAP.put(1917, -0.04782419530148183);
        RATIO_MAP.put(1961, 0.3818214255999712);
        RATIO_MAP.put(1962, 0.285067388316234);
        RATIO_MAP.put(1963, 0.2890246236433093);
        RATIO_MAP.put(1964, 0.3078895095791619);
        RATIO_MAP.put(1965, 0.33429281047654247);
        RATIO_MAP.put(1966, 0.24727455194141312);
        RATIO_MAP.put(1967, 0.23956014202184583);
        RATIO_MAP.put(1968, 0.19427433917907735);
        RATIO_MAP.put(1969, 0.19173460104724407);
        RATIO_MAP.put(1970, 0.17292498469506645);
        RATIO_MAP.put(1971, 0.18919159234648786);
        RATIO_MAP.put(1972, 0.24875046714224672);
        RATIO_MAP.put(1973, 0.2619112114456693);
        RATIO_MAP.put(1974, 0.319147712153686);
        RATIO_MAP.put(1975, 0.3183637716183033);
        RATIO_MAP.put(1976, 0.273484830416203);
        RATIO_MAP.put(1977, 0.25656328609509294);
        RATIO_MAP.put(1978, 0.24620392238860106);
        RATIO_MAP.put(1979, 0.24591100952339);
        RATIO_MAP.put(1980, 0.2537141050530902);
        RATIO_MAP.put(1981, 0.27003646867347525);
        RATIO_MAP.put(1982, 0.25953126856896236);
        RATIO_MAP.put(1983, 0.24783424088955375);
        RATIO_MAP.put(1984, 0.22053193461564713);
        RATIO_MAP.put(1985, 0.20117254496851183);
        RATIO_MAP.put(1986, 0.24761957196916018);
        RATIO_MAP.put(1987, 0.22260365600102328);
        RATIO_MAP.put(1988, 0.16037992282774371);
        RATIO_MAP.put(1989, 0.08413548429611467);
        RATIO_MAP.put(1990, 0.050764686991973826);
        RATIO_MAP.put(1991, 0.01566739941874787);
        RATIO_MAP.put(1992, 0.004480756501868886);
        RATIO_MAP.put(1993, 0.0010005441431262978);
        RATIO_MAP.put(1994, 0.0004375627649422898);
        RATIO_MAP.put(1995, 0.00021433995713497438);
        RATIO_MAP.put(1996, 0.00019108591962805303);
        RATIO_MAP.put(1997, 0.00017161959212852354);
        RATIO_MAP.put(1998, 0.09643691693925856);
        RATIO_MAP.put(1999, 0.040621855728690676);
        RATIO_MAP.put(2000, 0.03559222549694757);
        RATIO_MAP.put(2001, 0.034294027181635565);
        RATIO_MAP.put(2002, 0.031941049305747135);
        RATIO_MAP.put(2003, 0.03258958393291661);
        RATIO_MAP.put(2004, 0.03471349136851719);
        RATIO_MAP.put(2005, 0.03537571791992041);
        RATIO_MAP.put(2006, 0.03680271008205329);
        RATIO_MAP.put(2007, 0.039102196437972456);
        RATIO_MAP.put(2008, 0.04036448250552854);
        RATIO_MAP.put(2009, 0.03158079800003254);
        RATIO_MAP.put(2010, 0.032934963177095856);
        RATIO_MAP.put(2011, 0.03402299558250868);
        RATIO_MAP.put(2012, 0.032194409186173584);
        RATIO_MAP.put(2013, 0.031406662572919804);
        RATIO_MAP.put(2014, 0.02638450209253832);
        RATIO_MAP.put(2015, 0.016479075281564864);
    }
}
