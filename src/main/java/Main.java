import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;
import java.util.Random;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createDefault("")
                .setActivity(Activity.watching("ta mère se faire baiser"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        bot.addEventListener(new Main());

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().contains("twitter.com")){
            String[] args = event.getMessage().getContentRaw().split("//twitter.com");
            event.getChannel().sendMessage("https://fxtwitter.com" + args[1]).queue();
            event.getMessage().delete().queue();
        }
        else if (event.getMessage().getContentRaw().contains("feur") || event.getMessage().getContentRaw().contains("Feur")){
            int a = getRandomNumberInRange(1, 2);
            if(a==1){
                int b = getRandomNumberInRange(1, 2);
                if(b==1) {
                    event.getChannel().sendMessage("T'es génant").queue();
                }
                else{
                    event.getChannel().sendMessage(cringe()).queue();
                }
            }
        }
        else if(event.getMessage().getContentRaw().toLowerCase().contains("qui ?") && !event.getAuthor().isBot() || event.getMessage().getContentRaw().toLowerCase().equals("qui") && !event.getAuthor().isBot()){
            int a = getRandomNumberInRange(1, 2);
            if(a==1){
                event.getChannel().sendMessage("J'avoue qui à demandé ?").queue();
            }
            else {
                event.getChannel().sendMessage("Tu es cringe à dire ''qui ?''").queue();
            }
        }
        else if(event.getMessage().getContentRaw().toLowerCase().contains("!ratio")){
            int a = getRandomNumberInRange(1, 2);
            if(a==1){
                event.getChannel().sendMessage("Nan ta gueule").queue();
            }
            else {
                String[] args = event.getMessage().getContentRaw().split(" ");
                event.getChannel().sendMessage(event.getMessage().getAuthor() + "ratio" + args[1] + ratio()).queue();
                event.getMessage().delete().queue();
            }
        }
    }

    public String ratio(){
        String res;
        ArrayList<String> ratio = new ArrayList<>();
        ratio.add("la salope");
        ratio.add("la petite pute");
        ratio.add("la merde");
        ratio.add("le sous humain");
        return ratio.get(getRandomNumberInRange(0,3));
    }

    public String cringe(){
        ArrayList<String> gif = new ArrayList<>();
        gif.add("https://tenor.com/view/dies-of-cringe-cringe-gif-20747133");
        gif.add("https://tenor.com/view/cringe-youre-cringe-dies-of-cringe-cringe-af-gif-25319855");
        gif.add("https://tenor.com/view/cringe-gif-23594630");
        gif.add("https://i1.sndcdn.com/artworks-lFHmV922CalFXzTx-1BzOMg-t500x500.jpg");
        gif.add("https://ih1.redbubble.net/image.713481123.5957/flat,800x800,075,f.u2.jpg");
        return gif.get(getRandomNumberInRange(0,4));
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
