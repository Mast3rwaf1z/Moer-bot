package bot1;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Jailthread extends Thread{
	int jailtime;
	Member jailed;
	MessageReceivedEvent event;
	Role currentRole;
	TextChannel jailchannel;
	public long starttime;
	public Jailthread(Member member, Role role, int t, MessageReceivedEvent e) {
		jailtime = t;
		jailed = member;
		event = e;
		currentRole = role;
		jailchannel = e.getGuild().getTextChannelById("904713794348011591");
		starttime = System.currentTimeMillis();
		this.start();
	}
	public void run() {
		System.out.println("removing role " + currentRole.getName());
		event.getGuild().removeRoleFromMember(jailed, currentRole).queue();
		System.out.println("adding role " + event.getGuild().getRoleById("884892762246348840").getName());
		event.getGuild().addRoleToMember(jailed, event.getGuild().getRoleById("884892762246348840")).queue();
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle(jailed.getEffectiveName() + " has been jailed!");
		builder.setDescription(jailed.getAsMention() + " has been jailed for " + jailtime + " seconds (" + jailtime/60 + " minutes)");
		jailchannel.sendMessageEmbeds(builder.build()).queue();
		try {
			Thread.sleep(jailtime*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("removing role " + event.getGuild().getRoleById("884892762246348840").getName());
		event.getGuild().removeRoleFromMember(jailed, event.getGuild().getRoleById("884892762246348840")).queue();
		System.out.println("adding role " +  currentRole.getName());
		event.getGuild().addRoleToMember(jailed, currentRole).queue();
	}
}
