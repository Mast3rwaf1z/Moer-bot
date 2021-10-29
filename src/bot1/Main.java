package bot1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import org.json.simple.*;
import org.python.util.PythonInterpreter;

public class Main {
    public static boolean ActivityMør = false;
    public static String currentTrack;
    public static int rainbowCounter = 0;
    public static int currentRole = 0;
    static JDA jda;
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws LoginException, InterruptedException, IOException, InvocationTargetException {
    	JSONObject admin = (JSONObject) log.readData("data2.json").get("admin");
        Commands.mør = Long.parseLong(admin.get("mør").toString());
        GUI newWindow = new GUI("Mør Bot");
        jda = JDABuilder.createDefault(admin.get("token").toString())
                .addEventListeners(new Commands()).setActivity(Activity.playing("-help"))
                .setStatus(OnlineStatus.ONLINE).build();
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.import.site", "false");
        
        Properties preProps = System.getProperties();
        PythonInterpreter.initialize(preProps, props, new String[0]);
        
        
        //MessageChannel channel = jda.getGuildById(692410386657574952L).getTextChannelById(798128372403929088L);
        //channel.addReactionById(798128372403929088L, "U+1F602").queue();
        //Message message = new MessageBuilder().append("lol").build();
        //channel.sendMessage(message).queue();
        
        
        /*while (true) {
            if(Commands.rainbow) {
                Guild rainbowGuild = jda.getGuildById(Commands.rainbowGuild);
                Member rainbowMember = rainbowGuild.getMemberById(Commands.rainbowMember);
            	//System.out.println(rainbowCounter);
                if(rainbowCounter == 250) {
                	 String[] farver = {"blue", "green", "gray", "yellow", "orange", "red", "white", "purple", "pink", "darkgreen"};
                	 currentRole++;
                	 if(currentRole >= farver.length) {
                		 currentRole = 0;
                	 }
                	 rainbowGuild.addRoleToMember(rainbowMember, rainbowGuild.getRolesByName(farver[currentRole], true).get(0)).queue();
                	 if(currentRole - 1 == -1) {
                		 rainbowGuild.removeRoleFromMember(rainbowMember, rainbowGuild.getRolesByName(farver[farver.length - 1], true).get(0)).queue();
                	 }
                	 else {
                    	 rainbowGuild.removeRoleFromMember(rainbowMember, rainbowGuild.getRolesByName(farver[currentRole - 1], true).get(0)).queue();
                	 }
                	 rainbowCounter = 0;
                }
                else {
                	rainbowCounter++;
                }
            }
            
            GUI.button3pressed = false;
            GUI.button2pressed = false;
            GUI.button1pressed = false;
            GUI.online = false;
            GUI.idle = false;
            GUI.DnD = false;
            Commands.nitten = false;
            Commands.trackTracker = false;
            Thread.sleep(10);
        }*/
    }
    public static void setActivity(String activity) {
    	jda.getPresence().setActivity(Activity.playing("-help | " + activity));
    }
    public static void setStatus(OnlineStatus status) {
    	jda.getPresence().setStatus(status);
    }
}