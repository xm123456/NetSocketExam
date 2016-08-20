package Exam3.Exam3;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/*13.780,13.820,13.820,13.920,13.770,13.810,13.820,12987481,
179762261.140,114500,13.810,222800,13.800,74800,13.790,65500,13.780,25600,13.770,32950,13.820,26400,
13.830,23800,13.840,43600,13.850,83400,13.860,2016-08-19,15:05:03,00";*/
public class App2{

	private static final DocumentBuilderFactory lan3 = null;

	public static void main(String[] args) {
		try {
			
			
			//DOM
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("stock");
			root.setAttribute("cat", "it");
			
			Element lan1 = document.createElement("lan");
			lan1.setAttribute("id", "0");
			Element name1 = document.createElement("股票名字");
			name1.setTextContent("汉得信息");
			Element lan2 = document.createElement("lan");
			lan2.setAttribute("id", "1");
			Element ide1 = document.createElement("今日开盘价");
			ide1.setTextContent("13.780");
			lan1.appendChild(name1);
			lan1.appendChild(ide1);
			
			lan3.setAttribute("id", "2");
			Element ide2 = document.createElement("昨日开盘价");
			ide1.setTextContent("13.780");
			((Node) lan3).appendChild(name1);
			((Node) lan3).appendChild(ide1);
			
			lan2.setAttribute("id", "3");
			Element ide3 = document.createElement("当前价格");
			ide1.setTextContent("13.780");
			lan1.appendChild(name1);
			lan1.appendChild(ide1);
			
			lan2.setAttribute("id", "4");
			Element name2 = document.createElement("最高价格");
			name2.setTextContent("Swift");
			Element ide4 = document.createElement("ide");
			ide2.setTextContent("XCode");
			lan2.appendChild(name2);
			lan2.appendChild(ide2);
			
			lan2.setAttribute("id", "5");
			Element ide5 = document.createElement("最低价格");
			ide1.setTextContent("13.780");
			lan1.appendChild(name1);
			lan1.appendChild(ide1);
			
			Element lan3 = document.createElement("lan");
			lan3.setAttribute("id", "6");
			Element name3 = document.createElement("name");
			name3.setTextContent("C#");
			Element ide6 = document.createElement("ide");
			ide3.setTextContent("Visual Studio");
			lan3.appendChild(name3);
			lan3.appendChild(ide3);
			
			root.appendChild(lan1);
			root.appendChild(lan2);
			root.appendChild(lan3);
			document.appendChild(root);
			
			//-------------
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("encoding", "UTF-8");
			
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			System.out.println(writer.toString());
			
			transformer.transform(new DOMSource(document), new StreamResult(new File("newxml.xml")));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
