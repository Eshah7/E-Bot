package esha.ebot.commands;

import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Info extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "info")) {
			EmbedBuilder info = new EmbedBuilder(); 
			info.setTitle("E-Bot 🌹 Information"); 
			info.setDescription("A project discord bot to add some fun to servers!");
			info.setColor(0x00b395);
			info.setFooter("Created by Esha", event.getMember().getUser().getAvatarUrl()); 
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
	}
}
			
