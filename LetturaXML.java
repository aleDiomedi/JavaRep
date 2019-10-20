import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class LetturaXML {
	public static void main(String [] args) {
		
		JTextArea txtArea;
		ArrayList<Object> elenco = new ArrayList<>();
		
		try {
			
			File file = new File("C:\\Users\\NomeUtente\\Desktop\\file.XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(ArrayList.class); //ArrayList o qualunque tipo si tratti (ElencoBici per esempio)
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			elenco = (ArrayList<Object>) jaxbUnmarshaller.unmarshal(file);
			
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	}
}
