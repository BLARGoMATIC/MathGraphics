package mathGraphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphicReader {

	public static void main(String[] args) {
        String  fileName  = "picture_1.txt";
        boolean isKeyword = true;       // Current word is a command
        // Geometric shapes we can draw, assume only one is true
        boolean line     = false;
        boolean triangle = false;
        int[]   parameters = {0, 0, 0, 0, 0, 0, 0, 0};
        int     curParam  = 0;
        int     i = 0;
        // With the following resources// Ctor takes a Reader// Anonymous Reader
        try (BufferedReader br = new BufferedReader(new FileReader( fileName ) ); ) {
            
        	StringBuilder sb = new StringBuilder();

            // Read and process our graphics file, one line at a time
            //
        	
            while( br.ready() ) {
                isKeyword = true;  // First word is a keyword or command
                curParam  = 0;

                for( String token  // Each word on a line goes in ‘token’
                     :             // Enhanced for loop indicator
                     br.readLine() // Read a line, returning a String
                     .             // Apply a String method
                     split("[ ]+")
                ) {
                    if( isKeyword ) {
                        switch( token ) {
                            case( "line" ): 
                                line = true;
                                break;
                            case( "triangle" ):
                                triangle = true;
                                break;
                            default:
                            	System.out.println("found invalid keyword: " + token);
                        }
                        isKeyword = false;
                    }
                    else {
                        parameters[curParam] = Integer.parseInt( token );
                        curParam++;
                    }
                } // END  for tokens in this line

                // Draw based on the boolean status of our keyword
                //
                curParam--;  // Reset as no parameter was read after last ++
                if( line ) {
                    // Draw line code here
                    System.out.print( "Calling DrawPatterns addLine( " );
                    for( i = 0; i < curParam; i++ ) {
                        System.out.print( parameters[i] + ", " );
                    }
                    System.out.println( parameters[curParam] + " )" );

                    // Reset state information
                    line = false;
                }
                else if( triangle ) {
                    // Draw line code here
                    System.out.print( "Calling DrawPatterns addTriangle( " );
                    for( i = 0; i < curParam; i++ ) {
                        System.out.print( parameters[i] + ", " );
                    }
                    System.out.println( parameters[curParam] + " )" );

                    // Reset state information
                    triangle = false;                	
                }

            } // END  while file ready

        }
        catch( FileNotFoundException e ) { System.out.println(e); }
        catch( IOException e )           { System.out.println(e); }
        catch( Exception e )             { System.out.println(e); }

    } // END  main()
} // END  class GraphicReader