package IO.InputStream;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest1 {
    public static class ImageNameFilter implements FilenameFilter{

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".PNG");
        }
    }

    public static void main(String[] args) {
        System.out.println("C:\\file의 전체 파일 출력");
        File file = new File("C:\\file");
        System.out.println(file);
        String[] files = file.list();
        if (files != null) {
            for (String fileName : files) {
                File subFile = new File(file, fileName);
                if (subFile.isDirectory()) {
                    System.out.println("디렉토리 이름" + fileName);
                } else {
                    System.out.println("파일 이름:" + fileName + ", 파일크기:" + subFile.length() + "byte");
                }
            }
        }

        System.out.println("C:\\file의 이미지 파일만 출력");
        String[] imageFiles = file.list(new ImageNameFilter());
        if (imageFiles != null) {
            for(String fileName: imageFiles){
                File subFile = new File(file, fileName);
                System.out.println("파일 이름:"+fileName+",파일크기:"+subFile.length()+"byte, 파일경로:"+
                        subFile.getAbsolutePath());
            }
        }

        File makeFile = new File("C:\\file\\testFile.txt");
        boolean flag = false;
        try {
            flag = makeFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag){
            System.out.println("makeFile 이 생성됨");
        }

        File renameFile = new File("C:\\file\\testFile2.txt");
        flag = makeFile.renameTo(renameFile);
        if(flag){
            System.out.println("makeFile 의 이름이 변경됨.");
        }

        if(renameFile.delete()){
            System.out.println("renameFile 이 제거됨");
        }
    }
}
