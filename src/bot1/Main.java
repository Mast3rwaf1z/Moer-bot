package bot1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import org.json.simple.*;

public class Main {
    public static boolean ActivityMør = false;
    public static String currentTrack;
    public static int rainbowCounter = 0;
    public static int currentRole = 0;

    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws LoginException, InterruptedException, IOException, InvocationTargetException {
    	JSONObject admin = (JSONObject) log.readData("data2.json").get("admin");
    	System.out.println(admin);
        Commands.mør = Long.parseLong(admin.get("mør").toString());
        GUI newWindow = new GUI("Mør Bot");
        final JDA jda = JDABuilder.createDefault(admin.get("token").toString())
                .addEventListeners(new Commands()).setActivity(Activity.playing("-hjælp"))
                .setStatus(OnlineStatus.ONLINE).build();
        
        //MessageChannel channel = jda.getGuildById(692410386657574952L).getTextChannelById(798128372403929088L);
        //channel.addReactionById(798128372403929088L, "U+1F602").queue();
        //Message message = new MessageBuilder().append("lol").build();
        //channel.sendMessage(message).queue();
        
        
        while (true) {
            if (GUI.button1pressed) {
                jda.getPresence().setActivity(Activity.playing("-hjælp | " + newWindow.activity));
                System.out.println(newWindow.activity);
                ActivityMør = false;
            }
            if (Commands.nitten) {
                jda.getPresence().setActivity(Activity.playing("-hjælp | " + "Nitten kommer i sovsen"));
            }
            if (GUI.button2pressed) {
                jda.getPresence().setActivity(Activity.playing("-hjælp | " + Commands.mør + " x Mør"));
                ActivityMør = true;

            }
            if (GUI.button3pressed) {
            	admin.put("mør", 0);
            	log.writeData("admin", admin, "data2.json");
                //log.writeFile(String.valueOf(0));
                Commands.mør = 0;
                GUI.button2pressed = true;
            }
            if (GUI.online) {
                jda.getPresence().setStatus(OnlineStatus.ONLINE);
                System.out.println("online");
            }
            if (GUI.idle) {
                jda.getPresence().setStatus(OnlineStatus.IDLE);
                System.out.println("idle");
            }
            if (GUI.DnD) {
                jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
                System.out.println("DnD");
            }
            if (Commands.trackTracker) {
                jda.getPresence().setActivity(Activity.playing("-hjælp | " + currentTrack));
            }
            if(Commands.rainbow) {
                Guild rainbowGuild = jda.getGuildById(Commands.rainbowGuild);
                Member rainbowMember = rainbowGuild.getMemberById(Commands.rainbowMember);
            	System.out.println(rainbowCounter);
                if(rainbowCounter == 250) {
                	 String[] farver = {"blå", "grøn", "grå", "gul", "orange", "rød", "hvid", "lilla", "pink", "mørkegrøn"};
                	 System.out.println(farver[currentRole]);
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
        }
    }
}