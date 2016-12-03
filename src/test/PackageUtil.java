package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PackageUtil {
/*
	public static List<String> getClassName(String packageName) { 
        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\"); 
        List<String> fileNames = getClassName(filePath, null); 
        return fileNames; 
    }*/ 
	
	public static List<String> getClassName(String packageName) {
		String filePath = "C:\\软件\\新建文件夹 (2)\\mvc\\src\\" + packageName.replace(".", "\\");//遍历所有类
		List<String> fileNames = getClassName(filePath, null);
		
		//List<String> classNames = getClassName(packageName); 
		return fileNames;
	}

	
	private static List<String> getClassName(String filePath, List<String> className) {
		List<String> myClassName = new ArrayList<String>();
		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				myClassName.addAll(getClassName(childFile.getPath(), myClassName));
			} else {
				String childFilePath = childFile.getPath();
				childFilePath = childFilePath.substring(childFilePath.indexOf("\\src") + 5, childFilePath.lastIndexOf("."));
				childFilePath = childFilePath.replace("\\", ".");
				myClassName.add(childFilePath);
			}
		}

		return myClassName;
	}
	
}