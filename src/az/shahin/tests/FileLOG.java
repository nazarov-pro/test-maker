/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.tests;

import az.shahin.pojo.HistoryPojo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FileLOG {

    private final File file = new File("history.log");

    public List<HistoryPojo> getAllHistory() throws FileNotFoundException {
        List<HistoryPojo> allitem = new ArrayList<>();
        if (file.exists()) {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                HistoryPojo pojo = new HistoryPojo(Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine(), scan.nextLine(), scan.nextLine(), Integer.parseInt(scan.nextLine()));
                allitem.add(pojo);
            }
            scan.close();
        }
        return allitem;
    }

    public void writeLOG(List<HistoryPojo> allitem) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        List<HistoryPojo> allitem2 = getAllHistory();
        if(allitem2 ==null ||allitem2.isEmpty() ){
            
        }else{
            allitem.addAll(allitem2);
        }
        //System.out.println(allitem.get(0).getMy());
        PrintWriter writer = new PrintWriter(file);
        for (HistoryPojo pojo : allitem) {
           writer.println(pojo.getUserId());
           writer.println(pojo.getTestId());
           writer.println(pojo.getMy());
           writer.println(pojo.getCorrect());
           writer.println(pojo.getTime());
           writer.println(pojo.getScore());
        }
        writer.close();
    }
    
    public void removeMyHistory(int id) throws FileNotFoundException, IOException{
        List<HistoryPojo> pojolist =getAllHistory();
        Iterator<HistoryPojo> iter = pojolist.iterator();
        while(iter.hasNext()){
            HistoryPojo pojo = iter.next();
            if(pojo.getUserId() == id){
                iter.remove();
            }
        }
        removeFile();
        writeLOG(pojolist);
    }
    
    public void removeFile(){
        if(file.exists())
        file.delete();
    }
}
