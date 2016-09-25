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
        messages.add("**GRATULATION! - Du hast gewonnen!**");
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
        if (weaponNameCreature.equals("Sword")){
            messages.add("plötzlich...");
            messages.add("rennt "+creatureName+" auf dich zu und schwingt sein riesiges Schwert.");
            messages.add("Du hüpfst zur Seite... und stolperst...");
            messages.add("das Schwert trifft Deinen Brustkorb und versenkt sich immer tiefer in Deiner Brust!");
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
    }

    @Override
    public void playerAttacked(String weaponNamePlayer, String weaponNameCreature, String creatureName,
                               String playerName, boolean hasPlayerWon, int hpPlayer, int hpCreature, int damage){
        messages.clear();
        messages.add("++++++++++++++fight++++++++++++");
        messages.add(playerName+ "      vs       " +creatureName);
        messages.add("");
        messages.add("Waffe: "+weaponNamePlayer+"                       "+weaponNameCreature);
        if (hasPlayerWon){
            messages.add("Du hast Deinem Gegner "+damage+" Schadenspunkte zugefügt.");
        }
        if (hasPlayerWon == false){
            messages.add("Dein Gegner hat Dir "+damage+" Schadenspunkte zugefügt.");
        }
        messages.add("HP:         "+hpPlayer+"                               "+hpCreature);
        messages.add("");
        messages.add("Willst Du einen weiteren Zweikampf riskieren?");
        messages.add("Oder flüchtest Du lieber wie ein Feigling?");
    }

    @Override
    public void roomHasCreature(String name, String description, String species, String weaponName){
        messages.clear();
        messages.add("Boahhhh! Muuuarrrrr!");
        messages.add("Vor Dir steht "+description);
        messages.add("");
        messages.add("***Monster***");
        messages.add("Name: "+name);
        messages.add("Gestalt: "+species);
        messages.add("Waffe: "+weaponName);
        messages.add("");
        messages.add("Willst Du den Kampf mit ihm aufnehmen?");
    }

    @Override
    public void roomHasWeapon(String name, String description){
        messages.clear();
        messages.add("Du betrittst den Raum und siehst Dich um...");
        messages.add("in der hinteren Ecke siehst Du was aufblitzen...");
        messages.add("Du trittst näher heran...");
        if (name.equals("Knife")){
            messages.add("und siehst, dass ein "+description+" auf dem Boden liegt.");
        }
        if (name.equals("Lance")){
            messages.add("und siehst eine "+description);
        }
        if (name.equals("Sword")){
        messages.add("und siehst ein "+description);}
        messages.add("");
        messages.add("Willst Du es mitnehmen?");
    }

    @Override
    public void roomHasTreasure(String name, String description){
        messages.clear();
        messages.add("Du gelangst in eine schummrige Kammer...");
        messages.add("in der Mitte des Raumes zeichnet sich ein dunkler Schatten auf dem Boden ab.");
        messages.add("Du erkundest vorsichtig die Umgebung... und entdeckst...");
        messages.add("eine Holztruhe!");
        messages.add("");
        messages.add("Das muss "+description+" sein!");
        messages.add("");
        messages.add("Willst Du ihn mitnehmen?");
    }

    @Override
    public void treasureIsTaken(String name, String description, int amount){
        messages.add("*****"+description+"*****");
        messages.add("Inhalt: "+amount+" Goldstücke!");

    }

    @Override
    public void weaponIsTaken(String name, String description, int force){
        messages.add("***** Neues Item *****");
        messages.add(description);
        messages.add("Schlagkraft: "+force);

    }

    @Override
    public void roomIsEmpty() {
        messages.clear();
        messages.add("Hier gibt's nichts... nur Staub.");
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }
}
