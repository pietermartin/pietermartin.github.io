package org.umlg.sqlg.doc;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;
import org.asciidoctor.Placement;

import java.io.File;

import static org.asciidoctor.Asciidoctor.Factory.create;

/**
 * Date: 2016/12/14
 * Time: 1:43 PM
 */
public class AsciiDoctor {

    public static void main(String[] args) {
        new AsciiDoctor().createDocs();
    }

    public void createDocs() {
        Asciidoctor asciidoctor = create();
        try {
            File file = new File("src/main/asciidoc/sqlg.adoc");
            File html = new File("src/main/html/sqlg.html");
            Attributes attributes = new Attributes();
            attributes.setBackend("html5");
            attributes.setStyleSheetName("asciidoctor-default.css");
            //the left toc don't work with these css
//            attributes.setStyleSheetName("volnitsky.css");
//            attributes.setStylesDir("./volnitsky");
//            attributes.setStyleSheetName("flask.css");
//            attributes.setStylesDir("./flask");
            attributes.setTableOfContents2(Placement.LEFT);

            Options options = new Options();
            options.setAttributes(attributes);
            options.setToFile(html.getPath());

            asciidoctor.convertFile(
                    file,
                    options
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
