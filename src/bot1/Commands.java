package bot1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;

import org.json.simple.JSONObject;
import org.python.util.PythonInterpreter;

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
    public static boolean jens = false;
    public static boolean rasmus = false;
    public static final char prefix = '&';
    public static long rainbowGuild = 761730703762128992L;
    public static long rainbowMember = 214752462769356802L;
    static JSONObject admin = (JSONObject) log.readData("data2.json").get("admin");
    final private String[] color = {"blue", "green", "gray", "yellow", "orange", "red", "white", "purple", "pink", "darkgreen"};
    JSONObject data = log.readData("data2.json");
    HashMap<String, Jailthread> jailed = new HashMap<String, Jailthread>();
    MusicBot musicBot = new MusicBot();
	@SuppressWarnings("unchecked")
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        TextChannel channel = event.getTextChannel();
        String msg = message.getContentRaw();
        String[] content = msg.split(" ");
        Member member = event.getMember();
        Guild guild = event.getGuild();
        MusicBot musicBot = new MusicBot();
    	JSONObject LB = log.readData("leaderboard2.json");

        // command kode
        if (event.isFromType(ChannelType.TEXT)) {
            // flair
            EmbedBuilder embed = new EmbedBuilder();
            switch(content[0].toLowerCase()) {
            	case prefix + "color":
            		if(content.length == 1) {
            			channel.sendMessage("Get color based on input").queue();
            		}
            		else if(content[1].equals("reset")) {
            			resetcolors(member, guild);
            		}
            		else {
            			for(String color : color) {
            				if(content[1].equalsIgnoreCase(color)) {
            					resetcolors(member, guild);
            					guild.addRoleToMember(member, guild.getRolesByName(color, true).get(0)).queue();
            				}
            			}
            		}
            		break;
            	case prefix + "f":
            	case prefix + "fluff":
            		if(msg.contains("er gaust mør?")) {
                    message.addReaction("\uD83D\uDC4C").queue();
            		channel.sendMessage("Gaust er mør.").queue();
            		break;
            		}
            		else if(msg.contains("vibecheck")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		embed.setAuthor("Vibecheck:");
                    	embed.setImage("https://media1.tenor.com/images/48b96ea30d85cb419b22c66393c3b739/tenor.gif?itemid=15623737");
                    	channel.sendMessageEmbeds(embed.build()).queue();
                    	break;
            		}
            		else if(msg.contains("er thomas helt oppe i bageren?")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		channel.sendMessage("Thomas er helt oppe i bageren.").queue();
                		break;
            		}
            		else if(msg.contains("har nitten kommet i sovsen?")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		channel.sendMessage("Nitten laver bechamelsovs.").queue();
                		break;
            		}
            		else if(msg.contains("dio!")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		embed.setAuthor("DIO");
                    	embed.setImage("https://gifimage.net/wp-content/uploads/2017/12/jojo-menacing-gif-12.gif");
                    	embed.setDescription("ゴゴゴゴゴゴゴゴ");
                    	channel.sendMessageEmbeds(embed.build()).queue();
                    	break;
            		}
            		else if(msg.contains("dio")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		embed.setAuthor("Just Dio");
                    	embed.setImage("https://thumbs.gfycat.com/AnchoredTornAzurewingedmagpie-small.gif");
                    	channel.sendMessageEmbeds(embed.build()).queue();
                    	break;
            		}
            		else if(msg.contains("thunder cross split attack")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		channel.sendMessageEmbeds(new EmbedBuilder().setAuthor("Thunder Cross Split Attack").setImage("https://i.imgur.com/zwioFkk.jpg").build()).queue();
                		break;
            		}
            		else if(msg.contains("hayato")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		channel.sendMessageEmbeds(new EmbedBuilder().setImage("https://media1.tenor.com/images/2b0d3da94a3c2503c2295c8837cfa578/tenor.gif?itemid=14453363").build()).queue();
                		break;
            		}
            		else if(msg.contains("oscars diller")) {
                        message.addReaction("\uD83D\uDC4C").queue();
                		embed.setImage("https://www.cdn.alt.dk/af3a7e756fff49e8babfbbfd2a7bcf91/9686403e0cc340fcb951cede6c3fd4f5.jpg");
                    	channel.sendMessageEmbeds(embed.build()).queue();
                    	break;
            		}
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
                	admin.put("moer", mør);
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
            // få hjælp
            	case prefix + "help":
            		if(content.length == 1 || content[1].contains("2")) {
            			message.addReaction("\uD83D\uDC4C").queue();
            			embed.setAuthor("Help");
                		embed.setDescription("You'll get help here");
                		embed.addField(prefix + "help or help 1, 2, etc", "Get help", false);
                		embed.addField(prefix + "Er gaust mør?", "Fluff command", false);
                		embed.addField(prefix + "mør", "Fluff command", false);
                		embed.addField(prefix + "color <color>","get role based on input (blue, green, gray, yellow, Orange, red, white, purple, Pink or darkgreen)", false);
                		embed.addField(prefix + "color reset", "Remove all colored roles from yourself", false);
                		embed.addField(prefix + "Credits", "Who made this bot", false);
                		channel.sendMessageEmbeds(embed.build()).queue();
                	break;
            		}
            		else if(content[1].contains("2")) {
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setAuthor("Help");
                	embed.setDescription("You'll get even more help here");
                	embed.addField(prefix+"mørcounter", "Fluff command", false);
                	embed.addField(prefix+"gaust er mør", "Fluff command", false);
                	embed.addField(prefix+"rainbow", "TBD", false);
                	embed.addField(prefix+"play", "queue a track", false);
                	embed.addField(prefix+"queue", "show a list of tracks in queue", false);
                	channel.sendMessageEmbeds(embed.build()).queue();
                	break;
            		}
            	case prefix + "credits":
                    message.addReaction("\uD83D\uDC4C").queue();
            		if (msg.equalsIgnoreCase(prefix + "credits")) 
            		{
            			channel.sendMessage("created by @Mast3r_waf1z#6969, name inspired by @Snaust#2517").queue();
            		}
            		break;
                //sinister intentions
            	case prefix + "jens": 
                    message.addReaction("\uD83D\uDC4C").queue();
                	if(jens) 
                	{
                		jens = false;
                		channel.sendMessage("Jens terminated").queue();
                	}
                	else if(!jens) 
                	{
                		jens = true;
                		channel.sendMessage("Jens initiated").queue();
                	}
                	break;
            	case prefix + "rasmus":
            		message.addReaction("\uD83D\uDC4C").queue();
            		if(rasmus)
            		{
            			rasmus = false;
      					channel.sendMessage("Rasmus terminated").queue();
            		}
            		else if(!rasmus) 
            		{
            			rasmus = true;
            			channel.sendMessage("Rasmus initiated").queue();
            		}
            		break;
            	case prefix + "poop":
                    message.addReaction("\uD83D\uDC4C").queue();
            		JSONObject guildData = (JSONObject) log.readData("data2.json").get(guild.getId());
            		String currentLort = guildData.get("currentLort").toString();
            		channel.sendMessage(guild.retrieveMemberById(currentLort).complete().getEffectiveName() + " has the poop").queue();
            		break;
            	case prefix + "leaderboard":
                    message.addReaction("\uD83D\uDC4C").queue();
            		embed.setTitle("Poop Leaderboard");
            		embed.setThumbnail("https://cdn.discordapp.com/attachments/692410386657574955/809730484640284682/lort.png");
            		JSONObject File = log.readData("leaderboard2.json");
            		LB = (JSONObject) File.get(guild.getId());
            		//LB = log.readData("leaderboard2.json");
            		if(LB.size() > 0) {
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

                		if(content.length > 1 && content[1].equalsIgnoreCase("plot")) { //print as a plot
                			ProcessBuilder processBuilder  = new ProcessBuilder("python", "plotter.py", guild.getId());
                			processBuilder.redirectErrorStream(true);
                			try {
								Process process = processBuilder.start();
								process.waitFor();
								File file = new File("tmp.png");
								channel.sendFile(file).queue();
								
								
							} catch (IOException | InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                			System.out.println("leaderboard table");
                		}
                		else { //print in an embed
                			for(int i = result.size(); i > 0 ; i--) { 
                				String id = result.keySet().toArray()[i - 1].toString();
                				System.out.println(id);
                				embed.addField(guild.retrieveMemberById(id).complete().getEffectiveName(),LB.get(id).toString() + " Poop", false);
                			}
                			channel.sendMessageEmbeds(embed.build()).queue();
                		}
            		}
            		else {
            			channel.sendMessage("leaderboard empty :(").queue();
            		}
            		break;
            }
            //214752462769356802 mig 310153696044515349 moham(m)ad
            if(jens && (guild.getId().equals("761730703762128992") || guild.getId().equals("692410386657574952")) && member.getId().equals("310153696044515349")) 
            {
            	message.addReaction("minn:769359037149478932").queue();
            }
            if(rasmus && guild.getId().equals("761730703762128992") && member.getId().equals("203928945207279616"))
            {
            	message.addReaction("minn:812017850281623604").queue();
            }
            double rand = Math.random() * 100;
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
            			Main.setActivity("Gaust er mør");
            			break;
            	
           			case prefix + "nitten kommer i sovsen":
           		        message.addReaction("\uD83D\uDC4C").queue();
           				Main.setActivity("Nitten kommer i sovsen");
            			break;
            		case prefix + "mørcounter":
            	        message.addReaction("\uD83D\uDC4C").queue();
            			Main.setActivity(mør + "x mør");
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

            // Musicbot
            switch(content[0].toLowerCase()) {
            case prefix + "play":
            case prefix + "p":
                message.addReaction("\uD83D\uDC4C").queue();
            	if (content.length == 2) {
            		musicBot.loadAndPlay(event.getTextChannel(), event.getMember().getVoiceState().getChannel(), content[1]);
            	}
            	else {
            		channel.sendMessage("Missing Youtube link").queue();
            	}
            	break;
            case prefix + "skip":
                message.addReaction("\uD83D\uDC4C").queue();
            	try {
            		musicBot.skipTrack(event.getTextChannel());
            	} catch(Exception e){
            		channel.sendMessage("There is nothing to skip").queue();
            	}
            	break;
            case prefix + "queue":
            case prefix + "q":
            	try {
            		if(content.length>1) {
            			channel.sendMessageEmbeds(musicBot.getQueue(guild.getTextChannelById(channel.getId()), Integer.parseInt(content[1])).build()).queue();
            		}
            		else if(content.length==1) {
            			channel.sendMessageEmbeds(musicBot.getQueue(guild.getTextChannelById(channel.getId()), 0).build()).queue();
            		}
            	}catch(IllegalStateException e) {
            		e.printStackTrace();
            		channel.sendMessage("EXCEPTION! command failed").queue();
            	}
            	break;
            case prefix + "disconnect":
            		musicBot.disconnect(guild);
            	break;
            case prefix + "nowplaying":
            case prefix + "np":
                	message.addReaction("\uD83D\uDC4C").queue();
            		try {
            		musicBot.nowPlaying(channel);
            		} catch(Exception e) {
            			channel.sendMessage("There is nothing playing").queue();
            		}
            	break;
            case prefix + "clear":
            	musicBot.clear(channel);
            	break;
            case prefix + "repeat":
                message.addReaction("\uD83D\uDC4C").queue();
            	musicBot.repeat(channel);
            	break;
            case prefix + "py":
			case prefix + "python":
				if(!message.getContentRaw().contains("while")) {
					String code = message.getContentRaw().substring(8);
					System.out.println(code);
					if(code.contains("`")) {
						code = code.substring(3, code.length()-3);
					}
					if(code.contains("python")) {
						code = code.substring(7);
					}
					else if(code.contains("py")) {
						code = code.substring(3);
					}
					
					channel.sendMessage("```python\n"+code+"\n\nOutput:\n"+pyExecuter(code)+"```").queue();
					System.out.println("finished running");
				}
				break;
			case prefix + "jail":
				if(content[1] == "--t" || content[1] == "-time") {
					message.addReaction("\uD83D\uDC4C").queue();
					long current = System.currentTimeMillis();
					long start = jailed.get(content[1].substring(3, 21)).starttime;
					String seconds = String.valueOf(jailed.get(content[1].substring(3, 21)).jailtime - ((current - start)/1000));
					String minutes = String.valueOf(jailed.get(content[1].substring(3, 21)).jailtime/60 - (((current - start)/1000)/60));
					String hours = String.valueOf(jailed.get(content[1].substring(3, 21)).jailtime/3600 - ((((current - start)/1000)/60)/60));
					String days = String.valueOf(jailed.get(content[1].substring(3, 21)).jailtime/86400 - (((((current - start)/1000)/60)/60)/24));
					String jailmsg = guild.retrieveMemberById(content[1].substring(3, 21)).complete().getEffectiveName() + " has " + days + " days or " + hours + " hours or " + minutes + " minutes or " + seconds + " seconds left ";
					channel.sendMessage(jailmsg).queue();
				}
				else if(content.length == 3 && member.isOwner()) {
					message.addReaction("\uD83D\uDC4C").queue();
					String currentRole = "";
					System.out.println(content[1]);
					if(findRole(event.getGuild().retrieveMemberById(content[1].substring(3, 21)).complete(), "Stor skade") != null) {
						currentRole = "851167407895478283";
					}
					else if(findRole(event.getGuild().retrieveMemberById(content[1].substring(3, 21)).complete(), "BRAINDEAD") != null) {
						currentRole = "851166983269384252";
					}
					else if(findRole(event.getGuild().retrieveMemberById(content[1].substring(3, 21)).complete(), "Guest") != null){
						currentRole = "884895202366595102";
					}
					jailed.put(content[1].substring(3, 21), new Jailthread(event.getGuild().retrieveMemberById(content[1].substring(3, 21)).complete(), event.getGuild().getRoleById(currentRole), Integer.parseInt(content[2]), event));
				}
				break;
            }
        }
    }

    public static Role findRole(Member member, String name) 
    {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private static User getMember(String id) throws LoginException{
        JDA jda = JDABuilder.createDefault(log.readData("data").get("token").toString()).build();
        return jda.getUserById(id);
    }
    private static Guild getGuild(String id) throws LoginException{
        JDA jda = JDABuilder.createDefault(log.readData("data").get("token").toString()).build();
    	return jda.getGuildById(id);
        
    }
    private void resetcolors (Member member, Guild guild) {
    	for(int i = 0; i < color.length; i++) {
    		if(findRole(member, color[i]) != null) {
    			guild.removeRoleFromMember(member, guild.getRolesByName(color[i], true).get(0)).queue();
    		}
    	}
    }
	public String pyExecuter(String code) {
		PythonInterpreter pyInterp;
		pyInterp = new PythonInterpreter();
		StringWriter output = new StringWriter();
		pyInterp.setOut(output);
		pyInterp.exec(code);
		System.out.println(output.toString());
		pyInterp.close();
		return output.toString();
	}
}
