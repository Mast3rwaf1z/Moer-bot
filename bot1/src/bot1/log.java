package bot1;

import java.io.*;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * log
 */
public class log {
    static public String readFile() throws IOException {
        FileReader input = new FileReader("mørlog.txt");
        System.out.println("data read");
        BufferedReader reader = new BufferedReader(input);

        String c = reader.readLine();
        reader.close();
        return (c);
    }

    static public void writeFile(String number) throws IOException {
        FileWriter output = new FileWriter("mørlog.txt");
        BufferedWriter writer = new BufferedWriter(output);
        System.out.println("data written");
        writer.write(number);
        writer.close();
    }
    public static JSONObject readData(String file) 
	{
    	JSONParser jsonParser = new JSONParser();
    	try(FileReader reader = new FileReader(file))
    	{
    		JSONObject data = (JSONObject) jsonParser.parse(reader);
    		return data;
    	}
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    		System.exit(0);
    		return null;
    	} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
			System.exit(0);
			return null;
		}
    	catch (ParseException e) 
    	{
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
    @SuppressWarnings("unchecked")
	public static void writeData(String index, JSONObject data, String File)
    {
		JSONObject current = readData(File);
    	try(FileWriter file = new FileWriter(File))
    	{
    		current.put(index, data);
    		file.write(current.toJSONString());
    		file.flush();
    	} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }
    //fuck det her, generer en ny entry i leaderboard filen hver gang der er en ny person der får lorten.
    @SuppressWarnings("unchecked")
	public static void generateUserData(Guild guild) {
    	List<Member> members = guild.getMembers();
    	for(int i = 0; i < members.size(); i++) {
        	JSONObject data = new JSONObject();
    		String name = members.get(i).getEffectiveName();
    		data.put(name, 0);
    		writeData(name,data, "leaderboard.json");
    	}
    	
    }
    
    public static JSONObject GetUserData(MessageChannel channel) {
    	return null;
    }
    
    public static void setUserData(String datatype, JSONObject data) {
    	
    }
}

