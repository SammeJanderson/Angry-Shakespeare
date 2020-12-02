import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        try{
            TelegramBotsApi telegramBotsApi =  new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new AngryShakespeare());


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}
