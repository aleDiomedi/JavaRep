import java.io.*;
public class ScritturaFile {
	public static void main(String [] args) {

        // The name of the file to open.
        String percorsoFile = "C:\\Users\\NomeUtente\\Desktop\\file.txt";

        try {
        	File file = new File(percorsoFile);
            FileWriter fileWriter =  new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //attraverso il metodo .write si può scrivere quel che si vuole sul file.txt
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            //comando di nuova riga
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file at '"
                + percorsoFile + "'");
        }
    }
}
