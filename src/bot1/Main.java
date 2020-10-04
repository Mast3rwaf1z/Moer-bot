package bot1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import esp32.*;

public class Main {
    public static String prefix = "-";
    public static boolean ActivityMør = false;
    public static String currentTrack;

    public static void main(String[] args) throws LoginException, InterruptedException, IOException, InvocationTargetException {
        Commands.mør = Long.parseLong(log.readFile());
        GUI newWindow = new GUI("Mør Bot");
        final JDA jda = JDABuilder.createDefault("")
                .addEventListeners(new Commands()).setActivity(Activity.playing("-hjælp"))
                .setStatus(OnlineStatus.ONLINE).build();
        SendData.SendDataToESP();
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
                log.writeFile(String.valueOf(0));
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
                jda.getPresence().setActivity(Activity.playing("-hjÃ¦lp | " + currentTrack));
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