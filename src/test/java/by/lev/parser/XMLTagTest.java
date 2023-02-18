package by.lev.parser;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import parser.XMLTag;
import utilities.ListADT;
import utilities.MyArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class XMLTagTest {

    @Test(groups = "parser")
    public void testGetName() {
        XMLTag tag = new XMLTag("TagName");
        assertEquals(tag.getName(), "TagName");
    }

    @Test(groups = "parser")
    public void testSetName() {
        XMLTag tag = new XMLTag("TagName");
        tag.setName("NewTagName");
        assertEquals(tag.getName(), "NewTagName");
    }

    @Test(groups = "parser")
    public void testTagPropertyConstructor() {
        XMLTag.TagProperty property =
                new XMLTag.TagProperty("Name", "Value");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(property.getName(), "Name");
        softAssert.assertEquals(property.getValue(), "Value");
        softAssert.assertAll();
    }

    @Test(groups = "parser")
    public void testTagPropertySetName() {
        XMLTag.TagProperty property =
                new XMLTag.TagProperty("Name", "Value");

        property.setName("NewName");
        assertEquals(property.getName(), "NewName");
    }

    @Test(groups = "parser")
    public void testTagPropertySetValue() {
        XMLTag.TagProperty property = new XMLTag.TagProperty("Name", "Value");
        property.setValue("NewValue");
        assertEquals(property.getValue(), "NewValue");
    }

    @Test(groups = "parser")
    public void testGetEmptyMyArrayListAsProperties() {
        XMLTag tag = new XMLTag("Tag");
        ListADT<XMLTag.TagProperty> properties = tag.getProperties();
        assertTrue(properties.isEmpty());
    }

    @Test(groups = "parser")
    public void testSetAndGetProperties() {
        XMLTag.TagProperty FirstProperty =
                new XMLTag.TagProperty("Name", "Value");
        XMLTag.TagProperty SecondProperty =
                new XMLTag.TagProperty("Name", "Value");

        ListADT<XMLTag.TagProperty> propertyListADT = new MyArrayList<>();

        propertyListADT.add(FirstProperty);
        propertyListADT.add(SecondProperty);

        XMLTag tag = new XMLTag("Tag");

        tag.setProperties(propertyListADT);

        assertEquals(tag.getProperties(), propertyListADT);
    }

    @Test(groups = "parser")
    public void testGetEmptyMyArrayListAsNestedTags() {
        XMLTag tag = new XMLTag("Tag");
        ListADT<XMLTag> nestedTags = tag.getNestedTags();
        assertTrue(nestedTags.isEmpty());
    }

    @Test(groups = "parser")
    public void testSetNestedTags() {
        XMLTag tag = new XMLTag("Tag");
        ListADT<XMLTag> nestedTags = new MyArrayList<>();
        nestedTags.add(new XMLTag("One"));
        nestedTags.add(new XMLTag("Two"));
        nestedTags.add(new XMLTag("Three"));

        tag.setNestedTags(nestedTags);

        assertEquals(tag.getNestedTags(), nestedTags);
    }

    @Test(groups = "parser")
    public void testGetText(){
        XMLTag tag = new XMLTag("Tag");
        assertNull(tag.getText());
    }

    @Test(groups = "parser")
    public void testSetText(){
        XMLTag tag = new XMLTag("Tag");
        tag.setText("Text");
        assertEquals(tag.getText(), "Text");
    }
}
