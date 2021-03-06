package nu.hex.story.manager.util.currency.convert;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class FinnishMarkToUSDollarConverter extends AbstractDollarConverter {

    public FinnishMarkToUSDollarConverter(Integer year) {
        super(year, 1880, 1998);
    }

    static {
        RATIO_MAP.put(1913, 0.19190105157223697);
        RATIO_MAP.put(1914, 0.18640377490881346);
        RATIO_MAP.put(1915, 0.15300900891738692);
        RATIO_MAP.put(1916, 0.14366768797383864);
        RATIO_MAP.put(1917, 0.1401058221457726);
        RATIO_MAP.put(1918, 0.12717313717211529);
        RATIO_MAP.put(1919, 0.07078405024812275);
        RATIO_MAP.put(1920, 0.036740573791466356);
        RATIO_MAP.put(1921, 0.020259099099656376);
        RATIO_MAP.put(1922, 0.021646541859276894);
        RATIO_MAP.put(1923, 0.026853185397189082);
        RATIO_MAP.put(1924, 0.025127549175657425);
        RATIO_MAP.put(1925, 0.0252417991778731);
        RATIO_MAP.put(1926, 0.02516642455347413);
        RATIO_MAP.put(1927, 0.025211984463162366);
        RATIO_MAP.put(1928, 0.025195766694875974);
        RATIO_MAP.put(1929, 0.025165034741412903);
        RATIO_MAP.put(1930, 0.025188934875701296);
        RATIO_MAP.put(1931, 0.02320808844277631);
        RATIO_MAP.put(1932, 0.015546973711416274);
        RATIO_MAP.put(1933, 0.01848384627751519);
        RATIO_MAP.put(1934, 0.022328981826200096);
        RATIO_MAP.put(1935, 0.021690251511504464);
        RATIO_MAP.put(1936, 0.021997765799343875);
        RATIO_MAP.put(1937, 0.02188282938978781);
        RATIO_MAP.put(1938, 0.021636114493970907);
        RATIO_MAP.put(1939, 0.020618416407267432);
        RATIO_MAP.put(1940, 0.020452380952381003);
        RATIO_MAP.put(1941, 0.020472117136686802);
        RATIO_MAP.put(1942, 0.020452380952381003);
        RATIO_MAP.put(1943, 0.020452380952381003);
        RATIO_MAP.put(1944, 0.020452380952381003);
        RATIO_MAP.put(1945, 0.01248041719936789);
        RATIO_MAP.put(1946, 0.007448342302065488);
        RATIO_MAP.put(1947, 0.007472222222222222);
        RATIO_MAP.put(1948, 0.007472222222222221);
        RATIO_MAP.put(1949, 0.0062020212047799545);
        RATIO_MAP.put(1950, 0.004382239382239387);
        RATIO_MAP.put(1951, 0.004382239382239387);
        RATIO_MAP.put(1952, 0.004382239382239382);
        RATIO_MAP.put(1953, 0.0043822393822393925);
        RATIO_MAP.put(1954, 0.004382239382239387);
        RATIO_MAP.put(1955, 0.004382239382239377);
        RATIO_MAP.put(1956, 0.004382239382239384);
        RATIO_MAP.put(1957, 0.00397727103921781);
        RATIO_MAP.put(1958, 0.003164412366960866);
        RATIO_MAP.put(1959, 0.0031463386506236);
        RATIO_MAP.put(1960, 0.3144076153272251);
        RATIO_MAP.put(1961, 0.31341458703444786);
        RATIO_MAP.put(1962, 0.3127923978067071);
        RATIO_MAP.put(1963, 0.3109127377099068);
        RATIO_MAP.put(1964, 0.3113154252259883);
        RATIO_MAP.put(1965, 0.31114062072394255);
        RATIO_MAP.put(1966, 0.310876272113667);
        RATIO_MAP.put(1967, 0.2945476764895008);
        RATIO_MAP.put(1968, 0.23934248925719814);
        RATIO_MAP.put(1969, 0.23866696341098714);
        RATIO_MAP.put(1970, 0.23987823424577365);
        RATIO_MAP.put(1971, 0.2402041190493768);
        RATIO_MAP.put(1972, 0.24175769318901608);
        RATIO_MAP.put(1973, 0.2631750076991445);
        RATIO_MAP.put(1974, 0.2664615740177416);
        RATIO_MAP.put(1975, 0.2727855985671284);
        RATIO_MAP.put(1976, 0.2595873528802125);
        RATIO_MAP.put(1977, 0.2487364001866127);
        RATIO_MAP.put(1978, 0.24367889900629428);
        RATIO_MAP.put(1979, 0.2575363589487998);
        RATIO_MAP.put(1980, 0.26888900923922004);
        RATIO_MAP.put(1981, 0.2327197275079478);
        RATIO_MAP.put(1982, 0.2084190690487646);
        RATIO_MAP.put(1983, 0.17997620230608155);
        RATIO_MAP.put(1984, 0.16689020905797297);
        RATIO_MAP.put(1985, 0.16192013997121066);
        RATIO_MAP.put(1986, 0.19746275216783782);
        RATIO_MAP.put(1987, 0.22781183233807784);
        RATIO_MAP.put(1988, 0.23935894993725768);
        RATIO_MAP.put(1989, 0.23360835558183626);
        RATIO_MAP.put(1990, 0.2618899767371799);
        RATIO_MAP.put(1991, 0.2477271128250102);
        RATIO_MAP.put(1992, 0.22381048429969813);
        RATIO_MAP.put(1993, 0.17523586902413255);
        RATIO_MAP.put(1994, 0.1918339727604643);
        RATIO_MAP.put(1995, 0.22918690200821218);
        RATIO_MAP.put(1996, 0.2177998487458192);
        RATIO_MAP.put(1997, 0.1928381576125203);
        RATIO_MAP.put(1998, 0.18702559874404687);
    }
}
