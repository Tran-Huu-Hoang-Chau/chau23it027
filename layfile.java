package javapro;

import java.util.Scanner;
import java.io.File;

public class layfile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao duong dan file");
		String filePath = sc.nextLine();
        File file = new File(filePath);
		if (file.exists()) {
            System.out.println("file  co ton tai");
            long filesize = file.length();
            System.out.println("kich thuoc cua file la " + filesize + "byte");
        } else {
            System.out.println("file khong ton tai ");
        }
		
		
	}

}
