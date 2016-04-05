import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Read_Write_file {
    String read_file,write_file;
    Read_Write_file(String read_file, String write_file){
        this.read_file = read_file;
        this.write_file = write_file;
    }

    public  StringBuffer readers() throws IOException {
        //声明缓存字符串，存储读出的数据
        StringBuffer sb= new StringBuffer();
        FileReader reader = new FileReader(read_file);
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        while((str = br.readLine()) != null) {
            if(!str.equals("8")){
                System.out.println(str);}
            else {
                //换行符要单独写
                sb.append(str).append("\n");
                System.out.println("buffer 长度：" + sb.length());
                break;}
        }
        br.close();
        reader.close();
        //返回StringBuffer 类型
        return sb;
    }
    public void writers(StringBuffer s) throws IOException {
        List<String> lis = new ArrayList<>();
        for(int i=0;i<10;i++){
            lis.add(i+"aa");
        }
        FileWriter writer = new FileWriter(write_file,true);
        BufferedWriter bw;
        bw = new BufferedWriter(writer);
        bw.write(s.toString());
        //write list
        bw.write(lis.toString());
        bw.close();
        writer.close();
    }
    public static void main(String[] args) throws IOException {
        Read_Write_file coop = new Read_Write_file("/Users/mac-li/Documents/Java_Student/read.txt","/Users/mac-li/Documents/Java_Student/write.txt");
        coop.writers(coop.readers());
    }
}
