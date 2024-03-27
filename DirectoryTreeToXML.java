package javapro;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DirectoryTreeToXML {
	 public static void main(String[] args) {
	        String directoryPath = "path/to/directory"; // Thay đổi đường dẫn thư mục tại đây

	        File directory = new File(directoryPath);
	        if (directory.exists() && directory.isDirectory()) {
	            StringBuilder xmlBuilder = new StringBuilder();
	            xmlBuilder.append("<DirectoryTree>\n");
	            generateXML(directory, xmlBuilder);
	            xmlBuilder.append("</DirectoryTree>");

	            String xmlString = xmlBuilder.toString();
	            System.out.println(xmlString); // In ra XML

	            // Lưu XML vào file
	            try {
	                FileWriter fileWriter = new FileWriter("directory_tree.xml");
	                fileWriter.write(xmlString);
	                fileWriter.close();
	                System.out.println("XML file saved successfully.");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("Invalid directory path.");
	        }
	    }

	    private static void generateXML(File directory, StringBuilder xmlBuilder) {
	        xmlBuilder.append("<Directory name=\"").append(directory.getName()).append("\">\n");
	        File[] files = directory.listFiles();
	        if (files != null) {
	            for (File file : files) {
	                if (file.isDirectory()) {
	                    generateXML(file, xmlBuilder);
	                } else {
	                    xmlBuilder.append("<File>").append(file.getName()).append("</File>\n");
	                }
	            }
	        }
	        xmlBuilder.append("</Directory>\n");
	    }

}
