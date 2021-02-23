package bot1;

import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;

import org.json.simple.JSONObject;


import bot1.MusicPlayer.MusicBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
/**
 * Commands
 */
public class Commands extends ListenerAdapter{
    static public long mør = 0;
    public static boolean nitten = false;
    public static boolean trackTracker = false;
    public static boolean rainbow = false;
    public static boolean reacter = false;
    private static final String prefix = "-";
    public static long rainbowGuild = 761730703762128992L;
    public static long rainbowMember = 214752462769356802L;
    static JSONObject admin = (JSONObject) log.readData("data2.json").get("admin");
    JSONObject data = log.readData("data2.json");
	@SuppressWarnings("unchecked")
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentDisplay();
        String[] splitmsg = msg.split(" ", findStringSubstrings(msg, ' ') + 1);
        Member member = event.getMember();
        Guild guild = event.getGuild();
        TextChannel testChannel = guild.getTextChannelsByName("botspam", true).get(0);
        MusicBot musicBot = new MusicBot();
    	JSONObject LB = log.readData("leaderboard2.json");
    	

        // command kode
        if (event.isFromType(ChannelType.TEXT)) {
        	
            if (channel == testChannel) {
                // få farver
            	switch(msg.toLowerCase()) {
            		case prefix + "farve " + "blå":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("blå", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "grøn":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("grøn", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "grå":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("grå", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "gul":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("gul", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "orange":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("orange", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "rød":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("rød", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "hvid":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("hvid", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "lilla":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("lilla", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "pink":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("pink", true).get(0)).queue();
            			break;
            		case prefix + "farve " + "mørkegrøn":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			guild.addRoleToMember(member, guild.getRolesByName("mørkegrøn", true).get(0)).queue();
            			break;
            	}

                // fjern alle farver
                if (msg.equalsIgnoreCase(prefix + "farve " + "reset")) {
                    message.addReaction("\uD83D\uDC4C").queue();
                    if (findRole(member, "blå") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("blå", true).get(0)).queue();
                    }
                    if (findRole(member, "Grøn") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("grøn", true).get(0)).queue();
                    }
                    if (findRole(member, "Grå") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("grå", true).get(0)).queue();
                    }
                    if (findRole(member, "Gul") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("gul", true).get(0)).queue();
                    }
                    if (findRole(member, "Orange") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("orange", true).get(0)).queue();
                    }
                    if (findRole(member, "Rød") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("rød", true).get(0)).queue();
                    }
                    if (findRole(member, "Hvid") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("hvid", true).get(0)).queue();
                    }
                    if (findRole(member, "Lilla") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("lilla", true).get(0)).queue();
                    }
                    if (findRole(member, "Pink") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("pink", true).get(0)).queue();
                    }
                    if (findRole(member, "Mørkegrøn") != null) {
                        guild.removeRoleFromMember(member, guild.getRolesByName("mørkegrøn", true).get(0)).queue();
                    }
                }
            }

            // flair
            EmbedBuilder embed = new EmbedBuilder();
            switch(msg.toLowerCase()) {
            	case prefix + "er gaust mør?":
                    message.addReaction("\uD83D\uDC4C").queue();
            		channel.sendMessage("Gaust er mør.").queue();
            		break;
            	case prefix + "mør":
                    message.addReaction("\uD83D\uDC4C").queue();
            		mør++;
                	if (mør == 1) {
                		channel.sendMessage("der er blevet mørret " + mør + " gang").queue();
                	}
                	else 
                	{
                		channel.sendMessage("der er blevet mørret " + mør + " gange").queue();
                	}
                	//try 
                	//{
                		//log.writeFile(String.valueOf(Commands.mør));
                	admin.put("mør", mør);
                		log.writeData("admin", admin, "data2.json");
                	//} 
                	/*catch (IOException e) 
                	{
                		e.printStackTrace();
                	}*/
                	if (Main.ActivityMør == true) 
                	{
                		GUI.button2pressed = true;
                	}
                	break;
                
            	case prefix + "profiler":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor(event.getAuthor().getName() + "'s profil");
            		embed.setImage(event.getAuthor().getAvatarUrl());
            		embed.setDescription(event.getAuthor().getId() + "L");
            		channel.sendMessage(embed.build()).queue();
            		break;
                
            	case prefix + "vibecheck":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor("Vibecheck:");
                	embed.setImage("https://media1.tenor.com/images/48b96ea30d85cb419b22c66393c3b739/tenor.gif?itemid=15623737");
                	channel.sendMessage(embed.build()).queue();
                	break;
                
            	case prefix + "er thomas helt oppe i bageren?":
                    message.addReaction("\uD83D\uDC4C").queue();
            		channel.sendMessage("Thomas er helt oppe i bageren.").queue();
            		break;
            
            	case prefix + "har nitten kommet i sovsen?":
                    message.addReaction("\uD83D\uDC4C").queue();
            		channel.sendMessage("Nitten laver bechamelsovs.").queue();
            		break;
                
            	case prefix + "dio!":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor("DIO");
                	embed.setImage("https://gifimage.net/wp-content/uploads/2017/12/jojo-menacing-gif-12.gif");
                	embed.setDescription("ゴゴゴゴゴゴゴゴ");
                	channel.sendMessage(embed.build()).queue();
                	break;
                
            	case prefix + "dio":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor("Just Dio");
                	embed.setImage("https://thumbs.gfycat.com/AnchoredTornAzurewingedmagpie-small.gif");
                	channel.sendMessage(embed.build()).queue();
                	break;
                
            	case prefix + "thunder cross split attack":
                    message.addReaction("\uD83D\uDC4C").queue();
            		channel.sendMessage(new EmbedBuilder().setAuthor("Thunder Cross Split Attack").setImage("https://i.imgur.com/zwioFkk.jpg").build()).queue();
            		break;
            
            	case prefix + "hayato":
                    message.addReaction("\uD83D\uDC4C").queue();
            		channel.sendMessage(new EmbedBuilder().setImage("https://media1.tenor.com/images/2b0d3da94a3c2503c2295c8837cfa578/tenor.gif?itemid=14453363").build()).queue();
            		break;
            
            	case prefix + "oscars diller":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setImage("https://www.cdn.alt.dk/af3a7e756fff49e8babfbbfd2a7bcf91/9686403e0cc340fcb951cede6c3fd4f5.jpg");
                	channel.sendMessage(embed.build()).queue();
                	break;
            

            

            // få hjælp
            	case prefix + "hjælp 1":
            	case prefix + "hjælp":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor("Hjælp");
                	embed.setDescription("Her får du hjælp");
                	embed.addField("-hjælp eller hjælp 1, 2, osv", "Få hjælp", false);
                	embed.addField("-Er gaust mør?", "Få at vide om gaust er mør", false);
                	embed.addField("-mør", "Mør", false);
                	embed.addField("-farve <farve>","Få rolle ud fra farve (Blå, Grøn, Grå, Gul, Orange, Rød, Hvid, Lilla, Pink eller Mørkegrøn)", false);
                	embed.addField("-farve reset", "Fjern alle farvede roller fra dig selv", false);
                	embed.addField("-Hvad er bøw?", "Find ud af hvad bøw er.", false);
                	embed.addField("-Credits", "Hvem har lavet botten ;)", false);
                	channel.sendMessage(embed.build()).queue();
                	break;
                
            	case prefix + "hjælp 2":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor("Hjælp");
                	embed.setDescription("Her får du mere hjælp");
                	embed.addField("-mørcounter", "find ud af hvor mørret der er blevet", false);
                	embed.addField("-gaust er mør", "giv alle besked at gaust er mør", false);
                	embed.addField("rainbow", "få dit navn til at være sejt", false);
                	channel.sendMessage(embed.build()).queue();
                	break;
                
            	case prefix + "hvad er bøw?":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor("Hvad er Bøw?");
                	embed.setDescription("Dette er en discord server der først blev brugt meget da de fleste der er mod nu gik på HTX");
                	embed.addField("Hvorfor er vi på 3. server?", "Den første server endte alle med admin og ødelagde serveren, anden server blev efterladt af ejeren", false);
                	channel.sendMessage(embed.build()).queue();
                	break;
                
            	case prefix + "credits":
                    message.addReaction("\uD83D\uDC4C").queue();
            		if (msg.equalsIgnoreCase(prefix + "credits")) 
            		{
            			channel.sendMessage("@Mast3r_waf1z#6969 har lavet Mør Bot, inspireret af at @Snaust#2517 er mør").queue();
            		}
            		break;
                //sinister intentions
            	case prefix + "jens": 
                    message.addReaction("\uD83D\uDC4C").queue();
                	{
                		if(reacter) 
                		{
                			reacter = false;
                			channel.sendMessage("Jens terminated").queue();
                		}
                		else if(!reacter) 
                		{
                			reacter = true;
                			channel.sendMessage("Jens initiated").queue();
                		}
                	}
                	break;
            	case prefix + "lort":
                    message.addReaction("\uD83D\uDC4C").queue();
            		JSONObject guildData = (JSONObject) log.readData("data2.json").get(guild.getId());
            		String currentLort = guildData.get("currentLort").toString();
            		channel.sendMessage(guild.retrieveMemberById(currentLort).complete().getEffectiveName() + " har lorten").queue();
            		break;
            	case prefix + "leaderboard":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setTitle("Lort Leaderboard");
            		embed.setThumbnail("https://cdn.discordapp.com/attachments/692410386657574955/809730484640284682/lort.png");
            		JSONObject File = log.readData("leaderboard2.json");
            		LB = (JSONObject) File.get(guild.getId());
            		//LB = log.readData("leaderboard2.json");
            		if(LB.size() > 0) {
                		System.out.println("Leaderboard size: "+LB.size());
                		System.out.println("first entry: "+LB.entrySet().toArray()[0].toString().substring(0, 18));
                		Object[] entrySet = LB.entrySet().toArray();
                		
                		//sort
                		HashMap<String, Integer> converted = new HashMap<String, Integer>();
                		Object[] keys = LB.keySet().toArray();
                		for(int i = 0; i < LB.size(); i++) {
                			converted.put(keys[i].toString(),Integer.parseInt(LB.get(keys[i]).toString()));
                		}
                		System.out.println("converted: "+converted);
                		Map<String, Integer> result = converted.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                		System.out.println(result);
                		//end sort
                		
            			for(int i = result.size(); i > 0 ; i--) {
            				String id = result.keySet().toArray()[i - 1].toString().substring(0, 18);
            				embed.addField(guild.retrieveMemberById(id).complete().getEffectiveName(),LB.get(id).toString() + " Lort", false);
            			}
            			channel.sendMessage(embed.build()).queue();
            		}
            		else {
            			channel.sendMessage("leaderboard empty :(").queue();
            		}
            		break;
            }
            //214752462769356802 mig 310153696044515349 moham(m)ad
            if(reacter && guild.getId().equals("761730703762128992") && member.getId().equals("310153696044515349")) 
            {
            	message.addReaction("minn:769359037149478932").queue();
            }
            double rand = Math.random() * 100;
            System.out.println(Math.exp(msg.length()/175));
            if(rand > 99 - (Math.exp(msg.length()/175))) {
            	message.addReaction("\uD83D\uDCA9").queue();
            	JSONObject data = new JSONObject();
            	data.put("currentLort", member.getIdLong());
            	log.writeData(guild.getId(), data, "data2.json");
            	//add 1 to leaderboard for the given member
            	JSONObject file = log.readData("leaderboard2.json");
            	if(file.containsKey(guild.getId()))
            	{
            		LB = (JSONObject) file.get(guild.getId());
            	}else {
            		LB = new JSONObject();
            	}
            	long count;
            	if(LB.get(member.getId()) != null) {
            		count = Long.parseLong(LB.get(member.getId()).toString());
            		count++;
            	}
            	else {
            		count = 1;
            	}
            	JSONObject LBentry = new JSONObject();
            	LBentry = LB;
            	LBentry.put(member.getId(), count);
            	log.writeData(guild.getId(), LBentry, "leaderboard2.json");
            	
            }
                
         // modrank commands
            if (member.hasPermission(Permission.ADMINISTRATOR))
            {
            	switch(msg.toLowerCase()) 
            	{
            		case prefix + "gaust er mør":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			GUI.button1pressed = true;
            			break;
            	
           			case prefix + "nitten kommer i sovsen":
           		        message.addReaction("\uD83D\uDC4C").queue();
       					nitten = true;
            			break;
            		case prefix + "mørcounter":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			GUI.button2pressed = true;
            			break;
            	
            		case prefix + "track":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			trackTracker = true;
            			break;
            			
            		case prefix + "rainbow start":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			rainbow = true;
            			rainbowGuild = guild.getIdLong();
            			rainbowMember = member.getIdLong();
            			break;
            		case prefix + "rainbow stop":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			rainbow = false;
            			break;
            		case prefix + "rainbow":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			channel.sendMessage("warning! This is fairly gay").queue();
            			channel.sendMessage("-rainbow start to begin").queue();
            			channel.sendMessage("-rainbow stop to stop").queue();
            			break;
            		case prefix + "exit":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			System.exit(0);
            			break;
            	}
            }

            // to be split commands
            if (splitmsg[0].equalsIgnoreCase(prefix + "split")) 
            {
                message.addReaction("\uD83D\uDC4C").queue();
            	embed.setAuthor("split");

            	for (int i = 1; i < splitmsg.length; i++) 
            	{
            		embed.addField(" ", splitmsg[i], false);
            	}
            	embed.setDescription("total: " + String.valueOf(splitmsg.length - 1));
            	channel.sendMessage(embed.build()).queue();
            }

            if (splitmsg[0].equalsIgnoreCase(prefix + "link")) 
            {
                message.addReaction("\uD83D\uDC4C").queue();
            	char[] youtube = { 'y', 'o', 'u', 't', 'u' };
            	if (splitmsg[1].length() > 5) 
            	{
            		if (findSpecificSubstring(youtube, splitmsg[1])) 
            		{
            			channel.sendMessage("youtube").queue();
            		}
            	}
            	char[] soundcloud = { 'o', 'u', 'n', 'd' };
            	if (splitmsg[1].length() > 5) 
            	{
            		if (findSpecificSubstring(soundcloud, splitmsg[1])) 
            		{
            			channel.sendMessage("soundcloud").queue();
            		}
            	}
            }

            // Musicbot
            if (splitmsg[0].equalsIgnoreCase(prefix + "play") || splitmsg[0].equalsIgnoreCase(prefix + "p")) 
            {
                message.addReaction("\uD83D\uDC4C").queue();
            	if (splitmsg.length == 2) 
            	{
            		musicBot.loadAndPlay(event.getTextChannel(), event.getMember().getVoiceState().getChannel(), splitmsg[1]);
            	} 
            	else 
            	{
            		channel.sendMessage("Link mangler");
            	}
            }
            else if (splitmsg[0].equalsIgnoreCase(prefix + "skip")) 
            {
                message.addReaction("\uD83D\uDC4C").queue();
            	musicBot.skipTrack(event.getTextChannel());
            }
            if (msg.equalsIgnoreCase(prefix + "queue")) 
            {
            	channel.sendMessage(musicBot.getQueue().build()).queue();
            }
            if (msg.equalsIgnoreCase(prefix + "disconnect")) 
            {
            	musicBot.disconnect(guild);
            }
        }
    }

    public static Role findRole(Member member, String name) 
    {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public int findStringSubstrings(String string, char c) 
    {
        int substrings = 0;
        for (int i = 0; i < string.length(); i++) 
        {
            if (string.charAt(i) == c) 
            {
                substrings++;
            }
        }
        return substrings;
    }

    public boolean findSpecificSubstring(char[] c, String string) 
    {
        boolean[] Found = new boolean[c.length];
        boolean result = true;
        int startLocation = 0;
        for (int i = 0; i < c.length; i++) 
        {
            Found[i] = false;
        }
        for (int i = 0; i < string.length(); i++) 
        {
            if (string.charAt(i) == c[0] && startLocation == 0) 
            {
                startLocation = i;
            }
        }
        for (int i = 0; i < c.length; i++) 
        {
            if (string.charAt(i + startLocation) == c[i] && Found[i] == false) 
            {
                Found[i] = true;
            }
        }
        for (int i = 0; i < c.length; i++) 
        {
            if (!Found[i]) 
            {
                result = false;
            }
        }
        return result;
    }
    private static User getMember(String id) throws LoginException{
        JDA jda = JDABuilder.createDefault(log.readData("data").get("token").toString()).build();
        return jda.getUserById(id);
    }
    private static Guild getGuild(String id) throws LoginException{
        JDA jda = JDABuilder.createDefault(log.readData("data").get("token").toString()).build();
    	return jda.getGuildById(id);
        
    }
}
