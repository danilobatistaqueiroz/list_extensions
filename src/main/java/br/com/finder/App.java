package br.com.finder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

public class App 
{
    public static void main( String[] args )
    {
    	List<File> files = new ArrayList<File>();
    	List<String> extensions = new ArrayList<String>();
		listf("C:\\Users\\danilo.queiroz\\Documents\\listaextensoes", files);
		for(File file : files) {
			String ext1 = FilenameUtils.getExtension(file.getName());
			if(extensions.contains(ext1)==false) {
				extensions.add(ext1);
			}
		}
		System.out.println(extensions.toString());
    }
    
    public static void listf(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }
}
