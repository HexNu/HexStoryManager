package nu.hex.story.manager.rpg.documents.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Created 2016-nov-10
 *
 * @author hl
 * @param <T>
 */
public abstract class AbstractReader<T> implements DocumentReader<T> {

    protected final List<String> lines;

    public AbstractReader(String path) throws IOException {
        this(Files.readAllLines(new File(path).toPath()));
    }

    public AbstractReader(List<String> lines) {
        this.lines = lines;
    }

    protected String getValue(String line) {
        return line.substring(line.indexOf(":") + 1).trim();
    }

    protected Long getValueAsLong(String line) {
        return Long.valueOf(getValue(line));
    }

    protected Double getValueAsDouble(String line) {
        return Double.valueOf(getValue(line));
    }

    protected Integer getValueAsInteger(String line) {
        return Integer.valueOf(getValue(line));
    }

    protected File getValueAsFile(String line) {
        return new File(getValue(line));
    }

    protected String getField(String line) {
        return line.substring(0, line.indexOf(":"));
    }

}
