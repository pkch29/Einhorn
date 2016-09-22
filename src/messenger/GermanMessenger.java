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
        messages.add("");
        messages.add("GAME OVER! - Du hast verloren!");
        messages.add("");
        messages.add("Du kannst es gleich nochmal versuchen.");
        messages.add("Du befindest Dich wieder am Eingang.");
    }

    @Override
    public void creatureDied(String creatureName, String weaponNamePlayer, int hpPlayer, int damage){
        messages.clear();
        if (weaponNamePlayer.equals("Hand")){
            messages.add("Du nimmst Deinen ganzen Mut zusammen.. schreitest zu "+creatureName);
            messages.add("und wendest die Fünf-Punkte-Pressur-Herzexplosions-Technik an.");
            messages.add(creatureName+" läuft 5 Schritte auf dich zu... und...");
            messages.add("fällt tot um!");
        }
        if (weaponNamePlayer.equals("Knife")){
            messages.add("Du rennst auf "+creatureName+" zu... gleitest flink an ihm vorbei...");
            messages.add("stehst plötzlich hinter ihm...");
            messages.add("und schneidest ihm die Kehle durch...");
            messages.add(creatureName+" röchelt... fällt hin... und stirbt...");
        }
        if (weaponNamePlayer.equals("Sword")){
            messages.add("plötzlich rennt "+creatureName+" auf Dich zu...");
            messages.add("Du holst mit Deinem Schwert aus... und...");
            messages.add("enthauptest Deinen Gegner!");
        }
        if (weaponNamePlayer.equals("Lance")){
            messages.add("Du nimmst Deine ganze Kraft zusammen... ATTACKE!");
            messages.add("Du bohrst Deine Lanze "+creatureName+" mitten ins Herz!");
            messages.add("Er schreit auf... und fällt in sich zusammen.");
        }
        messages.add("");
        messages.add("Du hast den Kampf gewonnen.");
        messages.add("Was willst Du als nächstes tun?");
    }

    @Override
    public void playerAttacked(String weaponNamePlayer, String weaponNameCreature, String creatureName,
                               String playerName, boolean hasPlayerWon, int hpPlayer, int hpCreature, int damage){
        messages.clear();
        messages.add("+++++++++++++++++++fight+++++++++++++++++");
        messages.add(playerName+ "      vs       " +creatureName);
        messages.add("");
        messages.add("weapon: "+weaponNamePlayer+"                       "+weaponNameCreature);
        if (hasPlayerWon){
            messages.add("Du hast Deinem Gegner "+damage+" Schadenspunkte zugefügt.");
        }
        if (hasPlayerWon == false){
            messages.add("Dein Gegner hat Dir "+damage+" Schadenspunkte zugefügt.");
        }
        messages.add("HP:     "+hpPlayer+"                               "+hpCreature);
        messages.add("");
        messages.add("Willst Du einen weiteren Zweikampf riskieren?");
        messages.add("Oder flüchtest Du lieber wie ein Feigling?");
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
