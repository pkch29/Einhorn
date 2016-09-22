package messenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates Messages to be displayed by the GUI
 */
public class GermanMessenger implements Messenger {


    private List<String> messages = new ArrayList<>();

    @Override
    public void playerWon() {
        messages.clear();
        messages.add("Gratulation! - Du hast gewonnen!");
        messages.add("");
        messages.add("Du kannst es gleich nochmal versuchen.");
        messages.add("Du befindest Dich wieder am Eingang - aber ohne Schatz.");
    }

    @Override
    public void help(){
        messages.clear();
        messages.add("Finde das Schwert und töte Gothofiedus,\ntöte dann Grodagrim und hole die Lanze.\n"
                + "Jetzt suche den Schatz ...\nund verlasse das Verlies.");
    }

    @Override
    public void gameLost(String creatureName, String weaponNameCreature){
        messages.clear();
        if (weaponNameCreature == "Teeth") {
            messages.add("laut quietschend greift "+creatureName+" Dich an...\n" +
                    "und bohrt seine großen, scharfen Zähne tief in Deinen Hals!\n" +
                    "Du taumelst... gehst ein paar Schritte rückwärts... und\n"+
                    "spürst wie Dein warmes Blut an Deinem Hals entlang läuft.\n"+
                    "Dir wird schwarz vor Augen...\n" +
                    "Du bist tot......... ");
        }
        if (weaponNameCreature == "Axe"){
            messages.add("plötzlich... \n" +
                    "rennt "+creatureName+" auf dich zu und schwingt seine riesige Axt.\n" +
                    "Du hüpfst zur Seite... und stolperst...\n" +
                    "die Axt erwischt Deinen Brustkorb und versenkt sich immer tiefer in Deiner Brust!\n" +
                    "Ein höllischer Schmerz erschüttert Deinen Körper!\n" +
                    "Du fällst zu Boden......... ");
        }
        if (weaponNameCreature == "Fire"){
            messages.add("Nun ist "+creatureName+" richtig wütend!\n" +
                    "Zornig steht er da, seine Nüstern beben...\n" +
                    "Er öffnet sein Maul und ein heißer Feuerschwall schießt in Deine Richtung.\n" +
                    "Du wurdest knusprig, schwarz gegrillt... und zerfällst zu Staub.");
        }
        messages.add("GAME OVER! - Du hast verloren!");
        messages.add("");
        messages.add("Du kannst es gleich nochmal versuchen.");
        messages.add("Du befindest Dich wieder am Eingang.");
    }

    @Override
    public void creatureDied(String creatureName, String weaponNamePlayer, int hpPlayer, int damage){
        messages.clear();
        messages.add("das monster ist tot!");
    }

    @Override
    public void playerAttacked(String weaponNamePlayer, String weaponNameCreature, String creatureName,
                               boolean hasPlayerWon, int hpPlayer, int hpCreature, int damage){
        messages.clear();
        messages.add("player vs monster");
    }

    @Override
    public void roomHasCreature(String name, String description, String species, String weaponName){
        messages.clear();
        messages.add("");
    }

    @Override
    public void roomHasWeapon(String name, String description, int force){
        messages.clear();
        messages.add("");
    }

    @Override
    public void roomHasTreasure(String name, String description){
        messages.clear();
        messages.add("");
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }
}
