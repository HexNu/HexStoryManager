package nu.hex.story.manager.rpg.documents.gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created 2016-nov-10
 *
 * @author hl
 */
public class DocumentFileChooser extends JFileChooser {

    public DocumentFileChooser(File currentDirectory) {
        super(currentDirectory);
        super.setAcceptAllFileFilterUsed(false);
        super.addChoosableFileFilter(new FileNameExtensionFilter("Location text file", "srl"));
        super.addChoosableFileFilter(new FileNameExtensionFilter("Book text file", "srb"));
    }
}
