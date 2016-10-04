//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.03 at 03:39:32 PM CEST 
//


package generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}DataUnits"/>
 *         &lt;element ref="{}Attachments" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="schemaVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="batchReference" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="previousReference" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="receiverReference" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="timeStamp" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="formTasksInBatch" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="formsInBatch" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataUnits",
    "attachments"
})
@XmlRootElement(name = "DataBatch")
public class DataBatch {

    @XmlElement(name = "DataUnits", required = true)
    protected DataUnits dataUnits;
    @XmlElement(name = "Attachments")
    protected Attachments attachments;
    @XmlAttribute(name = "schemaVersion", required = true)
    protected BigDecimal schemaVersion;
    @XmlAttribute(name = "batchReference", required = true)
    protected long batchReference;
    @XmlAttribute(name = "previousReference", required = true)
    protected long previousReference;
    @XmlAttribute(name = "receiverReference", required = true)
    protected String receiverReference;
    @XmlAttribute(name = "timeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlAttribute(name = "formTasksInBatch", required = true)
    protected long formTasksInBatch;
    @XmlAttribute(name = "formsInBatch")
    protected Long formsInBatch;

    /**
     * Gets the value of the dataUnits property.
     * 
     * @return
     *     possible object is
     *     {@link DataUnits }
     *     
     */
    public DataUnits getDataUnits() {
        return dataUnits;
    }

    /**
     * Sets the value of the dataUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataUnits }
     *     
     */
    public void setDataUnits(DataUnits value) {
        this.dataUnits = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * @return
     *     possible object is
     *     {@link Attachments }
     *     
     */
    public Attachments getAttachments() {
        return attachments;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attachments }
     *     
     */
    public void setAttachments(Attachments value) {
        this.attachments = value;
    }

    /**
     * Gets the value of the schemaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the value of the schemaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSchemaVersion(BigDecimal value) {
        this.schemaVersion = value;
    }

    /**
     * Gets the value of the batchReference property.
     * 
     */
    public long getBatchReference() {
        return batchReference;
    }

    /**
     * Sets the value of the batchReference property.
     * 
     */
    public void setBatchReference(long value) {
        this.batchReference = value;
    }

    /**
     * Gets the value of the previousReference property.
     * 
     */
    public long getPreviousReference() {
        return previousReference;
    }

    /**
     * Sets the value of the previousReference property.
     * 
     */
    public void setPreviousReference(long value) {
        this.previousReference = value;
    }

    /**
     * Gets the value of the receiverReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverReference() {
        return receiverReference;
    }

    /**
     * Sets the value of the receiverReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverReference(String value) {
        this.receiverReference = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the formTasksInBatch property.
     * 
     */
    public long getFormTasksInBatch() {
        return formTasksInBatch;
    }

    /**
     * Sets the value of the formTasksInBatch property.
     * 
     */
    public void setFormTasksInBatch(long value) {
        this.formTasksInBatch = value;
    }

    /**
     * Gets the value of the formsInBatch property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFormsInBatch() {
        return formsInBatch;
    }

    /**
     * Sets the value of the formsInBatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFormsInBatch(Long value) {
        this.formsInBatch = value;
    }

}