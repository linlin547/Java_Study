package Buffered.Reader.Writer;

import java.io.*;

/**
 * Created by mac-li on 16/4/20.
 */
public class BufferReaderWriter {
    private String filepath;

    public BufferReaderWriter(String filepath) {
        this.filepath = filepath;
    }

    public void readData() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filepath));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("开始读取");
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    public void writeData(String String) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
//            bufferedWriter = new BufferedWriter(new FileWriter(filepath));//覆盖方式
            bufferedWriter = new BufferedWriter(new FileWriter(filepath, true));//追加
            bufferedWriter.write(String);
            bufferedWriter.newLine();
            bufferedWriter.flush();//强制刷新缓冲区，避免数据输入不完整
            System.out.println("写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {//没弄明白为什么不等于null,难道是有对象导致为null？
                bufferedWriter.close();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/mac-li/Documents/Java_project/Java_Study/src/Buffered/Reader/Writer/text.txt";
        BufferReaderWriter bufferReaderWriter = new BufferReaderWriter(path);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(String.valueOf(i)).append("\n");
        }
        bufferReaderWriter.writeData(stringBuilder.toString());
        bufferReaderWriter.readData();
    }

}
