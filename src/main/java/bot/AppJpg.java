package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import util.BotSettings;

import java.util.List;

public class AppJpg extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()){
            Message message = update.getMessage();
            SendMessage sendMessage = null;

            if (message.hasText()){
                String text = message.getText();
                if ("/start".equals(text)) {
                    sendMessage = BotService.start(update);
                }
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        if (update.hasMessage()){
            Message message = update.getMessage();
            SendMessage sendMessage = null;

            if (message.hasPhoto()){
                List<PhotoSize> photo = message.getPhoto();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return BotSettings.USER_NAME_BOT;
    }

    @Override
    public String getBotToken() {
        return BotSettings.TOKEN;
    }
}