package esha.ebot.commands;

import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TownOfSalem extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "tos")) {
			EmbedBuilder tos = new EmbedBuilder(); 
			
			tos.setTitle("Town of Salem 🧙‍♀️🔮"); 
			tos.setDescription("Would you like to play Town of Salem?");
			tos.setColor(0x9026a6);
			tos.setFooter("Created by Esha", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage("@here").queue(); 
			event.getChannel().sendMessage(tos.build()).complete().addReaction("✨").queue();
			
			tos.clear();
		}
	}
}
			
