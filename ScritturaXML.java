import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ScritturaXML {
	public static void main(String [] args) {
		ArrayList<Object> elenco = new ArrayList<>();
		try {
			File file = new File("C:\\Users\\NomeUtente\\Desktop\\file.XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(ArrayList.class); //ArrayList o qualunque tipo si tratti (ElencoBici per esempio)
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//mette a capo
			jaxbMarshaller.marshal(elenco, file);
			jaxbMarshaller.marshal(elenco, System.out);
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	}
}
