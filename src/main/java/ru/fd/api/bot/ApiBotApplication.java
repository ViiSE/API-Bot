package ru.fd.api.bot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.file.SettingsFileStringImpl;

import java.io.File;

public class ApiBotApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(APIBotConfiguration.class);

		Greetings greetings = ctx.getBean("greetingsWithTimeout", Greetings.class);
		greetings.hello();

		SettingsFile<String> settingsFile;
		if(args.length != 0)
			settingsFile = (SettingsFileStringImpl) ctx.getBean("settingsFileString", args[0]);
		else
			settingsFile = (SettingsFileStringImpl) ctx.getBean("settingsFileString", System.getProperty("user.dir") + File.separator + "settings.json");

		ApplicationRunner<String> appRunner = (ApplicationRunnerDefaultImpl) ctx.getBean("applicationRunnerDefault", ApplicationRunner.class);
		appRunner.run(settingsFile);
	}

}
