package ee.praktika.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

    public static void main( String[] args ){

        try {

            //create object mapper
            ObjectMapper mapper = new ObjectMapper();

            //read JSON file and map*convert to Java POJO:
            //data/sample-lite.json
            Student theStudent = mapper.readValue( new File( "data/sample-full.json" ), Student.class );

            //print first and last name
            System.out.println( "\nStudent first name: " + theStudent.getFirstName() );
            System.out.println( "\nStudent last name: " + theStudent.getLastName() );

            //print out adress - street and the city
            Address tempAddress = theStudent.getAddress();

            System.out.println( "\nStreet = " + tempAddress.getStreet() );
            System.out.println( "\nCity = " + tempAddress.getCity() );

            //print out the languages

            for( String tempLanguage : theStudent.getLanguages() ) {
                System.out.println( tempLanguage );
            }

        }
        catch( Exception exc ) {
            exc.printStackTrace();
        }
    }

}
