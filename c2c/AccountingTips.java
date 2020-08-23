package esha.ebot.c2c;

import esha.ebot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AccountingTips extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "accountingtips")) {
			EmbedBuilder balanceSheet = new EmbedBuilder(); 
			balanceSheet.setTitle("C2C 🌊 Accounting Crash Course"); 
			balanceSheet.setDescription("**__Balance Sheet: __**\n" + "**Assets:** A resource with economic value (Ex. Inventory, Cash, Equipment, Supplies & Copyrights)\n" + "**Liabilities:** Something the company owes (Ex. Loan, Payables, Mortgages)\n" + "**Equity:** Ownership of the assets (Assets - Liabilities)\n" + "**Accounting Equation (Must Always Balance):** Assets = Liability - Equity" );
			balanceSheet.setColor(0x33b1f5);
			balanceSheet.setFooter("Created by Esha", event.getMember().getUser().getAvatarUrl()); 
			event.getChannel().sendTyping().queue(); 
			event.getChannel().sendMessage(balanceSheet.build()).queue();
			balanceSheet.clear();
		}
	}
}
			
