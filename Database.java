import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Database {

    private double leftEnd;
    private double rigthEnd;
    private int division;
    private double[] coefficients;
    private double integral;

    public Database(){

    }

    public Database(double leftEnd, double rigthEnd, int division, double[] coefficients, double integral) {
        this.leftEnd = leftEnd;
        this.rigthEnd = rigthEnd;
        this.division = division;
        this.coefficients = coefficients;
        this.integral = integral;


    }
}
