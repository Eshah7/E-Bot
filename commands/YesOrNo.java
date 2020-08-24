package esha.ebot.commands;


import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class YesOrNo extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "yn")) {
			if (args.length < 2) {
				// Usage
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0x00b395);
				usage.setTitle("Specify a question!");
				usage.setDescription("Usage: `" + Main.prefix + "yn [a yes or no question]`");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else {
					int min = 0; 
					int max = 2; 
					int random_number = (int)(Math.random() * (max - min + 1) + min);
					
					if (random_number == 0) {
						EmbedBuilder success = new EmbedBuilder();
						success.setColor(0x119e18);
						success.setTitle("E-Bot says **yes**");
						event.getChannel().sendMessage(success.build()).queue();
					}
					else {
						EmbedBuilder success = new EmbedBuilder();
						success.setColor(0xc70300);
						success.setTitle("E-Bot says **no**");
						event.getChannel().sendMessage(success.build()).queue();
					}
				
				}
				
		}
	}
}
