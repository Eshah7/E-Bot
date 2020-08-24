package esha.ebot.commands;

import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "help")) {
			EmbedBuilder help = new EmbedBuilder(); 
			help.setTitle("Features"); 
			help.setDescription("**`~info`**"+" get more information about ebot\n" + "**`~clear`**"+" clear 2-100 messages within the past two (2) weeks \n" + "**`~yn`**" + " ask a yes or no question\n" + "**`~bw`**"+" ask everyone currently online to play bed wars\n" + "**`~tos`**" + "ask everyone currently online to play town of salem\n" 
			+ "**`~help`**"+" prompt this list");
			help.setColor(0x00b395);
			help.setFooter("Created by Esha", event.getMember().getUser().getAvatarUrl()); 
			
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(help.build()).queue();
			help.clear();
		}
	}
}
			
