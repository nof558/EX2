package EX1;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Runtime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class help us to read and pull out from our input(json file) the user login
 * details( username and password fields only) by a parser and output them to txt file.
 * @author nof55
 */
public class UsersInfo
{
    static final int EXEC_NUM = 10;
    /**
     * this function is only to help for calculate the runtime of the function in the main.
     */
    public static void getData()
    {
        try
        {
            JSONParser parser=new JSONParser();     // using for String analyzing from the JSON input
            JSONObject outPut=new JSONObject();     //using to save the output data 
            JSONArray arrJ=new JSONArray();         //using for saving the data from the JSON into arr
            JSONArray tokenizer = (JSONArray) parser.parse(new FileReader("input.json"));     //tokenizer is used to read from json file and cast to json array

            for (int i = 0; i < tokenizer.size(); i++)   
            {
                JSONObject info = (JSONObject) tokenizer.get(i);    //take one part of data from the JSON input 
                arrJ.add(info.get("username").toString()+":"+info.get("password").toString());      //add to arr the username and password fields only.
            }
            
            outPut.put("users", arrJ);          //
            
            try (FileWriter file = new FileWriter("output.txt"))
            {
                file.write(outPut.toJSONString());          //print to the output file
            }
            System.out.println("\n JSON Object: " + outPut);
        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
    }
   //the main is for testing results runtime for the function from EX1 and write them
    public static void main(String[] args)
    {
        long arr[]= new long[EXEC_NUM];
        long startTime,stopTime,runTime;
        for (int i = 0; i < EXEC_NUM; i++)
        {
           startTime=System.currentTimeMillis();
           getData();
           stopTime=System.currentTimeMillis();
           runTime=stopTime-startTime;
           arr[i] = runTime;
          
            
       
        }
        System.out.println(Arrays.toString(arr)); 
        Runtime runMem=Runtime.getRuntime();
        runMem.gc();
        long memory=runMem.totalMemory()-runMem.freeMemory();
        System.out.println("memory used by bytes is: "+ memory);
       
    }
}

