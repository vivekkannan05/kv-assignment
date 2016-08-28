//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.25 at 10:56:03 PM CEST 
//


package assignment.kv.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element ref="{}mappinglist"/>
 *           &lt;element ref="{}childrennodes"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element ref="{}alternative" maxOccurs="unbounded"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element ref="{}xmlFile" maxOccurs="unbounded"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mappinglist",
    "childrennodes",
    "alternative",
    "xmlFile"
})
@XmlRootElement(name = "node")
public class Node {

    protected Mappinglist mappinglist;
    protected Childrennodes childrennodes;
    protected List<Alternative> alternative;
    protected List<XmlFile> xmlFile;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the mappinglist property.
     * 
     * @return
     *     possible object is
     *     {@link Mappinglist }
     *     
     */
    public Mappinglist getMappinglist() {
        return mappinglist;
    }

    /**
     * Sets the value of the mappinglist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mappinglist }
     *     
     */
    public void setMappinglist(Mappinglist value) {
        this.mappinglist = value;
    }

    /**
     * Gets the value of the childrennodes property.
     * 
     * @return
     *     possible object is
     *     {@link Childrennodes }
     *     
     */
    public Childrennodes getChildrennodes() {
        if(null==childrennodes){
        	childrennodes = new Childrennodes();
        }
    	return childrennodes;
    }

    /**
     * Sets the value of the childrennodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Childrennodes }
     *     
     */
    public void setChildrennodes(Childrennodes value) {
        this.childrennodes = value;
    }

    /**
     * Gets the value of the alternative property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternative property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternative().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Alternative }
     * 
     * 
     */
    public List<Alternative> getAlternative() {
        if (alternative == null) {
            alternative = new ArrayList<Alternative>();
        }
        return this.alternative;
    }

    /**
     * Gets the value of the xmlFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xmlFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXmlFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlFile }
     * 
     * 
     */
    public List<XmlFile> getXmlFile() {
        if (null == xmlFile) {
            xmlFile = new ArrayList<XmlFile>();
        }
        return this.xmlFile;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
