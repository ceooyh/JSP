package step06;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTest1 {
	
	public static void main(String[] args) throws Exception{
		File file = new File("test.xml");
		DocumentBuilderFactory f = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder dBuilder = f.newDocumentBuilder();
		Document doc =  dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		
		String root = doc.getDocumentElement().getNodeName();
		System.out.println("root : " + root);
		
		NodeList list = doc.getElementsByTagName(root);//company를 선택을 했다.
		System.out.println(list.getLength());//길이를 나타내는데 하위노드의 갯수라고 보기에는 힘들다.
		
		Node temp = list.item(0);
		NodeList child = temp.getChildNodes();
		System.out.println(child.item(1).getNodeName());
		
		for(int i=0;i<child.getLength();i++) {
			Node n = child.item(i);
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(n.getNodeName());
				System.out.println(n.getAttributes().getNamedItem("no").getTextContent());
				if(n.getNodeName().equals("staff")) {
					NodeList sChild = n.getChildNodes();
					for(int j=0;j<sChild.getLength();j++) {
						Node t = sChild.item(j);
						if(t.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(t.getNodeName() + " : " + t.getTextContent());
						}
					}
				}
			}
		}
		
	}
}
