package by.lev.parser;

import org.testng.annotations.Test;
import parser.XMLParser;
import parser.XMLTag;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class XMLParserTest {

    @Test(
            expectedExceptions = FileNotFoundException.class,
            groups = "parser")
    public void testXMLParserWithoutTrueFileRoot() {
       new XMLParser("");
    }

    @Test(groups = "parser")
    public void testTrueSimpleXmlFile() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/true_simple_file.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testSelfClosedTag() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/file_with_selfclosed_tag.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testTagWithAtribute() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/tag_with_atribute.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testCommentLines() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/file_with_comment_lines.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testDifficultFile() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/difficult_file.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testWithoutDeclarationFile() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/without_declaration.xml");
        parser.parseDocument();
        assertFalse(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testGetNameFromRoot() {
        XMLParser parser = new XMLParser("src/test/xmlfiles/true_simple_file.xml");
        parser.parseDocument();
        String xmlTageName;

        try {
            Field field = parser.getClass().getDeclaredField("root");
            field.setAccessible(true);
            XMLTag xmlTag = (XMLTag) field.get(parser);

            xmlTageName = xmlTag.getName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        assertEquals(xmlTageName, "bookstore");
    }

    /*
     * Для дальнейшего тестирования требуется исправление обнаруженных ошибок.
     * При данной работе приложения невозможно корректно проверить некоторые
     * места в коде.
     * */

}
