package bot;

import enums.BotState;
import model.User;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import service.UserService;
import service.impl.UserServiceImpl;
import util.BotConstants;

public class BotService {

    public static UserService userService = new UserServiceImpl();

    public static SendMessage start(Update update) {

        registerUser(update);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(BotConstants.MENU_HEADER);

        return sendMessage;

    }

    private static void registerUser(Update update) {
        org.telegram.telegrambots.meta.api.objects.User user = update.getMessage().getFrom();
        if (!userService.existsByChatId(update.getMessage().getChatId())){
            User user1 = new User(
                    update.getMessage().getChatId(),
                    user.getFirstName(),
                    user.getLastName(), user.getUserName(),
                    update.getMessage().getContact() != null ? update.getMessage().getContact().getPhoneNumber() : "",
                    BotState.START
            );
            userService.save(user1);
        }


    }
}