package nu.hex.story.manager.core.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.hex.story.manager.core.domain.person.Person;
import nu.hex.story.manager.core.domain.person.impl.DefaultPerson;

/**
 * Created 2016-okt-19
 *
 * @author hl
 */
public class FamilyCSVReader implements FileReader<List<Person>> {

    private static final String DELIMITER = ";";
    private static final int SEX = 0,
            GIVEN_NAME = 1,
            FAMILY_NAME = 2,
            MOTHER = 3,
            FATHER = 4,
            BIRTH_YEAR = 5,
            DEATH_YEAR = 6,
            RESIDENCE = 7;
    private final Path path;
    private final Map<Integer, Person> personMap = new HashMap<>();
    private int index = 1;
    private Person.Sex sex;
    private String familyName, residence;
    private Person mother, father;
    private LocalDate birthDate, deathDate;
    private static final Map<String, Integer> NUMBER_OF_DAYS_MAP = new HashMap<>();

    static {
        NUMBER_OF_DAYS_MAP.put("01", 31);
        NUMBER_OF_DAYS_MAP.put("02", 28);
        NUMBER_OF_DAYS_MAP.put("03", 31);
        NUMBER_OF_DAYS_MAP.put("04", 30);
        NUMBER_OF_DAYS_MAP.put("05", 31);
        NUMBER_OF_DAYS_MAP.put("06", 30);
        NUMBER_OF_DAYS_MAP.put("07", 31);
        NUMBER_OF_DAYS_MAP.put("08", 31);
        NUMBER_OF_DAYS_MAP.put("09", 30);
        NUMBER_OF_DAYS_MAP.put("10", 31);
        NUMBER_OF_DAYS_MAP.put("11", 30);
        NUMBER_OF_DAYS_MAP.put("12", 31);
    }

    public FamilyCSVReader(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Person> read() {
        try {
            List<String> lines = Files.readAllLines(path);
            lines.stream().forEach((line) -> {
                createPerson(index, line);
                index++;
            });
        } catch (IOException ex) {
            Logger.getLogger(FamilyCSVReader.class.getName()).log(Level.SEVERE, "Could not read the file {0}", path.toString());
        }
        return new ArrayList<>(personMap.values());
    }

    private void createPerson(int index, String line) {
        Person person = new DefaultPerson();
        personMap.put(index, person);
        line = line.replaceAll(";", " ; ");
        String[] fields = line.split(DELIMITER);
        if (hasContent(fields[SEX])) {
            sex = fields[SEX].trim().equals("M") ? Person.Sex.MALE : Person.Sex.FEMALE;
        }
        if (hasContent(fields[FAMILY_NAME])) {
            familyName = getString(fields, FAMILY_NAME);
        }
        if (hasContent(fields[MOTHER])) {
            mother = getPerson(fields[MOTHER]);
        }
        if (hasContent(fields[FATHER])) {
            father = getPerson(fields[FATHER]);
        }
        if (hasContent(fields[BIRTH_YEAR])) {
            birthDate = createDate(fields[BIRTH_YEAR], true);
        }
        if (fields.length > DEATH_YEAR) {
            if (hasContent(fields[DEATH_YEAR])) {
                deathDate = createDate(fields[DEATH_YEAR], false);
            }
            if (fields.length > RESIDENCE) {
                if (hasContent(fields[RESIDENCE])) {
                    residence = getString(fields, RESIDENCE);
                }
            }
        }
        person.setSex(sex);
        person.setGivenName(getString(fields, GIVEN_NAME));
        person.setFamilyName(familyName);
        person.setDateOfBirth(birthDate);
        person.setDateOfDeath(deathDate);
        person.setMother(mother);
        person.setFather(father);
        person.setFamilyName(familyName);
        person.setResidence(residence);
    }

    private static String getString(String[] fields, int i) {
        return fields[i].trim();
    }

    private boolean hasContent(String string) {
        return string != null && !string.trim().isEmpty();
    }

    private LocalDate createDate(String field, boolean isBirthDate) {
        String month = getRandomDateValue(4, 9);
        String day = getRandomDateValue(1, NUMBER_OF_DAYS_MAP.get(month));
        LocalDate result = LocalDate.parse(field.trim() + "-" + month + "-" + day, DateTimeFormatter.ISO_DATE);
        if (birthDate != null) {
            if (isBirthDate && result.isBefore(birthDate)) {
                result = result.plusDays(result.compareTo(birthDate) + getRandomInt(1, 61));
            }
        }
        return result;
    }

    private String getRandomDateValue(int min, int max) {
        int number = getRandomInt(min, max);
        return number < 10 ? "0" + number : "" + number;
    }

    private int getRandomInt(int min, int max) {
        int number = min + (int) (Math.random() * ((max - min) + 1));
        return number;
    }

    private Person getPerson(String value) {
        return personMap.get(Integer.valueOf(value.trim()));
    }

    public static void main(String[] args) {
        String filePath = "/home/hl/Dokument/HexNu/StoryManager/sample-files/sample.csv";
        List<Person> persons = new FamilyCSVReader(filePath).read();
        persons.stream().forEach((person) -> {
            System.out.println(person.getGivenName() + " " + person.getFamilyName());
            if (person.getMother() != null) {
                System.out.println("Mother: " + person.getMother().getName());
            }
            if (person.getFather() != null) {
                System.out.println("Father: " + person.getFather().getName());
            }
        });
    }
}
