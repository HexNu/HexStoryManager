package nu.hex.story.manager.util.currency.convert;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class ChineseYuanToUSDollarConverter extends AbstractDollarConverter {

    public ChineseYuanToUSDollarConverter(Integer year) {
        super(year, 1922, 2015);
    }

    static {
        RATIO_MAP.put(1922, 0.5557617988047708);
        RATIO_MAP.put(1923, 0.5270399657895553);
        RATIO_MAP.put(1924, 0.5275194595808841);
        RATIO_MAP.put(1925, 0.568938667690981);
        RATIO_MAP.put(1926, 0.4996066764665011);
        RATIO_MAP.put(1927, 0.43925699153449466);
        RATIO_MAP.put(1928, 0.4613311368492702);
        RATIO_MAP.put(1929, 0.4189185428557722);
        RATIO_MAP.put(1930, 0.2991361468732953);
        RATIO_MAP.put(1931, 0.22266201117640919);
        RATIO_MAP.put(1932, 0.2168429750415936);
        RATIO_MAP.put(1933, 0.28110629516396335);
        RATIO_MAP.put(1934, 0.34090958670785454);
        RATIO_MAP.put(1935, 0.3650625229394712);
        RATIO_MAP.put(1936, 0.29703869173475317);
        RATIO_MAP.put(1937, 0.2955614426080371);
        RATIO_MAP.put(1938, 0.21324493390616342);
        RATIO_MAP.put(1939, 0.11885321204446755);
        RATIO_MAP.put(1940, 0.06322147691273888);
        RATIO_MAP.put(1941, 0.053178529111942915);
        RATIO_MAP.put(1942, -0.04076479076479081);
        RATIO_MAP.put(1943, -0.04076479076479081);
        RATIO_MAP.put(1944, -0.04076479076479081);
        RATIO_MAP.put(1945, -0.04076479076479081);
        RATIO_MAP.put(1946, -0.04071940624083111);
        RATIO_MAP.put(1947, -0.04068462401795738);
        RATIO_MAP.put(1948, -0.04068462401795738);
        RATIO_MAP.put(1949, -0.03668792218852768);
        RATIO_MAP.put(1950, 0.29057503231806336);
        RATIO_MAP.put(1951, 0.37480957621500904);
        RATIO_MAP.put(1952, 0.33006250025155026);
        RATIO_MAP.put(1953, 0.2998502567281301);
        RATIO_MAP.put(1954, 0.2673083614049908);
        RATIO_MAP.put(1955, 0.21390423000737369);
        RATIO_MAP.put(1956, 0.17196601222802557);
        RATIO_MAP.put(1957, 0.1349961000354665);
        RATIO_MAP.put(1958, 0.1477521383194129);
        RATIO_MAP.put(1959, 0.179309551203603);
        RATIO_MAP.put(1960, 0.15809686605319206);
        RATIO_MAP.put(1961, 0.09052560153968074);
        RATIO_MAP.put(1962, 0.0673147817594615);
        RATIO_MAP.put(1963, 0.18805129057348527);
        RATIO_MAP.put(1964, 0.2686060429393652);
        RATIO_MAP.put(1965, 0.26589785652031184);
        RATIO_MAP.put(1966, 0.257484499412218);
        RATIO_MAP.put(1967, 0.2794815932768908);
        RATIO_MAP.put(1968, 0.2645180804904632);
        RATIO_MAP.put(1969, 0.29313645557557005);
        RATIO_MAP.put(1970, 0.3001767330541835);
        RATIO_MAP.put(1971, 0.3139302355036905);
        RATIO_MAP.put(1972, 0.38589692387805075);
        RATIO_MAP.put(1973, 0.49902528586178563);
        RATIO_MAP.put(1974, 0.46778099154657565);
        RATIO_MAP.put(1975, 0.4068423716850963);
        RATIO_MAP.put(1976, 0.42733652416843804);
        RATIO_MAP.put(1977, 0.4373526000250413);
        RATIO_MAP.put(1978, 0.4374139177324009);
        RATIO_MAP.put(1979, 0.4192504494953871);
        RATIO_MAP.put(1980, 0.5163403179858023);
        RATIO_MAP.put(1981, 0.4941946976056191);
        RATIO_MAP.put(1982, 0.44655520951082855);
        RATIO_MAP.put(1983, 0.4216308612043448);
        RATIO_MAP.put(1984, 0.37691843949495896);
        RATIO_MAP.put(1985, 0.32556916967121935);
        RATIO_MAP.put(1986, 0.24855309973676362);
        RATIO_MAP.put(1987, 0.22593602181191597);
        RATIO_MAP.put(1988, 0.15031817737852918);
        RATIO_MAP.put(1989, 0.0879824312592976);
        RATIO_MAP.put(1990, 0.07419716713640316);
        RATIO_MAP.put(1991, 0.08855655788346034);
        RATIO_MAP.put(1992, 0.11844030420605149);
        RATIO_MAP.put(1993, 0.10110904109943962);
        RATIO_MAP.put(1994, 0.09169048395522697);
        RATIO_MAP.put(1995, 0.11196346124495202);
        RATIO_MAP.put(1996, 0.11539758514438127);
        RATIO_MAP.put(1997, 0.1164138486130126);
        RATIO_MAP.put(1998, 0.11722977230469998);
        RATIO_MAP.put(1999, 0.12081128570105869);
        RATIO_MAP.put(2000, 0.12093726389272855);
        RATIO_MAP.put(2001, 0.12085271607216251);
        RATIO_MAP.put(2002, 0.12097482097864927);
        RATIO_MAP.put(2003, 0.12084522095170247);
        RATIO_MAP.put(2004, 0.12084688187883966);
        RATIO_MAP.put(2005, 0.1221068785384722);
        RATIO_MAP.put(2006, 0.12550432003861844);
        RATIO_MAP.put(2007, 0.13148379459581214);
        RATIO_MAP.put(2008, 0.1443694410140647);
        RATIO_MAP.put(2009, 0.14673178113846816);
        RATIO_MAP.put(2010, 0.1477291624883811);
        RATIO_MAP.put(2011, 0.15479690313841976);
        RATIO_MAP.put(2012, 0.15848510789030937);
        RATIO_MAP.put(2013, 0.1626650291679456);
        RATIO_MAP.put(2014, 0.16237222392347256);
        RATIO_MAP.put(2015, 0.15914641375222238);
    }
}
