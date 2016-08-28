package assignment.kv.parser;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import assignment.kv.generated.Node;

public class XMLParser {
	
	public static Node parse(String xml) {
		
		try {
			JAXBContext ctx = JAXBContext.newInstance("assignment.kv.generated");
			Unmarshaller umarshaller = ctx.createUnmarshaller();
			//umarshaller.setValidating(true);
			// TODO Perform schema validation
			Node node = (Node)umarshaller.unmarshal(new FileInputStream(xml));
			return node;
		} catch (JAXBException|IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
