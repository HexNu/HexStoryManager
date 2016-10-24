package nu.hex.story.manager.core.rpg.coc.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import nu.hex.story.manager.core.domain.rpg.coc.character.CoCIncomeAndSavings;

/**
 * Created 2016-okt-23
 *
 * @author hl
 */
public class PoundToDollarConverter {

    private static final Map<Integer, Double> RATIO_MAP = new HashMap<>();
    private final Integer year;

    /**
     * Calculate approximate exchange rate for pound to dollar between 1792 and
     * 2015.
     *
     * @param year
     */
    public PoundToDollarConverter(Integer year) {
        this.year = year;
        if (year < 1791 || year > 2015) {
            throw new IllegalArgumentException("The value is out of range (1791 - 2015)");
        }
    }

    /**
     * Returns the calculated result with for decimal digits
     *
     * @param dollar
     * @return
     */
    public Double getDollarToPound(Double dollar) {
        return Double.valueOf(String.format("%.4f", dollar / RATIO_MAP.get(year)).replaceAll(",", "."));
    }

    public Double getDollarToPound(Integer dollar) {
        return getDollarToPound(dollar.doubleValue());
    }

    /**
     * Returns the calculated result with for decimal digits
     *
     * @param pound
     * @return
     */
    public Double getPoundToDollar(Double pound) {
        return Double.valueOf(String.format(Locale.ENGLISH, "%0.4f", pound * RATIO_MAP.get(year)).replaceAll(",", "."));
    }

    public Double getPoundToDollar(Integer pound) {
        return getPoundToDollar(pound.doubleValue());
    }

    public static void main(String[] args) {
        Double dollar = 15000d;
        Integer year = 1794;
        year = 1921;
//        dollar = 75d;
        PoundToDollarConverter conv = new PoundToDollarConverter(year);
        CurrencyFormat currencyFormat = new CurrencyFormat(CoCIncomeAndSavings.Currency.OLD_GBP);
        System.out.println(currencyFormat.format(conv.getDollarToPound(0.05)));
//        System.out.println(conv.getPoundToDollar(dollar));
    }

    static {
        RATIO_MAP.put(1791, 4.55);
        RATIO_MAP.put(1792, 4.47);
        RATIO_MAP.put(1793, 4.51);
        RATIO_MAP.put(1794, 4.75);
        RATIO_MAP.put(1795, 4.53);
        RATIO_MAP.put(1796, 4.29);
        RATIO_MAP.put(1797, 4.44);
        RATIO_MAP.put(1798, 4.39);
        RATIO_MAP.put(1799, 4.13);
        RATIO_MAP.put(1800, 4.55);
        RATIO_MAP.put(1801, 4.38);
        RATIO_MAP.put(1802, 4.49);
        RATIO_MAP.put(1803, 4.54);
        RATIO_MAP.put(1804, 4.55);
        RATIO_MAP.put(1805, 4.35);
        RATIO_MAP.put(1806, 4.43);
        RATIO_MAP.put(1807, 4.42);
        RATIO_MAP.put(1808, 4.63);
        RATIO_MAP.put(1809, 4.57);
        RATIO_MAP.put(1810, 4.30);
        RATIO_MAP.put(1811, 3.82);
        RATIO_MAP.put(1812, 3.62);
        RATIO_MAP.put(1813, 3.75);
        RATIO_MAP.put(1814, 4.24);
        RATIO_MAP.put(1815, 4.90);
        RATIO_MAP.put(1816, 5.22);
        RATIO_MAP.put(1817, 4.60);
        RATIO_MAP.put(1818, 4.50);
        RATIO_MAP.put(1819, 4.51);
        RATIO_MAP.put(1820, 4.52);
        RATIO_MAP.put(1821, 4.82);
        RATIO_MAP.put(1822, 4.98);
        RATIO_MAP.put(1823, 4.80);
        RATIO_MAP.put(1824, 4.87);
        RATIO_MAP.put(1825, 4.83);
        RATIO_MAP.put(1826, 4.92);
        RATIO_MAP.put(1827, 4.94);
        RATIO_MAP.put(1828, 4.93);
        RATIO_MAP.put(1829, 4.86);
        RATIO_MAP.put(1830, 4.76);
        RATIO_MAP.put(1831, 4.86);
        RATIO_MAP.put(1832, 4.86);
        RATIO_MAP.put(1833, 4.79);
        RATIO_MAP.put(1834, 4.64);
        RATIO_MAP.put(1835, 4.85);
        RATIO_MAP.put(1836, 4.82);
        RATIO_MAP.put(1837, 5.10);
        RATIO_MAP.put(1838, 4.89);
        RATIO_MAP.put(1839, 4.99);
        RATIO_MAP.put(1840, 5.00);
        RATIO_MAP.put(1841, 4.99);
        RATIO_MAP.put(1842, 4.80);
        RATIO_MAP.put(1843, 4.79);
        RATIO_MAP.put(1844, 4.86);
        RATIO_MAP.put(1845, 4.87);
        RATIO_MAP.put(1846, 4.82);
        RATIO_MAP.put(1847, 4.79);
        RATIO_MAP.put(1848, 4.87);
        RATIO_MAP.put(1849, 4.81);
        RATIO_MAP.put(1850, 4.87);
        RATIO_MAP.put(1851, 4.91);
        RATIO_MAP.put(1852, 4.90);
        RATIO_MAP.put(1853, 4.89);
        RATIO_MAP.put(1854, 4.88);
        RATIO_MAP.put(1855, 4.89);
        RATIO_MAP.put(1856, 4.91);
        RATIO_MAP.put(1857, 4.89);
        RATIO_MAP.put(1858, 4.86);
        RATIO_MAP.put(1859, 4.90);
        RATIO_MAP.put(1860, 4.85);
        RATIO_MAP.put(1861, 4.77);
        RATIO_MAP.put(1862, 5.56);
        RATIO_MAP.put(1863, 7.08);
        RATIO_MAP.put(1864, 9.97);
        RATIO_MAP.put(1865, 7.69);
        RATIO_MAP.put(1866, 6.88);
        RATIO_MAP.put(1867, 6.75);
        RATIO_MAP.put(1868, 6.83);
        RATIO_MAP.put(1869, 6.48);
        RATIO_MAP.put(1870, 5.59);
        RATIO_MAP.put(1871, 5.46);
        RATIO_MAP.put(1872, 5.45);
        RATIO_MAP.put(1873, 5.55);
        RATIO_MAP.put(1874, 5.42);
        RATIO_MAP.put(1875, 5.59);
        RATIO_MAP.put(1876, 5.42);
        RATIO_MAP.put(1877, 5.08);
        RATIO_MAP.put(1878, 4.89);
        RATIO_MAP.put(1879, 4.85);
        RATIO_MAP.put(1880, 4.84);
        RATIO_MAP.put(1881, 4.83);
        RATIO_MAP.put(1882, 4.87);
        RATIO_MAP.put(1883, 4.85);
        RATIO_MAP.put(1884, 4.85);
        RATIO_MAP.put(1885, 4.86);
        RATIO_MAP.put(1886, 4.86);
        RATIO_MAP.put(1887, 4.85);
        RATIO_MAP.put(1888, 4.87);
        RATIO_MAP.put(1889, 4.87);
        RATIO_MAP.put(1890, 4.86);
        RATIO_MAP.put(1891, 4.86);
        RATIO_MAP.put(1892, 4.87);
        RATIO_MAP.put(1893, 4.86);
        RATIO_MAP.put(1894, 4.88);
        RATIO_MAP.put(1895, 4.89);
        RATIO_MAP.put(1896, 4.87);
        RATIO_MAP.put(1897, 4.86);
        RATIO_MAP.put(1898, 4.85);
        RATIO_MAP.put(1899, 4.86);
        RATIO_MAP.put(1900, 4.87);
        RATIO_MAP.put(1901, 4.87);
        RATIO_MAP.put(1902, 4.87);
        RATIO_MAP.put(1903, 4.86);
        RATIO_MAP.put(1904, 4.87);
        RATIO_MAP.put(1905, 4.87);
        RATIO_MAP.put(1906, 4.85);
        RATIO_MAP.put(1907, 4.86);
        RATIO_MAP.put(1908, 4.87);
        RATIO_MAP.put(1909, 4.87);
        RATIO_MAP.put(1910, 4.86);
        RATIO_MAP.put(1911, 4.86);
        RATIO_MAP.put(1912, 4.87);
        RATIO_MAP.put(1913, 4.87);
        RATIO_MAP.put(1914, 4.93);
        RATIO_MAP.put(1915, 4.76);
        RATIO_MAP.put(1916, 4.77);
        RATIO_MAP.put(1917, 4.76);
        RATIO_MAP.put(1918, 4.76);
        RATIO_MAP.put(1919, 4.43);
        RATIO_MAP.put(1920, 3.66);
        RATIO_MAP.put(1921, 3.85);
        RATIO_MAP.put(1922, 4.43);
        RATIO_MAP.put(1923, 4.58);
        RATIO_MAP.put(1924, 4.42);
        RATIO_MAP.put(1925, 4.83);
        RATIO_MAP.put(1926, 4.86);
        RATIO_MAP.put(1927, 4.86);
        RATIO_MAP.put(1928, 4.87);
        RATIO_MAP.put(1929, 4.86);
        RATIO_MAP.put(1930, 4.86);
        RATIO_MAP.put(1931, 4.54);
        RATIO_MAP.put(1932, 3.51);
        RATIO_MAP.put(1933, 4.24);
        RATIO_MAP.put(1934, 5.04);
        RATIO_MAP.put(1935, 4.90);
        RATIO_MAP.put(1936, 4.97);
        RATIO_MAP.put(1937, 4.94);
        RATIO_MAP.put(1938, 4.89);
        RATIO_MAP.put(1939, 4.43);
        RATIO_MAP.put(1940, 3.83);
        RATIO_MAP.put(1941, 4.03);
        RATIO_MAP.put(1942, 4.04);
        RATIO_MAP.put(1943, 4.04);
        RATIO_MAP.put(1944, 4.04);
        RATIO_MAP.put(1945, 4.03);
        RATIO_MAP.put(1946, 4.03);
        RATIO_MAP.put(1947, 4.03);
        RATIO_MAP.put(1948, 4.03);
        RATIO_MAP.put(1949, 3.69);
        RATIO_MAP.put(1950, 2.80);
        RATIO_MAP.put(1951, 2.80);
        RATIO_MAP.put(1952, 2.79);
        RATIO_MAP.put(1953, 2.81);
        RATIO_MAP.put(1954, 2.81);
        RATIO_MAP.put(1955, 2.79);
        RATIO_MAP.put(1956, 2.80);
        RATIO_MAP.put(1957, 2.79);
        RATIO_MAP.put(1958, 2.81);
        RATIO_MAP.put(1959, 2.81);
        RATIO_MAP.put(1960, 2.81);
        RATIO_MAP.put(1961, 2.80);
        RATIO_MAP.put(1962, 2.81);
        RATIO_MAP.put(1963, 2.80);
        RATIO_MAP.put(1964, 2.79);
        RATIO_MAP.put(1965, 2.80);
        RATIO_MAP.put(1966, 2.79);
        RATIO_MAP.put(1967, 2.75);
        RATIO_MAP.put(1968, 2.39);
        RATIO_MAP.put(1969, 2.39);
        RATIO_MAP.put(1970, 2.40);
        RATIO_MAP.put(1971, 2.44);
        RATIO_MAP.put(1972, 2.50);
        RATIO_MAP.put(1973, 2.45);
        RATIO_MAP.put(1974, 2.34);
        RATIO_MAP.put(1975, 2.22);
        RATIO_MAP.put(1976, 1.80);
        RATIO_MAP.put(1977, 1.75);
        RATIO_MAP.put(1978, 1.92);
        RATIO_MAP.put(1979, 2.12);
        RATIO_MAP.put(1980, 2.33);
        RATIO_MAP.put(1981, 2.02);
        RATIO_MAP.put(1982, 1.75);
        RATIO_MAP.put(1983, 1.52);
        RATIO_MAP.put(1984, 1.34);
        RATIO_MAP.put(1985, 1.30);
        RATIO_MAP.put(1986, 1.47);
        RATIO_MAP.put(1987, 1.64);
        RATIO_MAP.put(1988, 1.78);
        RATIO_MAP.put(1989, 1.64);
        RATIO_MAP.put(1990, 1.78);
        RATIO_MAP.put(1991, 1.77);
        RATIO_MAP.put(1992, 1.77);
        RATIO_MAP.put(1993, 1.50);
        RATIO_MAP.put(1994, 1.53);
        RATIO_MAP.put(1995, 1.58);
        RATIO_MAP.put(1996, 1.56);
        RATIO_MAP.put(1997, 1.64);
        RATIO_MAP.put(1998, 1.66);
        RATIO_MAP.put(1999, 1.62);
        RATIO_MAP.put(2000, 1.52);
        RATIO_MAP.put(2001, 1.44);
        RATIO_MAP.put(2002, 1.50);
        RATIO_MAP.put(2003, 1.64);
        RATIO_MAP.put(2004, 1.83);
        RATIO_MAP.put(2005, 1.82);
        RATIO_MAP.put(2006, 1.84);
        RATIO_MAP.put(2007, 2.00);
        RATIO_MAP.put(2008, 1.85);
        RATIO_MAP.put(2009, 1.57);
        RATIO_MAP.put(2010, 1.55);
        RATIO_MAP.put(2011, 1.60);
        RATIO_MAP.put(2012, 1.59);
        RATIO_MAP.put(2013, 1.56);
        RATIO_MAP.put(2014, 1.65);
        RATIO_MAP.put(2015, 1.53);
    }
}
