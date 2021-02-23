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
    public static boolean ActivityM�r = false;
    public static String currentTrack;
    public static int rainbowCounter = 0;
    public static int currentRole = 0;

    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws LoginException, InterruptedException, IOException, InvocationTargetException {
    	JSONObject admin = (JSONObject) log.readData("data2.json").get("admin");
    	System.out.println(admin);
        Commands.m�r = Long.parseLong(admin.get("m�r").toString());
        GUI newWindow = new GUI("M�r Bot");
        final JDA jda = JDABuilder.createDefault(admin.get("token").toString())
                .addEventListeners(new Commands()).setActivity(Activity.playing("-hj�lp"))
                .setStatus(OnlineStatus.ONLINE).build();
        
        //MessageChannel channel = jda.getGuildById(692410386657574952L).getTextChannelById(798128372403929088L);
        //channel.addReactionById(798128372403929088L, "U+1F602").queue();
        //Message message = new MessageBuilder().append("lol").build();
        //channel.sendMessage(message).queue();
        
        
        while (true) {
            if (GUI.button1pressed) {
                jda.getPresence().setActivity(Activity.playing("-hj�lp | " + newWindow.activity));
                System.out.println(newWindow.activity);
                ActivityM�r = false;
            }
            if (Commands.nitten) {
                jda.getPresence().setActivity(Activity.playing("-hj�lp | " + "Nitten kommer i sovsen"));
            }
            if (GUI.button2pressed) {
                jda.getPresence().setActivity(Activity.playing("-hj�lp | " + Commands.m�r + " x M�r"));
                ActivityM�r = true;

            }
            if (GUI.button3pressed) {
            	admin.put("m�r", 0);
            	log.writeData("admin", admin, "data2.json");
                //log.writeFile(String.valueOf(0));
                Commands.m�r = 0;
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
                jda.getPresence().setActivity(Activity.playing("-hj�lp | " + currentTrack));
            }
            if(Commands.rainbow) {
                Guild rainbowGuild = jda.getGuildById(Commands.rainbowGuild);
                Member rainbowMember = rainbowGuild.getMemberById(Commands.rainbowMember);
            	System.out.println(rainbowCounter);
                if(rainbowCounter == 250) {
                	 String[] farver = {"bl�", "gr�n", "gr�", "gul", "orange", "r�d", "hvid", "lilla", "pink", "m�rkegr�n"};
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