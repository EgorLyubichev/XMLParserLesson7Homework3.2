package by.lev;

import org.testng.annotations.Test;
import parser.XMLParser;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class XMLParserTest {

    @Test
    public void testTrueSimpleXmlFile() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/true_simple_file.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test
    public void testSelfClosedTag() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/file_with_selfclosed_tag.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test
    public void testTagWithAtribute() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/tag_with_atribute.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test
    public void testCommentLines() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/file_with_comment_lines.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test
    public void testDifficultFile() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/difficult_file.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test
    public void testWithoutDeclarationFile() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/without_declaration.xml");
        parser.parseDocument();
        assertFalse(parser.getErrors().isEmpty());
    }

    /*
    * Для дальнейшего тестирования требуется исправление обнаруженных ошибок.
    * При данной работе приложения невозможно корректно проверить некоторые
    * места в коде.
    * */

}
