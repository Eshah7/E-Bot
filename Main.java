package esha.ebot;


import javax.security.auth.login.LoginException;

import esha.ebot.c2c.AccountingTips;
import esha.ebot.c2c.BalanceSheet;
import esha.ebot.c2c.Inventory;
import esha.ebot.commands.BedWars;
import esha.ebot.commands.Clear;
import esha.ebot.commands.Help;
import esha.ebot.commands.Info;
import esha.ebot.commands.TownOfSalem;
import esha.ebot.commands.YesOrNo;
import esha.ebot.events.GuildMessageReceived;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	
	public static JDA jda; 
	public static String prefix = "~";

	// Main method
	public static void main(String[] args) throws LoginException {
		// TODO Auto-generated method stub
		
		 
		// Set up 
		 JDABuilder builder = new JDABuilder(); 
		 builder.setToken("NzE0NTUyNDY5OTQxNjQ5NDk5.XuleAg.Lh07Fi2HrHc2EIIU5Qwp_XE5kSI");
		 builder.setStatus(OnlineStatus.ONLINE);
		 builder.setActivity(Activity.listening("~help"));
		
		 // Commands
		 builder.addEventListeners(new Info());
		 builder.addEventListeners(new Clear()); 
		 builder.addEventListeners(new BedWars());
		 builder.addEventListeners(new Help()); 
		 builder.addEventListeners(new TownOfSalem());
		 builder.addEventListeners(new YesOrNo()); 

		 // Events
		// builder.addEventListeners(new GuildMessageReceived());
		 
		 // Coast2Coast Designs Commands
		 builder.addEventListeners(new BalanceSheet()); 
		 builder.addEventListeners(new Inventory());
		 builder.addEventListeners(new AccountingTips());
		 
		 builder.build(); 
		 
		 
	}

}
