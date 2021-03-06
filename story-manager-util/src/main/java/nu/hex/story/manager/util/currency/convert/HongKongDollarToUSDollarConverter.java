package nu.hex.story.manager.util.currency.convert;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class HongKongDollarToUSDollarConverter extends AbstractDollarConverter {

    public HongKongDollarToUSDollarConverter(Integer year) {
        super(year, 1916, 2015);
    }

    static {
        RATIO_MAP.put(1916, 0.5085991149850958);
        RATIO_MAP.put(1917, 0.6368825690748031);
        RATIO_MAP.put(1918, 0.7807225957719147);
        RATIO_MAP.put(1919, -0.044594141931271716);
        RATIO_MAP.put(1920, -0.03677997861053778);
        RATIO_MAP.put(1921, 0.5220747430103514);
        RATIO_MAP.put(1922, 0.5565668468168565);
        RATIO_MAP.put(1923, 0.5298000671762019);
        RATIO_MAP.put(1924, 0.5252221661685741);
        RATIO_MAP.put(1925, 0.5650799303302781);
        RATIO_MAP.put(1926, 0.5330700929363138);
        RATIO_MAP.put(1927, 0.4919107673133573);
        RATIO_MAP.put(1928, 0.5006705252651894);
        RATIO_MAP.put(1929, 0.4715772814393579);
        RATIO_MAP.put(1930, 0.3384990976467293);
        RATIO_MAP.put(1931, 0.2414496770424406);
        RATIO_MAP.put(1932, 0.2340479707387356);
        RATIO_MAP.put(1933, 0.2895012348852418);
        RATIO_MAP.put(1934, 0.3871314835157395);
        RATIO_MAP.put(1935, 0.4813283970903598);
        RATIO_MAP.put(1936, 0.31661206739433173);
        RATIO_MAP.put(1937, 0.3064298734452151);
        RATIO_MAP.put(1938, 0.3040687135103349);
        RATIO_MAP.put(1939, 0.2746832689958061);
        RATIO_MAP.put(1940, 0.24191863535137859);
        RATIO_MAP.put(1941, 0.24613460464233977);
        RATIO_MAP.put(1942, -0.04076479076479081);
        RATIO_MAP.put(1943, -0.04076479076479081);
        RATIO_MAP.put(1944, -0.04076479076479081);
        RATIO_MAP.put(1945, -0.04076479076479081);
        RATIO_MAP.put(1946, 0.35220166048418705);
        RATIO_MAP.put(1947, 0.2910946884542646);
        RATIO_MAP.put(1948, 0.2724243403071051);
        RATIO_MAP.put(1949, 0.2117604082456455);
        RATIO_MAP.put(1950, 0.1754629437745407);
        RATIO_MAP.put(1951, 0.17621969902410548);
        RATIO_MAP.put(1952, 0.17224744195919478);
        RATIO_MAP.put(1953, 0.17585787794130442);
        RATIO_MAP.put(1954, 0.17603546344527984);
        RATIO_MAP.put(1955, 0.1768389384815512);
        RATIO_MAP.put(1956, 0.17444551417200682);
        RATIO_MAP.put(1957, 0.1745139137355448);
        RATIO_MAP.put(1958, 0.1747413883299107);
        RATIO_MAP.put(1959, 0.17590840121994916);
        RATIO_MAP.put(1960, 0.1770669296970308);
        RATIO_MAP.put(1961, 0.1762383868489455);
        RATIO_MAP.put(1962, 0.1767755854994924);
        RATIO_MAP.put(1963, 0.17565048566135036);
        RATIO_MAP.put(1964, 0.17505436941965122);
        RATIO_MAP.put(1965, 0.17447835822605096);
        RATIO_MAP.put(1966, 0.17460492688041868);
        RATIO_MAP.put(1967, 0.17559170445960834);
        RATIO_MAP.put(1968, 0.17065768991154184);
        RATIO_MAP.put(1969, 0.17141836298817048);
        RATIO_MAP.put(1970, 0.167522173048736);
        RATIO_MAP.put(1971, 0.17000232104548668);
        RATIO_MAP.put(1972, 0.183545024195605);
        RATIO_MAP.put(1973, 0.20112830394155623);
        RATIO_MAP.put(1974, 0.19351267445508366);
        RATIO_MAP.put(1975, 0.2047755153380708);
        RATIO_MAP.put(1976, 0.20857293310201583);
        RATIO_MAP.put(1977, 0.2132871569664977);
        RATIO_MAP.put(1978, 0.2133155668872157);
        RATIO_MAP.put(1979, 0.19987626634593456);
        RATIO_MAP.put(1980, 0.20038254162593713);
        RATIO_MAP.put(1981, 0.17999848146122252);
        RATIO_MAP.put(1982, 0.16531072520775247);
        RATIO_MAP.put(1983, 0.1384650899125267);
        RATIO_MAP.put(1984, 0.12939091821596144);
        RATIO_MAP.put(1985, 0.1303574883656747);
        RATIO_MAP.put(1986, 0.12816914377599015);
        RATIO_MAP.put(1987, 0.12897085960055626);
        RATIO_MAP.put(1988, 0.12509954010473526);
        RATIO_MAP.put(1989, 0.1290823984429997);
        RATIO_MAP.put(1990, 0.13039144140420889);
        RATIO_MAP.put(1991, 0.1296985444992043);
        RATIO_MAP.put(1992, 0.1293484142941771);
        RATIO_MAP.put(1993, 0.1293914810418238);
        RATIO_MAP.put(1994, 0.12886113133714025);
        RATIO_MAP.put(1995, 0.12921463525317042);
        RATIO_MAP.put(1996, 0.12948898225152147);
        RATIO_MAP.put(1997, 0.1294444320158643);
        RATIO_MAP.put(1998, 0.12939226858174047);
        RATIO_MAP.put(1999, 0.12892117639120684);
        RATIO_MAP.put(2000, 0.12850189013727775);
        RATIO_MAP.put(2001, 0.12826493850914733);
        RATIO_MAP.put(2002, 0.12839006936566713);
        RATIO_MAP.put(2003, 0.12845414644218425);
        RATIO_MAP.put(2004, 0.12843163490504808);
        RATIO_MAP.put(2005, 0.12865366405654607);
        RATIO_MAP.put(2006, 0.12882626511831177);
        RATIO_MAP.put(2007, 0.12821610270924652);
        RATIO_MAP.put(2008, 0.1288294477621956);
        RATIO_MAP.put(2009, 0.12931090979116253);
        RATIO_MAP.put(2010, 0.12873532211935226);
        RATIO_MAP.put(2011, 0.12846126614231412);
        RATIO_MAP.put(2012, 0.1289222776515039);
        RATIO_MAP.put(2013, 0.12892232115443597);
        RATIO_MAP.put(2014, 0.12896452163261715);
        RATIO_MAP.put(2015, 0.1289982216953164);
    }
}
