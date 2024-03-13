package javapro;

import java.io.File;
import java.util.Scanner;

public class xoathumuc {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("nhap duong dan file vao");
	String filePath = sc.nextLine();
	File file = new File(filePath); 
	if (file.exists())
	{
		System.out.println("file co ton tai");
		 if (file.delete()) {
             System.out.println("Đã xóa file thành công!");
         } else {
             System.out.println("Không thể xóa file.");
         }
	}
	else
	{

		System.out.println("file khong ton tai ");
	}
}
}
