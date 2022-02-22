package bot1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import org.json.simple.*;
import java.sql.*;
import org.python.util.PythonInterpreter;

public class Main {
    public static boolean ActivityMør = false;
    public static String currentTrack;
    public static int rainbowCounter = 0;
    public static int currentRole = 0;
    static JDA jda;
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws LoginException, InterruptedException, IOException, InvocationTargetException {
    	/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://193.176.87.172:41896", "mast3r", "dt1ikkuy");
			Statement stmt = con.createStatement();
			stmt.execute("use morbot;");
			stmt.execute("insert into userdata values('214752462769356802', 57);");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    	exec();
    }
    
    public static void setActivity(String activity) {
    	jda.getPresence().setActivity(Activity.playing(Commands.prefix +"help | " + activity));
    }
    
    public static void setStatus(OnlineStatus status) {
    	jda.getPresence().setStatus(status);
    }
    
    public static void exec() throws LoginException {
    	JSONObject admin = (JSONObject) log.readData("data2.json").get("admin");
        Commands.mør = Long.parseLong(admin.get("moer").toString());
        //GUI newWindow = new GUI("mør Bot");
        jda = JDABuilder.createDefault(admin.get("token").toString())
                .addEventListeners(new Commands()).setActivity(Activity.playing(Commands.prefix + "help"))
                .setStatus(OnlineStatus.ONLINE).build();
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.import.site", "false");
        
        Properties preProps = System.getProperties();
        PythonInterpreter.initialize(preProps, props, new String[0]);
        System.out.println(jda.retrieveUserById("235088799074484224").complete().getName());
    }
}