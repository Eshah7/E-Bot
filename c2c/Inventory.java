package esha.ebot.c2c;

import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Inventory extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "stock")) {
			EmbedBuilder balanceSheet = new EmbedBuilder(); 
			balanceSheet.setTitle("Recent 🌊 Inventory Stock Check"); 
			balanceSheet.setDescription("**__Product List: __**\n" + "1 Animal Crossing Cat Pack\n " + "1 Lemon Sticker\n" + "2 Fossils");
			balanceSheet.setColor(0x00b395);
			balanceSheet.setFooter("Created by Esha", event.getMember().getUser().getAvatarUrl()); 
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(balanceSheet.build()).queue();
			balanceSheet.clear();
		}
	}
}
			
