import bot.AppJpg;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.impl.StoreDataToDbFromJson;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws TelegramApiException, SQLException {

        StoreDataToDbFromJson.store();

        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        try {
            api.registerBot(new AppJpg());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
