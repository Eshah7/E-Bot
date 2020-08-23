package esha.ebot.c2c;

import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BalanceSheet extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "bs")) {
			EmbedBuilder balanceSheet = new EmbedBuilder(); 
			balanceSheet.setTitle("Recent 🌊 Balance Sheet"); 
			balanceSheet.setDescription("See how our business is performing by viewing the Balance Sheet");
			balanceSheet.setImage("https://i.imgur.com/XyXhUAl.png");
			balanceSheet.setColor(0x00b395);
			balanceSheet.setFooter("Created by Esha", event.getMember().getUser().getAvatarUrl()); 
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(balanceSheet.build()).queue();
			balanceSheet.clear();
		}
	}
}
			
