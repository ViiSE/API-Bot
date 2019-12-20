package ru.fd.api.bot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.file.SettingsFileStringImpl;
import ru.fd.api.bot.producer.GreetingsProducer;

import java.io.File;

public class ApiBotApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(APIBotConfiguration.class);

		GreetingsProducer gP = ctx.getBean(GreetingsProducer.class);
		gP.getGreetingsWithTimeoutInstance(gP.getGreetingsWithBannerInstance(ctx.getBean(BannerPath.class))).hello();

		SettingsFile<String> settingsFile;
		if(args.length != 0)
			settingsFile = (SettingsFileStringImpl) ctx.getBean("settingsFileString", args[0]);
		else
			settingsFile = (SettingsFileStringImpl) ctx.getBean("settingsFileString", System.getProperty("user.dir") + File.separator + "settings.json");

		ApplicationRunner appRunner = (ApplicationRunner) ctx.getBean("applicationRunnerDefault", settingsFile);
		appRunner.run();
	}

}
