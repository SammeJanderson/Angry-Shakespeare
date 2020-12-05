import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.ChosenInlineResult;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineQueryResult;
import com.pengrad.telegrambot.model.request.InlineQueryResultArticle;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

import java.util.Random;

public class AngryShakespeare {
    public static void main(String[] args) {
        TelegramBot angryShakespeare = new TelegramBot("1436883352:AAHHXW6byZTbgVWIoAM7KJCt16v-NQQu1CU");


        angryShakespeare.setUpdatesListener(updates -> {
            for (Update update : updates) {

                Random random = new Random();

                InlineQuery inlineQuery = update.inlineQuery();
                ChosenInlineResult chosenInlineResult = update.chosenInlineResult();
                CallbackQuery callbackQuery = update.callbackQuery();



                if (inlineQuery != null&&update.message()==null) {
                    String insultado = inlineQuery.query();
                    System.out.println(insultado);


                    boolean insultoProibido = inlineQuery.query().matches("(samme)|(..mm.)|(summer)");
                    System.out.println(insultoProibido);


                    if (insultoProibido) {

                        InlineQueryResult inlineQuerySamme = new InlineQueryResultArticle("id5", "Samme quando nasceu teu ...",
                                inlineQuery.from().firstName() +" tentou insultar o Samme.\n"+inlineQuery.from().firstName()+" é um(a) covarde infiel! Um(a) patife desonesto!\nFanfarrão(ona) vil e maldito(a) furioso(a)!"
                                ).thumbUrl("https://i.imgur.com/5sTio5x.jpg");

                        BaseResponse response = angryShakespeare.execute(new AnswerInlineQuery(inlineQuery.id(), inlineQuerySamme).cacheTime(0));

                    } else {


                        String insulto = "";
                        String insulto2 = "";
                        String insulto3 = "";


                        insulto = String.format(InsultFactory.insults[random.nextInt(InsultFactory.insults.length)], inlineQuery.query());
                        insulto2 = String.format(InsultFactory.insults[random.nextInt(InsultFactory.insults.length)], inlineQuery.query());
                        insulto3 = String.format(InsultFactory.insults[random.nextInt(InsultFactory.insults.length)], inlineQuery.query());


                        InlineQueryResult inlineQueryResult = new InlineQueryResultArticle("id01", insulto, insulto).thumbUrl("https://i.imgur.com/5sTio5x.jpg");

                        InlineQueryResult inlineQueryResult2 = new InlineQueryResultArticle("id02", insulto2, insulto2).thumbUrl("https://i.imgur.com/5sTio5x.jpg");

                        InlineQueryResult inlineQueryResult3 = new InlineQueryResultArticle("id03", insulto3, insulto3).thumbUrl("https://i.imgur.com/5sTio5x.jpg");

                        BaseResponse response = angryShakespeare.execute(new AnswerInlineQuery(inlineQuery.id(), inlineQueryResult, inlineQueryResult2, inlineQueryResult3).cacheTime(0));
                    }
                }


            }


            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }

}
