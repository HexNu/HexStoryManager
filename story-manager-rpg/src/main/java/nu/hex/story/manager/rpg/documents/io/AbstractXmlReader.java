package nu.hex.story.manager.rpg.documents.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import se.digitman.lightxml.DocumentToXmlNodeParser;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-nov-11
 *
 * @author hl
 * @param <T>
 */
public abstract class AbstractXmlReader<T> implements DocumentReader<T> {

    protected final XmlNode node;

    public AbstractXmlReader(XmlNode node) {
        this.node = node;
    }

    public AbstractXmlReader(String path) throws FileNotFoundException {
        this.node = new DocumentToXmlNodeParser(new FileInputStream(new File(path))).parse();
    }

//    protected Long getAttributeAsLong(String attributeName) throws NumberFormatException {
//        return Long.valueOf(node.getAttribute(attributeName));
//    }
//
//    protected Integer getAttributeAsInteger(String attributeName) throws NumberFormatException {
//        return Integer.valueOf(node.getAttribute(attributeName));
//    }
//
//    protected Double getAttributeAsDouble(String attributeName) throws NumberFormatException {
//        return Double.valueOf(node.getAttribute(attributeName));
//    }
//
//    protected String getAttribute(String attributeName) throws NumberFormatException {
//        return node.getAttribute(attributeName);
//    }
}
