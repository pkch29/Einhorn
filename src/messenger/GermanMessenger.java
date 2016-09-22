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
        messages.add("Finde das Schwert und töte Gothofiedus,");
        messages.add("töte dann Grodagrim und hole die Lanze.");
        messages.add("Jetzt suche den Schatz ...");
        messages.add("und verlasse das Verlies.");
    }

    @Override
    public void gameLost(String creatureName, String weaponNameCreature){
        messages.clear();
        if (weaponNameCreature.equals("Teeth")) {
            messages.add("laut quietschend greift "+creatureName+" Dich an...");
            messages.add("und bohrt seine großen, scharfen Zähne tief in Deinen Hals!");
            messages.add("Du taumelst... gehst ein paar Schritte rückwärts... und");
            messages.add("spürst wie Dein warmes Blut an Deinem Hals entlang läuft.");
            messages.add("Dir wird schwarz vor Augen...");
            messages.add("Du bist tot......... ");
        }
        if (weaponNameCreature.equals("Axe")){
            messages.add("plötzlich...");
            messages.add("rennt "+creatureName+" auf dich zu und schwingt seine riesige Axt.");
            messages.add("Du hüpfst zur Seite... und stolperst...");
            messages.add("die Axt erwischt Deinen Brustkorb und versenkt sich immer tiefer in Deiner Brust!");
            messages.add("Ein höllischer Schmerz erschüttert Deinen Körper!");
            messages.add("Du fällst zu Boden......... ");
        }
        if (weaponNameCreature.equals("Fire")){
            messages.add("Nun ist "+creatureName+" richtig wütend!");
            messages.add("Zornig steht er da, seine Nüstern beben...");
            messages.add("Er öffnet sein Maul und ein heißer Feuerschwall schießt in Deine Richtung.");
            messages.add("Du wurdest knusprig, schwarz gegrillt... und zerfällst zu Staub.");
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
                               String playerName, boolean hasPlayerWon, int hpPlayer, int hpCreature, int damage){
        messages.clear();
        messages.add("++++++++++++++++fight++++++++++++");
        messages.add(playerName+ " vs " +creatureName);
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
