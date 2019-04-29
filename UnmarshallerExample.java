
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallerExample {

    //converts an xml file to objects
    public static Unmarshaller generateUnmarshaller() throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Database.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        return unmarshaller;
    }
}
