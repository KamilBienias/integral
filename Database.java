import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Database {

    @XmlElement(name = "integral-of-polynominal")
    private List<Integral> integrals;

    //a non-argument constructor is needed to create an xml file
    public Database(){

    }

    public Database(List<Integral> integrals) {
        this.integrals = integrals;
    }

    public List<Integral> getIntegrals() {
        return integrals;
    }


}
