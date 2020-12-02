import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;

public class AngryShakespeare extends TelegramLongPollingBot {
    Random random =  new Random();

    String[] insults = {"“Você não vale mais nada, mais eu te chamaria Valete.”",
            "“Eu desejo-nos posso ser melhores desconhecido.”",
            "“Ele é deformado, torto, idade e sere, \n" +
                    " Cara deformada, corpo feio, sem forma em todos os lugares; \n" +
                    " Vicioso, ungentle, tolo, sem corte, grosseiro; \n" +
                    " Estigmatico na tomada, pior em mente “.",
            "“Tu filho da puta, vilão sem sentido!”",
            "“Você habilidades são muito infantil, como para fazer muito sozinho.”",
            "“Eles mentem mortal que lhe dizer que você tem bons rostos.”",
            "“Mais de sua conversa poderia infectar meu cérebro.”",
            "“Para coisas como você, eu posso escassos acha que há alguma, ye’re tão leve.”",
            "“A acidez do rosto azeda uvas maduras.”",
            "“Pra longe! Tu és veneno para o meu sangue “.",
            "“Eles têm uma abundante falta de inteligência.”",
            "“Aqui, tu incestuosa, assassino, condenado Dane, \n" +
                    " Beba fora desta poção!",
            "“Este covarde otimista, este preguiçoso, este picador, esta colina enorme de carne!”",
            "“Longe, você corta-bolsa patife! você bung sujo, embora! Por este vinho, eu vou empurrar minha faca em suas rachaduras mofados, um você joga o chocos atrevido comigo. Longe, você bebado patife! Seu cesto de punho obsoleto malabarista!”",
            "“O fanfarrão vil e maldito furioso!",
            "Ele é pusilânime e com o rosto vermelho.",
            "“Leve-a para longe; porque ela tem vivido muito tempo,\n" +
                    " Para encher o mundo com qualidades viciosas.”",
            "“Dentes tivesses tu na tua cabeça quando nasceste,\n Para significar teres vindo a morder o mundo.”",
            "“Você blocos, você pedras, você pior do que coisas sem sentido!”",
            "“O que você besta!\n Eu vou tão maul você e sua brindar-ferro,\n Que você deve pensar o diabo do inferno.”",
            "“Você é um tolo tedioso.”",
            "“O covarde infiel! O patife desonesto!\n Queres ficar são um homem fora do meu vício?”",
            "Tu és um mictório rei castelhano!”",
            "“O céu sabe muito bem que és falsa como o inferno.”",
            "“Fora da minha vista! fazes infectar meus olhos.”",
            "“Você camponês pretendente! Você filho da puta burro de carga de cavalo malte!”",
            "“Por que, tu peixe desossado tu … Irá tu dizer uma mentira monstruosa, sendo apenas metade de um peixe e metade de um monstro?”",
            "“Tu! filho de puta-lobo!”",
            "“Tu encharcado de raciocínio senhor! tu não tens mais cérebro do que eu tenho em meus cotovelos.”",
            "“Vá pendurar-se, você impertinente zombeteiro!”",
            "“Eu vou cortar sua língua.”\n" +
                    " “Mas isso não importará, vou falar como muito sagacidade como tu depois.”"

    };

    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getText());
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();

        switch (command) {
            case "/insult":
                System.out.println(insults[random.nextInt(Integer.parseInt(String.valueOf(insults.length)))]);
                message.setText(insults[random.nextInt(Integer.parseInt(String.valueOf(insults.length)))]);

                break;
        }

        message.setChatId(String.valueOf(update.getMessage().getChatId()));

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}

