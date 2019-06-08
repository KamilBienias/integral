import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class UserInterface {

    private Database database;

    private UserInterface(Database database) {
        this.database = database;
    }

    private void menu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. Calculate the integral of the polynomial");
            System.out.println("2. Display all calculated integrals");
            System.out.println("0. Quit");

            System.out.print("Please, enter the command number: ");
            Scanner scanner = new Scanner(System.in);
            boolean isThereError = true;
            int commandNumber = -1;
            while (isThereError) {
                try {
                    commandNumber = scanner.nextInt();
                    if (commandNumber > 2 || commandNumber < 0) {// checks whether the integer number is from the menu, if not then throws IllegalArgumentException
                        throw new IllegalArgumentException();
                    }
                    isThereError = false;// when there is no exception, it leaves the try-catch block
                } catch (InputMismatchException letter) {
                    System.err.print("It is not an integer. Please, enter the command number: ");
                    scanner.nextLine();
                } catch (IllegalArgumentException outOfMenu) {
                    System.err.printf("Number %d is out of menu. ", commandNumber);
                    System.out.print("Please, enter the command number: ");
                    scanner.nextLine();
                }
            }

            switch (commandNumber) {
                case 1:
                    System.out.println("\nYou have chosen to calculate new integral");
                    calculateIntegral();
                    break;

                case 2:
                    System.out.println("\nYou have chosen to display calculated integrals:");
                    displayCalculatedIntegrals();
                    break;

                case 0:
                    System.out.println("\nYou have chosen to quit");
                    quit = true;
            }
        }
    }


    private void calculateIntegral() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThe program calculates definite integral from the polynomial in the given range. Then saves calculations to the XML file");
        System.out.println("\nEnter the ends of the interval on which the polynomial is specified (left <right)");
        double left = 0;
        double right = 0;
        boolean isIntervalError = true;
        while (isIntervalError) {
            try {
                System.out.print("Left end = ");
                left = scanner.nextDouble();
                System.out.print("Right end = ");
                right = scanner.nextDouble();
                if(left >= right) {
                    throw new IllegalArgumentException();
                }
                isIntervalError = false;
            }catch (IllegalArgumentException e){
                System.out.println("The left end must be less than the right one");
                scanner.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("It is in not a number");
                scanner.nextLine();
            }
        }

        System.out.println("\nEnter the number of sections to be divided (the more the more precisely): ");
        int division = 0;
        boolean isDivisionError = true;
        while (isDivisionError) {
            try {
                division = scanner.nextInt();//the section will be divided into so many parts
                if(division < 1){
                    throw new IllegalArgumentException();
                }
                isDivisionError = false;
            }catch (IllegalArgumentException e){
                System.out.println("The number of parts must be greater than 0, but less than " + Integer.MAX_VALUE);
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("It is not an integer or you put number of parts greater than" + Integer.MAX_VALUE);
                scanner.nextLine();
            }
        }
        double diameterOfDivision = (right - left) / division;//the length of each part is called the diameter of the division
        System.out.println("\nSo you will divide the interval into " + division + " parts,");
        System.out.println("each with a length " + diameterOfDivision);

        System.out.print("Give the polynomial degree: ");
        int degree = 0;
        boolean isDegreeError = true;
        while (isDegreeError) {
            try {
                degree = scanner.nextInt();
                if(degree < 0){
                    throw new IllegalArgumentException();
                }
                isDegreeError = false;
            }catch (IllegalArgumentException e){
                System.out.println("Degree must be at least 0");
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("It is not an integer");
                scanner.nextLine();
            }
        }

        System.out.print("W(x)= ");
        for (int i=degree ; i >= 1; i--)//writes the polynomial form of the given degree
        {
            System.out.print("a" + i + "*x^" + i + " + ");
        }
        System.out.println("a0");

        System.out.println("Enter polynomial coefficients (they can be with a comma):");
        double[] coefficients = new double[degree+1];
        for(int i=0; i<=degree; i++) {
            coefficients[i] = 0;
        }
        boolean isCoefficientsError = true;
        while (isCoefficientsError) {
            try {
                for (int j = degree; j >= 0; j--) {
                    System.out.print("a" + j + " = ");
                    coefficients[j] = scanner.nextDouble();
                }
                isCoefficientsError = false;
            }catch (InputMismatchException e){
                System.out.println("It is not a number");
                scanner.nextLine();
            }
        }
        double[] arguments = new double[division];//array of arguments that will be inserted into the function
        double[] values = new double[division];//array of function values ​​for split arguments
        double[] fieldOfRectangle = new double[division];//array of fields of small rectangles
        double sum = 0;//sum of function values ​​for split arguments

        //calculating values ​​for arguments and adding these values
        for (int i = 0; i < division; i++)
        {
            arguments[i] = left + i * diameterOfDivision;
            values[i]=0;//function value for the argument declared above
            for (int k=0; k<=degree; k++)
            {
                double temporaryValue;
                temporaryValue = coefficients[k] * Math.pow(arguments[i], k);
                values[i] = values[i] + temporaryValue;
            }
            fieldOfRectangle[i] = values[i] * diameterOfDivision;
            sum = sum + fieldOfRectangle[i];
        }

        System.out.println("\nDefinite integral on the interval (" + left + "; " + right + ")");
        System.out.print("from the function y = ");
        for(int i=degree; i>0; i--)
        {
            System.out.print(coefficients[i] + "*x^" + i + " + ");
        }
        System.out.println(coefficients[0]);
        System.out.println("is equal: " + sum);

        Integral integral = new Integral(left, right, division, degree, coefficients, sum);
        database.getIntegrals().add(integral);
        System.out.println("Integral was added to database. Saved informations:");
        System.out.println(integral);
    }

    private void displayCalculatedIntegrals() {
        try {
//            for (Integral  integral : database.getIntegrals()) {
//                System.out.println("\n" + integral);
            for(int i = 0; i < database.getIntegrals().size(); i++){
                System.out.println(i+1 + ".\n" + database.getIntegrals().get(i) + "\n");
            }
        }catch (Exception e){
            System.out.println("There are no calculated integrals yet");
        }finally {
            System.out.println("No more calculated integrals");
        }
    }

    public static void main(String[] args) throws JAXBException {

        Database database = new Database(new ArrayList<>());
        try {
            Unmarshaller unmarshaller = UnmarshallerExample.generateUnmarshaller();

            database = (Database) unmarshaller.unmarshal(new File("database.xml"));
        } catch (JAXBException e) {
            System.out.println("\nCreates new database");
        }

        UserInterface UI = new UserInterface(database);

        UI.menu();

        Marshaller marshaller = MarshallerExample.generateMarshaller();

        marshaller.marshal(database, new File("database.xml"));

    }
}
