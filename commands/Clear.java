package esha.ebot.commands;

import java.util.List;


import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "clear")) {
			if (args.length < 2) {
				// Usage
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("Specify amount to delete");
				usage.setDescription("Usage: `" + Main.prefix + "clear [# of messages]`");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
				
					// Success
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x22ff2a);
					success.setTitle("✅ Successfully deleted " + args[1] + " messages.");
					event.getChannel().sendMessage(success.build()).queue();
				}
				catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						// Too many messages
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("❌ Too many messages selected");
						error.setDescription("Only hundred (100) messages can be deleted at a time.");
						event.getChannel().sendMessage(error.build()).queue();
					}
					else {
						// Messages that are too old
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("❌ Selected messages are older than two (2) weeks");
						error.setDescription("Messages older than two (2) weeks cannot be deleted.");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
			}
		}
	}
}
