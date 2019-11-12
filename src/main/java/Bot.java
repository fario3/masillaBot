import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Random;

public class Bot extends ListenerAdapter {

    public static void main(String args[]) throws Exception{
        //JDA jda= new JDABuilder("NjQyMzQxMTM3MzU2Njg1MzE4.XcVhNg.ECcPSu90e0qGVztxW4k0cdHoYdI").build();
        JDABuilder jda = new JDABuilder(AccountType.BOT);
        String token = "NjQyMzQxMTM3MzU2Njg1MzE4.XcVhNg.ECcPSu90e0qGVztxW4k0cdHoYdI";
        jda.setToken(token);
        jda.addEventListeners(new Bot());
        jda.build();


    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        Guild g = event.getGuild();
        List<Member> usuarios = g.getMembers();

        System.out.println("Mensaje recibido de " + event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());

        if(event.getMessage().getContentRaw().equalsIgnoreCase("masilla")){
            event.getChannel().sendMessage(event.getAuthor().getAsMention()+" el sergio").queue();
            //event.getAuthor().openPrivateChannel().queue();
        }

        /*if(event.getMessage().getContentRaw().equalsIgnoreCase("spam")){
            event.getChannel().sendMessage("Listado de todos los masillas del discord: ");
            for(Member m : usuarios) {
                //System.out.println(m + "\n");

                event.getChannel().sendMessage(m.getUser().getAsMention() + " " + m.getUser().getName()).queue();
            }
        }*/

        /*if(event.getMessage().getContentRaw().startsWith("spamprivado")){
            int i = 0;
            while(i<5){
                i++;
                event.getChannel().sendMessage(event.getAuthor().getAsMention()+" acho " +i).queue();
            }
        }*/

        Random r = new Random();
        int low = 0;
        int high = usuarios.size();
        int result = r.nextInt(high-low) + low;
        Member usuarioRamdom = usuarios.get(result);
        if(event.getMessage().getContentRaw().equalsIgnoreCase("hijo de puta") || event.getMessage().getContentRaw().equalsIgnoreCase("hdp")){
            event.getChannel().sendMessage(usuarioRamdom.getUser().getAsMention() + " es el más hijoputa").queue();
        }

        if(event.getMessage().getContentRaw().equalsIgnoreCase("privado")){
            event.getAuthor().openPrivateChannel().queue((chanel) ->{
                chanel.sendMessage("holis guapo").queue();
            });
        }

        if(event.getMessage().getContentRaw().equalsIgnoreCase("soborno")) {
            for (int i = 0; i < 10; i++) {
                event.getChannel().sendMessage("Las mejores gorras! Tu tienda de confianza de gorras!" +
                        " compra aquí y ahora https://caphunters.es").queue();
                try {
                    Thread.sleep(900000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onUserTyping(UserTypingEvent event) {
        event.getChannel().sendMessage("Cállate " + event);
    }
}
