package javapro;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StudentXMLWriter {
	  public static void main(String[] args) {
	        // Tạo danh sách sinh viên
	        List<Student> studentList = new ArrayList<>();
	        studentList.add(new Student("John Doe", 20, 3.5));
	        studentList.add(new Student("Jane Smith", 22, 3.8));
	        studentList.add(new Student("David Johnson", 21, 3.2));

	        // Tạo document XML
	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder;
	        try {
	            docBuilder = docFactory.newDocumentBuilder();
	            Document doc = docBuilder.newDocument();

	            // Tạo phần tử gốc <students>
	            Element rootElement = doc.createElement("students");
	            doc.appendChild(rootElement);

	            // Tạo phần tử <student> cho mỗi sinh viên trong danh sách
	            for (Student student : studentList) {
	                Element studentElement = doc.createElement("student");
	                rootElement.appendChild(studentElement);

	                // Tạo các phần tử con cho sinh viên
	                Element nameElement = doc.createElement("name");
	                nameElement.appendChild(doc.createTextNode(student.getName()));
	                studentElement.appendChild(nameElement);

	                Element ageElement = doc.createElement("age");
	                ageElement.appendChild(doc.createTextNode(String.valueOf(student.getAge())));
	                studentElement.appendChild(ageElement);

	                Element gpaElement = doc.createElement("gpa");
	                gpaElement.appendChild(doc.createTextNode(String.valueOf(student.getGpa())));
	                studentElement.appendChild(gpaElement);
	            }

	            // Ghi dữ liệu vào file XML
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File("students.xml"));
	            transformer.transform(source, result);

	            System.out.println("File XML đã được tạo thành công!");

	        } catch (ParserConfigurationException | TransformerException e) {
	            e.printStackTrace();
	        }
	    }
	}

	class Student {
	    private String name;
	    private int age;
	    private double gpa;

	    public Student(String name, int age, double gpa) {
	        this.name = name;
	        this.age = age;
	        this.gpa = gpa;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public double getGpa() {
	        return gpa;
	    }
}
