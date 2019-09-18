
package CollectionExamQuestionFileWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamQuestions {
    public static void saveQuestionsToFile(ArrayList<String> questions, String filePath){
        PrintWriter fileWriter = null;
        try{
            fileWriter = new PrintWriter(filePath);
            for(String question : questions){
                fileWriter.println(question);
            }
            
            System.out.println("\nQuestions successfully saved to file at " + 
                    filePath);
                       
        } catch(FileNotFoundException ex){
            System.out.println("File not found");
        } finally{
            if(fileWriter != null) fileWriter.close();
        }    
    }
    
    public static ArrayList<String> readQuestionsFromFile(String filePath){
        try{
            FileReader rdr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(rdr);
            ArrayList<String> readQuestions = new ArrayList<>();
            
            String question = null;
            while((question = reader.readLine()) != null){
                readQuestions.add(question);    
            }
          
            rdr.close();
            reader.close();
            
            return (readQuestions);
            
        } catch(FileNotFoundException ex){
            System.out.println("File not found");
            return null;
        } catch(IOException ex2) {
            System.out.println("Error occured while reading from file");
            return null;
        } 
        
    }
    
    public static void main(String[] args){
        System.out.println("ADEYEMI ADEDOYIN SIMEON -- 209188\n");
        String path = "C:\\Users\\SIMEON_DEE\\Documents\\ExamQuestionsInputFile.txt";
        ArrayList<String> examQuestions = new ArrayList<>();
        ArrayList<String> readQuestions = new ArrayList<>();
            
        Scanner input = new Scanner(System.in);
            
        System.out.println("How many Exam questions do you have?");
        int n = input.nextInt();
          
        System.out.println("\nEnter your " + n + " questions");
        for(int i = 1; i <= n; i++){
            examQuestions.add(input.nextLine());
        }
            
        //Writing questions to file
        saveQuestionsToFile(examQuestions,path);
        
        //Reading questions from file    
        readQuestions = readQuestionsFromFile(path);
            
        System.out.println("\nQuestions Read From File");
        System.out.println("************************\n");
        for(int counter = 0; counter < readQuestions.size(); counter++){
            System.out.println((counter + 1) + ".) " + 
                    readQuestions.get(counter));
            System.out.println("--------------------------------------------");
        }
        
    }
    
}
