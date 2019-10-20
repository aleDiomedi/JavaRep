import java.io.*;

public class LetturaFile {
	
	public static void main(String [] args) {

        // The name of the file to open.
        String percorsoFile = "C:\\Users\\NomeUtente\\Desktop\\file.txt";

        // This will reference one line at a time
        String line = null;

        try {
        	File file = new File(percorsoFile);
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //ad ogni ciclo la stringa line corrisponde ad una riga del file
            	//qui è dove viene processata quindi ogni riga, nell'esempio vengono semplicemente stampate a video
            	System.out.println(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file at'" + 
                percorsoFile+ "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file at '" 
                + percorsoFile + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

}
