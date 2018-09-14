package Apollo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Address")
public class Address {

	 AddressSubElement Address;

     public AddressSubElement getAddress() {
             return Address;
     }
     
     @XmlElement(name="Address",namespace="http://schemas.datacontract.org/2004/07/ServiceObjects")
	public void setAddress(AddressSubElement address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Address [Address=" + Address + "]";
	}

}
