package bot1;

import java.io.IOException;
import java.util.List;

import bot1.MusicPlayer.MusicBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
/**
 * Commands
 */
public class Commands extends ListenerAdapter {
    static public long mør = 0;
    public static boolean nitten = false;
    public static boolean trackTracker = false;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String msg = message.getContentDisplay();
        String[] splitmsg = msg.split(" ", findStringSubstrings(msg, ' ') + 1);
        Member member = event.getMember();
        Guild guild = event.getGuild();
        TextChannel bøwFarver = guild.getTextChannelById(692746501520359466L);
        TextChannel testChannel = guild.getTextChannelById(692410386657574955L);
        MusicBot musicBot = new MusicBot();

        // command kode
        if (event.isFromType(ChannelType.TEXT)) {

            if (channel == bøwFarver) {
                // få farver
                if (msg.equalsIgnoreCase(Main.prefix + "blå")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554161147838633L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "grøn")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554377016344596L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "grå")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554405176508466L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "gul")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554425070092288L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "orange")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554454476750873L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "rød")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554483693879326L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "Hvid")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554525805084722L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "lilla")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554589226893393L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "pink")) {
                    guild.addRoleToMember(member, guild.getRoleById(685554611662487731L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "mørkegrøn")) {
                    guild.addRoleToMember(member, guild.getRoleById(685563159968612392L)).queue();
                }

                // fjern alle farver
                if (msg.equalsIgnoreCase(Main.prefix + "resetfarver")) {
                    if (findRole(member, "Blå") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554161147838633L)).queue();
                    }
                    if (findRole(member, "Grøn") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554377016344596L)).queue();
                    }
                    if (findRole(member, "Grå") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554405176508466L)).queue();
                    }
                    if (findRole(member, "Gul") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554425070092288L)).queue();
                    }
                    if (findRole(member, "Orange") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554454476750873L)).queue();
                    }
                    if (findRole(member, "Rød") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554483693879326L)).queue();
                    }
                    if (findRole(member, "Hvid") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554525805084722L)).queue();
                    }
                    if (findRole(member, "Lilla") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554589226893393L)).queue();
                    }
                    if (findRole(member, "Pink") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685554611662487731L)).queue();
                    }
                    if (findRole(member, "Mørkegrøn") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(685563159968612392L)).queue();
                    }
                }
                if
            }
            if (channel == testChannel) {
                // fÃ¥ farver
                if (msg.equalsIgnoreCase(Main.prefix + "blå")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254114409381920L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "grøn")) {
                    guild.addRoleToMember(member, guild.getRoleById(692700136668659732L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "grå")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254163940048906L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "gul")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254233561432124L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "orange")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254284899581992L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "rød")) {
                    guild.addRoleToMember(member, guild.getRoleById(692728493900824596L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "Hvid")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254327710842902L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "lilla")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254365384212531L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "pink")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254401887240203L)).queue();
                }
                if (msg.equalsIgnoreCase(Main.prefix + "mørkegrøn")) {
                    guild.addRoleToMember(member, guild.getRoleById(695254457293996103L)).queue();
                }

                // fjern alle farver
                if (msg.equalsIgnoreCase(Main.prefix + "resetfarver")) {
                    if (findRole(member, "blå") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254114409381920L)).queue();
                    }
                    if (findRole(member, "grøn") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(692700136668659732L)).queue();
                    }
                    if (findRole(member, "grå") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254163940048906L)).queue();
                    }
                    if (findRole(member, "gul") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254233561432124L)).queue();
                    }
                    if (findRole(member, "orange") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254284899581992L)).queue();
                    }
                    if (findRole(member, "rød") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(692728493900824596L)).queue();
                    }
                    if (findRole(member, "Hvid") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254327710842902L)).queue();
                    }
                    if (findRole(member, "lilla") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254365384212531L)).queue();
                    }
                    if (findRole(member, "pink") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254401887240203L)).queue();
                    }
                    if (findRole(member, "mørkegrøn") != null) {
                        guild.removeRoleFromMember(member, guild.getRoleById(695254457293996103L)).queue();
                    }
                }
            }

            // flair
            if (msg.equalsIgnoreCase(Main.prefix + "Er gaust mør?")) {
                channel.sendMessage("Gaust er mør.").queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "Mør")) {
                mør++;
                if (mør == 1) {
                    channel.sendMessage("der er blevet mørret " + mør + " gang").queue();
                } else {

                    channel.sendMessage("der er blevet mørret " + mør + " gange").queue();
                }
                try {
                    log.writeFile(String.valueOf(Commands.mør));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Main.ActivityMør == true) {
                    GUI.button2pressed = true;
                }
            }
            if (msg.equalsIgnoreCase(Main.prefix + "Profiler")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor(event.getAuthor().getName() + "'s profil");
                embed.setImage(event.getAuthor().getAvatarUrl());
                embed.setDescription(event.getAuthor().getId() + "L");
                channel.sendMessage(embed.build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "Vibecheck")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor("Vibecheck:");
                embed.setImage(
                        "https://media1.tenor.com/images/48b96ea30d85cb419b22c66393c3b739/tenor.gif?itemid=15623737");
                channel.sendMessage(embed.build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "Er thomas helt oppe i bageren?")) {
                channel.sendMessage("Thomas er helt oppe i bageren.").queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "har nitten kommet i sovsen?")) {
                channel.sendMessage("Nitten laver bechamelsovs.").queue();
            }
            if (msg.equals(Main.prefix + "DIO")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor("DIO");
                embed.setImage("https://gifimage.net/wp-content/uploads/2017/12/jojo-menacing-gif-12.gif");
                embed.setDescription("ゴゴゴゴゴゴゴゴ");
                channel.sendMessage(embed.build()).queue();
            }
            if (msg.equals(Main.prefix + "Dio")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor("Just Dio");
                embed.setImage("https://thumbs.gfycat.com/AnchoredTornAzurewingedmagpie-small.gif");
                channel.sendMessage(embed.build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "Thunder cross split attack")) {
                channel.sendMessage(new EmbedBuilder().setAuthor("Thunder Cross Split Attack")
                        .setImage("https://i.imgur.com/zwioFkk.jpg").build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "Hayato")) {
                channel.sendMessage(new EmbedBuilder().setImage(
                        "https://media1.tenor.com/images/2b0d3da94a3c2503c2295c8837cfa578/tenor.gif?itemid=14453363")
                        .build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "Oscars diller")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setImage(
                        "https://www.cdn.alt.dk/af3a7e756fff49e8babfbbfd2a7bcf91/9686403e0cc340fcb951cede6c3fd4f5.jpg");
                channel.sendMessage(embed.build()).queue();
            }

            // to be split commands
            if (splitmsg[0].equalsIgnoreCase(Main.prefix + "split")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor("split");

                for (int i = 1; i < splitmsg.length; i++) {
                    embed.addField(" ", splitmsg[i], false);
                }
                embed.setDescription("total: " + String.valueOf(splitmsg.length - 1));
                channel.sendMessage(embed.build()).queue();
            }

            if (splitmsg[0].equalsIgnoreCase(Main.prefix + "link")) {
                char[] youtube = { 'y', 'o', 'u', 't', 'u' };
                if (splitmsg[1].length() > 5) {
                    if (findSpecificSubstring(youtube, splitmsg[1])) {
                        channel.sendMessage("youtube").queue();
                    }
                }
                char[] soundcloud = { 'o', 'u', 'n', 'd' };
                if (splitmsg[1].length() > 5) {
                    if (findSpecificSubstring(soundcloud, splitmsg[1])) {
                        channel.sendMessage("soundcloud").queue();
                    }
                }
            }

            // Musicbot
            if (splitmsg[0].equalsIgnoreCase(Main.prefix + "play") || splitmsg[0].equalsIgnoreCase(Main.prefix + "p")) {
                if (splitmsg.length == 2) {
                    musicBot.loadAndPlay(event.getTextChannel(), event.getMember().getVoiceState().getChannel(),
                            splitmsg[1]);
                } else {
                    channel.sendMessage("Link mangler");
                }
            } else if (splitmsg[0].equalsIgnoreCase(Main.prefix + "skip")) {
                musicBot.skipTrack(event.getTextChannel());
            }
            if (msg.equalsIgnoreCase(Main.prefix + "queue")) {
                channel.sendMessage(musicBot.getQueue().build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "disconnect")) {
                musicBot.disconnect(guild);
            }

            // modrank commands
            if (findRole(member, "Bread") != null) {
                if (msg.equalsIgnoreCase(Main.prefix + "Gaust er mÃ¸r")) {
                    GUI.button1pressed = true;
                }
                if (msg.equalsIgnoreCase(Main.prefix + "nitten kommer i sovsen")) {
                    nitten = true;
                }
                if (msg.equalsIgnoreCase(Main.prefix + "MÃ¸rcounter")) {
                    GUI.button2pressed = true;
                }
                if (msg.equalsIgnoreCase(Main.prefix + "track")) {
                    trackTracker = true;
                }
            }

            // få hjælp
            if (msg.equalsIgnoreCase(Main.prefix + "hjælp") || msg.equalsIgnoreCase(Main.prefix + "hjælp1")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor("Hjælp");
                embed.setDescription("Her får du hjælp");
                embed.addField("-hjælp eller hjælp1, 2, osv", "Få hjælp", false);
                embed.addField("-Er gaust mør?", "Få at vide om gaust er mør", false);
                embed.addField("-mør", "Mør", false);
                embed.addField("-farve",
                        "Få rolle ud fra farve (Blå, Grøn, Grå, Gul, Orange, Rød, Hvid, Lilla, Pink eller Mørkegrøn)",
                        false);
                embed.addField("-resetfarver", "Fjern alle farvede roller fra dig selv", false);
                embed.addField("-Hvad er bøw?", "Find ud af hvad bøw er.", false);
                embed.addField("-Credits", "Hvem har lavet botten ;)", false);
                channel.sendMessage(embed.build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "hjælp2")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor("Hjælp");
                embed.setDescription("Her får du mere hjælp");
                embed.addField("-mørcounter", "find ud af hvor mørret der er blevet", false);
                embed.addField("-gaust er mør", "giv alle besked at gaust er mør", false);
                channel.sendMessage(embed.build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "hvad er bøw?")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setAuthor("Hvad er Bøw?");
                embed.setDescription(
                        "Dette er en discord server der først blev brugt meget da de fleste der er mod nu gik på HTX");
                embed.addField("Hvorfor er vi på 3. server?",
                        "Den første server endte alle med admin og ødelagde serveren, anden server blev efterladt af ejeren",
                        false);
                channel.sendMessage(embed.build()).queue();
            }
            if (msg.equalsIgnoreCase(Main.prefix + "credits")) {
                channel.sendMessage("@Mast3r_waf1z#6969 har lavet Mør Bot, inspireret af at @Jynis#2517 er mør")
                        .queue();
            }

        }
    }

    public Role findRole(Member member, String name) {
        List<Role> roles = member.getRoles();
        return roles.stream().filter(role -> role.getName().equals(name)).findFirst().orElse(null);
    }

    public int findStringSubstrings(String string, char c) {
        int substrings = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                substrings++;
            }
        }
        return substrings;
    }

    public boolean findSpecificSubstring(char[] c, String string) {
        boolean[] Found = new boolean[c.length];
        boolean result = true;
        int startLocation = 0;
        for (int i = 0; i < c.length; i++) {
            Found[i] = false;
        }
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c[0] && startLocation == 0) {
                startLocation = i;
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (string.charAt(i + startLocation) == c[i] && Found[i] == false) {
                Found[i] = true;
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (!Found[i]) {
                result = false;
            }
        }
        return result;
    }
}
